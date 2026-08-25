package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class i extends ReplacementSpan {

    /* renamed from: b, reason: collision with root package name */
    private final p f7916b;

    /* renamed from: a, reason: collision with root package name */
    private final Paint.FontMetricsInt f7915a = new Paint.FontMetricsInt();

    /* renamed from: c, reason: collision with root package name */
    private short f7917c = -1;

    /* renamed from: d, reason: collision with root package name */
    private short f7918d = -1;

    /* renamed from: e, reason: collision with root package name */
    private float f7919e = 1.0f;

    i(p pVar) {
        androidx.core.util.i.h(pVar, "rasterizer cannot be null");
        this.f7916b = pVar;
    }

    public final p a() {
        return this.f7916b;
    }

    final int b() {
        return this.f7917c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i5, int i6, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f7915a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f7915a;
        this.f7919e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f7916b.e();
        this.f7918d = (short) (this.f7916b.e() * this.f7919e);
        short i7 = (short) (this.f7916b.i() * this.f7919e);
        this.f7917c = i7;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f7915a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i7;
    }
}
