package common.xpathutils;

public class X {
    public static String hasCssClass(String name) {
        return String.format("contains(concat(' ', normalize-space(@class), ' ')," +
                " ' %s ')", name);
    }
}
