package com.rodemark.base_entity;

public abstract class Entity {
    private final Cell position;

    public Entity(Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return position;
    }

    public String getSymbol() {
        return null;
    }
}
