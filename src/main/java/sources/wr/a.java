package wr;

import com.transsion.shorttv.bean.Subject;
import java.util.HashSet;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final C0101a b = new C0101a(null);
    private final HashSet a = new HashSet();

    /* renamed from: wr.a$a, reason: collision with other inner class name */
    public static final class C0101a {
        private C0101a() {
        }

        public /* synthetic */ C0101a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void b(a aVar, String str, Subject subject, int i, Long l, String str2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            l = null;
        }
        aVar.a(str, subject, i, l, str2);
    }

    public final void a(String str, Subject subject, int i, Long l, String str2) {
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
        if (l != null) {
            linkedHashMap.put("browse_duration", String.valueOf(l.longValue()));
        }
        or.b.a.a();
        h.a.z(str, linkedHashMap);
    }

    public final void c(String str, Subject subject, int i, String str2) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "optType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("position", String.valueOf(i));
        linkedHashMap.put("opt_type", str2);
        linkedHashMap.put("subject_id", String.valueOf(subject != null ? subject.getSubjectId() : null));
        linkedHashMap.put("item_type", "subject");
        linkedHashMap.put("ops", String.valueOf(subject != null ? subject.getOps() : null));
        or.b.a.a();
        h.a.o(str, linkedHashMap);
    }
}
