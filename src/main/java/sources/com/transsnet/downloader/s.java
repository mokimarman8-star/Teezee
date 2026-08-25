package com.transsnet.downloader;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class s implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Subject c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ int i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ FragmentManager k;
    public final /* synthetic */ DownloadManagerApi l;
    public final /* synthetic */ FragmentActivity m;

    public /* synthetic */ s(String str, String str2, Subject subject, String str3, String str4, String str5, String str6, String str7, int i, boolean z, FragmentManager fragmentManager, DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity) {
        this.a = str;
        this.b = str2;
        this.c = subject;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = i;
        this.j = z;
        this.k = fragmentManager;
        this.l = downloadManagerApi;
        this.m = fragmentActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return DownloadManagerApi.e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
    }
}
