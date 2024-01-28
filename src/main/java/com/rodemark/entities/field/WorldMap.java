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

    public static final String ANSI_BG_BROWN = "\u001B[43m";
    public void printMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell currentCell = new Cell(x, y);
                Entity entity = entities.get(currentCell);

                if (entity != null) {
                    System.out.print(ANSI_BG_BROWN + entity.getSymbol() + " ");
                } else {
                    // Print an empty space if no entity is present
                    System.out.print(ANSI_BG_BROWN + "   ");
                }
            }
            System.out.println(); // Move to the next line for the next row
        }
    }



}
