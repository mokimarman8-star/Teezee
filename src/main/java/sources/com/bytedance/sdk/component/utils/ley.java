package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ley {
    public static Class<?> Sj(String str) {
        try {
            try {
                try {
                    return Class.forName(str, true, Sj());
                } catch (ClassNotFoundException unused) {
                    return Class.forName(str);
                }
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return Class.forName(str, true, ley.class.getClassLoader());
        }
    }

    private static ClassLoader Sj() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? ley.class.getClassLoader() : contextClassLoader;
    }

    public static Method Sj(String str, String str2, Class<?>... clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class<?> Sj = Sj(str);
            if (Sj != null) {
                return Sj.getMethod(str2, clsArr);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
