package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b extends e {
    public b g(int i5, ByteBuffer byteBuffer) {
        h(i5, byteBuffer);
        return this;
    }

    public void h(int i5, ByteBuffer byteBuffer) {
        c(i5, byteBuffer);
    }

    public int i(int i5) {
        int b5 = b(16);
        if (b5 != 0) {
            return this.f7894b.getInt(d(b5) + (i5 * 4));
        }
        return 0;
    }

    public int j() {
        int b5 = b(16);
        if (b5 != 0) {
            return e(b5);
        }
        return 0;
    }

    public boolean k() {
        int b5 = b(6);
        return (b5 == 0 || this.f7894b.get(b5 + this.f7893a) == 0) ? false : true;
    }

    public short l() {
        int b5 = b(14);
        if (b5 != 0) {
            return this.f7894b.getShort(b5 + this.f7893a);
        }
        return (short) 0;
    }

    public int m() {
        int b5 = b(4);
        if (b5 != 0) {
            return this.f7894b.getInt(b5 + this.f7893a);
        }
        return 0;
    }

    public short n() {
        int b5 = b(8);
        if (b5 != 0) {
            return this.f7894b.getShort(b5 + this.f7893a);
        }
        return (short) 0;
    }

    public short o() {
        int b5 = b(12);
        if (b5 != 0) {
            return this.f7894b.getShort(b5 + this.f7893a);
        }
        return (short) 0;
    }
}
