package androidx.core.view;

import android.view.ViewConfiguration;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewConfigurationCompat$a {
    static float a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    static float b(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }
}
