package com.cloud.tmc.integration.utils.ext;

import com.cloud.hisavana.sdk.d;
import com.cloud.tmc.integration.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u001a7\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u0003`\u0004\"\u0006\b\u0000\u0010\u0003\u0018\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086\b\u001aI\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u0003`\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0006\b\u0002\u0010\u0003\u0018\u0001*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\tH\u0086\b¨\u0006\n"}, d2 = {"cast2HashMap", "Ljava/util/HashMap;", "", "T", "Lkotlin/collections/HashMap;", "any", "", "K", "V", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class MapExtKt {
    public static final /* synthetic */ <T> HashMap<String, T> cast2HashMap(Object obj) {
        d.C0127d c0127d = (HashMap<String, T>) new HashMap();
        if (obj instanceof HashMap) {
            for (Object obj2 : ((HashMap) obj).keySet()) {
                Map map = (Map) obj;
                Object obj3 = map.get(obj2);
                Intrinsics.n(3, "T");
                if (obj3 instanceof Object) {
                    String obj4 = obj2.toString();
                    Object obj5 = map.get(obj2);
                    Intrinsics.n(1, "T");
                    c0127d.put(obj4, obj5);
                }
            }
        }
        return c0127d;
    }

    public static final /* synthetic */ <K, V, T> HashMap<String, T> cast2HashMap(Map<K, ? extends V> map) {
        Intrinsics.h(map, "<this>");
        HashMap<String, T> hashMap = new HashMap<>();
        if (map instanceof HashMap) {
            for (K k : ((HashMap) map).keySet()) {
                V v = map.get(k);
                Intrinsics.n(3, "T");
                if (v instanceof Object) {
                    String obj = k.toString();
                    V v2 = map.get(k);
                    Intrinsics.n(1, "T");
                    hashMap.put(obj, v2);
                }
            }
        }
        return hashMap;
    }
}
