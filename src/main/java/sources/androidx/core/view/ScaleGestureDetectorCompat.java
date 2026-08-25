package androidx.core.view;

import android.view.ScaleGestureDetector;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ScaleGestureDetectorCompat {
    private ScaleGestureDetectorCompat() {
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector) {
        return scaleGestureDetector.isQuickScaleEnabled();
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object obj) {
        return isQuickScaleEnabled((ScaleGestureDetector) obj);
    }

    @Deprecated
    public static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector, boolean z5) {
        scaleGestureDetector.setQuickScaleEnabled(z5);
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object obj, boolean z5) {
        setQuickScaleEnabled((ScaleGestureDetector) obj, z5);
    }
}
