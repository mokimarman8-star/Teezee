package yw;

import androidx.collection.s;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g {
    private final String a;
    private final String b;
    private final long c;

    public g(String videoId, String collectionId, long j) {
        Intrinsics.h(videoId, "videoId");
        Intrinsics.h(collectionId, "collectionId");
        this.a = videoId;
        this.b = collectionId;
        this.c = j;
    }

    public final String a() {
        return this.b;
    }

    public final long b() {
        return this.c;
    }

    public final String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.c(this.a, gVar.a) && Intrinsics.c(this.b, gVar.b) && this.c == gVar.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + s.a(this.c);
    }

    public String toString() {
        return "UGCPlayRecordEvent(videoId=" + this.a + ", collectionId=" + this.b + ", progress=" + this.c + ")";
    }
}
