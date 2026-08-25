package com.transsion.json;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class b {
    public static Object a(String str, Class cls) {
        if (str == null) {
            throw new Exception("The Json is Null: ");
        }
        try {
            return new i().b(str, cls);
        } catch (Exception unused) {
            throw new Exception("error json:" + str);
        }
    }

    public static String b(Object obj) {
        return c(obj, false);
    }

    public static String c(Object obj, boolean z) {
        if (obj != null) {
            return new j().b(new String[]{"*.class"}).a(z).c(obj);
        }
        throw new IllegalStateException("The Object is Null: ");
    }
}
