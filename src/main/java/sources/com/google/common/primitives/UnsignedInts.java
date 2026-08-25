package com.google.common.primitives;

import com.google.common.base.m;
import java.util.Comparator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class UnsignedInts {

    enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i = 0; i < min; i++) {
                int i2 = iArr[i];
                int i3 = iArr2[i];
                if (i2 != i3) {
                    return UnsignedInts.a(i2, i3);
                }
            }
            return iArr.length - iArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }
    }

    public static int a(int i, int i2) {
        return Ints.e(c(i), c(i2));
    }

    public static int b(int i, int i2) {
        return (int) (f(i) / f(i2));
    }

    static int c(int i) {
        return i ^ Integer.MIN_VALUE;
    }

    public static int d(String str, int i) {
        m.o(str);
        long parseLong = Long.parseLong(str, i);
        if ((4294967295L & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new NumberFormatException("Input " + str + " in base " + i + " is not in the range of an unsigned integer");
    }

    public static int e(int i, int i2) {
        return (int) (f(i) % f(i2));
    }

    public static long f(int i) {
        return i & 4294967295L;
    }

    public static String g(int i, int i2) {
        return Long.toString(i & 4294967295L, i2);
    }
}
