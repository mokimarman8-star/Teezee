package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i implements t {
    private static final ZipShort c = new ZipShort(44225);
    private byte[] a;
    private byte[] b;

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return c;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        this.b = Arrays.copyOfRange(bArr, i, i + i2);
        if (this.a == null) {
            parseFromLocalFileData(bArr, i, i2);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        this.a = Arrays.copyOfRange(bArr, i, i2 + i);
    }
}
