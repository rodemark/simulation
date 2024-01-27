package com.rodemark.entities.stationary;

import com.rodemark.base_entity.Entity;
import com.rodemark.entities.field.Cell;

public class Ground extends Entity {

    public Ground(Cell position) {
        super(position);
    }

    @Override
    public String getSymbol() {
        return "\uD83D\uDFEB";
    }
}
