package com.rodemark.base_entity;

import com.rodemark.PathFinder;
import com.rodemark.entities.field.Cell;
import com.rodemark.entities.field.WorldMap;

import java.util.List;

public abstract class Creature extends Entity {
    protected int health;
    protected int speed;

    public Creature(Cell position) {
        super(position);
    }

    public void makeMove(WorldMap worldMap, Class<? extends Entity> targetType) {
        Entity nearestEntity = PathFinder.findNearestEntity(worldMap, this, targetType);

        if (nearestEntity != null) {
            List<Cell> path = PathFinder.findPath(worldMap, this, nearestEntity);

            if (!path.isEmpty() && path.size() > 1) {
                Cell nextPosition = path.get(1);

                worldMap.removeEntity(this);
                this.setPosition(nextPosition);
                worldMap.addEntity(this);

                System.out.println("Creature moved to: " + nextPosition);
                worldMap.printMap();
                System.out.println();
            } else {
                System.out.println("Error. Path is empty. Creature.class.makeMove");
            }
        }
        else {
            System.out.println("Error. The required entity is missing. Creature.class.makeMove");
        }
    }

}
