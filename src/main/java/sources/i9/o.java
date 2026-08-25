package i9;

import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class o {
    public static void a(boolean z, String str) {
        if (!z) {
            throw ParserException.createForMalformedContainer(str, (Throwable) null);
        }
    }

    public static boolean b(m mVar, byte[] bArr, int i, int i2, boolean z) {
        try {
            return mVar.peekFully(bArr, i, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public static int c(m mVar, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int b = mVar.b(bArr, i + i3, i2 - i3);
            if (b == -1) {
                break;
            }
            i3 += b;
        }
        return i3;
    }

    public static boolean d(m mVar, byte[] bArr, int i, int i2) {
        try {
            mVar.readFully(bArr, i, i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean e(m mVar, int i) {
        try {
            mVar.skipFully(i);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
