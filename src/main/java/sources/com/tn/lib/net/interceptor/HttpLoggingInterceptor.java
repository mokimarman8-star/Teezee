package com.tn.lib.net.interceptor;

import ig.d;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import wf.a;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private final a a;
    private volatile Set b;
    private volatile Level c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/tn/lib/net/interceptor/HttpLoggingInterceptor$Level;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Level {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Level[] $VALUES;
        public static final Level NONE = new Level("NONE", 0);
        public static final Level BASIC = new Level("BASIC", 1);
        public static final Level HEADERS = new Level("HEADERS", 2);
        public static final Level BODY = new Level("BODY", 3);

        private static final /* synthetic */ Level[] $values() {
            return new Level[]{NONE, BASIC, HEADERS, BODY};
        }

        static {
            Level[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private Level(String str, int i) {
        }

        public static EnumEntries<Level> getEntries() {
            return $ENTRIES;
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public HttpLoggingInterceptor() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.lib.net.interceptor.HttpLoggingInterceptor.<init>():void");
    }

    public HttpLoggingInterceptor(a aVar) {
        Intrinsics.h(aVar, "logger");
        this.a = aVar;
        this.b = SetsKt.f();
        this.c = Level.NONE;
    }

    private final boolean a(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || StringsKt.H(str, "identity", true) || StringsKt.H(str, "gzip", true)) ? false : true;
    }

    private final void c(Headers headers, int i) {
        String value = this.b.contains(headers.name(i)) ? "██" : headers.value(i);
        this.a.log(headers.name(i) + ": " + value);
    }

    public final void b(Level level) {
        Intrinsics.h(level, "<set-?>");
        this.c = level;
    }

    public Response intercept(Interceptor.Chain chain) {
        boolean z;
        String str;
        String str2;
        long j;
        String str3;
        String str4;
        String str5;
        Charset charset;
        Charset charset2;
        Intrinsics.h(chain, "chain");
        Level level = this.c;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z2 = level == Level.BODY;
        boolean z3 = z2 || level == Level.HEADERS;
        RequestBody body = request.body();
        Connection connection = chain.connection();
        String str6 = "--> " + request.method() + " " + request.url() + (connection != null ? " " + connection.protocol() : "");
        if (!z3 && body != null) {
            str6 = str6 + " (" + body.contentLength() + "-byte body)";
        }
        this.a.log(str6);
        if (z3) {
            Headers headers = request.headers();
            if (body != null) {
                MediaType contentType = body.contentType();
                if (contentType == null || headers.get("Content-Type") != null) {
                    str = " ";
                } else {
                    a aVar = this.a;
                    StringBuilder sb = new StringBuilder();
                    str = " ";
                    sb.append("Content-Type: ");
                    sb.append(contentType);
                    aVar.log(sb.toString());
                }
                if (body.contentLength() == -1 || headers.get("Content-Length") != null) {
                    z = z3;
                } else {
                    a aVar2 = this.a;
                    long contentLength = body.contentLength();
                    StringBuilder sb2 = new StringBuilder();
                    z = z3;
                    sb2.append("Content-Length: ");
                    sb2.append(contentLength);
                    aVar2.log(sb2.toString());
                }
            } else {
                z = z3;
                str = " ";
            }
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                c(headers, i);
            }
            if (!z2 || body == null) {
                this.a.log("--> END " + request.method());
            } else if (a(request.headers())) {
                this.a.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (body.isDuplex()) {
                this.a.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (body.isOneShot()) {
                this.a.log("--> END " + request.method() + " (one-shot body omitted)");
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                MediaType contentType2 = body.contentType();
                if (contentType2 == null || (charset2 = contentType2.charset(StandardCharsets.UTF_8)) == null) {
                    charset2 = StandardCharsets.UTF_8;
                    Intrinsics.g(charset2, "UTF_8");
                }
                this.a.log("");
                if (d.a(buffer)) {
                    this.a.log(buffer.readString(charset2));
                    this.a.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.a.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            }
        } else {
            z = z3;
            str = " ";
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            Intrinsics.e(body2);
            long contentLength2 = body2.contentLength();
            String str7 = contentLength2 != -1 ? contentLength2 + "-byte" : "unknown-length";
            a aVar3 = this.a;
            int code = proceed.code();
            if (proceed.message().length() == 0) {
                j = contentLength2;
                str2 = "-byte body)";
                str3 = "";
            } else {
                str2 = "-byte body)";
                j = contentLength2;
                str3 = ' ' + proceed.message();
            }
            HttpUrl url = proceed.request().url();
            if (z) {
                str4 = "-byte body omitted)";
                str5 = "";
            } else {
                StringBuilder sb3 = new StringBuilder();
                str4 = "-byte body omitted)";
                sb3.append(", ");
                sb3.append(str7);
                sb3.append(" body");
                str5 = sb3.toString();
            }
            aVar3.log("<-- " + code + str3 + str + url + " (" + millis + "ms" + str5 + ")");
            if (z) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    c(headers2, i2);
                }
                if (!z2 || !HttpHeaders.promisesBody(proceed)) {
                    this.a.log("<-- END HTTP");
                } else if (a(proceed.headers())) {
                    this.a.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource source = body2.source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer2 = source.getBuffer();
                    Long l = null;
                    if (StringsKt.H("gzip", headers2.get("Content-Encoding"), true)) {
                        Long valueOf = Long.valueOf(buffer2.size());
                        GzipSource gzipSource = new GzipSource(buffer2.clone());
                        try {
                            buffer2 = new Buffer();
                            buffer2.writeAll(gzipSource);
                            CloseableKt.a(gzipSource, (Throwable) null);
                            l = valueOf;
                        } finally {
                        }
                    }
                    MediaType contentType3 = body2.contentType();
                    if (contentType3 == null || (charset = contentType3.charset(StandardCharsets.UTF_8)) == null) {
                        charset = StandardCharsets.UTF_8;
                        Intrinsics.g(charset, "UTF_8");
                    }
                    if (!d.a(buffer2)) {
                        this.a.log("");
                        this.a.log("<-- END HTTP (binary " + buffer2.size() + str4);
                        return proceed;
                    }
                    if (j != 0) {
                        this.a.log("");
                        this.a.log(buffer2.clone().readString(charset));
                    }
                    if (l != null) {
                        this.a.log("<-- END HTTP (" + buffer2.size() + "-byte, " + l + "-gzipped-byte body)");
                    } else {
                        this.a.log("<-- END HTTP (" + buffer2.size() + str2);
                    }
                }
            }
            return proceed;
        } catch (Exception e) {
            a.a.i("HttpTag", "net_state:" + l.a.b() + " url:" + request.url() + "<-- HTTP FAILED: " + e, true);
            throw e;
        }
    }
}
