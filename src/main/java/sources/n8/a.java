package n8;

import android.util.Log;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.facebook.biddingkit.http.client.HttpMethod;
import com.facebook.biddingkit.http.client.HttpRequestException;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class a {
    private Set d;
    private Set e;
    protected int a = 2000;
    protected int b = 8000;
    protected String c = TmcConstants.DEFAULT_ENCODING;
    private int f = 3;
    private boolean g = false;
    private Map h = new TreeMap();

    private void a(HttpURLConnection httpURLConnection) {
        for (String str : this.h.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.h.get(str));
        }
        httpURLConnection.setRequestProperty("Accept-Charset", this.c);
    }

    private int d(int i) {
        return (i <= 1 || i > 20) ? i : d(i - 1) + d(i - 2);
    }

    private byte[] n(InputStream inputStream) {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Type inference failed for: r4v0, types: [n8.a] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected e b(String str, HttpMethod httpMethod, String str2, byte[] bArr) {
        boolean z = false;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                this.g = false;
                HttpURLConnection i = i(str);
                try {
                    k(i, httpMethod, str2);
                    a(i);
                    i.connect();
                    this.g = true;
                    Set set = this.e;
                    boolean z2 = (set == null || set.isEmpty()) ? false : true;
                    Set set2 = this.d;
                    if (set2 != null && !set2.isEmpty()) {
                        z = true;
                    }
                    if ((i instanceof HttpsURLConnection) && (z2 || z)) {
                        try {
                            f.b((HttpsURLConnection) i, this.e, this.d);
                        } catch (Exception e) {
                            Log.e("AndroidHttpClient", "Unable to validate SSL certificates: ", e);
                        }
                    }
                    if (i.getDoOutput() && bArr != null) {
                        t(i, bArr);
                    }
                    e m = i.getDoInput() ? m(i) : new e(i, null);
                    i.disconnect();
                    return m;
                } catch (Exception e2) {
                    e = e2;
                    str = i;
                    try {
                        e l = l(str);
                        if (l == null || l.a() <= 0) {
                            throw new HttpRequestException(e, l);
                        }
                        if (str != 0) {
                            str.disconnect();
                        }
                        return l;
                    } catch (Exception unused) {
                        Log.e("AndroidHttpClient", "Failed http method: ", e);
                        throw new HttpRequestException(e, null);
                    }
                }
            } catch (Throwable th) {
                th = th;
                httpURLConnection = str;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            str = 0;
        } catch (Throwable th2) {
            th = th2;
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    public e c(d dVar) {
        try {
            return s(dVar);
        } catch (HttpRequestException e) {
            Log.e("AndroidHttpClient", "Unable to send request and got a HttpRequestException: ", e);
            return null;
        } catch (Exception e2) {
            Log.e("AndroidHttpClient", "Unable to send request and got a RuntimeException: ", new HttpRequestException(e2, null));
            return null;
        }
    }

    public e e(String str, Map map) {
        return c(new b(str, map));
    }

    protected int f(int i) {
        return d(i + 2) * 1000;
    }

    public boolean g(HttpRequestException httpRequestException) {
        e httpResponse = httpRequestException.getHttpResponse();
        return httpResponse != null && httpResponse.a() > 0;
    }

    protected boolean h(Throwable th, long j) {
        long currentTimeMillis = (System.currentTimeMillis() - j) + 10;
        return this.g ? currentTimeMillis >= ((long) this.b) : currentTimeMillis >= ((long) this.a);
    }

    protected HttpURLConnection i(String str) {
        try {
            return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(str + " is not a valid URL", e);
        }
    }

    public e j(String str, String str2, byte[] bArr) {
        return c(new c(str, null, str2, bArr));
    }

    protected void k(HttpURLConnection httpURLConnection, HttpMethod httpMethod, String str) {
        httpURLConnection.setConnectTimeout(this.a);
        httpURLConnection.setReadTimeout(this.b);
        httpURLConnection.setRequestMethod(httpMethod.getMethodName());
        httpURLConnection.setDoOutput(httpMethod.getDoOutput());
        httpURLConnection.setDoInput(httpMethod.getDoInput());
        if (str != null) {
            httpURLConnection.setRequestProperty("Content-Type", str);
        }
    }

    protected e l(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        byte[] n = null;
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                try {
                    n = n(errorStream);
                } catch (Throwable th) {
                    th = th;
                    inputStream = errorStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            }
            e eVar = new e(httpURLConnection, n);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused2) {
                }
            }
            return eVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    protected e m(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        byte[] n = null;
        try {
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (inputStream2 != null) {
                try {
                    n = n(inputStream2);
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            }
            e eVar = new e(httpURLConnection, n);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
            }
            return eVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void o(int i) {
        this.a = i;
    }

    public void p(Set set) {
        this.e = set;
    }

    public void q(Set set) {
        this.d = set;
    }

    public void r(int i) {
        this.b = i;
    }

    public e s(d dVar) {
        long currentTimeMillis = System.currentTimeMillis();
        e eVar = null;
        for (int i = 0; i < this.f; i++) {
            try {
                o(f(i));
                currentTimeMillis = System.currentTimeMillis();
                eVar = b(dVar.d(), dVar.c(), dVar.b(), dVar.a());
            } catch (HttpRequestException e) {
                if (h(e, currentTimeMillis) && i < this.f - 1) {
                    continue;
                } else {
                    if (!g(e) || i >= this.f - 1) {
                        Log.e("AndroidHttpClient", "Unable to send request: ", e);
                        break;
                    }
                    try {
                        Thread.sleep(this.a);
                    } catch (InterruptedException e2) {
                        Log.e("AndroidHttpClient", "App is stopping: ", e2);
                    }
                }
            }
            if (eVar != null) {
                return eVar;
            }
        }
        return eVar;
    }

    protected int t(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream;
        try {
            outputStream = httpURLConnection.getOutputStream();
            if (outputStream != null) {
                try {
                    outputStream.write(bArr);
                } catch (Throwable th) {
                    th = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
            }
            return responseCode;
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
    }
}
