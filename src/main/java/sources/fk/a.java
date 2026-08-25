package fk;

import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    public static final void a(Subject subject, String str, String str2) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "moduleName");
        if (subject == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_rank_list_item");
        hashMap.put("module_name", str2);
        hashMap.put("seenStatus", String.valueOf(subject.getSeenStatus()));
        String subjectId = subject.getSubjectId();
        String str3 = BuildConfig.FLAVOR;
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", subjectId);
        hashMap.put("has_resource", String.valueOf(subject.getHasResource()));
        hashMap.put("subject_type", String.valueOf(subject.getSubjectType()));
        String ops = subject.getOps();
        if (ops != null) {
            str3 = ops;
        }
        hashMap.put("ops", str3);
        hashMap.put("tag", String.valueOf(subject.getTags()));
        com.transsion.baselib.helper.a.a.e(str, hashMap);
    }

    public static final void b(Subject subject, String str, String str2) {
        String str3;
        String ops;
        Integer seenStatus;
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", (subject == null || (seenStatus = subject.getSeenStatus()) == null || seenStatus.intValue() != 1) ? "click_course_subscribe" : "click_course_unsubscribe");
        hashMap.put("module_name", str2);
        String str4 = BuildConfig.FLAVOR;
        if (subject == null || (str3 = subject.getSubjectId()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", str3);
        hashMap.put("has_resource", String.valueOf(subject != null ? subject.getHasResource() : null));
        hashMap.put("subject_type", String.valueOf(subject != null ? subject.getSubjectType() : null));
        if (subject != null && (ops = subject.getOps()) != null) {
            str4 = ops;
        }
        hashMap.put("ops", str4);
        hashMap.put("tag", String.valueOf(subject != null ? subject.getTags() : null));
        hashMap.put("seenStatus", String.valueOf(subject != null ? subject.getSeenStatus() : null));
        com.transsion.baselib.helper.a.a.b(str, hashMap);
    }
}
