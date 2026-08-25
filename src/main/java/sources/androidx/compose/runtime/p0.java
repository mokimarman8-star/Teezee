package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2866a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f2867b;

    public p0(Object obj, Object obj2) {
        this.f2866a = obj;
        this.f2867b = obj2;
    }

    private final int a(Object obj) {
        if (obj instanceof Enum) {
            return ((Enum) obj).ordinal();
        }
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return Intrinsics.c(this.f2866a, p0Var.f2866a) && Intrinsics.c(this.f2867b, p0Var.f2867b);
    }

    public int hashCode() {
        return (a(this.f2866a) * 31) + a(this.f2867b);
    }

    public String toString() {
        return "JoinedKey(left=" + this.f2866a + ", right=" + this.f2867b + ')';
    }
}
