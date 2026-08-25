package org.apache.tools.ant.util;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class k {
    private static final d a = d.k();

    public static ClassLoader a() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static boolean b() {
        return true;
    }

    public static void c(ClassLoader classLoader) {
        Thread.currentThread().setContextClassLoader(classLoader);
    }
}
