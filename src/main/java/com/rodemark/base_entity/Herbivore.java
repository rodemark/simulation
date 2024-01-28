package com.rodemark.base_entity;

import com.rodemark.entities.field.Cell;

public abstract class Herbivore extends Creature {
    public Herbivore(Cell position, int health, int power) {
        super(position);
        this.health = health;
        this.power = power;
    }

}
