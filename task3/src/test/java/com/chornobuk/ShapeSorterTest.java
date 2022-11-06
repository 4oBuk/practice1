package com.chornobuk;

import com.chornobuk.shapes.AbstractShape;
import com.chornobuk.shapes.Cube;
import com.chornobuk.shapes.Cylinder;
import com.chornobuk.shapes.Sphere;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class ShapeSorterTest {

    Cube cube1 = new Cube(2);
    Cube cube2 = new Cube(4);
    Cube cube3 = new Cube(5);

    Sphere sphere1 = new Sphere(8);
    Sphere sphere2 = new Sphere(9);
    Sphere sphere3 = new Sphere(10);

    Cylinder cylinder1 = new Cylinder(200, 3);
    Cylinder cylinder3 = new Cylinder(400, 9);
    Cylinder cylinder2 = new Cylinder(500, 6);

    List<AbstractShape> sortedList = new ArrayList<>();

    {
        sortedList.add(cube1);
        sortedList.add(cube2);
        sortedList.add(cube3);
        sortedList.add(sphere1);
        sortedList.add(sphere2);
        sortedList.add(sphere3);
        sortedList.add(cylinder1);
        sortedList.add(cylinder2);
        sortedList.add(cylinder3);
    }

    @Test
    void sortByVolumeNullCollection() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeSorter.sortShapesByVolume(null));
    }

    @Test
    void sortByVolumeEmptyCollection() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeSorter.sortShapesByVolume(new ArrayList<>()));
    }

    @Test
    void sortByVolumeAlreadySortedCollection() {
        Assertions.assertEquals(sortedList, ShapeSorter.sortShapesByVolume(sortedList));

    }

    @Test
    void sortByVolume() {

        List<AbstractShape> startList = new ArrayList<>();
        startList.add(cube3);
        startList.add(cube2);
        startList.add(cube1);
        startList.add(sphere1);
        startList.add(sphere3);
        startList.add(sphere2);
        startList.add(cylinder3);
        startList.add(cylinder1);
        startList.add(cylinder2);

        Assertions.assertEquals(sortedList, ShapeSorter.sortShapesByVolume(startList));
    }
}