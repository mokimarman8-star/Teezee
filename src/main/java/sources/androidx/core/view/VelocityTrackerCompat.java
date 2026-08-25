package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class VelocityTrackerCompat {
    private static Map<VelocityTracker, g0> sFallbackTrackers = Collections.synchronizedMap(new WeakHashMap());

    @Retention(RetentionPolicy.SOURCE)
    public @interface VelocityTrackableMotionEventAxis {
    }

    private static class a {
        static float a(VelocityTracker velocityTracker, int i5) {
            return velocityTracker.getAxisVelocity(i5);
        }

        static float b(VelocityTracker velocityTracker, int i5, int i6) {
            return velocityTracker.getAxisVelocity(i5, i6);
        }

        static boolean c(VelocityTracker velocityTracker, int i5) {
            return velocityTracker.isAxisSupported(i5);
        }
    }

    private VelocityTrackerCompat() {
    }

    public static void addMovement(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!sFallbackTrackers.containsKey(velocityTracker)) {
                sFallbackTrackers.put(velocityTracker, new g0());
            }
            sFallbackTrackers.get(velocityTracker).a(motionEvent);
        }
    }

    public static void clear(VelocityTracker velocityTracker) {
        velocityTracker.clear();
        removeFallbackForTracker(velocityTracker);
    }

    public static void computeCurrentVelocity(VelocityTracker velocityTracker, int i5) {
        computeCurrentVelocity(velocityTracker, i5, Float.MAX_VALUE);
    }

    public static void computeCurrentVelocity(VelocityTracker velocityTracker, int i5, float f5) {
        velocityTracker.computeCurrentVelocity(i5, f5);
        g0 fallbackTrackerOrNull = getFallbackTrackerOrNull(velocityTracker);
        if (fallbackTrackerOrNull != null) {
            fallbackTrackerOrNull.c(i5, f5);
        }
    }

    public static float getAxisVelocity(VelocityTracker velocityTracker, int i5) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(velocityTracker, i5);
        }
        if (i5 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i5 == 1) {
            return velocityTracker.getYVelocity();
        }
        g0 fallbackTrackerOrNull = getFallbackTrackerOrNull(velocityTracker);
        if (fallbackTrackerOrNull != null) {
            return fallbackTrackerOrNull.d(i5);
        }
        return 0.0f;
    }

    public static float getAxisVelocity(VelocityTracker velocityTracker, int i5, int i6) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.b(velocityTracker, i5, i6);
        }
        if (i5 == 0) {
            return velocityTracker.getXVelocity(i6);
        }
        if (i5 == 1) {
            return velocityTracker.getYVelocity(i6);
        }
        return 0.0f;
    }

    private static g0 getFallbackTrackerOrNull(VelocityTracker velocityTracker) {
        return sFallbackTrackers.get(velocityTracker);
    }

    @Deprecated
    public static float getXVelocity(VelocityTracker velocityTracker, int i5) {
        return velocityTracker.getXVelocity(i5);
    }

    @Deprecated
    public static float getYVelocity(VelocityTracker velocityTracker, int i5) {
        return velocityTracker.getYVelocity(i5);
    }

    public static boolean isAxisSupported(VelocityTracker velocityTracker, int i5) {
        return Build.VERSION.SDK_INT >= 34 ? a.c(velocityTracker, i5) : i5 == 26 || i5 == 0 || i5 == 1;
    }

    public static void recycle(VelocityTracker velocityTracker) {
        velocityTracker.recycle();
        removeFallbackForTracker(velocityTracker);
    }

    private static void removeFallbackForTracker(VelocityTracker velocityTracker) {
        sFallbackTrackers.remove(velocityTracker);
    }
}
