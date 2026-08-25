package sn;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();
    private static f b;

    private e() {
    }

    public static /* synthetic */ void b(e eVar, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        eVar.a(str, str2, z);
    }

    public static /* synthetic */ void d(e eVar, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        eVar.c(str, str2, z);
    }

    public static /* synthetic */ void f(e eVar, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        eVar.e(str, str2, z);
    }

    public static /* synthetic */ void i(e eVar, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        eVar.h(str, str2, z);
    }

    public final void a(String str, String str2, boolean z) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(str2, "msg");
        f fVar = b;
        if (fVar != null) {
            fVar.b(str, str2, z);
        }
    }

    public final void c(String str, String str2, boolean z) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(str2, "msg");
        f fVar = b;
        if (fVar != null) {
            fVar.d(str, str2, z);
        }
    }

    public final void e(String str, String str2, boolean z) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(str2, "msg");
        f fVar = b;
        if (fVar != null) {
            fVar.a(str, str2, z);
        }
    }

    public final void g(f fVar) {
        Intrinsics.h(fVar, "callback");
        b = fVar;
    }

    public final void h(String str, String str2, boolean z) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(str2, "msg");
        f fVar = b;
        if (fVar != null) {
            fVar.c(str, str2, z);
        }
    }
}
