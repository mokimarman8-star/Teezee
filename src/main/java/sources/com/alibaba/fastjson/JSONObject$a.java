package com.alibaba.fastjson;

import a5.h;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class JSONObject$a extends ObjectInputStream {

    /* renamed from: a, reason: collision with root package name */
    static Field[] f14560a;

    /* renamed from: b, reason: collision with root package name */
    static volatile boolean f14561b;

    public JSONObject$a(ObjectInputStream objectInputStream) {
        super(objectInputStream);
        int i5 = 0;
        while (true) {
            try {
                Field[] fieldArr = f14560a;
                if (i5 >= fieldArr.length) {
                    return;
                }
                Field field = fieldArr[i5];
                field.set(this, field.get(objectInputStream));
                i5++;
            } catch (IllegalAccessException unused) {
                f14561b = true;
                return;
            }
        }
    }

    static void d() {
        if (f14560a != null || f14561b) {
            return;
        }
        try {
            Field[] declaredFields = ObjectInputStream.class.getDeclaredFields();
            String[] strArr = {"bin", "passHandle", "handles", "curContext"};
            Field[] fieldArr = new Field[4];
            for (int i5 = 0; i5 < 4; i5++) {
                Field X = TypeUtils.X(ObjectInputStream.class, strArr[i5], declaredFields);
                X.setAccessible(true);
                fieldArr[i5] = X;
            }
            f14560a = fieldArr;
        } catch (Throwable unused) {
            f14561b = true;
        }
    }

    @Override // java.io.ObjectInputStream
    protected void readStreamHeader() {
    }

    @Override // java.io.ObjectInputStream
    protected Class resolveClass(ObjectStreamClass objectStreamClass) {
        String name = objectStreamClass.getName();
        if (name.length() > 2) {
            int lastIndexOf = name.lastIndexOf(91);
            if (lastIndexOf != -1) {
                name = name.substring(lastIndexOf + 1);
            }
            if (name.length() > 2 && name.charAt(0) == 'L' && name.charAt(name.length() - 1) == ';') {
                name = name.substring(1, name.length() - 1);
            }
            if (TypeUtils.R(name) == null) {
                h.z.j(name, (Class) null, Feature.SupportAutoType.mask);
            }
        }
        return super.resolveClass(objectStreamClass);
    }

    @Override // java.io.ObjectInputStream
    protected Class resolveProxyClass(String[] strArr) {
        for (String str : strArr) {
            if (TypeUtils.R(str) == null) {
                h.z.i(str, (Class) null);
            }
        }
        return super.resolveProxyClass(strArr);
    }
}
