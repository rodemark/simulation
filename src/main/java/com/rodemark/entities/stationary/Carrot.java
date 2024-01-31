package com.rodemark.entities.stationary;

import com.rodemark.base_entity.Vegetation;
import com.rodemark.entities.field.Cell;

public class Carrot extends Vegetation {

    public Carrot(Cell position) {
        super(position);
    }

    @Override
    public String getSymbol() {
        return "\uD83E\uDD55";
    }
}
