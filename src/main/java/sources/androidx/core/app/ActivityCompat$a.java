package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ActivityCompat$a {
    static void a(Activity activity) {
        activity.finishAfterTransition();
    }

    static void b(Activity activity) {
        activity.postponeEnterTransition();
    }

    static void c(Activity activity, SharedElementCallback sharedElementCallback) {
        activity.setEnterSharedElementCallback(sharedElementCallback);
    }

    static void d(Activity activity, SharedElementCallback sharedElementCallback) {
        activity.setExitSharedElementCallback(sharedElementCallback);
    }

    static void e(Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
