package com.amazonaws.util;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class NamespaceRemovingInputStream extends SdkFilterInputStream {
    private final byte[] a;
    private boolean b;

    private static final class StringPrefixSlicer {
        private String a;

        public StringPrefixSlicer(String str) {
            this.a = str;
        }

        public String a() {
            return this.a;
        }

        public boolean b(String str) {
            if (!this.a.startsWith(str)) {
                return false;
            }
            this.a = this.a.substring(str.length());
            return true;
        }

        public boolean c(String str) {
            int indexOf = this.a.indexOf(str);
            if (indexOf < 0) {
                return false;
            }
            this.a = this.a.substring(indexOf + str.length());
            return true;
        }

        public boolean d(String str) {
            if (!this.a.startsWith(str)) {
                return false;
            }
            while (this.a.startsWith(str)) {
                this.a = this.a.substring(str.length());
            }
            return true;
        }
    }

    public NamespaceRemovingInputStream(InputStream inputStream) {
        super(new BufferedInputStream(inputStream));
        this.a = new byte[200];
        this.b = false;
    }

    private int l(String str) {
        StringPrefixSlicer stringPrefixSlicer = new StringPrefixSlicer(str);
        if (!stringPrefixSlicer.b("xmlns")) {
            return -1;
        }
        stringPrefixSlicer.d(" ");
        if (!stringPrefixSlicer.b("=")) {
            return -1;
        }
        stringPrefixSlicer.d(" ");
        if (stringPrefixSlicer.b("\"") && stringPrefixSlicer.c("\"")) {
            return str.length() - stringPrefixSlicer.a().length();
        }
        return -1;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        k();
        int read = ((FilterInputStream) this).in.read();
        if (read != 120 || this.b) {
            return read;
        }
        this.a[0] = (byte) read;
        ((FilterInputStream) this).in.mark(this.a.length);
        InputStream inputStream = ((FilterInputStream) this).in;
        byte[] bArr = this.a;
        int read2 = inputStream.read(bArr, 1, bArr.length - 1);
        ((FilterInputStream) this).in.reset();
        int l = l(new String(this.a, 0, read2 + 1, StringUtils.a));
        if (l <= 0) {
            return read;
        }
        for (int i = 0; i < l - 1; i++) {
            ((FilterInputStream) this).in.read();
        }
        int read3 = ((FilterInputStream) this).in.read();
        this.b = true;
        return read3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int read = read();
            if (read == -1) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            bArr[i3 + i] = (byte) read;
        }
        return i2;
    }
}
