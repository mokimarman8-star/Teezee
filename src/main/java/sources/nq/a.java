package nq;

import com.transsion.share.bean.ShareType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final ShareType a;
    private final int b;
    private final String c;

    public a(ShareType shareType, int i, String str) {
        Intrinsics.h(shareType, "shareType");
        Intrinsics.h(str, "shareName");
        this.a = shareType;
        this.b = i;
        this.c = str;
    }

    public final int a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final ShareType c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.b == aVar.b && Intrinsics.c(this.c, aVar.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ShareData(shareType=" + this.a + ", shareIconId=" + this.b + ", shareName=" + this.c + ")";
    }
}
