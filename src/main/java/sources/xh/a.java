package xh;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    private final void a(int i, String str, String str2, boolean z) {
        if (i == 3) {
            wf.a.a.c(str, str2, z);
            return;
        }
        if (i == 4) {
            wf.a.a.p(str, new String[]{str2}, z);
        } else if (i == 5) {
            wf.a.a.w(str, str2, z);
        } else {
            if (i != 6) {
                return;
            }
            wf.a.a.i(str, str2, z);
        }
    }

    public static /* synthetic */ void c(a aVar, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 4;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        aVar.b(str, i, z);
    }

    public static /* synthetic */ void e(a aVar, String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "ad_";
        }
        if ((i2 & 4) != 0) {
            i = 3;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        aVar.d(str, str2, i, z);
    }

    public static /* synthetic */ void g(a aVar, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 3;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        aVar.f(str, i, z);
    }

    public static /* synthetic */ void i(a aVar, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 3;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        aVar.h(str, i, z);
    }

    public static /* synthetic */ void k(a aVar, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 3;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        aVar.j(str, i, z);
    }

    public static /* synthetic */ void m(a aVar, String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 3;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        aVar.l(str, str2, i, z);
    }

    public final void b(String str, int i, boolean z) {
        Intrinsics.h(str, "msg");
        a(i, "ad_init", str, z);
    }

    public final void d(String str, String str2, int i, boolean z) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(str2, "msg");
        a(i, str, str2, z);
    }

    public final void f(String str, int i, boolean z) {
        Intrinsics.h(str, "msg");
        a(i, "ad_ic", str, z);
    }

    public final void h(String str, int i, boolean z) {
        Intrinsics.h(str, "msg");
        a(i, "ad_ps_d", str, z);
    }

    public final void j(String str, int i, boolean z) {
        Intrinsics.h(str, "msg");
        a(i, "ad_ps_a", str, z);
    }

    public final void l(String str, String str2, int i, boolean z) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(str2, "msg");
        a(i, str, str2, z);
    }
}
