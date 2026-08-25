package androidx.window.core;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f13764a;

    /* renamed from: b, reason: collision with root package name */
    private final int f13765b;

    /* renamed from: c, reason: collision with root package name */
    private final int f13766c;

    /* renamed from: d, reason: collision with root package name */
    private final int f13767d;

    public b(int i5, int i6, int i7, int i8) {
        this.f13764a = i5;
        this.f13765b = i6;
        this.f13766c = i7;
        this.f13767d = i8;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        Intrinsics.h(rect, "rect");
    }

    public final int a() {
        return this.f13767d - this.f13765b;
    }

    public final int b() {
        return this.f13764a;
    }

    public final int c() {
        return this.f13765b;
    }

    public final int d() {
        return this.f13766c - this.f13764a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.c(b.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.core.Bounds");
        }
        b bVar = (b) obj;
        return this.f13764a == bVar.f13764a && this.f13765b == bVar.f13765b && this.f13766c == bVar.f13766c && this.f13767d == bVar.f13767d;
    }

    public final Rect f() {
        return new Rect(this.f13764a, this.f13765b, this.f13766c, this.f13767d);
    }

    public int hashCode() {
        return (((((this.f13764a * 31) + this.f13765b) * 31) + this.f13766c) * 31) + this.f13767d;
    }

    public String toString() {
        return ((Object) b.class.getSimpleName()) + " { [" + this.f13764a + ',' + this.f13765b + ',' + this.f13766c + ',' + this.f13767d + "] }";
    }
}
