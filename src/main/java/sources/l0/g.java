package l0;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class g implements LineHeightSpan {

    /* renamed from: a, reason: collision with root package name */
    private final float f16342a;

    public g(float f5) {
        this.f16342a = f5;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i5, int i6, int i7, int i8, Paint.FontMetricsInt fontMetricsInt) {
        if (i.a(fontMetricsInt) <= 0) {
            return;
        }
        int ceil = (int) Math.ceil(fontMetricsInt.descent * ((r4 * 1.0f) / r3));
        fontMetricsInt.descent = ceil;
        fontMetricsInt.ascent = ceil - ((int) Math.ceil(this.f16342a));
    }
}
