package androidx.compose.ui.node;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class c {
    public static int[] a(int[] iArr) {
        return iArr;
    }

    public static final int b(int[] iArr, int i5) {
        return iArr[i5 + c(iArr)];
    }

    private static final int c(int[] iArr) {
        return iArr.length / 2;
    }

    public static final void d(int[] iArr, int i5, int i6) {
        iArr[i5 + c(iArr)] = i6;
    }
}
