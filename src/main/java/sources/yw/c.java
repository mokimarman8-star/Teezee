package yw;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    private final String a;
    private final int b;
    private boolean c;
    private boolean d;
    private boolean e;

    public c(String subjectId, int i, boolean z, boolean z2, boolean z3) {
        Intrinsics.h(subjectId, "subjectId");
        this.a = subjectId;
        this.b = i;
        this.c = z;
        this.d = z2;
        this.e = z3;
    }

    public /* synthetic */ c(String str, int i, boolean z, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? false : z3);
    }

    public final int a() {
        return this.b;
    }

    public final boolean b() {
        return this.e;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final void e(boolean z) {
        this.e = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.c(this.a, cVar.a) && this.b == cVar.b && this.c == cVar.c && this.d == cVar.d && this.e == cVar.e;
    }

    public final void f(boolean z) {
        this.c = z;
    }

    public final void g(boolean z) {
        this.d = z;
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b) * 31) + androidx.compose.foundation.e.a(this.c)) * 31) + androidx.compose.foundation.e.a(this.d)) * 31) + androidx.compose.foundation.e.a(this.e);
    }

    public String toString() {
        return "DownloadShortTVEpisodeSelectItem(subjectId=" + this.a + ", position=" + this.b + ", isFree=" + this.c + ", isSelect=" + this.d + ", isDownload=" + this.e + ")";
    }
}
