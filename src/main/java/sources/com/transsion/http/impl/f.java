package com.transsion.http.impl;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ long c;
    final /* synthetic */ DownloadCallback d;

    f(DownloadCallback downloadCallback, String str, long j, long j2) {
        this.d = downloadCallback;
        this.a = str;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.z(this.a, this.b, this.c);
    }
}
