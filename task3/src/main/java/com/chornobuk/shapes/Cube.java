package com.chornobuk.shapes;

public class Cube extends AbstractShape{
    private int length;

    public Cube(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public double getVolume() {
        return length * length * length;
    }
}
