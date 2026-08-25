package com.amazonaws.services.s3.internal.crypto;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class AesCtr extends ContentCryptoScheme {
    AesCtr() {
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    int a() {
        return ContentCryptoScheme.b.a();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    String b() {
        return "AES/CTR/NoPadding";
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    int c() {
        return 16;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    String d() {
        return ContentCryptoScheme.b.d();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    int e() {
        return ContentCryptoScheme.b.e();
    }
}
