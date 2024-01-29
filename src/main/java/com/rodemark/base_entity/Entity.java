package com.rodemark.base_entity;

import com.rodemark.entities.field.Cell;

public abstract class Entity {
    private Cell position;

    public Entity(Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return position;
    }
    public void setPosition(Cell position) {
        this.position = position;
    }

    public abstract String getSymbol();

}
