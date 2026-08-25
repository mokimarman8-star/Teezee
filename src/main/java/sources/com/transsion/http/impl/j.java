package com.transsion.http.impl;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ l b;

    j(l lVar, String str) {
        this.b = lVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar = this.b;
        lVar.c.y(lVar.b, this.a);
    }
}
