package com.chornobuk;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayFilter {
    public static int[] getPositiveNumbersInDescendingOrder(int[] array) {
        if (array != null) {
            return Arrays.stream(array)
                    .boxed()
                    .filter(x -> x >= 0)
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
        return null;
    }
}
