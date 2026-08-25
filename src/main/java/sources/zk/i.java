package zk;

import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i {
    private final HashSet a = new HashSet();
    private final HashSet b = new HashSet();

    public final void a(String str, String str2, String str3, String str4, Integer num, boolean z, String str5, String str6, String str7) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", str2);
        hashMap.put("subject_id", str3);
        hashMap.put("ops", str4);
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        hashMap.put("position", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z);
        hashMap.put("has_resource", sb2.toString());
        hashMap.put("category", String.valueOf(str5));
        hashMap.put("rec_type", String.valueOf(str6));
        hashMap.put("label", String.valueOf(str7));
        com.transsion.baselib.helper.a.a.i(str, hashMap);
    }

    public final void b(String str, String str2, String str3, Integer num, String str4, String str5, String str6) {
        Intrinsics.h(str, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("staff_id", String.valueOf(str2));
        hashMap.put("ops", String.valueOf(str3));
        hashMap.put("position", String.valueOf(num));
        if (str2 != null) {
            boolean contains = this.b.contains(str2);
            this.b.add(str2);
            if (contains) {
                return;
            }
        }
        hashMap.put("category", String.valueOf(str4));
        hashMap.put("rec_type", String.valueOf(str5));
        hashMap.put("label", String.valueOf(str6));
        com.transsion.baselib.helper.a.a.a(str, hashMap);
    }

    public final void c(String str, String str2, String str3, Integer num, String str4, String str5, String str6) {
        Intrinsics.h(str, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("staff_id", String.valueOf(str2));
        hashMap.put("ops", String.valueOf(str3));
        hashMap.put("position", String.valueOf(num));
        hashMap.put("category", String.valueOf(str4));
        hashMap.put("rec_type", String.valueOf(str5));
        hashMap.put("label", String.valueOf(str6));
        com.transsion.baselib.helper.a.a.f(str, hashMap);
    }

    public final void d(String str, String str2, String str3, Integer num, boolean z, String str4, String str5, String str6) {
        Intrinsics.h(str, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", String.valueOf(str2));
        hashMap.put("ops", String.valueOf(str3));
        hashMap.put("position", String.valueOf(num));
        if (str2 != null) {
            boolean contains = this.a.contains(str2);
            this.a.add(str2);
            if (contains) {
                return;
            }
        }
        hashMap.put("has_resource", String.valueOf(z));
        hashMap.put("category", String.valueOf(str4));
        hashMap.put("rec_type", String.valueOf(str5));
        hashMap.put("label", String.valueOf(str6));
        com.transsion.baselib.helper.a.a.a(str, hashMap);
    }

    public final void e(String str, String str2, String str3, Integer num, boolean z, String str4, String str5, String str6) {
        Intrinsics.h(str, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", String.valueOf(str2));
        hashMap.put("ops", String.valueOf(str3));
        hashMap.put("position", String.valueOf(num));
        hashMap.put("has_resource", String.valueOf(z));
        hashMap.put("category", String.valueOf(str4));
        hashMap.put("rec_type", String.valueOf(str5));
        hashMap.put("label", String.valueOf(str6));
        com.transsion.baselib.helper.a.a.f(str, hashMap);
    }
}
