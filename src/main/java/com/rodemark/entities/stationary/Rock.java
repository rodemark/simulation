package com.rodemark.entities.stationary;

import com.rodemark.base_entity.Entity;
import com.rodemark.entities.field.Cell;

public class Rock extends Entity {

    public Rock(Cell position) {
        super(position);
    }

    @Override
    public String getSymbol() {
        return "\uD83E\uDEA8";
    }


}
