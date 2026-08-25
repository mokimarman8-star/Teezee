package androidx.compose.foundation.layout;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    private float f1883a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1884b;

    /* renamed from: c, reason: collision with root package name */
    private m f1885c;

    public z() {
        this(0.0f, false, null, null, 15, null);
    }

    public z(float f5, boolean z5, m mVar, p pVar) {
        this.f1883a = f5;
        this.f1884b = z5;
        this.f1885c = mVar;
    }

    public /* synthetic */ z(float f5, boolean z5, m mVar, p pVar, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0.0f : f5, (i5 & 2) != 0 ? true : z5, (i5 & 4) != 0 ? null : mVar, (i5 & 8) != 0 ? null : pVar);
    }

    public final m a() {
        return this.f1885c;
    }

    public final boolean b() {
        return this.f1884b;
    }

    public final p c() {
        return null;
    }

    public final float d() {
        return this.f1883a;
    }

    public final void e(m mVar) {
        this.f1885c = mVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return Float.compare(this.f1883a, zVar.f1883a) == 0 && this.f1884b == zVar.f1884b && Intrinsics.c(this.f1885c, zVar.f1885c) && Intrinsics.c((Object) null, (Object) null);
    }

    public final void f(boolean z5) {
        this.f1884b = z5;
    }

    public final void g(float f5) {
        this.f1883a = f5;
    }

    public int hashCode() {
        int floatToIntBits = ((Float.floatToIntBits(this.f1883a) * 31) + androidx.compose.foundation.e.a(this.f1884b)) * 31;
        m mVar = this.f1885c;
        return (floatToIntBits + (mVar == null ? 0 : mVar.hashCode())) * 31;
    }

    public String toString() {
        return "RowColumnParentData(weight=" + this.f1883a + ", fill=" + this.f1884b + ", crossAxisAlignment=" + this.f1885c + ", flowLayoutData=" + ((Object) null) + ')';
    }
}
