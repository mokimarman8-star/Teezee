package com.transsion.api.gateway.utils;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class PermissionUtils {
    public static boolean lacksPermission(String str) {
        try {
            return ContextUtils.getContext().checkSelfPermission(str) == -1;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean lacksPermissions(String... strArr) {
        for (String str : strArr) {
            if (lacksPermission(str)) {
                return true;
            }
        }
        return false;
    }
}
