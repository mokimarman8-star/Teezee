package com.transsnet.downloader;

import androidx.fragment.app.FragmentActivity;
import com.transsion.baselib.db.download.DownloadBean;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ DownloadBean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ FragmentActivity d;

    public /* synthetic */ e(DownloadBean downloadBean, String str, int i, FragmentActivity fragmentActivity) {
        this.a = downloadBean;
        this.b = str;
        this.c = i;
        this.d = fragmentActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DownloadManagerApi.j(this.a, this.b, this.c, this.d);
    }
}
