package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class AdaptScreenUtils {
    private static List a;

    private static void b(Resources resources, float f) {
        resources.getDisplayMetrics().xdpi = f;
        Utils.a().getResources().getDisplayMetrics().xdpi = f;
        d(resources, f);
    }

    private static void c(Resources resources, float f) {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            try {
                DisplayMetrics displayMetrics = (DisplayMetrics) ((Field) it.next()).get(resources);
                if (displayMetrics != null) {
                    displayMetrics.xdpi = f;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void d(Resources resources, float f) {
        if (a != null) {
            c(resources, f);
            return;
        }
        a = new ArrayList();
        Class<?> cls = resources.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        while (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                    field.setAccessible(true);
                    DisplayMetrics e = e(resources, field);
                    if (e != null) {
                        a.add(field);
                        e.xdpi = f;
                    }
                }
            }
            cls = cls.getSuperclass();
            if (cls == null) {
                return;
            } else {
                declaredFields = cls.getDeclaredFields();
            }
        }
    }

    private static DisplayMetrics e(Resources resources, Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception unused) {
            return null;
        }
    }

    static Runnable f() {
        return new Runnable() { // from class: com.blankj.utilcode.util.AdaptScreenUtils.1
            @Override // java.lang.Runnable
            public void run() {
                AdaptScreenUtils.g();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        b(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }
}
