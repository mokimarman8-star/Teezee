package com.transsnet.downloader.proxy;

import com.danikula.videocache.m;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadRange;
import kotlin.jvm.internal.Intrinsics;
import zw.d;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadFileCache$a extends d {
    final /* synthetic */ DownloadFileCache a;

    DownloadFileCache$a(DownloadFileCache downloadFileCache) {
        this.a = downloadFileCache;
    }

    @Override // zw.d
    public void h(DownloadBean bean, int i) {
        m d;
        m d2;
        Intrinsics.h(bean, "bean");
        if (DownloadFileCache.c(this.a) == null || (d = DownloadFileCache.d(this.a)) == null || !d.b()) {
            return;
        }
        long b = DownloadFileCache.b(this.a) + 8192;
        DownloadRange c = DownloadFileCache.c(this.a);
        Intrinsics.e(c);
        if (b > c.totalProgress() || (d2 = DownloadFileCache.d(this.a)) == null) {
            return;
        }
        d2.c();
    }
}
