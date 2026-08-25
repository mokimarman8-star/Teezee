package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class MD5DigestCalculatingInputStream extends SdkFilterInputStream {
    private MessageDigest a;
    private MessageDigest b;

    public MD5DigestCalculatingInputStream(InputStream inputStream) {
        super(inputStream);
        this.a = n();
    }

    private MessageDigest l(MessageDigest messageDigest) {
        try {
            return (MessageDigest) messageDigest.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("unexpected", e);
        }
    }

    private MessageDigest n() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("unexpected", e);
        }
    }

    public byte[] m() {
        return this.a.digest();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        if (markSupported()) {
            super.mark(i);
            this.b = l(this.a);
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = super.read();
        if (read != -1) {
            this.a.update((byte) read);
        }
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.a.update(bArr, i, read);
        }
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        if (!markSupported()) {
            throw new IOException("mark/reset not supported");
        }
        super.reset();
        MessageDigest messageDigest = this.b;
        this.a = messageDigest == null ? n() : l(messageDigest);
    }
}
