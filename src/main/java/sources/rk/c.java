package rk;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.ExplainBean;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.push.bean.MsgStyle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import qi.h;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    private HashSet a;
    private String b;

    public c(String str) {
        Intrinsics.h(str, "page");
        this.b = str;
    }

    public final void a(BaseProviderMultiAdapter baseProviderMultiAdapter, int i, long j) {
        List explains;
        Boolean hasResource;
        String subjectId;
        HashSet hashSet;
        Intrinsics.h(baseProviderMultiAdapter, "adapter");
        if (i >= baseProviderMultiAdapter.getData().size()) {
            return;
        }
        OperateItem operateItem = (OperateItem) baseProviderMultiAdapter.getItem(i);
        if (Intrinsics.c(operateItem.getType(), PostItemType.SINGLE_SUBJECT.getValue()) || Intrinsics.c(operateItem.getType(), PostItemType.SUBJECT.getValue())) {
            if (this.a == null) {
                this.a = new HashSet();
            }
            HashMap hashMap = new HashMap();
            HashSet hashSet2 = this.a;
            if (hashSet2 != null) {
                Subject feedsSubject = operateItem.getFeedsSubject();
                if (CollectionsKt.b0(hashSet2, feedsSubject != null ? feedsSubject.getSubjectId() : null)) {
                    a.a aVar = wf.a.a;
                    Subject feedsSubject2 = operateItem.getFeedsSubject();
                    a.a.f(aVar, "reportExposure", "trendFragment position:" + i + ",subjectId: + " + (feedsSubject2 != null ? feedsSubject2.getSubjectId() : null) + "}", false, 4, (Object) null);
                    return;
                }
            }
            Subject feedsSubject3 = operateItem.getFeedsSubject();
            if (feedsSubject3 != null && (subjectId = feedsSubject3.getSubjectId()) != null && subjectId.length() > 0 && (hashSet = this.a) != null) {
                Subject feedsSubject4 = operateItem.getFeedsSubject();
                String subjectId2 = feedsSubject4 != null ? feedsSubject4.getSubjectId() : null;
                Intrinsics.e(subjectId2);
                hashSet.add(subjectId2);
            }
            hashMap.put("sequence", String.valueOf(i));
            hashMap.put("item_type", "rec");
            Subject feedsSubject5 = operateItem.getFeedsSubject();
            hashMap.put("ops", feedsSubject5 != null ? feedsSubject5.getOps() : null);
            Subject feedsSubject6 = operateItem.getFeedsSubject();
            hashMap.put("subject_id", feedsSubject6 != null ? feedsSubject6.getSubjectId() : null);
            hashMap.put("browse_duration", String.valueOf(j));
            Subject feedsSubject7 = operateItem.getFeedsSubject();
            hashMap.put("has_resource", (feedsSubject7 == null || (hasResource = feedsSubject7.getHasResource()) == null) ? null : hasResource.toString());
            Subject feedsSubject8 = operateItem.getFeedsSubject();
            hashMap.put("is_cache", String.valueOf(feedsSubject8 != null ? Boolean.valueOf(feedsSubject8.isCache()) : null));
            Subject feedsSubject9 = operateItem.getFeedsSubject();
            hashMap.put("load_cover_success", String.valueOf(feedsSubject9 != null ? Boolean.valueOf(feedsSubject9.getLoadCoverSuccess()) : null));
            Subject feedsSubject10 = operateItem.getFeedsSubject();
            hashMap.put("load_cover_duration", String.valueOf(feedsSubject10 != null ? Long.valueOf(feedsSubject10.getLoadCoverDuration()) : null));
            Subject feedsSubject11 = operateItem.getFeedsSubject();
            hashMap.put("cover_cache", String.valueOf(feedsSubject11 != null ? Boolean.valueOf(feedsSubject11.getCoverCache()) : null));
            Subject feedsSubject12 = operateItem.getFeedsSubject();
            hashMap.put("builtin", (feedsSubject12 == null || !feedsSubject12.getBuiltIn()) ? "0" : MsgStyle.CUSTOM_LEFT_PIC);
            StringBuilder sb = new StringBuilder();
            Subject feedsSubject13 = operateItem.getFeedsSubject();
            if (feedsSubject13 != null && (explains = feedsSubject13.getExplains()) != null) {
                Iterator it = explains.iterator();
                while (it.hasNext()) {
                    sb.append(((ExplainBean) it.next()).getType());
                    sb.append(",");
                }
            }
            String sb2 = sb.toString();
            Intrinsics.g(sb2, "toString(...)");
            hashMap.put("rec_explain_type", StringsKt.r1(sb2, new char[]{','}));
            h.a.z(this.b, hashMap);
        }
    }

    public final void b(int i, Subject subject) {
        Intrinsics.h(subject, "item");
        HashMap hashMap = new HashMap();
        hashMap.put("sequence", String.valueOf(i));
        hashMap.put("item_type", "rec");
        hashMap.put("ops", subject.getOps());
        hashMap.put("subject_id", subject.getSubjectId());
        hashMap.put("builtin", subject.getBuiltIn() ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        StringBuilder sb = new StringBuilder();
        List explains = subject.getExplains();
        if (explains != null) {
            Iterator it = explains.iterator();
            while (it.hasNext()) {
                sb.append(((ExplainBean) it.next()).getType());
                sb.append(",");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "toString(...)");
        hashMap.put("rec_explain_type", StringsKt.r1(sb2, new char[]{','}));
        h.a.o(this.b, hashMap);
    }
}
