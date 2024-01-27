package com.rodemark;

import com.rodemark.base_entity.Cell;
import com.rodemark.base_entity.Entity;

import java.util.HashMap;

public class Map {
    private final int width = 10;
    private final int height = 10;
    private final HashMap<Cell, Entity> entities;

    public Map(HashMap<Cell, Entity> entities) {
        this.entities = entities;
    }

    public void addEntity(Entity entity){
        entities.put(entity.getPosition(), entity);
    }

    public void removeEntity(Entity entity){
        entities.remove(entity.getPosition());
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
