package z3;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a implements g {

    /* renamed from: c, reason: collision with root package name */
    public static final C0187a f18862c = new C0187a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f18863a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f18864b;

    /* renamed from: z3.a$a, reason: collision with other inner class name */
    public static final class C0187a {
        private C0187a() {
        }

        public /* synthetic */ C0187a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(f fVar, int i5, Object obj) {
            if (obj == null) {
                fVar.g(i5);
                return;
            }
            if (obj instanceof byte[]) {
                fVar.k0(i5, (byte[]) obj);
                return;
            }
            if (obj instanceof Float) {
                fVar.a(i5, ((Number) obj).floatValue());
                return;
            }
            if (obj instanceof Double) {
                fVar.a(i5, ((Number) obj).doubleValue());
                return;
            }
            if (obj instanceof Long) {
                fVar.c(i5, ((Number) obj).longValue());
                return;
            }
            if (obj instanceof Integer) {
                fVar.c(i5, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Short) {
                fVar.c(i5, ((Number) obj).shortValue());
                return;
            }
            if (obj instanceof Byte) {
                fVar.c(i5, ((Number) obj).byteValue());
                return;
            }
            if (obj instanceof String) {
                fVar.V(i5, (String) obj);
                return;
            }
            if (obj instanceof Boolean) {
                fVar.c(i5, ((Boolean) obj).booleanValue() ? 1L : 0L);
                return;
            }
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i5 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }

        public final void b(f fVar, Object[] objArr) {
            Intrinsics.h(fVar, "statement");
            if (objArr == null) {
                return;
            }
            int length = objArr.length;
            int i5 = 0;
            while (i5 < length) {
                Object obj = objArr[i5];
                i5++;
                a(fVar, i5, obj);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        this(str, null);
        Intrinsics.h(str, "query");
    }

    public a(String str, Object[] objArr) {
        Intrinsics.h(str, "query");
        this.f18863a = str;
        this.f18864b = objArr;
    }

    @Override // z3.g
    public void b(f fVar) {
        Intrinsics.h(fVar, "statement");
        f18862c.b(fVar, this.f18864b);
    }

    @Override // z3.g
    public String d() {
        return this.f18863a;
    }
}
