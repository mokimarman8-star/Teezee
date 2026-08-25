package com.google.protobuf;

import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class ByteString$a extends ByteString$b {
    private final int limit;
    private int position = 0;
    final /* synthetic */ ByteString this$0;

    ByteString$a(ByteString byteString) {
        this.this$0 = byteString;
        this.limit = byteString.size();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.protobuf.ByteString$b, com.google.protobuf.ByteString$e
    public byte nextByte() {
        int i = this.position;
        if (i >= this.limit) {
            throw new NoSuchElementException();
        }
        this.position = i + 1;
        return this.this$0.internalByteAt(i);
    }
}
