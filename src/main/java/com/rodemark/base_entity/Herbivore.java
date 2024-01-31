package com.rodemark.base_entity;

import com.rodemark.entities.field.Cell;

public abstract class Herbivore extends Creature {
    protected int health;
    public Herbivore(Cell position) {
        super(position);
    }

}
