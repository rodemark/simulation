package com.rodemark.entities.mobile;

import com.rodemark.base_entity.Herbivore;
import com.rodemark.entities.field.Cell;

public class Rabbit extends Herbivore {
    public Rabbit(Cell position, int health, int power) {
        super(position, health, power);
    }

    @Override
    public String getSymbol(){
        return "\uD83D\uDC07";
    }
}
