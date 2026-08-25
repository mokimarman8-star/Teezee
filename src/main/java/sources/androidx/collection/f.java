package androidx.collection;

import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private int[] f1270a;

    /* renamed from: b, reason: collision with root package name */
    private int f1271b;

    /* renamed from: c, reason: collision with root package name */
    private int f1272c;

    /* renamed from: d, reason: collision with root package name */
    private int f1273d;

    @JvmOverloads
    public f() {
        this(0, 1, null);
    }

    public f(int i5) {
        if (!(i5 >= 1)) {
            n.d.a("capacity must be >= 1");
        }
        if (!(i5 <= 1073741824)) {
            n.d.a("capacity must be <= 2^30");
        }
        i5 = Integer.bitCount(i5) != 1 ? Integer.highestOneBit(i5 - 1) << 1 : i5;
        this.f1273d = i5 - 1;
        this.f1270a = new int[i5];
    }

    public /* synthetic */ f(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 8 : i5);
    }

    private final void c() {
        int[] iArr = this.f1270a;
        int length = iArr.length;
        int i5 = this.f1271b;
        int i6 = length - i5;
        int i7 = length << 1;
        if (i7 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i7];
        ArraysKt.j(iArr, iArr2, 0, i5, length);
        ArraysKt.j(this.f1270a, iArr2, i6, 0, this.f1271b);
        this.f1270a = iArr2;
        this.f1271b = 0;
        this.f1272c = length;
        this.f1273d = i7 - 1;
    }

    public final void a(int i5) {
        int[] iArr = this.f1270a;
        int i6 = this.f1272c;
        iArr[i6] = i5;
        int i7 = this.f1273d & (i6 + 1);
        this.f1272c = i7;
        if (i7 == this.f1271b) {
            c();
        }
    }

    public final void b() {
        this.f1272c = this.f1271b;
    }

    public final boolean d() {
        return this.f1271b == this.f1272c;
    }

    public final int e() {
        int i5 = this.f1271b;
        if (i5 == this.f1272c) {
            g gVar = g.f1275a;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i6 = this.f1270a[i5];
        this.f1271b = (i5 + 1) & this.f1273d;
        return i6;
    }
}
