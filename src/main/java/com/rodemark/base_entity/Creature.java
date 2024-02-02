package com.rodemark.base_entity;

import com.rodemark.actions.PathFinder;
import com.rodemark.entities.field.Cell;
import com.rodemark.entities.field.WorldMap;
import com.rodemark.entities.stationary.Carrot;

import java.util.List;

public abstract class Creature extends Entity {
    protected int speed;

    public int getSpeed() {
        return speed;
    }

    public Creature(Cell position) {
        super(position);
    }

    public void makeMove(WorldMap worldMap, Class <? extends Entity> targetType) {
        Entity nearestEntity = PathFinder.findNearestEntity(worldMap, this, targetType);
        PathFinder pathFinder = new PathFinder();
        if (nearestEntity != null) {
            List<Cell> path = pathFinder.findPath(worldMap, this, nearestEntity);

            if (!path.isEmpty() && path.size() > 1) {
                consume(worldMap, nearestEntity, path);

            } else {
//                System.out.println("Error. Path is empty. Creature.class : makeMove");
            }
        }
        else {
//            System.out.println("Error. The required entity is missing. Creature.class : makeMove");
        }
    }

    private void consume(WorldMap worldMap, Entity nearestEntity, List<Cell> path){
        Cell nextPosition = path.get(1);

        if (nextPosition.x() == nearestEntity.getPosition().x() && nextPosition.y() == nearestEntity.getPosition().y()){
            if (this instanceof Predator & nearestEntity instanceof Herbivore){
                Herbivore herbivore = (Herbivore) nearestEntity;
                Predator predator = (Predator) this;

                int power = predator.power;
                int health = herbivore.health;

                health = health - power;
                herbivore.health = health;

                if (health <= 0){
                    worldMap.removeEntity(nearestEntity);
                    worldMap.removeEntity(this);

                    this.setPosition(nextPosition);
                    ((Predator) this).power = power + 1;
                    worldMap.addEntity(this);

                }
            }

            if (this instanceof Herbivore){
                worldMap.removeEntity(nearestEntity);
                worldMap.removeEntity(this);

                this.setPosition(nextPosition);
                ((Herbivore) this).health += 5;
                worldMap.addEntity(this);
            }
        }
        else{
            worldMap.removeEntity(this);
            this.setPosition(nextPosition);
            worldMap.addEntity(this);
        }
    }

}
