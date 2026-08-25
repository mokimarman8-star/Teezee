package com.transsion.http.impl;

import java.io.UnsupportedEncodingException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class k implements Runnable {
    final /* synthetic */ UnsupportedEncodingException a;
    final /* synthetic */ l b;

    k(l lVar, UnsupportedEncodingException unsupportedEncodingException) {
        this.b = lVar;
        this.a = unsupportedEncodingException;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar = this.b;
        lVar.c.x(lVar.b, null, this.a.getCause());
    }
}
