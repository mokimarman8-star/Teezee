package com.tmc.network.strategy;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.tmc.network.HttpClient;
import com.tmc.network.HttpRequestor;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class c {
    private String a;
    private final a b;

    public static final class a implements Callback {
        a() {
        }

        public void onFailure(Call call, IOException iOException) {
            Intrinsics.h(call, "call");
            Intrinsics.h(iOException, "e");
            rf.b.a.c("pre connect onFailure");
        }

        public void onResponse(Call call, Response response) {
            Intrinsics.h(call, "call");
            Intrinsics.h(response, "response");
            rf.b.a.c("pre connect success");
        }
    }

    public c(String str) {
        Intrinsics.h(str, "url");
        this.a = str;
        this.b = new a();
    }

    public final void a() {
        HttpClient httpClient;
        OkHttpClient okHttpClient;
        Call newCall;
        try {
            Request build = new Request.Builder().url(this.a).header("isPre", "true").head().build();
            HttpRequestor companion = HttpRequestor.INSTANCE.getInstance();
            if (companion != null && (httpClient = companion.getHttpClient()) != null && (okHttpClient = httpClient.getOkHttpClient()) != null && (newCall = okHttpClient.newCall(build)) != null) {
                FirebasePerfOkHttpClient.enqueue(newCall, this.b);
            }
            rf.b.a.c(Intrinsics.q("pre connect start url = ", this.a));
        } catch (Throwable th) {
            rf.b.a.e(th);
        }
    }
}
