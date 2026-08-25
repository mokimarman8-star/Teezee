package androidx.collection;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class x implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f1355a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ long[] f1356b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f1357c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f1358d;

    @JvmOverloads
    public x() {
        this(0, 1, null);
    }

    public x(int i5) {
        if (i5 == 0) {
            this.f1356b = n.a.f16550b;
            this.f1357c = n.a.f16551c;
        } else {
            int f5 = n.a.f(i5);
            this.f1356b = new long[f5];
            this.f1357c = new Object[f5];
        }
    }

    public /* synthetic */ x(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 10 : i5);
    }

    public void a(long j5, Object obj) {
        Object obj2;
        int i5 = this.f1358d;
        if (i5 != 0 && j5 <= this.f1356b[i5 - 1]) {
            k(j5, obj);
            return;
        }
        if (this.f1355a) {
            long[] jArr = this.f1356b;
            if (i5 >= jArr.length) {
                Object[] objArr = this.f1357c;
                int i6 = 0;
                for (int i7 = 0; i7 < i5; i7++) {
                    Object obj3 = objArr[i7];
                    obj2 = y.f1359a;
                    if (obj3 != obj2) {
                        if (i7 != i6) {
                            jArr[i6] = jArr[i7];
                            objArr[i6] = obj3;
                            objArr[i7] = null;
                        }
                        i6++;
                    }
                }
                this.f1355a = false;
                this.f1358d = i6;
            }
        }
        int i8 = this.f1358d;
        if (i8 >= this.f1356b.length) {
            int f5 = n.a.f(i8 + 1);
            long[] copyOf = Arrays.copyOf(this.f1356b, f5);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f1356b = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f1357c, f5);
            Intrinsics.g(copyOf2, "copyOf(this, newSize)");
            this.f1357c = copyOf2;
        }
        this.f1356b[i8] = j5;
        this.f1357c[i8] = obj;
        this.f1358d = i8 + 1;
    }

    public void b() {
        int i5 = this.f1358d;
        Object[] objArr = this.f1357c;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        this.f1358d = 0;
        this.f1355a = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public x clone() {
        Object clone = super.clone();
        Intrinsics.f(clone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        x xVar = (x) clone;
        xVar.f1356b = (long[]) this.f1356b.clone();
        xVar.f1357c = (Object[]) this.f1357c.clone();
        return xVar;
    }

    public boolean d(long j5) {
        return h(j5) >= 0;
    }

    public Object e(long j5) {
        Object obj;
        int b5 = n.a.b(this.f1356b, this.f1358d, j5);
        if (b5 >= 0) {
            Object obj2 = this.f1357c[b5];
            obj = y.f1359a;
            if (obj2 != obj) {
                return this.f1357c[b5];
            }
        }
        return null;
    }

    public Object g(long j5, Object obj) {
        Object obj2;
        int b5 = n.a.b(this.f1356b, this.f1358d, j5);
        if (b5 < 0) {
            return obj;
        }
        Object obj3 = this.f1357c[b5];
        obj2 = y.f1359a;
        return obj3 == obj2 ? obj : this.f1357c[b5];
    }

    public int h(long j5) {
        Object obj;
        if (this.f1355a) {
            int i5 = this.f1358d;
            long[] jArr = this.f1356b;
            Object[] objArr = this.f1357c;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj2 = objArr[i7];
                obj = y.f1359a;
                if (obj2 != obj) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj2;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.f1355a = false;
            this.f1358d = i6;
        }
        return n.a.b(this.f1356b, this.f1358d, j5);
    }

    public boolean i() {
        return n() == 0;
    }

    public long j(int i5) {
        Object obj;
        if (!(i5 >= 0 && i5 < this.f1358d)) {
            n.d.a("Expected index to be within 0..size()-1, but was " + i5);
        }
        if (this.f1355a) {
            int i6 = this.f1358d;
            long[] jArr = this.f1356b;
            Object[] objArr = this.f1357c;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj2 = objArr[i8];
                obj = y.f1359a;
                if (obj2 != obj) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj2;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.f1355a = false;
            this.f1358d = i7;
        }
        return this.f1356b[i5];
    }

    public void k(long j5, Object obj) {
        Object obj2;
        Object obj3;
        int b5 = n.a.b(this.f1356b, this.f1358d, j5);
        if (b5 >= 0) {
            this.f1357c[b5] = obj;
            return;
        }
        int i5 = ~b5;
        if (i5 < this.f1358d) {
            Object obj4 = this.f1357c[i5];
            obj3 = y.f1359a;
            if (obj4 == obj3) {
                this.f1356b[i5] = j5;
                this.f1357c[i5] = obj;
                return;
            }
        }
        if (this.f1355a) {
            int i6 = this.f1358d;
            long[] jArr = this.f1356b;
            if (i6 >= jArr.length) {
                Object[] objArr = this.f1357c;
                int i7 = 0;
                for (int i8 = 0; i8 < i6; i8++) {
                    Object obj5 = objArr[i8];
                    obj2 = y.f1359a;
                    if (obj5 != obj2) {
                        if (i8 != i7) {
                            jArr[i7] = jArr[i8];
                            objArr[i7] = obj5;
                            objArr[i8] = null;
                        }
                        i7++;
                    }
                }
                this.f1355a = false;
                this.f1358d = i7;
                i5 = ~n.a.b(this.f1356b, i7, j5);
            }
        }
        int i9 = this.f1358d;
        if (i9 >= this.f1356b.length) {
            int f5 = n.a.f(i9 + 1);
            long[] copyOf = Arrays.copyOf(this.f1356b, f5);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f1356b = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f1357c, f5);
            Intrinsics.g(copyOf2, "copyOf(this, newSize)");
            this.f1357c = copyOf2;
        }
        int i10 = this.f1358d;
        if (i10 - i5 != 0) {
            long[] jArr2 = this.f1356b;
            int i11 = i5 + 1;
            ArraysKt.k(jArr2, jArr2, i11, i5, i10);
            Object[] objArr2 = this.f1357c;
            ArraysKt.l(objArr2, objArr2, i11, i5, this.f1358d);
        }
        this.f1356b[i5] = j5;
        this.f1357c[i5] = obj;
        this.f1358d++;
    }

    public void l(long j5) {
        Object obj;
        Object obj2;
        int b5 = n.a.b(this.f1356b, this.f1358d, j5);
        if (b5 >= 0) {
            Object obj3 = this.f1357c[b5];
            obj = y.f1359a;
            if (obj3 != obj) {
                Object[] objArr = this.f1357c;
                obj2 = y.f1359a;
                objArr[b5] = obj2;
                this.f1355a = true;
            }
        }
    }

    public void m(int i5) {
        Object obj;
        Object obj2;
        Object obj3 = this.f1357c[i5];
        obj = y.f1359a;
        if (obj3 != obj) {
            Object[] objArr = this.f1357c;
            obj2 = y.f1359a;
            objArr[i5] = obj2;
            this.f1355a = true;
        }
    }

    public int n() {
        Object obj;
        if (this.f1355a) {
            int i5 = this.f1358d;
            long[] jArr = this.f1356b;
            Object[] objArr = this.f1357c;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj2 = objArr[i7];
                obj = y.f1359a;
                if (obj2 != obj) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj2;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.f1355a = false;
            this.f1358d = i6;
        }
        return this.f1358d;
    }

    public Object o(int i5) {
        Object obj;
        if (!(i5 >= 0 && i5 < this.f1358d)) {
            n.d.a("Expected index to be within 0..size()-1, but was " + i5);
        }
        if (this.f1355a) {
            int i6 = this.f1358d;
            long[] jArr = this.f1356b;
            Object[] objArr = this.f1357c;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj2 = objArr[i8];
                obj = y.f1359a;
                if (obj2 != obj) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj2;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.f1355a = false;
            this.f1358d = i7;
        }
        return this.f1357c[i5];
    }

    public String toString() {
        if (n() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1358d * 28);
        sb.append('{');
        int i5 = this.f1358d;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(j(i6));
            sb.append('=');
            Object o5 = o(i6);
            if (o5 != sb) {
                sb.append(o5);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }
}
