package rm;

import androidx.compose.foundation.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    private boolean a;
    private boolean b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c() {
        this(r2, r2, 3, null);
        boolean z = false;
    }

    public c(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public /* synthetic */ c(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    public final boolean a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.b == cVar.b;
    }

    public int hashCode() {
        return (e.a(this.a) * 31) + e.a(this.b);
    }

    public String toString() {
        return "LocalParam(isSubMoreTipBean=" + this.a + ", isSubMoreLoading=" + this.b + ")";
    }
}
