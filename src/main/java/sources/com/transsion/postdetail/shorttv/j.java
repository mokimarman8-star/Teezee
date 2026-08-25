package com.transsion.postdetail.shorttv;

import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashSet;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j {
    public static final a b = new a(null);
    private final HashSet a = new HashSet();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void a(String str, Subject subject, int i, long j, String str2) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(subject, "item");
        Intrinsics.h(str2, "optType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.a.contains(subject.getSubjectId())) {
            return;
        }
        this.a.add(subject.getSubjectId());
        linkedHashMap.put("position", String.valueOf(i));
        linkedHashMap.put("opt_type", str2);
        linkedHashMap.put("ops", String.valueOf(subject.getOps()));
        linkedHashMap.put("subject_id", String.valueOf(subject.getSubjectId()));
        linkedHashMap.put("item_type", "subject");
        linkedHashMap.put("browse_duration", String.valueOf(j));
        qi.h.a.z(str, linkedHashMap);
    }

    public final void b(String str, Subject subject, int i, String str2) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "optType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("position", String.valueOf(i));
        linkedHashMap.put("opt_type", str2);
        linkedHashMap.put("subject_id", String.valueOf(subject != null ? subject.getSubjectId() : null));
        linkedHashMap.put("item_type", "subject");
        linkedHashMap.put("ops", String.valueOf(subject != null ? subject.getOps() : null));
        qi.h.a.o(str, linkedHashMap);
    }
}
