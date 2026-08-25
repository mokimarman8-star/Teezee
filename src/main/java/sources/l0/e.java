package l0;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e extends MetricAffectingSpan {

    /* renamed from: a, reason: collision with root package name */
    private final float f16340a;

    public e(float f5) {
        this.f16340a = f5;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setLetterSpacing(this.f16340a);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setLetterSpacing(this.f16340a);
    }
}
