package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    final b f12938a;

    /* renamed from: b, reason: collision with root package name */
    final a f12939b = new a();

    /* renamed from: c, reason: collision with root package name */
    final List f12940c = new ArrayList();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        long f12941a = 0;

        /* renamed from: b, reason: collision with root package name */
        a f12942b;

        a() {
        }

        private void c() {
            if (this.f12942b == null) {
                this.f12942b = new a();
            }
        }

        void a(int i5) {
            if (i5 < 64) {
                this.f12941a &= ~(1 << i5);
                return;
            }
            a aVar = this.f12942b;
            if (aVar != null) {
                aVar.a(i5 - 64);
            }
        }

        int b(int i5) {
            a aVar = this.f12942b;
            return aVar == null ? i5 >= 64 ? Long.bitCount(this.f12941a) : Long.bitCount(this.f12941a & ((1 << i5) - 1)) : i5 < 64 ? Long.bitCount(this.f12941a & ((1 << i5) - 1)) : aVar.b(i5 - 64) + Long.bitCount(this.f12941a);
        }

        boolean d(int i5) {
            if (i5 < 64) {
                return (this.f12941a & (1 << i5)) != 0;
            }
            c();
            return this.f12942b.d(i5 - 64);
        }

        void e(int i5, boolean z5) {
            if (i5 >= 64) {
                c();
                this.f12942b.e(i5 - 64, z5);
                return;
            }
            long j5 = this.f12941a;
            boolean z6 = (Long.MIN_VALUE & j5) != 0;
            long j6 = (1 << i5) - 1;
            this.f12941a = ((j5 & (~j6)) << 1) | (j5 & j6);
            if (z5) {
                h(i5);
            } else {
                a(i5);
            }
            if (z6 || this.f12942b != null) {
                c();
                this.f12942b.e(0, z6);
            }
        }

        boolean f(int i5) {
            if (i5 >= 64) {
                c();
                return this.f12942b.f(i5 - 64);
            }
            long j5 = 1 << i5;
            long j6 = this.f12941a;
            boolean z5 = (j6 & j5) != 0;
            long j7 = j6 & (~j5);
            this.f12941a = j7;
            long j8 = j5 - 1;
            this.f12941a = (j7 & j8) | Long.rotateRight((~j8) & j7, 1);
            a aVar = this.f12942b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f12942b.f(0);
            }
            return z5;
        }

        void g() {
            this.f12941a = 0L;
            a aVar = this.f12942b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i5) {
            if (i5 < 64) {
                this.f12941a |= 1 << i5;
            } else {
                c();
                this.f12942b.h(i5 - 64);
            }
        }

        public String toString() {
            if (this.f12942b == null) {
                return Long.toBinaryString(this.f12941a);
            }
            return this.f12942b.toString() + "xx" + Long.toBinaryString(this.f12941a);
        }
    }

    interface b {
        void a(View view);

        RecyclerView$a0 b(View view);

        void c(int i5);

        void d(View view, int i5);

        void e();

        int f(View view);

        void g(View view);

        View getChildAt(int i5);

        int getChildCount();

        void h(int i5);

        void i(View view, int i5, ViewGroup.LayoutParams layoutParams);
    }

    e(b bVar) {
        this.f12938a = bVar;
    }

    private int h(int i5) {
        if (i5 < 0) {
            return -1;
        }
        int childCount = this.f12938a.getChildCount();
        int i6 = i5;
        while (i6 < childCount) {
            int b5 = i5 - (i6 - this.f12939b.b(i6));
            if (b5 == 0) {
                while (this.f12939b.d(i6)) {
                    i6++;
                }
                return i6;
            }
            i6 += b5;
        }
        return -1;
    }

    private void l(View view) {
        this.f12940c.add(view);
        this.f12938a.a(view);
    }

    private boolean t(View view) {
        if (!this.f12940c.remove(view)) {
            return false;
        }
        this.f12938a.g(view);
        return true;
    }

    void a(View view, int i5, boolean z5) {
        int childCount = i5 < 0 ? this.f12938a.getChildCount() : h(i5);
        this.f12939b.e(childCount, z5);
        if (z5) {
            l(view);
        }
        this.f12938a.d(view, childCount);
    }

    void b(View view, boolean z5) {
        a(view, -1, z5);
    }

    void c(View view, int i5, ViewGroup.LayoutParams layoutParams, boolean z5) {
        int childCount = i5 < 0 ? this.f12938a.getChildCount() : h(i5);
        this.f12939b.e(childCount, z5);
        if (z5) {
            l(view);
        }
        this.f12938a.i(view, childCount, layoutParams);
    }

    void d(int i5) {
        int h5 = h(i5);
        this.f12939b.f(h5);
        this.f12938a.c(h5);
    }

    View e(int i5) {
        int size = this.f12940c.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = (View) this.f12940c.get(i6);
            RecyclerView$a0 b5 = this.f12938a.b(view);
            if (b5.getLayoutPosition() == i5 && !b5.isInvalid() && !b5.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    View f(int i5) {
        return this.f12938a.getChildAt(h(i5));
    }

    int g() {
        return this.f12938a.getChildCount() - this.f12940c.size();
    }

    View i(int i5) {
        return this.f12938a.getChildAt(i5);
    }

    int j() {
        return this.f12938a.getChildCount();
    }

    void k(View view) {
        int f5 = this.f12938a.f(view);
        if (f5 >= 0) {
            this.f12939b.h(f5);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int m(View view) {
        int f5 = this.f12938a.f(view);
        if (f5 == -1 || this.f12939b.d(f5)) {
            return -1;
        }
        return f5 - this.f12939b.b(f5);
    }

    boolean n(View view) {
        return this.f12940c.contains(view);
    }

    void o() {
        this.f12939b.g();
        for (int size = this.f12940c.size() - 1; size >= 0; size--) {
            this.f12938a.g((View) this.f12940c.get(size));
            this.f12940c.remove(size);
        }
        this.f12938a.e();
    }

    void p(View view) {
        int f5 = this.f12938a.f(view);
        if (f5 < 0) {
            return;
        }
        if (this.f12939b.f(f5)) {
            t(view);
        }
        this.f12938a.h(f5);
    }

    void q(int i5) {
        int h5 = h(i5);
        View childAt = this.f12938a.getChildAt(h5);
        if (childAt == null) {
            return;
        }
        if (this.f12939b.f(h5)) {
            t(childAt);
        }
        this.f12938a.h(h5);
    }

    boolean r(View view) {
        int f5 = this.f12938a.f(view);
        if (f5 == -1) {
            t(view);
            return true;
        }
        if (!this.f12939b.d(f5)) {
            return false;
        }
        this.f12939b.f(f5);
        t(view);
        this.f12938a.h(f5);
        return true;
    }

    void s(View view) {
        int f5 = this.f12938a.f(view);
        if (f5 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f12939b.d(f5)) {
            this.f12939b.a(f5);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f12939b.toString() + ", hidden list:" + this.f12940c.size();
    }
}
