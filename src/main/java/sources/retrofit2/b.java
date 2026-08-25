package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Streaming;
import retrofit2.k;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class b extends k.a {

    static final class a implements k {
        static final a a = new a();

        a() {
        }

        @Override // retrofit2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResponseBody convert(ResponseBody responseBody) {
            try {
                return o0.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* renamed from: retrofit2.b$b, reason: collision with other inner class name */
    static final class C0010b implements k {
        static final C0010b a = new C0010b();

        C0010b() {
        }

        @Override // retrofit2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }
    }

    static final class c implements k {
        static final c a = new c();

        c() {
        }

        @Override // retrofit2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }
    }

    static final class d implements k {
        static final d a = new d();

        d() {
        }

        @Override // retrofit2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    static final class e implements k {
        static final e a = new e();

        e() {
        }

        @Override // retrofit2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit convert(ResponseBody responseBody) {
            responseBody.close();
            return Unit.a;
        }
    }

    static final class f implements k {
        static final f a = new f();

        f() {
        }

        @Override // retrofit2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void convert(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    b() {
    }

    @Override // retrofit2.k.a
    public k c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, k0 k0Var) {
        if (RequestBody.class.isAssignableFrom(o0.h(type))) {
            return C0010b.a;
        }
        return null;
    }

    @Override // retrofit2.k.a
    public k d(Type type, Annotation[] annotationArr, k0 k0Var) {
        if (type == ResponseBody.class) {
            return o0.l(annotationArr, Streaming.class) ? c.a : a.a;
        }
        if (type == Void.class) {
            return f.a;
        }
        if (o0.m(type)) {
            return e.a;
        }
        return null;
    }
}
