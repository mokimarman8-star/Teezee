package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class j implements t {
    private ZipShort a;
    private byte[] b;
    private byte[] c;

    public void a(byte[] bArr) {
        this.c = u.c(bArr);
    }

    public void b(ZipShort zipShort) {
        this.a = zipShort;
    }

    public void c(byte[] bArr) {
        this.b = u.c(bArr);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return this.a;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2 + i);
        a(copyOfRange);
        if (this.b == null) {
            c(copyOfRange);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        c(Arrays.copyOfRange(bArr, i, i2 + i));
    }
}
