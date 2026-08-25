package xs;

import com.transsion.shorttv_pugc.bean.Subject;
import java.util.HashSet;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static final a b = new a(null);
    private final HashSet a = new HashSet();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void a(String pageName, Subject item, int i, long j, String optType) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(item, "item");
        Intrinsics.h(optType, "optType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.a.contains(item.getSubjectId())) {
            return;
        }
        this.a.add(item.getSubjectId());
        linkedHashMap.put("position", String.valueOf(i));
        linkedHashMap.put("opt_type", optType);
        linkedHashMap.put("ops", String.valueOf(item.getOps()));
        linkedHashMap.put("subject_id", String.valueOf(item.getSubjectId()));
        linkedHashMap.put("item_type", "subject");
        linkedHashMap.put("browse_duration", String.valueOf(j));
        h.a.z(pageName, linkedHashMap);
    }

    public final void b(String pageName, Subject subject, int i, String optType) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(optType, "optType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("position", String.valueOf(i));
        linkedHashMap.put("opt_type", optType);
        linkedHashMap.put("subject_id", String.valueOf(subject != null ? subject.getSubjectId() : null));
        linkedHashMap.put("item_type", "subject");
        linkedHashMap.put("ops", String.valueOf(subject != null ? subject.getOps() : null));
        h.a.o(pageName, linkedHashMap);
    }
}
