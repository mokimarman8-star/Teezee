package androidx.appcompat.app;

import android.os.PowerManager;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class AppCompatDelegateImpl$h {
    static boolean a(PowerManager powerManager) {
        return powerManager.isPowerSaveMode();
    }

    static String b(Locale locale) {
        return locale.toLanguageTag();
    }
}
