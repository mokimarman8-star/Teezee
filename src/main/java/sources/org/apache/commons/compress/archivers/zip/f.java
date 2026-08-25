package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;
import org.apache.tools.zip.UnixStat;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class f implements t {
    public static final ZipShort d = new ZipShort(41246);
    private short a;
    private boolean b;
    private int c = 0;

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return d;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        if (i2 >= 2) {
            int value = ZipShort.getValue(bArr, i);
            this.a = (short) (value & 32767);
            this.b = (value & UnixStat.FILE_FLAG) != 0;
        } else {
            throw new ZipException("Too short content for ResourceAlignmentExtraField (0xa11e): " + i2);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        parseFromCentralDirectoryData(bArr, i, i2);
        this.c = i2 - 2;
    }
}
