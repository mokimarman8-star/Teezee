package k0;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class b1 {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f16000a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16001b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16002c;

    /* renamed from: d, reason: collision with root package name */
    private final TextPaint f16003d;

    /* renamed from: e, reason: collision with root package name */
    private final int f16004e;

    /* renamed from: f, reason: collision with root package name */
    private final TextDirectionHeuristic f16005f;

    /* renamed from: g, reason: collision with root package name */
    private final Layout.Alignment f16006g;

    /* renamed from: h, reason: collision with root package name */
    private final int f16007h;

    /* renamed from: i, reason: collision with root package name */
    private final TextUtils.TruncateAt f16008i;

    /* renamed from: j, reason: collision with root package name */
    private final int f16009j;

    /* renamed from: k, reason: collision with root package name */
    private final float f16010k;

    /* renamed from: l, reason: collision with root package name */
    private final float f16011l;

    /* renamed from: m, reason: collision with root package name */
    private final int f16012m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f16013n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f16014o;

    /* renamed from: p, reason: collision with root package name */
    private final int f16015p;

    /* renamed from: q, reason: collision with root package name */
    private final int f16016q;

    /* renamed from: r, reason: collision with root package name */
    private final int f16017r;

    /* renamed from: s, reason: collision with root package name */
    private final int f16018s;

    /* renamed from: t, reason: collision with root package name */
    private final int[] f16019t;

    /* renamed from: u, reason: collision with root package name */
    private final int[] f16020u;

    public b1(CharSequence charSequence, int i5, int i6, TextPaint textPaint, int i7, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i8, TextUtils.TruncateAt truncateAt, int i9, float f5, float f6, int i10, boolean z5, boolean z6, int i11, int i12, int i13, int i14, int[] iArr, int[] iArr2) {
        this.f16000a = charSequence;
        this.f16001b = i5;
        this.f16002c = i6;
        this.f16003d = textPaint;
        this.f16004e = i7;
        this.f16005f = textDirectionHeuristic;
        this.f16006g = alignment;
        this.f16007h = i8;
        this.f16008i = truncateAt;
        this.f16009j = i9;
        this.f16010k = f5;
        this.f16011l = f6;
        this.f16012m = i10;
        this.f16013n = z5;
        this.f16014o = z6;
        this.f16015p = i11;
        this.f16016q = i12;
        this.f16017r = i13;
        this.f16018s = i14;
        this.f16019t = iArr;
        this.f16020u = iArr2;
        if (i5 < 0 || i5 > i6) {
            throw new IllegalArgumentException("invalid start value");
        }
        int length = charSequence.length();
        if (i6 < 0 || i6 > length) {
            throw new IllegalArgumentException("invalid end value");
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("invalid maxLines value");
        }
        if (i7 < 0) {
            throw new IllegalArgumentException("invalid width value");
        }
        if (i9 < 0) {
            throw new IllegalArgumentException("invalid ellipsizedWidth value");
        }
        if (f5 < 0.0f) {
            throw new IllegalArgumentException("invalid lineSpacingMultiplier value");
        }
    }

    public final Layout.Alignment a() {
        return this.f16006g;
    }

    public final int b() {
        return this.f16015p;
    }

    public final TextUtils.TruncateAt c() {
        return this.f16008i;
    }

    public final int d() {
        return this.f16009j;
    }

    public final int e() {
        return this.f16002c;
    }

    public final int f() {
        return this.f16018s;
    }

    public final boolean g() {
        return this.f16013n;
    }

    public final int h() {
        return this.f16012m;
    }

    public final int[] i() {
        return this.f16019t;
    }

    public final int j() {
        return this.f16016q;
    }

    public final int k() {
        return this.f16017r;
    }

    public final float l() {
        return this.f16011l;
    }

    public final float m() {
        return this.f16010k;
    }

    public final int n() {
        return this.f16007h;
    }

    public final TextPaint o() {
        return this.f16003d;
    }

    public final int[] p() {
        return this.f16020u;
    }

    public final int q() {
        return this.f16001b;
    }

    public final CharSequence r() {
        return this.f16000a;
    }

    public final TextDirectionHeuristic s() {
        return this.f16005f;
    }

    public final boolean t() {
        return this.f16014o;
    }

    public final int u() {
        return this.f16004e;
    }
}
