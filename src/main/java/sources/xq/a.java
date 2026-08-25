package xq;

import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final HashSet a = new HashSet();

    public final void a(String str, String str2, String str3, Integer num, String str4, boolean z, String str5) {
        Intrinsics.h(str, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", str2);
        hashMap.put("ops", str3);
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        hashMap.put("position", sb.toString());
        hashMap.put("item_type", str4);
        if (str2 != null) {
            boolean contains = this.a.contains(str2);
            this.a.add(str2);
            if (contains) {
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z);
        hashMap.put("has_resource", sb2.toString());
        hashMap.put("category_type", str5);
        h.a.z(str, hashMap);
    }

    public final void b(String str, String str2, String str3, String str4, Integer num, String str5, boolean z, String str6) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", str2);
        hashMap.put("subject_id", str3);
        hashMap.put("ops", str4);
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        hashMap.put("position", sb.toString());
        hashMap.put("item_type", str5);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z);
        hashMap.put("has_resource", sb2.toString());
        hashMap.put("category_type", str6);
        h.a.o(str, hashMap);
    }
}
