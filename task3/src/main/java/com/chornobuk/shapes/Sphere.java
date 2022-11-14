package com.chornobuk.shapes;

public class Sphere extends AbstractShape {
    private int radius;

    public Sphere(int radius) {
        if (radius <= 0) throw new IllegalArgumentException("radius cannot be negative or zero");
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius <= 0) throw new IllegalArgumentException("radius cannot be negative or zero");
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return 4 / 3.0 * Math.PI * Math.pow(radius, 3);
    }
}
