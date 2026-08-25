package bl;

import androidx.compose.foundation.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private String a;
    private String b;
    private String c;
    private boolean d;
    private String e;

    public a(String str, String str2, String str3, boolean z, String str4) {
        Intrinsics.h(str, "filterValue");
        Intrinsics.h(str2, "filterName");
        Intrinsics.h(str3, "filterType");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = str4;
    }

    public /* synthetic */ a(String str, String str2, String str3, boolean z, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z, (i & 16) != 0 ? null : str4);
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.a;
    }

    public final boolean d() {
        return this.d;
    }

    public final void e(boolean z) {
        this.d = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b) && Intrinsics.c(this.c, aVar.c) && this.d == aVar.d && Intrinsics.c(this.e, aVar.e);
    }

    public int hashCode() {
        int hashCode = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + e.a(this.d)) * 31;
        String str = this.e;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilterItem(filterValue=" + this.a + ", filterName=" + this.b + ", filterType=" + this.c + ", isSelected=" + this.d + ", filterRangeValue=" + this.e + ")";
    }
}
