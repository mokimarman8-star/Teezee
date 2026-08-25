package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g extends p1 {
    private boolean[] a;
    private int b;

    public g(boolean[] bufferWithData) {
        Intrinsics.h(bufferWithData, "bufferWithData");
        this.a = bufferWithData;
        this.b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i) {
        boolean[] zArr = this.a;
        if (zArr.length < i) {
            boolean[] copyOf = Arrays.copyOf(zArr, RangesKt.e(i, zArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.b;
    }

    public final void e(boolean z) {
        p1.c(this, 0, 1, null);
        boolean[] zArr = this.a;
        int d = d();
        this.b = d + 1;
        zArr[d] = z;
    }

    @Override // kotlinx.serialization.internal.p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean[] a() {
        boolean[] copyOf = Arrays.copyOf(this.a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
