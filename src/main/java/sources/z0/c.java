package z0;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f18717e = new c(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f18718a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18719b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18720c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18721d;

    static class a {
        static Insets a(int i5, int i6, int i7, int i8) {
            return Insets.of(i5, i6, i7, i8);
        }
    }

    private c(int i5, int i6, int i7, int i8) {
        this.f18718a = i5;
        this.f18719b = i6;
        this.f18720c = i7;
        this.f18721d = i8;
    }

    public static c a(c cVar, c cVar2) {
        return c(Math.max(cVar.f18718a, cVar2.f18718a), Math.max(cVar.f18719b, cVar2.f18719b), Math.max(cVar.f18720c, cVar2.f18720c), Math.max(cVar.f18721d, cVar2.f18721d));
    }

    public static c b(c cVar, c cVar2) {
        return c(Math.min(cVar.f18718a, cVar2.f18718a), Math.min(cVar.f18719b, cVar2.f18719b), Math.min(cVar.f18720c, cVar2.f18720c), Math.min(cVar.f18721d, cVar2.f18721d));
    }

    public static c c(int i5, int i6, int i7, int i8) {
        return (i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) ? f18717e : new c(i5, i6, i7, i8);
    }

    public static c d(Rect rect) {
        return c(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static c e(c cVar, c cVar2) {
        return c(cVar.f18718a - cVar2.f18718a, cVar.f18719b - cVar2.f18719b, cVar.f18720c - cVar2.f18720c, cVar.f18721d - cVar2.f18721d);
    }

    public static c f(Insets insets) {
        int i5;
        int i6;
        int i7;
        int i8;
        i5 = insets.left;
        i6 = insets.top;
        i7 = insets.right;
        i8 = insets.bottom;
        return c(i5, i6, i7, i8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f18721d == cVar.f18721d && this.f18718a == cVar.f18718a && this.f18720c == cVar.f18720c && this.f18719b == cVar.f18719b;
    }

    public Insets g() {
        return a.a(this.f18718a, this.f18719b, this.f18720c, this.f18721d);
    }

    public int hashCode() {
        return (((((this.f18718a * 31) + this.f18719b) * 31) + this.f18720c) * 31) + this.f18721d;
    }

    public String toString() {
        return "Insets{left=" + this.f18718a + ", top=" + this.f18719b + ", right=" + this.f18720c + ", bottom=" + this.f18721d + '}';
    }
}
