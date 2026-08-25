package l0;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b extends MetricAffectingSpan {

    /* renamed from: a, reason: collision with root package name */
    private final String f16338a;

    public b(String str) {
        this.f16338a = str;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setFontFeatureSettings(this.f16338a);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setFontFeatureSettings(this.f16338a);
    }
}
