package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class n implements h0 {

    /* renamed from: a, reason: collision with root package name */
    private final h0 f1866a;

    /* renamed from: b, reason: collision with root package name */
    private final h0 f1867b;

    public n(h0 h0Var, h0 h0Var2) {
        this.f1866a = h0Var;
        this.f1867b = h0Var2;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int a(o0.e eVar) {
        return RangesKt.e(this.f1866a.a(eVar) - this.f1867b.a(eVar), 0);
    }

    @Override // androidx.compose.foundation.layout.h0
    public int b(o0.e eVar) {
        return RangesKt.e(this.f1866a.b(eVar) - this.f1867b.b(eVar), 0);
    }

    @Override // androidx.compose.foundation.layout.h0
    public int c(o0.e eVar, LayoutDirection layoutDirection) {
        return RangesKt.e(this.f1866a.c(eVar, layoutDirection) - this.f1867b.c(eVar, layoutDirection), 0);
    }

    @Override // androidx.compose.foundation.layout.h0
    public int d(o0.e eVar, LayoutDirection layoutDirection) {
        return RangesKt.e(this.f1866a.d(eVar, layoutDirection) - this.f1867b.d(eVar, layoutDirection), 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.c(nVar.f1866a, this.f1866a) && Intrinsics.c(nVar.f1867b, this.f1867b);
    }

    public int hashCode() {
        return (this.f1866a.hashCode() * 31) + this.f1867b.hashCode();
    }

    public String toString() {
        return '(' + this.f1866a + " - " + this.f1867b + ')';
    }
}
