package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f0 extends p1 {
    private float[] a;
    private int b;

    public f0(float[] bufferWithData) {
        Intrinsics.h(bufferWithData, "bufferWithData");
        this.a = bufferWithData;
        this.b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i) {
        float[] fArr = this.a;
        if (fArr.length < i) {
            float[] copyOf = Arrays.copyOf(fArr, RangesKt.e(i, fArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.b;
    }

    public final void e(float f) {
        p1.c(this, 0, 1, null);
        float[] fArr = this.a;
        int d = d();
        this.b = d + 1;
        fArr[d] = f;
    }

    @Override // kotlinx.serialization.internal.p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public float[] a() {
        float[] copyOf = Arrays.copyOf(this.a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
