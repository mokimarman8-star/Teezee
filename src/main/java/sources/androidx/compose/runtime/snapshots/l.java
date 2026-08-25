package androidx.compose.runtime.snapshots;

import kotlin.collections.ArraysKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private int f3009a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f3010b = new int[16];

    /* renamed from: c, reason: collision with root package name */
    private int[] f3011c = new int[16];

    /* renamed from: d, reason: collision with root package name */
    private int[] f3012d;

    /* renamed from: e, reason: collision with root package name */
    private int f3013e;

    public l() {
        int[] iArr = new int[16];
        int i5 = 0;
        while (i5 < 16) {
            int i6 = i5 + 1;
            iArr[i5] = i6;
            i5 = i6;
        }
        this.f3012d = iArr;
    }

    private final int b() {
        int length = this.f3012d.length;
        if (this.f3013e >= length) {
            int i5 = length * 2;
            int[] iArr = new int[i5];
            int i6 = 0;
            while (i6 < i5) {
                int i7 = i6 + 1;
                iArr[i6] = i7;
                i6 = i7;
            }
            ArraysKt.o(this.f3012d, iArr, 0, 0, 0, 14, (Object) null);
            this.f3012d = iArr;
        }
        int i8 = this.f3013e;
        this.f3013e = this.f3012d[i8];
        return i8;
    }

    private final void c(int i5) {
        int[] iArr = this.f3010b;
        int length = iArr.length;
        if (i5 <= length) {
            return;
        }
        int i6 = length * 2;
        int[] iArr2 = new int[i6];
        int[] iArr3 = new int[i6];
        ArraysKt.o(iArr, iArr2, 0, 0, 0, 14, (Object) null);
        ArraysKt.o(this.f3011c, iArr3, 0, 0, 0, 14, (Object) null);
        this.f3010b = iArr2;
        this.f3011c = iArr3;
    }

    private final void d(int i5) {
        this.f3012d[i5] = this.f3013e;
        this.f3013e = i5;
    }

    private final void g(int i5) {
        int i6;
        int[] iArr = this.f3010b;
        int i7 = this.f3009a >> 1;
        while (i5 < i7) {
            int i8 = (i5 + 1) << 1;
            int i9 = i8 - 1;
            if (i8 >= this.f3009a || (i6 = iArr[i8]) >= iArr[i9]) {
                if (iArr[i9] >= iArr[i5]) {
                    return;
                }
                i(i9, i5);
                i5 = i9;
            } else {
                if (i6 >= iArr[i5]) {
                    return;
                }
                i(i8, i5);
                i5 = i8;
            }
        }
    }

    private final void h(int i5) {
        int[] iArr = this.f3010b;
        int i6 = iArr[i5];
        while (i5 > 0) {
            int i7 = ((i5 + 1) >> 1) - 1;
            if (iArr[i7] <= i6) {
                return;
            }
            i(i7, i5);
            i5 = i7;
        }
    }

    private final void i(int i5, int i6) {
        int[] iArr = this.f3010b;
        int[] iArr2 = this.f3011c;
        int[] iArr3 = this.f3012d;
        int i7 = iArr[i5];
        iArr[i5] = iArr[i6];
        iArr[i6] = i7;
        int i8 = iArr2[i5];
        iArr2[i5] = iArr2[i6];
        iArr2[i6] = i8;
        iArr3[iArr2[i5]] = i5;
        iArr3[iArr2[i6]] = i6;
    }

    public final int a(int i5) {
        c(this.f3009a + 1);
        int i6 = this.f3009a;
        this.f3009a = i6 + 1;
        int b5 = b();
        this.f3010b[i6] = i5;
        this.f3011c[i6] = b5;
        this.f3012d[b5] = i6;
        h(i6);
        return b5;
    }

    public final int e(int i5) {
        return this.f3009a > 0 ? this.f3010b[0] : i5;
    }

    public final void f(int i5) {
        int i6 = this.f3012d[i5];
        i(i6, this.f3009a - 1);
        this.f3009a--;
        h(i6);
        g(i6);
        d(i5);
    }
}
