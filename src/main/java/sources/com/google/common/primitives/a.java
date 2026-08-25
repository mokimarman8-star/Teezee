package com.google.common.primitives;

import com.google.common.base.m;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a {
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(byte[] bArr, byte[] bArr2) {
        m.p(bArr, "array");
        m.p(bArr2, "target");
        if (bArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (bArr.length - bArr2.length) + 1) {
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                if (bArr[i + i2] != bArr2[i2]) {
                    break;
                }
            }
            return i;
        }
        return -1;
    }
}
