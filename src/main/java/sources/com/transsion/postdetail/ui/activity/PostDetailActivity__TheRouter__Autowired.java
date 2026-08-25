package com.transsion.postdetail.ui.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.Iterator;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class PostDetailActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof PostDetailActivity) {
            PostDetailActivity postDetailActivity = (PostDetailActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                mf.a aVar = (mf.a) it.next();
                try {
                    Boolean bool = (Boolean) aVar.a("boolean", postDetailActivity, new com.therouter.router.b("boolean", "from_comment", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailActivity", "fromComment", false, "No desc."));
                    if (bool != null) {
                        postDetailActivity.fromComment = bool.booleanValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    Boolean bool2 = (Boolean) aVar.a("boolean", postDetailActivity, new com.therouter.router.b("boolean", "need_back_to_room", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailActivity", "needBackToRoom", false, "No desc."));
                    if (bool2 != null) {
                        postDetailActivity.needBackToRoom = bool2.booleanValue();
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    Boolean bool3 = (Boolean) aVar.a("boolean", postDetailActivity, new com.therouter.router.b("boolean", "video_load_more", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailActivity", "videoLoadMore", false, "No desc."));
                    if (bool3 != null) {
                        postDetailActivity.videoLoadMore = bool3.booleanValue();
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
                try {
                    PostSubjectItem postSubjectItem = (PostSubjectItem) aVar.a("com.transsion.moviedetailapi.bean.PostSubjectItem", postDetailActivity, new com.therouter.router.b("com.transsion.moviedetailapi.bean.PostSubjectItem", "item_object", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailActivity", "itemObject", false, "No desc."));
                    if (postSubjectItem != null) {
                        postDetailActivity.itemObject = postSubjectItem;
                    }
                } catch (Exception e4) {
                    if (TheRouter.m()) {
                        e4.printStackTrace();
                    }
                }
                try {
                    Integer num = (Integer) aVar.a("int", postDetailActivity, new com.therouter.router.b("int", "tab_id", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailActivity", "tabId", false, "No desc."));
                    if (num != null) {
                        postDetailActivity.tabId = num.intValue();
                    }
                } catch (Exception e5) {
                    if (TheRouter.m()) {
                        e5.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", postDetailActivity, new com.therouter.router.b("java.lang.String", "comment_id", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailActivity", "commentId", false, "No desc."));
                    if (str != null) {
                        postDetailActivity.commentId = str;
                    }
                } catch (Exception e6) {
                    if (TheRouter.m()) {
                        e6.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", postDetailActivity, new com.therouter.router.b("java.lang.String", "id", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailActivity", "postId", false, "No desc."));
                    if (str2 != null) {
                        postDetailActivity.postId = str2;
                    }
                } catch (Exception e7) {
                    if (TheRouter.m()) {
                        e7.printStackTrace();
                    }
                }
                try {
                    String str3 = (String) aVar.a("java.lang.String", postDetailActivity, new com.therouter.router.b("java.lang.String", "item_type", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailActivity", "itemType", false, "No desc."));
                    if (str3 != null) {
                        postDetailActivity.itemType = str3;
                    }
                } catch (Exception e8) {
                    if (TheRouter.m()) {
                        e8.printStackTrace();
                    }
                }
                try {
                    String str4 = (String) aVar.a("java.lang.String", postDetailActivity, new com.therouter.router.b("java.lang.String", "media_type", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailActivity", "mediaType", false, "No desc."));
                    if (str4 != null) {
                        postDetailActivity.mediaType = str4;
                    }
                } catch (Exception e9) {
                    if (TheRouter.m()) {
                        e9.printStackTrace();
                    }
                }
                try {
                    String str5 = (String) aVar.a("java.lang.String", postDetailActivity, new com.therouter.router.b("java.lang.String", "page_from", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailActivity", "pageFrom", false, "No desc."));
                    if (str5 != null) {
                        postDetailActivity.pageFrom = str5;
                    }
                } catch (Exception e10) {
                    if (TheRouter.m()) {
                        e10.printStackTrace();
                    }
                }
                try {
                    String str6 = (String) aVar.a("java.lang.String", postDetailActivity, new com.therouter.router.b("java.lang.String", "rec_ops", 0, BuildConfig.FLAVOR, "com.transsion.postdetail.ui.activity.PostDetailActivity", "ops", false, "No desc."));
                    if (str6 != null) {
                        postDetailActivity.ops = str6;
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
