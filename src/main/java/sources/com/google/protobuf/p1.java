package com.google.protobuf;

import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class p1 {
    private static final p1 DEFAULT_INSTANCE = new p1(0, new int[0], new Object[0], false);
    private static final int MIN_CAPACITY = 8;
    private int count;
    private boolean isMutable;
    private int memoizedSerializedSize;
    private Object[] objects;
    private int[] tags;

    private p1() {
        this(0, new int[8], new Object[8], true);
    }

    private p1(int i, int[] iArr, Object[] objArr, boolean z) {
        this.memoizedSerializedSize = -1;
        this.count = i;
        this.tags = iArr;
        this.objects = objArr;
        this.isMutable = z;
    }

    private void ensureCapacity(int i) {
        int[] iArr = this.tags;
        if (i > iArr.length) {
            int i2 = this.count;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.tags = Arrays.copyOf(iArr, i);
            this.objects = Arrays.copyOf(this.objects, i);
        }
    }

    public static p1 getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static int hashCode(int[] iArr, int i) {
        int i2 = 17;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        return i2;
    }

    private static int hashCode(Object[] objArr, int i) {
        int i2 = 17;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + objArr[i3].hashCode();
        }
        return i2;
    }

    private p1 mergeFrom(i iVar) throws IOException {
        int readTag;
        do {
            readTag = iVar.readTag();
            if (readTag == 0) {
                break;
            }
        } while (mergeFieldFrom(readTag, iVar));
        return this;
    }

    static p1 mutableCopyOf(p1 p1Var, p1 p1Var2) {
        int i = p1Var.count + p1Var2.count;
        int[] copyOf = Arrays.copyOf(p1Var.tags, i);
        System.arraycopy(p1Var2.tags, 0, copyOf, p1Var.count, p1Var2.count);
        Object[] copyOf2 = Arrays.copyOf(p1Var.objects, i);
        System.arraycopy(p1Var2.objects, 0, copyOf2, p1Var.count, p1Var2.count);
        return new p1(i, copyOf, copyOf2, true);
    }

    static p1 newInstance() {
        return new p1();
    }

    private static boolean objectsEquals(Object[] objArr, Object[] objArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!objArr[i2].equals(objArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private static boolean tagsEquals(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static void writeField(int i, Object obj, Writer writer) throws IOException {
        int tagFieldNumber = WireFormat.getTagFieldNumber(i);
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            writer.writeInt64(tagFieldNumber, ((Long) obj).longValue());
            return;
        }
        if (tagWireType == 1) {
            writer.writeFixed64(tagFieldNumber, ((Long) obj).longValue());
            return;
        }
        if (tagWireType == 2) {
            writer.writeBytes(tagFieldNumber, (ByteString) obj);
            return;
        }
        if (tagWireType != 3) {
            if (tagWireType != 5) {
                throw new RuntimeException((Throwable) InvalidProtocolBufferException.invalidWireType());
            }
            writer.writeFixed32(tagFieldNumber, ((Integer) obj).intValue());
        } else if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            writer.writeStartGroup(tagFieldNumber);
            ((p1) obj).writeTo(writer);
            writer.writeEndGroup(tagFieldNumber);
        } else {
            writer.writeEndGroup(tagFieldNumber);
            ((p1) obj).writeTo(writer);
            writer.writeStartGroup(tagFieldNumber);
        }
    }

    void checkMutable() {
        if (!this.isMutable) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof p1)) {
            return false;
        }
        p1 p1Var = (p1) obj;
        int i = this.count;
        return i == p1Var.count && tagsEquals(this.tags, p1Var.tags, i) && objectsEquals(this.objects, p1Var.objects, this.count);
    }

    public int getSerializedSize() {
        int computeUInt64Size;
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.tags[i3];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i4);
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                computeUInt64Size = CodedOutputStream.computeUInt64Size(tagFieldNumber, ((Long) this.objects[i3]).longValue());
            } else if (tagWireType == 1) {
                computeUInt64Size = CodedOutputStream.computeFixed64Size(tagFieldNumber, ((Long) this.objects[i3]).longValue());
            } else if (tagWireType == 2) {
                computeUInt64Size = CodedOutputStream.computeBytesSize(tagFieldNumber, (ByteString) this.objects[i3]);
            } else if (tagWireType == 3) {
                computeUInt64Size = (CodedOutputStream.computeTagSize(tagFieldNumber) * 2) + ((p1) this.objects[i3]).getSerializedSize();
            } else {
                if (tagWireType != 5) {
                    throw new IllegalStateException((Throwable) InvalidProtocolBufferException.invalidWireType());
                }
                computeUInt64Size = CodedOutputStream.computeFixed32Size(tagFieldNumber, ((Integer) this.objects[i3]).intValue());
            }
            i2 += computeUInt64Size;
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public int getSerializedSizeAsMessageSet() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.tags[i3]), (ByteString) this.objects[i3]);
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public int hashCode() {
        int i = this.count;
        return ((((527 + i) * 31) + hashCode(this.tags, i)) * 31) + hashCode(this.objects, this.count);
    }

    public void makeImmutable() {
        if (this.isMutable) {
            this.isMutable = false;
        }
    }

    boolean mergeFieldFrom(int i, i iVar) throws IOException {
        checkMutable();
        int tagFieldNumber = WireFormat.getTagFieldNumber(i);
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            storeField(i, Long.valueOf(iVar.readInt64()));
            return true;
        }
        if (tagWireType == 1) {
            storeField(i, Long.valueOf(iVar.readFixed64()));
            return true;
        }
        if (tagWireType == 2) {
            storeField(i, iVar.readBytes());
            return true;
        }
        if (tagWireType == 3) {
            p1 p1Var = new p1();
            p1Var.mergeFrom(iVar);
            iVar.checkLastTagWas(WireFormat.makeTag(tagFieldNumber, 4));
            storeField(i, p1Var);
            return true;
        }
        if (tagWireType == 4) {
            return false;
        }
        if (tagWireType != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        storeField(i, Integer.valueOf(iVar.readFixed32()));
        return true;
    }

    p1 mergeFrom(p1 p1Var) {
        if (p1Var.equals(getDefaultInstance())) {
            return this;
        }
        checkMutable();
        int i = this.count + p1Var.count;
        ensureCapacity(i);
        System.arraycopy(p1Var.tags, 0, this.tags, this.count, p1Var.count);
        System.arraycopy(p1Var.objects, 0, this.objects, this.count, p1Var.count);
        this.count = i;
        return this;
    }

    p1 mergeLengthDelimitedField(int i, ByteString byteString) {
        checkMutable();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        storeField(WireFormat.makeTag(i, 2), byteString);
        return this;
    }

    p1 mergeVarintField(int i, int i2) {
        checkMutable();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        storeField(WireFormat.makeTag(i, 0), Long.valueOf(i2));
        return this;
    }

    final void printWithIndent(StringBuilder sb2, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            u0.printField(sb2, i, String.valueOf(WireFormat.getTagFieldNumber(this.tags[i2])), this.objects[i2]);
        }
    }

    void storeField(int i, Object obj) {
        checkMutable();
        ensureCapacity(this.count + 1);
        int[] iArr = this.tags;
        int i2 = this.count;
        iArr[i2] = i;
        this.objects[i2] = obj;
        this.count = i2 + 1;
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.count; i++) {
            codedOutputStream.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.tags[i]), (ByteString) this.objects[i]);
        }
    }

    void writeAsMessageSetTo(Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (int i = this.count - 1; i >= 0; i--) {
                writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[i]), this.objects[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[i2]), this.objects[i2]);
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.count; i++) {
            int i2 = this.tags[i];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i2);
            int tagWireType = WireFormat.getTagWireType(i2);
            if (tagWireType == 0) {
                codedOutputStream.writeUInt64(tagFieldNumber, ((Long) this.objects[i]).longValue());
            } else if (tagWireType == 1) {
                codedOutputStream.writeFixed64(tagFieldNumber, ((Long) this.objects[i]).longValue());
            } else if (tagWireType == 2) {
                codedOutputStream.writeBytes(tagFieldNumber, (ByteString) this.objects[i]);
            } else if (tagWireType == 3) {
                codedOutputStream.writeTag(tagFieldNumber, 3);
                ((p1) this.objects[i]).writeTo(codedOutputStream);
                codedOutputStream.writeTag(tagFieldNumber, 4);
            } else {
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                codedOutputStream.writeFixed32(tagFieldNumber, ((Integer) this.objects[i]).intValue());
            }
        }
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            for (int i = 0; i < this.count; i++) {
                writeField(this.tags[i], this.objects[i], writer);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            writeField(this.tags[i2], this.objects[i2], writer);
        }
    }
}
