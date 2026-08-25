package com.transsion.ugcvideodetail.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import java.util.Iterator;
import okhttp3.HttpUrl;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class UGCLocalVideoDetailActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof UGCLocalVideoDetailActivity) {
            UGCLocalVideoDetailActivity uGCLocalVideoDetailActivity = (UGCLocalVideoDetailActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                mf.a aVar = (mf.a) it.next();
                try {
                    String str = (String) aVar.a("java.lang.String", uGCLocalVideoDetailActivity, new b("java.lang.String", "id", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.ugcvideodetail.activity.UGCLocalVideoDetailActivity", "videoId", false, "No desc."));
                    if (str != null) {
                        uGCLocalVideoDetailActivity.videoId = str;
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", uGCLocalVideoDetailActivity, new b("java.lang.String", "parent_track_id", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.ugcvideodetail.activity.UGCLocalVideoDetailActivity", "previousPageTrackId", false, "No desc."));
                    if (str2 != null) {
                        uGCLocalVideoDetailActivity.previousPageTrackId = str2;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", uGCLocalVideoDetailActivity, new b("java.lang.String", "parent_video_id", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.ugcvideodetail.activity.UGCLocalVideoDetailActivity", "previousPageVideoId", false, "No desc."));
                    if (str3 != null) {
                        uGCLocalVideoDetailActivity.previousPageVideoId = str3;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    String str4 = (String) aVar.a("java.lang.String", uGCLocalVideoDetailActivity, new b("java.lang.String", "resource_id", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.ugcvideodetail.activity.UGCLocalVideoDetailActivity", "resourceId", false, "No desc."));
                    if (str4 != null) {
                        uGCLocalVideoDetailActivity.resourceId = str4;
                    }
                } catch (Exception e4) {
                    if (TheRouter.m()) {
                        e4.printStackTrace();
                    }
                }
                try {
                    String str5 = (String) aVar.a("java.lang.String", uGCLocalVideoDetailActivity, new b("java.lang.String", "ugcCategory", 0, HttpUrl.FRAGMENT_ENCODE_SET, "com.transsion.ugcvideodetail.activity.UGCLocalVideoDetailActivity", "type", false, "No desc."));
                    if (str5 != null) {
                        uGCLocalVideoDetailActivity.type = str5;
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
