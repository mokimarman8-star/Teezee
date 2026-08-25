package androidx.recyclerview.widget;

import android.view.View;
import androidx.core.view.inputmethod.EditorInfoCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class LinearLayoutManager$a {

    /* renamed from: a, reason: collision with root package name */
    m f12805a;

    /* renamed from: b, reason: collision with root package name */
    int f12806b;

    /* renamed from: c, reason: collision with root package name */
    int f12807c;

    /* renamed from: d, reason: collision with root package name */
    boolean f12808d;

    /* renamed from: e, reason: collision with root package name */
    boolean f12809e;

    LinearLayoutManager$a() {
        e();
    }

    void a() {
        this.f12807c = this.f12808d ? this.f12805a.i() : this.f12805a.m();
    }

    public void b(View view, int i5) {
        if (this.f12808d) {
            this.f12807c = this.f12805a.d(view) + this.f12805a.o();
        } else {
            this.f12807c = this.f12805a.g(view);
        }
        this.f12806b = i5;
    }

    public void c(View view, int i5) {
        int o5 = this.f12805a.o();
        if (o5 >= 0) {
            b(view, i5);
            return;
        }
        this.f12806b = i5;
        if (this.f12808d) {
            int i6 = (this.f12805a.i() - o5) - this.f12805a.d(view);
            this.f12807c = this.f12805a.i() - i6;
            if (i6 > 0) {
                int e5 = this.f12807c - this.f12805a.e(view);
                int m5 = this.f12805a.m();
                int min = e5 - (m5 + Math.min(this.f12805a.g(view) - m5, 0));
                if (min < 0) {
                    this.f12807c += Math.min(i6, -min);
                    return;
                }
                return;
            }
            return;
        }
        int g5 = this.f12805a.g(view);
        int m6 = g5 - this.f12805a.m();
        this.f12807c = g5;
        if (m6 > 0) {
            int i7 = (this.f12805a.i() - Math.min(0, (this.f12805a.i() - o5) - this.f12805a.d(view))) - (g5 + this.f12805a.e(view));
            if (i7 < 0) {
                this.f12807c -= Math.min(m6, -i7);
            }
        }
    }

    boolean d(View view, RecyclerView$x recyclerView$x) {
        RecyclerView$n recyclerView$n = (RecyclerView$n) view.getLayoutParams();
        return !recyclerView$n.isItemRemoved() && recyclerView$n.getViewLayoutPosition() >= 0 && recyclerView$n.getViewLayoutPosition() < recyclerView$x.b();
    }

    void e() {
        this.f12806b = -1;
        this.f12807c = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f12808d = false;
        this.f12809e = false;
    }

    public String toString() {
        return "AnchorInfo{mPosition=" + this.f12806b + ", mCoordinate=" + this.f12807c + ", mLayoutFromEnd=" + this.f12808d + ", mValid=" + this.f12809e + '}';
    }
}
