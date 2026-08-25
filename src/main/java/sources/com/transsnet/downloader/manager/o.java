package com.transsnet.downloader.manager;

import com.transsion.baselib.db.download.DownloadBean;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class o implements Function1 {
    public final /* synthetic */ DownloadBean a;
    public final /* synthetic */ DownloadManagerImpl b;
    public final /* synthetic */ int c;
    public final /* synthetic */ List d;
    public final /* synthetic */ Function1 e;
    public final /* synthetic */ String f;

    public /* synthetic */ o(DownloadBean downloadBean, DownloadManagerImpl downloadManagerImpl, int i, List list, Function1 function1, String str) {
        this.a = downloadBean;
        this.b = downloadManagerImpl;
        this.c = i;
        this.d = list;
        this.e = function1;
        this.f = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return DownloadManagerImpl.N(this.a, this.b, this.c, this.d, this.e, this.f, ((Boolean) obj).booleanValue());
    }
}
