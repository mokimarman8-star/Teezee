package k0;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final w f16076a = new w();

    private w() {
    }

    public final boolean a(Canvas canvas, float f5, float f6, float f7, float f8) {
        boolean quickReject;
        quickReject = canvas.quickReject(f5, f6, f7, f8);
        return quickReject;
    }

    public final boolean b(Canvas canvas, Path path) {
        boolean quickReject;
        quickReject = canvas.quickReject(path);
        return quickReject;
    }

    public final boolean c(Canvas canvas, RectF rectF) {
        boolean quickReject;
        quickReject = canvas.quickReject(rectF);
        return quickReject;
    }
}
