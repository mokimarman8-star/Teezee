package com.transsion.subroom.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import java.util.Iterator;
import okhttp3.HttpUrl;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class MainActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                mf.a aVar = (mf.a) it.next();
                try {
                    Integer num = (Integer) aVar.a("int", mainActivity, new b("int", "secondTabIndex", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.subroom.activity.MainActivity", "mSecondTabIndex", false, "No desc."));
                    if (num != null) {
                        mainActivity.n = num.intValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    Integer num2 = (Integer) aVar.a("int", mainActivity, new b("int", "tabIndex", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.subroom.activity.MainActivity", "mInitTabId", false, "No desc."));
                    if (num2 != null) {
                        mainActivity.m = num2.intValue();
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", mainActivity, new b("java.lang.String", "bottomTab", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.subroom.activity.MainActivity", "mBottomTabCode", false, "No desc."));
                    if (str != null) {
                        mainActivity.l = str;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", mainActivity, new b("java.lang.String", "topTab", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.subroom.activity.MainActivity", "mTopTabCode", false, "No desc."));
                    if (str2 != null) {
                        mainActivity.k = str2;
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
