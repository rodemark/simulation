package com.rodemark;

import com.rodemark.base_entity.Entity;
import com.rodemark.entities.field.Cell;
import com.rodemark.entities.field.WorldMap;

import java.util.Random;

public class Spawn {
    private final Random random = new Random();
    private final Class <? extends Entity> targetType;

    public Spawn(Class<? extends Entity> targetType) {
        this.targetType = targetType;
    }

    public void spawning(WorldMap worldMap) {
        // TODO сделать изменение вероятности в зависимости от сущности.
        float chanceSpawn = 0.05f;
        int amountEntities = (int) (worldMap.getMapSize() * chanceSpawn);

        int x = 0;
        int y = 0;

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
}
