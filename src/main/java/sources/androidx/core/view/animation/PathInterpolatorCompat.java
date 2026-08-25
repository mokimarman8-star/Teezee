package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class PathInterpolatorCompat {

    static class a {
        static Interpolator a(float f5, float f6) {
            return new PathInterpolator(f5, f6);
        }

        static Interpolator b(float f5, float f6, float f7, float f8) {
            return new PathInterpolator(f5, f6, f7, f8);
        }

        static Interpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    private PathInterpolatorCompat() {
    }

    public static Interpolator create(float f5, float f6) {
        return a.a(f5, f6);
    }

    public static Interpolator create(float f5, float f6, float f7, float f8) {
        return a.b(f5, f6, f7, f8);
    }

    public static Interpolator create(Path path) {
        return a.c(path);
    }
}
