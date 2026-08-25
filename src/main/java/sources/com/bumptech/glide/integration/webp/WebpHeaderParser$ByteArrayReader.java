package com.bumptech.glide.integration.webp;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class WebpHeaderParser$ByteArrayReader implements WebpHeaderParser$Reader {
    private final byte[] data;
    private final int offset;
    private int pos;
    private final int size;

    WebpHeaderParser$ByteArrayReader(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.offset = i;
        this.size = i2;
        this.pos = i;
    }

    @Override // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
    public int getByte() throws IOException {
        int i = this.pos;
        if (i >= this.offset + this.size) {
            return -1;
        }
        byte[] bArr = this.data;
        this.pos = i + 1;
        return bArr[i];
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
        int min = Math.min((this.offset + this.size) - this.pos, i);
        if (min == 0) {
            return -1;
        }
        System.arraycopy(this.data, this.pos, bArr, 0, min);
        return min;
    }

    @Override // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
    public long skip(long j) throws IOException {
        int min = (int) Math.min((this.offset + this.size) - this.pos, j);
        this.pos += min;
        return min;
    }
}
