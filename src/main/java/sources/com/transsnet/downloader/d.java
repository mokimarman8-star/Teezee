package com.transsnet.downloader;

import androidx.fragment.app.FragmentActivity;
import com.transsion.baselib.db.download.DownloadBean;
import kotlin.jvm.functions.Function4;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class d implements Function4 {
    public final /* synthetic */ Function4 a;
    public final /* synthetic */ DownloadManagerApi b;
    public final /* synthetic */ FragmentActivity c;
    public final /* synthetic */ String d;

    public /* synthetic */ d(Function4 function4, DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, String str) {
        this.a = function4;
        this.b = downloadManagerApi;
        this.c = fragmentActivity;
        this.d = str;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return DownloadManagerApi.k(this.a, this.b, this.c, this.d, ((Integer) obj).intValue(), (String) obj2, (DownloadBean) obj3, ((Boolean) obj4).booleanValue());
    }
}
