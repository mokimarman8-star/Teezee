package com.cloud.hisavana.sdk;

import android.util.Base64;
import android.util.Log;
import com.cloud.hisavana.sdk.sign.SignAlgorithm;
import java.nio.charset.StandardCharsets;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class p0 extends v1 {
    private final String a;

    public p0(String str) {
        this.a = str;
    }

    @Override // com.cloud.hisavana.sdk.v1
    public String a(SignAlgorithm signAlgorithm, String str) {
        try {
            Mac mac = Mac.getInstance(signAlgorithm.name());
            mac.init(new SecretKeySpec(Base64.decode(this.a, 2), signAlgorithm.name()));
            return Base64.encodeToString(mac.doFinal(str.getBytes(StandardCharsets.UTF_8)), 2);
        } catch (Exception e) {
            b4.b().e(Log.getStackTraceString(e));
            return "";
        }
    }
}
