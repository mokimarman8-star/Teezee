package ig;

import java.io.EOFException;
import kotlin.ranges.RangesKt;
import okio.Buffer;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, RangesKt.i(buffer.size(), 64L));
            for (int i = 0; i < 16; i++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
