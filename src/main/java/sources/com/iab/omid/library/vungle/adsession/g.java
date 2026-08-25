package com.iab.omid.library.vungle.adsession;

import java.net.URL;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class g {
    private final String a;
    private final URL b;
    private final String c;

    private g(String str, URL url, String str2) {
        this.a = str;
        this.b = url;
        this.c = str2;
    }

    public static g a(String str, URL url, String str2) {
        xe.g.f(str, "VendorKey is null or empty");
        xe.g.d(url, "ResourceURL is null");
        xe.g.f(str2, "VerificationParameters is null or empty");
        return new g(str, url, str2);
    }

    public URL b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.c;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        xe.c.i(jSONObject, "vendorKey", this.a);
        xe.c.i(jSONObject, "resourceUrl", this.b.toString());
        xe.c.i(jSONObject, "verificationParameters", this.c);
        return jSONObject;
    }
}
