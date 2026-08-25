package l0;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class l extends CharacterStyle {

    /* renamed from: a, reason: collision with root package name */
    private final int f16367a;

    /* renamed from: b, reason: collision with root package name */
    private final float f16368b;

    /* renamed from: c, reason: collision with root package name */
    private final float f16369c;

    /* renamed from: d, reason: collision with root package name */
    private final float f16370d;

    public l(int i5, float f5, float f6, float f7) {
        this.f16367a = i5;
        this.f16368b = f5;
        this.f16369c = f6;
        this.f16370d = f7;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(this.f16370d, this.f16368b, this.f16369c, this.f16367a);
    }
}
