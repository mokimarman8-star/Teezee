package com.transsion.api.gateway.dns;

import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class d {
    public final int a;
    public String b;
    public int c;
    public int d;
    public boolean e;
    public String f;
    public BigInteger g;

    public d(d dVar) {
        this.c = 0;
        this.d = 0;
        this.e = false;
        char[] cArr = new char[16];
        Arrays.fill(cArr, 'f');
        this.f = new String(cArr);
        this.g = new BigInteger(this.f, 16);
        this.b = dVar.b;
        this.a = dVar.a;
        this.c = dVar.c;
        this.d = dVar.d;
        this.e = dVar.e;
        this.g = dVar.g;
        this.f = dVar.f;
    }

    public d(String str, int i) {
        this.c = 0;
        this.d = 0;
        this.e = false;
        char[] cArr = new char[16];
        Arrays.fill(cArr, 'f');
        this.f = new String(cArr);
        this.g = new BigInteger(this.f, 16);
        this.b = str;
        this.a = i;
    }
}
