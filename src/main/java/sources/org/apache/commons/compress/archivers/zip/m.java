package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class m extends PKWareExtraHeader {
    private int d;
    private PKWareExtraHeader.HashAlgorithm e;

    public m() {
        super(new ZipShort(21));
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        a(4, i2);
        super.parseFromCentralDirectoryData(bArr, i, i2);
        this.d = ZipShort.getValue(bArr, i);
        this.e = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i + 2));
    }
}
