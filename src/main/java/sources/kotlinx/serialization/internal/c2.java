package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;
import sy.d;
import sy.f;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class c2 implements sy.f, sy.d {
    private final ArrayList a = new ArrayList();

    private final boolean H(kotlinx.serialization.descriptors.f fVar, int i) {
        c0(a0(fVar, i));
        return true;
    }

    @Override // sy.f
    public final void B(int i) {
        Q(b0(), i);
    }

    @Override // sy.d
    public void C(kotlinx.serialization.descriptors.f descriptor, int i, kotlinx.serialization.g serializer, Object obj) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(serializer, "serializer");
        if (H(descriptor, i)) {
            e(serializer, obj);
        }
    }

    @Override // sy.d
    public final void D(kotlinx.serialization.descriptors.f descriptor, int i, short s) {
        Intrinsics.h(descriptor, "descriptor");
        U(a0(descriptor, i), s);
    }

    @Override // sy.d
    public final void E(kotlinx.serialization.descriptors.f descriptor, int i, double d) {
        Intrinsics.h(descriptor, "descriptor");
        M(a0(descriptor, i), d);
    }

    @Override // sy.d
    public final void F(kotlinx.serialization.descriptors.f descriptor, int i, long j) {
        Intrinsics.h(descriptor, "descriptor");
        R(a0(descriptor, i), j);
    }

    @Override // sy.f
    public final void G(String value) {
        Intrinsics.h(value, "value");
        V(b0(), value);
    }

    public void I(kotlinx.serialization.g gVar, Object obj) {
        f.a.c(this, gVar, obj);
    }

    protected void J(Object obj, boolean z) {
        W(obj, Boolean.valueOf(z));
    }

    protected void K(Object obj, byte b) {
        W(obj, Byte.valueOf(b));
    }

    protected void L(Object obj, char c) {
        W(obj, Character.valueOf(c));
    }

    protected void M(Object obj, double d) {
        W(obj, Double.valueOf(d));
    }

    protected void N(Object obj, kotlinx.serialization.descriptors.f enumDescriptor, int i) {
        Intrinsics.h(enumDescriptor, "enumDescriptor");
        W(obj, Integer.valueOf(i));
    }

    protected void O(Object obj, float f) {
        W(obj, Float.valueOf(f));
    }

    protected sy.f P(Object obj, kotlinx.serialization.descriptors.f inlineDescriptor) {
        Intrinsics.h(inlineDescriptor, "inlineDescriptor");
        c0(obj);
        return this;
    }

    protected void Q(Object obj, int i) {
        W(obj, Integer.valueOf(i));
    }

    protected void R(Object obj, long j) {
        W(obj, Long.valueOf(j));
    }

    protected void S(Object obj) {
    }

    protected void T(Object obj) {
        throw new SerializationException("null is not supported");
    }

    protected void U(Object obj, short s) {
        W(obj, Short.valueOf(s));
    }

    protected void V(Object obj, String value) {
        Intrinsics.h(value, "value");
        W(obj, value);
    }

    protected void W(Object obj, Object value) {
        Intrinsics.h(value, "value");
        throw new SerializationException("Non-serializable " + Reflection.b(value.getClass()) + " is not supported by " + Reflection.b(getClass()) + " encoder");
    }

    protected void X(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
    }

    protected final Object Y() {
        return CollectionsKt.u0(this.a);
    }

    protected final Object Z() {
        return CollectionsKt.v0(this.a);
    }

    @Override // sy.f
    public ty.c a() {
        return ty.d.a();
    }

    protected abstract Object a0(kotlinx.serialization.descriptors.f fVar, int i);

    @Override // sy.f
    public sy.d b(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        return this;
    }

    protected final Object b0() {
        if (this.a.isEmpty()) {
            throw new SerializationException("No tag in stack for requested element");
        }
        ArrayList arrayList = this.a;
        return arrayList.remove(CollectionsKt.n(arrayList));
    }

    @Override // sy.d
    public final void c(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        if (!this.a.isEmpty()) {
            b0();
        }
        X(descriptor);
    }

    protected final void c0(Object obj) {
        this.a.add(obj);
    }

    @Override // sy.f
    public void e(kotlinx.serialization.g gVar, Object obj) {
        f.a.d(this, gVar, obj);
    }

    @Override // sy.d
    public final sy.f f(kotlinx.serialization.descriptors.f descriptor, int i) {
        Intrinsics.h(descriptor, "descriptor");
        return P(a0(descriptor, i), descriptor.h(i));
    }

    @Override // sy.f
    public final void g(double d) {
        M(b0(), d);
    }

    @Override // sy.f
    public final void h(byte b) {
        K(b0(), b);
    }

    @Override // sy.d
    public void i(kotlinx.serialization.descriptors.f descriptor, int i, kotlinx.serialization.g serializer, Object obj) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(serializer, "serializer");
        if (H(descriptor, i)) {
            I(serializer, obj);
        }
    }

    @Override // sy.f
    public sy.d j(kotlinx.serialization.descriptors.f fVar, int i) {
        return f.a.a(this, fVar, i);
    }

    @Override // sy.f
    public final void k(kotlinx.serialization.descriptors.f enumDescriptor, int i) {
        Intrinsics.h(enumDescriptor, "enumDescriptor");
        N(b0(), enumDescriptor, i);
    }

    @Override // sy.f
    public final sy.f l(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        return P(b0(), descriptor);
    }

    @Override // sy.f
    public final void m(long j) {
        R(b0(), j);
    }

    @Override // sy.d
    public final void n(kotlinx.serialization.descriptors.f descriptor, int i, char c) {
        Intrinsics.h(descriptor, "descriptor");
        L(a0(descriptor, i), c);
    }

    @Override // sy.f
    public void o() {
        T(b0());
    }

    @Override // sy.d
    public final void p(kotlinx.serialization.descriptors.f descriptor, int i, byte b) {
        Intrinsics.h(descriptor, "descriptor");
        K(a0(descriptor, i), b);
    }

    @Override // sy.f
    public final void q(short s) {
        U(b0(), s);
    }

    @Override // sy.f
    public final void r(boolean z) {
        J(b0(), z);
    }

    @Override // sy.d
    public final void s(kotlinx.serialization.descriptors.f descriptor, int i, float f) {
        Intrinsics.h(descriptor, "descriptor");
        O(a0(descriptor, i), f);
    }

    @Override // sy.f
    public final void t(float f) {
        O(b0(), f);
    }

    @Override // sy.f
    public final void u(char c) {
        L(b0(), c);
    }

    @Override // sy.f
    public void v() {
        S(Y());
    }

    @Override // sy.d
    public final void w(kotlinx.serialization.descriptors.f descriptor, int i, int i2) {
        Intrinsics.h(descriptor, "descriptor");
        Q(a0(descriptor, i), i2);
    }

    @Override // sy.d
    public final void x(kotlinx.serialization.descriptors.f descriptor, int i, boolean z) {
        Intrinsics.h(descriptor, "descriptor");
        J(a0(descriptor, i), z);
    }

    @Override // sy.d
    public final void y(kotlinx.serialization.descriptors.f descriptor, int i, String value) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(value, "value");
        V(a0(descriptor, i), value);
    }

    @Override // sy.d
    public boolean z(kotlinx.serialization.descriptors.f fVar, int i) {
        return d.a.a(this, fVar, i);
    }
}
