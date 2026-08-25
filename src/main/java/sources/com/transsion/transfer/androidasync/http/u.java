package com.transsion.transfer.androidasync.http;

import android.text.TextUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class u implements w, Cloneable {
    private final String a;
    private final String b;

    public u(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.a = str;
        this.b = str2;
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        u uVar = (u) obj;
        return this.a.equals(uVar.a) && TextUtils.equals(this.b, uVar.b);
    }

    @Override // com.transsion.transfer.androidasync.http.w
    public String getName() {
        return this.a;
    }

    @Override // com.transsion.transfer.androidasync.http.w
    public String getValue() {
        return this.b;
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public String toString() {
        return this.a + "=" + this.b;
    }
}
