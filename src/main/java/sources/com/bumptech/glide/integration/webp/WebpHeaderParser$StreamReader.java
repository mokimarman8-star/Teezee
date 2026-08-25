package com.bumptech.glide.integration.webp;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class WebpHeaderParser$StreamReader implements WebpHeaderParser$Reader {
    private final InputStream is;

    WebpHeaderParser$StreamReader(InputStream inputStream) {
        this.is = inputStream;
    }

    @Override // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
    public int getByte() throws IOException {
        return this.is.read();
    }

    @Override // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
    public int getUInt16() throws IOException {
        return ((this.is.read() << 8) & 65280) | (this.is.read() & 255);
    }

    @Override // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
    public short getUInt8() throws IOException {
        return (short) (this.is.read() & 255);
    }

    @Override // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
    public int read(byte[] bArr, int i) throws IOException {
        int i2 = i;
        while (i2 > 0) {
            int read = this.is.read(bArr, i - i2, i2);
            if (read == -1) {
                break;
            }
            i2 -= read;
        }
        return i - i2;
    }

    @Override // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
    public long skip(long j) throws IOException {
        if (j < 0) {
            return 0L;
        }
        long j2 = j;
        while (j2 > 0) {
            long skip = this.is.skip(j2);
            if (skip <= 0) {
                if (this.is.read() == -1) {
                    break;
                }
                skip = 1;
            }
            j2 -= skip;
        }
        return j - j2;
    }
}
