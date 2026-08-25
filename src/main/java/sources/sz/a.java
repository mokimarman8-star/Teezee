package sz;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import org.apache.tools.zip.UnixStat;
import org.jsoup.helper.d;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a extends BufferedInputStream {
    private final boolean a;
    private final int b;
    private long c;
    private long d;
    private int e;
    private boolean f;

    private a(InputStream inputStream, int i, int i2) {
        super(inputStream, i);
        this.d = 0L;
        d.d(i2 >= 0);
        this.b = i2;
        this.e = i2;
        this.a = i2 != 0;
        this.c = System.nanoTime();
    }

    private boolean d() {
        return this.d != 0 && System.nanoTime() - this.c > this.d;
    }

    public static a j(InputStream inputStream, int i, int i2) {
        return inputStream instanceof a ? (a) inputStream : new a(inputStream, i, i2);
    }

    public ByteBuffer f(int i) {
        d.e(i >= 0, "maxSize must be 0 (unlimited) or larger");
        boolean z = i > 0;
        int i2 = UnixStat.FILE_FLAG;
        if (z && i < 32768) {
            i2 = i;
        }
        byte[] bArr = new byte[i2];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        while (true) {
            int read = read(bArr);
            if (read == -1) {
                break;
            }
            if (z) {
                if (read >= i) {
                    byteArrayOutputStream.write(bArr, 0, i);
                    break;
                }
                i -= read;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    public a h(long j, long j2) {
        this.c = j;
        this.d = j2 * 1000000;
        return this;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3;
        if (this.f || (this.a && this.e <= 0)) {
            return -1;
        }
        if (Thread.interrupted()) {
            this.f = true;
            return -1;
        }
        if (d()) {
            throw new SocketTimeoutException("Read timeout");
        }
        if (this.a && i2 > (i3 = this.e)) {
            i2 = i3;
        }
        try {
            int read = super.read(bArr, i, i2);
            this.e -= read;
            return read;
        } catch (SocketTimeoutException unused) {
            return 0;
        }
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        super.reset();
        this.e = this.b - ((BufferedInputStream) this).markpos;
    }
}
