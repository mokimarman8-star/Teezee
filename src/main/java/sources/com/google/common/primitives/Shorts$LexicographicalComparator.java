package com.google.common.primitives;

import java.util.Comparator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
enum Shorts$LexicographicalComparator implements Comparator<short[]> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(short[] sArr, short[] sArr2) {
        int min = Math.min(sArr.length, sArr2.length);
        for (int i = 0; i < min; i++) {
            int compare = Short.compare(sArr[i], sArr2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return sArr.length - sArr2.length;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Shorts.lexicographicalComparator()";
    }
}
