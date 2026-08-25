package androidx.compose.foundation.lazy.grid;

import androidx.collection.s;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final long f1947a;

    private /* synthetic */ a(long j5) {
        this.f1947a = j5;
    }

    public static final /* synthetic */ a a(long j5) {
        return new a(j5);
    }

    public static boolean b(long j5, Object obj) {
        return (obj instanceof a) && j5 == ((a) obj).e();
    }

    public static int c(long j5) {
        return s.a(j5);
    }

    public static String d(long j5) {
        return "GridItemSpan(packedValue=" + j5 + ')';
    }

    public final /* synthetic */ long e() {
        return this.f1947a;
    }

    public boolean equals(Object obj) {
        return b(this.f1947a, obj);
    }

    public int hashCode() {
        return c(this.f1947a);
    }

    public String toString() {
        return d(this.f1947a);
    }
}
