package ez;

import java.io.InputStream;
import okio.internal.Buffer;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class c {
    private static final byte[] a = new byte[Buffer.SEGMENTING_THRESHOLD];

    public static int a(InputStream inputStream, byte[] bArr) {
        return b(inputStream, bArr, 0, bArr.length);
    }

    public static int b(InputStream inputStream, byte[] bArr, int i, int i2) {
        if (i2 < 0 || i < 0 || i2 + i > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = 0;
        while (i3 != i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        return i3;
    }

    public static long c(InputStream inputStream, long j) {
        int b;
        long j2 = j;
        while (j2 > 0) {
            long skip = inputStream.skip(j2);
            if (skip == 0) {
                break;
            }
            j2 -= skip;
        }
        while (j2 > 0 && (b = b(inputStream, a, 0, (int) Math.min(j2, 4096L))) >= 1) {
            j2 -= b;
        }
        return j - j2;
    }
}
