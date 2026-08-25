package androidx.datastore.preferences.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class x extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private Iterator f7774a;

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f7775b;

    /* renamed from: c, reason: collision with root package name */
    private int f7776c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f7777d;

    /* renamed from: e, reason: collision with root package name */
    private int f7778e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7779f;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f7780g;

    /* renamed from: h, reason: collision with root package name */
    private int f7781h;

    /* renamed from: i, reason: collision with root package name */
    private long f7782i;

    x(Iterable iterable) {
        this.f7774a = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.f7776c++;
        }
        this.f7777d = -1;
        if (d()) {
            return;
        }
        this.f7775b = w.f7772e;
        this.f7777d = 0;
        this.f7778e = 0;
        this.f7782i = 0L;
    }

    private boolean d() {
        this.f7777d++;
        if (!this.f7774a.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.f7774a.next();
        this.f7775b = byteBuffer;
        this.f7778e = byteBuffer.position();
        if (this.f7775b.hasArray()) {
            this.f7779f = true;
            this.f7780g = this.f7775b.array();
            this.f7781h = this.f7775b.arrayOffset();
        } else {
            this.f7779f = false;
            this.f7782i = k1.k(this.f7775b);
            this.f7780g = null;
        }
        return true;
    }

    private void f(int i5) {
        int i6 = this.f7778e + i5;
        this.f7778e = i6;
        if (i6 == this.f7775b.limit()) {
            d();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f7777d == this.f7776c) {
            return -1;
        }
        if (this.f7779f) {
            int i5 = this.f7780g[this.f7778e + this.f7781h] & 255;
            f(1);
            return i5;
        }
        int w5 = k1.w(this.f7778e + this.f7782i) & 255;
        f(1);
        return w5;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        if (this.f7777d == this.f7776c) {
            return -1;
        }
        int limit = this.f7775b.limit();
        int i7 = this.f7778e;
        int i8 = limit - i7;
        if (i6 > i8) {
            i6 = i8;
        }
        if (this.f7779f) {
            System.arraycopy(this.f7780g, i7 + this.f7781h, bArr, i5, i6);
            f(i6);
        } else {
            int position = this.f7775b.position();
            y.c(this.f7775b, this.f7778e);
            this.f7775b.get(bArr, i5, i6);
            y.c(this.f7775b, position);
            f(i6);
        }
        return i6;
    }
}
