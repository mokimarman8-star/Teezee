package androidx.core.os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class t {

    static class a {
        static boolean a(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(context);
        }
        return true;
    }
}
