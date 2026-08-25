package com.transsion.http.b;

import il.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class b implements Runnable {
    final /* synthetic */ c a;

    b(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        fVar = this.a.k;
        fVar.a();
    }
}
