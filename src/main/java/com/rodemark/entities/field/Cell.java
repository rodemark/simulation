package com.rodemark.entities.field;

public record Cell(int x, int y) {
    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }
}
