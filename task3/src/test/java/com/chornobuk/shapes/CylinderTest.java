package com.chornobuk.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    @Test
    public void newCylinderWithNegativeRadius() {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder(1,-5));
    }

    @Test
    public void newCylinderWithNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder(-1,5));
    }


    @Test
    public void newCylinderWithZeroRadius() {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder(1,0));
    }

    @Test
    public void newCylinderWithZeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder(0,5));
    }

    @Test
    public void newCylinderWithNegativeHeightAndRadius() {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder(-1,-5));
    }

    @Test
    public void newCylinderWithZeroHeightAndRadius() {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder(0,0));
    }

    @Test
    public void setRadiusWithNegativeValue() {
        Cylinder cylinder = new Cylinder(1,1);
        assertThrows(IllegalArgumentException.class, () -> cylinder.setRadius(-5));
    }

    @Test
    public void setRadiusWithZeroValue() {
        Cylinder cylinder = new Cylinder(1,1);
        assertThrows(IllegalArgumentException.class, () -> cylinder.setRadius(0));
    }

    @Test
    public void setHeightWithNegativeValue() {
        Cylinder cylinder = new Cylinder(1,1);
        assertThrows(IllegalArgumentException.class, () -> cylinder.setHeight(-3));

    }

    @Test
    public void setHeightWithZeroValue() {
        Cylinder cylinder = new Cylinder(1,1);
        assertThrows(IllegalArgumentException.class, () -> cylinder.setHeight(0));

    }
}