package com.cloud.sdk.commonutil.gsonutil;

import com.cloud.sdk.commonutil.util.c;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import m7.e;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class GsonUtil {

    public static class GsonParseException extends Exception {
        public GsonParseException(Throwable th) {
            super(th);
        }
    }

    public static Object a(String str, Class cls) {
        try {
            return c().fromJson(str, cls);
        } catch (Exception e) {
            throw new GsonParseException(e);
        }
    }

    public static Object b(String str, Type type) {
        try {
            return c().fromJson(str, type);
        } catch (Exception e) {
            throw new GsonParseException(e);
        }
    }

    public static Gson c() {
        return e.a();
    }

    public static String d(Object obj) {
        try {
            return c().toJson(obj);
        } catch (Exception e) {
            c.Log().e("GsonUtil", e.getMessage());
            return "";
        }
    }
}
