package l0;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class m extends MetricAffectingSpan {

    /* renamed from: a, reason: collision with root package name */
    private final float f16371a;

    public m(float f5) {
        this.f16371a = f5;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTextSkewX(this.f16371a + textPaint.getTextSkewX());
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTextSkewX(this.f16371a + textPaint.getTextSkewX());
    }
}
