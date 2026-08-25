package androidx.compose.runtime.snapshots;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class m {
    public static final int a(int[] iArr, int i5) {
        int length = iArr.length - 1;
        int i6 = 0;
        while (i6 <= length) {
            int i7 = (i6 + length) >>> 1;
            int i8 = iArr[i7];
            if (i5 > i8) {
                i6 = i7 + 1;
            } else {
                if (i5 >= i8) {
                    return i7;
                }
                length = i7 - 1;
            }
        }
        return -(i6 + 1);
    }
}
