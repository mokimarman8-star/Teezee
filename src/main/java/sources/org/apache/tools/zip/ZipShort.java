package org.apache.tools.zip;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ZipShort implements Cloneable {
    private static final int BYTE_1_MASK = 65280;
    private static final int BYTE_1_SHIFT = 8;
    private static final int BYTE_MASK = 255;
    private int value;

    public ZipShort(int i) {
        this.value = i;
    }

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipShort(byte[] bArr, int i) {
        this.value = getValue(bArr, i);
    }

    public static byte[] getBytes(int i) {
        return new byte[]{(byte) (i & BYTE_MASK), (byte) ((i & BYTE_1_MASK) >> 8)};
    }

    public static int getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }

    public static int getValue(byte[] bArr, int i) {
        return ((bArr[i + 1] << 8) & BYTE_1_MASK) + (bArr[i] & 255);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ZipShort) && this.value == ((ZipShort) obj).getValue();
    }

    public byte[] getBytes() {
        int i = this.value;
        return new byte[]{(byte) (i & BYTE_MASK), (byte) ((i & BYTE_1_MASK) >> 8)};
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }
}
