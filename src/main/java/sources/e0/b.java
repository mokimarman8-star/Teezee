package e0;

import androidx.compose.ui.input.pointer.v;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private int f14960a;

    /* renamed from: b, reason: collision with root package name */
    private long[] f14961b = new long[2];

    public final boolean a(long j5) {
        if (d(j5)) {
            return false;
        }
        k(this.f14960a, j5);
        return true;
    }

    public final boolean b(long j5) {
        return a(j5);
    }

    public final void c() {
        this.f14960a = 0;
    }

    public final boolean d(long j5) {
        int i5 = this.f14960a;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.f14961b[i6] == j5) {
                return true;
            }
        }
        return false;
    }

    public final long e(int i5) {
        return v.b(this.f14961b[i5]);
    }

    public final int f() {
        return this.f14960a;
    }

    public final boolean g() {
        return this.f14960a == 0;
    }

    public final boolean h(long j5) {
        int i5 = this.f14960a;
        for (int i6 = 0; i6 < i5; i6++) {
            if (j5 == e(i6)) {
                j(i6);
                return true;
            }
        }
        return false;
    }

    public final boolean i(long j5) {
        return h(j5);
    }

    public final boolean j(int i5) {
        int i6 = this.f14960a;
        if (i5 >= i6) {
            return false;
        }
        int i7 = i6 - 1;
        while (i5 < i7) {
            long[] jArr = this.f14961b;
            int i8 = i5 + 1;
            jArr[i5] = jArr[i8];
            i5 = i8;
        }
        this.f14960a--;
        return true;
    }

    public final void k(int i5, long j5) {
        long[] jArr = this.f14961b;
        if (i5 >= jArr.length) {
            long[] copyOf = Arrays.copyOf(jArr, Math.max(i5 + 1, jArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f14961b = copyOf;
        }
        this.f14961b[i5] = j5;
        if (i5 >= this.f14960a) {
            this.f14960a = i5 + 1;
        }
    }
}
