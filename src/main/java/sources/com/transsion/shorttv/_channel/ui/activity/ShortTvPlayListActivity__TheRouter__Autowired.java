package com.transsion.shorttv._channel.ui.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import mf.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ShortTvPlayListActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof ShortTvPlayListActivity) {
            ShortTvPlayListActivity shortTvPlayListActivity = (ShortTvPlayListActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    String str = (String) aVar.a("java.lang.String", shortTvPlayListActivity, new b("java.lang.String", "category", 0, BuildConfig.FLAVOR, "com.transsion.shorttv._channel.ui.activity.ShortTvPlayListActivity", "category", false, "No desc."));
                    if (str != null) {
                        shortTvPlayListActivity.category = str;
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", shortTvPlayListActivity, new b("java.lang.String", "label", 0, BuildConfig.FLAVOR, "com.transsion.shorttv._channel.ui.activity.ShortTvPlayListActivity", "label", false, "No desc."));
                    if (str2 != null) {
                        shortTvPlayListActivity.label = str2;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", shortTvPlayListActivity, new b("java.lang.String", "recType", 0, BuildConfig.FLAVOR, "com.transsion.shorttv._channel.ui.activity.ShortTvPlayListActivity", "recType", false, "No desc."));
                    if (str3 != null) {
                        shortTvPlayListActivity.recType = str3;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }
}
