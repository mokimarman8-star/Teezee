package com.amazonaws.internal;

import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class SdkDigestInputStream extends DigestInputStream implements MetricAware {
    public SdkDigestInputStream(InputStream inputStream, MessageDigest messageDigest) {
        super(inputStream, messageDigest);
    }

    @Override // com.amazonaws.internal.MetricAware
    public final boolean d() {
        if (((DigestInputStream) this).in instanceof MetricAware) {
            return ((MetricAware) ((DigestInputStream) this).in).d();
        }
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) {
        if (j <= 0) {
            return j;
        }
        int min = (int) Math.min(2048L, j);
        byte[] bArr = new byte[min];
        long j2 = j;
        while (j2 > 0) {
            int read = read(bArr, 0, (int) Math.min(j2, min));
            if (read == -1) {
                if (j2 == j) {
                    return -1L;
                }
                return j - j2;
            }
            j2 -= read;
        }
        return j;
    }
}
