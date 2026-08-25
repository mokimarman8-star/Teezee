package com.danikula.videocache;

import java.io.OutputStream;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
class j {
    private final ExecutorService a = Executors.newSingleThreadExecutor();
    private final String b;
    private final int c;

    private class a implements Callable {
        private a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(j.this.f());
        }
    }

    j(String str, int i) {
        this.b = (String) l.c(str);
        this.c = i;
    }

    private List b() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    private String c() {
        return String.format(Locale.US, "http://%s:%d/%s", this.b, Integer.valueOf(this.c), "ping");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        h hVar = new h(c());
        try {
            try {
                byte[] bytes = "ping ok".getBytes();
                hVar.d(0L);
                byte[] bArr = new byte[bytes.length];
                hVar.f(bArr);
                boolean equals = Arrays.equals(bytes, bArr);
                q.c("Ping response: `" + new String(bArr) + "`, pinged? " + equals);
                return equals;
            } catch (ProxyCacheException unused) {
                q.b("Error reading ping response");
                hVar.a();
                return false;
            }
        } finally {
            hVar.a();
        }
    }

    boolean d(String str) {
        return "ping".equals(str);
    }

    boolean e(int i, int i2) {
        l.a(i >= 1);
        l.a(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
            } catch (InterruptedException | ExecutionException unused) {
                q.b("Error pinging server due to unexpected error");
            } catch (TimeoutException unused2) {
                q.f("Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            }
            if (((Boolean) this.a.submit(new a()).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i3++;
            i2 *= 2;
        }
        q.b(String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), b()));
        return false;
    }

    void g(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }
}
