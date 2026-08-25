package pg;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class d {
    private String a = "";
    private og.b b;
    private long c;
    private Executor d;
    private og.a e;

    public final og.a a() {
        return this.e;
    }

    public final long b() {
        return this.c;
    }

    public final Executor c() {
        return this.d;
    }

    public final og.b d() {
        return this.b;
    }

    public final String e() {
        return this.a;
    }

    public final void f(Executor executor) {
        this.d = executor;
    }

    public final void g(og.b bVar) {
        this.b = bVar;
    }

    public final void h(String str) {
        Intrinsics.h(str, "<set-?>");
        this.a = str;
    }
}
