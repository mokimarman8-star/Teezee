package com.amazonaws.util;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ValidationUtils {
    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
