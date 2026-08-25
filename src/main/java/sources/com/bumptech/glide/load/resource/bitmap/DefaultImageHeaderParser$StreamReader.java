package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class DefaultImageHeaderParser$StreamReader implements DefaultImageHeaderParser.Reader {
    private final InputStream is;

    DefaultImageHeaderParser$StreamReader(InputStream inputStream) {
        this.is = inputStream;
    }

    public int getUInt16() throws IOException {
        return (getUInt8() << 8) | getUInt8();
    }

    public short getUInt8() throws IOException {
        int read = this.is.read();
        if (read != -1) {
            return (short) read;
        }
        throw new DefaultImageHeaderParser.Reader.EndOfFileException();
    }

    public int read(byte[] bArr, int i) throws IOException {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i && (i3 = this.is.read(bArr, i2, i - i2)) != -1) {
            i2 += i3;
        }
        if (i2 == 0 && i3 == -1) {
            throw new DefaultImageHeaderParser.Reader.EndOfFileException();
        }
        return i2;
    }

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
