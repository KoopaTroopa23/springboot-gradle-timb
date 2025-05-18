package com.example.learning;

import java.util.ArrayList;
import java.util.List;

public class MathHelper {

    // From Section17 / Basics
    public static int calculateFinalValue() {
        int first = (10 + 11) + (2 * 10);
        int second = 12;
        int third = 6;
        return 1000 - (first + second + third);
    }

    // From Section17 – list with wrapper class
    public static List<Integer> getBigNumberList() {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(9);
        list.add(null);
        list.add(11);
        return list;
    }

    // From Section17 – casting
    public static short halfOfMinByte() {
        byte minByte = -128;
        return (short) (minByte / 2);
    }

    // From Section17 – max int value with underscore
    public static int getMaxIntValue() {
        return 2_123_234_232;
    }

    //From Section17 - Wrapper Classes for List and Maps and null
    public static List<Integer> createIntegerList(Integer... numbers) {
        List<Integer> list = new ArrayList<>();
        for (Integer num : numbers) {
            list.add(num);
        }
        return list;
    }

    // From FirstLessons or Section15 (learning basic variables)
    public static String describePrimitiveTypes() {
        return "byte, short, int, long, float, double, char, boolean";
    }

    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static char getGradeFromScore(int score) {
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        if (score >= 60) return 'D';
        return 'F';
    }
}
