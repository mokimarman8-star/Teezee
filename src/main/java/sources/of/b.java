package of;

import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tmc.network.log.LogLevel;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b implements Interceptor {
    private static final a e = new a(null);
    private final InterfaceC0193b a;
    private volatile Set b;
    private volatile LogLevel c;
    private volatile LogLevel d;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Buffer buffer) {
            Intrinsics.h(buffer, "<this>");
            try {
                Buffer buffer2 = new Buffer();
                buffer.copyTo(buffer2, 0L, RangesKt.i(buffer.size(), 64L));
                int i = 0;
                do {
                    i++;
                    if (buffer2.exhausted()) {
                        break;
                    }
                    int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                    if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                        return false;
                    }
                } while (i < 16);
                return true;
            } catch (EOFException unused) {
                return false;
            }
        }

        public final boolean b(MediaType mediaType) {
            if (!Intrinsics.c(mediaType == null ? null : mediaType.type(), MimeTypes.BASE_TYPE_TEXT)) {
                if (!Intrinsics.c(mediaType == null ? null : mediaType.subtype(), "json")) {
                    if (!Intrinsics.c(mediaType != null ? mediaType.subtype() : null, "x-www-form-urlencoded")) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /* renamed from: of.b$b, reason: collision with other inner class name */
    public interface InterfaceC0193b {
        public static final C0194b a = C0194b.a;
        public static final InterfaceC0193b b = new a();

        /* renamed from: of.b$b$a */
        public static final class a implements InterfaceC0193b {
            a() {
            }

            @Override // of.b.InterfaceC0193b
            public void log(String str) {
                Intrinsics.h(str, TrackingKey.MESSAGE);
                Platform.Companion.get().log(str, 4, (Throwable) null);
            }
        }

        /* renamed from: of.b$b$b, reason: collision with other inner class name */
        public static final class C0194b {
            static final /* synthetic */ C0194b a = new C0194b();

            private C0194b() {
            }
        }

        void log(String str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b() {
        this(r0, 1, r0);
        InterfaceC0193b interfaceC0193b = null;
    }

    public b(InterfaceC0193b interfaceC0193b) {
        Intrinsics.h(interfaceC0193b, "logger");
        this.a = interfaceC0193b;
        this.b = SetsKt.f();
        LogLevel logLevel = LogLevel.NONE;
        this.c = logLevel;
        this.d = logLevel;
    }

    public /* synthetic */ b(InterfaceC0193b interfaceC0193b, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? InterfaceC0193b.b : interfaceC0193b);
    }

    private final boolean a(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || StringsKt.H(str, "identity", true) || StringsKt.H(str, "gzip", true)) ? false : true;
    }

    private final void b(Headers headers, int i) {
        String value = this.b.contains(headers.name(i)) ? "██" : headers.value(i);
        this.a.log(headers.name(i) + ": " + value);
    }

    public final void c(LogLevel logLevel) {
        Intrinsics.h(logLevel, "<set-?>");
        this.c = logLevel;
    }

    public final void d(LogLevel logLevel) {
        Intrinsics.h(logLevel, "<set-?>");
        this.d = logLevel;
    }

    public final b e(LogLevel logLevel) {
        Intrinsics.h(logLevel, "level");
        c(logLevel);
        return this;
    }

    public final b f(LogLevel logLevel) {
        Intrinsics.h(logLevel, "level");
        d(logLevel);
        return this;
    }

    public Response intercept(Interceptor.Chain chain) {
        boolean z;
        String str;
        String str2;
        char c;
        String sb2;
        String str3;
        Charset charset;
        Long l;
        Intrinsics.h(chain, "chain");
        LogLevel logLevel = this.c;
        LogLevel logLevel2 = this.d;
        Request request = chain.request();
        LogLevel logLevel3 = LogLevel.NONE;
        if (logLevel == logLevel3 && logLevel2 == logLevel3) {
            return chain.proceed(request);
        }
        boolean z2 = logLevel == LogLevel.BODY;
        boolean z3 = z2 || logLevel == LogLevel.HEADERS;
        RequestBody body = request.body();
        boolean b = e.b(body == null ? null : body.contentType());
        Connection connection = chain.connection();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("--> ");
        sb3.append(request.method());
        sb3.append(' ');
        sb3.append(request.url());
        sb3.append(connection != null ? Intrinsics.q(" ", connection.protocol()) : TtmlNode.ANONYMOUS_REGION_ID);
        String sb4 = sb3.toString();
        if (!z3 && body != null) {
            sb4 = sb4 + " (" + body.contentLength() + "-byte body)";
        }
        this.a.log(sb4);
        if (z3) {
            Headers headers = request.headers();
            if (body != null) {
                MediaType contentType = body.contentType();
                if (contentType != null && headers.get("Content-Type") == null) {
                    z = z3;
                    this.a.log(Intrinsics.q("Content-Type: ", contentType));
                } else {
                    z = z3;
                }
                if (body.contentLength() != -1 && headers.get("Content-Length") == null) {
                    this.a.log(Intrinsics.q("Content-Length: ", Long.valueOf(body.contentLength())));
                }
            } else {
                z = z3;
            }
            int size = headers.size();
            if (size > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    b(headers, i);
                    if (i2 >= size) {
                        break;
                    }
                    i = i2;
                }
            }
            if (!z2 || body == null) {
                this.a.log(Intrinsics.q("--> END ", request.method()));
            } else if (a(request.headers())) {
                this.a.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (body.isDuplex()) {
                this.a.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (b) {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                MediaType contentType2 = body.contentType();
                Charset charset2 = contentType2 == null ? null : contentType2.charset(StandardCharsets.UTF_8);
                if (charset2 == null) {
                    charset2 = StandardCharsets.UTF_8;
                    Intrinsics.g(charset2, "UTF_8");
                }
                this.a.log(TtmlNode.ANONYMOUS_REGION_ID);
                if (e.a(buffer)) {
                    this.a.log(buffer.readString(charset2));
                    this.a.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.a.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            } else {
                this.a.log("--> END " + request.method() + " (non text request body omitted.)");
            }
        } else {
            z = z3;
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            boolean z4 = logLevel2 == LogLevel.BODY;
            boolean z5 = z4 || logLevel2 == LogLevel.HEADERS;
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            Intrinsics.e(body2);
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                str = contentLength + "-byte";
            } else {
                str = "unknown-length";
            }
            InterfaceC0193b interfaceC0193b = this.a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("<-- ");
            sb5.append(proceed.code());
            if (proceed.message().length() == 0) {
                str2 = "-byte body omitted)";
                sb2 = TtmlNode.ANONYMOUS_REGION_ID;
                c = ' ';
            } else {
                String message = proceed.message();
                StringBuilder sb6 = new StringBuilder();
                str2 = "-byte body omitted)";
                c = ' ';
                sb6.append(String.valueOf(' '));
                sb6.append(message);
                sb2 = sb6.toString();
            }
            sb5.append(sb2);
            sb5.append(c);
            sb5.append(proceed.request().url());
            sb5.append(" (");
            sb5.append(millis);
            sb5.append("ms");
            if (z) {
                str3 = TtmlNode.ANONYMOUS_REGION_ID;
            } else {
                str3 = ", " + str + " body";
            }
            sb5.append(str3);
            sb5.append(')');
            interfaceC0193b.log(sb5.toString());
            boolean b2 = e.b(body2.contentType());
            if (z5) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                if (size2 > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        b(headers2, i3);
                        if (i4 >= size2) {
                            break;
                        }
                        i3 = i4;
                    }
                }
                if (!z4 || !HttpHeaders.promisesBody(proceed)) {
                    this.a.log("<-- END HTTP");
                } else if (a(proceed.headers())) {
                    this.a.log("<-- END HTTP (encoded body omitted)");
                } else if (b2) {
                    BufferedSource source = body2.source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer2 = source.getBuffer();
                    if (StringsKt.H("gzip", headers2.get("Content-Encoding"), true)) {
                        l = Long.valueOf(buffer2.size());
                        GzipSource gzipSource = new GzipSource(buffer2.clone());
                        try {
                            buffer2 = new Buffer();
                            buffer2.writeAll(gzipSource);
                            charset = null;
                            CloseableKt.a(gzipSource, (Throwable) null);
                        } finally {
                        }
                    } else {
                        charset = null;
                        l = null;
                    }
                    MediaType contentType3 = body2.contentType();
                    Charset charset3 = contentType3 == null ? charset : contentType3.charset(StandardCharsets.UTF_8);
                    if (charset3 == null) {
                        charset3 = StandardCharsets.UTF_8;
                        Intrinsics.g(charset3, "UTF_8");
                    }
                    if (!e.a(buffer2)) {
                        this.a.log(TtmlNode.ANONYMOUS_REGION_ID);
                        this.a.log("<-- END HTTP (binary " + buffer2.size() + str2);
                        return proceed;
                    }
                    if (contentLength != 0) {
                        this.a.log(TtmlNode.ANONYMOUS_REGION_ID);
                        this.a.log(buffer2.clone().readString(charset3));
                    }
                    if (l != null) {
                        this.a.log("<-- END HTTP (" + buffer2.size() + "-byte, " + l + "-gzipped-byte body)");
                    } else {
                        this.a.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                    }
                } else {
                    this.a.log("<-- END HTTP (non text response body omitted.)");
                }
            }
            return proceed;
        } catch (Exception e2) {
            this.a.log(Intrinsics.q("<-- HTTP FAILED: ", e2));
            throw e2;
        }
    }
}
