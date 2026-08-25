package sd;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class m extends q {
    private static final int[] b = {1, 1, 1, 1};
    private static final int[] c = {3, 1, 1};
    private static final int[][] d = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // sd.q
    public boolean[] d(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        q.c(str);
        boolean[] zArr = new boolean[(length * 9) + 9];
        int b2 = q.b(zArr, 0, b, true);
        for (int i = 0; i < length; i += 2) {
            int digit = Character.digit(str.charAt(i), 10);
            int digit2 = Character.digit(str.charAt(i + 1), 10);
            int[] iArr = new int[10];
            for (int i2 = 0; i2 < 5; i2++) {
                int i3 = i2 * 2;
                int[][] iArr2 = d;
                iArr[i3] = iArr2[digit][i2];
                iArr[i3 + 1] = iArr2[digit2][i2];
            }
            b2 += q.b(zArr, b2, iArr, true);
        }
        q.b(zArr, b2, c, true);
        return zArr;
    }

    @Override // sd.q
    protected Collection g() {
        return Collections.singleton(BarcodeFormat.ITF);
    }
}
