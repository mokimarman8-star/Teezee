package k0;

import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f16063a = new g();

    private g() {
    }

    public final void a(Canvas canvas, CharSequence charSequence, int i5, int i6, int i7, int i8, float f5, float f6, boolean z5, Paint paint) {
        canvas.drawTextRun(charSequence, i5, i6, i7, i8, f5, f6, z5, paint);
    }

    public final void b(Canvas canvas, char[] cArr, int i5, int i6, int i7, int i8, float f5, float f6, boolean z5, Paint paint) {
        canvas.drawTextRun(cArr, i5, i6, i7, i8, f5, f6, z5, paint);
    }
}
