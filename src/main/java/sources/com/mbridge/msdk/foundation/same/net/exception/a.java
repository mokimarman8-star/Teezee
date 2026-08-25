package com.mbridge.msdk.foundation.same.net.exception;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a extends Exception {
    public int a;
    public String b;
    public com.mbridge.msdk.foundation.same.net.toolbox.a c;

    public a(int i, com.mbridge.msdk.foundation.same.net.toolbox.a aVar) {
        this.a = i;
        this.c = aVar;
    }

    public a(int i, com.mbridge.msdk.foundation.same.net.toolbox.a aVar, String str) {
        this.a = i;
        this.c = aVar;
        this.b = str;
    }
}
