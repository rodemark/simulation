package com.rodemark.actions;

import com.rodemark.base_entity.*;
import com.rodemark.entities.field.Cell;
import com.rodemark.entities.field.WorldMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Action {
    private final Random random = new Random();
    private final WorldMap worldMap;

    public Action(WorldMap worldMap ) {
        this.worldMap = worldMap;
    }

    public void spawning(Class<? extends Entity> targetType) {
        float chanceSpawn;

        int rnd1 = random.nextInt(10);
        int rnd2 = random.nextInt(15);
        int rnd3 = random.nextInt(15);

        if (targetType.isInstance(Predator.class)){
            chanceSpawn = 0.01f * rnd1;
        }
        else{
            if (targetType.isInstance(Herbivore.class)){
                chanceSpawn = 0.01f * rnd2;
            }
            else{
                chanceSpawn = 0.01f * rnd3;
            }
        }

        int amountEntities = (int) (worldMap.getMapSize() * chanceSpawn);

        int x;
        int y;
        for (int i = 0; i < amountEntities; i++) {

            x = random.nextInt(worldMap.getWidth());
            y = random.nextInt(worldMap.getHeight());

            while (worldMap.getEntities().containsKey(new Cell(x, y))){
                x = random.nextInt(worldMap.getWidth());
                y = random.nextInt(worldMap.getHeight());
            }
            try {
                Entity entity = targetType.getDeclaredConstructor(Cell.class)
                        .newInstance(new Cell(x, y));

                worldMap.addEntity(entity);
            } catch (Exception err) {
                System.out.println(err);
            }
        }
    }

    /**
     * @param typeOfMoving : Who's moving? - all (predators and herbivores), predators, herbivores.
     */
    public void moving(String typeOfMoving) {
        HashMap<Cell, Entity> entities = new HashMap<>(worldMap.getEntities());

        for (Map.Entry<Cell, Entity> entry : entities.entrySet()) {
            Entity entity = entry.getValue();

            Creature creature = null;
            if (entity instanceof Creature){
                creature = (Creature) entity;
            }
            else continue;

            if (typeOfMoving.equals("all")) {
                if (creature instanceof Predator) {
                    creature.makeMove(worldMap, Herbivore.class);
                }
                if (creature instanceof Herbivore) {
                    creature.makeMove(worldMap, Vegetation.class);
                }
            }

            if (typeOfMoving.equals("predators")) {
                if (creature instanceof Predator) {
                    creature.makeMove(worldMap, Herbivore.class);
                }
            }

            if (typeOfMoving.equals("herbivores")) {
                if (creature instanceof Herbivore) {
                    creature.makeMove(worldMap, Vegetation.class);
                }
            }
        }
    }
}
