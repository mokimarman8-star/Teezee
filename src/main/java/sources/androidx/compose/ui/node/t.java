package androidx.compose.ui.node;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class t {

    /* renamed from: a, reason: collision with root package name */
    private int[] f4445a;

    /* renamed from: b, reason: collision with root package name */
    private int f4446b;

    public t(int i5) {
        this.f4445a = new int[i5];
    }

    private final boolean a(int i5, int i6) {
        int[] iArr = this.f4445a;
        int i7 = iArr[i5];
        int i8 = iArr[i6];
        if (i7 >= i8) {
            return i7 == i8 && iArr[i5 + 1] <= iArr[i6 + 1];
        }
        return true;
    }

    private final int e(int i5, int i6, int i7) {
        int i8 = i5 - i7;
        while (i5 < i6) {
            if (a(i5, i6)) {
                i8 += i7;
                k(i8, i5);
            }
            i5 += i7;
        }
        int i9 = i8 + i7;
        k(i9, i6);
        return i9;
    }

    private final void i(int i5, int i6, int i7) {
        if (i5 < i6) {
            int e5 = e(i5, i6, i7);
            i(i5, e5 - i7, i7);
            i(e5 + i7, i6, i7);
        }
    }

    private final void k(int i5, int i6) {
        int[] iArr = this.f4445a;
        o0.i(iArr, i5, i6);
        o0.i(iArr, i5 + 1, i6 + 1);
        o0.i(iArr, i5 + 2, i6 + 2);
    }

    public final int b(int i5) {
        return this.f4445a[i5];
    }

    public final int c() {
        return this.f4446b;
    }

    public final boolean d() {
        return this.f4446b != 0;
    }

    public final int f() {
        int[] iArr = this.f4445a;
        int i5 = this.f4446b - 1;
        this.f4446b = i5;
        return iArr[i5];
    }

    public final void g(int i5, int i6, int i7) {
        int i8 = this.f4446b;
        int i9 = i8 + 3;
        int[] iArr = this.f4445a;
        if (i9 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f4445a = copyOf;
        }
        int[] iArr2 = this.f4445a;
        iArr2[i8] = i5 + i7;
        iArr2[i8 + 1] = i6 + i7;
        iArr2[i8 + 2] = i7;
        this.f4446b = i9;
    }

    public final void h(int i5, int i6, int i7, int i8) {
        int i9 = this.f4446b;
        int i10 = i9 + 4;
        int[] iArr = this.f4445a;
        if (i10 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f4445a = copyOf;
        }
        int[] iArr2 = this.f4445a;
        iArr2[i9] = i5;
        iArr2[i9 + 1] = i6;
        iArr2[i9 + 2] = i7;
        iArr2[i9 + 3] = i8;
        this.f4446b = i10;
    }

    public final void j() {
        int i5 = this.f4446b;
        if (!(i5 % 3 == 0)) {
            g0.a.b("Array size not a multiple of 3");
        }
        if (i5 > 3) {
            i(0, i5 - 3, 3);
        }
    }
}
