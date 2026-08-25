package com.transsnet.downloader.ugc.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import java.util.Iterator;
import mf.a;
import okhttp3.HttpUrl;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class UGCMyDownloadsActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof UGCMyDownloadsActivity) {
            UGCMyDownloadsActivity uGCMyDownloadsActivity = (UGCMyDownloadsActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    Integer num = (Integer) aVar.a("int", uGCMyDownloadsActivity, new b("int", "main_tab_index", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsnet.downloader.ugc.activity.UGCMyDownloadsActivity", "mainTabIndex", false, "No desc."));
                    if (num != null) {
                        uGCMyDownloadsActivity.mainTabIndex = num.intValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", uGCMyDownloadsActivity, new b("java.lang.String", "sub_tab_title", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsnet.downloader.ugc.activity.UGCMyDownloadsActivity", "subTabTitle", false, "No desc."));
                    if (str != null) {
                        uGCMyDownloadsActivity.subTabTitle = str;
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
