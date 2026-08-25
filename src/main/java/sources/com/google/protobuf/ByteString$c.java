package com.google.protobuf;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class ByteString$c implements ByteString$d {
    private ByteString$c() {
    }

    /* synthetic */ ByteString$c(ByteString$a byteString$a) {
        this();
    }

    @Override // com.google.protobuf.ByteString$d
    public byte[] copyFrom(byte[] bArr, int i, int i2) {
        return Arrays.copyOfRange(bArr, i, i2 + i);
    }
}
