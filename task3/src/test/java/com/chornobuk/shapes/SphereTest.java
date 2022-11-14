package com.chornobuk.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    public void newSphereWithZeroRadius() {
        assertThrows(IllegalArgumentException.class, () -> new Sphere(0));
    }

    @Test
    public void newSphereWithNegativeRadius() {
        assertThrows(IllegalArgumentException.class, () -> new Sphere(-5));
    }

    @Test
    public void setNegativeRadius() {
        Sphere sphere = new Sphere(5);
        assertThrows(IllegalArgumentException.class, () ->sphere.setRadius(-4));
    }

    @Test
    public void setZeroRadius() {
        Sphere sphere = new Sphere(5);
        assertThrows(IllegalArgumentException.class, () ->sphere.setRadius(0));

    }

}