package kotlin.io;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class a extends ByteArrayOutputStream {
    public a(int i) {
        super(i);
    }

    public final byte[] d() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        Intrinsics.g(buf, "buf");
        return buf;
    }
}
