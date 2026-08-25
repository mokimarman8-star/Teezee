package com.bytedance.adsdk.sP.EjP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj implements EjP {
    private final HttpURLConnection Sj;

    public Sj(HttpURLConnection httpURLConnection) {
        this.Sj = httpURLConnection;
    }

    private String Sj(HttpURLConnection httpURLConnection) throws IOException {
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

    @Override // com.bytedance.adsdk.sP.EjP.EjP
    public String EjP() {
        try {
            if (Sj()) {
                return null;
            }
            return "Unable to fetch " + this.Sj.getURL() + ". Failed with " + this.Sj.getResponseCode() + "\n" + Sj(this.Sj);
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override // com.bytedance.adsdk.sP.EjP.EjP
    public boolean Sj() {
        try {
            return this.Sj.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.bytedance.adsdk.sP.EjP.EjP
    public String TKC() {
        return this.Sj.getContentType();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.Sj.disconnect();
    }

    @Override // com.bytedance.adsdk.sP.EjP.EjP
    public InputStream sP() throws IOException {
        return this.Sj.getInputStream();
    }
}
