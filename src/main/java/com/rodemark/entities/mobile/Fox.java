package com.rodemark.entities.mobile;

import com.rodemark.base_entity.Predator;
import com.rodemark.entities.field.Cell;

public class Fox extends Predator {


    public Fox(Cell position, int health, int power) {
        super(position, health, power);
    }

    @Override
    public String getSymbol(){
        return "\uD83E\uDD8A";
    }

}
