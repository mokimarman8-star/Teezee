package com.transsion.http.impl;

import java.io.UnsupportedEncodingException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class l implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ int b;
    final /* synthetic */ StringCallback c;

    l(StringCallback stringCallback, byte[] bArr, int i) {
        this.c = stringCallback;
        this.a = bArr;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.c.h(new j(this, StringCallback.w(this.a, "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            this.c.h(new k(this, e));
        }
    }
}
