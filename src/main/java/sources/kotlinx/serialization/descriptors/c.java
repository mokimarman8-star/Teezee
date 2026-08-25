package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class c implements f {
    private final f a;
    public final KClass b;
    private final String c;

    public c(f original, KClass kClass) {
        Intrinsics.h(original, "original");
        Intrinsics.h(kClass, "kClass");
        this.a = original;
        this.b = kClass;
        this.c = original.i() + '<' + kClass.g() + '>';
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean b() {
        return this.a.b();
    }

    @Override // kotlinx.serialization.descriptors.f
    public int c(String name) {
        Intrinsics.h(name, "name");
        return this.a.c(name);
    }

    @Override // kotlinx.serialization.descriptors.f
    public h d() {
        return this.a.d();
    }

    @Override // kotlinx.serialization.descriptors.f
    public int e() {
        return this.a.e();
    }

    public boolean equals(Object obj) {
        c cVar = obj instanceof c ? (c) obj : null;
        return cVar != null && Intrinsics.c(this.a, cVar.a) && Intrinsics.c(cVar.b, this.b);
    }

    @Override // kotlinx.serialization.descriptors.f
    public String f(int i) {
        return this.a.f(i);
    }

    @Override // kotlinx.serialization.descriptors.f
    public List g(int i) {
        return this.a.g(i);
    }

    @Override // kotlinx.serialization.descriptors.f
    public List getAnnotations() {
        return this.a.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.f
    public f h(int i) {
        return this.a.h(i);
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + i().hashCode();
    }

    @Override // kotlinx.serialization.descriptors.f
    public String i() {
        return this.c;
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean isInline() {
        return this.a.isInline();
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean j(int i) {
        return this.a.j(i);
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.b + ", original: " + this.a + ')';
    }
}
