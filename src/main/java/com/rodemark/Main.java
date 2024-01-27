package com.rodemark;

import com.rodemark.entities.field.Cell;
import com.rodemark.base_entity.Entity;
import com.rodemark.entities.field.WorldMap;
import com.rodemark.entities.mobile.Fox;
import com.rodemark.entities.mobile.Rabbit;
import com.rodemark.entities.stationary.Grass;
import com.rodemark.entities.stationary.Rock;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Fox fox1 = new Fox(new Cell(0,0));
        Rabbit rabbit1 = new Rabbit(new Cell(0, 2));

        Rock rock1= new Rock(new Cell(1,0));
        Grass grass1 = new Grass(new Cell(2, 2));
        HashMap<Cell, Entity> entityHashMap = new HashMap<>();
        WorldMap worldMap = new WorldMap(entityHashMap);
        worldMap.addEntity(fox1);
        worldMap.addEntity(rabbit1);
        worldMap.addEntity(rock1);
        worldMap.addEntity(grass1);

        worldMap.printMap();
        fox1.makeMove(worldMap, Rabbit.class);
        fox1.makeMove(worldMap, Rabbit.class);
        fox1.makeMove(worldMap, Rabbit.class);

    }
}