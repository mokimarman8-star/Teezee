package androidx.collection;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class l0 extends ObjectList {
    public l0() {
        this(0, 1, null);
    }

    public l0(int i5) {
        super(i5, null);
    }

    public /* synthetic */ l0(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 16 : i5);
    }

    public final boolean e(Object obj) {
        g(this.f1242b + 1);
        Object[] objArr = this.f1241a;
        int i5 = this.f1242b;
        objArr[i5] = obj;
        this.f1242b = i5 + 1;
        return true;
    }

    public final void f() {
        ArraysKt.u(this.f1241a, (Object) null, 0, this.f1242b);
        this.f1242b = 0;
    }

    public final void g(int i5) {
        Object[] objArr = this.f1241a;
        if (objArr.length < i5) {
            Object[] copyOf = Arrays.copyOf(objArr, Math.max(i5, (objArr.length * 3) / 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f1241a = copyOf;
        }
    }
}
