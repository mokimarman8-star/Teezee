package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    private int[] f2801a = new int[10];

    /* renamed from: b, reason: collision with root package name */
    private int f2802b;

    public final void a() {
        this.f2802b = 0;
    }

    public final int b() {
        return this.f2802b;
    }

    public final int c(int i5) {
        int i6 = this.f2802b;
        for (int i7 = 0; i7 < i6; i7++) {
            if (this.f2801a[i7] == i5) {
                return i7;
            }
        }
        return -1;
    }

    public final boolean d() {
        return this.f2802b == 0;
    }

    public final int e() {
        return this.f2801a[this.f2802b - 1];
    }

    public final int f(int i5) {
        return this.f2801a[i5];
    }

    public final int g() {
        return this.f2801a[this.f2802b - 2];
    }

    public final int h(int i5) {
        return this.f2802b > 0 ? e() : i5;
    }

    public final int i() {
        int[] iArr = this.f2801a;
        int i5 = this.f2802b - 1;
        this.f2802b = i5;
        return iArr[i5];
    }

    public final void j(int i5) {
        int i6 = this.f2802b;
        int[] iArr = this.f2801a;
        if (i6 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f2801a = copyOf;
        }
        int[] iArr2 = this.f2801a;
        int i7 = this.f2802b;
        this.f2802b = i7 + 1;
        iArr2[i7] = i5;
    }
}
