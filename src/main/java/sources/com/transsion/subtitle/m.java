package com.transsion.subtitle;

import com.transsion.baselib.db.download.DownloadBean;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class m implements Function1 {
    public final /* synthetic */ VideoSubtitleManagerImp a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ DownloadBean c;

    public /* synthetic */ m(VideoSubtitleManagerImp videoSubtitleManagerImp, Function1 function1, DownloadBean downloadBean) {
        this.a = videoSubtitleManagerImp;
        this.b = function1;
        this.c = downloadBean;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return VideoSubtitleManagerImp.n(this.a, this.b, this.c, ((Boolean) obj).booleanValue());
    }
}
