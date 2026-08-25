package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class o {

    /* renamed from: c, reason: collision with root package name */
    public static final l f12545c = new l(null);

    /* renamed from: d, reason: collision with root package name */
    public static final o f12546d = new f();

    /* renamed from: e, reason: collision with root package name */
    public static final o f12547e = new i();

    /* renamed from: f, reason: collision with root package name */
    public static final o f12548f = new e();

    /* renamed from: g, reason: collision with root package name */
    public static final o f12549g = new h();

    /* renamed from: h, reason: collision with root package name */
    public static final o f12550h = new g();

    /* renamed from: i, reason: collision with root package name */
    public static final o f12551i = new d();

    /* renamed from: j, reason: collision with root package name */
    public static final o f12552j = new c();

    /* renamed from: k, reason: collision with root package name */
    public static final o f12553k = new b();

    /* renamed from: l, reason: collision with root package name */
    public static final o f12554l = new a();

    /* renamed from: m, reason: collision with root package name */
    public static final o f12555m = new k();

    /* renamed from: n, reason: collision with root package name */
    public static final o f12556n = new j();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f12557a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12558b = "nav_type";

    public static final class a extends o {
        a() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "boolean[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean[] a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            return (boolean[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean[] h(String str) {
            Intrinsics.h(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String str, boolean[] zArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            bundle.putBooleanArray(str, zArr);
        }
    }

    public static final class b extends o {
        b() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "boolean";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Object obj) {
            i(bundle, str, ((Boolean) obj).booleanValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            return (Boolean) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean h(String str) {
            boolean z5;
            Intrinsics.h(str, "value");
            if (Intrinsics.c(str, "true")) {
                z5 = true;
            } else {
                if (!Intrinsics.c(str, "false")) {
                    throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
                }
                z5 = false;
            }
            return Boolean.valueOf(z5);
        }

        public void i(Bundle bundle, String str, boolean z5) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            bundle.putBoolean(str, z5);
        }
    }

    public static final class c extends o {
        c() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "float[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public float[] a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            return (float[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public float[] h(String str) {
            Intrinsics.h(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String str, float[] fArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            bundle.putFloatArray(str, fArr);
        }
    }

    public static final class d extends o {
        d() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "float";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Object obj) {
            i(bundle, str, ((Number) obj).floatValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Float a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            Object obj = bundle.get(str);
            if (obj != null) {
                return (Float) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Float h(String str) {
            Intrinsics.h(str, "value");
            return Float.valueOf(Float.parseFloat(str));
        }

        public void i(Bundle bundle, String str, float f5) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            bundle.putFloat(str, f5);
        }
    }

    public static final class e extends o {
        e() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "integer[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int[] a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            return (int[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public int[] h(String str) {
            Intrinsics.h(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String str, int[] iArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            bundle.putIntArray(str, iArr);
        }
    }

    public static final class f extends o {
        f() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "integer";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Object obj) {
            i(bundle, str, ((Number) obj).intValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Integer a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            Object obj = bundle.get(str);
            if (obj != null) {
                return (Integer) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Integer h(String str) {
            int parseInt;
            Intrinsics.h(str, "value");
            if (StringsKt.W(str, "0x", false, 2, (Object) null)) {
                String substring = str.substring(2);
                Intrinsics.g(substring, "this as java.lang.String).substring(startIndex)");
                parseInt = Integer.parseInt(substring, CharsKt.a(16));
            } else {
                parseInt = Integer.parseInt(str);
            }
            return Integer.valueOf(parseInt);
        }

        public void i(Bundle bundle, String str, int i5) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            bundle.putInt(str, i5);
        }
    }

    public static final class g extends o {
        g() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "long[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public long[] a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            return (long[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public long[] h(String str) {
            Intrinsics.h(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String str, long[] jArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            bundle.putLongArray(str, jArr);
        }
    }

    public static final class h extends o {
        h() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "long";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Object obj) {
            i(bundle, str, ((Number) obj).longValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Long a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            Object obj = bundle.get(str);
            if (obj != null) {
                return (Long) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Long h(String str) {
            String str2;
            long parseLong;
            Intrinsics.h(str, "value");
            if (StringsKt.G(str, "L", false, 2, (Object) null)) {
                str2 = str.substring(0, str.length() - 1);
                Intrinsics.g(str2, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                str2 = str;
            }
            if (StringsKt.W(str, "0x", false, 2, (Object) null)) {
                String substring = str2.substring(2);
                Intrinsics.g(substring, "this as java.lang.String).substring(startIndex)");
                parseLong = Long.parseLong(substring, CharsKt.a(16));
            } else {
                parseLong = Long.parseLong(str2);
            }
            return Long.valueOf(parseLong);
        }

        public void i(Bundle bundle, String str, long j5) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            bundle.putLong(str, j5);
        }
    }

    public static final class i extends o {
        i() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "reference";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Object obj) {
            i(bundle, str, ((Number) obj).intValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Integer a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            Object obj = bundle.get(str);
            if (obj != null) {
                return (Integer) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Integer h(String str) {
            int parseInt;
            Intrinsics.h(str, "value");
            if (StringsKt.W(str, "0x", false, 2, (Object) null)) {
                String substring = str.substring(2);
                Intrinsics.g(substring, "this as java.lang.String).substring(startIndex)");
                parseInt = Integer.parseInt(substring, CharsKt.a(16));
            } else {
                parseInt = Integer.parseInt(str);
            }
            return Integer.valueOf(parseInt);
        }

        public void i(Bundle bundle, String str, int i5) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            bundle.putInt(str, i5);
        }
    }

    public static final class j extends o {
        j() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "string[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public String[] a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            return (String[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public String[] h(String str) {
            Intrinsics.h(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String str, String[] strArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            bundle.putStringArray(str, strArr);
        }
    }

    public static final class k extends o {
        k() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "string";
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public String a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            return (String) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public String h(String str) {
            Intrinsics.h(str, "value");
            return str;
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String str, String str2) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            bundle.putString(str, str2);
        }
    }

    public static final class l {
        private l() {
        }

        public /* synthetic */ l(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public o a(String str, String str2) {
            o oVar = o.f12546d;
            if (Intrinsics.c(oVar.b(), str)) {
                return oVar;
            }
            o oVar2 = o.f12548f;
            if (Intrinsics.c(oVar2.b(), str)) {
                return oVar2;
            }
            o oVar3 = o.f12549g;
            if (Intrinsics.c(oVar3.b(), str)) {
                return oVar3;
            }
            o oVar4 = o.f12550h;
            if (Intrinsics.c(oVar4.b(), str)) {
                return oVar4;
            }
            o oVar5 = o.f12553k;
            if (Intrinsics.c(oVar5.b(), str)) {
                return oVar5;
            }
            o oVar6 = o.f12554l;
            if (Intrinsics.c(oVar6.b(), str)) {
                return oVar6;
            }
            o oVar7 = o.f12555m;
            if (Intrinsics.c(oVar7.b(), str)) {
                return oVar7;
            }
            o oVar8 = o.f12556n;
            if (Intrinsics.c(oVar8.b(), str)) {
                return oVar8;
            }
            o oVar9 = o.f12551i;
            if (Intrinsics.c(oVar9.b(), str)) {
                return oVar9;
            }
            o oVar10 = o.f12552j;
            if (Intrinsics.c(oVar10.b(), str)) {
                return oVar10;
            }
            o oVar11 = o.f12547e;
            if (Intrinsics.c(oVar11.b(), str)) {
                return oVar11;
            }
            if (str == null || str.length() == 0) {
                return oVar7;
            }
            try {
                String q5 = (!StringsKt.W(str, ".", false, 2, (Object) null) || str2 == null) ? str : Intrinsics.q(str2, str);
                if (StringsKt.G(str, "[]", false, 2, (Object) null)) {
                    q5 = q5.substring(0, q5.length() - 2);
                    Intrinsics.g(q5, "this as java.lang.String…ing(startIndex, endIndex)");
                    Class<?> cls = Class.forName(q5);
                    if (Parcelable.class.isAssignableFrom(cls)) {
                        return new n(cls);
                    }
                    if (Serializable.class.isAssignableFrom(cls)) {
                        return new p(cls);
                    }
                } else {
                    Class<?> cls2 = Class.forName(q5);
                    if (Parcelable.class.isAssignableFrom(cls2)) {
                        return new C0089o(cls2);
                    }
                    if (Enum.class.isAssignableFrom(cls2)) {
                        return new m(cls2);
                    }
                    if (Serializable.class.isAssignableFrom(cls2)) {
                        return new q(cls2);
                    }
                }
                throw new IllegalArgumentException(Intrinsics.q(q5, " is not Serializable or Parcelable."));
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException(e5);
            }
        }

        public final o b(String str) {
            Intrinsics.h(str, "value");
            try {
                try {
                    try {
                        try {
                            o oVar = o.f12546d;
                            oVar.h(str);
                            return oVar;
                        } catch (IllegalArgumentException unused) {
                            o oVar2 = o.f12551i;
                            oVar2.h(str);
                            return oVar2;
                        }
                    } catch (IllegalArgumentException unused2) {
                        o oVar3 = o.f12549g;
                        oVar3.h(str);
                        return oVar3;
                    }
                } catch (IllegalArgumentException unused3) {
                    return o.f12555m;
                }
            } catch (IllegalArgumentException unused4) {
                o oVar4 = o.f12553k;
                oVar4.h(str);
                return oVar4;
            }
        }

        public final o c(Object obj) {
            o qVar;
            if (obj instanceof Integer) {
                return o.f12546d;
            }
            if (obj instanceof int[]) {
                return o.f12548f;
            }
            if (obj instanceof Long) {
                return o.f12549g;
            }
            if (obj instanceof long[]) {
                return o.f12550h;
            }
            if (obj instanceof Float) {
                return o.f12551i;
            }
            if (obj instanceof float[]) {
                return o.f12552j;
            }
            if (obj instanceof Boolean) {
                return o.f12553k;
            }
            if (obj instanceof boolean[]) {
                return o.f12554l;
            }
            if ((obj instanceof String) || obj == null) {
                return o.f12555m;
            }
            if ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) {
                return o.f12556n;
            }
            if (obj.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                Intrinsics.e(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    Class<?> componentType2 = obj.getClass().getComponentType();
                    if (componentType2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                    }
                    qVar = new n(componentType2);
                    return qVar;
                }
            }
            if (obj.getClass().isArray()) {
                Class<?> componentType3 = obj.getClass().getComponentType();
                Intrinsics.e(componentType3);
                if (Serializable.class.isAssignableFrom(componentType3)) {
                    Class<?> componentType4 = obj.getClass().getComponentType();
                    if (componentType4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                    }
                    qVar = new p(componentType4);
                    return qVar;
                }
            }
            if (obj instanceof Parcelable) {
                qVar = new C0089o(obj.getClass());
            } else if (obj instanceof Enum) {
                qVar = new m(obj.getClass());
            } else {
                if (!(obj instanceof Serializable)) {
                    throw new IllegalArgumentException("Object of type " + ((Object) obj.getClass().getName()) + " is not supported for navigation arguments.");
                }
                qVar = new q(obj.getClass());
            }
            return qVar;
        }
    }

    public static final class m extends q {

        /* renamed from: p, reason: collision with root package name */
        private final Class f12559p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Class cls) {
            super(false, cls);
            Intrinsics.h(cls, "type");
            if (cls.isEnum()) {
                this.f12559p = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " is not an Enum type.").toString());
        }

        @Override // androidx.navigation.o.q, androidx.navigation.o
        public String b() {
            String name = this.f12559p.getName();
            Intrinsics.g(name, "type.name");
            return name;
        }

        @Override // androidx.navigation.o.q
        /* renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Enum h(String str) {
            Object obj;
            Intrinsics.h(str, "value");
            Object[] enumConstants = this.f12559p.getEnumConstants();
            Intrinsics.g(enumConstants, "type.enumConstants");
            int length = enumConstants.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    obj = null;
                    break;
                }
                obj = enumConstants[i5];
                i5++;
                if (StringsKt.H(((Enum) obj).name(), str, true)) {
                    break;
                }
            }
            Enum r32 = (Enum) obj;
            if (r32 != null) {
                return r32;
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + ((Object) this.f12559p.getName()) + '.');
        }
    }

    public static final class n extends o {

        /* renamed from: o, reason: collision with root package name */
        private final Class f12560o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Class cls) {
            super(true);
            Intrinsics.h(cls, "type");
            if (!Parcelable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Parcelable.").toString());
            }
            try {
                this.f12560o = Class.forName("[L" + ((Object) cls.getName()) + ';');
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException(e5);
            }
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.f12560o.getName();
            Intrinsics.g(name, "arrayType.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.c(n.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.c(this.f12560o, ((n) obj).f12560o);
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Parcelable[] a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            return (Parcelable[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        public Parcelable[] h(String str) {
            Intrinsics.h(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public int hashCode() {
            return this.f12560o.hashCode();
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String str, Parcelable[] parcelableArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            this.f12560o.cast(parcelableArr);
            bundle.putParcelableArray(str, parcelableArr);
        }
    }

    /* renamed from: androidx.navigation.o$o, reason: collision with other inner class name */
    public static final class C0089o extends o {

        /* renamed from: o, reason: collision with root package name */
        private final Class f12561o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0089o(Class cls) {
            super(true);
            Intrinsics.h(cls, "type");
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.f12561o = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Parcelable or Serializable.").toString());
        }

        @Override // androidx.navigation.o
        public Object a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            return bundle.get(str);
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.f12561o.getName();
            Intrinsics.g(name, "type.name");
            return name;
        }

        @Override // androidx.navigation.o
        /* renamed from: e */
        public Object h(String str) {
            Intrinsics.h(str, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.c(C0089o.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.c(this.f12561o, ((C0089o) obj).f12561o);
        }

        @Override // androidx.navigation.o
        public void f(Bundle bundle, String str, Object obj) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            this.f12561o.cast(obj);
            if (obj == null || (obj instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            }
        }

        public int hashCode() {
            return this.f12561o.hashCode();
        }
    }

    public static final class p extends o {

        /* renamed from: o, reason: collision with root package name */
        private final Class f12562o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Class cls) {
            super(true);
            Intrinsics.h(cls, "type");
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            }
            try {
                this.f12562o = Class.forName("[L" + ((Object) cls.getName()) + ';');
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException(e5);
            }
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.f12562o.getName();
            Intrinsics.g(name, "arrayType.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.c(p.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.c(this.f12562o, ((p) obj).f12562o);
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Serializable[] a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            return (Serializable[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        public Serializable[] h(String str) {
            Intrinsics.h(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public int hashCode() {
            return this.f12562o.hashCode();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String str, Serializable[] serializableArr) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            this.f12562o.cast(serializableArr);
            bundle.putSerializable(str, serializableArr);
        }
    }

    public static class q extends o {

        /* renamed from: o, reason: collision with root package name */
        private final Class f12563o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(Class cls) {
            super(true);
            Intrinsics.h(cls, "type");
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            }
            if (!cls.isEnum()) {
                this.f12563o = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " is an Enum. You should use EnumType instead.").toString());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(boolean z5, Class cls) {
            super(z5);
            Intrinsics.h(cls, "type");
            if (Serializable.class.isAssignableFrom(cls)) {
                this.f12563o = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.f12563o.getName();
            Intrinsics.g(name, "type.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof q) {
                return Intrinsics.c(this.f12563o, ((q) obj).f12563o);
            }
            return false;
        }

        @Override // androidx.navigation.o
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Serializable a(Bundle bundle, String str) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            return (Serializable) bundle.get(str);
        }

        @Override // androidx.navigation.o
        public Serializable h(String str) {
            Intrinsics.h(str, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public int hashCode() {
            return this.f12563o.hashCode();
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String str, Serializable serializable) {
            Intrinsics.h(bundle, "bundle");
            Intrinsics.h(str, "key");
            Intrinsics.h(serializable, "value");
            this.f12563o.cast(serializable);
            bundle.putSerializable(str, serializable);
        }
    }

    public o(boolean z5) {
        this.f12557a = z5;
    }

    public abstract Object a(Bundle bundle, String str);

    public abstract String b();

    public boolean c() {
        return this.f12557a;
    }

    public final Object d(Bundle bundle, String str, String str2) {
        Intrinsics.h(bundle, "bundle");
        Intrinsics.h(str, "key");
        Intrinsics.h(str2, "value");
        Object h5 = h(str2);
        f(bundle, str, h5);
        return h5;
    }

    /* renamed from: e */
    public abstract Object h(String str);

    public abstract void f(Bundle bundle, String str, Object obj);

    public String toString() {
        return b();
    }
}
