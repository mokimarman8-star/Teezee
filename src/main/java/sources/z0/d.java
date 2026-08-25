package z0;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import androidx.core.graphics.BlendModeCompat;
import z0.a;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f18722a = new ThreadLocal();

    static class a {
        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    static class b {
        static void a(Paint paint, Object obj) {
            paint.setBlendMode((BlendMode) obj);
        }
    }

    public static boolean a(Paint paint, String str) {
        return a.a(paint, str);
    }

    public static boolean b(Paint paint, BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.a(paint, blendModeCompat != null ? a.b.a(blendModeCompat) : null);
            return true;
        }
        if (blendModeCompat == null) {
            paint.setXfermode(null);
            return true;
        }
        PorterDuff.Mode a5 = z0.a.a(blendModeCompat);
        paint.setXfermode(a5 != null ? new PorterDuffXfermode(a5) : null);
        return a5 != null;
    }
}
