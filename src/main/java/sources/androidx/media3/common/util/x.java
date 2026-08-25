package androidx.media3.common.util;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class x {
    public static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void b(MediaFormat mediaFormat, androidx.media3.common.i iVar) {
        if (iVar != null) {
            d(mediaFormat, "color-transfer", iVar.f8749c);
            d(mediaFormat, "color-standard", iVar.f8747a);
            d(mediaFormat, "color-range", iVar.f8748b);
            a(mediaFormat, "hdr-static-info", iVar.f8750d);
        }
    }

    public static void c(MediaFormat mediaFormat, String str, float f5) {
        if (f5 != -1.0f) {
            mediaFormat.setFloat(str, f5);
        }
    }

    public static void d(MediaFormat mediaFormat, String str, int i5) {
        if (i5 != -1) {
            mediaFormat.setInteger(str, i5);
        }
    }

    public static void e(MediaFormat mediaFormat, List list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            mediaFormat.setByteBuffer("csd-" + i5, ByteBuffer.wrap((byte[]) list.get(i5)));
        }
    }
}
