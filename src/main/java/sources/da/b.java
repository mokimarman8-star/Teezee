package da;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import com.google.android.exoplayer2.k;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b implements com.google.android.exoplayer2.k {
    public static final b r = new C0042b().o("").a();
    public static final k.a s = new k.a() { // from class: da.a
        public final com.google.android.exoplayer2.k a(Bundle bundle) {
            b c;
            c = b.c(bundle);
            return c;
        }
    };
    public final CharSequence a;
    public final Layout.Alignment b;
    public final Layout.Alignment c;
    public final Bitmap d;
    public final float e;
    public final int f;
    public final int g;
    public final float h;
    public final int i;
    public final float j;
    public final float k;
    public final boolean l;
    public final int m;
    public final int n;
    public final float o;
    public final int p;
    public final float q;

    /* renamed from: da.b$b, reason: collision with other inner class name */
    public static final class C0042b {
        private CharSequence a;
        private Bitmap b;
        private Layout.Alignment c;
        private Layout.Alignment d;
        private float e;
        private int f;
        private int g;
        private float h;
        private int i;
        private int j;
        private float k;
        private float l;
        private float m;
        private boolean n;
        private int o;
        private int p;
        private float q;

        public C0042b() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = -3.4028235E38f;
            this.f = Integer.MIN_VALUE;
            this.g = Integer.MIN_VALUE;
            this.h = -3.4028235E38f;
            this.i = Integer.MIN_VALUE;
            this.j = Integer.MIN_VALUE;
            this.k = -3.4028235E38f;
            this.l = -3.4028235E38f;
            this.m = -3.4028235E38f;
            this.n = false;
            this.o = -16777216;
            this.p = Integer.MIN_VALUE;
        }

        private C0042b(b bVar) {
            this.a = bVar.a;
            this.b = bVar.d;
            this.c = bVar.b;
            this.d = bVar.c;
            this.e = bVar.e;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.n;
            this.k = bVar.o;
            this.l = bVar.j;
            this.m = bVar.k;
            this.n = bVar.l;
            this.o = bVar.m;
            this.p = bVar.p;
            this.q = bVar.q;
        }

        public b a() {
            return new b(this.a, this.c, this.d, this.b, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q);
        }

        public C0042b b() {
            this.n = false;
            return this;
        }

        public int c() {
            return this.g;
        }

        public int d() {
            return this.i;
        }

        public CharSequence e() {
            return this.a;
        }

        public C0042b f(Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        public C0042b g(float f) {
            this.m = f;
            return this;
        }

        public C0042b h(float f, int i) {
            this.e = f;
            this.f = i;
            return this;
        }

        public C0042b i(int i) {
            this.g = i;
            return this;
        }

        public C0042b j(Layout.Alignment alignment) {
            this.d = alignment;
            return this;
        }

        public C0042b k(float f) {
            this.h = f;
            return this;
        }

        public C0042b l(int i) {
            this.i = i;
            return this;
        }

        public C0042b m(float f) {
            this.q = f;
            return this;
        }

        public C0042b n(float f) {
            this.l = f;
            return this;
        }

        public C0042b o(CharSequence charSequence) {
            this.a = charSequence;
            return this;
        }

        public C0042b p(Layout.Alignment alignment) {
            this.c = alignment;
            return this;
        }

        public C0042b q(float f, int i) {
            this.k = f;
            this.j = i;
            return this;
        }

        public C0042b r(int i) {
            this.p = i;
            return this;
        }

        public C0042b s(int i) {
            this.o = i;
            this.n = true;
            return this;
        }
    }

    private b(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z, int i5, int i6, float f6) {
        if (charSequence == null) {
            com.google.android.exoplayer2.util.a.e(bitmap);
        } else {
            com.google.android.exoplayer2.util.a.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.a = charSequence.toString();
        } else {
            this.a = null;
        }
        this.b = alignment;
        this.c = alignment2;
        this.d = bitmap;
        this.e = f;
        this.f = i;
        this.g = i2;
        this.h = f2;
        this.i = i3;
        this.j = f4;
        this.k = f5;
        this.l = z;
        this.m = i5;
        this.n = i4;
        this.o = f3;
        this.p = i6;
        this.q = f6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b c(Bundle bundle) {
        C0042b c0042b = new C0042b();
        CharSequence charSequence = bundle.getCharSequence(d(0));
        if (charSequence != null) {
            c0042b.o(charSequence);
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(d(1));
        if (alignment != null) {
            c0042b.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(d(2));
        if (alignment2 != null) {
            c0042b.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(d(3));
        if (bitmap != null) {
            c0042b.f(bitmap);
        }
        if (bundle.containsKey(d(4)) && bundle.containsKey(d(5))) {
            c0042b.h(bundle.getFloat(d(4)), bundle.getInt(d(5)));
        }
        if (bundle.containsKey(d(6))) {
            c0042b.i(bundle.getInt(d(6)));
        }
        if (bundle.containsKey(d(7))) {
            c0042b.k(bundle.getFloat(d(7)));
        }
        if (bundle.containsKey(d(8))) {
            c0042b.l(bundle.getInt(d(8)));
        }
        if (bundle.containsKey(d(10)) && bundle.containsKey(d(9))) {
            c0042b.q(bundle.getFloat(d(10)), bundle.getInt(d(9)));
        }
        if (bundle.containsKey(d(11))) {
            c0042b.n(bundle.getFloat(d(11)));
        }
        if (bundle.containsKey(d(12))) {
            c0042b.g(bundle.getFloat(d(12)));
        }
        if (bundle.containsKey(d(13))) {
            c0042b.s(bundle.getInt(d(13)));
        }
        if (!bundle.getBoolean(d(14), false)) {
            c0042b.b();
        }
        if (bundle.containsKey(d(15))) {
            c0042b.r(bundle.getInt(d(15)));
        }
        if (bundle.containsKey(d(16))) {
            c0042b.m(bundle.getFloat(d(16)));
        }
        return c0042b.a();
    }

    private static String d(int i) {
        return Integer.toString(i, 36);
    }

    public C0042b b() {
        return new C0042b();
    }

    public boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return TextUtils.equals(this.a, bVar.a) && this.b == bVar.b && this.c == bVar.c && ((bitmap = this.d) != null ? !((bitmap2 = bVar.d) == null || !bitmap.sameAs(bitmap2)) : bVar.d == null) && this.e == bVar.e && this.f == bVar.f && this.g == bVar.g && this.h == bVar.h && this.i == bVar.i && this.j == bVar.j && this.k == bVar.k && this.l == bVar.l && this.m == bVar.m && this.n == bVar.n && this.o == bVar.o && this.p == bVar.p && this.q == bVar.q;
    }

    public int hashCode() {
        return com.google.common.base.j.b(new Object[]{this.a, this.b, this.c, this.d, Float.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Float.valueOf(this.h), Integer.valueOf(this.i), Float.valueOf(this.j), Float.valueOf(this.k), Boolean.valueOf(this.l), Integer.valueOf(this.m), Integer.valueOf(this.n), Float.valueOf(this.o), Integer.valueOf(this.p), Float.valueOf(this.q)});
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(d(0), this.a);
        bundle.putSerializable(d(1), this.b);
        bundle.putSerializable(d(2), this.c);
        bundle.putParcelable(d(3), this.d);
        bundle.putFloat(d(4), this.e);
        bundle.putInt(d(5), this.f);
        bundle.putInt(d(6), this.g);
        bundle.putFloat(d(7), this.h);
        bundle.putInt(d(8), this.i);
        bundle.putInt(d(9), this.n);
        bundle.putFloat(d(10), this.o);
        bundle.putFloat(d(11), this.j);
        bundle.putFloat(d(12), this.k);
        bundle.putBoolean(d(14), this.l);
        bundle.putInt(d(13), this.m);
        bundle.putInt(d(15), this.p);
        bundle.putFloat(d(16), this.q);
        return bundle;
    }
}
