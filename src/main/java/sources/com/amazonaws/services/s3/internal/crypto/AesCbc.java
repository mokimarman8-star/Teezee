package com.amazonaws.services.s3.internal.crypto;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class AesCbc extends ContentCryptoScheme {
    AesCbc() {
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    int a() {
        return 16;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    String b() {
        return "AES/CBC/PKCS5Padding";
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    int c() {
        return 16;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    String d() {
        return "AES";
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    int e() {
        return 256;
    }
}
