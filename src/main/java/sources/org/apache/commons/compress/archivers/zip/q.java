package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class q implements t {
    static final ZipShort f = new ZipShort(1);
    private static final byte[] g = new byte[0];
    private ZipEightByteInteger a;
    private ZipEightByteInteger b;
    private ZipEightByteInteger c;
    private ZipLong d;
    private byte[] e;

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return f;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.e = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        if (i2 >= 28) {
            parseFromLocalFileData(bArr, i, i2);
            return;
        }
        if (i2 == 24) {
            this.a = new ZipEightByteInteger(bArr, i);
            this.b = new ZipEightByteInteger(bArr, i + 8);
            this.c = new ZipEightByteInteger(bArr, i + 16);
        } else if (i2 % 8 == 4) {
            this.d = new ZipLong(bArr, (i + i2) - 4);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        if (i2 < 16) {
            throw new ZipException("Zip64 extended information must contain both size values in the local file header.");
        }
        this.a = new ZipEightByteInteger(bArr, i);
        this.b = new ZipEightByteInteger(bArr, i + 8);
        int i3 = i + 16;
        int i4 = i2 - 16;
        if (i4 >= 8) {
            this.c = new ZipEightByteInteger(bArr, i3);
            i3 = i + 24;
            i4 = i2 - 24;
        }
        if (i4 >= 4) {
            this.d = new ZipLong(bArr, i3);
        }
    }
}
