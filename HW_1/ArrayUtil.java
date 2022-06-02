package ru.geekbrains.HW_1;

import java.util.ArrayList;

public class ArrayUtil {
    public static void replaceTwoElements(Object[] arr, int i1, int i2) {
        Object temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;

    }
    public static <T> ArrayList<T> arrToList(T[] arr) {
        ArrayList<T> result = new ArrayList<T>(arr.length);
        for (T t : arr) {
            result.add(t);
        }
        return result;
    }
}
