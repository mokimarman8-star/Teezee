package qn;

import androidx.compose.foundation.e;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    private final int a;
    private final String b;
    private final int c;
    private final boolean d;
    private final b[] e;

    public d(int i, String str, int i2, boolean z, b[] bVarArr) {
        Intrinsics.h(bVarArr, "formats");
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = z;
        this.e = bVarArr;
    }

    public final boolean a() {
        return this.d;
    }

    public final b[] b() {
        return this.e;
    }

    public final String c() {
        return this.b;
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && Intrinsics.c(this.b, dVar.b) && this.c == dVar.c && this.d == dVar.d && Intrinsics.c(this.e, dVar.e);
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        return ((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.c) * 31) + e.a(this.d)) * 31) + Arrays.hashCode(this.e);
    }

    public String toString() {
        return "TnTracksGroup(length=" + this.a + ", id=" + this.b + ", type=" + this.c + ", adaptiveSupported=" + this.d + ", formats=" + Arrays.toString(this.e) + ")";
    }
}
