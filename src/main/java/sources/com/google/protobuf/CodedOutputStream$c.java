package com.google.protobuf;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Utf8;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class CodedOutputStream$c extends CodedOutputStream {
    private final byte[] buffer;
    private final int limit;
    private final int offset;
    private int position;

    CodedOutputStream$c(byte[] bArr, int i, int i2) {
        super((CodedOutputStream$a) null);
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        int i3 = i + i2;
        if ((i | i2 | (bArr.length - i3)) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        this.buffer = bArr;
        this.offset = i;
        this.position = i;
        this.limit = i3;
    }

    public void flush() {
    }

    public final int getTotalBytesWritten() {
        return this.position - this.offset;
    }

    public final int spaceLeft() {
        return this.limit - this.position;
    }

    public final void write(byte b) throws IOException {
        try {
            byte[] bArr = this.buffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
        }
    }

    public final void write(ByteBuffer byteBuffer) throws IOException {
        int remaining = byteBuffer.remaining();
        try {
            byteBuffer.get(this.buffer, this.position, remaining);
            this.position += remaining;
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(remaining)), e);
        }
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e);
        }
    }

    public final void writeBool(int i, boolean z) throws IOException {
        writeTag(i, 0);
        write(z ? (byte) 1 : (byte) 0);
    }

    public final void writeByteArray(int i, byte[] bArr) throws IOException {
        writeByteArray(i, bArr, 0, bArr.length);
    }

    public final void writeByteArray(int i, byte[] bArr, int i2, int i3) throws IOException {
        writeTag(i, 2);
        writeByteArrayNoTag(bArr, i2, i3);
    }

    public final void writeByteArrayNoTag(byte[] bArr, int i, int i2) throws IOException {
        writeUInt32NoTag(i2);
        write(bArr, i, i2);
    }

    public final void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException {
        writeTag(i, 2);
        writeUInt32NoTag(byteBuffer.capacity());
        writeRawBytes(byteBuffer);
    }

    public final void writeBytes(int i, ByteString byteString) throws IOException {
        writeTag(i, 2);
        writeBytesNoTag(byteString);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void writeBytesNoTag(ByteString byteString) throws IOException {
        writeUInt32NoTag(byteString.size());
        byteString.writeTo(this);
    }

    public final void writeFixed32(int i, int i2) throws IOException {
        writeTag(i, 5);
        writeFixed32NoTag(i2);
    }

    public final void writeFixed32NoTag(int i) throws IOException {
        try {
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
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
        }
    }

    public final void writeFixed64(int i, long j) throws IOException {
        writeTag(i, 1);
        writeFixed64NoTag(j);
    }

    public final void writeFixed64NoTag(long j) throws IOException {
        try {
            byte[] bArr = this.buffer;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i + 2;
            this.position = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i + 3;
            this.position = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i + 4;
            this.position = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
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
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
        }
    }

    public final void writeInt32(int i, int i2) throws IOException {
        writeTag(i, 0);
        writeInt32NoTag(i2);
    }

    public final void writeInt32NoTag(int i) throws IOException {
        if (i >= 0) {
            writeUInt32NoTag(i);
        } else {
            writeUInt64NoTag(i);
        }
    }

    public final void writeLazy(ByteBuffer byteBuffer) throws IOException {
        write(byteBuffer);
    }

    public final void writeLazy(byte[] bArr, int i, int i2) throws IOException {
        write(bArr, i, i2);
    }

    public final void writeMessage(int i, s0 s0Var) throws IOException {
        writeTag(i, 2);
        writeMessageNoTag(s0Var);
    }

    final void writeMessage(int i, s0 s0Var, i1 i1Var) throws IOException {
        writeTag(i, 2);
        writeUInt32NoTag(((a) s0Var).getSerializedSize(i1Var));
        i1Var.writeTo(s0Var, ((CodedOutputStream) this).wrapper);
    }

    public final void writeMessageNoTag(s0 s0Var) throws IOException {
        writeUInt32NoTag(s0Var.getSerializedSize());
        s0Var.writeTo(this);
    }

    final void writeMessageNoTag(s0 s0Var, i1 i1Var) throws IOException {
        writeUInt32NoTag(((a) s0Var).getSerializedSize(i1Var));
        i1Var.writeTo(s0Var, ((CodedOutputStream) this).wrapper);
    }

    public final void writeMessageSetExtension(int i, s0 s0Var) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, i);
        writeMessage(3, s0Var);
        writeTag(1, 4);
    }

    public final void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.hasArray()) {
            write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            return;
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        e0.clear(duplicate);
        write(duplicate);
    }

    public final void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, i);
        writeBytes(3, byteString);
        writeTag(1, 4);
    }

    public final void writeString(int i, String str) throws IOException {
        writeTag(i, 2);
        writeStringNoTag(str);
    }

    public final void writeStringNoTag(String str) throws IOException {
        int i = this.position;
        try {
            int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
            int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
            if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                int i2 = i + computeUInt32SizeNoTag2;
                this.position = i2;
                int encode = Utf8.encode(str, this.buffer, i2, spaceLeft());
                this.position = i;
                writeUInt32NoTag((encode - i) - computeUInt32SizeNoTag2);
                this.position = encode;
            } else {
                writeUInt32NoTag(Utf8.encodedLength(str));
                this.position = Utf8.encode(str, this.buffer, this.position, spaceLeft());
            }
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream.OutOfSpaceException(e);
        } catch (Utf8.UnpairedSurrogateException e2) {
            this.position = i;
            inefficientWriteStringNoTag(str, e2);
        }
    }

    public final void writeTag(int i, int i2) throws IOException {
        writeUInt32NoTag(WireFormat.makeTag(i, i2));
    }

    public final void writeUInt32(int i, int i2) throws IOException {
        writeTag(i, 0);
        writeUInt32NoTag(i2);
    }

    public final void writeUInt32NoTag(int i) throws IOException {
        while ((i & (-128)) != 0) {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }
        byte[] bArr2 = this.buffer;
        int i3 = this.position;
        this.position = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    public final void writeUInt64(int i, long j) throws IOException {
        writeTag(i, 0);
        writeUInt64NoTag(j);
    }

    public final void writeUInt64NoTag(long j) throws IOException {
        if (CodedOutputStream.access$100() && spaceLeft() >= 10) {
            while ((j & (-128)) != 0) {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                s1.putByte(bArr, i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr2 = this.buffer;
            int i2 = this.position;
            this.position = 1 + i2;
            s1.putByte(bArr2, i2, (byte) j);
            return;
        }
        while ((j & (-128)) != 0) {
            try {
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }
        byte[] bArr4 = this.buffer;
        int i4 = this.position;
        this.position = i4 + 1;
        bArr4[i4] = (byte) j;
    }
}
