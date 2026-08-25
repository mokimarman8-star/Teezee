package org.mvel2;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class c {
    private char[] a;
    private int b;
    private boolean c;
    private String d;
    private int e;
    private int f;

    public c(char[] cArr, int i, boolean z, String str) {
        this.a = cArr;
        this.b = i;
        this.c = z;
        this.d = str;
        a();
    }

    public void a() {
        char[] cArr;
        if ((this.e != 0 && this.f != 0) || (cArr = this.a) == null || cArr.length == 0) {
            return;
        }
        int i = 1;
        int i2 = 1;
        for (int i3 = 0; i3 < this.b; i3++) {
            char c = this.a[i3];
            if (c == '\n') {
                i++;
                i2 = 0;
            } else if (c != '\r') {
                i2++;
            }
        }
        this.e = i;
        this.f = i2;
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.b;
    }

    public char[] d() {
        return this.a;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.d;
    }

    public boolean g() {
        return this.c;
    }

    public void h(int i) {
        this.f = i;
    }

    public void i(int i) {
        this.b = i;
    }

    public void j(char[] cArr) {
        this.a = cArr;
    }

    public void k(int i) {
        this.e = i;
    }

    public String toString() {
        if (this.c) {
            return "(" + this.e + "," + this.f + ") " + this.d;
        }
        return "(" + this.e + "," + this.f + ") WARNING: " + this.d;
    }
}
