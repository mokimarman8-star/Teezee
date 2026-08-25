package com.transsion.http.impl;

import java.io.UnsupportedEncodingException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class n implements Runnable {
    final /* synthetic */ UnsupportedEncodingException a;
    final /* synthetic */ o b;

    n(o oVar, UnsupportedEncodingException unsupportedEncodingException) {
        this.b = oVar;
        this.a = unsupportedEncodingException;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar = this.b;
        oVar.d.x(oVar.b, null, this.a.getCause());
    }
}
