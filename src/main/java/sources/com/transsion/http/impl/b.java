package com.transsion.http.impl;

import android.graphics.Bitmap;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class b implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ int b;
    final /* synthetic */ BitmapCallback c;

    b(BitmapCallback bitmapCallback, byte[] bArr, int i) {
        this.c = bitmapCallback;
        this.a = bArr;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap x;
        x = this.c.x(this.a);
        this.c.h(new a(this, x));
    }
}
