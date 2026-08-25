package hx;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    private final String a;
    private final boolean b;
    private final String c;

    public c(String subjectId, boolean z, String str) {
        Intrinsics.h(subjectId, "subjectId");
        this.a = subjectId;
        this.b = z;
        this.c = str;
    }

    public final boolean a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
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
        return Intrinsics.c(this.a, cVar.a) && this.b == cVar.b && Intrinsics.c(this.c, cVar.c);
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + androidx.compose.foundation.e.a(this.b)) * 31;
        String str = this.c;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FavoriteEvent(subjectId=" + this.a + ", favorite=" + this.b + ", favoriteNum=" + this.c + ")";
    }
}
