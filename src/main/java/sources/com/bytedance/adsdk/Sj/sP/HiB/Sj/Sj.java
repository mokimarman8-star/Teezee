package com.bytedance.adsdk.Sj.sP.HiB.Sj;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {
    private static Object Sj(double d, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Double.valueOf(d / number.intValue());
        }
        if (number instanceof Long) {
            return Double.valueOf(d / number.longValue());
        }
        if (number instanceof Float) {
            return Double.valueOf(d / number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(d / number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object Sj(float f, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Float.valueOf(f / number.intValue());
        }
        if (number instanceof Long) {
            return Float.valueOf(f / number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(f / number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(f / number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object Sj(int i, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Integer.valueOf(i / number.intValue());
        }
        if (number instanceof Long) {
            return Long.valueOf(i / number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(i / number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(i / number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object Sj(long j, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Long.valueOf(j / number.intValue());
        }
        if (number instanceof Long) {
            return Long.valueOf(j / number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(j / number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(j / number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    public static Object Sj(Number number, Number number2) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Sj(number.intValue(), number2);
        }
        if (number instanceof Long) {
            return Sj(number.longValue(), number2);
        }
        if (number instanceof Float) {
            return Sj(number.floatValue(), number2);
        }
        if (number instanceof Double) {
            return Sj(number.doubleValue(), number2);
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }
}
