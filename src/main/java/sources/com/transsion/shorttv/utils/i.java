package com.transsion.shorttv.utils;

import com.transsion.shorttv.bean.BannerData;
import com.transsion.shorttv.bean.OperateItem;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.bean.Video;
import com.transsion.web.api.WebConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class i {
    public static final void a(OperateItem operateItem, Map map) {
        Intrinsics.h(operateItem, "<this>");
        Intrinsics.h(map, "map");
        map.put("item_type", "opt");
        String type = operateItem.getType();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (type == null) {
            type = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        map.put("opt_type", type);
        String title = operateItem.getTitle();
        if (title == null) {
            title = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        map.put("opTitle", title);
        String opId = operateItem.getOpId();
        if (opId != null) {
            str = opId;
        }
        map.put("opId", str);
    }

    public static final void b(BannerData bannerData, Map map) {
        Intrinsics.h(bannerData, "<this>");
        Intrinsics.h(map, "map");
        String subjectId = bannerData.getSubjectId();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (subjectId == null) {
            subjectId = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        map.put("subject_id", subjectId);
        map.put("has_resource", String.valueOf(bannerData.getHasResource()));
        map.put("subject_type", String.valueOf(bannerData.getSubjectType()));
        map.put("type", String.valueOf(bannerData.getType()));
        String ops = bannerData.getOps();
        if (ops == null) {
            ops = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        map.put("ops", ops);
        String content = bannerData.getContent();
        if (content == null) {
            content = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        map.put("content", content);
        map.put("builtin", bannerData.getBuiltIn() ? com.vungle.ads.internal.b.AD_VISIBILITY_INVISIBLE : "0");
        String deepLink = bannerData.getDeepLink();
        if (deepLink != null) {
            str = deepLink;
        }
        map.put(WebConstants.FIELD_DEEPLINK, str);
        map.put("seenStatus", String.valueOf(bannerData.getSeenStatus()));
    }

    public static final void c(Subject subject, Map map) {
        Intrinsics.h(subject, "<this>");
        Intrinsics.h(map, "map");
        String subjectId = subject.getSubjectId();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (subjectId == null) {
            subjectId = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        map.put("subject_id", subjectId);
        map.put("has_resource", String.valueOf(subject.getHasResource()));
        map.put("subject_type", String.valueOf(subject.getSubjectType()));
        String ops = subject.getOps();
        if (ops != null) {
            str = ops;
        }
        map.put("ops", str);
        map.put("builtin", subject.getBuiltIn() ? com.vungle.ads.internal.b.AD_VISIBILITY_INVISIBLE : "0");
        map.put("tag", String.valueOf(subject.getTags()));
        map.put("seenStatus", String.valueOf(subject.getSeenStatus()));
    }

    public static final Video d(List list, int i) {
        Object obj;
        Object obj2;
        Intrinsics.h(list, "<this>");
        List list2 = list;
        Iterator it = list2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (Intrinsics.c(((Video) obj2).getResolution(), String.valueOf(i))) {
                break;
            }
        }
        Video video = (Video) obj2;
        if (video != null) {
            return video;
        }
        Iterator it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (Intrinsics.c(((Video) next).getResolution(), "480")) {
                obj = next;
                break;
            }
        }
        Video video2 = (Video) obj;
        return video2 == null ? (Video) CollectionsKt.k0(list) : video2;
    }

    public static final String e(Integer num) {
        int intValue = num != null ? num.intValue() : 0;
        if (1 > intValue || intValue >= 10) {
            return String.valueOf(intValue);
        }
        return "0" + intValue;
    }
}
