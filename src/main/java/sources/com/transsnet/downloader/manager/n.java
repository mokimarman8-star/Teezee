package com.transsnet.downloader.manager;

import com.transsion.baselib.db.download.DownloadBean;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class n implements Function1 {
    public final /* synthetic */ DownloadManagerImpl a;
    public final /* synthetic */ DownloadBean b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ String d;

    public /* synthetic */ n(DownloadManagerImpl downloadManagerImpl, DownloadBean downloadBean, Function1 function1, String str) {
        this.a = downloadManagerImpl;
        this.b = downloadBean;
        this.c = function1;
        this.d = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return DownloadManagerImpl.P(this.a, this.b, this.c, this.d, ((Boolean) obj).booleanValue());
    }
}
