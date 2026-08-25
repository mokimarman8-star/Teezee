package com.google.common.primitives;

import java.util.Comparator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class Floats extends c {

    private enum LexicographicalComparator implements Comparator<float[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(float[] fArr, float[] fArr2) {
            int min = Math.min(fArr.length, fArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = Float.compare(fArr[i], fArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return fArr.length - fArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }
    }

    public static int a(float f) {
        return Float.valueOf(f).hashCode();
    }
}
