package ag;

import com.tn.lib.net.cons.HeaderType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class b {
    private boolean a;
    private boolean b;
    private String c = "";
    private HeaderType d = HeaderType.ONE_ROOM;
    private long e;

    public final HeaderType a() {
        return this.d;
    }

    public final String b() {
        return this.c;
    }

    public final boolean c() {
        return this.a;
    }

    public final boolean d() {
        return this.b;
    }

    public final void e(boolean z) {
        this.a = z;
    }

    public final void f(boolean z) {
        this.b = z;
    }

    public final void g(long j) {
        this.e = j;
    }

    public final void h(String str) {
        Intrinsics.h(str, "<set-?>");
        this.c = str;
    }
}
