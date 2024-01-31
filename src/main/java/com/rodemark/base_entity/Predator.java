package com.rodemark.base_entity;

import com.rodemark.entities.field.Cell;

public abstract class Predator extends Creature {
    protected int power;
    public Predator(Cell position) {
        super(position);
    }
    @Override
    public String getSymbol() {
        return null;
    }
}
