package mh;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.transsion.core.log.ObjectLogUtils;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class o {
    public static ObjectLogUtils a = new ObjectLogUtils.a().p("NetworkMonitor").q(true).n(false).m();

    public static String a() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "persist.sys.oobe_country", TmcConstants.ROUTE_UNKNOWN);
        } catch (Exception e) {
            a.g(Log.getStackTraceString(e));
            str = "";
        }
        return (TextUtils.isEmpty(str) || TmcConstants.ROUTE_UNKNOWN.equals(str)) ? b().getCountry() : str;
    }

    private static Locale b() {
        try {
            return Build.VERSION.SDK_INT >= 24 ? n0.d.a(n0.b.a(), 0) : Locale.getDefault();
        } catch (Exception e) {
            Locale locale = Locale.getDefault();
            a.g(Log.getStackTraceString(e));
            return locale;
        }
    }
}
