package com.transsion.api.gateway.sercurity;

import android.util.Base64;
import com.transsion.api.gateway.utils.GatewayUtils;
import java.nio.charset.Charset;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class a {
    public final String a;

    public a(String str) {
        this.a = str;
    }

    public String a(d dVar, String str) {
        try {
            Mac mac = Mac.getInstance(dVar.name());
            mac.init(new SecretKeySpec(Base64.decode(this.a, 2), dVar.name()));
            return Base64.encodeToString(mac.doFinal(str.getBytes(Charset.forName("UTF-8"))), 2);
        } catch (Exception e) {
            e.printStackTrace();
            GatewayUtils.L.e(e);
            return "";
        }
    }
}
