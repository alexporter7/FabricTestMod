package com.github.fabrictestmod.util;

public class ScreenUtil {

    public static final int X_OFFSET = 28;

    public enum YOffsetLine {
        LINE1(11),
        LINE2(20),
        LINE3(29);

        public final int offset;

        YOffsetLine(int offset) {
            this.offset = offset;
        }

        public int getOffset() {
            return offset;
        }
    }

}
