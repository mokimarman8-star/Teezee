package androidx.compose.ui.text.platform;

import android.text.TextPaint;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f {
    public static final void a(TextPaint textPaint, float f5) {
        if (Float.isNaN(f5)) {
            return;
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        textPaint.setAlpha(Math.round(f5 * 255));
    }
}
