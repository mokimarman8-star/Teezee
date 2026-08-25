package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a implements s {

    /* renamed from: b, reason: collision with root package name */
    private final int f3970b;

    public a(int i5) {
        this.f3970b = i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.c(a.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.f(obj, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.AndroidPointerIconType");
        return this.f3970b == ((a) obj).f3970b;
    }

    public int hashCode() {
        return this.f3970b;
    }

    public String toString() {
        return "AndroidPointerIcon(type=" + this.f3970b + ')';
    }
}
