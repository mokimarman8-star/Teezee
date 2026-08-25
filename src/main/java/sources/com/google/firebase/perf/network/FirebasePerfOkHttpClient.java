package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.i;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import wc.f;
import xc.k;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class FirebasePerfOkHttpClient {
    static void a(Response response, i iVar, long j, long j2) {
        Request request = response.request();
        if (request == null) {
            return;
        }
        iVar.q(request.url().url().toString());
        iVar.f(request.method());
        if (request.body() != null) {
            long contentLength = request.body().contentLength();
            if (contentLength != -1) {
                iVar.j(contentLength);
            }
        }
        ResponseBody body = response.body();
        if (body != null) {
            long contentLength2 = body.contentLength();
            if (contentLength2 != -1) {
                iVar.m(contentLength2);
            }
            MediaType contentType = body.contentType();
            if (contentType != null) {
                iVar.l(contentType.toString());
            }
        }
        iVar.g(response.code());
        iVar.k(j);
        iVar.o(j2);
        iVar.a();
    }

    @Keep
    public static void enqueue(Call call, Callback callback) {
        Timer timer = new Timer();
        call.enqueue(new d(callback, k.k(), timer, timer.getMicros()));
    }

    @Keep
    public static Response execute(Call call) throws IOException {
        i b = i.b(k.k());
        Timer timer = new Timer();
        long micros = timer.getMicros();
        try {
            Response execute = call.execute();
            a(execute, b, micros, timer.getDurationMicros());
            return execute;
        } catch (IOException e) {
            Request request = call.request();
            if (request != null) {
                HttpUrl url = request.url();
                if (url != null) {
                    b.q(url.url().toString());
                }
                if (request.method() != null) {
                    b.f(request.method());
                }
            }
            b.k(micros);
            b.o(timer.getDurationMicros());
            f.d(b);
            throw e;
        }
    }
}
