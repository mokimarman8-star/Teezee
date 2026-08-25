package com.transsion.http.b;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.transsion.http.impl.DownloadCallback;
import fl.e;
import il.f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import kl.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class c implements Runnable, Comparable<c> {
    final el.b a;
    final DownloadCallback b;
    private String c;
    private String d;
    private final Object g;
    private String h;
    private long i;
    private boolean j;
    private f k;
    private volatile boolean l;
    private final el.c m;
    private a n;
    private final AtomicBoolean e = new AtomicBoolean();
    private final e f = new e();
    private long o = 0;

    public c(el.b bVar, DownloadCallback downloadCallback) {
        this.a = bVar;
        this.b = downloadCallback;
        this.j = bVar.c().k();
        this.g = bVar.c().m();
        this.c = bVar.c().i();
        String n = bVar.c().n();
        this.h = n;
        this.m = new el.c(n);
    }

    private File a(f fVar) throws Throwable {
        FileOutputStream fileOutputStream;
        long j;
        BufferedInputStream bufferedInputStream;
        this.f.a(this.m);
        this.d = this.c + ".tmp";
        File file = new File(this.d);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("can not create dir: " + parentFile.getAbsolutePath());
            }
        } else if (this.j) {
            this.o = file.length();
        }
        this.a.c().f().put("RANGE", "bytes=" + this.o + "-");
        if (c()) {
            return null;
        }
        fVar.i();
        this.i = fVar.b();
        InputStream c = fVar.c();
        File file2 = new File(this.d);
        if (this.j) {
            j = this.o;
            fileOutputStream = new FileOutputStream(file2, true);
        } else {
            fileOutputStream = new FileOutputStream(file2);
            j = 0;
        }
        long j2 = this.i + j;
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(c);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        if (c()) {
            return null;
        }
        DownloadCallback downloadCallback = this.b;
        if (downloadCallback != null) {
            downloadCallback.y(this.k.g(), this.h, j, j2);
        }
        byte[] bArr = new byte[4096];
        while (true) {
            int read = bufferedInputStream2.read(bArr);
            if (read == -1) {
                bufferedOutputStream.flush();
                d.a(bufferedInputStream2);
                d.a(bufferedOutputStream);
                this.f.b(this.m);
                if (!this.c.equals(this.d)) {
                    File file3 = new File(this.c);
                    if (file2.renameTo(file3)) {
                        return file3;
                    }
                }
                return file2;
            }
            if (!file2.getParentFile().exists()) {
                d.a(bufferedInputStream2);
                d.a(bufferedOutputStream);
                d.a(fileOutputStream);
                this.f.b(this.m);
                throw new IOException("parent be deleted!");
            }
            bufferedOutputStream.write(bArr, 0, read);
            j += read;
            if (c()) {
                return null;
            }
            DownloadCallback downloadCallback2 = this.b;
            if (downloadCallback2 != null) {
                bufferedInputStream = bufferedInputStream2;
                downloadCallback2.y(this.k.g(), this.h, j, j2);
            } else {
                bufferedInputStream = bufferedInputStream2;
            }
            bufferedInputStream2 = bufferedInputStream;
        }
    }

    private void e() {
        if (this.k != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(new b(this)).start();
            } else {
                this.k.a();
            }
        }
    }

    private synchronized void f() {
        DownloadCallback downloadCallback;
        if (!this.l && this.e.get() && (downloadCallback = this.b) != null) {
            downloadCallback.e();
        }
    }

    private synchronized void g() {
        DownloadCallback downloadCallback;
        if (!this.l && this.e.get() && (downloadCallback = this.b) != null) {
            downloadCallback.u();
        }
    }

    public void a(a aVar) {
    }

    public boolean a() {
        jl.a.a.d("book", "cancel by tag");
        this.e.set(true);
        f();
        e();
        return c();
    }

    public Object b() {
        return this.g;
    }

    public boolean c() {
        return this.e.get();
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull c cVar) {
        return 0;
    }

    public boolean d() {
        this.e.set(true);
        e();
        boolean z = this.e.get();
        if (z) {
            g();
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean exists;
        long length;
        DownloadCallback downloadCallback;
        DownloadCallback downloadCallback2;
        if (c()) {
            return;
        }
        DownloadCallback downloadCallback3 = this.b;
        if (downloadCallback3 != null) {
            downloadCallback3.a();
        }
        f d = this.a.d();
        this.k = d;
        try {
            File a = a(d);
            if (a == null || !a.exists() || a.length() <= 0) {
                if (!c() && (downloadCallback = this.b) != null) {
                    downloadCallback.w(d.g(), this.h, "file is null");
                }
            } else if (!c() && (downloadCallback2 = this.b) != null) {
                downloadCallback2.A(d.g(), this.h, a);
            }
        } finally {
            try {
                if (exists) {
                    if ((length > r1 ? 1 : (length == r1 ? 0 : -1)) > 0) {
                        d.a();
                        if (c()) {
                        }
                    }
                }
                d.a();
                if (c()) {
                }
            } catch (Throwable th2) {
            }
        }
        d.a();
        if (c()) {
            return;
        }
        DownloadCallback downloadCallback4 = this.b;
        if (downloadCallback4 != null) {
            downloadCallback4.b();
        }
        this.l = true;
    }
}
