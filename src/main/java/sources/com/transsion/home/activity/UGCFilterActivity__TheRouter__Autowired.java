package com.transsion.home.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import mf.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class UGCFilterActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof UGCFilterActivity) {
            UGCFilterActivity uGCFilterActivity = (UGCFilterActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    Integer num = (Integer) aVar.a("int", uGCFilterActivity, new b("int", "tabId", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCFilterActivity", "tabId", false, "No desc."));
                    if (num != null) {
                        uGCFilterActivity.tabId = num.intValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", uGCFilterActivity, new b("java.lang.String", "filterType", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCFilterActivity", "mFilterJson", false, "No desc."));
                    if (str != null) {
                        uGCFilterActivity.mFilterJson = str;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", uGCFilterActivity, new b("java.lang.String", "fromOptId", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCFilterActivity", "fromOptId", false, "No desc."));
                    if (str2 != null) {
                        uGCFilterActivity.fromOptId = str2;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", uGCFilterActivity, new b("java.lang.String", "tabCode", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCFilterActivity", "tabCode", false, "No desc."));
                    if (str3 != null) {
                        uGCFilterActivity.tabCode = str3;
                    }
                } catch (Exception e4) {
                    if (TheRouter.m()) {
                        e4.printStackTrace();
                    }
                }
                try {
                    String str4 = (String) aVar.a("java.lang.String", uGCFilterActivity, new b("java.lang.String", "videoType", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCFilterActivity", "videoType", false, "No desc."));
                    if (str4 != null) {
                        uGCFilterActivity.videoType = str4;
                    }
                } catch (Exception e5) {
                    if (TheRouter.m()) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }
}
