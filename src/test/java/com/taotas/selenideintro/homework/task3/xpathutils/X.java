package com.taotas.selenideintro.homework.task3.xpathutils;

public class X {
    public static String hasCssClass(String className) {
        return String.format("contains(concat(' ', normalize-space(@class), ' ')," +
                " ' %s ')", className);
    }
}
