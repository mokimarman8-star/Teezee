package com.apm.insight;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface ICrashFilter {
    boolean onJavaCrashFilter(Throwable th, Thread thread);

    boolean onNativeCrashFilter(String str, String str2);
}
