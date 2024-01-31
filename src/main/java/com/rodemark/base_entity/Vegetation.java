package com.rodemark.base_entity;

import com.rodemark.entities.field.Cell;

public abstract class Vegetation extends Entity{

    public Vegetation(Cell position) {
        super(position);
    }

    @Override
    public abstract String getSymbol();
}
