package com.chornobuk;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayFilterTest {

    @Test
    void getPositiveNumbersInDescendingOrderNullArray() {
        Assertions.assertArrayEquals(null, ArrayFilter.getPositiveNumbersInDescendingOrder(null));
    }

    @Test
    void getPositiveNumbersInDescendingOrderEmptyArray() {
        int[] emptyArray = new int[]{};
        Assertions.assertArrayEquals(emptyArray, ArrayFilter.getPositiveNumbersInDescendingOrder(emptyArray));
    }


    @Test
    void getPositiveNumbersInDescendingOrderUnsortedArray() {
        int[] unsortedArray = new int[]{0, 12, 23, 33, 55, 87};
        int[] sortedArray = new int[]{87, 55, 33, 23, 12, 0};
        Assertions.assertArrayEquals(sortedArray, ArrayFilter.getPositiveNumbersInDescendingOrder(unsortedArray));
    }

    @Test
    void getPositiveNumbersInDescendingOrder() {
        int[] originalArray = new int[]{-12, -35, 1, -2, 84, 0, 5, 129, 48, 964, -33,};
        int[] sortedArray = new int[]{964, 129, 84, 48, 5, 1, 0};
        Assertions.assertArrayEquals(sortedArray, ArrayFilter.getPositiveNumbersInDescendingOrder(originalArray));
    }
}