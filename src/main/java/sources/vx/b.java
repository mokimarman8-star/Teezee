package vx;

import androidx.collection.s;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    private final int a;
    private final long b;
    private final long c;
    private final String d;

    public b(int i, long j, long j2, String str) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && Intrinsics.c(this.d, bVar.d);
    }

    public int hashCode() {
        int a = ((((this.a * 31) + s.a(this.b)) * 31) + s.a(this.c)) * 31;
        String str = this.d;
        return a + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Chapter(index=" + this.a + ", start=" + this.b + ", end=" + this.c + ", title=" + this.d + ")";
    }
}
