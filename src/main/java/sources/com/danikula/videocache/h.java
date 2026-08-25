package com.danikula.videocache;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class h {
    private final r7.b a;
    private o b;
    private HttpURLConnection c;
    private InputStream d;

    public h(String str) {
        this(str, new r7.a());
    }

    public h(String str, r7.b bVar) {
        this.a = (r7.b) l.c(bVar);
        this.b = new o(str, -2147483648L, n.d(str));
    }

    private long b(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private void c(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry entry : this.a.a(str).entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
    }

    private HttpURLConnection e(long j, int i) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.b.a;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (j > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            q.a(sb.toString());
            httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str2).openConnection()));
            c(httpURLConnection, str2);
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str2 = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    private long g(HttpURLConnection httpURLConnection, long j, int i) {
        long b = b(httpURLConnection);
        return i == 200 ? b : i == 206 ? b + j : this.b.b;
    }

    public void a() {
        HttpURLConnection httpURLConnection = this.c;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                q.b("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    public void d(long j) {
        try {
            HttpURLConnection e = e(j, -1);
            this.c = e;
            String contentType = e.getContentType();
            this.d = new BufferedInputStream(this.c.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.c;
            this.b = new o(this.b.a, g(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening connection for " + this.b.a + " with offset " + j, e2);
        }
    }

    public int f(byte[] bArr) {
        InputStream inputStream = this.d;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.b.a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new InterruptedProxyCacheException("Reading source " + this.b.a + " is interrupted", e);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading data from " + this.b.a, e2);
        }
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.b + "}";
    }
}
