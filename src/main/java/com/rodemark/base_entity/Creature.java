package com.rodemark.base_entity;

public abstract class Creature extends Entity {
    protected int health;
    protected int power;

    public Creature(Cell position) {
        super(position);
    }

    public abstract void makeMove();

}
