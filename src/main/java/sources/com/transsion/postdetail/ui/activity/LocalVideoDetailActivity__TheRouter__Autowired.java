package com.transsion.postdetail.ui.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class LocalVideoDetailActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof LocalVideoDetailActivity) {
            LocalVideoDetailActivity localVideoDetailActivity = (LocalVideoDetailActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                mf.a aVar = (mf.a) it.next();
                try {
                    Boolean bool = (Boolean) aVar.a("java.lang.Boolean", localVideoDetailActivity, new com.therouter.router.b("java.lang.Boolean", "extra_completed", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "completed", false, "No desc."));
                    if (bool != null) {
                        localVideoDetailActivity.completed = bool;
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    Boolean bool2 = (Boolean) aVar.a("java.lang.Boolean", localVideoDetailActivity, new com.therouter.router.b("java.lang.Boolean", "extra_is_series", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "isSeries", false, "No desc."));
                    if (bool2 != null) {
                        localVideoDetailActivity.isSeries = bool2;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    Integer num = (Integer) aVar.a("java.lang.Integer", localVideoDetailActivity, new com.therouter.router.b("java.lang.Integer", "extra_height", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "videoHeight", false, "No desc."));
                    if (num != null) {
                        localVideoDetailActivity.videoHeight = num;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    Integer num2 = (Integer) aVar.a("java.lang.Integer", localVideoDetailActivity, new com.therouter.router.b("java.lang.Integer", "extra_parent_position", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "parentPosition", false, "No desc."));
                    if (num2 != null) {
                        localVideoDetailActivity.parentPosition = num2;
                    }
                } catch (Exception e4) {
                    if (TheRouter.m()) {
                        e4.printStackTrace();
                    }
                }
                try {
                    Integer num3 = (Integer) aVar.a("java.lang.Integer", localVideoDetailActivity, new com.therouter.router.b("java.lang.Integer", "extra_position", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "position", false, "No desc."));
                    if (num3 != null) {
                        localVideoDetailActivity.position = num3;
                    }
                } catch (Exception e5) {
                    if (TheRouter.m()) {
                        e5.printStackTrace();
                    }
                }
                try {
                    Integer num4 = (Integer) aVar.a("java.lang.Integer", localVideoDetailActivity, new com.therouter.router.b("java.lang.Integer", "extra_width", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "videoWidth", false, "No desc."));
                    if (num4 != null) {
                        localVideoDetailActivity.videoWidth = num4;
                    }
                } catch (Exception e6) {
                    if (TheRouter.m()) {
                        e6.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", localVideoDetailActivity, new com.therouter.router.b("java.lang.String", "extra_local_path", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "path", false, "No desc."));
                    if (str != null) {
                        localVideoDetailActivity.path = str;
                    }
                } catch (Exception e7) {
                    if (TheRouter.m()) {
                        e7.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", localVideoDetailActivity, new com.therouter.router.b("java.lang.String", "extra_name", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "name", false, "No desc."));
                    if (str2 != null) {
                        localVideoDetailActivity.name = str2;
                    }
                } catch (Exception e8) {
                    if (TheRouter.m()) {
                        e8.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", localVideoDetailActivity, new com.therouter.router.b("java.lang.String", "extra_page_from", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "pageFrom", false, "No desc."));
                    if (str3 != null) {
                        localVideoDetailActivity.pageFrom = str3;
                    }
                } catch (Exception e9) {
                    if (TheRouter.m()) {
                        e9.printStackTrace();
                    }
                }
                try {
                    String str4 = (String) aVar.a("java.lang.String", localVideoDetailActivity, new com.therouter.router.b("java.lang.String", "extra_post_id", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "postId", false, "No desc."));
                    if (str4 != null) {
                        localVideoDetailActivity.postId = str4;
                    }
                } catch (Exception e10) {
                    if (TheRouter.m()) {
                        e10.printStackTrace();
                    }
                }
                try {
                    String str5 = (String) aVar.a("java.lang.String", localVideoDetailActivity, new com.therouter.router.b("java.lang.String", "extra_proxy_url", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "proxyUrl", false, "No desc."));
                    if (str5 != null) {
                        localVideoDetailActivity.proxyUrl = str5;
                    }
                } catch (Exception e11) {
                    if (TheRouter.m()) {
                        e11.printStackTrace();
                    }
                }
                try {
                    String str6 = (String) aVar.a("java.lang.String", localVideoDetailActivity, new com.therouter.router.b("java.lang.String", "extra_resource_id", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "resourceId", false, "No desc."));
                    if (str6 != null) {
                        localVideoDetailActivity.resourceId = str6;
                    }
                } catch (Exception e12) {
                    if (TheRouter.m()) {
                        e12.printStackTrace();
                    }
                }
                try {
                    String str7 = (String) aVar.a("java.lang.String", localVideoDetailActivity, new com.therouter.router.b("java.lang.String", "extra_subject_id", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "subjectId", false, "No desc."));
                    if (str7 != null) {
                        localVideoDetailActivity.subjectId = str7;
                    }
                } catch (Exception e13) {
                    if (TheRouter.m()) {
                        e13.printStackTrace();
                    }
                }
                try {
                    String str8 = (String) aVar.a("java.lang.String", localVideoDetailActivity, new com.therouter.router.b("java.lang.String", "extra_url", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.LocalVideoDetailActivity", "url", false, "No desc."));
                    if (str8 != null) {
                        localVideoDetailActivity.url = str8;
                    }
                } catch (Exception e14) {
                    if (TheRouter.m()) {
                        e14.printStackTrace();
                    }
                }
            }
        }
    }
}
