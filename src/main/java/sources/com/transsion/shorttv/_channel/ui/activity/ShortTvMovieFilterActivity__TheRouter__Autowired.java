package com.transsion.shorttv._channel.ui.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import mf.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ShortTvMovieFilterActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof ShortTvMovieFilterActivity) {
            ShortTvMovieFilterActivity shortTvMovieFilterActivity = (ShortTvMovieFilterActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    Boolean bool = (Boolean) aVar.a("boolean", shortTvMovieFilterActivity, new b("boolean", "showViewPager", 0, BuildConfig.FLAVOR, "com.transsion.shorttv._channel.ui.activity.ShortTvMovieFilterActivity", "showViewPager", false, "No desc."));
                    if (bool != null) {
                        shortTvMovieFilterActivity.showViewPager = bool.booleanValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    Integer num = (Integer) aVar.a("int", shortTvMovieFilterActivity, new b("int", "tab_id", 0, BuildConfig.FLAVOR, "com.transsion.shorttv._channel.ui.activity.ShortTvMovieFilterActivity", "tabId", false, "No desc."));
                    if (num != null) {
                        shortTvMovieFilterActivity.tabId = num.intValue();
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", shortTvMovieFilterActivity, new b("java.lang.String", "filterType", 0, BuildConfig.FLAVOR, "com.transsion.shorttv._channel.ui.activity.ShortTvMovieFilterActivity", "mFilterJson", false, "No desc."));
                    if (str != null) {
                        shortTvMovieFilterActivity.mFilterJson = str;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", shortTvMovieFilterActivity, new b("java.lang.String", "tabCode", 0, BuildConfig.FLAVOR, "com.transsion.shorttv._channel.ui.activity.ShortTvMovieFilterActivity", "tabCode", false, "No desc."));
                    if (str2 != null) {
                        shortTvMovieFilterActivity.tabCode = str2;
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
