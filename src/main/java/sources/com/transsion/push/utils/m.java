package com.transsion.push.utils;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.transsion.push.bean.MsgStyle;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class m {
    public static long a(InputStream inputStream, OutputStream outputStream) {
        return b(inputStream, outputStream, 8024);
    }

    public static long b(InputStream inputStream, OutputStream outputStream, int i) {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public static byte[] c(String str, byte[] bArr) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("User-Agent", MsgStyle.SOURCE_PUSH);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.flush();
        PushLogUtils.LOG.g("response code:" + httpURLConnection.getResponseCode());
        if (httpURLConnection.getResponseCode() >= 400) {
            return null;
        }
        return d(httpURLConnection.getInputStream());
    }

    public static byte[] d(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
