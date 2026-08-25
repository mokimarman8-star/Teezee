package dz;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.r;
import org.apache.commons.compress.archivers.zip.s;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class b extends cz.b {
    private final byte[] c;
    private final int d;
    private final int e;
    private boolean f;
    private long g;
    private long h;
    private final InputStream i;
    private a j;
    private final r k;
    final String l;
    private Map m;
    private final boolean n;

    public b(InputStream inputStream) {
        this(inputStream, 10240, 512);
    }

    public b(InputStream inputStream, int i, int i2) {
        this(inputStream, i, i2, null);
    }

    public b(InputStream inputStream, int i, int i2, String str) {
        this(inputStream, i, i2, str, false);
    }

    public b(InputStream inputStream, int i, int i2, String str, boolean z) {
        this.c = new byte[256];
        this.m = new HashMap();
        this.i = inputStream;
        this.f = false;
        this.l = str;
        this.k = s.a(str);
        this.d = i2;
        this.e = i;
        this.n = z;
    }

    private void S() {
        if (r()) {
            return;
        }
        long j = this.g;
        if (j > 0) {
            int i = this.d;
            if (j % i != 0) {
                f(ez.c.c(this.i, (((j / i) + 1) * i) - j));
            }
        }
    }

    private void T() {
        boolean markSupported = this.i.markSupported();
        if (markSupported) {
            this.i.mark(this.d);
        }
        try {
            if (s(x()) || !markSupported) {
            }
        } finally {
            if (markSupported) {
                j(this.d);
                this.i.reset();
            }
        }
    }

    private void k(Map map) {
        this.j.C(map);
    }

    private void l() {
        long h = h();
        int i = this.e;
        long j = h % i;
        if (j > 0) {
            f(ez.c.c(this.i, i - j));
        }
    }

    private byte[] p() {
        byte[] x = x();
        y(s(x));
        if (!q() || x == null) {
            return x;
        }
        T();
        l();
        return null;
    }

    private boolean r() {
        a aVar = this.j;
        return aVar != null && aVar.h();
    }

    private void u() {
        Map t = t(this);
        n();
        k(t);
    }

    private void v() {
        this.m = t(this);
        n();
    }

    private void w() {
        byte[] p;
        if (this.j.i()) {
            do {
                p = p();
                if (p == null) {
                    this.j = null;
                    return;
                }
            } while (new c(p).a());
        }
    }

    @Override // java.io.InputStream
    public int available() {
        if (r()) {
            return 0;
        }
        long j = this.g;
        long j2 = this.h;
        if (j - j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) (j - j2);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.i.close();
    }

    protected byte[] m() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = read(this.c);
            if (read < 0) {
                break;
            }
            byteArrayOutputStream.write(this.c, 0, read);
        }
        n();
        if (this.j == null) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > 0 && byteArray[length - 1] == 0) {
            length--;
        }
        if (length == byteArray.length) {
            return byteArray;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 0, bArr, 0, length);
        return bArr;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public cz.a n() {
        return o();
    }

    public a o() {
        if (q()) {
            return null;
        }
        if (this.j != null) {
            ez.c.c(this, Long.MAX_VALUE);
            S();
        }
        byte[] p = p();
        if (p == null) {
            this.j = null;
            return null;
        }
        try {
            a aVar = new a(p, this.k, this.n);
            this.j = aVar;
            this.h = 0L;
            this.g = aVar.g();
            if (this.j.j()) {
                byte[] m = m();
                if (m == null) {
                    return null;
                }
                this.j.w(this.k.a(m));
            }
            if (this.j.k()) {
                byte[] m2 = m();
                if (m2 == null) {
                    return null;
                }
                this.j.y(this.k.a(m2));
            }
            if (this.j.l()) {
                v();
            }
            if (this.j.n()) {
                u();
            } else if (!this.m.isEmpty()) {
                k(this.m);
            }
            if (this.j.m()) {
                w();
            }
            this.g = this.j.g();
            return this.j;
        } catch (IllegalArgumentException e) {
            throw new IOException("Error detected parsing the header", e);
        }
    }

    protected final boolean q() {
        return this.f;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (q() || r() || this.h >= this.g) {
            return -1;
        }
        if (this.j == null) {
            throw new IllegalStateException("No current tar entry");
        }
        int min = Math.min(i2, available());
        int read = this.i.read(bArr, i, min);
        if (read != -1) {
            b(read);
            this.h += read;
        } else {
            if (min > 0) {
                throw new IOException("Truncated TAR archive");
            }
            y(true);
        }
        return read;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
    }

    protected boolean s(byte[] bArr) {
        return bArr == null || ez.a.a(bArr, this.d);
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        if (j <= 0 || r()) {
            return 0L;
        }
        long c = ez.c.c(this.i, Math.min(j, this.g - this.h));
        f(c);
        this.h += c;
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        r4 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Map t(InputStream inputStream) {
        int read;
        HashMap hashMap = new HashMap(this.m);
        do {
            int i = 0;
            int i2 = 0;
            while (true) {
                read = inputStream.read();
                if (read == -1) {
                    break;
                }
                i++;
                if (read == 10) {
                    break;
                }
                if (read == 32) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read2 = inputStream.read();
                        if (read2 == -1) {
                            break;
                        }
                        i++;
                        if (read2 == 61) {
                            String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                            int i3 = i2 - i;
                            if (i3 == 1) {
                                hashMap.remove(byteArrayOutputStream2);
                            } else {
                                byte[] bArr = new byte[i3];
                                int a = ez.c.a(inputStream, bArr);
                                if (a != i3) {
                                    throw new IOException("Failed to read Paxheader. Expected " + i3 + " bytes, read " + a);
                                }
                                hashMap.put(byteArrayOutputStream2, new String(bArr, 0, i3 - 1, "UTF-8"));
                            }
                        } else {
                            byteArrayOutputStream.write((byte) read2);
                        }
                    }
                } else {
                    i2 = (i2 * 10) + (read - 48);
                }
            }
        } while (read != -1);
        return hashMap;
    }

    protected byte[] x() {
        byte[] bArr = new byte[this.d];
        int a = ez.c.a(this.i, bArr);
        b(a);
        if (a != this.d) {
            return null;
        }
        return bArr;
    }

    protected final void y(boolean z) {
        this.f = z;
    }
}
