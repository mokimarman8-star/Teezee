package tb;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class g implements Closeable {
    private static final Logger g = Logger.getLogger(g.class.getName());
    private final RandomAccessFile a;
    int b;
    private int c;
    private b d;
    private b e;
    private final byte[] f = new byte[16];

    class a implements d {
        boolean a = true;
        final /* synthetic */ StringBuilder b;

        a(StringBuilder sb2) {
            this.b = sb2;
        }

        @Override // tb.g.d
        public void read(InputStream inputStream, int i) {
            if (this.a) {
                this.a = false;
            } else {
                this.b.append(", ");
            }
            this.b.append(i);
        }
    }

    static class b {
        static final b c = new b(0, 0);
        final int a;
        final int b;

        b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.a + ", length = " + this.b + "]";
        }
    }

    private final class c extends InputStream {
        private int a;
        private int b;

        private c(b bVar) {
            this.a = g.this.W(bVar.a + 4);
            this.b = bVar.b;
        }

        /* synthetic */ c(g gVar, b bVar, a aVar) {
            this(bVar);
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.b == 0) {
                return -1;
            }
            g.this.a.seek(this.a);
            int read = g.this.a.read();
            this.a = g.this.W(this.a + 1);
            this.b--;
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            g.q(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.b;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            g.this.x(this.a, bArr, i, i2);
            this.a = g.this.W(this.a + i2);
            this.b -= i2;
            return i2;
        }
    }

    public interface d {
        void read(InputStream inputStream, int i);
    }

    public g(File file) {
        if (!file.exists()) {
            o(file);
        }
        this.a = r(file);
        t();
    }

    private void S(int i) {
        this.a.setLength(i);
        this.a.getChannel().force(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int W(int i) {
        int i2 = this.b;
        return i < i2 ? i : (i + 16) - i2;
    }

    private void X(int i, int i2, int i3, int i4) {
        e0(this.f, i, i2, i3, i4);
        this.a.seek(0L);
        this.a.write(this.f);
    }

    private static void d0(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void e0(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            d0(bArr, i, i2);
            i += 4;
        }
    }

    private void m(int i) {
        int i2 = i + 4;
        int v = v();
        if (v >= i2) {
            return;
        }
        int i3 = this.b;
        do {
            v += i3;
            i3 <<= 1;
        } while (v < i2);
        S(i3);
        b bVar = this.e;
        int W = W(bVar.a + 4 + bVar.b);
        if (W < this.d.a) {
            FileChannel channel = this.a.getChannel();
            channel.position(this.b);
            long j = W - 4;
            if (channel.transferTo(16L, j, channel) != j) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i4 = this.e.a;
        int i5 = this.d.a;
        if (i4 < i5) {
            int i6 = (this.b + i4) - 16;
            X(i3, this.c, i5, i6);
            this.e = new b(i6, this.e.b);
        } else {
            X(i3, this.c, i5, i4);
        }
        this.b = i3;
    }

    private static void o(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile r = r(file2);
        try {
            r.setLength(4096L);
            r.seek(0L);
            byte[] bArr = new byte[16];
            e0(bArr, 4096, 0, 0, 0);
            r.write(bArr);
            r.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            r.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object q(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile r(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private b s(int i) {
        if (i == 0) {
            return b.c;
        }
        this.a.seek(i);
        return new b(i, this.a.readInt());
    }

    private void t() {
        this.a.seek(0L);
        this.a.readFully(this.f);
        int u = u(this.f, 0);
        this.b = u;
        if (u <= this.a.length()) {
            this.c = u(this.f, 4);
            int u2 = u(this.f, 8);
            int u3 = u(this.f, 12);
            this.d = s(u2);
            this.e = s(u3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.b + ", Actual length: " + this.a.length());
    }

    private static int u(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    private int v() {
        return this.b - T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, byte[] bArr, int i2, int i3) {
        int W = W(i);
        int i4 = W + i3;
        int i5 = this.b;
        if (i4 <= i5) {
            this.a.seek(W);
            this.a.readFully(bArr, i2, i3);
            return;
        }
        int i6 = i5 - W;
        this.a.seek(W);
        this.a.readFully(bArr, i2, i6);
        this.a.seek(16L);
        this.a.readFully(bArr, i2 + i6, i3 - i6);
    }

    private void y(int i, byte[] bArr, int i2, int i3) {
        int W = W(i);
        int i4 = W + i3;
        int i5 = this.b;
        if (i4 <= i5) {
            this.a.seek(W);
            this.a.write(bArr, i2, i3);
            return;
        }
        int i6 = i5 - W;
        this.a.seek(W);
        this.a.write(bArr, i2, i6);
        this.a.seek(16L);
        this.a.write(bArr, i2 + i6, i3 - i6);
    }

    public int T() {
        if (this.c == 0) {
            return 16;
        }
        b bVar = this.e;
        int i = bVar.a;
        int i2 = this.d.a;
        return i >= i2 ? (i - i2) + 4 + bVar.b + 16 : (((i + 4) + bVar.b) + this.b) - i2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.a.close();
    }

    public void j(byte[] bArr) {
        k(bArr, 0, bArr.length);
    }

    public synchronized void k(byte[] bArr, int i, int i2) {
        int W;
        try {
            q(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            m(i2);
            boolean p = p();
            if (p) {
                W = 16;
            } else {
                b bVar = this.e;
                W = W(bVar.a + 4 + bVar.b);
            }
            b bVar2 = new b(W, i2);
            d0(this.f, 0, i2);
            y(bVar2.a, this.f, 0, 4);
            y(bVar2.a + 4, bArr, i, i2);
            X(this.b, this.c + 1, p ? bVar2.a : this.d.a, bVar2.a);
            this.e = bVar2;
            this.c++;
            if (p) {
                this.d = bVar2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void l() {
        try {
            X(4096, 0, 0, 0);
            this.c = 0;
            b bVar = b.c;
            this.d = bVar;
            this.e = bVar;
            if (this.b > 4096) {
                S(4096);
            }
            this.b = 4096;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void n(d dVar) {
        int i = this.d.a;
        for (int i2 = 0; i2 < this.c; i2++) {
            b s = s(i);
            dVar.read(new c(this, s, null), s.b);
            i = W(s.a + 4 + s.b);
        }
    }

    public synchronized boolean p() {
        return this.c == 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append('[');
        sb2.append("fileLength=");
        sb2.append(this.b);
        sb2.append(", size=");
        sb2.append(this.c);
        sb2.append(", first=");
        sb2.append(this.d);
        sb2.append(", last=");
        sb2.append(this.e);
        sb2.append(", element lengths=[");
        try {
            n(new a(sb2));
        } catch (IOException e) {
            g.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb2.append("]]");
        return sb2.toString();
    }

    public synchronized void w() {
        try {
            if (p()) {
                throw new NoSuchElementException();
            }
            if (this.c == 1) {
                l();
            } else {
                b bVar = this.d;
                int W = W(bVar.a + 4 + bVar.b);
                x(W, this.f, 0, 4);
                int u = u(this.f, 0);
                X(this.b, this.c - 1, W, this.e.a);
                this.c--;
                this.d = new b(W, u);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
