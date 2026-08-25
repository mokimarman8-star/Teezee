package il;

import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.transsion.http.d.h;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class f implements Cloneable {
    protected final e a;
    private HttpURLConnection b = null;
    private InputStream c = null;
    private int d = 480;

    public f(e eVar) {
        this.a = eVar;
    }

    public void a() {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            kl.d.a(inputStream);
            this.c = null;
        }
        HttpURLConnection httpURLConnection = this.b;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public long b() {
        int available;
        HttpURLConnection httpURLConnection = this.b;
        long j = 0;
        try {
            if (httpURLConnection != null) {
                try {
                    j = httpURLConnection.getContentLength();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                if (j >= 1) {
                    return j;
                }
                available = c().available();
            } else {
                available = c().available();
            }
            j = available;
            return j;
        } catch (Throwable unused) {
            return j;
        }
    }

    public InputStream c() {
        HttpURLConnection httpURLConnection = this.b;
        if (httpURLConnection != null && this.c == null) {
            this.c = httpURLConnection.getResponseCode() >= 400 ? this.b.getErrorStream() : this.b.getInputStream();
        }
        return this.c;
    }

    public e e() {
        return this.a;
    }

    public int g() {
        if (this.b != null) {
            return this.d;
        }
        return 404;
    }

    public void i() {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new el.c(this.a.n()).b().openConnection()));
        this.b = httpURLConnection;
        httpURLConnection.setReadTimeout(this.a.j());
        this.b.setConnectTimeout(this.a.a());
        HttpURLConnection httpURLConnection2 = this.b;
        if (httpURLConnection2 instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(this.a.l());
            ((HttpsURLConnection) this.b).setHostnameVerifier(this.a.g());
        }
        h h = this.a.h();
        this.b.setRequestMethod(h.toString());
        if (this.a.f() != null) {
            for (String str : this.a.f().keySet()) {
                this.b.setRequestProperty(str, (String) this.a.f().get(str));
            }
        }
        if (h == h.b || h == h.c || h == h.d || h == h.h) {
            this.b.setRequestProperty("connection", "Keep-Alive");
            this.b.setRequestProperty("charset", "utf-8");
            this.b.setRequestProperty("Content-Type", this.a.d().toString());
            long length = this.a.c().getBytes().length;
            if (length < 0) {
                this.b.setChunkedStreamingMode(262144);
            } else if (length < 2147483647L) {
                this.b.setFixedLengthStreamingMode((int) length);
            } else {
                this.b.setFixedLengthStreamingMode(length);
            }
            this.b.setRequestProperty("Content-Length", String.valueOf(length));
            this.b.setDoOutput(true);
            OutputStream outputStream = this.b.getOutputStream();
            this.d = 481;
            outputStream.write(this.a.c().getBytes());
            outputStream.flush();
            outputStream.close();
        }
        int responseCode = this.b.getResponseCode();
        this.d = responseCode;
        if (302 == responseCode || 301 == responseCode) {
            String headerField = this.b.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                return;
            }
            a();
            this.a.b(headerField);
            i();
        }
    }
}
