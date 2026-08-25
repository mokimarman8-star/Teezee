package com.transsnet.downloader;

import androidx.fragment.app.FragmentActivity;
import com.transsion.baselib.db.download.DownloadBean;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ DownloadBean d;
    public final /* synthetic */ DownloadManagerApi e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    public /* synthetic */ f(FragmentActivity fragmentActivity, String str, String str2, DownloadBean downloadBean, DownloadManagerApi downloadManagerApi, String str3, String str4) {
        this.a = fragmentActivity;
        this.b = str;
        this.c = str2;
        this.d = downloadBean;
        this.e = downloadManagerApi;
        this.f = str3;
        this.g = str4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return DownloadManagerApi.r(this.a, this.b, this.c, this.d, this.e, this.f, this.g, (DownloadBean) obj);
    }
}
