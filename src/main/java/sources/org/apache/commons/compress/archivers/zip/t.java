package org.apache.commons.compress.archivers.zip;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface t {
    ZipShort getHeaderId();

    void parseFromCentralDirectoryData(byte[] bArr, int i, int i2);

    void parseFromLocalFileData(byte[] bArr, int i, int i2);
}
