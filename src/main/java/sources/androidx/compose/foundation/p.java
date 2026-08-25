package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class p {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2144a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2145b;

    /* renamed from: c, reason: collision with root package name */
    private long f2146c = o0.t.f16668b.a();

    /* renamed from: d, reason: collision with root package name */
    private EdgeEffect f2147d;

    /* renamed from: e, reason: collision with root package name */
    private EdgeEffect f2148e;

    /* renamed from: f, reason: collision with root package name */
    private EdgeEffect f2149f;

    /* renamed from: g, reason: collision with root package name */
    private EdgeEffect f2150g;

    /* renamed from: h, reason: collision with root package name */
    private EdgeEffect f2151h;

    /* renamed from: i, reason: collision with root package name */
    private EdgeEffect f2152i;

    /* renamed from: j, reason: collision with root package name */
    private EdgeEffect f2153j;

    /* renamed from: k, reason: collision with root package name */
    private EdgeEffect f2154k;

    public p(Context context, int i5) {
        this.f2144a = context;
        this.f2145b = i5;
    }

    private final EdgeEffect e() {
        EdgeEffect a5 = o.f2143a.a(this.f2144a);
        a5.setColor(this.f2145b);
        if (!o0.t.e(this.f2146c, o0.t.f16668b.a())) {
            a5.setSize(o0.t.g(this.f2146c), o0.t.f(this.f2146c));
        }
        return a5;
    }

    private final boolean n(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !edgeEffect.isFinished();
    }

    private final boolean x(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !(o.f2143a.b(edgeEffect) == 0.0f);
    }

    public final boolean A() {
        return x(this.f2147d);
    }

    public final void B(long j5) {
        this.f2146c = j5;
        EdgeEffect edgeEffect = this.f2147d;
        if (edgeEffect != null) {
            edgeEffect.setSize(o0.t.g(j5), o0.t.f(j5));
        }
        EdgeEffect edgeEffect2 = this.f2148e;
        if (edgeEffect2 != null) {
            edgeEffect2.setSize(o0.t.g(j5), o0.t.f(j5));
        }
        EdgeEffect edgeEffect3 = this.f2149f;
        if (edgeEffect3 != null) {
            edgeEffect3.setSize(o0.t.f(j5), o0.t.g(j5));
        }
        EdgeEffect edgeEffect4 = this.f2150g;
        if (edgeEffect4 != null) {
            edgeEffect4.setSize(o0.t.f(j5), o0.t.g(j5));
        }
        EdgeEffect edgeEffect5 = this.f2151h;
        if (edgeEffect5 != null) {
            edgeEffect5.setSize(o0.t.g(j5), o0.t.f(j5));
        }
        EdgeEffect edgeEffect6 = this.f2152i;
        if (edgeEffect6 != null) {
            edgeEffect6.setSize(o0.t.g(j5), o0.t.f(j5));
        }
        EdgeEffect edgeEffect7 = this.f2153j;
        if (edgeEffect7 != null) {
            edgeEffect7.setSize(o0.t.f(j5), o0.t.g(j5));
        }
        EdgeEffect edgeEffect8 = this.f2154k;
        if (edgeEffect8 != null) {
            edgeEffect8.setSize(o0.t.f(j5), o0.t.g(j5));
        }
    }

    public final EdgeEffect f() {
        EdgeEffect edgeEffect = this.f2148e;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e5 = e();
        this.f2148e = e5;
        return e5;
    }

    public final EdgeEffect g() {
        EdgeEffect edgeEffect = this.f2152i;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e5 = e();
        this.f2152i = e5;
        return e5;
    }

    public final EdgeEffect h() {
        EdgeEffect edgeEffect = this.f2149f;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e5 = e();
        this.f2149f = e5;
        return e5;
    }

    public final EdgeEffect i() {
        EdgeEffect edgeEffect = this.f2153j;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e5 = e();
        this.f2153j = e5;
        return e5;
    }

    public final EdgeEffect j() {
        EdgeEffect edgeEffect = this.f2150g;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e5 = e();
        this.f2150g = e5;
        return e5;
    }

    public final EdgeEffect k() {
        EdgeEffect edgeEffect = this.f2154k;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e5 = e();
        this.f2154k = e5;
        return e5;
    }

    public final EdgeEffect l() {
        EdgeEffect edgeEffect = this.f2147d;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e5 = e();
        this.f2147d = e5;
        return e5;
    }

    public final EdgeEffect m() {
        EdgeEffect edgeEffect = this.f2151h;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e5 = e();
        this.f2151h = e5;
        return e5;
    }

    public final boolean o() {
        return n(this.f2148e);
    }

    public final boolean p() {
        return x(this.f2152i);
    }

    public final boolean q() {
        return x(this.f2148e);
    }

    public final boolean r() {
        return n(this.f2149f);
    }

    public final boolean s() {
        return x(this.f2153j);
    }

    public final boolean t() {
        return x(this.f2149f);
    }

    public final boolean u() {
        return n(this.f2150g);
    }

    public final boolean v() {
        return x(this.f2154k);
    }

    public final boolean w() {
        return x(this.f2150g);
    }

    public final boolean y() {
        return n(this.f2147d);
    }

    public final boolean z() {
        return x(this.f2151h);
    }
}
