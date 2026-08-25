package com.apm.insight.h;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    private static final Map<Class<?>, Class<?>> a;

    /* renamed from: com.apm.insight.h.a$a, reason: collision with other inner class name */
    public static class C0006a<T> {
        public final Class<? extends T> a;
        public final T b;
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        Class cls = Boolean.TYPE;
        hashMap.put(Boolean.class, cls);
        Class cls2 = Byte.TYPE;
        hashMap.put(Byte.class, cls2);
        Class cls3 = Character.TYPE;
        hashMap.put(Character.class, cls3);
        Class cls4 = Short.TYPE;
        hashMap.put(Short.class, cls4);
        Class cls5 = Integer.TYPE;
        hashMap.put(Integer.class, cls5);
        Class cls6 = Float.TYPE;
        hashMap.put(Float.class, cls6);
        Class cls7 = Long.TYPE;
        hashMap.put(Long.class, cls7);
        Class cls8 = Double.TYPE;
        hashMap.put(Double.class, cls8);
        hashMap.put(cls, cls);
        hashMap.put(cls2, cls2);
        hashMap.put(cls3, cls3);
        hashMap.put(cls4, cls4);
        hashMap.put(cls5, cls5);
        hashMap.put(cls6, cls6);
        hashMap.put(cls7, cls7);
        hashMap.put(cls8, cls8);
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        Method method;
        Class<?>[] parameterTypes;
        try {
            Class<?> cls = Class.forName(str);
            Class<?>[] clsArr = new Class[4];
            for (int i = 0; i < 4; i++) {
                Object obj = objArr[i];
                clsArr[i] = (obj == null || !(obj instanceof C0006a)) ? obj == null ? null : obj.getClass() : ((C0006a) obj).a;
            }
            while (true) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        method = null;
                        break;
                    }
                    method = declaredMethods[i2];
                    if (method.getName().equals(str2) && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 4) {
                        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                            if (!parameterTypes[i3].isAssignableFrom(clsArr[i3])) {
                                Map<Class<?>, Class<?>> map = a;
                                if (map.containsKey(parameterTypes[i3]) && map.get(parameterTypes[i3]).equals(map.get(clsArr[i3]))) {
                                }
                            }
                        }
                        break;
                    }
                    i2++;
                }
                if (method != null) {
                    method.setAccessible(true);
                    Object[] objArr2 = new Object[4];
                    for (int i4 = 0; i4 < 4; i4++) {
                        Object obj2 = objArr[i4];
                        if (obj2 == null || !(obj2 instanceof C0006a)) {
                            objArr2[i4] = obj2;
                        } else {
                            objArr2[i4] = ((C0006a) obj2).b;
                        }
                    }
                    return (T) method.invoke(null, objArr2);
                }
                if (cls.getSuperclass() == null) {
                    throw new NoSuchMethodException();
                }
                cls = cls.getSuperclass();
            }
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str, e);
            return null;
        }
    }
}
