package com.alibaba.fastjson.util;

import java.util.concurrent.Callable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class i {
    private static boolean a;

    static {
        try {
            Class.forName("java.sql.Time");
            a = true;
        } catch (Throwable unused) {
            a = false;
        }
    }

    public static Object a(c cVar, Object obj, Object obj2) {
        if (a) {
            return cVar.apply(obj, obj2);
        }
        return null;
    }

    public static Object b(e eVar, Object obj) {
        if (a) {
            return eVar.apply(obj);
        }
        return null;
    }

    public static Object c(Callable callable) {
        if (!a) {
            return null;
        }
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
