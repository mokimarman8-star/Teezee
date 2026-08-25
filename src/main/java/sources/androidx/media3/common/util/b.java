package androidx.media3.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final File f9043a;

    /* renamed from: b, reason: collision with root package name */
    private final File f9044b;

    private static final class a extends OutputStream {

        /* renamed from: a, reason: collision with root package name */
        private final FileOutputStream f9045a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f9046b = false;

        public a(File file) {
            this.f9045a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f9046b) {
                return;
            }
            this.f9046b = true;
            flush();
            try {
                this.f9045a.getFD().sync();
            } catch (IOException e5) {
                u.i("AtomicFile", "Failed to sync file descriptor:", e5);
            }
            this.f9045a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            this.f9045a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i5) {
            this.f9045a.write(i5);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.f9045a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i5, int i6) {
            this.f9045a.write(bArr, i5, i6);
        }
    }

    public b(File file) {
        this.f9043a = file;
        this.f9044b = new File(file.getPath() + ".bak");
    }

    private void e() {
        if (this.f9044b.exists()) {
            this.f9043a.delete();
            this.f9044b.renameTo(this.f9043a);
        }
    }

    public void a() {
        this.f9043a.delete();
        this.f9044b.delete();
    }

    public void b(OutputStream outputStream) {
        outputStream.close();
        this.f9044b.delete();
    }

    public boolean c() {
        return this.f9043a.exists() || this.f9044b.exists();
    }

    public InputStream d() {
        e();
        return new FileInputStream(this.f9043a);
    }

    public OutputStream f() {
        if (this.f9043a.exists()) {
            if (this.f9044b.exists()) {
                this.f9043a.delete();
            } else if (!this.f9043a.renameTo(this.f9044b)) {
                u.h("AtomicFile", "Couldn't rename file " + this.f9043a + " to backup file " + this.f9044b);
            }
        }
        try {
            return new a(this.f9043a);
        } catch (FileNotFoundException e5) {
            File parentFile = this.f9043a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.f9043a, e5);
            }
            try {
                return new a(this.f9043a);
            } catch (FileNotFoundException e6) {
                throw new IOException("Couldn't create " + this.f9043a, e6);
            }
        }
    }
}
