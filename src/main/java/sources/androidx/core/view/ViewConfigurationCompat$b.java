package androidx.core.view;

import android.view.ViewConfiguration;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewConfigurationCompat$b {
    static int a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHoverSlop();
    }

    static boolean b(ViewConfiguration viewConfiguration) {
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
}
