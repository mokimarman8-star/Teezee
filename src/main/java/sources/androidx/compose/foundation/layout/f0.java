package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class f0 implements h0 {

    /* renamed from: a, reason: collision with root package name */
    private final h0 f1849a;

    /* renamed from: b, reason: collision with root package name */
    private final h0 f1850b;

    public f0(h0 h0Var, h0 h0Var2) {
        this.f1849a = h0Var;
        this.f1850b = h0Var2;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int a(o0.e eVar) {
        return Math.max(this.f1849a.a(eVar), this.f1850b.a(eVar));
    }

    @Override // androidx.compose.foundation.layout.h0
    public int b(o0.e eVar) {
        return Math.max(this.f1849a.b(eVar), this.f1850b.b(eVar));
    }

    @Override // androidx.compose.foundation.layout.h0
    public int c(o0.e eVar, LayoutDirection layoutDirection) {
        return Math.max(this.f1849a.c(eVar, layoutDirection), this.f1850b.c(eVar, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.h0
    public int d(o0.e eVar, LayoutDirection layoutDirection) {
        return Math.max(this.f1849a.d(eVar, layoutDirection), this.f1850b.d(eVar, layoutDirection));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return Intrinsics.c(f0Var.f1849a, this.f1849a) && Intrinsics.c(f0Var.f1850b, this.f1850b);
    }

    public int hashCode() {
        return this.f1849a.hashCode() + (this.f1850b.hashCode() * 31);
    }

    public String toString() {
        return '(' + this.f1849a + " ∪ " + this.f1850b + ')';
    }
}
