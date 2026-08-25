package androidx.media;

import android.text.TextUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class i implements c {

    /* renamed from: a, reason: collision with root package name */
    private String f8452a;

    /* renamed from: b, reason: collision with root package name */
    private int f8453b;

    /* renamed from: c, reason: collision with root package name */
    private int f8454c;

    i(String str, int i5, int i6) {
        this.f8452a = str;
        this.f8453b = i5;
        this.f8454c = i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return (this.f8453b < 0 || iVar.f8453b < 0) ? TextUtils.equals(this.f8452a, iVar.f8452a) && this.f8454c == iVar.f8454c : TextUtils.equals(this.f8452a, iVar.f8452a) && this.f8453b == iVar.f8453b && this.f8454c == iVar.f8454c;
    }

    public int hashCode() {
        return androidx.core.util.d.b(this.f8452a, Integer.valueOf(this.f8454c));
    }
}
