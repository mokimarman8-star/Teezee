package androidx.compose.ui.input.pointer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private final long f4052a;

    private /* synthetic */ v(long j5) {
        this.f4052a = j5;
    }

    public static final /* synthetic */ v a(long j5) {
        return new v(j5);
    }

    public static long b(long j5) {
        return j5;
    }

    public static boolean c(long j5, Object obj) {
        return (obj instanceof v) && j5 == ((v) obj).g();
    }

    public static final boolean d(long j5, long j6) {
        return j5 == j6;
    }

    public static int e(long j5) {
        return androidx.collection.s.a(j5);
    }

    public static String f(long j5) {
        return "PointerId(value=" + j5 + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f4052a, obj);
    }

    public final /* synthetic */ long g() {
        return this.f4052a;
    }

    public int hashCode() {
        return e(this.f4052a);
    }

    public String toString() {
        return f(this.f4052a);
    }
}
