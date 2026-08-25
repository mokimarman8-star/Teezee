package com.therouter.router;

import androidx.collection.x0;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class c {
    private static final x0 a = new x0();

    public static final Fragment a(String str) {
        Intrinsics.h(str, "className");
        try {
            Object newInstance = d(str).getConstructor(null).newInstance(null);
            Intrinsics.e(newInstance);
            return (Fragment) newInstance;
        } catch (IllegalAccessException e) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    public static final boolean b(String str) {
        Intrinsics.h(str, "className");
        try {
            return Fragment.class.isAssignableFrom(c(str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static final Class c(String str) {
        Intrinsics.h(str, "className");
        ClassLoader classLoader = Fragment.class.getClassLoader();
        x0 x0Var = a;
        x0 x0Var2 = (x0) x0Var.get(classLoader);
        if (x0Var2 == null) {
            x0Var2 = new x0();
            x0Var.put(classLoader, x0Var2);
        }
        Class<?> cls = (Class) x0Var2.get(str);
        if (cls == null) {
            cls = Class.forName(str, false, classLoader);
            x0Var2.put(str, cls);
        }
        Intrinsics.e(cls);
        return cls;
    }

    public static final Class d(String str) {
        Intrinsics.h(str, "className");
        try {
            Class c = c(str);
            Intrinsics.f(c, "null cannot be cast to non-null type java.lang.Class<out androidx.fragment.app.Fragment?>");
            return c;
        } catch (ClassCastException e) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists", e2);
        }
    }
}
