package com.transsion.shorttv.ui.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import java.util.Iterator;
import mf.a;
import okhttp3.HttpUrl;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class ShortTVFavoriteActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof ShortTVFavoriteActivity) {
            ShortTVFavoriteActivity shortTVFavoriteActivity = (ShortTVFavoriteActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                try {
                    String str = (String) ((a) it.next()).a("java.lang.String", shortTVFavoriteActivity, new b("java.lang.String", "ops", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.shorttv.ui.activity.ShortTVFavoriteActivity", "ops", false, "No desc."));
                    if (str != null) {
                        shortTVFavoriteActivity.ops = str;
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
