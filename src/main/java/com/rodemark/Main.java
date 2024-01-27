package com.rodemark;

import com.rodemark.base_entity.Cell;
import com.rodemark.base_entity.Entity;
import com.rodemark.entities.mobile.Fox;
import com.rodemark.entities.mobile.Rabbit;
import com.rodemark.entities.stationary.Rock;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Fox fox1 = new Fox(new Cell(0,0));
        Rabbit rabbit1 = new Rabbit(new Cell(1, 1));

        Rock rock1= new Rock(new Cell(1,0));

        HashMap<Cell, Entity> entityHashMap = new HashMap<>();
        Map map = new Map(entityHashMap);
        map.addEntity(fox1);
        map.addEntity(rabbit1);
        map.addEntity(rock1);

        map.printMap();
    }
}