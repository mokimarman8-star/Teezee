package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class DefaultImageHeaderParser$ByteBufferReader implements DefaultImageHeaderParser.Reader {
    private final ByteBuffer byteBuffer;

    DefaultImageHeaderParser$ByteBufferReader(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public int getUInt16() throws DefaultImageHeaderParser.Reader.EndOfFileException {
        return (getUInt8() << 8) | getUInt8();
    }

    public short getUInt8() throws DefaultImageHeaderParser.Reader.EndOfFileException {
        if (this.byteBuffer.remaining() >= 1) {
            return (short) (this.byteBuffer.get() & 255);
        }
        throw new DefaultImageHeaderParser.Reader.EndOfFileException();
    }

    public int read(byte[] bArr, int i) {
        int min = Math.min(i, this.byteBuffer.remaining());
        if (min == 0) {
            return -1;
        }
        this.byteBuffer.get(bArr, 0, min);
        return min;
    }

    public long skip(long j) {
        int min = (int) Math.min(this.byteBuffer.remaining(), j);
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.position(byteBuffer.position() + min);
        return min;
    }
}
