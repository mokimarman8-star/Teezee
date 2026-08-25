package k0;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f16072a = new m();

    private m() {
    }

    public final boolean a(Canvas canvas, Path path) {
        boolean clipOutPath;
        clipOutPath = canvas.clipOutPath(path);
        return clipOutPath;
    }

    public final boolean b(Canvas canvas, float f5, float f6, float f7, float f8) {
        boolean clipOutRect;
        clipOutRect = canvas.clipOutRect(f5, f6, f7, f8);
        return clipOutRect;
    }

    public final boolean c(Canvas canvas, int i5, int i6, int i7, int i8) {
        boolean clipOutRect;
        clipOutRect = canvas.clipOutRect(i5, i6, i7, i8);
        return clipOutRect;
    }

    public final boolean d(Canvas canvas, Rect rect) {
        boolean clipOutRect;
        clipOutRect = canvas.clipOutRect(rect);
        return clipOutRect;
    }

    public final boolean e(Canvas canvas, RectF rectF) {
        boolean clipOutRect;
        clipOutRect = canvas.clipOutRect(rectF);
        return clipOutRect;
    }
}
