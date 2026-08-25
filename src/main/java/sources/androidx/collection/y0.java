package androidx.collection;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class y0 implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f1360a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ int[] f1361b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f1362c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f1363d;

    @JvmOverloads
    public y0() {
        this(0, 1, null);
    }

    public y0(int i5) {
        if (i5 == 0) {
            this.f1361b = n.a.f16549a;
            this.f1362c = n.a.f16551c;
        } else {
            int e5 = n.a.e(i5);
            this.f1361b = new int[e5];
            this.f1362c = new Object[e5];
        }
    }

    public /* synthetic */ y0(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 10 : i5);
    }

    public void a(int i5, Object obj) {
        int i6 = this.f1363d;
        if (i6 != 0 && i5 <= this.f1361b[i6 - 1]) {
            l(i5, obj);
            return;
        }
        if (this.f1360a && i6 >= this.f1361b.length) {
            z0.f(this);
        }
        int i7 = this.f1363d;
        if (i7 >= this.f1361b.length) {
            int e5 = n.a.e(i7 + 1);
            int[] copyOf = Arrays.copyOf(this.f1361b, e5);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f1361b = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f1362c, e5);
            Intrinsics.g(copyOf2, "copyOf(this, newSize)");
            this.f1362c = copyOf2;
        }
        this.f1361b[i7] = i5;
        this.f1362c[i7] = obj;
        this.f1363d = i7 + 1;
    }

    public void b() {
        int i5 = this.f1363d;
        Object[] objArr = this.f1362c;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        this.f1363d = 0;
        this.f1360a = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public y0 clone() {
        Object clone = super.clone();
        Intrinsics.f(clone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        y0 y0Var = (y0) clone;
        y0Var.f1361b = (int[]) this.f1361b.clone();
        y0Var.f1362c = (Object[]) this.f1362c.clone();
        return y0Var;
    }

    public boolean d(int i5) {
        return i(i5) >= 0;
    }

    public boolean e(Object obj) {
        if (this.f1360a) {
            z0.f(this);
        }
        int i5 = this.f1363d;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                i6 = -1;
                break;
            }
            if (this.f1362c[i6] == obj) {
                break;
            }
            i6++;
        }
        return i6 >= 0;
    }

    public Object g(int i5) {
        return z0.c(this, i5);
    }

    public Object h(int i5, Object obj) {
        return z0.d(this, i5, obj);
    }

    public int i(int i5) {
        if (this.f1360a) {
            z0.f(this);
        }
        return n.a.a(this.f1361b, this.f1363d, i5);
    }

    public int j(Object obj) {
        if (this.f1360a) {
            z0.f(this);
        }
        int i5 = this.f1363d;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.f1362c[i6] == obj) {
                return i6;
            }
        }
        return -1;
    }

    public int k(int i5) {
        if (this.f1360a) {
            z0.f(this);
        }
        return this.f1361b[i5];
    }

    public void l(int i5, Object obj) {
        Object obj2;
        int a5 = n.a.a(this.f1361b, this.f1363d, i5);
        if (a5 >= 0) {
            this.f1362c[a5] = obj;
            return;
        }
        int i6 = ~a5;
        if (i6 < this.f1363d) {
            Object obj3 = this.f1362c[i6];
            obj2 = z0.f1364a;
            if (obj3 == obj2) {
                this.f1361b[i6] = i5;
                this.f1362c[i6] = obj;
                return;
            }
        }
        if (this.f1360a && this.f1363d >= this.f1361b.length) {
            z0.f(this);
            i6 = ~n.a.a(this.f1361b, this.f1363d, i5);
        }
        int i7 = this.f1363d;
        if (i7 >= this.f1361b.length) {
            int e5 = n.a.e(i7 + 1);
            int[] copyOf = Arrays.copyOf(this.f1361b, e5);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f1361b = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f1362c, e5);
            Intrinsics.g(copyOf2, "copyOf(this, newSize)");
            this.f1362c = copyOf2;
        }
        int i8 = this.f1363d;
        if (i8 - i6 != 0) {
            int[] iArr = this.f1361b;
            int i9 = i6 + 1;
            ArraysKt.j(iArr, iArr, i9, i6, i8);
            Object[] objArr = this.f1362c;
            ArraysKt.l(objArr, objArr, i9, i6, this.f1363d);
        }
        this.f1361b[i6] = i5;
        this.f1362c[i6] = obj;
        this.f1363d++;
    }

    public void m(int i5) {
        z0.e(this, i5);
    }

    public void n(int i5) {
        Object obj;
        Object obj2;
        Object obj3 = this.f1362c[i5];
        obj = z0.f1364a;
        if (obj3 != obj) {
            Object[] objArr = this.f1362c;
            obj2 = z0.f1364a;
            objArr[i5] = obj2;
            this.f1360a = true;
        }
    }

    public Object o(int i5, Object obj) {
        int i6 = i(i5);
        if (i6 < 0) {
            return null;
        }
        Object[] objArr = this.f1362c;
        Object obj2 = objArr[i6];
        objArr[i6] = obj;
        return obj2;
    }

    public int p() {
        if (this.f1360a) {
            z0.f(this);
        }
        return this.f1363d;
    }

    public Object q(int i5) {
        if (this.f1360a) {
            z0.f(this);
        }
        return this.f1362c[i5];
    }

    public String toString() {
        if (p() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1363d * 28);
        sb.append('{');
        int i5 = this.f1363d;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(k(i6));
            sb.append('=');
            Object q5 = q(i6);
            if (q5 != this) {
                sb.append(q5);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "buffer.toString()");
        return sb2;
    }
}
