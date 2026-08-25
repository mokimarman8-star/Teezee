package ra;

import android.graphics.Canvas;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a {

    /* renamed from: ra.a$a, reason: collision with other inner class name */
    public interface InterfaceC0198a {
        void a(Canvas canvas);
    }

    public static int a(Canvas canvas, float f, float f2, float f3, float f4, int i) {
        return canvas.saveLayerAlpha(f, f2, f3, f4, i);
    }
}
