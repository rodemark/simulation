package com.rodemark.entities.field;

import com.rodemark.base_entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorldMap {
    private final int width = 10;
    private final int height = 10;
    private final HashMap<Cell, Entity> entities;

    public WorldMap(HashMap<Cell, Entity> entities) {
        this.entities = entities;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public HashMap<Cell, Entity> getEntities() {
        return entities;
    }

    public void addEntity(Entity entity){
        entities.put(entity.getPosition(), entity);
    }

    public void removeEntity(Entity entity){
        entities.remove(entity.getPosition());
    }

    public Entity getEntityFromCell(Cell cell){
        return entities.get(cell);
    }

    public Class<? extends Entity> getTypeCell(Cell cell) {
        return entities.get(cell) != null ? entities.get(cell).getClass() : null;
    }

    public List<Cell> getNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<>();
        int x = cell.x();
        int y = cell.y();

        // Consider only up, down, left, and right neighbors
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            Cell neighbor = new Cell(newX, newY);

            if (this.getEntities().containsKey(neighbor)) {
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }


    public void printMap() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Cell currentCell = new Cell(x, y);
                Entity entity = entities.get(currentCell);

                if (entity != null) {
                    System.out.print(entity.getSymbol() + " ");
                } else {
                    // Print an empty space if no entity is present
                    System.out.print("\uD83D\uDFEB" + " ");
                }
            }
            System.out.println(); // Move to the next line for the next row
        }
    }

}
