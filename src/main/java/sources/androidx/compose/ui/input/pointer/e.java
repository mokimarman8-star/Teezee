package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final long f3979a;

    /* renamed from: b, reason: collision with root package name */
    private final long f3980b;

    /* renamed from: c, reason: collision with root package name */
    private long f3981c;

    private e(long j5, long j6) {
        this.f3979a = j5;
        this.f3980b = j6;
        this.f3981c = y.g.f18527b.c();
    }

    private e(long j5, long j6, long j7) {
        this(j5, j6, (DefaultConstructorMarker) null);
        this.f3981c = j7;
    }

    public /* synthetic */ e(long j5, long j6, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7);
    }

    public /* synthetic */ e(long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6);
    }

    public final long a() {
        return this.f3981c;
    }

    public final long b() {
        return this.f3980b;
    }

    public final long c() {
        return this.f3979a;
    }

    public String toString() {
        return "HistoricalChange(uptimeMillis=" + this.f3979a + ", position=" + ((Object) y.g.t(this.f3980b)) + ')';
    }
}
