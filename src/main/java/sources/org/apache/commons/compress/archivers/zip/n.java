package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class n extends PKWareExtraHeader {
    private int d;
    private PKWareExtraHeader.HashAlgorithm e;

    public n() {
        super(new ZipShort(22));
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        a(4, i2);
        this.d = ZipShort.getValue(bArr, i);
        this.e = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i + 2));
    }
}
