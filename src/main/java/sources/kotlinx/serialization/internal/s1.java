package kotlinx.serialization.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.f;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class s1 implements kotlinx.serialization.descriptors.f {
    private final String a;
    private final kotlinx.serialization.descriptors.e b;

    public s1(String serialName, kotlinx.serialization.descriptors.e kind) {
        Intrinsics.h(serialName, "serialName");
        Intrinsics.h(kind, "kind");
        this.a = serialName;
        this.b = kind;
    }

    private final Void a() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean b() {
        return f.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public int c(String name) {
        Intrinsics.h(name, "name");
        a();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.f
    public int e() {
        return 0;
    }

    @Override // kotlinx.serialization.descriptors.f
    public String f(int i) {
        a();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.f
    public List g(int i) {
        a();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.f
    public List getAnnotations() {
        return f.a.a(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.f h(int i) {
        a();
        throw new KotlinNothingValueException();
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
        a();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.f
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public kotlinx.serialization.descriptors.e d() {
        return this.b;
    }

    public String toString() {
        return "PrimitiveDescriptor(" + i() + ')';
    }
}
