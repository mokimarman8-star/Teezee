package com.squareup.okhttp.internal;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class DiskLruCache implements Closeable {
    static final Pattern s = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final Sink t = new c();
    private final FileSystem a;
    private final File b;
    private final File c;
    private final File d;
    private final File e;
    private final int f;
    private long g;
    private final int h;
    private BufferedSink j;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private final Executor q;
    private long i = 0;
    private final LinkedHashMap k = new LinkedHashMap(0, 0.75f, true);
    private long p = 0;
    private final Runnable r = new Runnable() { // from class: com.squareup.okhttp.internal.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskLruCache.this) {
                if ((!DiskLruCache.this.n) || DiskLruCache.this.o) {
                    return;
                }
                try {
                    DiskLruCache.this.u0();
                    if (DiskLruCache.this.f0()) {
                        DiskLruCache.this.o0();
                        DiskLruCache.this.l = 0;
                    }
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
    };

    class a extends com.squareup.okhttp.internal.b {
        a(Sink sink) {
            super(sink);
        }

        @Override // com.squareup.okhttp.internal.b
        protected void b(IOException iOException) {
            DiskLruCache.this.m = true;
        }
    }

    class b implements Iterator {
        final Iterator a;
        f b;
        f c;

        b() {
            this.a = new ArrayList(DiskLruCache.this.k.values()).iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            f fVar = this.b;
            this.c = fVar;
            this.b = null;
            return fVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b != null) {
                return true;
            }
            synchronized (DiskLruCache.this) {
                try {
                    if (DiskLruCache.this.o) {
                        return false;
                    }
                    while (this.a.hasNext()) {
                        f n = ((e) this.a.next()).n();
                        if (n != null) {
                            this.b = n;
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            f fVar = this.c;
            if (fVar == null) {
                throw new IllegalStateException("remove() before next()");
            }
            try {
                DiskLruCache.this.p0(fVar.a);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.c = null;
                throw th;
            }
            this.c = null;
        }
    }

    static class c implements Sink {
        c() {
        }

        public void close() {
        }

        public void flush() {
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }

        public void write(Buffer buffer, long j) {
            buffer.skip(j);
        }
    }

    public final class d {
        private final e a;
        private final boolean[] b;
        private boolean c;
        private boolean d;

        class a extends com.squareup.okhttp.internal.b {
            a(Sink sink) {
                super(sink);
            }

            @Override // com.squareup.okhttp.internal.b
            protected void b(IOException iOException) {
                synchronized (DiskLruCache.this) {
                    d.this.c = true;
                }
            }
        }

        private d(e eVar) {
            this.a = eVar;
            this.b = eVar.e ? null : new boolean[DiskLruCache.this.h];
        }

        public void a() {
            synchronized (DiskLruCache.this) {
                DiskLruCache.this.v(this, false);
            }
        }

        public void e() {
            synchronized (DiskLruCache.this) {
                try {
                    if (this.c) {
                        DiskLruCache.this.v(this, false);
                        DiskLruCache.this.r0(this.a);
                    } else {
                        DiskLruCache.this.v(this, true);
                    }
                    this.d = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public Sink f(int i) {
            a aVar;
            synchronized (DiskLruCache.this) {
                try {
                    if (this.a.f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.a.e) {
                        this.b[i] = true;
                    }
                    try {
                        aVar = new a(DiskLruCache.this.a.sink(this.a.d[i]));
                    } catch (FileNotFoundException unused) {
                        return DiskLruCache.t;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }
    }

    private final class e {
        private final String a;
        private final long[] b;
        private final File[] c;
        private final File[] d;
        private boolean e;
        private d f;
        private long g;

        private e(String str) {
            this.a = str;
            this.b = new long[DiskLruCache.this.h];
            this.c = new File[DiskLruCache.this.h];
            this.d = new File[DiskLruCache.this.h];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i = 0; i < DiskLruCache.this.h; i++) {
                sb2.append(i);
                this.c[i] = new File(DiskLruCache.this.b, sb2.toString());
                sb2.append(".tmp");
                this.d[i] = new File(DiskLruCache.this.b, sb2.toString());
                sb2.setLength(length);
            }
        }

        private IOException l(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(String[] strArr) {
            if (strArr.length != DiskLruCache.this.h) {
                throw l(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw l(strArr);
                }
            }
        }

        f n() {
            Closeable closeable;
            if (!Thread.holdsLock(DiskLruCache.this)) {
                throw new AssertionError();
            }
            Closeable[] closeableArr = new Source[DiskLruCache.this.h];
            long[] jArr = (long[]) this.b.clone();
            for (int i = 0; i < DiskLruCache.this.h; i++) {
                try {
                    closeableArr[i] = DiskLruCache.this.a.source(this.c[i]);
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < DiskLruCache.this.h && (closeable = closeableArr[i2]) != null; i2++) {
                        g.c(closeable);
                    }
                    return null;
                }
            }
            return new f(this.a, this.g, closeableArr, jArr);
        }

        void o(BufferedSink bufferedSink) {
            for (long j : this.b) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }
    }

    public final class f implements Closeable {
        private final String a;
        private final long b;
        private final Source[] c;
        private final long[] d;

        private f(String str, long j, Source[] sourceArr, long[] jArr) {
            this.a = str;
            this.b = j;
            this.c = sourceArr;
            this.d = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Closeable closeable : this.c) {
                g.c(closeable);
            }
        }

        public d d() {
            return DiskLruCache.this.S(this.a, this.b);
        }

        public Source f(int i) {
            return this.c[i];
        }
    }

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.a = fileSystem;
        this.b = file;
        this.f = i;
        this.c = new File(file, "journal");
        this.d = new File(file, "journal.tmp");
        this.e = new File(file, "journal.bkp");
        this.h = i2;
        this.g = j;
        this.q = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized d S(String str, long j) {
        e0();
        u();
        x0(str);
        e eVar = (e) this.k.get(str);
        if (j != -1 && (eVar == null || eVar.g != j)) {
            return null;
        }
        if (eVar != null && eVar.f != null) {
            return null;
        }
        this.j.writeUtf8("DIRTY").writeByte(32).writeUtf8(str).writeByte(10);
        this.j.flush();
        if (this.m) {
            return null;
        }
        if (eVar == null) {
            eVar = new e(str);
            this.k.put(str, eVar);
        }
        d dVar = new d(eVar);
        eVar.f = dVar;
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f0() {
        int i = this.l;
        return i >= 2000 && i >= this.k.size();
    }

    private BufferedSink g0() {
        return Okio.buffer(new a(this.a.appendingSink(this.c)));
    }

    private void h0() {
        this.a.delete(this.d);
        Iterator it = this.k.values().iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            int i = 0;
            if (eVar.f == null) {
                while (i < this.h) {
                    this.i += eVar.b[i];
                    i++;
                }
            } else {
                eVar.f = null;
                while (i < this.h) {
                    this.a.delete(eVar.c[i]);
                    this.a.delete(eVar.d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    private void j0() {
        BufferedSource buffer = Okio.buffer(this.a.source(this.c));
        try {
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(readUtf8LineStrict) || !"1".equals(readUtf8LineStrict2) || !Integer.toString(this.f).equals(readUtf8LineStrict3) || !Integer.toString(this.h).equals(readUtf8LineStrict4) || !TtmlNode.ANONYMOUS_REGION_ID.equals(readUtf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    l0(buffer.readUtf8LineStrict());
                    i++;
                } catch (EOFException unused) {
                    this.l = i - this.k.size();
                    if (buffer.exhausted()) {
                        this.j = g0();
                    } else {
                        o0();
                    }
                    g.c(buffer);
                    return;
                }
            }
        } catch (Throwable th) {
            g.c(buffer);
            throw th;
        }
    }

    private void l0(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.k.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        e eVar = (e) this.k.get(substring);
        if (eVar == null) {
            eVar = new e(substring);
            this.k.put(substring, eVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            eVar.e = true;
            eVar.f = null;
            eVar.m(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            eVar.f = new d(eVar);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o0() {
        try {
            BufferedSink bufferedSink = this.j;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink buffer = Okio.buffer(this.a.sink(this.d));
            try {
                buffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
                buffer.writeUtf8("1").writeByte(10);
                buffer.writeDecimalLong(this.f).writeByte(10);
                buffer.writeDecimalLong(this.h).writeByte(10);
                buffer.writeByte(10);
                for (e eVar : this.k.values()) {
                    if (eVar.f != null) {
                        buffer.writeUtf8("DIRTY").writeByte(32);
                        buffer.writeUtf8(eVar.a);
                        buffer.writeByte(10);
                    } else {
                        buffer.writeUtf8("CLEAN").writeByte(32);
                        buffer.writeUtf8(eVar.a);
                        eVar.o(buffer);
                        buffer.writeByte(10);
                    }
                }
                buffer.close();
                if (this.a.exists(this.c)) {
                    this.a.rename(this.c, this.e);
                }
                this.a.rename(this.d, this.c);
                this.a.delete(this.e);
                this.j = g0();
                this.m = false;
            } catch (Throwable th) {
                buffer.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r0(e eVar) {
        if (eVar.f != null) {
            eVar.f.c = true;
        }
        for (int i = 0; i < this.h; i++) {
            this.a.delete(eVar.c[i]);
            this.i -= eVar.b[i];
            eVar.b[i] = 0;
        }
        this.l++;
        this.j.writeUtf8("REMOVE").writeByte(32).writeUtf8(eVar.a).writeByte(10);
        this.k.remove(eVar.a);
        if (f0()) {
            this.q.execute(this.r);
        }
        return true;
    }

    private synchronized void u() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        while (this.i > this.g) {
            r0((e) this.k.values().iterator().next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void v(d dVar, boolean z) {
        e eVar = dVar.a;
        if (eVar.f != dVar) {
            throw new IllegalStateException();
        }
        if (z && !eVar.e) {
            for (int i = 0; i < this.h; i++) {
                if (!dVar.b[i]) {
                    dVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!this.a.exists(eVar.d[i])) {
                    dVar.a();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.h; i2++) {
            File file = eVar.d[i2];
            if (!z) {
                this.a.delete(file);
            } else if (this.a.exists(file)) {
                File file2 = eVar.c[i2];
                this.a.rename(file, file2);
                long j = eVar.b[i2];
                long size = this.a.size(file2);
                eVar.b[i2] = size;
                this.i = (this.i - j) + size;
            }
        }
        this.l++;
        eVar.f = null;
        if (eVar.e || z) {
            eVar.e = true;
            this.j.writeUtf8("CLEAN").writeByte(32);
            this.j.writeUtf8(eVar.a);
            eVar.o(this.j);
            this.j.writeByte(10);
            if (z) {
                long j2 = this.p;
                this.p = 1 + j2;
                eVar.g = j2;
            }
        } else {
            this.k.remove(eVar.a);
            this.j.writeUtf8("REMOVE").writeByte(32);
            this.j.writeUtf8(eVar.a);
            this.j.writeByte(10);
        }
        this.j.flush();
        if (this.i > this.g || f0()) {
            this.q.execute(this.r);
        }
    }

    public static DiskLruCache w(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), g.s("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private void x0(String str) {
        if (s.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized void T() {
        e0();
        for (e eVar : (e[]) this.k.values().toArray(new e[this.k.size()])) {
            r0(eVar);
        }
    }

    public synchronized f W(String str) {
        e0();
        u();
        x0(str);
        e eVar = (e) this.k.get(str);
        if (eVar != null && eVar.e) {
            f n = eVar.n();
            if (n == null) {
                return null;
            }
            this.l++;
            this.j.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
            if (f0()) {
                this.q.execute(this.r);
            }
            return n;
        }
        return null;
    }

    public File X() {
        return this.b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.n && !this.o) {
                for (e eVar : (e[]) this.k.values().toArray(new e[this.k.size()])) {
                    if (eVar.f != null) {
                        eVar.f.a();
                    }
                }
                u0();
                this.j.close();
                this.j = null;
                this.o = true;
                return;
            }
            this.o = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long d0() {
        return this.g;
    }

    public synchronized void e0() {
        try {
            if (this.n) {
                return;
            }
            if (this.a.exists(this.e)) {
                if (this.a.exists(this.c)) {
                    this.a.delete(this.e);
                } else {
                    this.a.rename(this.e, this.c);
                }
            }
            if (this.a.exists(this.c)) {
                try {
                    j0();
                    h0();
                    this.n = true;
                    return;
                } catch (IOException e2) {
                    com.squareup.okhttp.internal.e.f().i("DiskLruCache " + this.b + " is corrupt: " + e2.getMessage() + ", removing");
                    x();
                    this.o = false;
                }
            }
            o0();
            this.n = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void flush() {
        if (this.n) {
            u();
            u0();
            this.j.flush();
        }
    }

    public synchronized boolean isClosed() {
        return this.o;
    }

    public synchronized boolean p0(String str) {
        e0();
        u();
        x0(str);
        e eVar = (e) this.k.get(str);
        if (eVar == null) {
            return false;
        }
        return r0(eVar);
    }

    public synchronized long s0() {
        e0();
        return this.i;
    }

    public synchronized Iterator t0() {
        e0();
        return new b();
    }

    public void x() {
        close();
        this.a.deleteContents(this.b);
    }

    public d y(String str) {
        return S(str, -1L);
    }
}
