package com.transsion.infra.gateway.core.sercurity;

import android.util.Base64;
import com.transsion.gslb.BuildConfig;
import java.nio.charset.Charset;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a extends c {
    private final String a;

    public a(String str) {
        this.a = str;
    }

    @Override // com.transsion.infra.gateway.core.sercurity.c
    public String a(SignAlgorithm signAlgorithm, String str) {
        try {
            Mac mac = Mac.getInstance(signAlgorithm.name());
            mac.init(new SecretKeySpec(Base64.decode(this.a, 2), signAlgorithm.name()));
            return Base64.encodeToString(mac.doFinal(str.getBytes(Charset.forName("UTF-8"))), 2);
        } catch (Exception e) {
            e.printStackTrace();
            com.transsion.infra.gateway.core.utils.c.a.i(e);
            return BuildConfig.FLAVOR;
        }
    }
}
