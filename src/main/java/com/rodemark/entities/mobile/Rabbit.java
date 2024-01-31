package com.rodemark.entities.mobile;

import com.rodemark.base_entity.Herbivore;
import com.rodemark.entities.field.Cell;

public class Rabbit extends Herbivore {
    private static final int RABBIT_HEALTH = 5;
    private static final int RABBIT_SPEED = 2;

    public Rabbit(Cell position) {
        super(position);
        this.health = RABBIT_HEALTH;
        this.speed = RABBIT_SPEED;
    }

    @Override
    public String getSymbol(){
        return "\uD83D\uDC30";
    }
}
