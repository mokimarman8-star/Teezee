package fl;

import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements Closeable {
    private final File a;
    private final File b;
    private final File c;
    private final File d;
    private final int e;
    private long f;
    private final int g;
    private Writer i;
    private int k;
    private long o;
    private long h = 0;
    private final LinkedHashMap j = new LinkedHashMap(0, 0.75f, true);
    private long l = 0;
    final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    private final Callable n = new a();

    class a implements Callable {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (f.this) {
                try {
                    if (f.this.i == null) {
                        return null;
                    }
                    f.this.T();
                    if (f.this.r()) {
                        f.this.y();
                        f.this.k = 0;
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private static final class b implements ThreadFactory {
        /* synthetic */ b(a aVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class c {
        private final d a;
        private final boolean[] b;
        private boolean c;

        /* synthetic */ c(d dVar, a aVar) {
            this.a = dVar;
            this.b = dVar.e ? null : new boolean[f.this.g];
        }

        public File b(int i) {
            File file;
            synchronized (f.this) {
                try {
                    if (this.a.f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.a.e) {
                        this.b[i] = true;
                    }
                    file = this.a.d[i];
                    if (!f.this.a.exists()) {
                        f.this.a.mkdirs();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return file;
        }

        public void c() {
            f.this.l(this, false);
        }

        public void d() {
            if (this.c) {
                return;
            }
            try {
                c();
            } catch (IOException unused) {
            }
        }

        public void f() {
            f.this.l(this, true);
            this.c = true;
        }
    }

    private final class d {
        private final String a;
        private final long[] b;
        File[] c;
        File[] d;
        private boolean e;
        private c f;
        private long g;
        private long h;

        /* synthetic */ d(String str, a aVar) {
            this.a = str;
            this.b = new long[f.this.g];
            this.c = new File[f.this.g];
            this.d = new File[f.this.g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < f.this.g; i++) {
                sb.append(i);
                this.c[i] = new File(f.this.a, sb.toString());
                sb.append(".tmp");
                this.d[i] = new File(f.this.a, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException e(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(String[] strArr) {
            if (strArr.length != f.this.g) {
                e(strArr);
                throw null;
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    e(strArr);
                    throw null;
                }
            }
        }

        public File d(int i) {
            return this.c[i];
        }

        public String f() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File j(int i) {
            return this.d[i];
        }
    }

    public final class e {
        private final File[] a;

        /* synthetic */ e(f fVar, String str, long j, File[] fileArr, long[] jArr, a aVar) {
            this.a = fileArr;
        }

        public File a(int i) {
            return this.a[i];
        }
    }

    private f(File file, int i, int i2, long j, long j2) {
        this.a = file;
        this.e = i;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.g = i2;
        this.f = j;
        this.o = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        while (this.h > this.f) {
            u((String) ((Map.Entry) this.j.entrySet().iterator().next()).getKey());
        }
    }

    private synchronized c f(String str, long j) {
        k();
        d dVar = (d) this.j.get(str);
        a aVar = null;
        if (j != -1 && (dVar == null || dVar.g != j)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(str, aVar);
            this.j.put(str, dVar);
        } else if (dVar.f != null) {
            return null;
        }
        c cVar = new c(dVar, aVar);
        dVar.f = cVar;
        this.i.append((CharSequence) "DIRTY");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        this.i.flush();
        return cVar;
    }

    public static f h(File file, int i, int i2, long j, long j2) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                o(file2, file3, false);
            }
        }
        f fVar = new f(file, i, i2, j, j2);
        if (fVar.b.exists()) {
            try {
                fVar.w();
                fVar.t();
                return fVar;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                fVar.close();
                fl.d.c(fVar.a);
            }
        }
        file.mkdirs();
        f fVar2 = new f(file, i, i2, j, j2);
        fVar2.y();
        return fVar2;
    }

    private void k() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(c cVar, boolean z) {
        d dVar = cVar.a;
        if (dVar.f != cVar) {
            throw new IllegalStateException();
        }
        if (z && !dVar.e) {
            for (int i = 0; i < this.g; i++) {
                if (!cVar.b[i]) {
                    cVar.c();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!dVar.j(i).exists()) {
                    cVar.c();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.g; i2++) {
            File j = dVar.j(i2);
            if (!z) {
                n(j);
            } else if (j.exists()) {
                File d2 = dVar.d(i2);
                j.renameTo(d2);
                long j2 = dVar.b[i2];
                long length = d2.length();
                dVar.b[i2] = length;
                this.h = (this.h - j2) + length;
            }
        }
        this.k++;
        dVar.f = null;
        if (dVar.e || z) {
            dVar.e = true;
            this.i.append((CharSequence) "CLEAN");
            this.i.append(' ');
            this.i.append((CharSequence) dVar.a);
            this.i.append((CharSequence) dVar.f());
            this.i.append(' ');
            this.i.append((CharSequence) "STAMP_");
            this.i.append((CharSequence) String.valueOf(System.currentTimeMillis()));
            this.i.append('\n');
            if (z) {
                long j3 = this.l;
                this.l = 1 + j3;
                dVar.g = j3;
            }
        } else {
            this.j.remove(dVar.a);
            this.i.append((CharSequence) "REMOVE");
            this.i.append(' ');
            this.i.append((CharSequence) dVar.a);
            this.i.append('\n');
        }
        this.i.flush();
        if (this.h > this.f || r()) {
            this.m.submit(this.n);
        }
    }

    private static void n(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void o(File file, File file2, boolean z) {
        if (z) {
            n(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    private void t() {
        n(this.c);
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i = 0;
            if (dVar.f == null) {
                while (i < this.g) {
                    this.h += dVar.b[i];
                    i++;
                }
            } else {
                dVar.f = null;
                while (i < this.g) {
                    n(dVar.d(i));
                    n(dVar.j(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private void w() {
        l lVar = new l(new FileInputStream(this.b), fl.d.a);
        try {
            String h = lVar.h();
            String h2 = lVar.h();
            String h3 = lVar.h();
            String h4 = lVar.h();
            String h5 = lVar.h();
            if (!"libcore.io.DiskLruCache".equals(h) || !MsgStyle.CUSTOM_LEFT_PIC.equals(h2) || !Integer.toString(this.e).equals(h3) || !Integer.toString(this.g).equals(h4) || !BuildConfig.FLAVOR.equals(h5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected journal header: [");
                sb.append(h);
                sb.append(", ");
                sb.append(h2);
                sb.append(", ");
                sb.append(h4);
                sb.append(", ");
                sb.append(h5);
                sb.append("]");
                throw new IOException(sb.toString());
            }
            int i = 0;
            while (true) {
                try {
                    x(lVar.h());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (lVar.d()) {
                        y();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), fl.d.a));
                    }
                    fl.d.b(lVar);
                    return;
                }
            }
        } catch (Throwable th2) {
            fl.d.b(lVar);
            throw th2;
        }
    }

    private void x(String str) {
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
                this.j.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        d dVar = (d) this.j.get(substring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(substring, aVar);
            this.j.put(substring, dVar);
        }
        if (indexOf2 == -1 || indexOf != 5 || !str.startsWith("CLEAN")) {
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f = new c(dVar, aVar);
                return;
            }
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        String[] split = str.substring(indexOf2 + 1).split(" ");
        dVar.e = true;
        dVar.f = null;
        if (!split[split.length - 1].startsWith("STAMP_")) {
            dVar.h = System.currentTimeMillis();
            dVar.k(split);
            return;
        }
        String[] strArr = new String[split.length - 1];
        for (int i2 = 0; i2 < split.length - 1; i2++) {
            strArr[i2] = split[i2];
        }
        dVar.k(strArr);
        dVar.h = Long.parseLong(split[split.length - 1].substring(6));
        if (Math.abs(System.currentTimeMillis() - dVar.h) > this.o) {
            dVar.f = new c(dVar, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void y() {
        try {
            Writer writer = this.i;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), fl.d.a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write(MsgStyle.CUSTOM_LEFT_PIC);
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.j.values()) {
                    if (dVar.f != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("DIRTY ");
                        sb.append(dVar.a);
                        sb.append('\n');
                        bufferedWriter.write(sb.toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("CLEAN ");
                        sb2.append(dVar.a);
                        sb2.append(dVar.f());
                        sb2.append(' ');
                        sb2.append("STAMP_");
                        sb2.append(dVar.h);
                        sb2.append('\n');
                        bufferedWriter.write(sb2.toString());
                    }
                }
                bufferedWriter.close();
                if (this.b.exists()) {
                    o(this.b, this.d, true);
                }
                o(this.c, this.b, false);
                this.d.delete();
                this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), fl.d.a));
            } catch (Throwable th2) {
                bufferedWriter.close();
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.i == null) {
                return;
            }
            Iterator it = new ArrayList(this.j.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f != null) {
                    dVar.f.c();
                }
            }
            T();
            this.i.close();
            this.i = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public c d(String str) {
        return f(str, -1L);
    }

    public synchronized e p(String str) {
        k();
        d dVar = (d) this.j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.e) {
            return null;
        }
        for (File file : dVar.c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) "READ");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        if (r()) {
            this.m.submit(this.n);
        }
        return new e(this, str, dVar.g, dVar.c, dVar.b, null);
    }

    public synchronized boolean u(String str) {
        try {
            k();
            d dVar = (d) this.j.get(str);
            if (dVar != null && dVar.f == null) {
                for (int i = 0; i < this.g; i++) {
                    File d2 = dVar.d(i);
                    if (d2.exists() && !d2.delete()) {
                        throw new IOException("failed to delete " + d2);
                    }
                    this.h -= dVar.b[i];
                    dVar.b[i] = 0;
                }
                this.k++;
                this.i.append((CharSequence) "REMOVE");
                this.i.append(' ');
                this.i.append((CharSequence) str);
                this.i.append('\n');
                this.j.remove(str);
                if (r()) {
                    this.m.submit(this.n);
                }
                return true;
            }
            return false;
        } finally {
        }
    }
}
