package com.transsnet.downloader;

import androidx.fragment.app.FragmentActivity;
import com.transsion.baselib.db.download.DownloadBean;
import kotlin.jvm.functions.Function4;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class h implements Function4 {
    public final /* synthetic */ DownloadManagerApi a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ String c;

    public /* synthetic */ h(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, String str) {
        this.a = downloadManagerApi;
        this.b = fragmentActivity;
        this.c = str;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return DownloadManagerApi.n(this.a, this.b, this.c, ((Integer) obj).intValue(), (String) obj2, (DownloadBean) obj3, ((Boolean) obj4).booleanValue());
    }
}
