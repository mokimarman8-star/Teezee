package com.danikula.videocache;

import com.transsnet.downloader.util.h;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class HttpProxyCacheServer {
    private final Object a;
    private final ExecutorService b;
    private final Map c;
    private ServerSocket d;
    private int e;
    private Thread f;
    private c g;
    private j h;

    private final class WaitRequestsRunnable implements Runnable {
        private final CountDownLatch startSignal;

        public WaitRequestsRunnable(CountDownLatch countDownLatch) {
            this.startSignal = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.startSignal.countDown();
            HttpProxyCacheServer.this.p();
        }
    }

    private HttpProxyCacheServer(c cVar) {
        this.a = new Object();
        this.b = Executors.newFixedThreadPool(8);
        this.c = new ConcurrentHashMap();
        this.g = (c) l.c(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.e = localPort;
            i.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new WaitRequestsRunnable(countDownLatch));
            this.f = thread;
            thread.start();
            countDownLatch.await();
            this.h = new j("127.0.0.1", this.e);
            q.a("init success");
        } catch (Throwable unused) {
            this.b.shutdown();
        }
    }

    /* synthetic */ HttpProxyCacheServer(c cVar, f fVar) {
        this(cVar);
    }

    private String c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.e), n.c(str));
    }

    private void d(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            m(new ProxyCacheException("Error closing socket", e));
        }
    }

    private void e(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            q.a("Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            m(new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    private void f(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            q.f("Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private g h(String str) {
        g gVar;
        synchronized (this.a) {
            try {
                gVar = (g) this.c.get(str);
                if (gVar == null) {
                    gVar = new g(str, this.g);
                    this.c.put(str, gVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    private int i() {
        int i;
        synchronized (this.a) {
            try {
                Iterator it = this.c.values().iterator();
                i = 0;
                while (it.hasNext()) {
                    i += ((g) it.next()).b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    private boolean l() {
        return this.h.e(3, 70);
    }

    private void m(Throwable th) {
        q.b("HttpProxyCacheServer error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.danikula.videocache.HttpProxyCacheServer] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.StringBuilder] */
    public void n(Socket socket, d dVar) {
        g gVar = null;
        try {
            try {
                String b = n.b(dVar.a);
                q.a("Request to cache proxy， " + Thread.currentThread().getName() + "， " + dVar + ", url = " + b);
                if (this.h.d(b)) {
                    this.h.g((Socket) socket);
                } else {
                    gVar = h(b);
                    gVar.d(dVar, (Socket) socket);
                }
                o(socket);
                if (gVar != null) {
                    gVar.f();
                }
                socket = new StringBuilder();
            } catch (Throwable th) {
                o(socket);
                if (0 != 0) {
                    gVar.f();
                }
                q.a("Opened connections: " + i());
                throw th;
            }
        } catch (SocketException unused) {
            q.a("Closing socket… Socket is closed by client.");
            o(socket);
            if (0 != 0) {
                gVar.f();
            }
            socket = new StringBuilder();
            socket.append("Opened connections: ");
            socket.append(i());
            q.a(socket.toString());
        } catch (Throwable th2) {
            m(new ProxyCacheException("Error processing request", th2));
            o(socket);
            if (0 != 0) {
                gVar.f();
            }
            socket = new StringBuilder();
            socket.append("Opened connections: ");
            socket.append(i());
            q.a(socket.toString());
        }
        socket.append("Opened connections: ");
        socket.append(i());
        q.a(socket.toString());
    }

    private void o(Socket socket) {
        e(socket);
        f(socket);
        d(socket);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            q.a("waitForRequest~ isInterrupted = " + Thread.currentThread().isInterrupted());
            while (!Thread.currentThread().isInterrupted()) {
                Socket accept = this.d.accept();
                q.c("Accept new socket " + accept);
                d c = d.c(accept.getInputStream());
                String b = n.b(c.a);
                g gVar = (g) this.c.get(b);
                if (gVar != null) {
                    gVar.f();
                }
                if (!this.h.d(b)) {
                    h.a.b("3");
                }
                this.b.submit((Runnable) new SocketProcessorRunnable(this, accept, c));
            }
        } catch (Throwable th) {
            q.c("waitForRequest error = " + th.toString());
            m(new ProxyCacheException("Error during waiting connection", th));
        }
    }

    public void g() {
        synchronized (this.a) {
            try {
                Iterator it = this.c.values().iterator();
                while (it.hasNext()) {
                    ((g) it.next()).a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String j(String str, String str2, boolean z) {
        return k(str, str2, false, z);
    }

    public String k(String str, String str2, boolean z, boolean z2) {
        return (!z2 || l()) ? c(str) : str;
    }
}
