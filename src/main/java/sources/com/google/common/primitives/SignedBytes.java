package com.google.common.primitives;

import com.google.common.base.m;
import java.util.Comparator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class SignedBytes {

    private enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = Byte.compare(bArr[i], bArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return bArr.length - bArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }
    }

    public static byte a(long j) {
        byte b = (byte) j;
        m.h(((long) b) == j, "Out of range: %s", j);
        return b;
    }
}
