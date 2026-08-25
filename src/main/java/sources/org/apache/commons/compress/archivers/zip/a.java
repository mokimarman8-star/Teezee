package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a implements t {
    private long a;
    private byte[] b;
    private byte[] c;

    protected a() {
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        parseFromLocalFileData(bArr, i, i2);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        if (i2 < 5) {
            throw new ZipException("UniCode path extra data must have at least 5 bytes.");
        }
        byte b = bArr[i];
        if (b != 1) {
            throw new ZipException("Unsupported version [" + ((int) b) + "] for UniCode path extra data.");
        }
        this.a = ZipLong.getValue(bArr, i + 1);
        int i3 = i2 - 5;
        byte[] bArr2 = new byte[i3];
        this.b = bArr2;
        System.arraycopy(bArr, i + 5, bArr2, 0, i3);
        this.c = null;
    }
}
