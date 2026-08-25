package androidx.compose.runtime;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3048a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public u() {
        this(r2, false, 3, r2);
        androidx.compose.runtime.tooling.c cVar = null;
    }

    public u(androidx.compose.runtime.tooling.c cVar, boolean z5) {
        this.f3048a = z5;
    }

    public /* synthetic */ u(androidx.compose.runtime.tooling.c cVar, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : cVar, (i5 & 2) != 0 ? false : z5);
    }

    public final androidx.compose.runtime.tooling.c a() {
        return null;
    }

    public final boolean b() {
        return this.f3048a;
    }

    public final void c(androidx.compose.runtime.tooling.c cVar) {
    }
}
