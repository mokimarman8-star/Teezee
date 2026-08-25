package com.bytedance.sdk.component.HiB.sP;

import android.util.Log;
import com.bytedance.sdk.component.HiB.HiB;
import com.bytedance.sdk.component.utils.TEQ;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj implements com.bytedance.sdk.component.HiB.EjP<TKC> {
    private Map<String, String> Sj(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list != null && list.size() > 0) {
                hashMap.put(str, list.get(0));
            }
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    @Override // com.bytedance.sdk.component.HiB.EjP
    /* renamed from: sP, reason: merged with bridge method [inline-methods] */
    public TKC<byte[]> Sj(HiB hiB) {
        Closeable closeable;
        InputStream inputStream;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        String message;
        Closeable closeable2;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2 = null;
        Map<String, String> map = null;
        int i = 0;
        try {
            try {
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(hiB.Sj()).openConnection()));
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr2 = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (MalformedURLException e) {
                        e = e;
                        bArr = null;
                    } catch (IOException e2) {
                        e = e2;
                        bArr = null;
                    }
                }
                i = 200;
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    map = hiB.sP() ? Sj(httpURLConnection) : null;
                    TEQ.Sj(inputStream);
                    TEQ.Sj(byteArrayOutputStream);
                    message = "success";
                } catch (MalformedURLException e3) {
                    e = e3;
                    Log.w("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                    message = e.getMessage();
                    closeable2 = byteArrayOutputStream;
                    TEQ.Sj(inputStream);
                    TEQ.Sj(closeable2);
                    return new TKC<>(i, bArr, message, map);
                } catch (IOException e4) {
                    e = e4;
                    Log.w("InternalHttpClient", "IOException:" + e.getMessage());
                    message = e.getMessage();
                    closeable2 = byteArrayOutputStream;
                    TEQ.Sj(inputStream);
                    TEQ.Sj(closeable2);
                    return new TKC<>(i, bArr, message, map);
                }
            } catch (MalformedURLException e8) {
                e = e8;
                bArr = null;
                byteArrayOutputStream = bArr;
                Log.w("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                TEQ.Sj(inputStream);
                TEQ.Sj(closeable2);
                return new TKC<>(i, bArr, message, map);
            } catch (IOException e9) {
                e = e9;
                bArr = null;
                byteArrayOutputStream = bArr;
                Log.w("InternalHttpClient", "IOException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                TEQ.Sj(inputStream);
                TEQ.Sj(closeable2);
                return new TKC<>(i, bArr, message, map);
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                inputStream2 = inputStream;
                TEQ.Sj(inputStream2);
                TEQ.Sj(closeable);
                throw th;
            }
        } catch (MalformedURLException e10) {
            e = e10;
            inputStream = null;
            bArr = null;
        } catch (IOException e11) {
            e = e11;
            inputStream = null;
            bArr = null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            TEQ.Sj(inputStream2);
            TEQ.Sj(closeable);
            throw th;
        }
        return new TKC<>(i, bArr, message, map);
    }
}
