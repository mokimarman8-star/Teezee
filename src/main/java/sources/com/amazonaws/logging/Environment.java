package com.amazonaws.logging;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class Environment {
    public static boolean a() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getClassName().startsWith("org.junit.")) {
                return true;
            }
        }
        return false;
    }
}
