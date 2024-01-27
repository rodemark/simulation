package com.rodemark.base_entity;

public abstract class Predator extends Creature {
    public Predator(Cell position) {
        super(position);
    }

    @Override
    public void makeMove() {
        // Implement Predator's move logic
    }
}
