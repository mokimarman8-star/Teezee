package yz;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class d {
    protected static Map a = new HashMap();

    public static c a() {
        return null;
    }

    public static c b() {
        return null;
    }

    public static c c(Class cls) {
        android.support.v4.media.session.c.a(a.get(cls));
        return null;
    }

    public static boolean d() {
        return false;
    }

    public static boolean e() {
        return false;
    }

    public static boolean f(Class cls) {
        if (cls == null) {
            return false;
        }
        if (a.containsKey(cls)) {
            return true;
        }
        Class cls2 = cls;
        do {
            if (cls != cls2 && a.containsKey(cls2)) {
                Map map = a;
                map.put(cls, map.get(cls2));
                return true;
            }
            for (Class<?> cls3 : cls2.getInterfaces()) {
                if (a.containsKey(cls3)) {
                    Map map2 = a;
                    map2.put(cls, map2.get(cls3));
                    return true;
                }
            }
            cls2 = cls2.getSuperclass();
            if (cls2 == null) {
                break;
            }
        } while (cls2 != Object.class);
        return false;
    }
}
