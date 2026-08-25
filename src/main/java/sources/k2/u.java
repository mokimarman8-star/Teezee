package k2;

import androidx.media3.common.ParserException;
import java.io.EOFException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class u {
    public static void a(boolean z5, String str) {
        if (!z5) {
            throw ParserException.createForMalformedContainer(str, null);
        }
    }

    public static boolean b(s sVar, byte[] bArr, int i5, int i6, boolean z5) {
        try {
            return sVar.peekFully(bArr, i5, i6, z5);
        } catch (EOFException e5) {
            if (z5) {
                return false;
            }
            throw e5;
        }
    }

    public static int c(s sVar, byte[] bArr, int i5, int i6) {
        int i7 = 0;
        while (i7 < i6) {
            int b5 = sVar.b(bArr, i5 + i7, i6 - i7);
            if (b5 == -1) {
                break;
            }
            i7 += b5;
        }
        return i7;
    }

    public static boolean d(s sVar, byte[] bArr, int i5, int i6) {
        try {
            sVar.readFully(bArr, i5, i6);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean e(s sVar, int i5) {
        try {
            sVar.skipFully(i5);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
