package org.lsposed.hiddenapibypass;

import android.util.Log;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import sun.misc.Unsafe;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class l {
    private static final Unsafe a;
    private static final long b;
    private static final long c;
    private static final long d;
    private static final long e;
    private static final long f;
    private static final long g;
    private static final long h;
    private static final long i;
    private static final long j;
    private static final long k;
    private static final long l;
    private static final long m;
    private static final Set n = new HashSet();

    static {
        MethodHandles.Lookup lookup;
        MethodHandle unreflect;
        MethodHandles.Lookup lookup2;
        MethodHandle unreflect2;
        MethodHandles.Lookup lookup3;
        MethodHandle unreflectGetter;
        MethodHandles.Lookup lookup4;
        MethodHandle unreflectGetter2;
        try {
            Unsafe unsafe = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", null).invoke(null, null);
            a = unsafe;
            b = unsafe.objectFieldOffset(c.class.getDeclaredField("artMethod"));
            c = unsafe.objectFieldOffset(c.class.getDeclaredField("declaringClass"));
            long objectFieldOffset = unsafe.objectFieldOffset(f.class.getDeclaredField("artFieldOrMethod"));
            d = objectFieldOffset;
            e = unsafe.objectFieldOffset(g.class.getDeclaredField("info"));
            long objectFieldOffset2 = unsafe.objectFieldOffset(b.class.getDeclaredField("methods"));
            f = objectFieldOffset2;
            long objectFieldOffset3 = unsafe.objectFieldOffset(b.class.getDeclaredField("iFields"));
            g = objectFieldOffset3;
            h = unsafe.objectFieldOffset(b.class.getDeclaredField("sFields"));
            i = unsafe.objectFieldOffset(d.class.getDeclaredField("member"));
            Method declaredMethod = h.class.getDeclaredMethod("a", null);
            Method declaredMethod2 = h.class.getDeclaredMethod("b", null);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            lookup = MethodHandles.lookup();
            unreflect = lookup.unreflect(declaredMethod);
            lookup2 = MethodHandles.lookup();
            unreflect2 = lookup2.unreflect(declaredMethod2);
            long j2 = unsafe.getLong(unreflect, objectFieldOffset);
            long j3 = unsafe.getLong(unreflect2, objectFieldOffset);
            long j4 = unsafe.getLong(h.class, objectFieldOffset2);
            long j5 = j3 - j2;
            j = j5;
            k = (j2 - j4) - j5;
            Field declaredField = h.class.getDeclaredField("i");
            Field declaredField2 = h.class.getDeclaredField("j");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            lookup3 = MethodHandles.lookup();
            unreflectGetter = lookup3.unreflectGetter(declaredField);
            lookup4 = MethodHandles.lookup();
            unreflectGetter2 = lookup4.unreflectGetter(declaredField2);
            long j6 = unsafe.getLong(unreflectGetter, objectFieldOffset);
            long j7 = unsafe.getLong(unreflectGetter2, objectFieldOffset);
            long j8 = unsafe.getLong(h.class, objectFieldOffset3);
            l = j7 - j6;
            m = j6 - j8;
        } catch (ReflectiveOperationException e2) {
            Log.e("HiddenApiBypass", "Initialize error", e2);
            throw new ExceptionInInitializerError(e2);
        }
    }

    static boolean a(Class[] clsArr, Object[] objArr) {
        if (clsArr.length != objArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (clsArr[i2].isPrimitive()) {
                Class cls = clsArr[i2];
                if (cls == Integer.TYPE && !(objArr[i2] instanceof Integer)) {
                    return false;
                }
                if (cls == Byte.TYPE && !(objArr[i2] instanceof Byte)) {
                    return false;
                }
                if (cls == Character.TYPE && !(objArr[i2] instanceof Character)) {
                    return false;
                }
                if (cls == Boolean.TYPE && !(objArr[i2] instanceof Boolean)) {
                    return false;
                }
                if (cls == Double.TYPE && !(objArr[i2] instanceof Double)) {
                    return false;
                }
                if (cls == Float.TYPE && !(objArr[i2] instanceof Float)) {
                    return false;
                }
                if (cls == Long.TYPE && !(objArr[i2] instanceof Long)) {
                    return false;
                }
                if (cls == Short.TYPE && !(objArr[i2] instanceof Short)) {
                    return false;
                }
            } else {
                Object obj = objArr[i2];
                if (obj != null && !clsArr[i2].isInstance(obj)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean b(String... strArr) {
        Set set = n;
        set.addAll(Arrays.asList(strArr));
        String[] strArr2 = new String[((HashSet) set).size()];
        set.toArray(strArr2);
        return d(strArr2);
    }

    public static Object c(Class cls, Object obj, String str, Object... objArr) {
        if (obj != null && !cls.isInstance(obj)) {
            throw new IllegalArgumentException("this object is not an instance of the given class");
        }
        Method declaredMethod = e.class.getDeclaredMethod("invoke", Object[].class);
        declaredMethod.setAccessible(true);
        Unsafe unsafe = a;
        long j2 = unsafe.getLong(cls, f);
        if (j2 == 0) {
            throw new NoSuchMethodException("Cannot find matching method");
        }
        int i2 = unsafe.getInt(j2);
        for (int i3 = 0; i3 < i2; i3++) {
            a.putLong(declaredMethod, b, (i3 * j) + j2 + k);
            if (str.equals(declaredMethod.getName()) && a(declaredMethod.getParameterTypes(), objArr)) {
                return declaredMethod.invoke(obj, objArr);
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static boolean d(String... strArr) {
        try {
            c(VMRuntime.class, c(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", strArr);
            return true;
        } catch (Throwable th) {
            Log.w("HiddenApiBypass", "setHiddenApiExemptions", th);
            return false;
        }
    }
}
