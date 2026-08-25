package com.google.protobuf;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class ByteString$b implements ByteString$e {
    ByteString$b() {
    }

    @Override // java.util.Iterator
    public final Byte next() {
        return Byte.valueOf(nextByte());
    }

    @Override // com.google.protobuf.ByteString$e
    public abstract /* synthetic */ byte nextByte();

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
