package com.transsion.http.impl;

import java.io.UnsupportedEncodingException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class o implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ int b;
    final /* synthetic */ Throwable c;
    final /* synthetic */ StringCallback d;

    o(StringCallback stringCallback, byte[] bArr, int i, Throwable th2) {
        this.d = stringCallback;
        this.a = bArr;
        this.b = i;
        this.c = th2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.d.h(new m(this, StringCallback.w(this.a, "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            this.d.h(new n(this, e));
        }
    }
}
