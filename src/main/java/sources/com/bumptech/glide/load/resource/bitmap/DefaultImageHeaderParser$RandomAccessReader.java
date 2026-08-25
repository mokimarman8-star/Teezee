package com.bumptech.glide.load.resource.bitmap;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class DefaultImageHeaderParser$RandomAccessReader {
    private final ByteBuffer data;

    DefaultImageHeaderParser$RandomAccessReader(byte[] bArr, int i) {
        this.data = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
    }

    private boolean isAvailable(int i, int i2) {
        return this.data.remaining() - i >= i2;
    }

    short getInt16(int i) {
        if (isAvailable(i, 2)) {
            return this.data.getShort(i);
        }
        return (short) -1;
    }

    int getInt32(int i) {
        if (isAvailable(i, 4)) {
            return this.data.getInt(i);
        }
        return -1;
    }

    int length() {
        return this.data.remaining();
    }

    void order(ByteOrder byteOrder) {
        this.data.order(byteOrder);
    }
}
