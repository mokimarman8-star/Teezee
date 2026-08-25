package pq;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f16978a = new a();

    private a() {
    }

    private final String a(String str, String str2) {
        ur.b h5;
        String a5;
        vr.a c5 = c.f16989a.c();
        return (c5 == null || (h5 = c5.h()) == null || (a5 = h5.a(str, str2)) == null) ? str2 : a5;
    }

    static /* synthetic */ String b(a aVar, String str, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = null;
        }
        return aVar.a(str, str2);
    }

    public final boolean c() {
        return !Intrinsics.c(b(this, "short_tv_optimize_enable", null, 2, null), "false");
    }
}
