package v4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private final HttpURLConnection f18073a;

    public a(HttpURLConnection httpURLConnection) {
        this.f18073a = httpURLConnection;
    }

    private String b(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    @Override // v4.c
    public InputStream M() {
        return this.f18073a.getInputStream();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18073a.disconnect();
    }

    @Override // v4.c
    public String error() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.f18073a.getURL() + ". Failed with " + this.f18073a.getResponseCode() + "\n" + b(this.f18073a);
        } catch (IOException e5) {
            x4.f.d("get error failed ", e5);
            return e5.getMessage();
        }
    }

    @Override // v4.c
    public boolean isSuccessful() {
        try {
            return this.f18073a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // v4.c
    public String z() {
        return this.f18073a.getContentType();
    }
}
