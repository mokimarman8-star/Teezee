package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class o extends PKWareExtraHeader {
    private int d;
    private PKWareExtraHeader.EncryptionAlgorithm e;
    private int f;
    private int g;
    private long h;
    private PKWareExtraHeader.HashAlgorithm i;
    private int j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    public o() {
        super(new ZipShort(23));
    }

    private void d(String str, int i, int i2, int i3) {
        if (i2 + i <= i3) {
            return;
        }
        throw new ZipException("Invalid X0017_StrongEncryptionHeader: " + str + " " + i + " doesn't fit into " + i3 + " bytes of data at position " + i2);
    }

    public void e(byte[] bArr, int i, int i2) {
        a(12, i2);
        this.d = ZipShort.getValue(bArr, i);
        this.e = PKWareExtraHeader.EncryptionAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i + 2));
        this.f = ZipShort.getValue(bArr, i + 4);
        this.g = ZipShort.getValue(bArr, i + 6);
        long value = ZipLong.getValue(bArr, i + 8);
        this.h = value;
        if (value > 0) {
            a(16, i2);
            this.i = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i + 12));
            this.j = ZipShort.getValue(bArr, i + 14);
            for (long j = 0; j < this.h; j++) {
                for (int i3 = 0; i3 < this.j; i3++) {
                }
            }
        }
    }

    public void f(byte[] bArr, int i, int i2) {
        a(4, i2);
        int value = ZipShort.getValue(bArr, i);
        d("ivSize", value, 4, i2);
        this.k = Arrays.copyOfRange(bArr, i + 4, value);
        int i3 = value + 16;
        a(i3, i2);
        int i4 = i + value;
        this.d = ZipShort.getValue(bArr, i4 + 6);
        this.e = PKWareExtraHeader.EncryptionAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i4 + 8));
        this.f = ZipShort.getValue(bArr, i4 + 10);
        this.g = ZipShort.getValue(bArr, i4 + 12);
        int value2 = ZipShort.getValue(bArr, i4 + 14);
        d("erdSize", value2, i3, i2);
        int i5 = i4 + 16;
        this.l = Arrays.copyOfRange(bArr, i5, value2);
        int i6 = value + 20 + value2;
        a(i6, i2);
        long value3 = ZipLong.getValue(bArr, i5 + value2);
        this.h = value3;
        if (value3 == 0) {
            a(i6 + 2, i2);
            int value4 = ZipShort.getValue(bArr, i4 + 20 + value2);
            d("vSize", value4, value + 22 + value2, i2);
            if (value4 >= 4) {
                int i7 = i4 + 22 + value2;
                this.o = Arrays.copyOfRange(bArr, i7, value4 - 4);
                this.p = Arrays.copyOfRange(bArr, (i7 + value4) - 4, 4);
                return;
            } else {
                throw new ZipException("Invalid X0017_StrongEncryptionHeader: vSize " + value4 + " is too small to hold CRC");
            }
        }
        a(i6 + 6, i2);
        this.i = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i4 + 20 + value2));
        int i8 = i4 + 22 + value2;
        this.j = ZipShort.getValue(bArr, i8);
        int i9 = i4 + 24 + value2;
        int value5 = ZipShort.getValue(bArr, i9);
        int i10 = this.j;
        this.m = new byte[i10];
        if (value5 < i10) {
            throw new ZipException("Invalid X0017_StrongEncryptionHeader: resize " + value5 + " is too small to hold hashSize" + this.j);
        }
        this.n = new byte[value5 - i10];
        d("resize", value5, value + 24 + value2, i2);
        System.arraycopy(bArr, i9, this.m, 0, this.j);
        int i11 = this.j;
        System.arraycopy(bArr, i9 + i11, this.n, 0, value5 - i11);
        a(value + 26 + value2 + value5 + 2, i2);
        int value6 = ZipShort.getValue(bArr, i4 + 26 + value2 + value5);
        if (value6 < 4) {
            throw new ZipException("Invalid X0017_StrongEncryptionHeader: vSize " + value6 + " is too small to hold CRC");
        }
        d("vSize", value6, value + 22 + value2 + value5, i2);
        int i12 = value6 - 4;
        byte[] bArr2 = new byte[i12];
        this.o = bArr2;
        this.p = new byte[4];
        int i13 = i8 + value5;
        System.arraycopy(bArr, i13, bArr2, 0, i12);
        System.arraycopy(bArr, (i13 + value6) - 4, this.p, 0, 4);
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        super.parseFromCentralDirectoryData(bArr, i, i2);
        e(bArr, i, i2);
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        super.parseFromLocalFileData(bArr, i, i2);
        f(bArr, i, i2);
    }
}
