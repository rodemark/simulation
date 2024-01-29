package com.rodemark;

import com.rodemark.entities.field.Cell;
import com.rodemark.base_entity.Entity;
import com.rodemark.entities.field.WorldMap;
import com.rodemark.entities.mobile.Fox;
import com.rodemark.entities.mobile.Rabbit;
import com.rodemark.entities.stationary.Carrot;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        WorldMap worldMap = getWorldMap();

        worldMap.printMap();

        Move move = new Move();
        move.moving(worldMap);

        worldMap.printMap();
//        fox1.makeMove(worldMap, Rabbit.class);
//        fox1.makeMove(worldMap, Rabbit.class);
//        fox1.makeMove(worldMap, Rabbit.class);
//
//        rabbit1.makeMove(worldMap, Carrot.class);
//        rabbit1.makeMove(worldMap, Carrot.class);
//        rabbit1.makeMove(worldMap, Carrot.class);
//
//        while (worldMap.getEntities().get(rabbit1.getPosition()) instanceof Rabbit){
//            rabbit1.makeMove(worldMap, Carrot.class);
//            fox1.makeMove(worldMap, Rabbit.class);
//        }

    }

    private static WorldMap getWorldMap() {
        HashMap<Cell, Entity> entityHashMap = new HashMap<>();
        WorldMap worldMap = new WorldMap(entityHashMap);

        Spawn spawnFox = new Spawn(Fox.class);
        spawnFox.spawning(worldMap);

        Spawn spawnRabbit = new Spawn(Rabbit.class);
        spawnRabbit.spawning(worldMap);

        Spawn spawnCarrot = new Spawn(Carrot.class);
        spawnCarrot.spawning(worldMap);
        return worldMap;
    }
}