package n8;

import android.util.Log;
import java.net.HttpURLConnection;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class e {
    private int a;
    private String b;
    private Map c;
    private byte[] d;

    public e(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.a = httpURLConnection.getResponseCode();
            this.b = httpURLConnection.getURL().toString();
            this.c = httpURLConnection.getHeaderFields();
        } catch (Throwable th) {
            Log.e("HttpResponse", "Failed to createHttpResponse", th);
        }
        this.d = bArr;
    }

    public int a() {
        return this.a;
    }
}
