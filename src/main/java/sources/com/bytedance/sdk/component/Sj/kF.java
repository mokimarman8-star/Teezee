package com.bytedance.sdk.component.Sj;

import android.text.TextUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class kF {
    private static boolean Sj;

    static String Sj() {
        return "";
    }

    static String Sj(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String substring = Sj ? str.substring(1, str.length() - 1) : "";
        String concat = "{\"code\":1,\"__data\":".concat(String.valueOf(str));
        if (substring.isEmpty()) {
            return concat + "}";
        }
        return concat + "," + substring + "}";
    }

    static String Sj(Throwable th) {
        StringBuilder sb = new StringBuilder("{\"code\":");
        sb.append(th instanceof TzV ? ((TzV) th).Sj : 0);
        sb.append("}");
        return sb.toString();
    }

    static void Sj(boolean z) {
        Sj = z;
    }
}
