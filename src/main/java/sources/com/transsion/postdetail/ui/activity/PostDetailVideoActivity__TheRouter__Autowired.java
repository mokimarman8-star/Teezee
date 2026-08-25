package com.transsion.postdetail.ui.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.ArrayList;
import java.util.Iterator;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class PostDetailVideoActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof PostDetailVideoActivity) {
            PostDetailVideoActivity postDetailVideoActivity = (PostDetailVideoActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                mf.a aVar = (mf.a) it.next();
                try {
                    Boolean bool = (Boolean) aVar.a("boolean", postDetailVideoActivity, new com.therouter.router.b("boolean", "from_comment", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailVideoActivity", "fromComment", false, "No desc."));
                    if (bool != null) {
                        postDetailVideoActivity.fromComment = bool.booleanValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    Boolean bool2 = (Boolean) aVar.a("boolean", postDetailVideoActivity, new com.therouter.router.b("boolean", "is_build_in", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailVideoActivity", "isBuiltIn", false, "No desc."));
                    if (bool2 != null) {
                        postDetailVideoActivity.isBuiltIn = bool2.booleanValue();
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    Boolean bool3 = (Boolean) aVar.a("boolean", postDetailVideoActivity, new com.therouter.router.b("boolean", "is_from_downloaded", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailVideoActivity", "isFromDownloaded", false, "No desc."));
                    if (bool3 != null) {
                        postDetailVideoActivity.isFromDownloaded = bool3.booleanValue();
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    Boolean bool4 = (Boolean) aVar.a("boolean", postDetailVideoActivity, new com.therouter.router.b("boolean", "prioritize_downloaded", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailVideoActivity", "prioritizeDownloaded", false, "No desc."));
                    if (bool4 != null) {
                        postDetailVideoActivity.prioritizeDownloaded = bool4.booleanValue();
                    }
                } catch (Exception e4) {
                    if (TheRouter.m()) {
                        e4.printStackTrace();
                    }
                }
                try {
                    Boolean bool5 = (Boolean) aVar.a("boolean", postDetailVideoActivity, new com.therouter.router.b("boolean", "video_load_more", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailVideoActivity", "videoLoadMore", false, "No desc."));
                    if (bool5 != null) {
                        postDetailVideoActivity.videoLoadMore = bool5.booleanValue();
                    }
                } catch (Exception e5) {
                    if (TheRouter.m()) {
                        e5.printStackTrace();
                    }
                }
                try {
                    PostSubjectItem postSubjectItem = (PostSubjectItem) aVar.a("com.transsion.moviedetailapi.bean.PostSubjectItem", postDetailVideoActivity, new com.therouter.router.b("com.transsion.moviedetailapi.bean.PostSubjectItem", "item_object", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailVideoActivity", "itemObject", false, "No desc."));
                    if (postSubjectItem != null) {
                        postDetailVideoActivity.itemObject = postSubjectItem;
                    }
                } catch (Exception e6) {
                    if (TheRouter.m()) {
                        e6.printStackTrace();
                    }
                }
                try {
                    Integer num = (Integer) aVar.a("int", postDetailVideoActivity, new com.therouter.router.b("int", "tab_id", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailVideoActivity", "tabId", false, "No desc."));
                    if (num != null) {
                        postDetailVideoActivity.tabId = num.intValue();
                    }
                } catch (Exception e7) {
                    if (TheRouter.m()) {
                        e7.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", postDetailVideoActivity, new com.therouter.router.b("java.lang.String", "id", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailVideoActivity", "postId", false, "No desc."));
                    if (str != null) {
                        postDetailVideoActivity.postId = str;
                    }
                } catch (Exception e8) {
                    if (TheRouter.m()) {
                        e8.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", postDetailVideoActivity, new com.therouter.router.b("java.lang.String", "item_type", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailVideoActivity", "itemType", false, "No desc."));
                    if (str2 != null) {
                        postDetailVideoActivity.itemType = str2;
                    }
                } catch (Exception e9) {
                    if (TheRouter.m()) {
                        e9.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", postDetailVideoActivity, new com.therouter.router.b("java.lang.String", "media_type", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailVideoActivity", "mediaType", false, "No desc."));
                    if (str3 != null) {
                        postDetailVideoActivity.mediaType = str3;
                    }
                } catch (Exception e10) {
                    if (TheRouter.m()) {
                        e10.printStackTrace();
                    }
                }
                try {
                    String str4 = (String) aVar.a("java.lang.String", postDetailVideoActivity, new com.therouter.router.b("java.lang.String", "page_from", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailVideoActivity", "pageFrom", false, "No desc."));
                    if (str4 != null) {
                        postDetailVideoActivity.pageFrom = str4;
                    }
                } catch (Exception e11) {
                    if (TheRouter.m()) {
                        e11.printStackTrace();
                    }
                }
                try {
                    String str5 = (String) aVar.a("java.lang.String", postDetailVideoActivity, new com.therouter.router.b("java.lang.String", "rec_ops", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailVideoActivity", "ops", false, "No desc."));
                    if (str5 != null) {
                        postDetailVideoActivity.ops = str5;
                    }
                } catch (Exception e12) {
                    if (TheRouter.m()) {
                        e12.printStackTrace();
                    }
                }
                try {
                    ArrayList arrayList = (ArrayList) aVar.a("java.util.ArrayList<com.transsion.moviedetailapi.bean.PostSubjectItem>", postDetailVideoActivity, new com.therouter.router.b("java.util.ArrayList<com.transsion.moviedetailapi.bean.PostSubjectItem>", "downloaded_shorts_list", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailVideoActivity", "downloadedShortsList", false, "No desc."));
                    if (arrayList != null) {
                        postDetailVideoActivity.downloadedShortsList = arrayList;
                    }
                } catch (Exception e13) {
                    if (TheRouter.m()) {
                        e13.printStackTrace();
                    }
                }
            }
        }
    }
}
