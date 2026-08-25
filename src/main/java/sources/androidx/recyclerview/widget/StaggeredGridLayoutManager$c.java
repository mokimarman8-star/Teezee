package androidx.recyclerview.widget;

import android.view.View;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class StaggeredGridLayoutManager$c {

    /* renamed from: a, reason: collision with root package name */
    ArrayList f12906a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    int f12907b = EditorInfoCompat.IME_FLAG_FORCE_ASCII;

    /* renamed from: c, reason: collision with root package name */
    int f12908c = EditorInfoCompat.IME_FLAG_FORCE_ASCII;

    /* renamed from: d, reason: collision with root package name */
    int f12909d = 0;

    /* renamed from: e, reason: collision with root package name */
    final int f12910e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ StaggeredGridLayoutManager f12911f;

    StaggeredGridLayoutManager$c(StaggeredGridLayoutManager staggeredGridLayoutManager, int i5) {
        this.f12911f = staggeredGridLayoutManager;
        this.f12910e = i5;
    }

    void a(View view) {
        StaggeredGridLayoutManager$b r5 = r(view);
        r5.f12904a = this;
        this.f12906a.add(view);
        this.f12908c = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        if (this.f12906a.size() == 1) {
            this.f12907b = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        }
        if (r5.isItemRemoved() || r5.isItemChanged()) {
            this.f12909d += this.f12911f.c.e(view);
        }
    }

    void b(boolean z5, int i5) {
        int p5 = z5 ? p(EditorInfoCompat.IME_FLAG_FORCE_ASCII) : t(EditorInfoCompat.IME_FLAG_FORCE_ASCII);
        e();
        if (p5 == Integer.MIN_VALUE) {
            return;
        }
        if (!z5 || p5 >= this.f12911f.c.i()) {
            if (z5 || p5 <= this.f12911f.c.m()) {
                if (i5 != Integer.MIN_VALUE) {
                    p5 += i5;
                }
                this.f12908c = p5;
                this.f12907b = p5;
            }
        }
    }

    void c() {
        StaggeredGridLayoutManager$LazySpanLookup.FullSpanItem f5;
        ArrayList arrayList = this.f12906a;
        View view = (View) arrayList.get(arrayList.size() - 1);
        StaggeredGridLayoutManager$b r5 = r(view);
        this.f12908c = this.f12911f.c.d(view);
        if (r5.f12905b && (f5 = this.f12911f.m.f(r5.getViewLayoutPosition())) != null && f5.f12894b == 1) {
            this.f12908c += f5.a(this.f12910e);
        }
    }

    void d() {
        StaggeredGridLayoutManager$LazySpanLookup.FullSpanItem f5;
        View view = (View) this.f12906a.get(0);
        StaggeredGridLayoutManager$b r5 = r(view);
        this.f12907b = this.f12911f.c.g(view);
        if (r5.f12905b && (f5 = this.f12911f.m.f(r5.getViewLayoutPosition())) != null && f5.f12894b == -1) {
            this.f12907b -= f5.a(this.f12910e);
        }
    }

    void e() {
        this.f12906a.clear();
        u();
        this.f12909d = 0;
    }

    public int f() {
        return this.f12911f.h ? l(this.f12906a.size() - 1, -1, true) : l(0, this.f12906a.size(), true);
    }

    public int g() {
        return this.f12911f.h ? m(this.f12906a.size() - 1, -1, false) : m(0, this.f12906a.size(), false);
    }

    public int h() {
        return this.f12911f.h ? m(0, this.f12906a.size(), true) : m(this.f12906a.size() - 1, -1, true);
    }

    public int i() {
        return this.f12911f.h ? l(0, this.f12906a.size(), true) : l(this.f12906a.size() - 1, -1, true);
    }

    public int j() {
        return this.f12911f.h ? m(0, this.f12906a.size(), false) : m(this.f12906a.size() - 1, -1, false);
    }

    int k(int i5, int i6, boolean z5, boolean z6, boolean z7) {
        int m5 = this.f12911f.c.m();
        int i7 = this.f12911f.c.i();
        int i8 = i6 > i5 ? 1 : -1;
        while (i5 != i6) {
            View view = (View) this.f12906a.get(i5);
            int g5 = this.f12911f.c.g(view);
            int d5 = this.f12911f.c.d(view);
            boolean z8 = false;
            boolean z9 = !z7 ? g5 >= i7 : g5 > i7;
            if (!z7 ? d5 > m5 : d5 >= m5) {
                z8 = true;
            }
            if (z9 && z8) {
                if (z5 && z6) {
                    if (g5 >= m5 && d5 <= i7) {
                        return this.f12911f.getPosition(view);
                    }
                } else {
                    if (z6) {
                        return this.f12911f.getPosition(view);
                    }
                    if (g5 < m5 || d5 > i7) {
                        return this.f12911f.getPosition(view);
                    }
                }
            }
            i5 += i8;
        }
        return -1;
    }

    int l(int i5, int i6, boolean z5) {
        return k(i5, i6, false, false, z5);
    }

    int m(int i5, int i6, boolean z5) {
        return k(i5, i6, z5, true, false);
    }

    public int n() {
        return this.f12909d;
    }

    int o() {
        int i5 = this.f12908c;
        if (i5 != Integer.MIN_VALUE) {
            return i5;
        }
        c();
        return this.f12908c;
    }

    int p(int i5) {
        int i6 = this.f12908c;
        if (i6 != Integer.MIN_VALUE) {
            return i6;
        }
        if (this.f12906a.size() == 0) {
            return i5;
        }
        c();
        return this.f12908c;
    }

    public View q(int i5, int i6) {
        View view = null;
        if (i6 != -1) {
            int size = this.f12906a.size() - 1;
            while (size >= 0) {
                View view2 = (View) this.f12906a.get(size);
                StaggeredGridLayoutManager staggeredGridLayoutManager = this.f12911f;
                if (staggeredGridLayoutManager.h && staggeredGridLayoutManager.getPosition(view2) >= i5) {
                    break;
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager2 = this.f12911f;
                if ((!staggeredGridLayoutManager2.h && staggeredGridLayoutManager2.getPosition(view2) <= i5) || !view2.hasFocusable()) {
                    break;
                }
                size--;
                view = view2;
            }
        } else {
            int size2 = this.f12906a.size();
            int i7 = 0;
            while (i7 < size2) {
                View view3 = (View) this.f12906a.get(i7);
                StaggeredGridLayoutManager staggeredGridLayoutManager3 = this.f12911f;
                if (staggeredGridLayoutManager3.h && staggeredGridLayoutManager3.getPosition(view3) <= i5) {
                    break;
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager4 = this.f12911f;
                if ((!staggeredGridLayoutManager4.h && staggeredGridLayoutManager4.getPosition(view3) >= i5) || !view3.hasFocusable()) {
                    break;
                }
                i7++;
                view = view3;
            }
        }
        return view;
    }

    StaggeredGridLayoutManager$b r(View view) {
        return (StaggeredGridLayoutManager$b) view.getLayoutParams();
    }

    int s() {
        int i5 = this.f12907b;
        if (i5 != Integer.MIN_VALUE) {
            return i5;
        }
        d();
        return this.f12907b;
    }

    int t(int i5) {
        int i6 = this.f12907b;
        if (i6 != Integer.MIN_VALUE) {
            return i6;
        }
        if (this.f12906a.size() == 0) {
            return i5;
        }
        d();
        return this.f12907b;
    }

    void u() {
        this.f12907b = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f12908c = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
    }

    void v(int i5) {
        int i6 = this.f12907b;
        if (i6 != Integer.MIN_VALUE) {
            this.f12907b = i6 + i5;
        }
        int i7 = this.f12908c;
        if (i7 != Integer.MIN_VALUE) {
            this.f12908c = i7 + i5;
        }
    }

    void w() {
        int size = this.f12906a.size();
        View view = (View) this.f12906a.remove(size - 1);
        StaggeredGridLayoutManager$b r5 = r(view);
        r5.f12904a = null;
        if (r5.isItemRemoved() || r5.isItemChanged()) {
            this.f12909d -= this.f12911f.c.e(view);
        }
        if (size == 1) {
            this.f12907b = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        }
        this.f12908c = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
    }

    void x() {
        View view = (View) this.f12906a.remove(0);
        StaggeredGridLayoutManager$b r5 = r(view);
        r5.f12904a = null;
        if (this.f12906a.size() == 0) {
            this.f12908c = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        }
        if (r5.isItemRemoved() || r5.isItemChanged()) {
            this.f12909d -= this.f12911f.c.e(view);
        }
        this.f12907b = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
    }

    void y(View view) {
        StaggeredGridLayoutManager$b r5 = r(view);
        r5.f12904a = this;
        this.f12906a.add(0, view);
        this.f12907b = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        if (this.f12906a.size() == 1) {
            this.f12908c = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        }
        if (r5.isItemRemoved() || r5.isItemChanged()) {
            this.f12909d += this.f12911f.c.e(view);
        }
    }

    void z(int i5) {
        this.f12907b = i5;
        this.f12908c = i5;
    }
}
