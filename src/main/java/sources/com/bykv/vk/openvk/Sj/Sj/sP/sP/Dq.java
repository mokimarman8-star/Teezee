package com.bykv.vk.openvk.Sj.Sj.sP.sP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class Dq {
    private final RandomAccessFile a;

    static class Sj extends Exception {
        Sj(Throwable th) {
            super(th);
        }
    }

    Dq(File file, String str) {
        try {
            this.a = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new Sj(e);
        }
    }

    int a(byte[] bArr) {
        try {
            return this.a.read(bArr);
        } catch (IOException e) {
            throw new Sj(e);
        }
    }

    void b() {
        h6.a.n(this.a);
    }

    void c(long j) {
        try {
            this.a.seek(j);
        } catch (IOException e) {
            throw new Sj(e);
        }
    }

    void d(byte[] bArr, int i, int i2) {
        try {
            this.a.write(bArr, i, i2);
        } catch (IOException e) {
            throw new Sj(e);
        }
    }
}
