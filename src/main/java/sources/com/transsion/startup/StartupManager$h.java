package com.transsion.startup;

import com.wecloud.load.lib.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import qi.h;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class StartupManager$h implements j.a {
    StartupManager$h() {
    }

    @Override // com.wecloud.load.lib.j.a
    public void a(String eventName, Map data) {
        Intrinsics.h(eventName, "eventName");
        Intrinsics.h(data, "data");
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.e(data.size()));
            for (Object obj : data.entrySet()) {
                Object key = ((Map.Entry) obj).getKey();
                Object value = ((Map.Entry) obj).getValue();
                if (value != null && (r1 = value.toString()) != null) {
                    linkedHashMap.put(key, r1);
                }
                String str = HttpUrl.FRAGMENT_ENCODE_SET;
                linkedHashMap.put(key, str);
            }
            h.a.r(eventName, linkedHashMap);
        } catch (Throwable th) {
            a.a.l(wf.a.a, "StartupManager", "network probe report error: " + th, false, 4, (Object) null);
        }
    }
}
