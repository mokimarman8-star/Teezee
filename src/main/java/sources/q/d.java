package q;

import kotlin.jvm.internal.DefaultConstructorMarker;
import o0.i;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    private final float f16997a;

    private d(float f5) {
        this.f16997a = f5;
    }

    public /* synthetic */ d(float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5);
    }

    @Override // q.b
    public float a(long j5, o0.e eVar) {
        return eVar.D0(this.f16997a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && i.i(this.f16997a, ((d) obj).f16997a);
    }

    public int hashCode() {
        return i.j(this.f16997a);
    }

    public String toString() {
        return "CornerSize(size = " + this.f16997a + ".dp)";
    }
}
