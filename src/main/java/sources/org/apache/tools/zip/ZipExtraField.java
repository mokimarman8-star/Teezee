package org.apache.tools.zip;

import java.util.zip.ZipException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface ZipExtraField {
    byte[] getCentralDirectoryData();

    ZipShort getCentralDirectoryLength();

    ZipShort getHeaderId();

    byte[] getLocalFileDataData();

    ZipShort getLocalFileDataLength();

    void parseFromLocalFileData(byte[] bArr, int i, int i2) throws ZipException;
}
