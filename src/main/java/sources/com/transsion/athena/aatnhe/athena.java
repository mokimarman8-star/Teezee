package com.transsion.athena.aatnhe;

import android.text.TextUtils;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class athena {
    public String a;
    public String b;
    public int c;
    public int d;
    public int e;
    public boolean f;

    public athena() {
    }

    public athena(String str, String str2, int i, int i2, int i3, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = z;
    }

    public String a() {
        return this.a + "-" + this.b + "-" + this.d + "-" + this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof athena) {
            return TextUtils.equals(a(), ((athena) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.a, this.b, Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Boolean.valueOf(this.f));
    }
}
