package l0;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a extends MetricAffectingSpan {

    /* renamed from: a, reason: collision with root package name */
    private final float f16337a;

    public a(float f5) {
        this.f16337a = f5;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.baselineShift += (int) Math.ceil(textPaint.ascent() * this.f16337a);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.baselineShift += (int) Math.ceil(textPaint.ascent() * this.f16337a);
    }
}
