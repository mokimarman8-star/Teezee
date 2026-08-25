package androidx.compose.ui.platform;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class k2 {

    /* renamed from: a, reason: collision with root package name */
    private final String f4834a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f4835b;

    public k2(String str, Object obj) {
        this.f4834a = str;
        this.f4835b = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k2)) {
            return false;
        }
        k2 k2Var = (k2) obj;
        return Intrinsics.c(this.f4834a, k2Var.f4834a) && Intrinsics.c(this.f4835b, k2Var.f4835b);
    }

    public int hashCode() {
        int hashCode = this.f4834a.hashCode() * 31;
        Object obj = this.f4835b;
        return hashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "ValueElement(name=" + this.f4834a + ", value=" + this.f4835b + ')';
    }
}
