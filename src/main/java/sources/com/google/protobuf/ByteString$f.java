package com.google.protobuf;

import com.google.protobuf.ByteString;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class ByteString$f {
    private final byte[] buffer;
    private final CodedOutputStream output;

    private ByteString$f(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.output = CodedOutputStream.newInstance(bArr);
    }

    /* synthetic */ ByteString$f(int i, ByteString$a byteString$a) {
        this(i);
    }

    public ByteString build() {
        this.output.checkNoSpaceLeft();
        return new ByteString.LiteralByteString(this.buffer);
    }

    public CodedOutputStream getCodedOutput() {
        return this.output;
    }
}
