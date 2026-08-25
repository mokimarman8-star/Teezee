package androidx.compose.ui.node;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    private int f4415a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f4416b = new int[16];

    /* renamed from: c, reason: collision with root package name */
    private androidx.compose.runtime.collection.b[] f4417c = new androidx.compose.runtime.collection.b[16];

    public final boolean a() {
        int i5 = this.f4415a;
        return i5 > 0 && this.f4416b[i5 - 1] >= 0;
    }

    public final Object b() {
        int i5 = this.f4415a;
        if (i5 <= 0) {
            throw new IllegalStateException("Cannot call pop() on an empty stack. Guard with a call to isNotEmpty()");
        }
        int i6 = i5 - 1;
        int i7 = this.f4416b[i6];
        androidx.compose.runtime.collection.b bVar = this.f4417c[i6];
        Intrinsics.e(bVar);
        if (i7 > 0) {
            this.f4416b[i6] = r3[i6] - 1;
        } else if (i7 == 0) {
            this.f4417c[i6] = null;
            this.f4415a--;
        }
        return bVar.m()[i7];
    }

    public final void c(androidx.compose.runtime.collection.b bVar) {
        if (bVar.p()) {
            return;
        }
        int i5 = this.f4415a;
        int[] iArr = this.f4416b;
        if (i5 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f4416b = copyOf;
            androidx.compose.runtime.collection.b[] bVarArr = this.f4417c;
            Object[] copyOf2 = Arrays.copyOf(bVarArr, bVarArr.length * 2);
            Intrinsics.g(copyOf2, "copyOf(this, newSize)");
            this.f4417c = (androidx.compose.runtime.collection.b[]) copyOf2;
        }
        this.f4416b[i5] = bVar.n() - 1;
        this.f4417c[i5] = bVar;
        this.f4415a++;
    }
}
