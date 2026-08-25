package org.mvel2.optimizers;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mvel2.optimizers.dynamic.DynamicOptimizer;
import org.mvel2.optimizers.impl.asm.ASMAccessorOptimizer;
import org.mvel2.optimizers.impl.refl.ReflectiveAccessorOptimizer;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class b {
    public static String a = "dynamic";
    public static String b = "reflective";
    private static final Logger c = Logger.getLogger(b.class.getName());
    private static String d;
    private static final Map e;
    private static ThreadLocal f;

    static {
        HashMap hashMap = new HashMap();
        e = hashMap;
        f = new ThreadLocal();
        hashMap.put(b, new ReflectiveAccessorOptimizer());
        hashMap.put(a, new DynamicOptimizer());
        try {
            if (b.class.getClassLoader() != null) {
                b.class.getClassLoader().loadClass("org.mvel2.asm.ClassWriter");
            } else {
                ClassLoader.getSystemClassLoader().loadClass("org.mvel2.asm.ClassWriter");
            }
            hashMap.put("ASM", new ASMAccessorOptimizer());
        } catch (ClassNotFoundException unused) {
            d = b;
        } catch (Throwable th) {
            c.log(Level.WARNING, "[MVEL] Notice: Possible incorrect version of ASM present (3.0 required).  Disabling JIT compiler.  Reflective Optimizer will be used.", th);
            d = b;
        }
        if (Boolean.getBoolean("mvel2.disable.jit")) {
            e(b);
        } else {
            e(a);
        }
    }

    public static void a() {
        f.set(null);
        f.remove();
    }

    public static a b(String str) {
        try {
            return (a) ((a) e.get(str)).getClass().newInstance();
        } catch (Exception e3) {
            throw new RuntimeException("unable to instantiate accessor compiler", e3);
        }
    }

    public static a c() {
        try {
            return (a) ((a) e.get(d)).getClass().newInstance();
        } catch (Exception e3) {
            throw new RuntimeException("unable to instantiate accessor compiler", e3);
        }
    }

    public static a d() {
        if (f.get() == null) {
            f.set(c().getClass());
        }
        try {
            return (a) ((Class) f.get()).newInstance();
        } catch (Exception e3) {
            throw new RuntimeException("unable to instantiate accessor compiler", e3);
        }
    }

    public static void e(String str) {
        try {
            Map map = e;
            d = str;
            ((a) map.get(str)).init();
            f.set(null);
        } catch (Exception e3) {
            throw new RuntimeException("unable to instantiate accessor compiler", e3);
        }
    }

    public static void f(Class cls) {
        if (cls == null) {
            throw new RuntimeException("null optimizer");
        }
        f.set(cls);
    }
}
