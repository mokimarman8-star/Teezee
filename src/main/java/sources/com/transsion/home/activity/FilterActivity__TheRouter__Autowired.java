package com.transsion.home.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import mf.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class FilterActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof FilterActivity) {
            FilterActivity filterActivity = (FilterActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    Integer num = (Integer) aVar.a("int", filterActivity, new b("int", "tabId", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.FilterActivity", "tabId", false, "No desc."));
                    if (num != null) {
                        filterActivity.tabId = num.intValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", filterActivity, new b("java.lang.String", "filterType", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.FilterActivity", "mFilterJson", false, "No desc."));
                    if (str != null) {
                        filterActivity.mFilterJson = str;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", filterActivity, new b("java.lang.String", "tabCode", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.FilterActivity", "tabCode", false, "No desc."));
                    if (str2 != null) {
                        filterActivity.tabCode = str2;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", filterActivity, new b("java.lang.String", "videoType", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.FilterActivity", "videoType", false, "No desc."));
                    if (str3 != null) {
                        filterActivity.videoType = str3;
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
