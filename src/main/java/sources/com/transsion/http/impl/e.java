package com.transsion.http.impl;

import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ File b;
    final /* synthetic */ DownloadCallback c;

    e(DownloadCallback downloadCallback, String str, File file) {
        this.c = downloadCallback;
        this.a = str;
        this.b = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.B(this.a, this.b);
    }
}
