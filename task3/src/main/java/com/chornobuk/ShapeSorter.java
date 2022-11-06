package com.chornobuk;

import com.chornobuk.shapes.AbstractShape;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ShapeSorter {
    public static List<AbstractShape> sortShapesByVolume(Collection<AbstractShape> shapes) {
        if(shapes == null || shapes.size() == 0) throw new IllegalArgumentException("collection cannot be null or empty");
        return shapes.stream()
                .sorted(Comparator.comparingDouble(AbstractShape::getVolume))
                .toList();
    }
}
