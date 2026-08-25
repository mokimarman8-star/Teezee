package com.danikula.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class g {
    private final AtomicInteger a = new AtomicInteger(0);
    private final String b;
    private volatile e c;
    private final List d;
    private final b e;
    private final c f;

    private static final class a extends Handler implements b {
        private final String a;
        private final List b;

        public a(String str, List list) {
            super(Looper.getMainLooper());
            this.a = str;
            this.b = list;
        }

        @Override // com.danikula.videocache.b
        public void a(String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(this.a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.d = copyOnWriteArrayList;
        this.b = (String) l.c(str);
        this.f = (c) l.c(cVar);
        this.e = new a(str, copyOnWriteArrayList);
    }

    private e c() {
        e eVar = new e(this.f.c);
        this.f.c.B();
        eVar.l(this.e);
        return eVar;
    }

    private synchronized void e() {
        try {
            this.c = this.c == null ? c() : this.c;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a() {
        try {
            if (this.a.decrementAndGet() <= 0) {
                if (this.c != null) {
                    this.c.e();
                }
                this.c = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int b() {
        return this.a.get();
    }

    public void d(d dVar, Socket socket) {
        e();
        try {
            this.a.incrementAndGet();
            this.c.f();
            this.c.k(dVar, socket);
        } finally {
            q.f("processRequest， shutdown, threadName = " + Thread.currentThread().getName());
            a();
        }
    }

    public void f() {
        if (this.c != null) {
            this.c.g();
        }
    }
}
