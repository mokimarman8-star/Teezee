package com.blankj.utilcode.util;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class x {
    private static final Map b = new HashMap();
    private SharedPreferences a;

    private x(String str, int i) {
        this.a = Utils.a().getSharedPreferences(str, i);
    }

    public static x a(String str) {
        return b(str, 0);
    }

    public static x b(String str, int i) {
        if (e(str)) {
            str = "spUtils";
        }
        Map map = b;
        x xVar = (x) map.get(str);
        if (xVar == null) {
            synchronized (x.class) {
                try {
                    xVar = (x) map.get(str);
                    if (xVar == null) {
                        xVar = new x(str, i);
                        map.put(str, xVar);
                    }
                } finally {
                }
            }
        }
        return xVar;
    }

    private static boolean e(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String c(String str) {
        return d(str, "");
    }

    public String d(String str, String str2) {
        return this.a.getString(str, str2);
    }

    public void f(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (z) {
            this.a.edit().putString(str, str2).commit();
        } else {
            this.a.edit().putString(str, str2).apply();
        }
    }

    public void h(String str) {
        i(str, false);
    }

    public void i(String str, boolean z) {
        if (z) {
            this.a.edit().remove(str).commit();
        } else {
            this.a.edit().remove(str).apply();
        }
    }
}
