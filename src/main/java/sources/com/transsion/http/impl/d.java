package com.transsion.http.impl;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ DownloadCallback c;

    d(DownloadCallback downloadCallback, String str, String str2) {
        this.c = downloadCallback;
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.x(this.a, this.b);
    }
}
