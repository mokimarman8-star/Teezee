package com.transsion.shorttv_pugc.ui.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import java.util.Iterator;
import mf.a;
import okhttp3.HttpUrl;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class ShortTvListActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof ShortTvListActivity) {
            ShortTvListActivity shortTvListActivity = (ShortTvListActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    Boolean bool = (Boolean) aVar.a("boolean", shortTvListActivity, new b("boolean", "historyFist", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.shorttv_pugc.ui.activity.ShortTvListActivity", "isHistoryFirst", false, "No desc."));
                    if (bool != null) {
                        shortTvListActivity.isHistoryFirst = bool.booleanValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    Boolean bool2 = (Boolean) aVar.a("boolean", shortTvListActivity, new b("boolean", "ugc_without_history", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.shorttv_pugc.ui.activity.ShortTvListActivity", "ugcWithoutHistory", false, "No desc."));
                    if (bool2 != null) {
                        shortTvListActivity.ugcWithoutHistory = bool2.booleanValue();
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    Integer num = (Integer) aVar.a("int", shortTvListActivity, new b("int", "ep", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.shorttv_pugc.ui.activity.ShortTvListActivity", "ep", false, "No desc."));
                    if (num != null) {
                        shortTvListActivity.ep = num.intValue();
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", shortTvListActivity, new b("java.lang.String", "collectionId", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.shorttv_pugc.ui.activity.ShortTvListActivity", "collectId", false, "No desc."));
                    if (str != null) {
                        shortTvListActivity.collectId = str;
                    }
                } catch (Exception e4) {
                    if (TheRouter.m()) {
                        e4.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", shortTvListActivity, new b("java.lang.String", "fromOptId", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.shorttv_pugc.ui.activity.ShortTvListActivity", "fromOptId", false, "No desc."));
                    if (str2 != null) {
                        shortTvListActivity.fromOptId = str2;
                    }
                } catch (Exception e5) {
                    if (TheRouter.m()) {
                        e5.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", shortTvListActivity, new b("java.lang.String", "id", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.shorttv_pugc.ui.activity.ShortTvListActivity", "ugcVideoId", false, "No desc."));
                    if (str3 != null) {
                        shortTvListActivity.ugcVideoId = str3;
                    }
                } catch (Exception e6) {
                    if (TheRouter.m()) {
                        e6.printStackTrace();
                    }
                }
                try {
                    String str4 = (String) aVar.a("java.lang.String", shortTvListActivity, new b("java.lang.String", "ops", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.shorttv_pugc.ui.activity.ShortTvListActivity", "ops", false, "No desc."));
                    if (str4 != null) {
                        shortTvListActivity.ops = str4;
                    }
                } catch (Exception e7) {
                    if (TheRouter.m()) {
                        e7.printStackTrace();
                    }
                }
                try {
                    String str5 = (String) aVar.a("java.lang.String", shortTvListActivity, new b("java.lang.String", "subjectId", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.shorttv_pugc.ui.activity.ShortTvListActivity", "subjectId", false, "No desc."));
                    if (str5 != null) {
                        shortTvListActivity.subjectId = str5;
                    }
                } catch (Exception e8) {
                    if (TheRouter.m()) {
                        e8.printStackTrace();
                    }
                }
                try {
                    Long l = (Long) aVar.a("long", shortTvListActivity, new b("long", "ms", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.shorttv_pugc.ui.activity.ShortTvListActivity", "ms", false, "No desc."));
                    if (l != null) {
                        shortTvListActivity.ms = l.longValue();
                    }
                } catch (Exception e9) {
                    if (TheRouter.m()) {
                        e9.printStackTrace();
                    }
                }
            }
        }
    }
}
