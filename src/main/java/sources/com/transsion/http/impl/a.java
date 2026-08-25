package com.transsion.http.impl;

import android.graphics.Bitmap;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class a implements Runnable {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ b b;

    a(b bVar, Bitmap bitmap) {
        this.b = bVar;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar = this.b;
        bVar.c.z(bVar.b, this.a);
    }
}
