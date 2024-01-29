package com.rodemark.entities.mobile;

import com.rodemark.base_entity.Predator;
import com.rodemark.entities.field.Cell;

public class Fox extends Predator {
    private static final int FOX_HEALTH = 5;
    private static final int FOX_SPEED = 1;

    public Fox(Cell position) {
        super(position);
        this.health = FOX_HEALTH;
        this.speed = FOX_SPEED;
    }

    @Override
    public String getSymbol(){
        return "\uD83E\uDD8A";
    }

}
