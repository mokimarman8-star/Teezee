package org.apache.commons.compress.archivers.zip;

import java.util.Date;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class k implements t {
    private static final ZipShort d = new ZipShort(10);
    private static final ZipShort e = new ZipShort(1);
    private static final ZipShort f = new ZipShort(24);
    private ZipEightByteInteger a;
    private ZipEightByteInteger b;
    private ZipEightByteInteger c;

    public k() {
        ZipEightByteInteger zipEightByteInteger = ZipEightByteInteger.ZERO;
        this.a = zipEightByteInteger;
        this.b = zipEightByteInteger;
        this.c = zipEightByteInteger;
    }

    private void d(byte[] bArr, int i, int i2) {
        if (i2 >= 26) {
            if (f.equals(new ZipShort(bArr, i))) {
                this.a = new ZipEightByteInteger(bArr, i + 2);
                this.b = new ZipEightByteInteger(bArr, i + 10);
                this.c = new ZipEightByteInteger(bArr, i + 18);
            }
        }
    }

    private void e() {
        ZipEightByteInteger zipEightByteInteger = ZipEightByteInteger.ZERO;
        this.a = zipEightByteInteger;
        this.b = zipEightByteInteger;
        this.c = zipEightByteInteger;
    }

    private static Date f(ZipEightByteInteger zipEightByteInteger) {
        if (zipEightByteInteger == null || ZipEightByteInteger.ZERO.equals(zipEightByteInteger)) {
            return null;
        }
        return new Date((zipEightByteInteger.getLongValue() - 116444736000000000L) / 10000);
    }

    public Date a() {
        return f(this.b);
    }

    public Date b() {
        return f(this.c);
    }

    public Date c() {
        return f(this.a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        ZipEightByteInteger zipEightByteInteger = this.a;
        ZipEightByteInteger zipEightByteInteger2 = kVar.a;
        if (zipEightByteInteger != zipEightByteInteger2 && (zipEightByteInteger == null || !zipEightByteInteger.equals(zipEightByteInteger2))) {
            return false;
        }
        ZipEightByteInteger zipEightByteInteger3 = this.b;
        ZipEightByteInteger zipEightByteInteger4 = kVar.b;
        if (zipEightByteInteger3 != zipEightByteInteger4 && (zipEightByteInteger3 == null || !zipEightByteInteger3.equals(zipEightByteInteger4))) {
            return false;
        }
        ZipEightByteInteger zipEightByteInteger5 = this.c;
        ZipEightByteInteger zipEightByteInteger6 = kVar.c;
        return zipEightByteInteger5 == zipEightByteInteger6 || (zipEightByteInteger5 != null && zipEightByteInteger5.equals(zipEightByteInteger6));
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return d;
    }

    public int hashCode() {
        ZipEightByteInteger zipEightByteInteger = this.a;
        int hashCode = zipEightByteInteger != null ? (-123) ^ zipEightByteInteger.hashCode() : -123;
        ZipEightByteInteger zipEightByteInteger2 = this.b;
        if (zipEightByteInteger2 != null) {
            hashCode ^= Integer.rotateLeft(zipEightByteInteger2.hashCode(), 11);
        }
        ZipEightByteInteger zipEightByteInteger3 = this.c;
        return zipEightByteInteger3 != null ? hashCode ^ Integer.rotateLeft(zipEightByteInteger3.hashCode(), 22) : hashCode;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        e();
        parseFromLocalFileData(bArr, i, i2);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        int i4 = i + 4;
        while (i4 + 4 <= i3) {
            ZipShort zipShort = new ZipShort(bArr, i4);
            int i5 = i4 + 2;
            if (zipShort.equals(e)) {
                d(bArr, i5, i3 - i5);
                return;
            }
            i4 = i5 + new ZipShort(bArr, i5).getValue() + 2;
        }
    }

    public String toString() {
        return "0x000A Zip Extra Field: Modify:[" + c() + "]  Access:[" + a() + "]  Create:[" + b() + "] ";
    }
}
