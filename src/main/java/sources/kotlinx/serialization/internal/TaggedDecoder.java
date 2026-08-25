package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;
import sy.c;
import sy.e;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class TaggedDecoder implements sy.e, sy.c {
    private final ArrayList a = new ArrayList();
    private boolean b;

    private final Object a0(Object obj, Function0 function0) {
        Z(obj);
        Object invoke = function0.invoke();
        if (!this.b) {
            Y();
        }
        this.b = false;
        return invoke;
    }

    @Override // sy.c
    public final char A(kotlinx.serialization.descriptors.f descriptor, int i) {
        Intrinsics.h(descriptor, "descriptor");
        return L(X(descriptor, i));
    }

    @Override // sy.c
    public final byte B(kotlinx.serialization.descriptors.f descriptor, int i) {
        Intrinsics.h(descriptor, "descriptor");
        return K(X(descriptor, i));
    }

    @Override // sy.c
    public final boolean C(kotlinx.serialization.descriptors.f descriptor, int i) {
        Intrinsics.h(descriptor, "descriptor");
        return J(X(descriptor, i));
    }

    @Override // sy.e
    public boolean D() {
        Object W = W();
        if (W == null) {
            return false;
        }
        return S(W);
    }

    @Override // sy.c
    public final short E(kotlinx.serialization.descriptors.f descriptor, int i) {
        Intrinsics.h(descriptor, "descriptor");
        return T(X(descriptor, i));
    }

    @Override // sy.c
    public final double F(kotlinx.serialization.descriptors.f descriptor, int i) {
        Intrinsics.h(descriptor, "descriptor");
        return M(X(descriptor, i));
    }

    @Override // sy.e
    public Object G(kotlinx.serialization.a aVar) {
        return e.a.a(this, aVar);
    }

    @Override // sy.e
    public final byte H() {
        return K(Y());
    }

    protected Object I(kotlinx.serialization.a deserializer, Object obj) {
        Intrinsics.h(deserializer, "deserializer");
        return G(deserializer);
    }

    protected boolean J(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) V).booleanValue();
    }

    protected byte K(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) V).byteValue();
    }

    protected char L(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) V).charValue();
    }

    protected double M(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) V).doubleValue();
    }

    protected int N(Object obj, kotlinx.serialization.descriptors.f enumDescriptor) {
        Intrinsics.h(enumDescriptor, "enumDescriptor");
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) V).intValue();
    }

    protected float O(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) V).floatValue();
    }

    protected sy.e P(Object obj, kotlinx.serialization.descriptors.f inlineDescriptor) {
        Intrinsics.h(inlineDescriptor, "inlineDescriptor");
        Z(obj);
        return this;
    }

    protected int Q(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) V).intValue();
    }

    protected long R(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) V).longValue();
    }

    protected boolean S(Object obj) {
        return true;
    }

    protected short T(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) V).shortValue();
    }

    protected String U(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.String");
        return (String) V;
    }

    protected Object V(Object obj) {
        throw new SerializationException(Reflection.b(getClass()) + " can't retrieve untyped values");
    }

    protected final Object W() {
        return CollectionsKt.v0(this.a);
    }

    protected abstract Object X(kotlinx.serialization.descriptors.f fVar, int i);

    protected final Object Y() {
        ArrayList arrayList = this.a;
        Object remove = arrayList.remove(CollectionsKt.n(arrayList));
        this.b = true;
        return remove;
    }

    protected final void Z(Object obj) {
        this.a.add(obj);
    }

    @Override // sy.e, sy.c
    public ty.c a() {
        return ty.d.a();
    }

    @Override // sy.e
    public sy.c b(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        return this;
    }

    @Override // sy.c
    public void c(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
    }

    @Override // sy.e
    public final int e(kotlinx.serialization.descriptors.f enumDescriptor) {
        Intrinsics.h(enumDescriptor, "enumDescriptor");
        return N(Y(), enumDescriptor);
    }

    @Override // sy.c
    public final long f(kotlinx.serialization.descriptors.f descriptor, int i) {
        Intrinsics.h(descriptor, "descriptor");
        return R(X(descriptor, i));
    }

    @Override // sy.e
    public final int h() {
        return Q(Y());
    }

    @Override // sy.c
    public final int i(kotlinx.serialization.descriptors.f descriptor, int i) {
        Intrinsics.h(descriptor, "descriptor");
        return Q(X(descriptor, i));
    }

    @Override // sy.e
    public final Void j() {
        return null;
    }

    @Override // sy.c
    public int k(kotlinx.serialization.descriptors.f fVar) {
        return c.a.a(this, fVar);
    }

    @Override // sy.e
    public final long l() {
        return R(Y());
    }

    @Override // sy.c
    public final String m(kotlinx.serialization.descriptors.f descriptor, int i) {
        Intrinsics.h(descriptor, "descriptor");
        return U(X(descriptor, i));
    }

    @Override // sy.c
    public final Object n(kotlinx.serialization.descriptors.f descriptor, int i, final kotlinx.serialization.a deserializer, final Object obj) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(deserializer, "deserializer");
        return a0(X(descriptor, i), new Function0<Object>() { // from class: kotlinx.serialization.internal.TaggedDecoder$decodeNullableSerializableElement$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TaggedDecoder.this.D() ? TaggedDecoder.this.I(deserializer, obj) : TaggedDecoder.this.j();
            }
        });
    }

    @Override // sy.c
    public boolean p() {
        return c.a.b(this);
    }

    @Override // sy.e
    public final sy.e q(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        return P(Y(), descriptor);
    }

    @Override // sy.c
    public final sy.e r(kotlinx.serialization.descriptors.f descriptor, int i) {
        Intrinsics.h(descriptor, "descriptor");
        return P(X(descriptor, i), descriptor.h(i));
    }

    @Override // sy.e
    public final short s() {
        return T(Y());
    }

    @Override // sy.e
    public final float t() {
        return O(Y());
    }

    @Override // sy.c
    public final float u(kotlinx.serialization.descriptors.f descriptor, int i) {
        Intrinsics.h(descriptor, "descriptor");
        return O(X(descriptor, i));
    }

    @Override // sy.e
    public final double v() {
        return M(Y());
    }

    @Override // sy.e
    public final boolean w() {
        return J(Y());
    }

    @Override // sy.e
    public final char x() {
        return L(Y());
    }

    @Override // sy.c
    public final Object y(kotlinx.serialization.descriptors.f descriptor, int i, final kotlinx.serialization.a deserializer, final Object obj) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(deserializer, "deserializer");
        return a0(X(descriptor, i), new Function0<Object>() { // from class: kotlinx.serialization.internal.TaggedDecoder$decodeSerializableElement$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TaggedDecoder.this.I(deserializer, obj);
            }
        });
    }

    @Override // sy.e
    public final String z() {
        return U(Y());
    }
}
