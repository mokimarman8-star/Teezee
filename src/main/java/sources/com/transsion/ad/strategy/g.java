package com.transsion.ad.strategy;

import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.transsion.gslb.BuildConfig;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g {
    public static final g a = new g();

    private g() {
    }

    private final String b() {
        String simpleName = g.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final boolean a(String str, String str2) {
        InputStream byteStream;
        Intrinsics.h(str2, "destination");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Response execute = FirebasePerfOkHttpClient.execute(wh.b.a.d().newCall(new Request.Builder().url(str == null ? BuildConfig.FLAVOR : str).build()));
            if (!execute.isSuccessful()) {
                xh.a.e(xh.a.a, null, a.b() + " --> downloadFile() --> 素材加载失败 --> destination = " + str2 + " --> response = " + execute.message() + " --> url = " + str, 6, false, 9, null);
                return false;
            }
            ResponseBody body = execute.body();
            if (body == null || (byteStream = body.byteStream()) == null) {
                g gVar = a;
                xh.a.e(xh.a.a, null, gVar.b() + " --> downloadFile() --> 素材加载失败 --> response.body() == null || response.body?.byteStream()", 0, false, 13, null);
                return false;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(byteStream);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(str2);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                Unit unit = Unit.a;
                                CloseableKt.a(fileOutputStream, (Throwable) null);
                                CloseableKt.a(bufferedInputStream, (Throwable) null);
                                CloseableKt.a(byteStream, (Throwable) null);
                                return true;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Throwable th3 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.a(th2)));
            if (th3 == null) {
                throw new KotlinNothingValueException();
            }
            xh.a.e(xh.a.a, null, a.b() + " --> downloadFile() --> 素材加载失败 --> destination = " + str2 + " --> it = " + th3 + " --> url = " + str, 6, false, 9, null);
            return false;
        }
    }
}
