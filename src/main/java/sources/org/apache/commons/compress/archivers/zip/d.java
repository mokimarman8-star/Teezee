package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d implements t {
    private static final ZipShort a = new ZipShort(51966);
    private static final ZipShort b = new ZipShort(0);
    private static final byte[] c = new byte[0];
    private static final d d = new d();

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return a;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        parseFromLocalFileData(bArr, i, i2);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            throw new ZipException("JarMarker doesn't expect any data");
        }
    }
}
