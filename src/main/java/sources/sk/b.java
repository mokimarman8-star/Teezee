package sk;

import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.BffCommonOpData;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.push.bean.MsgStyle;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import ij.g;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class b {
    public static final void a(OperateItem operateItem, Map map) {
        Intrinsics.h(operateItem, "<this>");
        Intrinsics.h(map, "map");
        boolean b = g.a.b();
        String str = BuildConfig.FLAVOR;
        if (b) {
            String type = operateItem.getType();
            if (type == null) {
                type = BuildConfig.FLAVOR;
            }
            map.put("opt_type", type);
            String opId = operateItem.getOpId();
            if (opId != null) {
                str = opId;
            }
            map.put("opt_id", str);
            return;
        }
        map.put("item_type", "opt");
        String type2 = operateItem.getType();
        if (type2 == null) {
            type2 = BuildConfig.FLAVOR;
        }
        map.put("opt_type", type2);
        String title = operateItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        map.put("opTitle", title);
        String opId2 = operateItem.getOpId();
        if (opId2 != null) {
            str = opId2;
        }
        map.put("opId", str);
    }

    public static final void b(BannerData bannerData, Map map) {
        Intrinsics.h(bannerData, "<this>");
        Intrinsics.h(map, "map");
        boolean b = g.a.b();
        String str = BuildConfig.FLAVOR;
        if (b) {
            String ops = bannerData.getOps();
            if (ops == null) {
                ops = BuildConfig.FLAVOR;
            }
            map.put("ops", ops);
            String objId = bannerData.getObjId();
            if (objId == null) {
                objId = BuildConfig.FLAVOR;
            }
            map.put("object_id", objId);
            String content = bannerData.getContent();
            if (content != null) {
                str = content;
            }
            map.put("title", str);
            return;
        }
        String subjectId = bannerData.getSubjectId();
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        map.put("subject_id", subjectId);
        map.put("has_resource", String.valueOf(bannerData.getHasResource()));
        map.put("subject_type", String.valueOf(bannerData.getSubjectType()));
        String ops2 = bannerData.getOps();
        if (ops2 == null) {
            ops2 = BuildConfig.FLAVOR;
        }
        map.put("ops", ops2);
        String content2 = bannerData.getContent();
        if (content2 == null) {
            content2 = BuildConfig.FLAVOR;
        }
        map.put("content", content2);
        map.put("builtin", bannerData.getBuiltIn() ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        String deepLink = bannerData.getDeepLink();
        if (deepLink != null) {
            str = deepLink;
        }
        map.put("deeplink", str);
        map.put("seenStatus", String.valueOf(bannerData.getSeenStatus()));
    }

    public static final void c(BffCommonOpData bffCommonOpData, Map map) {
        Intrinsics.h(bffCommonOpData, "<this>");
        Intrinsics.h(map, "map");
        String id = bffCommonOpData.getId();
        String str = BuildConfig.FLAVOR;
        if (id == null) {
            id = BuildConfig.FLAVOR;
        }
        map.put("post_id", id);
        Integer postType = bffCommonOpData.getPostType();
        map.put("post_media_type", String.valueOf(postType != null ? postType.intValue() : 0));
        String content = bffCommonOpData.getContent();
        if (content == null) {
            content = BuildConfig.FLAVOR;
        }
        map.put("content", content);
        String deepLink = bffCommonOpData.getDeepLink();
        if (deepLink == null) {
            deepLink = BuildConfig.FLAVOR;
        }
        map.put("deeplink", deepLink);
        String opItemId = bffCommonOpData.getOpItemId();
        if (opItemId == null) {
            opItemId = BuildConfig.FLAVOR;
        }
        map.put("opItemId", opItemId);
        String ops = bffCommonOpData.getOps();
        if (ops != null) {
            str = ops;
        }
        map.put("ops", str);
    }

    public static final void d(Subject subject, Map map) {
        Intrinsics.h(subject, "<this>");
        Intrinsics.h(map, "map");
        String subjectId = subject.getSubjectId();
        String str = BuildConfig.FLAVOR;
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        map.put("subject_id", subjectId);
        map.put("has_resource", String.valueOf(subject.getHasResource()));
        map.put("subject_type", String.valueOf(subject.getSubjectType()));
        String ops = subject.getOps();
        if (ops != null) {
            str = ops;
        }
        map.put("ops", str);
        map.put("builtin", subject.getBuiltIn() ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        map.put("tag", String.valueOf(subject.getTags()));
        map.put("seenStatus", String.valueOf(subject.getSeenStatus()));
    }

    public static final void e(UGCVideo uGCVideo, Map map) {
        String str;
        Intrinsics.h(uGCVideo, "<this>");
        Intrinsics.h(map, "map");
        String ugcVideoId = uGCVideo.getUgcVideoId();
        String str2 = BuildConfig.FLAVOR;
        if (ugcVideoId == null) {
            ugcVideoId = BuildConfig.FLAVOR;
        }
        map.put("content_id", ugcVideoId);
        UGCVideoBelongToCollection belongToCollection = uGCVideo.getBelongToCollection();
        if (belongToCollection == null || (str = belongToCollection.getCollectionId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        map.put("belong_to_collection_id", str);
        map.put("content_type", "ugc_video");
        String subjectId = uGCVideo.getSubjectId();
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        map.put("refer_subject_id", subjectId);
        String ops = uGCVideo.getOps();
        if (ops != null) {
            str2 = ops;
        }
        map.put("ops", str2);
        map.put("builtin", uGCVideo.getBuiltIn() ? MsgStyle.CUSTOM_LEFT_PIC : "0");
    }
}
