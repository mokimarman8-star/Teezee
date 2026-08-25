package androidx.collection;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class d0 extends m {
    public d0() {
        this(0, 1, null);
    }

    public d0(int i5) {
        super(i5, null);
    }

    public /* synthetic */ d0(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 16 : i5);
    }

    public final boolean e(int i5) {
        g(this.f1296b + 1);
        int[] iArr = this.f1295a;
        int i6 = this.f1296b;
        iArr[i6] = i5;
        this.f1296b = i6 + 1;
        return true;
    }

    public final boolean f(int i5, int[] iArr) {
        int i6;
        Intrinsics.h(iArr, "elements");
        if (i5 < 0 || i5 > (i6 = this.f1296b)) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this.f1296b);
        }
        if (iArr.length == 0) {
            return false;
        }
        g(i6 + iArr.length);
        int[] iArr2 = this.f1295a;
        int i7 = this.f1296b;
        if (i5 != i7) {
            ArraysKt.j(iArr2, iArr2, iArr.length + i5, i5, i7);
        }
        ArraysKt.o(iArr, iArr2, i5, 0, 0, 12, (Object) null);
        this.f1296b += iArr.length;
        return true;
    }

    public final void g(int i5) {
        int[] iArr = this.f1295a;
        if (iArr.length < i5) {
            int[] copyOf = Arrays.copyOf(iArr, Math.max(i5, (iArr.length * 3) / 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f1295a = copyOf;
        }
    }

    public final void h(int[] iArr) {
        Intrinsics.h(iArr, "elements");
        f(this.f1296b, iArr);
    }

    public final int i(int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.f1296b)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i5);
            sb.append(" must be in 0..");
            sb.append(this.f1296b - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int[] iArr = this.f1295a;
        int i7 = iArr[i5];
        if (i5 != i6 - 1) {
            ArraysKt.j(iArr, iArr, i5, i5 + 1, i6);
        }
        this.f1296b--;
        return i7;
    }

    public final int j(int i5, int i6) {
        if (i5 >= 0 && i5 < this.f1296b) {
            int[] iArr = this.f1295a;
            int i7 = iArr[i5];
            iArr[i5] = i6;
            return i7;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("set index ");
        sb.append(i5);
        sb.append(" must be between 0 .. ");
        sb.append(this.f1296b - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }
}
