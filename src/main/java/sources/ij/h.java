package ij;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.mb.config.manager.ConfigBean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h {
    public static final h a = new h();
    private static Boolean b;

    private h() {
    }

    public final boolean a() {
        String str;
        Boolean bool = b;
        if (bool != null) {
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        try {
            tg.b bVar = tg.b.a;
            Application a2 = Utils.a();
            Intrinsics.g(a2, "getApp(...)");
            long j = bVar.k(a2).totalMem;
            ConfigBean c = cm.f.c.a().c("lowMemoryValue", true);
            if (c == null || (str = c.getValue()) == null) {
                str = "1.0";
            }
            if (j <= 1073741824 * Double.parseDouble(str)) {
                b = Boolean.TRUE;
            }
            Boolean bool2 = b;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
