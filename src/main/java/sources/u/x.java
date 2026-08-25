package u;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class x {
    public static final int f(int i5, int i6) {
        return (i5 >> i6) & 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] g(Object[] objArr, int i5, Object obj, Object obj2) {
        Object[] objArr2 = new Object[objArr.length + 2];
        ArraysKt.p(objArr, objArr2, 0, 0, i5, 6, (Object) null);
        ArraysKt.l(objArr, objArr2, i5 + 2, i5, objArr.length);
        objArr2[i5] = obj;
        objArr2[i5 + 1] = obj2;
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] h(Object[] objArr, int i5) {
        Object[] objArr2 = new Object[objArr.length - 2];
        ArraysKt.p(objArr, objArr2, 0, 0, i5, 6, (Object) null);
        ArraysKt.l(objArr, objArr2, i5, i5 + 2, objArr.length);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] i(Object[] objArr, int i5) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt.p(objArr, objArr2, 0, 0, i5, 6, (Object) null);
        ArraysKt.l(objArr, objArr2, i5, i5 + 1, objArr.length);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] j(Object[] objArr, int i5, int i6, t tVar) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt.p(objArr, objArr2, 0, 0, i5, 6, (Object) null);
        ArraysKt.l(objArr, objArr2, i5, i5 + 2, i6);
        objArr2[i6 - 2] = tVar;
        ArraysKt.l(objArr, objArr2, i6 - 1, i6, objArr.length);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] k(Object[] objArr, int i5, int i6, Object obj, Object obj2) {
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + 1);
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        ArraysKt.l(copyOf, copyOf, i5 + 2, i5 + 1, objArr.length);
        ArraysKt.l(copyOf, copyOf, i6 + 2, i6, i5);
        copyOf[i6] = obj;
        copyOf[i6 + 1] = obj2;
        return copyOf;
    }
}
