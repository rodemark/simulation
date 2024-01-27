package com.rodemark.entities.mobile;

import com.rodemark.base_entity.Predator;
import com.rodemark.base_entity.Cell;

public class Fox extends Predator {
    public Fox(Cell position) {
        super(position);
    }

    @Override
    public String getSymbol(){
        return "\uD83E\uDD8A";
    }
}
