package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class l1 {

    /* renamed from: a, reason: collision with root package name */
    private final String f2800a;

    public l1(String str) {
        this.f2800a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l1) && Intrinsics.c(this.f2800a, ((l1) obj).f2800a);
    }

    public int hashCode() {
        return this.f2800a.hashCode();
    }

    public String toString() {
        return "OpaqueKey(key=" + this.f2800a + ')';
    }
}
