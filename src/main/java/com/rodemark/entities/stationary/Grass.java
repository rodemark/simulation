package com.rodemark.entities.stationary;

import com.rodemark.base_entity.Entity;
import com.rodemark.entities.field.Cell;

public class Grass extends Entity {

    public Grass(Cell position) {
        super(position);
    }

    @Override
    public String getSymbol() {
        return "\uD83D\uDFE9";
    }
}
