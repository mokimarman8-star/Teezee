package l0;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import androidx.core.view.inputmethod.EditorInfoCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class h implements LineHeightSpan {

    /* renamed from: a, reason: collision with root package name */
    private final float f16343a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16344b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16345c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f16346d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f16347e;

    /* renamed from: f, reason: collision with root package name */
    private final float f16348f;

    /* renamed from: g, reason: collision with root package name */
    private int f16349g = EditorInfoCompat.IME_FLAG_FORCE_ASCII;

    /* renamed from: h, reason: collision with root package name */
    private int f16350h = EditorInfoCompat.IME_FLAG_FORCE_ASCII;

    /* renamed from: i, reason: collision with root package name */
    private int f16351i = EditorInfoCompat.IME_FLAG_FORCE_ASCII;

    /* renamed from: j, reason: collision with root package name */
    private int f16352j = EditorInfoCompat.IME_FLAG_FORCE_ASCII;

    /* renamed from: k, reason: collision with root package name */
    private int f16353k;

    /* renamed from: l, reason: collision with root package name */
    private int f16354l;

    public h(float f5, int i5, int i6, boolean z5, boolean z6, float f6) {
        this.f16343a = f5;
        this.f16344b = i5;
        this.f16345c = i6;
        this.f16346d = z5;
        this.f16347e = z6;
        this.f16348f = f6;
        if ((0.0f > f6 || f6 > 1.0f) && f6 != -1.0f) {
            throw new IllegalStateException("topRatio should be in [0..1] range or -1");
        }
    }

    private final void a(Paint.FontMetricsInt fontMetricsInt) {
        int ceil = (int) Math.ceil(this.f16343a);
        int a5 = ceil - i.a(fontMetricsInt);
        float f5 = this.f16348f;
        if (f5 == -1.0f) {
            f5 = Math.abs(fontMetricsInt.ascent) / i.a(fontMetricsInt);
        }
        int ceil2 = (int) (a5 <= 0 ? Math.ceil(a5 * f5) : Math.ceil(a5 * (1.0f - f5)));
        int i5 = fontMetricsInt.descent;
        int i6 = ceil2 + i5;
        this.f16351i = i6;
        int i7 = i6 - ceil;
        this.f16350h = i7;
        if (this.f16346d) {
            i7 = fontMetricsInt.ascent;
        }
        this.f16349g = i7;
        if (this.f16347e) {
            i6 = i5;
        }
        this.f16352j = i6;
        this.f16353k = fontMetricsInt.ascent - i7;
        this.f16354l = i6 - i5;
    }

    public final h b(int i5, int i6, boolean z5) {
        return new h(this.f16343a, i5, i6, z5, this.f16347e, this.f16348f);
    }

    public final int c() {
        return this.f16353k;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i5, int i6, int i7, int i8, Paint.FontMetricsInt fontMetricsInt) {
        if (i.a(fontMetricsInt) <= 0) {
            return;
        }
        boolean z5 = i5 == this.f16344b;
        boolean z6 = i6 == this.f16345c;
        if (z5 && z6 && this.f16346d && this.f16347e) {
            return;
        }
        if (this.f16349g == Integer.MIN_VALUE) {
            a(fontMetricsInt);
        }
        fontMetricsInt.ascent = z5 ? this.f16349g : this.f16350h;
        fontMetricsInt.descent = z6 ? this.f16352j : this.f16351i;
    }

    public final int d() {
        return this.f16354l;
    }

    public final boolean e() {
        return this.f16347e;
    }
}
