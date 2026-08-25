package z1;

import android.net.Uri;
import androidx.media3.common.util.r0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final long f18804a;

    /* renamed from: b, reason: collision with root package name */
    public final long f18805b;

    /* renamed from: c, reason: collision with root package name */
    private final String f18806c;

    /* renamed from: d, reason: collision with root package name */
    private int f18807d;

    public i(String str, long j5, long j6) {
        this.f18806c = str == null ? "" : str;
        this.f18804a = j5;
        this.f18805b = j6;
    }

    public i a(i iVar, String str) {
        String c5 = c(str);
        if (iVar != null && c5.equals(iVar.c(str))) {
            long j5 = this.f18805b;
            if (j5 != -1) {
                long j6 = this.f18804a;
                if (j6 + j5 == iVar.f18804a) {
                    long j7 = iVar.f18805b;
                    return new i(c5, j6, j7 != -1 ? j5 + j7 : -1L);
                }
            }
            long j8 = iVar.f18805b;
            if (j8 != -1) {
                long j9 = iVar.f18804a;
                if (j9 + j8 == this.f18804a) {
                    return new i(c5, j9, j5 != -1 ? j8 + j5 : -1L);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return r0.f(str, this.f18806c);
    }

    public String c(String str) {
        return r0.e(str, this.f18806c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f18804a == iVar.f18804a && this.f18805b == iVar.f18805b && this.f18806c.equals(iVar.f18806c);
    }

    public int hashCode() {
        if (this.f18807d == 0) {
            this.f18807d = ((((527 + ((int) this.f18804a)) * 31) + ((int) this.f18805b)) * 31) + this.f18806c.hashCode();
        }
        return this.f18807d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.f18806c + ", start=" + this.f18804a + ", length=" + this.f18805b + ")";
    }
}
