package com.tn.tranpay;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class e {
    public static final a c;
    private static e d;
    private boolean a;
    private int b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(e eVar) {
            Intrinsics.h(eVar, "theme");
            e.d = eVar;
        }

        public final e b() {
            return e.d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        c = new a(defaultConstructorMarker);
        d = new e(false, 0 == true ? 1 : 0, 3, defaultConstructorMarker);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public e(boolean z, int i) {
        this.a = z;
        this.b = i;
    }

    public /* synthetic */ e(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? -14696961 : i);
    }

    public final boolean c() {
        return this.a;
    }

    public final int d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b == eVar.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.b;
    }

    public String toString() {
        return "TranPayTheme(showLoadingWhenLaunched=" + this.a + ", tintColor=" + this.b + ")";
    }
}
