package com.transsion.home.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.gslb.BuildConfig;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import java.util.ArrayList;
import java.util.Iterator;
import mf.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class UGCHashTagActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof UGCHashTagActivity) {
            UGCHashTagActivity uGCHashTagActivity = (UGCHashTagActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    UGCVideoHashTag uGCVideoHashTag = (UGCVideoHashTag) aVar.a("com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag", uGCHashTagActivity, new b("com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag", "titleHashTag", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCHashTagActivity", "mainHasTag", false, "No desc."));
                    if (uGCVideoHashTag != null) {
                        uGCHashTagActivity.mainHasTag = uGCVideoHashTag;
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    Integer num = (Integer) aVar.a("int", uGCHashTagActivity, new b("int", "tabId", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCHashTagActivity", "tabId", false, "No desc."));
                    if (num != null) {
                        uGCHashTagActivity.tabId = num.intValue();
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", uGCHashTagActivity, new b("java.lang.String", "UGCVideoId", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCHashTagActivity", "ugcVideoId", false, "No desc."));
                    if (str != null) {
                        uGCHashTagActivity.ugcVideoId = str;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", uGCHashTagActivity, new b("java.lang.String", "fromOptId", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCHashTagActivity", "fromOptId", false, "No desc."));
                    if (str2 != null) {
                        uGCHashTagActivity.fromOptId = str2;
                    }
                } catch (Exception e4) {
                    if (TheRouter.m()) {
                        e4.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", uGCHashTagActivity, new b("java.lang.String", "hashtag", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCHashTagActivity", "mHashtagJson", false, "No desc."));
                    if (str3 != null) {
                        uGCHashTagActivity.mHashtagJson = str3;
                    }
                } catch (Exception e5) {
                    if (TheRouter.m()) {
                        e5.printStackTrace();
                    }
                }
                try {
                    ArrayList arrayList = (ArrayList) aVar.a("java.util.ArrayList<com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag>", uGCHashTagActivity, new b("java.util.ArrayList<com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag>", "hashTagList", 0, BuildConfig.FLAVOR, "com.transsion.home.activity.UGCHashTagActivity", "hasTagList", false, "No desc."));
                    if (arrayList != null) {
                        uGCHashTagActivity.hasTagList = arrayList;
                    }
                } catch (Exception e6) {
                    if (TheRouter.m()) {
                        e6.printStackTrace();
                    }
                }
            }
        }
    }
}
