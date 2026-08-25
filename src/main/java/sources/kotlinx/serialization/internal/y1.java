package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class y1 extends p1 {
    private short[] a;
    private int b;

    public y1(short[] bufferWithData) {
        Intrinsics.h(bufferWithData, "bufferWithData");
        this.a = bufferWithData;
        this.b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i) {
        short[] sArr = this.a;
        if (sArr.length < i) {
            short[] copyOf = Arrays.copyOf(sArr, RangesKt.e(i, sArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.b;
    }

    public final void e(short s) {
        p1.c(this, 0, 1, null);
        short[] sArr = this.a;
        int d = d();
        this.b = d + 1;
        sArr[d] = s;
    }

    @Override // kotlinx.serialization.internal.p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public short[] a() {
        short[] copyOf = Arrays.copyOf(this.a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
