package kotlinx.serialization.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.i;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class c1 implements kotlinx.serialization.descriptors.f {
    private final String a;
    private final kotlinx.serialization.descriptors.f b;
    private final kotlinx.serialization.descriptors.f c;
    private final int d;

    private c1(String str, kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.descriptors.f fVar2) {
        this.a = str;
        this.b = fVar;
        this.c = fVar2;
        this.d = 2;
    }

    public /* synthetic */ c1(String str, kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.descriptors.f fVar2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fVar, fVar2);
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
        throw new IllegalArgumentException(name + " is not a valid map index");
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.h d() {
        return i.c.a;
    }

    @Override // kotlinx.serialization.descriptors.f
    public int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return Intrinsics.c(i(), c1Var.i()) && Intrinsics.c(this.b, c1Var.b) && Intrinsics.c(this.c, c1Var.c);
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
            int i2 = i % 2;
            if (i2 == 0) {
                return this.b;
            }
            if (i2 == 1) {
                return this.c;
            }
            throw new IllegalStateException("Unreached");
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + i() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (((i().hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    @Override // kotlinx.serialization.descriptors.f
    public String i() {
        return this.a;
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
        return i() + '(' + this.b + ", " + this.c + ')';
    }
}
