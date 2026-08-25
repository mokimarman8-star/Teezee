package retrofit2;

import java.util.regex.Pattern;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class h0 {
    private static final char[] l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    private final String a;
    private final HttpUrl b;
    private String c;
    private HttpUrl.Builder d;
    private final Request.Builder e = new Request.Builder();
    private final Headers.Builder f;
    private MediaType g;
    private final boolean h;
    private MultipartBody.Builder i;
    private FormBody.Builder j;
    private RequestBody k;

    private static class a extends RequestBody {
        private final RequestBody a;
        private final MediaType b;

        a(RequestBody requestBody, MediaType mediaType) {
            this.a = requestBody;
            this.b = mediaType;
        }

        public long contentLength() {
            return this.a.contentLength();
        }

        public MediaType contentType() {
            return this.b;
        }

        public void writeTo(BufferedSink bufferedSink) {
            this.a.writeTo(bufferedSink);
        }
    }

    h0(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.a = str;
        this.b = httpUrl;
        this.c = str2;
        this.g = mediaType;
        this.h = z;
        if (headers != null) {
            this.f = headers.newBuilder();
        } else {
            this.f = new Headers.Builder();
        }
        if (z2) {
            this.j = new FormBody.Builder();
        } else if (z3) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.i = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    private static String i(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, i);
                j(buffer, str, i, length, z);
                return buffer.readUtf8();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    private static void j(Buffer buffer, String str, int i, int i2, boolean z) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(codePointAt);
                    while (!buffer2.exhausted()) {
                        byte readByte = buffer2.readByte();
                        buffer.writeByte(37);
                        char[] cArr = l;
                        buffer.writeByte((int) cArr[((readByte & 255) >> 4) & 15]);
                        buffer.writeByte((int) cArr[readByte & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    void a(String str, String str2, boolean z) {
        if (z) {
            this.j.addEncoded(str, str2);
        } else {
            this.j.add(str, str2);
        }
    }

    void b(String str, String str2, boolean z) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            if (z) {
                this.f.addUnsafeNonAscii(str, str2);
                return;
            } else {
                this.f.add(str, str2);
                return;
            }
        }
        try {
            this.g = MediaType.get(str2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e);
        }
    }

    void c(Headers headers) {
        this.f.addAll(headers);
    }

    void d(Headers headers, RequestBody requestBody) {
        this.i.addPart(headers, requestBody);
    }

    void e(MultipartBody.Part part) {
        this.i.addPart(part);
    }

    void f(String str, String str2, boolean z) {
        if (this.c == null) {
            throw new AssertionError();
        }
        String i = i(str2, z);
        String replace = this.c.replace("{" + str + "}", i);
        if (!m.matcher(replace).matches()) {
            this.c = replace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    void g(String str, String str2, boolean z) {
        String str3 = this.c;
        if (str3 != null) {
            HttpUrl.Builder newBuilder = this.b.newBuilder(str3);
            this.d = newBuilder;
            if (newBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.b + ", Relative: " + this.c);
            }
            this.c = null;
        }
        if (z) {
            this.d.addEncodedQueryParameter(str, str2);
        } else {
            this.d.addQueryParameter(str, str2);
        }
    }

    void h(Class cls, Object obj) {
        this.e.tag(cls, obj);
    }

    Request.Builder k() {
        HttpUrl resolve;
        HttpUrl.Builder builder = this.d;
        if (builder != null) {
            resolve = builder.build();
        } else {
            resolve = this.b.resolve(this.c);
            if (resolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.b + ", Relative: " + this.c);
            }
        }
        FormBody formBody = this.k;
        if (formBody == null) {
            FormBody.Builder builder2 = this.j;
            if (builder2 != null) {
                formBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.i;
                if (builder3 != null) {
                    formBody = builder3.build();
                } else if (this.h) {
                    formBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.g;
        if (mediaType != null) {
            if (formBody != null) {
                formBody = new a(formBody, mediaType);
            } else {
                this.f.add("Content-Type", mediaType.toString());
            }
        }
        return this.e.url(resolve).headers(this.f.build()).method(this.a, formBody);
    }

    void l(RequestBody requestBody) {
        this.k = requestBody;
    }

    void m(Object obj) {
        this.c = obj.toString();
    }
}
