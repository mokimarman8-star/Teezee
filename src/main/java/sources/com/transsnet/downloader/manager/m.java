package com.transsnet.downloader.manager;

import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class m implements Function1 {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ DownloadManagerImpl b;

    public /* synthetic */ m(Function1 function1, DownloadManagerImpl downloadManagerImpl) {
        this.a = function1;
        this.b = downloadManagerImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return DownloadManagerImpl.M(this.a, this.b, ((Boolean) obj).booleanValue());
    }
}
