package com.transsion.shorttv.subtitle.manager;

import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ur.n;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvVideoSubtitleManagerImp$resDownloadListener$1 implements n {
    final /* synthetic */ ShortTvVideoSubtitleManagerImp a;

    ShortTvVideoSubtitleManagerImp$resDownloadListener$1(ShortTvVideoSubtitleManagerImp shortTvVideoSubtitleManagerImp) {
        this.a = shortTvVideoSubtitleManagerImp;
    }

    private final void e(xr.a aVar, boolean z) {
        i.d(o0.a(y0.a()), (CoroutineContext) null, (CoroutineStart) null, new ShortTvVideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1(this.a, aVar, z, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            xr.b bVar = (xr.b) it.next();
            if (bVar.b() && bVar.a().getStatus() == 6) {
                return true;
            }
        }
        return false;
    }

    @Override // ur.n
    public void a(String str) {
        Intrinsics.h(str, "subtitleResId");
        i.d(o0.a(y0.a()), (CoroutineContext) null, (CoroutineStart) null, new ShortTvVideoSubtitleManagerImp$resDownloadListener$1$deleteSubtitle$1(str, null), 3, (Object) null);
    }

    @Override // ur.n
    public void b(xr.a aVar) {
        Intrinsics.h(aVar, "bean");
        e(aVar, true);
    }

    @Override // ur.n
    public void c(xr.a aVar, boolean z) {
        String str;
        Intrinsics.h(aVar, "bean");
        a.a aVar2 = wf.a.a;
        str = this.a.c;
        aVar2.c("short_tv_subtitle", str + " 开始下载，检测字幕 firstDownload:" + z + "，titleName:" + aVar.h() + ", ep:" + aVar.a() + " se:" + aVar.c(), true);
        if (z) {
            ShortTvVideoSubtitleManagerImp.n(this.a, aVar, null, 2, null);
        } else {
            e(aVar, false);
        }
    }
}
