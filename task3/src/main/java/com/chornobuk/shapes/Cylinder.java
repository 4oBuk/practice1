package com.chornobuk.shapes;

public class Cylinder extends AbstractShape {
    private int height;
    private int radius;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0) throw new IllegalArgumentException("height cannot be negative or zero");
        this.height = height;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius <= 0) throw new IllegalArgumentException("radius cannot be negative or zero");
        this.radius = radius;
    }

    public Cylinder(int height, int radius) {
        if (height <= 0 || radius <= 0)
            throw new IllegalArgumentException("height and radius have to be positive numbers");
        this.height = height;
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
