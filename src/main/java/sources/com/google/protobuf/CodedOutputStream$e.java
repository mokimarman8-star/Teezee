package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class CodedOutputStream$e extends CodedOutputStream$c {
    private final ByteBuffer byteBuffer;
    private int initialPosition;

    CodedOutputStream$e(ByteBuffer byteBuffer) {
        super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        this.byteBuffer = byteBuffer;
        this.initialPosition = byteBuffer.position();
    }

    @Override // com.google.protobuf.CodedOutputStream$c
    public void flush() {
        e0.position(this.byteBuffer, this.initialPosition + getTotalBytesWritten());
    }
}
