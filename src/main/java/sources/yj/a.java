package yj;

import android.content.Context;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.core.utils.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    private static Context a;
    private static boolean b;
    private static boolean c;
    private static boolean d;

    public static Context a() {
        Context context = a;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("u should init first");
    }

    public static void b(Context context) {
        if (d()) {
            return;
        }
        d = true;
        a = context.getApplicationContext();
        DeviceInfo.d();
        f.a(a());
    }

    public static boolean c() {
        return b;
    }

    public static boolean d() {
        return d && a != null;
    }

    public static boolean e() {
        return c;
    }

    public static void f(boolean z) {
        b = z;
    }
}
