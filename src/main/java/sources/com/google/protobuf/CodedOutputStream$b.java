package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class CodedOutputStream$b extends CodedOutputStream {
    final byte[] buffer;
    final int limit;
    int position;
    int totalBytesWritten;

    CodedOutputStream$b(int i) {
        super((CodedOutputStream$a) null);
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        byte[] bArr = new byte[Math.max(i, 20)];
        this.buffer = bArr;
        this.limit = bArr.length;
    }

    final void buffer(byte b) {
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
        this.totalBytesWritten++;
    }

    final void bufferFixed32NoTag(int i) {
        byte[] bArr = this.buffer;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) (i & 255);
        int i4 = i2 + 2;
        this.position = i4;
        bArr[i3] = (byte) ((i >> 8) & 255);
        int i5 = i2 + 3;
        this.position = i5;
        bArr[i4] = (byte) ((i >> 16) & 255);
        this.position = i2 + 4;
        bArr[i5] = (byte) ((i >> 24) & 255);
        this.totalBytesWritten += 4;
    }

    final void bufferFixed64NoTag(long j) {
        byte[] bArr = this.buffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        bArr[i] = (byte) (j & 255);
        int i3 = i + 2;
        this.position = i3;
        bArr[i2] = (byte) ((j >> 8) & 255);
        int i4 = i + 3;
        this.position = i4;
        bArr[i3] = (byte) ((j >> 16) & 255);
        int i5 = i + 4;
        this.position = i5;
        bArr[i4] = (byte) (255 & (j >> 24));
        int i6 = i + 5;
        this.position = i6;
        bArr[i5] = (byte) (((int) (j >> 32)) & 255);
        int i7 = i + 6;
        this.position = i7;
        bArr[i6] = (byte) (((int) (j >> 40)) & 255);
        int i8 = i + 7;
        this.position = i8;
        bArr[i7] = (byte) (((int) (j >> 48)) & 255);
        this.position = i + 8;
        bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        this.totalBytesWritten += 8;
    }

    final void bufferInt32NoTag(int i) {
        if (i >= 0) {
            bufferUInt32NoTag(i);
        } else {
            bufferUInt64NoTag(i);
        }
    }

    final void bufferTag(int i, int i2) {
        bufferUInt32NoTag(WireFormat.makeTag(i, i2));
    }

    final void bufferUInt32NoTag(int i) {
        if (!CodedOutputStream.access$100()) {
            while ((i & (-128)) != 0) {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                this.totalBytesWritten++;
                i >>>= 7;
            }
            byte[] bArr2 = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            bArr2[i3] = (byte) i;
            this.totalBytesWritten++;
            return;
        }
        long j = this.position;
        while ((i & (-128)) != 0) {
            byte[] bArr3 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            s1.putByte(bArr3, i4, (byte) ((i & 127) | 128));
            i >>>= 7;
        }
        byte[] bArr4 = this.buffer;
        int i5 = this.position;
        this.position = i5 + 1;
        s1.putByte(bArr4, i5, (byte) i);
        this.totalBytesWritten += (int) (this.position - j);
    }

    final void bufferUInt64NoTag(long j) {
        if (!CodedOutputStream.access$100()) {
            while ((j & (-128)) != 0) {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((((int) j) & 127) | 128);
                this.totalBytesWritten++;
                j >>>= 7;
            }
            byte[] bArr2 = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr2[i2] = (byte) j;
            this.totalBytesWritten++;
            return;
        }
        long j2 = this.position;
        while ((j & (-128)) != 0) {
            byte[] bArr3 = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            s1.putByte(bArr3, i3, (byte) ((((int) j) & 127) | 128));
            j >>>= 7;
        }
        byte[] bArr4 = this.buffer;
        int i4 = this.position;
        this.position = i4 + 1;
        s1.putByte(bArr4, i4, (byte) j);
        this.totalBytesWritten += (int) (this.position - j2);
    }

    public final int getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public final int spaceLeft() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }
}
