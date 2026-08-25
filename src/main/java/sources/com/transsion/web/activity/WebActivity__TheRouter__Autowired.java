package com.transsion.web.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.web.api.WebConstants;
import java.util.Iterator;
import mf.a;
import okhttp3.HttpUrl;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class WebActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof WebActivity) {
            WebActivity webActivity = (WebActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    Boolean bool = (Boolean) aVar.a("boolean", webActivity, new b("boolean", WebConstants.EXTERNAL_BROWSER, 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.web.activity.WebActivity", WebConstants.EXTERNAL_BROWSER, false, "No desc."));
                    if (bool != null) {
                        webActivity.com.transsion.web.api.WebConstants.EXTERNAL_BROWSER java.lang.String = bool.booleanValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    Boolean bool2 = (Boolean) aVar.a("boolean", webActivity, new b("boolean", WebConstants.FIELD_LOAD_URL_ONLY, 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.web.activity.WebActivity", "loadUrlOnly", false, "No desc."));
                    if (bool2 != null) {
                        webActivity.loadUrlOnly = bool2.booleanValue();
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", webActivity, new b("java.lang.String", WebConstants.FIELD_DEEPLINK, 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.web.activity.WebActivity", WebConstants.FIELD_DEEPLINK, false, "No desc."));
                    if (str != null) {
                        webActivity.com.transsion.web.api.WebConstants.FIELD_DEEPLINK java.lang.String = str;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", webActivity, new b("java.lang.String", WebConstants.PAGE_FROM, 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.web.activity.WebActivity", "pageFrom", false, "No desc."));
                    if (str2 != null) {
                        webActivity.pageFrom = str2;
                    }
                } catch (Exception e4) {
                    if (TheRouter.m()) {
                        e4.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", webActivity, new b("java.lang.String", WebConstants.FIELD_URL, 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.web.activity.WebActivity", WebConstants.FIELD_URL, false, "No desc."));
                    if (str3 != null) {
                        webActivity.com.transsion.web.api.WebConstants.FIELD_URL java.lang.String = str3;
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
