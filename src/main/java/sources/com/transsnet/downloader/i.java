package com.transsnet.downloader;

import androidx.fragment.app.FragmentActivity;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class i implements Function0 {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Subject d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ DownloadManagerApi i;

    public /* synthetic */ i(FragmentActivity fragmentActivity, String str, String str2, Subject subject, String str3, String str4, String str5, String str6, DownloadManagerApi downloadManagerApi) {
        this.a = fragmentActivity;
        this.b = str;
        this.c = str2;
        this.d = subject;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = downloadManagerApi;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return DownloadManagerApi.c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }
}
