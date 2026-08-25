package androidx.collection;

import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private Object[] f1265a;

    /* renamed from: b, reason: collision with root package name */
    private int f1266b;

    /* renamed from: c, reason: collision with root package name */
    private int f1267c;

    /* renamed from: d, reason: collision with root package name */
    private int f1268d;

    @JvmOverloads
    public e() {
        this(0, 1, null);
    }

    public e(int i5) {
        if (!(i5 >= 1)) {
            n.d.a("capacity must be >= 1");
        }
        if (!(i5 <= 1073741824)) {
            n.d.a("capacity must be <= 2^30");
        }
        i5 = Integer.bitCount(i5) != 1 ? Integer.highestOneBit(i5 - 1) << 1 : i5;
        this.f1268d = i5 - 1;
        this.f1265a = new Object[i5];
    }

    public /* synthetic */ e(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 8 : i5);
    }

    private final void b() {
        Object[] objArr = this.f1265a;
        int length = objArr.length;
        int i5 = this.f1266b;
        int i6 = length - i5;
        int i7 = length << 1;
        if (i7 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        Object[] objArr2 = new Object[i7];
        ArraysKt.l(objArr, objArr2, 0, i5, length);
        ArraysKt.l(this.f1265a, objArr2, i6, 0, this.f1266b);
        this.f1265a = objArr2;
        this.f1266b = 0;
        this.f1267c = length;
        this.f1268d = i7 - 1;
    }

    public final void a(Object obj) {
        Object[] objArr = this.f1265a;
        int i5 = this.f1267c;
        objArr[i5] = obj;
        int i6 = this.f1268d & (i5 + 1);
        this.f1267c = i6;
        if (i6 == this.f1266b) {
            b();
        }
    }

    public final Object c(int i5) {
        if (i5 < 0 || i5 >= f()) {
            g gVar = g.f1275a;
            throw new ArrayIndexOutOfBoundsException();
        }
        Object obj = this.f1265a[this.f1268d & (this.f1266b + i5)];
        Intrinsics.e(obj);
        return obj;
    }

    public final boolean d() {
        return this.f1266b == this.f1267c;
    }

    public final Object e() {
        int i5 = this.f1266b;
        if (i5 == this.f1267c) {
            g gVar = g.f1275a;
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] objArr = this.f1265a;
        Object obj = objArr[i5];
        objArr[i5] = null;
        this.f1266b = (i5 + 1) & this.f1268d;
        return obj;
    }

    public final int f() {
        return (this.f1267c - this.f1266b) & this.f1268d;
    }
}
