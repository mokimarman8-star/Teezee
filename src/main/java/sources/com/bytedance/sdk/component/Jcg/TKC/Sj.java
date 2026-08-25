package com.bytedance.sdk.component.Jcg.TKC;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean Sj(Map<String, String> map) {
        String str;
        if (map == null) {
            return false;
        }
        String str2 = "content-type";
        if (TextUtils.isEmpty(map.get("content-type"))) {
            str2 = "Content-Type";
            if (TextUtils.isEmpty(map.get("Content-Type"))) {
                str = "";
                return !str.contains("application/octet-stream");
            }
        }
        str = map.get(str2);
        if (!str.contains("application/octet-stream")) {
        }
    }
}
