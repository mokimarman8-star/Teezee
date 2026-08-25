package di;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends CharacterStyle implements UpdateAppearance {
    private final int a;
    private final int b;
    private final String c;

    public b(int i, int i2, String str) {
        Intrinsics.h(str, "gradientText");
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.h(textPaint, "tp");
        textPaint.setShader(new LinearGradient(0.0f, 0.0f, textPaint.measureText(this.c), 0.0f, this.a, this.b, Shader.TileMode.CLAMP));
    }
}
