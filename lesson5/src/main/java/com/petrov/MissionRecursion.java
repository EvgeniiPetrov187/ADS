package com.petrov;

// 1. Написать программу по возведению числа в степень с помощью рекурсии.
public class MissionRecursion {
    public static int multiple(int number, int degree) {
        if (degree == 0) {
            return 1;
        } else if (degree == 1) {
            return number;
        } else {
            return multiple(number, degree - 1) * number;
        }
    }
}
