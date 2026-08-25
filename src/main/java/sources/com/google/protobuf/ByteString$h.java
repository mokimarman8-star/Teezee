package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class ByteString$h implements ByteString$d {
    private ByteString$h() {
    }

    /* synthetic */ ByteString$h(ByteString$a byteString$a) {
        this();
    }

    @Override // com.google.protobuf.ByteString$d
    public byte[] copyFrom(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }
}
