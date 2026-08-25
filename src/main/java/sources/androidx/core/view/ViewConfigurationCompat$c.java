package androidx.core.view;

import android.view.ViewConfiguration;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewConfigurationCompat$c {
    static int a(ViewConfiguration viewConfiguration, int i5, int i6, int i7) {
        return viewConfiguration.getScaledMaximumFlingVelocity(i5, i6, i7);
    }

    static int b(ViewConfiguration viewConfiguration, int i5, int i6, int i7) {
        return viewConfiguration.getScaledMinimumFlingVelocity(i5, i6, i7);
    }
}
