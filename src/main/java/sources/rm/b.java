package rm;

import androidx.compose.foundation.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    private final boolean a;
    private final String b;
    private final int c;

    public b(boolean z, String str, int i) {
        this.a = z;
        this.b = str;
        this.c = i;
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final boolean c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && Intrinsics.c(this.b, bVar.b) && this.c == bVar.c;
    }

    public int hashCode() {
        int a = e.a(this.a) * 31;
        String str = this.b;
        return ((a + (str == null ? 0 : str.hashCode())) * 31) + this.c;
    }

    public String toString() {
        return "CommentLikeEvent(result=" + this.a + ", commentId=" + this.b + ", likeCount=" + this.c + ")";
    }
}
