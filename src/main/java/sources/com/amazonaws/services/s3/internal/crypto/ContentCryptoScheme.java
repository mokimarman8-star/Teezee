package com.amazonaws.services.s3.internal.crypto;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
abstract class ContentCryptoScheme {
    static final ContentCryptoScheme a = new AesCbc();
    static final ContentCryptoScheme b = new AesGcm();
    static final ContentCryptoScheme c = new AesCtr();

    ContentCryptoScheme() {
    }

    abstract int a();

    abstract String b();

    abstract int c();

    abstract String d();

    abstract int e();

    String f() {
        return null;
    }

    int g() {
        return 0;
    }

    public String toString() {
        return "cipherAlgo=" + b() + ", blockSizeInBytes=" + a() + ", ivLengthInBytes=" + c() + ", keyGenAlgo=" + d() + ", keyLengthInBits=" + e() + ", specificProvider=" + f() + ", tagLengthInBits=" + g();
    }
}
