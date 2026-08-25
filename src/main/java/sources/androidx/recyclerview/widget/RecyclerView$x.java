package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class RecyclerView$x {

    /* renamed from: b, reason: collision with root package name */
    private SparseArray f12875b;

    /* renamed from: m, reason: collision with root package name */
    int f12886m;

    /* renamed from: n, reason: collision with root package name */
    long f12887n;

    /* renamed from: o, reason: collision with root package name */
    int f12888o;

    /* renamed from: p, reason: collision with root package name */
    int f12889p;

    /* renamed from: q, reason: collision with root package name */
    int f12890q;

    /* renamed from: a, reason: collision with root package name */
    int f12874a = -1;

    /* renamed from: c, reason: collision with root package name */
    int f12876c = 0;

    /* renamed from: d, reason: collision with root package name */
    int f12877d = 0;

    /* renamed from: e, reason: collision with root package name */
    int f12878e = 1;

    /* renamed from: f, reason: collision with root package name */
    int f12879f = 0;

    /* renamed from: g, reason: collision with root package name */
    boolean f12880g = false;

    /* renamed from: h, reason: collision with root package name */
    boolean f12881h = false;

    /* renamed from: i, reason: collision with root package name */
    boolean f12882i = false;

    /* renamed from: j, reason: collision with root package name */
    boolean f12883j = false;

    /* renamed from: k, reason: collision with root package name */
    boolean f12884k = false;

    /* renamed from: l, reason: collision with root package name */
    boolean f12885l = false;

    void a(int i5) {
        if ((this.f12878e & i5) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i5) + " but it is " + Integer.toBinaryString(this.f12878e));
    }

    public int b() {
        return this.f12881h ? this.f12876c - this.f12877d : this.f12879f;
    }

    public int c() {
        return this.f12874a;
    }

    public boolean d() {
        return this.f12874a != -1;
    }

    public boolean e() {
        return this.f12881h;
    }

    void f(RecyclerView.Adapter adapter) {
        this.f12878e = 1;
        this.f12879f = adapter.getItemCount();
        this.f12881h = false;
        this.f12882i = false;
        this.f12883j = false;
    }

    public boolean g() {
        return this.f12885l;
    }

    public String toString() {
        return "State{mTargetPosition=" + this.f12874a + ", mData=" + this.f12875b + ", mItemCount=" + this.f12879f + ", mIsMeasuring=" + this.f12883j + ", mPreviousLayoutItemCount=" + this.f12876c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f12877d + ", mStructureChanged=" + this.f12880g + ", mInPreLayout=" + this.f12881h + ", mRunSimpleAnimations=" + this.f12884k + ", mRunPredictiveAnimations=" + this.f12885l + '}';
    }
}
