package com.pgl.ssdk;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.component.utils.Sj;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class n0 {
    public static Pair<Integer, String> a(String str) {
        Pair pair = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            pair = PglCryptUtils.getInstance().cypher4EncryptWithNoWrapBase64(str);
        } catch (Throwable unused) {
        }
        return (pair == null || ((Integer) pair.first).intValue() != 0 || TextUtils.isEmpty((CharSequence) pair.second)) ? new Pair<>(3, Sj.sP(str)) : new Pair<>(4, pair.second);
    }
}
