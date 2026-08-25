package com.amazonaws.services.s3.model;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class SSECustomerKey {
    private final String a = null;
    private String b;
    private String c;

    private SSECustomerKey() {
    }

    public static SSECustomerKey a(String str) {
        if (str != null) {
            return new SSECustomerKey().f(str);
        }
        throw new IllegalArgumentException();
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }

    public void e(String str) {
        this.c = str;
    }

    public SSECustomerKey f(String str) {
        e(str);
        return this;
    }
}
