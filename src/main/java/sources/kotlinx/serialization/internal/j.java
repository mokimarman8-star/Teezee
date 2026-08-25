package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class j extends p1 {
    private byte[] a;
    private int b;

    public j(byte[] bufferWithData) {
        Intrinsics.h(bufferWithData, "bufferWithData");
        this.a = bufferWithData;
        this.b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i) {
        byte[] bArr = this.a;
        if (bArr.length < i) {
            byte[] copyOf = Arrays.copyOf(bArr, RangesKt.e(i, bArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.b;
    }

    public final void e(byte b) {
        p1.c(this, 0, 1, null);
        byte[] bArr = this.a;
        int d = d();
        this.b = d + 1;
        bArr[d] = b;
    }

    @Override // kotlinx.serialization.internal.p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public byte[] a() {
        byte[] copyOf = Arrays.copyOf(this.a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
