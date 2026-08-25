package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class u implements t {

    /* renamed from: a, reason: collision with root package name */
    private final float f1879a;

    /* renamed from: b, reason: collision with root package name */
    private final float f1880b;

    /* renamed from: c, reason: collision with root package name */
    private final float f1881c;

    /* renamed from: d, reason: collision with root package name */
    private final float f1882d;

    private u(float f5, float f6, float f7, float f8) {
        this.f1879a = f5;
        this.f1880b = f6;
        this.f1881c = f7;
        this.f1882d = f8;
        if (f5 < 0.0f) {
            throw new IllegalArgumentException("Start padding must be non-negative");
        }
        if (f6 < 0.0f) {
            throw new IllegalArgumentException("Top padding must be non-negative");
        }
        if (f7 < 0.0f) {
            throw new IllegalArgumentException("End padding must be non-negative");
        }
        if (f8 < 0.0f) {
            throw new IllegalArgumentException("Bottom padding must be non-negative");
        }
    }

    public /* synthetic */ u(float f5, float f6, float f7, float f8, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, f6, f7, f8);
    }

    @Override // androidx.compose.foundation.layout.t
    public float a() {
        return this.f1882d;
    }

    @Override // androidx.compose.foundation.layout.t
    public float b(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.f1879a : this.f1881c;
    }

    @Override // androidx.compose.foundation.layout.t
    public float c(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.f1881c : this.f1879a;
    }

    @Override // androidx.compose.foundation.layout.t
    public float d() {
        return this.f1880b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return o0.i.i(this.f1879a, uVar.f1879a) && o0.i.i(this.f1880b, uVar.f1880b) && o0.i.i(this.f1881c, uVar.f1881c) && o0.i.i(this.f1882d, uVar.f1882d);
    }

    public int hashCode() {
        return (((((o0.i.j(this.f1879a) * 31) + o0.i.j(this.f1880b)) * 31) + o0.i.j(this.f1881c)) * 31) + o0.i.j(this.f1882d);
    }

    public String toString() {
        return "PaddingValues(start=" + ((Object) o0.i.k(this.f1879a)) + ", top=" + ((Object) o0.i.k(this.f1880b)) + ", end=" + ((Object) o0.i.k(this.f1881c)) + ", bottom=" + ((Object) o0.i.k(this.f1882d)) + ')';
    }
}
