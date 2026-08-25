package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c extends e {
    public static c i(ByteBuffer byteBuffer) {
        return j(byteBuffer, new c());
    }

    public static c j(ByteBuffer byteBuffer, c cVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return cVar.g(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public c g(int i5, ByteBuffer byteBuffer) {
        h(i5, byteBuffer);
        return this;
    }

    public void h(int i5, ByteBuffer byteBuffer) {
        c(i5, byteBuffer);
    }

    public b k(b bVar, int i5) {
        int b5 = b(6);
        if (b5 != 0) {
            return bVar.g(a(d(b5) + (i5 * 4)), this.f7894b);
        }
        return null;
    }

    public int l() {
        int b5 = b(6);
        if (b5 != 0) {
            return e(b5);
        }
        return 0;
    }

    public int m() {
        int b5 = b(4);
        if (b5 != 0) {
            return this.f7894b.getInt(b5 + this.f7893a);
        }
        return 0;
    }
}
