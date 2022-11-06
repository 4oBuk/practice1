package com.chornobuk;

import com.chornobuk.shapes.AbstractShape;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class ShapeSorterTest {

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
        List<AbstractShape> startList = new ArrayList<>();
        List<AbstractShape> sortedList = new ArrayList<>();

        Assertions.assertEquals(sortedList, ShapeSorter.sortShapesByVolume(startList));

    }

    void sortByVolume() {

    }
}