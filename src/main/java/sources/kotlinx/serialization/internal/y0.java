package kotlinx.serialization.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.i;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class y0 implements kotlinx.serialization.descriptors.f {
    private final kotlinx.serialization.descriptors.f a;
    private final int b;

    private y0(kotlinx.serialization.descriptors.f fVar) {
        this.a = fVar;
        this.b = 1;
    }

    public /* synthetic */ y0(kotlinx.serialization.descriptors.f fVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar);
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean b() {
        return f.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public int c(String name) {
        Intrinsics.h(name, "name");
        Integer v = StringsKt.v(name);
        if (v != null) {
            return v.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid list index");
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.h d() {
        return i.b.a;
    }

    @Override // kotlinx.serialization.descriptors.f
    public int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return Intrinsics.c(this.a, y0Var.a) && Intrinsics.c(i(), y0Var.i());
    }

    @Override // kotlinx.serialization.descriptors.f
    public String f(int i) {
        return String.valueOf(i);
    }

    @Override // kotlinx.serialization.descriptors.f
    public List g(int i) {
        if (i >= 0) {
            return CollectionsKt.l();
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + i() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.f
    public List getAnnotations() {
        return f.a.a(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.f h(int i) {
        if (i >= 0) {
            return this.a;
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + i() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + i().hashCode();
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean isInline() {
        return f.a.b(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean j(int i) {
        if (i >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + i() + " expects only non-negative indices").toString());
    }

    public String toString() {
        return i() + '(' + this.a + ')';
    }
}
