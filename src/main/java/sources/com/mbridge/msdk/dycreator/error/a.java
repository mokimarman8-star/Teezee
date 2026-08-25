package com.mbridge.msdk.dycreator.error;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    private int a;
    private String b;

    public a(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public a(b bVar) {
        if (bVar != null) {
            this.a = bVar.b();
            this.b = bVar.c();
        }
    }

    public String toString() {
        return "DyError{errorCode=" + this.a + '}';
    }
}
