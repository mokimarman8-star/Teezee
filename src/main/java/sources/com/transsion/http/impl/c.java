package com.transsion.http.impl;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class c implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ Throwable b;
    final /* synthetic */ BitmapCallback c;

    c(BitmapCallback bitmapCallback, int i, Throwable th2) {
        this.c = bitmapCallback;
        this.a = i;
        this.b = th2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.y(this.a, null, this.b);
    }
}
