package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ActivityCompat$b {
    static void a(Object obj) {
        ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
    }

    static void b(Activity activity, String[] strArr, int i5) {
        activity.requestPermissions(strArr, i5);
    }

    static boolean c(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
