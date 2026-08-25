package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.i;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import wc.f;
import xc.k;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class FirebasePerfUrlConnection {
    static Object a(j jVar, k kVar, Timer timer) {
        timer.reset();
        long micros = timer.getMicros();
        i b = i.b(kVar);
        try {
            URLConnection a = jVar.a();
            return a instanceof HttpsURLConnection ? new b((HttpsURLConnection) a, timer, b).getContent() : a instanceof HttpURLConnection ? new a((HttpURLConnection) a, timer, b).getContent() : a.getContent();
        } catch (IOException e) {
            b.k(micros);
            b.o(timer.getDurationMicros());
            b.q(jVar.toString());
            f.d(b);
            throw e;
        }
    }

    static Object b(j jVar, Class[] clsArr, k kVar, Timer timer) {
        timer.reset();
        long micros = timer.getMicros();
        i b = i.b(kVar);
        try {
            URLConnection a = jVar.a();
            return a instanceof HttpsURLConnection ? new b((HttpsURLConnection) a, timer, b).getContent(clsArr) : a instanceof HttpURLConnection ? new a((HttpURLConnection) a, timer, b).getContent(clsArr) : a.getContent(clsArr);
        } catch (IOException e) {
            b.k(micros);
            b.o(timer.getDurationMicros());
            b.q(jVar.toString());
            f.d(b);
            throw e;
        }
    }

    static InputStream c(j jVar, k kVar, Timer timer) {
        if (!k.k().u()) {
            return jVar.a().getInputStream();
        }
        timer.reset();
        long micros = timer.getMicros();
        i b = i.b(kVar);
        try {
            URLConnection a = jVar.a();
            return a instanceof HttpsURLConnection ? new b((HttpsURLConnection) a, timer, b).getInputStream() : a instanceof HttpURLConnection ? new a((HttpURLConnection) a, timer, b).getInputStream() : a.getInputStream();
        } catch (IOException e) {
            b.k(micros);
            b.o(timer.getDurationMicros());
            b.q(jVar.toString());
            f.d(b);
            throw e;
        }
    }

    @Keep
    public static Object getContent(URL url) throws IOException {
        return a(new j(url), k.k(), new Timer());
    }

    @Keep
    public static Object getContent(URL url, Class[] clsArr) throws IOException {
        return b(new j(url), clsArr, k.k(), new Timer());
    }

    @Keep
    public static Object instrument(Object obj) throws IOException {
        return obj instanceof HttpsURLConnection ? new b((HttpsURLConnection) obj, new Timer(), i.b(k.k())) : obj instanceof HttpURLConnection ? new a((HttpURLConnection) obj, new Timer(), i.b(k.k())) : obj;
    }

    @Keep
    public static InputStream openStream(URL url) throws IOException {
        return c(new j(url), k.k(), new Timer());
    }
}
