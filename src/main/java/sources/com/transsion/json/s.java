package com.transsion.json;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class s implements p {
    private final StringBuilder a;

    public s(StringBuilder sb) {
        this.a = sb;
    }

    public int a(String str, int i, int i2) {
        this.a.append((CharSequence) str, i, i2);
        return i2;
    }

    public p a(String str) {
        this.a.append(str);
        return this;
    }

    public int b(String str, int i, int i2, String str2) {
        this.a.append((CharSequence) str, i, i2);
        this.a.append(str2);
        return i2 + 1;
    }

    public String toString() {
        return this.a.toString();
    }
}
