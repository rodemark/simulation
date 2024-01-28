package com.rodemark;

import com.rodemark.base_entity.Entity;
import com.rodemark.entities.field.Cell;
import com.rodemark.entities.field.WorldMap;

import java.util.*;

public class PathFinder {

    // BFS
    public static List<Cell> findPath(WorldMap worldMap, Entity startEntity, Entity endEntity) {
        if (startEntity == null || endEntity == null) {
            throw new IllegalArgumentException("Start and target entities must not be null.");
        }

        Cell startCell = startEntity.getPosition();
        Cell endCell = endEntity.getPosition();

        if (startCell == null || endCell == null) {
            throw new IllegalArgumentException("Start and target positions must not be null.");
        }

        if (!worldMap.getEntities().containsKey(startCell) || !worldMap.getEntities().containsKey(endCell)) {
            throw new IllegalArgumentException("Start and target entities must be on the map.");
        }

        Queue<Cell> queue = new LinkedList<>();
        HashMap<Cell, Cell> parentMap = new HashMap<>();
        Set<Cell> visited = new HashSet<>();

        queue.add(startCell);
        visited.add(startCell);

        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();

            if (currentCell.x() == endCell.x() && currentCell.y() == endCell.y()) {
                List<Cell> path = new ArrayList<>();
                Cell cell = endCell;

                while (cell != null) {
                    path.add(cell);
                    cell = parentMap.get(cell);
                }

                Collections.reverse(path);
                return path;
            }

            List<Cell> neighbors = getValidNeighbors(worldMap, currentCell, visited, endEntity.getClass());
            for (Cell neighbor : neighbors) {
                queue.add(neighbor);
                visited.add(neighbor);
                parentMap.put(neighbor, currentCell);
            }
        }

        // No path found
        return Collections.emptyList();
    }

    private static List<Cell> getValidNeighbors(WorldMap worldMap, Cell cell, Set<Cell> visited, Class<? extends Entity> targetType) {
        List<Cell> neighbors = new ArrayList<>();
        int x = cell.x();
        int y = cell.y();

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX >= 0 && newX < worldMap.getWidth() && newY >= 0 && newY < worldMap.getHeight()) {
                Cell neighbor = new Cell(newX, newY);
                // если там нет никаких сущностей или там есть тот за кем охотимся
                if ((!worldMap.getEntities().containsKey(neighbor) || targetType.isInstance(worldMap.getEntities().get(neighbor))) && !visited.contains(neighbor)) {
                    neighbors.add(neighbor);
                }
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

