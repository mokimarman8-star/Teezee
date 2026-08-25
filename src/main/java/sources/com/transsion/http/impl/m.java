package com.transsion.http.impl;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class m implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ o b;

    m(o oVar, String str) {
        this.b = oVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar = this.b;
        oVar.d.x(oVar.b, this.a, oVar.c);
    }
}
