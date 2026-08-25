package k2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class k0 {
    public static List a(byte[] bArr) {
        long k5 = k(f(bArr));
        long k6 = k(3840L);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(b(k5));
        arrayList.add(b(k6));
        return arrayList;
    }

    private static byte[] b(long j5) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j5).array();
    }

    public static int c(byte[] bArr) {
        return bArr[9] & 255;
    }

    private static long d(byte b5, byte b6) {
        int i5;
        int i6 = b5 & 255;
        int i7 = b5 & 3;
        if (i7 != 0) {
            i5 = 2;
            if (i7 != 1 && i7 != 2) {
                i5 = b6 & 63;
            }
        } else {
            i5 = 1;
        }
        int i8 = i6 >> 3;
        return i5 * (i8 >= 16 ? 2500 << r6 : i8 >= 12 ? 10000 << (i8 & 1) : (i8 & 3) == 3 ? 60000 : 10000 << r6);
    }

    public static long e(byte[] bArr) {
        return d(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0);
    }

    public static int f(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static boolean g(long j5, long j6) {
        return j5 - j6 <= k(3840L) / 1000;
    }

    public static int h(ByteBuffer byteBuffer) {
        int i5 = i(byteBuffer);
        int i6 = byteBuffer.get(i5 + 26) + 27 + i5;
        return (int) ((d(byteBuffer.get(i6), byteBuffer.limit() - i6 > 1 ? byteBuffer.get(i6 + 1) : (byte) 0) * 48000) / 1000000);
    }

    public static int i(ByteBuffer byteBuffer) {
        if ((byteBuffer.get(5) & 2) == 0) {
            return 0;
        }
        byte b5 = byteBuffer.get(26);
        int i5 = 28;
        int i6 = 28;
        for (int i7 = 0; i7 < b5; i7++) {
            i6 += byteBuffer.get(i7 + 27);
        }
        byte b6 = byteBuffer.get(i6 + 26);
        for (int i8 = 0; i8 < b6; i8++) {
            i5 += byteBuffer.get(i6 + 27 + i8);
        }
        return i6 + i5;
    }

    public static int j(ByteBuffer byteBuffer) {
        return (int) ((d(byteBuffer.get(0), byteBuffer.limit() > 1 ? byteBuffer.get(1) : (byte) 0) * 48000) / 1000000);
    }

    private static long k(long j5) {
        return (j5 * 1000000000) / 48000;
    }
}
