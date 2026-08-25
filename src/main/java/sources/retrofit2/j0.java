package retrofit2;

import java.util.Objects;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public final class j0<T> {
    private final Response a;
    private final Object b;
    private final ResponseBody c;

    private j0(Response response, Object obj, ResponseBody responseBody) {
        this.a = response;
        this.b = obj;
        this.c = responseBody;
    }

    public static j0 c(ResponseBody responseBody, Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new j0(response, null, responseBody);
    }

    public static j0 g(Object obj, Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new j0(response, obj, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public Object a() {
        return this.b;
    }

    public int b() {
        return this.a.code();
    }

    public ResponseBody d() {
        return this.c;
    }

    public boolean e() {
        return this.a.isSuccessful();
    }

    public String f() {
        return this.a.message();
    }

    public String toString() {
        return this.a.toString();
    }
}
