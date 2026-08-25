package com.transsion.http.impl;

import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class DownloadCallback extends q {
    private long e;
    private long f = 300;

    public void A(int i, String str, File file) {
        h(new e(this, str, file));
    }

    public abstract void B(String str, File file);

    @Override // com.transsion.http.impl.q
    public void m(int i, byte[] bArr, Throwable th2) {
    }

    @Override // com.transsion.http.impl.q
    public void s(int i, byte[] bArr) {
    }

    public void w(int i, String str, String str2) {
        h(new d(this, str, str2));
    }

    public abstract void x(String str, String str2);

    public void y(int i, String str, long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.e >= this.f) {
            this.e = currentTimeMillis;
            h(new f(this, str, j, j2));
        }
    }

    public abstract void z(String str, long j, long j2);
}
