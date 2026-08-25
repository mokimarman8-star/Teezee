package androidx.recyclerview.widget;

import androidx.core.view.inputmethod.EditorInfoCompat;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class StaggeredGridLayoutManager$a {

    /* renamed from: a, reason: collision with root package name */
    int f12897a;

    /* renamed from: b, reason: collision with root package name */
    int f12898b;

    /* renamed from: c, reason: collision with root package name */
    boolean f12899c;

    /* renamed from: d, reason: collision with root package name */
    boolean f12900d;

    /* renamed from: e, reason: collision with root package name */
    boolean f12901e;

    /* renamed from: f, reason: collision with root package name */
    int[] f12902f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ StaggeredGridLayoutManager f12903g;

    StaggeredGridLayoutManager$a(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f12903g = staggeredGridLayoutManager;
        c();
    }

    void a() {
        this.f12898b = this.f12899c ? this.f12903g.c.i() : this.f12903g.c.m();
    }

    void b(int i5) {
        if (this.f12899c) {
            this.f12898b = this.f12903g.c.i() - i5;
        } else {
            this.f12898b = this.f12903g.c.m() + i5;
        }
    }

    void c() {
        this.f12897a = -1;
        this.f12898b = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        this.f12899c = false;
        this.f12900d = false;
        this.f12901e = false;
        int[] iArr = this.f12902f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }

    void d(StaggeredGridLayoutManager$c[] staggeredGridLayoutManager$cArr) {
        int length = staggeredGridLayoutManager$cArr.length;
        int[] iArr = this.f12902f;
        if (iArr == null || iArr.length < length) {
            this.f12902f = new int[this.f12903g.b.length];
        }
        for (int i5 = 0; i5 < length; i5++) {
            this.f12902f[i5] = staggeredGridLayoutManager$cArr[i5].t(EditorInfoCompat.IME_FLAG_FORCE_ASCII);
        }
    }
}
