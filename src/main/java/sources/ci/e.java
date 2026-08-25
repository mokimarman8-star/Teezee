package ci;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import com.transsion.gslb.BuildConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    public final boolean a(Context context, String str) {
        PackageManager packageManager;
        PackageManager.PackageInfoFlags of;
        if (str == null || str.length() == 0 || context == null || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                of = PackageManager.PackageInfoFlags.of(0L);
                packageManager.getPackageInfo(str, of);
            } else {
                packageManager.getPackageInfo(str, 0);
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final boolean b(Context context, String str) {
        Intent intent;
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            intent = null;
        } else {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            intent = packageManager.getLaunchIntentForPackage(str);
        }
        if (intent == null) {
            return false;
        }
        context.startActivity(intent);
        return true;
    }
}
