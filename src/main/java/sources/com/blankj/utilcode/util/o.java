package com.blankj.utilcode.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class o {
    private static final Map a = new ConcurrentHashMap();

    private static Gson a() {
        return new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    }

    public static Object b(Gson gson, String str, Class cls) {
        return gson.fromJson(str, cls);
    }

    public static Object c(Gson gson, String str, Type type) {
        return gson.fromJson(str, type);
    }

    public static Object d(String str, Class cls) {
        return b(f(), str, cls);
    }

    public static Object e(String str, Type type) {
        return c(f(), str, type);
    }

    public static Gson f() {
        Map map = a;
        Gson gson = (Gson) map.get("delegateGson");
        if (gson != null) {
            return gson;
        }
        Gson gson2 = (Gson) map.get("defaultGson");
        if (gson2 != null) {
            return gson2;
        }
        Gson a2 = a();
        map.put("defaultGson", a2);
        return a2;
    }

    public static Type g(Type type) {
        return TypeToken.getParameterized(List.class, new Type[]{type}).getType();
    }

    public static Type h(Type type, Type... typeArr) {
        return TypeToken.getParameterized(type, typeArr).getType();
    }

    public static String i(Gson gson, Object obj) {
        return gson.toJson(obj);
    }

    public static String j(Object obj) {
        return i(f(), obj);
    }
}
