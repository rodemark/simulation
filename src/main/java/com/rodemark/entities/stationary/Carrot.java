package com.rodemark.entities.stationary;

import com.rodemark.base_entity.Entity;
import com.rodemark.entities.field.Cell;

public class Carrot extends Entity {

    public Carrot(Cell position) {
        super(position);
    }

    @Override
    public String getSymbol() {
        return "\uD83E\uDD55";
    }
}
