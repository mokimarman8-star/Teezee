package com.transsnet.downloader.viewmodel;

import com.transsnet.downloader.bean.DownloadUrlBean;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadListManager$b extends dg.a {
    final /* synthetic */ DownloadListManager d;

    DownloadListManager$b(DownloadListManager downloadListManager) {
        this.d = downloadListManager;
    }

    public void a(String str, String str2) {
        a.a.f(wf.a.a, "downloadAna", "url download, get config failure, liveData is null = " + (this.d.Q() == null), false, 4, (Object) null);
        androidx.lifecycle.b0 Q = this.d.Q();
        if (Q != null) {
            Q.n((Object) null);
        }
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(DownloadUrlBean downloadUrlBean) {
        a.a.v(wf.a.a, "downloadAna", "url download, get config success, liveData is null = " + (this.d.Q() == null), false, 4, (Object) null);
        androidx.lifecycle.b0 Q = this.d.Q();
        if (Q != null) {
            Q.n(downloadUrlBean);
        }
    }
}
