package yw;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e {
    private boolean a;
    private boolean b;

    public e(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b == eVar.b;
    }

    public int hashCode() {
        return (androidx.compose.foundation.e.a(this.a) * 31) + androidx.compose.foundation.e.a(this.b);
    }

    public String toString() {
        return "PostEventPlayRecord(isRefresh=" + this.a + ", isOutsideVideo=" + this.b + ")";
    }
}
