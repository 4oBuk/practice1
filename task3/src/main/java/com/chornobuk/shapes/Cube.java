package com.chornobuk.shapes;

public class Cube extends AbstractShape {
    private int length;

    public Cube(int length) {
        if (length <= 0) throw new IllegalArgumentException("length cannot be negative or zero");
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length <= 0) throw new IllegalArgumentException("length cannot be negative or zero");
        this.length = length;
    }

    @Override
    public double getVolume() {
        return length * length * length;
    }
}
