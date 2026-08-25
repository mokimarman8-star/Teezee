package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class k1 {

    /* renamed from: a, reason: collision with root package name */
    private static final Unsafe f7702a = H();

    /* renamed from: b, reason: collision with root package name */
    private static final Class f7703b = androidx.datastore.preferences.protobuf.d.b();

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f7704c = q(Long.TYPE);

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f7705d = q(Integer.TYPE);

    /* renamed from: e, reason: collision with root package name */
    private static final e f7706e = F();

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f7707f = Y();

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f7708g = X();

    /* renamed from: h, reason: collision with root package name */
    static final long f7709h;

    /* renamed from: i, reason: collision with root package name */
    private static final long f7710i;

    /* renamed from: j, reason: collision with root package name */
    private static final long f7711j;

    /* renamed from: k, reason: collision with root package name */
    private static final long f7712k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f7713l;

    /* renamed from: m, reason: collision with root package name */
    private static final long f7714m;

    /* renamed from: n, reason: collision with root package name */
    private static final long f7715n;

    /* renamed from: o, reason: collision with root package name */
    private static final long f7716o;

    /* renamed from: p, reason: collision with root package name */
    private static final long f7717p;

    /* renamed from: q, reason: collision with root package name */
    private static final long f7718q;

    /* renamed from: r, reason: collision with root package name */
    private static final long f7719r;

    /* renamed from: s, reason: collision with root package name */
    private static final long f7720s;

    /* renamed from: t, reason: collision with root package name */
    private static final long f7721t;

    /* renamed from: u, reason: collision with root package name */
    private static final long f7722u;

    /* renamed from: v, reason: collision with root package name */
    private static final int f7723v;

    /* renamed from: w, reason: collision with root package name */
    static final boolean f7724w;

    class a implements PrivilegedExceptionAction {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    private static final class b extends e {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void c(long j5, byte[] bArr, long j6, long j7) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean d(Object obj, long j5) {
            return k1.f7724w ? k1.u(obj, j5) : k1.v(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public byte e(long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public byte f(Object obj, long j5) {
            return k1.f7724w ? k1.y(obj, j5) : k1.z(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public double g(Object obj, long j5) {
            return Double.longBitsToDouble(k(obj, j5));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public float h(Object obj, long j5) {
            return Float.intBitsToFloat(i(obj, j5));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public long j(long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void n(Object obj, long j5, boolean z5) {
            if (k1.f7724w) {
                k1.N(obj, j5, z5);
            } else {
                k1.O(obj, j5, z5);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void o(Object obj, long j5, byte b5) {
            if (k1.f7724w) {
                k1.Q(obj, j5, b5);
            } else {
                k1.R(obj, j5, b5);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void p(Object obj, long j5, double d5) {
            s(obj, j5, Double.doubleToLongBits(d5));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void q(Object obj, long j5, float f5) {
            r(obj, j5, Float.floatToIntBits(f5));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean v() {
            return false;
        }
    }

    private static final class c extends e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void c(long j5, byte[] bArr, long j6, long j7) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean d(Object obj, long j5) {
            return k1.f7724w ? k1.u(obj, j5) : k1.v(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public byte e(long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public byte f(Object obj, long j5) {
            return k1.f7724w ? k1.y(obj, j5) : k1.z(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public double g(Object obj, long j5) {
            return Double.longBitsToDouble(k(obj, j5));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public float h(Object obj, long j5) {
            return Float.intBitsToFloat(i(obj, j5));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public long j(long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void n(Object obj, long j5, boolean z5) {
            if (k1.f7724w) {
                k1.N(obj, j5, z5);
            } else {
                k1.O(obj, j5, z5);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void o(Object obj, long j5, byte b5) {
            if (k1.f7724w) {
                k1.Q(obj, j5, b5);
            } else {
                k1.R(obj, j5, b5);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void p(Object obj, long j5, double d5) {
            s(obj, j5, Double.doubleToLongBits(d5));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void q(Object obj, long j5, float f5) {
            r(obj, j5, Float.floatToIntBits(f5));
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean v() {
            return false;
        }
    }

    private static final class d extends e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void c(long j5, byte[] bArr, long j6, long j7) {
            this.f7725a.copyMemory((Object) null, j5, bArr, k1.f7709h + j6, j7);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean d(Object obj, long j5) {
            return this.f7725a.getBoolean(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public byte e(long j5) {
            return this.f7725a.getByte(j5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public byte f(Object obj, long j5) {
            return this.f7725a.getByte(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public double g(Object obj, long j5) {
            return this.f7725a.getDouble(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public float h(Object obj, long j5) {
            return this.f7725a.getFloat(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public long j(long j5) {
            return this.f7725a.getLong(j5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void n(Object obj, long j5, boolean z5) {
            this.f7725a.putBoolean(obj, j5, z5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void o(Object obj, long j5, byte b5) {
            this.f7725a.putByte(obj, j5, b5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void p(Object obj, long j5, double d5) {
            this.f7725a.putDouble(obj, j5, d5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public void q(Object obj, long j5, float f5) {
            this.f7725a.putFloat(obj, j5, f5);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean u() {
            if (!super.u()) {
                return false;
            }
            try {
                Class<?> cls = this.f7725a.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                k1.K(th);
                return false;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.k1.e
        public boolean v() {
            if (!super.v()) {
                return false;
            }
            try {
                Class<?> cls = this.f7725a.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable th) {
                k1.K(th);
                return false;
            }
        }
    }

    private static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        Unsafe f7725a;

        e(Unsafe unsafe) {
            this.f7725a = unsafe;
        }

        public final int a(Class cls) {
            return this.f7725a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f7725a.arrayIndexScale(cls);
        }

        public abstract void c(long j5, byte[] bArr, long j6, long j7);

        public abstract boolean d(Object obj, long j5);

        public abstract byte e(long j5);

        public abstract byte f(Object obj, long j5);

        public abstract double g(Object obj, long j5);

        public abstract float h(Object obj, long j5);

        public final int i(Object obj, long j5) {
            return this.f7725a.getInt(obj, j5);
        }

        public abstract long j(long j5);

        public final long k(Object obj, long j5) {
            return this.f7725a.getLong(obj, j5);
        }

        public final Object l(Object obj, long j5) {
            return this.f7725a.getObject(obj, j5);
        }

        public final long m(Field field) {
            return this.f7725a.objectFieldOffset(field);
        }

        public abstract void n(Object obj, long j5, boolean z5);

        public abstract void o(Object obj, long j5, byte b5);

        public abstract void p(Object obj, long j5, double d5);

        public abstract void q(Object obj, long j5, float f5);

        public final void r(Object obj, long j5, int i5) {
            this.f7725a.putInt(obj, j5, i5);
        }

        public final void s(Object obj, long j5, long j6) {
            this.f7725a.putLong(obj, j5, j6);
        }

        public final void t(Object obj, long j5, Object obj2) {
            this.f7725a.putObject(obj, j5, obj2);
        }

        public boolean u() {
            Unsafe unsafe = this.f7725a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                k1.K(th);
                return false;
            }
        }

        public boolean v() {
            Unsafe unsafe = this.f7725a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return k1.o() != null;
            } catch (Throwable th) {
                k1.K(th);
                return false;
            }
        }
    }

    static {
        long m5 = m(byte[].class);
        f7709h = m5;
        f7710i = m(boolean[].class);
        f7711j = n(boolean[].class);
        f7712k = m(int[].class);
        f7713l = n(int[].class);
        f7714m = m(long[].class);
        f7715n = n(long[].class);
        f7716o = m(float[].class);
        f7717p = n(float[].class);
        f7718q = m(double[].class);
        f7719r = n(double[].class);
        f7720s = m(Object[].class);
        f7721t = n(Object[].class);
        f7722u = s(o());
        f7723v = (int) (m5 & 7);
        f7724w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    static double A(Object obj, long j5) {
        return f7706e.g(obj, j5);
    }

    static float B(Object obj, long j5) {
        return f7706e.h(obj, j5);
    }

    static int C(Object obj, long j5) {
        return f7706e.i(obj, j5);
    }

    static long D(long j5) {
        return f7706e.j(j5);
    }

    static long E(Object obj, long j5) {
        return f7706e.k(obj, j5);
    }

    private static e F() {
        Unsafe unsafe = f7702a;
        if (unsafe == null) {
            return null;
        }
        if (!androidx.datastore.preferences.protobuf.d.c()) {
            return new d(unsafe);
        }
        if (f7704c) {
            return new c(unsafe);
        }
        if (f7705d) {
            return new b(unsafe);
        }
        return null;
    }

    static Object G(Object obj, long j5) {
        return f7706e.l(obj, j5);
    }

    static Unsafe H() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean I() {
        return f7708g;
    }

    static boolean J() {
        return f7707f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(Throwable th) {
        Logger.getLogger(k1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    static long L(Field field) {
        return f7706e.m(field);
    }

    static void M(Object obj, long j5, boolean z5) {
        f7706e.n(obj, j5, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(Object obj, long j5, boolean z5) {
        Q(obj, j5, z5 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O(Object obj, long j5, boolean z5) {
        R(obj, j5, z5 ? (byte) 1 : (byte) 0);
    }

    static void P(byte[] bArr, long j5, byte b5) {
        f7706e.o(bArr, f7709h + j5, b5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(Object obj, long j5, byte b5) {
        long j6 = (-4) & j5;
        int C = C(obj, j6);
        int i5 = ((~((int) j5)) & 3) << 3;
        U(obj, j6, ((255 & b5) << i5) | (C & (~(255 << i5))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R(Object obj, long j5, byte b5) {
        long j6 = (-4) & j5;
        int i5 = (((int) j5) & 3) << 3;
        U(obj, j6, ((255 & b5) << i5) | (C(obj, j6) & (~(255 << i5))));
    }

    static void S(Object obj, long j5, double d5) {
        f7706e.p(obj, j5, d5);
    }

    static void T(Object obj, long j5, float f5) {
        f7706e.q(obj, j5, f5);
    }

    static void U(Object obj, long j5, int i5) {
        f7706e.r(obj, j5, i5);
    }

    static void V(Object obj, long j5, long j6) {
        f7706e.s(obj, j5, j6);
    }

    static void W(Object obj, long j5, Object obj2) {
        f7706e.t(obj, j5, obj2);
    }

    private static boolean X() {
        e eVar = f7706e;
        if (eVar == null) {
            return false;
        }
        return eVar.u();
    }

    private static boolean Y() {
        e eVar = f7706e;
        if (eVar == null) {
            return false;
        }
        return eVar.v();
    }

    static long k(ByteBuffer byteBuffer) {
        return f7706e.k(byteBuffer, f7722u);
    }

    static Object l(Class cls) {
        try {
            return f7702a.allocateInstance(cls);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    private static int m(Class cls) {
        if (f7708g) {
            return f7706e.a(cls);
        }
        return -1;
    }

    private static int n(Class cls) {
        if (f7708g) {
            return f7706e.b(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field o() {
        Field r5;
        if (androidx.datastore.preferences.protobuf.d.c() && (r5 = r(Buffer.class, "effectiveDirectAddress")) != null) {
            return r5;
        }
        Field r6 = r(Buffer.class, "address");
        if (r6 == null || r6.getType() != Long.TYPE) {
            return null;
        }
        return r6;
    }

    static void p(long j5, byte[] bArr, long j6, long j7) {
        f7706e.c(j5, bArr, j6, j7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean q(Class cls) {
        if (!androidx.datastore.preferences.protobuf.d.c()) {
            return false;
        }
        try {
            Class cls2 = f7703b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field r(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long s(Field field) {
        e eVar;
        if (field == null || (eVar = f7706e) == null) {
            return -1L;
        }
        return eVar.m(field);
    }

    static boolean t(Object obj, long j5) {
        return f7706e.d(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean u(Object obj, long j5) {
        return y(obj, j5) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean v(Object obj, long j5) {
        return z(obj, j5) != 0;
    }

    static byte w(long j5) {
        return f7706e.e(j5);
    }

    static byte x(byte[] bArr, long j5) {
        return f7706e.f(bArr, f7709h + j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte y(Object obj, long j5) {
        return (byte) ((C(obj, (-4) & j5) >>> ((int) (((~j5) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte z(Object obj, long j5) {
        return (byte) ((C(obj, (-4) & j5) >>> ((int) ((j5 & 3) << 3))) & 255);
    }
}
