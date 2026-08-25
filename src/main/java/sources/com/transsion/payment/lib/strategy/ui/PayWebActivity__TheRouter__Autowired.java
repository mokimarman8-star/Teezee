package com.transsion.payment.lib.strategy.ui;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import mf.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class PayWebActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof PayWebActivity) {
            PayWebActivity payWebActivity = (PayWebActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    String str = (String) aVar.a("java.lang.String", payWebActivity, new b("java.lang.String", "page_from", 0, BuildConfig.FLAVOR, "com.transsion.payment.lib.strategy.ui.PayWebActivity", "pageFrom", false, "No desc."));
                    if (str != null) {
                        payWebActivity.pageFrom = str;
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", payWebActivity, new b("java.lang.String", "url", 0, BuildConfig.FLAVOR, "com.transsion.payment.lib.strategy.ui.PayWebActivity", "url", false, "No desc."));
                    if (str2 != null) {
                        payWebActivity.url = str2;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
