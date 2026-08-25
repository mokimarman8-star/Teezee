package kd;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d {
    private final byte[] a;
    private int b;
    private final String c;
    private final List d;
    private final String e;
    private Integer f;
    private Integer g;
    private Object h;
    private final int i;
    private final int j;
    private final int k;

    public d(byte[] bArr, String str, List list, String str2) {
        this(bArr, str, list, str2, -1, -1, 0);
    }

    public d(byte[] bArr, String str, List list, String str2, int i) {
        this(bArr, str, list, str2, -1, -1, i);
    }

    public d(byte[] bArr, String str, List list, String str2, int i, int i2, int i3) {
        this.a = bArr;
        this.b = bArr == null ? 0 : bArr.length * 8;
        this.c = str;
        this.d = list;
        this.e = str2;
        this.i = i2;
        this.j = i;
        this.k = i3;
    }

    public List a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public Integer c() {
        return this.g;
    }

    public Integer d() {
        return this.f;
    }

    public int e() {
        return this.b;
    }

    public Object f() {
        return this.h;
    }

    public byte[] g() {
        return this.a;
    }

    public int h() {
        return this.i;
    }

    public int i() {
        return this.j;
    }

    public int j() {
        return this.k;
    }

    public String k() {
        return this.c;
    }

    public boolean l() {
        return this.i >= 0 && this.j >= 0;
    }

    public void m(Integer num) {
        this.g = num;
    }

    public void n(Integer num) {
        this.f = num;
    }

    public void o(int i) {
        this.b = i;
    }

    public void p(Object obj) {
        this.h = obj;
    }
}
