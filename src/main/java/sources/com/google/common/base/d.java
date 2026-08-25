package com.google.common.base;

import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class d {
    private static final Map a = new WeakHashMap();

    static Map a(Class cls) {
        Map map;
        Map map2 = a;
        synchronized (map2) {
            try {
                map = (Map) map2.get(cls);
                if (map == null) {
                    map = c(cls);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map;
    }

    public static Optional b(Class cls, String str) {
        m.o(cls);
        m.o(str);
        return l.b(cls, str);
    }

    private static Map c(Class cls) {
        HashMap hashMap = new HashMap();
        Iterator it = EnumSet.allOf(cls).iterator();
        while (it.hasNext()) {
            Enum r2 = (Enum) it.next();
            hashMap.put(r2.name(), new WeakReference(r2));
        }
        a.put(cls, hashMap);
        return hashMap;
    }
}
