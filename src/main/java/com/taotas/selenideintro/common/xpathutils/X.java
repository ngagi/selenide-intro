package com.taotas.selenideintro.common.xpathutils;

public class X {
    public static String havingCssClass(String name) {
        return String.format("contains(concat(' ', normalize-space(@class), ' ')," +
                " ' %s ')", name);
    }
}
