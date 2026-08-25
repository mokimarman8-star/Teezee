package u1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.media3.common.util.a1;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f17964a;

    /* renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f17965b;

    /* renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f17966c;

    /* renamed from: d, reason: collision with root package name */
    public final Bitmap f17967d;

    /* renamed from: e, reason: collision with root package name */
    public final float f17968e;

    /* renamed from: f, reason: collision with root package name */
    public final int f17969f;

    /* renamed from: g, reason: collision with root package name */
    public final int f17970g;

    /* renamed from: h, reason: collision with root package name */
    public final float f17971h;

    /* renamed from: i, reason: collision with root package name */
    public final int f17972i;

    /* renamed from: j, reason: collision with root package name */
    public final float f17973j;

    /* renamed from: k, reason: collision with root package name */
    public final float f17974k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f17975l;

    /* renamed from: m, reason: collision with root package name */
    public final int f17976m;

    /* renamed from: n, reason: collision with root package name */
    public final int f17977n;

    /* renamed from: o, reason: collision with root package name */
    public final float f17978o;

    /* renamed from: p, reason: collision with root package name */
    public final int f17979p;

    /* renamed from: q, reason: collision with root package name */
    public final float f17980q;

    /* renamed from: r, reason: collision with root package name */
    public static final a f17955r = new b().o("").a();

    /* renamed from: s, reason: collision with root package name */
    private static final String f17956s = a1.C0(0);

    /* renamed from: t, reason: collision with root package name */
    private static final String f17957t = a1.C0(17);

    /* renamed from: u, reason: collision with root package name */
    private static final String f17958u = a1.C0(1);

    /* renamed from: v, reason: collision with root package name */
    private static final String f17959v = a1.C0(2);

    /* renamed from: w, reason: collision with root package name */
    private static final String f17960w = a1.C0(3);

    /* renamed from: x, reason: collision with root package name */
    private static final String f17961x = a1.C0(18);

    /* renamed from: y, reason: collision with root package name */
    private static final String f17962y = a1.C0(4);

    /* renamed from: z, reason: collision with root package name */
    private static final String f17963z = a1.C0(5);
    private static final String A = a1.C0(6);
    private static final String B = a1.C0(7);
    private static final String C = a1.C0(8);
    private static final String D = a1.C0(9);
    private static final String E = a1.C0(10);
    private static final String F = a1.C0(11);
    private static final String G = a1.C0(12);
    private static final String H = a1.C0(13);
    private static final String I = a1.C0(14);
    private static final String J = a1.C0(15);
    private static final String K = a1.C0(16);

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private CharSequence f17981a;

        /* renamed from: b, reason: collision with root package name */
        private Bitmap f17982b;

        /* renamed from: c, reason: collision with root package name */
        private Layout.Alignment f17983c;

        /* renamed from: d, reason: collision with root package name */
        private Layout.Alignment f17984d;

        /* renamed from: e, reason: collision with root package name */
        private float f17985e;

        /* renamed from: f, reason: collision with root package name */
        private int f17986f;

        /* renamed from: g, reason: collision with root package name */
        private int f17987g;

        /* renamed from: h, reason: collision with root package name */
        private float f17988h;

        /* renamed from: i, reason: collision with root package name */
        private int f17989i;

        /* renamed from: j, reason: collision with root package name */
        private int f17990j;

        /* renamed from: k, reason: collision with root package name */
        private float f17991k;

        /* renamed from: l, reason: collision with root package name */
        private float f17992l;

        /* renamed from: m, reason: collision with root package name */
        private float f17993m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f17994n;

        /* renamed from: o, reason: collision with root package name */
        private int f17995o;

        /* renamed from: p, reason: collision with root package name */
        private int f17996p;

        /* renamed from: q, reason: collision with root package name */
        private float f17997q;

        public b() {
            this.f17981a = null;
            this.f17982b = null;
            this.f17983c = null;
            this.f17984d = null;
            this.f17985e = -3.4028235E38f;
            this.f17986f = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
            this.f17987g = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
            this.f17988h = -3.4028235E38f;
            this.f17989i = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
            this.f17990j = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
            this.f17991k = -3.4028235E38f;
            this.f17992l = -3.4028235E38f;
            this.f17993m = -3.4028235E38f;
            this.f17994n = false;
            this.f17995o = -16777216;
            this.f17996p = EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        }

        private b(a aVar) {
            this.f17981a = aVar.f17964a;
            this.f17982b = aVar.f17967d;
            this.f17983c = aVar.f17965b;
            this.f17984d = aVar.f17966c;
            this.f17985e = aVar.f17968e;
            this.f17986f = aVar.f17969f;
            this.f17987g = aVar.f17970g;
            this.f17988h = aVar.f17971h;
            this.f17989i = aVar.f17972i;
            this.f17990j = aVar.f17977n;
            this.f17991k = aVar.f17978o;
            this.f17992l = aVar.f17973j;
            this.f17993m = aVar.f17974k;
            this.f17994n = aVar.f17975l;
            this.f17995o = aVar.f17976m;
            this.f17996p = aVar.f17979p;
            this.f17997q = aVar.f17980q;
        }

        public a a() {
            return new a(this.f17981a, this.f17983c, this.f17984d, this.f17982b, this.f17985e, this.f17986f, this.f17987g, this.f17988h, this.f17989i, this.f17990j, this.f17991k, this.f17992l, this.f17993m, this.f17994n, this.f17995o, this.f17996p, this.f17997q);
        }

        public b b() {
            this.f17994n = false;
            return this;
        }

        public int c() {
            return this.f17987g;
        }

        public int d() {
            return this.f17989i;
        }

        public CharSequence e() {
            return this.f17981a;
        }

        public b f(Bitmap bitmap) {
            this.f17982b = bitmap;
            return this;
        }

        public b g(float f5) {
            this.f17993m = f5;
            return this;
        }

        public b h(float f5, int i5) {
            this.f17985e = f5;
            this.f17986f = i5;
            return this;
        }

        public b i(int i5) {
            this.f17987g = i5;
            return this;
        }

        public b j(Layout.Alignment alignment) {
            this.f17984d = alignment;
            return this;
        }

        public b k(float f5) {
            this.f17988h = f5;
            return this;
        }

        public b l(int i5) {
            this.f17989i = i5;
            return this;
        }

        public b m(float f5) {
            this.f17997q = f5;
            return this;
        }

        public b n(float f5) {
            this.f17992l = f5;
            return this;
        }

        public b o(CharSequence charSequence) {
            this.f17981a = charSequence;
            return this;
        }

        public b p(Layout.Alignment alignment) {
            this.f17983c = alignment;
            return this;
        }

        public b q(float f5, int i5) {
            this.f17991k = f5;
            this.f17990j = i5;
            return this;
        }

        public b r(int i5) {
            this.f17996p = i5;
            return this;
        }

        public b s(int i5) {
            this.f17995o = i5;
            this.f17994n = true;
            return this;
        }
    }

    private a(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f5, int i5, int i6, float f6, int i7, int i8, float f7, float f8, float f9, boolean z5, int i9, int i10, float f10) {
        if (charSequence == null) {
            androidx.media3.common.util.a.e(bitmap);
        } else {
            androidx.media3.common.util.a.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f17964a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f17964a = charSequence.toString();
        } else {
            this.f17964a = null;
        }
        this.f17965b = alignment;
        this.f17966c = alignment2;
        this.f17967d = bitmap;
        this.f17968e = f5;
        this.f17969f = i5;
        this.f17970g = i6;
        this.f17971h = f6;
        this.f17972i = i7;
        this.f17973j = f8;
        this.f17974k = f9;
        this.f17975l = z5;
        this.f17976m = i9;
        this.f17977n = i8;
        this.f17978o = f7;
        this.f17979p = i10;
        this.f17980q = f10;
    }

    public static a b(Bundle bundle) {
        b bVar = new b();
        CharSequence charSequence = bundle.getCharSequence(f17956s);
        if (charSequence != null) {
            bVar.o(charSequence);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(f17957t);
            if (parcelableArrayList != null) {
                SpannableString valueOf = SpannableString.valueOf(charSequence);
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    c.c((Bundle) it.next(), valueOf);
                }
                bVar.o(valueOf);
            }
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(f17958u);
        if (alignment != null) {
            bVar.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(f17959v);
        if (alignment2 != null) {
            bVar.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(f17960w);
        if (bitmap != null) {
            bVar.f(bitmap);
        } else {
            byte[] byteArray = bundle.getByteArray(f17961x);
            if (byteArray != null) {
                bVar.f(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
            }
        }
        String str = f17962y;
        if (bundle.containsKey(str)) {
            String str2 = f17963z;
            if (bundle.containsKey(str2)) {
                bVar.h(bundle.getFloat(str), bundle.getInt(str2));
            }
        }
        String str3 = A;
        if (bundle.containsKey(str3)) {
            bVar.i(bundle.getInt(str3));
        }
        String str4 = B;
        if (bundle.containsKey(str4)) {
            bVar.k(bundle.getFloat(str4));
        }
        String str5 = C;
        if (bundle.containsKey(str5)) {
            bVar.l(bundle.getInt(str5));
        }
        String str6 = E;
        if (bundle.containsKey(str6)) {
            String str7 = D;
            if (bundle.containsKey(str7)) {
                bVar.q(bundle.getFloat(str6), bundle.getInt(str7));
            }
        }
        String str8 = F;
        if (bundle.containsKey(str8)) {
            bVar.n(bundle.getFloat(str8));
        }
        String str9 = G;
        if (bundle.containsKey(str9)) {
            bVar.g(bundle.getFloat(str9));
        }
        String str10 = H;
        if (bundle.containsKey(str10)) {
            bVar.s(bundle.getInt(str10));
        }
        if (!bundle.getBoolean(I, false)) {
            bVar.b();
        }
        String str11 = J;
        if (bundle.containsKey(str11)) {
            bVar.r(bundle.getInt(str11));
        }
        String str12 = K;
        if (bundle.containsKey(str12)) {
            bVar.m(bundle.getFloat(str12));
        }
        return bVar.a();
    }

    private Bundle c() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.f17964a;
        if (charSequence != null) {
            bundle.putCharSequence(f17956s, charSequence);
            CharSequence charSequence2 = this.f17964a;
            if (charSequence2 instanceof Spanned) {
                ArrayList<? extends Parcelable> a5 = c.a((Spanned) charSequence2);
                if (!a5.isEmpty()) {
                    bundle.putParcelableArrayList(f17957t, a5);
                }
            }
        }
        bundle.putSerializable(f17958u, this.f17965b);
        bundle.putSerializable(f17959v, this.f17966c);
        bundle.putFloat(f17962y, this.f17968e);
        bundle.putInt(f17963z, this.f17969f);
        bundle.putInt(A, this.f17970g);
        bundle.putFloat(B, this.f17971h);
        bundle.putInt(C, this.f17972i);
        bundle.putInt(D, this.f17977n);
        bundle.putFloat(E, this.f17978o);
        bundle.putFloat(F, this.f17973j);
        bundle.putFloat(G, this.f17974k);
        bundle.putBoolean(I, this.f17975l);
        bundle.putInt(H, this.f17976m);
        bundle.putInt(J, this.f17979p);
        bundle.putFloat(K, this.f17980q);
        return bundle;
    }

    public b a() {
        return new b();
    }

    public Bundle d() {
        Bundle c5 = c();
        if (this.f17967d != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            androidx.media3.common.util.a.g(this.f17967d.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
            c5.putByteArray(f17961x, byteArrayOutputStream.toByteArray());
        }
        return c5;
    }

    public boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f17964a, aVar.f17964a) && this.f17965b == aVar.f17965b && this.f17966c == aVar.f17966c && ((bitmap = this.f17967d) != null ? !((bitmap2 = aVar.f17967d) == null || !bitmap.sameAs(bitmap2)) : aVar.f17967d == null) && this.f17968e == aVar.f17968e && this.f17969f == aVar.f17969f && this.f17970g == aVar.f17970g && this.f17971h == aVar.f17971h && this.f17972i == aVar.f17972i && this.f17973j == aVar.f17973j && this.f17974k == aVar.f17974k && this.f17975l == aVar.f17975l && this.f17976m == aVar.f17976m && this.f17977n == aVar.f17977n && this.f17978o == aVar.f17978o && this.f17979p == aVar.f17979p && this.f17980q == aVar.f17980q;
    }

    public int hashCode() {
        return Objects.hash(this.f17964a, this.f17965b, this.f17966c, this.f17967d, Float.valueOf(this.f17968e), Integer.valueOf(this.f17969f), Integer.valueOf(this.f17970g), Float.valueOf(this.f17971h), Integer.valueOf(this.f17972i), Float.valueOf(this.f17973j), Float.valueOf(this.f17974k), Boolean.valueOf(this.f17975l), Integer.valueOf(this.f17976m), Integer.valueOf(this.f17977n), Float.valueOf(this.f17978o), Integer.valueOf(this.f17979p), Float.valueOf(this.f17980q));
    }
}
