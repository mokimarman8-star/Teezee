package bf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class f {
    private static String a(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        return c(context, null);
    }

    public static String c(Context context, String str) {
        b d = d(context);
        return d == null ? str : d.a();
    }

    public static b d(Context context) {
        String a = a(context);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        return c.a(new File(a));
    }
}
