package com.rodemark;

import com.rodemark.base_entity.Creature;
import com.rodemark.base_entity.Entity;
import com.rodemark.entities.field.Cell;
import com.rodemark.entities.field.WorldMap;
import com.rodemark.entities.mobile.Fox;
import com.rodemark.entities.mobile.Rabbit;

import java.util.HashMap;

public class Move {
    public void moving(WorldMap worldMap){
        HashMap<Cell, Entity> entities = worldMap.getEntities();
        // TODO использовать Iterator
        for (Entity entity : entities.values()) {
            if (entity instanceof Fox){
                Creature creature = (Creature) entity;
                creature.makeMove(worldMap, Rabbit.class);
            }
            // Ваш код для обработки каждой сущности
            // Например, вы можете вызвать метод или проверить тип сущности и выполнить соответствующие действия
            System.out.println(entity.getClass().getSimpleName()+ ": " + entity.getPosition());
        }
    }
}
