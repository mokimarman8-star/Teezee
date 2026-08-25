package com.elvishew.xlog.printer.file;

import g8.c;
import h8.a;
import j8.b;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class FilePrinter implements c {
    private final String a;
    private final b b;
    private final a c;
    private final i8.a d;
    private t7.c e;
    private k8.b f;
    private volatile Worker g = new Worker();

    private class Worker implements Runnable {
        private BlockingQueue<c> logs;
        private volatile boolean started;

        private Worker() {
            this.logs = new LinkedBlockingQueue();
        }

        void enqueue(c cVar) {
            try {
                this.logs.put(cVar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        boolean isStarted() {
            boolean z;
            synchronized (this) {
                z = this.started;
            }
            return z;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    c take = this.logs.take();
                    if (take == null) {
                        return;
                    } else {
                        FilePrinter.this.e(take.a, take.b, take.c, take.d);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    synchronized (this) {
                        this.started = false;
                        return;
                    }
                }
            }
        }

        void start() {
            synchronized (this) {
                try {
                    if (this.started) {
                        return;
                    }
                    new Thread(this).start();
                    this.started = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    FilePrinter(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        c();
    }

    private void c() {
        File file = new File(this.a);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private void d() {
        File[] listFiles = new File(this.a).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (this.d.a(file)) {
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j, int i, String str, String str2) {
        String d = this.f.d();
        boolean e = this.f.e();
        if (d == null || !e || this.b.b()) {
            String a = this.b.a(i, System.currentTimeMillis());
            if (a == null || a.trim().length() == 0) {
                d8.b.e().c("File name should not be empty, ignore log: " + str2);
                return;
            }
            if (!a.equals(d) || !e) {
                this.f.b();
                d();
                if (!this.f.f(new File(this.a, a))) {
                    return;
                } else {
                    d = a;
                }
            }
        }
        File c = this.f.c();
        if (this.c.b(c)) {
            this.f.b();
            e8.b.a(c, this.c);
            if (!this.f.f(new File(this.a, d))) {
                return;
            }
        }
        this.f.a(this.e.a(j, i, str, str2).toString());
    }

    public void a(int i, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.g.isStarted()) {
            this.g.start();
        }
        this.g.enqueue(new c(currentTimeMillis, i, str, str2));
    }
}
