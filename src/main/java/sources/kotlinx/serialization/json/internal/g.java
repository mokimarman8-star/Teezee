package kotlinx.serialization.json.internal;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract /* synthetic */ class g {
    public static /* synthetic */ String a(long j, int i) {
        if (j == 0) {
            return "0";
        }
        if (j > 0) {
            return Long.toString(j, i);
        }
        if (i < 2 || i > 36) {
            i = 10;
        }
        int i2 = 64;
        char[] cArr = new char[64];
        int i3 = i - 1;
        if ((i & i3) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i2--;
                cArr[i2] = Character.forDigit(((int) j) & i3, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            long a = (i & 1) == 0 ? (j >>> 1) / (i >>> 1) : kotlin.text.x.a(j, i);
            long j2 = i;
            cArr[63] = Character.forDigit((int) (j - (a * j2)), i);
            i2 = 63;
            while (a > 0) {
                i2--;
                cArr[i2] = Character.forDigit((int) (a % j2), i);
                a /= j2;
            }
        }
        return new String(cArr, i2, 64 - i2);
    }
}
