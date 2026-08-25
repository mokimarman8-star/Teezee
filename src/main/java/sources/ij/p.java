package ij;

import java.util.HashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class p {
    public static final void a(String str, String str2, String str3, Float f) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "long_pressed");
        hashMap.put("subject_id", str2);
        hashMap.put("ops", str3);
        hashMap.put("speed", String.valueOf(f));
        qi.h hVar = qi.h.a;
        if (str == null) {
            return;
        }
        hVar.o(str, hashMap);
    }

    public static final void b(String str, long j, String str2, String str3, Float f) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "long_pressed");
        hashMap.put("subject_id", str2);
        hashMap.put("ops", str3);
        hashMap.put("speed", String.valueOf(f));
        hashMap.put("duration", String.valueOf(j));
        qi.h hVar = qi.h.a;
        if (str == null) {
            return;
        }
        hVar.z(str, hashMap);
    }
}
