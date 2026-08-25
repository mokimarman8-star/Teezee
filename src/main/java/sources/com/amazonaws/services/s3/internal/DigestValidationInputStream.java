package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkDigestInputStream;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DigestValidationInputStream extends SdkDigestInputStream {
    private byte[] a;
    private boolean b;

    public DigestValidationInputStream(InputStream inputStream, MessageDigest messageDigest, byte[] bArr) {
        super(inputStream, messageDigest);
        this.b = false;
        this.a = bArr;
    }

    private void h() {
        if (this.a == null || this.b) {
            return;
        }
        this.b = true;
        if (!Arrays.equals(((DigestInputStream) this).digest.digest(), this.a)) {
            throw new AmazonClientException("Unable to verify integrity of data download.  Client calculated content hash didn't match hash calculated by Amazon S3.  The data may be corrupt.");
        }
    }

    @Override // java.security.DigestInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = super.read();
        if (read == -1) {
            h();
        }
        return read;
    }

    @Override // java.security.DigestInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read == -1) {
            h();
        }
        return read;
    }
}
