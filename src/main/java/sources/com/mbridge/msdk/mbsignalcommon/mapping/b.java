package com.mbridge.msdk.mbsignalcommon.mapping;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class b {

    public static class a<C> {
        protected Class<C> a;

        public a(Class<C> cls) {
            this.a = cls;
        }

        public C0110b a(String str, Class<?>... clsArr) throws com.mbridge.msdk.mbsignalcommon.mapping.a {
            return new C0110b(this.a, str, clsArr, 0);
        }
    }

    /* renamed from: com.mbridge.msdk.mbsignalcommon.mapping.b$b, reason: collision with other inner class name */
    public static class C0110b {
        protected final Method a;

        C0110b(Class<?> cls, String str, Class<?>[] clsArr, int i) throws com.mbridge.msdk.mbsignalcommon.mapping.a {
            Method method = null;
            if (cls == null) {
                return;
            }
            while (cls != Object.class && cls != null) {
                try {
                    method = cls.getDeclaredMethod(str, clsArr);
                    break;
                } catch (NoSuchMethodException e) {
                    if (MBridgeConstans.DEBUG && cls.getSuperclass() == Object.class) {
                        e.printStackTrace();
                    }
                    cls = cls.getSuperclass();
                } catch (SecurityException e2) {
                    try {
                        if (MBridgeConstans.DEBUG && cls.getSuperclass() == Object.class) {
                            e2.printStackTrace();
                        }
                        cls = cls.getSuperclass();
                    } catch (Exception e3) {
                        com.mbridge.msdk.mbsignalcommon.mapping.a aVar = new com.mbridge.msdk.mbsignalcommon.mapping.a(e3);
                        aVar.a(cls);
                        aVar.a(str);
                        b.b(aVar);
                        return;
                    } finally {
                        this.a = method;
                    }
                }
            }
            if (method != null) {
                if (i > 0 && (method.getModifiers() & i) != i) {
                    b.b(new com.mbridge.msdk.mbsignalcommon.mapping.a(method + " does not match modifiers: " + i));
                }
                method.setAccessible(true);
            }
        }

        public Object a(Object obj, Object... objArr) throws IllegalArgumentException, InvocationTargetException {
            Method method = this.a;
            if (method == null) {
                return null;
            }
            try {
                return method.invoke(obj, objArr);
            } catch (Exception e) {
                o0.a("MappingedMethod", "invoke error:" + e.getMessage());
                return null;
            }
        }

        public Method a() {
            return this.a;
        }
    }

    public static <T> a<T> a(ClassLoader classLoader, String str) throws com.mbridge.msdk.mbsignalcommon.mapping.a {
        try {
            return new a<>(classLoader.loadClass(str));
        } catch (Exception e) {
            b(new com.mbridge.msdk.mbsignalcommon.mapping.a(e));
            return new a<>(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.mbridge.msdk.mbsignalcommon.mapping.a aVar) throws com.mbridge.msdk.mbsignalcommon.mapping.a {
        throw aVar;
    }
}
