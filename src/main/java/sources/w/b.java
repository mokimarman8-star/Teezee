package w;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private int f18078a;

    public b() {
        this(0, 1, null);
    }

    public b(int i5) {
        this.f18078a = i5;
    }

    public /* synthetic */ b(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i5);
    }

    public final int a() {
        return this.f18078a;
    }

    public final void b(int i5) {
        this.f18078a += i5;
    }

    public final void c(int i5) {
        this.f18078a = i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f18078a == ((b) obj).f18078a;
    }

    public int hashCode() {
        return this.f18078a;
    }

    public String toString() {
        return "DeltaCounter(count=" + this.f18078a + ')';
    }
}
