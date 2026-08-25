package x0;

import android.content.pm.PackageInfo;
import android.os.Build;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {

    /* renamed from: x0.a$a, reason: collision with other inner class name */
    private static class C0182a {
        static long a(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }
    }

    public static long a(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? C0182a.a(packageInfo) : packageInfo.versionCode;
    }
}
