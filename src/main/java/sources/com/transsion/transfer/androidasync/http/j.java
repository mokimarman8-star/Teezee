package com.transsion.transfer.androidasync.http;

import android.net.Uri;
import android.util.Log;
import com.transsion.transfer.androidasync.AsyncSSLException;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class j {
    private String a;
    private String b;
    Uri c;
    private Headers d;
    private boolean e;
    private tt.a f;
    int g;
    String h;
    int i;
    String j;
    int k;
    long l;

    class a implements y {
        a() {
        }

        public String toString() {
            j jVar = j.this;
            if (jVar.h != null) {
                return String.format(Locale.ENGLISH, "%s %s %s", jVar.b, j.this.p(), j.this.a);
            }
            String k = jVar.k();
            if (k == null || k.length() == 0) {
                k = "/";
            }
            String encodedQuery = j.this.p().getEncodedQuery();
            if (encodedQuery != null && encodedQuery.length() != 0) {
                k = k + "?" + encodedQuery;
            }
            return String.format(Locale.ENGLISH, "%s %s %s", j.this.b, k, j.this.a);
        }
    }

    public j(Uri uri, String str) {
        this(uri, str, null);
    }

    public j(Uri uri, String str, Headers headers) {
        this.a = "HTTP/1.1";
        this.d = new Headers();
        this.e = true;
        this.g = 5000;
        this.i = -1;
        this.b = str;
        this.c = uri;
        if (headers == null) {
            this.d = new Headers();
        } else {
            this.d = headers;
        }
        if (headers == null) {
            x(this.d, uri);
        }
    }

    protected static String f() {
        String property = System.getProperty("http.agent");
        if (property != null) {
            return property;
        }
        return "Java" + System.getProperty("java.version");
    }

    private String i(String str) {
        return String.format(Locale.ENGLISH, "(%d ms) %s: %s", Long.valueOf(this.l != 0 ? System.currentTimeMillis() - this.l : 0L), p(), str);
    }

    public static void x(Headers headers, Uri uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (uri.getPort() != -1) {
                host = host + ":" + uri.getPort();
            }
            if (host != null) {
                headers.f("Host", host);
            }
        }
        headers.f("User-Agent", f());
        headers.f("Accept-Encoding", "gzip, deflate");
        headers.f("Connection", "keep-alive");
        headers.f("Accept", "*/*");
    }

    public j c(String str, String str2) {
        h().a(str, str2);
        return this;
    }

    public void d(String str, int i) {
        this.h = str;
        this.i = i;
    }

    public tt.a e() {
        return this.f;
    }

    public boolean g() {
        return this.e;
    }

    public Headers h() {
        return this.d;
    }

    public String j() {
        return this.b;
    }

    public String k() {
        return p().getEncodedPath();
    }

    public String l() {
        return this.h;
    }

    public int m() {
        return this.i;
    }

    public y n() {
        return new a();
    }

    public int o() {
        return this.g;
    }

    public Uri p() {
        return this.c;
    }

    public boolean q() {
        return true;
    }

    public void r(String str) {
        if (this.j != null && this.k <= 3) {
            i(str);
        }
    }

    public void s(String str, Exception exc) {
        String str2 = this.j;
        if (str2 != null && this.k <= 6) {
            Log.e(str2, i(str));
            Log.e(this.j, exc.getMessage(), exc);
        }
    }

    public void t(String str) {
        if (this.j != null && this.k <= 4) {
            i(str);
        }
    }

    public String toString() {
        Headers headers = this.d;
        return headers == null ? super.toString() : headers.g(this.c.toString());
    }

    public void u(String str) {
        String str2 = this.j;
        if (str2 != null && this.k <= 2) {
            Log.v(str2, i(str));
        }
    }

    public void v(AsyncSSLException asyncSSLException) {
    }

    public void w(tt.a aVar) {
        this.f = aVar;
    }

    public j y(int i) {
        this.g = i;
        return this;
    }
}
