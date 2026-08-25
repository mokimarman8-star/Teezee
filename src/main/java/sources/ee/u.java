package ee;

import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.hisavana.mediation.config.ConfigContentHelper;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class u {
    public static void a() {
        com.cloud.sdk.commonutil.util.c.Log().i("TestChecker", "mediation execSQL delete");
        try {
            ConfigContentHelper.g().c();
        } catch (Exception e) {
            com.cloud.sdk.commonutil.util.c.Log().e("TestChecker", "mediation delete db fail = " + e.getMessage());
        }
    }

    public static void b(boolean z) {
        int g = l7.a.e().g("key_data_status", -1);
        boolean z2 = !z;
        com.cloud.sdk.commonutil.util.c.Log().i("TestChecker", "mediation sp save env status = " + g + " and isDebug = " + z);
        if (g == -1 || g == z2) {
            return;
        }
        HSScopeHelper.a.i(new Runnable() { // from class: ee.t
            @Override // java.lang.Runnable
            public final void run() {
                u.a();
            }
        });
    }
}
