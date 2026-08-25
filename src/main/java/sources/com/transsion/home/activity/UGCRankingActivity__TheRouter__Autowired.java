package com.transsion.home.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import mf.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class UGCRankingActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof UGCRankingActivity) {
            UGCRankingActivity uGCRankingActivity = (UGCRankingActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    String str = (String) aVar.a("java.lang.String", uGCRankingActivity, new b("java.lang.String", "category", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCRankingActivity", "requestCategory", false, "No desc."));
                    if (str != null) {
                        uGCRankingActivity.requestCategory = str;
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", uGCRankingActivity, new b("java.lang.String", "fromOptId", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCRankingActivity", "fromOptId", false, "No desc."));
                    if (str2 != null) {
                        uGCRankingActivity.fromOptId = str2;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", uGCRankingActivity, new b("java.lang.String", "tabId", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCRankingActivity", "tabId", false, "No desc."));
                    if (str3 != null) {
                        uGCRankingActivity.tabId = str3;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    String str4 = (String) aVar.a("java.lang.String", uGCRankingActivity, new b("java.lang.String", "videoType", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCRankingActivity", "videoType", false, "No desc."));
                    if (str4 != null) {
                        uGCRankingActivity.videoType = str4;
                    }
                } catch (Exception e4) {
                    if (TheRouter.m()) {
                        e4.printStackTrace();
                    }
                }
            }
        }
    }
}
