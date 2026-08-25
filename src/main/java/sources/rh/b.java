package rh;

import com.transsion.ad.strategy.v;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final void a(List list) {
        Intrinsics.h(list, "strings");
        e.a.b(list);
    }

    public final void b() {
        xh.a.e(xh.a.a, (String) null, b.class.getSimpleName() + " --> setFullSearchModelSkipHotSplashAd() --> 接收到了deeplink事件 --> 全搜的时候热启动不展示热启动广告", 5, false, 9, (Object) null);
        c.a.b(true);
    }

    public final void c(boolean z) {
        xh.a.e(xh.a.a, (String) null, b.class.getSimpleName() + " --> setSkipShowAd() --> isPassed = " + z, 0, false, 13, (Object) null);
        e.a.c(z);
    }

    public final void d(boolean z) {
        v.a.b(z);
    }
}
