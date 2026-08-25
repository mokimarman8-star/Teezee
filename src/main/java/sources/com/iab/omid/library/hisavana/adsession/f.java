package com.iab.omid.library.hisavana.adsession;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f {
    private final String a;
    private final String b;

    private f(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static f a(String str, String str2) {
        le.g.f(str, "Name is null or empty");
        le.g.f(str2, "Version is null or empty");
        return new f(str, str2);
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }
}
