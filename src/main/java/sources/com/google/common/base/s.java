package com.google.common.base;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class s {
    public static void a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new VerifyException(p.c(str, objArr));
        }
    }
}
