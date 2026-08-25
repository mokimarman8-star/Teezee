package bm;

import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class e$b implements yx.d {
    public static final e$b a = new e$b();

    e$b() {
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final boolean a(Integer num, Throwable th2) {
        Intrinsics.h(num, "t1");
        Intrinsics.h(th2, "<unused var>");
        a.a.f(wf.a.a, "RequestConfig", "retry ing.. t1:" + num.intValue(), false, 4, (Object) null);
        return Intrinsics.c(e.e(e.a), Boolean.TRUE) && num.intValue() <= 1;
    }
}
