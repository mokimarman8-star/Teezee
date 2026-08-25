package com.transsnet.downloader;

import androidx.fragment.app.FragmentActivity;
import com.transsion.baselib.db.download.DownloadBean;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ DownloadManagerApi a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ DownloadBean c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Ref.ObjectRef e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    public /* synthetic */ a(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, DownloadBean downloadBean, String str, Ref.ObjectRef objectRef, String str2, String str3) {
        this.a = downloadManagerApi;
        this.b = fragmentActivity;
        this.c = downloadBean;
        this.d = str;
        this.e = objectRef;
        this.f = str2;
        this.g = str3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return DownloadManagerApi.s(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }
}
