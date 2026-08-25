package gu;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d {
    private final String a;
    private final boolean b;

    public d(String userId, boolean z) {
        Intrinsics.h(userId, "userId");
        this.a = userId;
        this.b = z;
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.c(this.a, dVar.a) && this.b == dVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + androidx.compose.foundation.e.a(this.b);
    }

    public String toString() {
        return "UGCSubscribeEvent(userId=" + this.a + ", isSubscribed=" + this.b + ")";
    }
}
