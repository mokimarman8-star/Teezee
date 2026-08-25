package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.InflaterSource;
import okio.Okio;
import okio.Source;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class f {
    private final InflaterSource a;
    private int b;
    private final BufferedSource c;

    class a extends ForwardingSource {
        a(Source source) {
            super(source);
        }

        public long read(Buffer buffer, long j) {
            if (f.this.b == 0) {
                return -1L;
            }
            long read = super.read(buffer, Math.min(j, f.this.b));
            if (read == -1) {
                return -1L;
            }
            f.this.b = (int) (r8.b - read);
            return read;
        }
    }

    class b extends Inflater {
        b() {
        }

        @Override // java.util.zip.Inflater
        public int inflate(byte[] bArr, int i, int i2) {
            int inflate = super.inflate(bArr, i, i2);
            if (inflate != 0 || !needsDictionary()) {
                return inflate;
            }
            setDictionary(i.a);
            return super.inflate(bArr, i, i2);
        }
    }

    public f(BufferedSource bufferedSource) {
        InflaterSource inflaterSource = new InflaterSource(new a(bufferedSource), new b());
        this.a = inflaterSource;
        this.c = Okio.buffer(inflaterSource);
    }

    private void d() {
        if (this.b > 0) {
            this.a.refill();
            if (this.b == 0) {
                return;
            }
            throw new IOException("compressedLimit > 0: " + this.b);
        }
    }

    private ByteString e() {
        return this.c.readByteString(this.c.readInt());
    }

    public void c() {
        this.c.close();
    }

    public List f(int i) {
        this.b += i;
        int readInt = this.c.readInt();
        if (readInt < 0) {
            throw new IOException("numberOfPairs < 0: " + readInt);
        }
        if (readInt > 1024) {
            throw new IOException("numberOfPairs > 1024: " + readInt);
        }
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            ByteString asciiLowercase = e().toAsciiLowercase();
            ByteString e = e();
            if (asciiLowercase.size() == 0) {
                throw new IOException("name.size == 0");
            }
            arrayList.add(new com.squareup.okhttp.internal.framed.b(asciiLowercase, e));
        }
        d();
        return arrayList;
    }
}
