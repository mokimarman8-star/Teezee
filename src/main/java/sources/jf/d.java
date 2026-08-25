package jf;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class d {
    private final boolean a;
    private final String b;
    private final Runnable c;
    private volatile int d;
    private final HashSet e;

    public d(boolean z, String str, String str2, Runnable runnable) {
        Intrinsics.h(str, "taskName");
        Intrinsics.h(str2, "dependsOn");
        this.a = z;
        this.b = str;
        this.c = runnable;
        this.e = new HashSet();
        for (String str3 : StringsKt.S0(str2, new String[]{","}, false, 0, 6, (Object) null)) {
            if (!StringsKt.q0(str3)) {
                this.e.add(StringsKt.n1(str3).toString());
            }
        }
        if (this.e.contains(this.b)) {
            throw new IllegalArgumentException("TheRouter::Task::The task cannot depend on himself : " + this.b);
        }
        if (!this.e.isEmpty() || Intrinsics.c(this.b, "TheRouter_Initialization") || Intrinsics.c(this.b, "TheRouter_Before_Initialization")) {
            return;
        }
        this.e.add("TheRouter_Initialization");
    }

    public final boolean a() {
        return this.a;
    }

    public final HashSet b() {
        return this.e;
    }

    protected final int c() {
        return this.d;
    }

    public final String d() {
        return this.b;
    }

    public final boolean e() {
        return this.d == 2;
    }

    public final boolean f() {
        return this.d == 0;
    }

    public abstract void g();

    protected final void h(int i) {
        this.d = i;
    }
}
