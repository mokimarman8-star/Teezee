package un;

import androidx.collection.s;
import androidx.compose.foundation.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements p6.a {
    private String a;
    private int b;
    private int c;
    private boolean d;
    private long e;
    private String f;
    private int g;

    public a(String str, int i, int i2, boolean z, long j, String str2, int i3) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = j;
        this.f = str2;
        this.g = i3;
    }

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.g;
    }

    public final String d() {
        return this.f;
    }

    public final int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && Intrinsics.c(this.f, aVar.f) && this.g == aVar.g;
    }

    public final boolean f() {
        return this.d;
    }

    public final void g(boolean z) {
        this.d = z;
    }

    public int getItemType() {
        return 2;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (((((((((str == null ? 0 : str.hashCode()) * 31) + this.b) * 31) + this.c) * 31) + e.a(this.d)) * 31) + s.a(this.e)) * 31;
        String str2 = this.f;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.g;
    }

    public String toString() {
        return "CommentSubLoadMoreBean(commentId=" + this.a + ", subCount=" + this.b + ", currentCount=" + this.c + ", isLoading=" + this.d + ", createTime=" + this.e + ", postId=" + this.f + ", nextPage=" + this.g + ")";
    }
}
