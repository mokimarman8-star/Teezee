package l0;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class n extends CharacterStyle {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f16372a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f16373b;

    public n(boolean z5, boolean z6) {
        this.f16372a = z5;
        this.f16373b = z6;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(this.f16372a);
        textPaint.setStrikeThruText(this.f16373b);
    }
}
