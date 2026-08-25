package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.LayoutDirection;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class o implements h0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f1868a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1869b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1870c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1871d;

    public o(int i5, int i6, int i7, int i8) {
        this.f1868a = i5;
        this.f1869b = i6;
        this.f1870c = i7;
        this.f1871d = i8;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int a(o0.e eVar) {
        return this.f1869b;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int b(o0.e eVar) {
        return this.f1871d;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int c(o0.e eVar, LayoutDirection layoutDirection) {
        return this.f1868a;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int d(o0.e eVar, LayoutDirection layoutDirection) {
        return this.f1870c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f1868a == oVar.f1868a && this.f1869b == oVar.f1869b && this.f1870c == oVar.f1870c && this.f1871d == oVar.f1871d;
    }

    public int hashCode() {
        return (((((this.f1868a * 31) + this.f1869b) * 31) + this.f1870c) * 31) + this.f1871d;
    }

    public String toString() {
        return "Insets(left=" + this.f1868a + ", top=" + this.f1869b + ", right=" + this.f1870c + ", bottom=" + this.f1871d + ')';
    }
}
