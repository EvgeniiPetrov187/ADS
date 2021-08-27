package com.petrov;

// 1. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1).
// Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.
public class MissionOne {
    public static int searchDigit(int[] arr) {
        if (arr.length == 0) {
            System.out.println(1);
        }
        int end = arr.length - 1;
        int start = 0;
        int center;
        int i = 0;

        while (end >= start) {
            i++;
            center = (start + end) / 2;
            if (arr[center] - center == 1) {
                start = center + 1;
            } else {
                end = center - 1;
            }
        }
        System.out.println("Iterations " + i);
        System.out.println(start + 1);


        return start + 1;
    }
}
