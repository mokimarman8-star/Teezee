package com.transsnet.downloader.fragment;

import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class c6 implements Function1 {
    public final /* synthetic */ FileManagerFragment a;

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return FileManagerFragment.B0(this.a, (AddToDownloadEvent) obj);
    }
}
