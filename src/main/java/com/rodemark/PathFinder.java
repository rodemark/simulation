package com.rodemark;

import com.rodemark.base_entity.Entity;
import com.rodemark.entities.field.Cell;
import com.rodemark.entities.field.WorldMap;

import java.util.*;

public class PathFinder {
    public static List<Cell> findPath(WorldMap worldMap, Entity startEntity, Entity targetEntity) {
        // Validate start and target entities
        if (startEntity == null || targetEntity == null) {
            throw new IllegalArgumentException("Start and target entities must not be null.");
        }

        // Validate start and target positions
        Cell startCell = startEntity.getPosition();
        Cell targetCell = targetEntity.getPosition();
        if (startCell == null || targetCell == null) {
            throw new IllegalArgumentException("Start and target positions must not be null.");
        }

        // Validate start and target entities are on the map
        if (!worldMap.getEntities().containsKey(startCell) || !worldMap.getEntities().containsKey(targetCell)) {
            throw new IllegalArgumentException("Start and target entities must be on the map.");
        }

        // Perform BFS to find the path
        Queue<Cell> queue = new LinkedList<>();
        HashMap<Cell, Cell> parentMap = new HashMap<>();
        Set<Cell> visited = new HashSet<>();

        queue.add(startCell);
        visited.add(startCell);

        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();

            if (currentCell.equals(targetCell)) {
                // Reconstruct the path
                List<Cell> path = new ArrayList<>();
                Cell cell = targetCell;

                while (cell != null) {
                    path.add(cell);
                    cell = parentMap.get(cell);
                }

                Collections.reverse(path);
                return path;
            }

            List<Cell> neighbors = getValidNeighbors(worldMap, currentCell, visited);
            for (Cell neighbor : neighbors) {
                queue.add(neighbor);
                visited.add(neighbor);
                parentMap.put(neighbor, currentCell);
            }
        }

        // No path found
        return Collections.emptyList();
    }

    private static List<Cell> getValidNeighbors(WorldMap worldMap, Cell cell, Set<Cell> visited) {
        List<Cell> neighbors = new ArrayList<>();
        int x = cell.x();
        int y = cell.y();

        // Consider only up, down, left, and right neighbors
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            Cell neighbor = new Cell(newX, newY);

            if (worldMap.getEntities().containsKey(neighbor) && !visited.contains(neighbor)) {
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }

    public static Entity findNearestEntity(WorldMap worldMap, Entity sourceEntity, Class<? extends Entity> targetType) {
        Entity nearestEntity = null;
        double minDistance = Double.MAX_VALUE;

        for (Entity entity : worldMap.getEntities().values()) {
            if (targetType.isInstance(entity)) {
                double distance = calculateDistance(sourceEntity.getPosition(), entity.getPosition());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestEntity = entity;
                }
            }
        }

        return nearestEntity;
    }

    private static double calculateDistance(Cell position1, Cell position2) {
        int dx = position1.x() - position2.x();
        int dy = position1.y() - position2.y();
        return Math.sqrt(dx * dx + dy * dy);
    }

}
