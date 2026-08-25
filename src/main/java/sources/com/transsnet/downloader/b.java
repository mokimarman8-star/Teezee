package com.transsnet.downloader;

import androidx.fragment.app.FragmentActivity;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class b implements Function0 {
    public final /* synthetic */ DownloadManagerApi a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ Subject c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;

    public /* synthetic */ b(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5) {
        this.a = downloadManagerApi;
        this.b = fragmentActivity;
        this.c = subject;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return DownloadManagerApi.i(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
}
