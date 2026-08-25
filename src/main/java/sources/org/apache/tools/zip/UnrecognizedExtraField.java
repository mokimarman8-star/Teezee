package org.apache.tools.zip;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class UnrecognizedExtraField implements ZipExtraField {
    private byte[] centralData;
    private ZipShort headerId;
    private byte[] localData;

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.centralData;
        return bArr != null ? bArr : getLocalFileDataData();
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        byte[] bArr = this.centralData;
        return bArr != null ? new ZipShort(bArr.length) : getLocalFileDataLength();
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return this.headerId;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return this.localData;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.localData.length);
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        setLocalFileDataData(bArr2);
    }

    public void setCentralDirectoryData(byte[] bArr) {
        this.centralData = bArr;
    }

    public void setHeaderId(ZipShort zipShort) {
        this.headerId = zipShort;
    }

    public void setLocalFileDataData(byte[] bArr) {
        this.localData = bArr;
    }
}
