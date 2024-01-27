package com.rodemark.entities.stationary;

import com.rodemark.base_entity.Entity;
import com.rodemark.entities.field.Cell;

public class Tree extends Entity {

    public Tree(Cell position) {
        super(position);
    }

    @Override
    public String getSymbol() {
        return "\uD83C\uDF33";
    }
}
