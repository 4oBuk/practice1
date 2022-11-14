package com.chornobuk.shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CubeTest {

    @Test
    public void newCubeWithNegativeLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Cube(-1));
    }

    @Test
    public void newCubeWithZeroLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Cube(0));
    }

    @Test
    public void setLengthNegativeValue() {
        Cube cube = new Cube(2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> cube.setLength(-5));
    }

    @Test
    public void setLengthZeroValue() {
        Cube cube = new Cube(1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> cube.setLength(0));
    }
}