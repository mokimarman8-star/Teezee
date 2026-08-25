package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class ByteString$BoundedByteString extends ByteString.LiteralByteString {
    private static final long serialVersionUID = 1;
    private final int bytesLength;
    private final int bytesOffset;

    ByteString$BoundedByteString(byte[] bArr, int i, int i2) {
        super(bArr);
        ByteString.checkRange(i, i + i2, bArr.length);
        this.bytesOffset = i;
        this.bytesLength = i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }

    public byte byteAt(int i) {
        ByteString.checkIndex(i, size());
        return ((ByteString.LiteralByteString) this).bytes[this.bytesOffset + i];
    }

    protected void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(((ByteString.LiteralByteString) this).bytes, getOffsetIntoBytes() + i, bArr, i2, i3);
    }

    protected int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    byte internalByteAt(int i) {
        return ((ByteString.LiteralByteString) this).bytes[this.bytesOffset + i];
    }

    public int size() {
        return this.bytesLength;
    }

    Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }
}
