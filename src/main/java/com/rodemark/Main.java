package com.rodemark;

import com.rodemark.entities.field.Cell;
import com.rodemark.base_entity.Entity;
import com.rodemark.entities.field.WorldMap;
import com.rodemark.entities.mobile.Fox;
import com.rodemark.entities.mobile.Rabbit;
import com.rodemark.entities.stationary.Carrot;
import com.rodemark.entities.stationary.Rock;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Fox fox1 = new Fox(new Cell(0,0), 10, 10);
        Rabbit rabbit1 = new Rabbit(new Cell(4, 4), 5, 1);

        Rock rock1= new Rock(new Cell(1,0));
        Rock rock2= new Rock(new Cell(0,1));
        Rock rock3= new Rock(new Cell(1,1));

        Carrot carrot1 = new Carrot(new Cell(2, 2));
        HashMap<Cell, Entity> entityHashMap = new HashMap<>();
        WorldMap worldMap = new WorldMap(entityHashMap);
        worldMap.addEntity(fox1);
        worldMap.addEntity(rabbit1);
        worldMap.addEntity(rock1);
//        worldMap.addEntity(rock2);
        worldMap.addEntity(rock3);
        worldMap.addEntity(carrot1);


        worldMap.printMap();
//        fox1.makeMove(worldMap, Rabbit.class);
//        fox1.makeMove(worldMap, Rabbit.class);
//        fox1.makeMove(worldMap, Rabbit.class);

        rabbit1.makeMove(worldMap, Carrot.class);

        while (worldMap.getEntities().get(rabbit1.getPosition()) instanceof Rabbit){
            rabbit1.makeMove(worldMap, Carrot.class);
            fox1.makeMove(worldMap, Rabbit.class);
        }

    }
}