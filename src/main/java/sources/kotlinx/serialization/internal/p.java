package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class p extends p1 {
    private char[] a;
    private int b;

    public p(char[] bufferWithData) {
        Intrinsics.h(bufferWithData, "bufferWithData");
        this.a = bufferWithData;
        this.b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.p1
    public void b(int i) {
        char[] cArr = this.a;
        if (cArr.length < i) {
            char[] copyOf = Arrays.copyOf(cArr, RangesKt.e(i, cArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.a = copyOf;
        }
    }

    @Override // kotlinx.serialization.internal.p1
    public int d() {
        return this.b;
    }

    public final void e(char c) {
        p1.c(this, 0, 1, null);
        char[] cArr = this.a;
        int d = d();
        this.b = d + 1;
        cArr[d] = c;
    }

    @Override // kotlinx.serialization.internal.p1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public char[] a() {
        char[] copyOf = Arrays.copyOf(this.a, d());
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }
}
