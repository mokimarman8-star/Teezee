package com.bumptech.glide.integration.webp;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class WebpHeaderParser$ByteBufferReader implements WebpHeaderParser$Reader {
    private final ByteBuffer byteBuffer;

    WebpHeaderParser$ByteBufferReader(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    @Override // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
    public int getByte() throws IOException {
        if (this.byteBuffer.remaining() < 1) {
            return -1;
        }
        return this.byteBuffer.get();
    }

    @Override // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
    public int getUInt16() throws IOException {
        return ((getByte() << 8) & 65280) | (getByte() & 255);
    }

    @Override // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
    public short getUInt8() throws IOException {
        return (short) (getByte() & 255);
    }

    @Override // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
    public int read(byte[] bArr, int i) throws IOException {
        int min = Math.min(i, this.byteBuffer.remaining());
        if (min == 0) {
            return -1;
        }
        this.byteBuffer.get(bArr, 0, min);
        return min;
    }

    @Override // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
    public long skip(long j) throws IOException {
        int min = (int) Math.min(this.byteBuffer.remaining(), j);
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.position(byteBuffer.position() + min);
        return min;
    }
}
