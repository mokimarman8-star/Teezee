package com.transsion.videodetail;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import java.util.Iterator;
import okhttp3.HttpUrl;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class BaseDetailActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof BaseDetailActivity) {
            BaseDetailActivity baseDetailActivity = (BaseDetailActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                mf.a aVar = (mf.a) it.next();
                try {
                    Boolean bool = (Boolean) aVar.a("boolean", baseDetailActivity, new com.therouter.router.b("boolean", "autoDownload", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.videodetail.BaseDetailActivity", "autoDownload", false, "No desc."));
                    if (bool != null) {
                        baseDetailActivity.autoDownload = bool.booleanValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    Boolean bool2 = (Boolean) aVar.a("boolean", baseDetailActivity, new com.therouter.router.b("boolean", "autoPlay", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.videodetail.BaseDetailActivity", "autoPlay", false, "No desc."));
                    if (bool2 != null) {
                        baseDetailActivity.autoPlay = bool2.booleanValue();
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    Boolean bool3 = (Boolean) aVar.a("boolean", baseDetailActivity, new com.therouter.router.b("boolean", "isMusicFloatViewClick", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.videodetail.BaseDetailActivity", "isMusicFloatViewClick", false, "No desc."));
                    if (bool3 != null) {
                        baseDetailActivity.isMusicFloatViewClick = bool3.booleanValue();
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    Boolean bool4 = (Boolean) aVar.a("boolean", baseDetailActivity, new com.therouter.router.b("boolean", "is_music_liked_fragment", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.videodetail.BaseDetailActivity", "isMusicLikedFragment", false, "No desc."));
                    if (bool4 != null) {
                        baseDetailActivity.isMusicLikedFragment = bool4.booleanValue();
                    }
                } catch (Exception e4) {
                    if (TheRouter.m()) {
                        e4.printStackTrace();
                    }
                }
                try {
                    Integer num = (Integer) aVar.a("int", baseDetailActivity, new com.therouter.router.b("int", "episode", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.videodetail.BaseDetailActivity", "targetEp", false, "No desc."));
                    if (num != null) {
                        baseDetailActivity.targetEp = num.intValue();
                    }
                } catch (Exception e5) {
                    if (TheRouter.m()) {
                        e5.printStackTrace();
                    }
                }
                try {
                    Integer num2 = (Integer) aVar.a("int", baseDetailActivity, new com.therouter.router.b("int", "season", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.videodetail.BaseDetailActivity", "curSeason", false, "No desc."));
                    if (num2 != null) {
                        baseDetailActivity.curSeason = num2.intValue();
                    }
                } catch (Exception e6) {
                    if (TheRouter.m()) {
                        e6.printStackTrace();
                    }
                }
                try {
                    Integer num3 = (Integer) aVar.a("int", baseDetailActivity, new com.therouter.router.b("int", "yy_preload_id", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.videodetail.BaseDetailActivity", "preloadId", false, "No desc."));
                    if (num3 != null) {
                        baseDetailActivity.preloadId = num3.intValue();
                    }
                } catch (Exception e7) {
                    if (TheRouter.m()) {
                        e7.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", baseDetailActivity, new com.therouter.router.b("java.lang.String", "id", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.videodetail.BaseDetailActivity", "id", false, "No desc."));
                    if (str != null) {
                        baseDetailActivity.id = str;
                    }
                } catch (Exception e8) {
                    if (TheRouter.m()) {
                        e8.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", baseDetailActivity, new com.therouter.router.b("java.lang.String", "module_name", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.videodetail.BaseDetailActivity", "moduleName", false, "No desc."));
                    if (str2 != null) {
                        baseDetailActivity.moduleName = str2;
                    }
                } catch (Exception e9) {
                    if (TheRouter.m()) {
                        e9.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", baseDetailActivity, new com.therouter.router.b("java.lang.String", "ops", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.videodetail.BaseDetailActivity", "ops", false, "No desc."));
                    if (str3 != null) {
                        baseDetailActivity.ops = str3;
                    }
                } catch (Exception e10) {
                    if (TheRouter.m()) {
                        e10.printStackTrace();
                    }
                }
                try {
                    String str4 = (String) aVar.a("java.lang.String", baseDetailActivity, new com.therouter.router.b("java.lang.String", "resourceId", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.videodetail.BaseDetailActivity", "autoPlayResourceId", false, "No desc."));
                    if (str4 != null) {
                        baseDetailActivity.autoPlayResourceId = str4;
                    }
                } catch (Exception e11) {
                    if (TheRouter.m()) {
                        e11.printStackTrace();
                    }
                }
            }
        }
    }
}
