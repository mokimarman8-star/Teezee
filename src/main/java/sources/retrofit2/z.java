package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;
import retrofit2.k;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class z extends k.a {

    static final class a implements k {
        final k a;

        a(k kVar) {
            this.a = kVar;
        }

        @Override // retrofit2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Optional convert(ResponseBody responseBody) {
            Optional ofNullable;
            ofNullable = Optional.ofNullable(this.a.convert(responseBody));
            return ofNullable;
        }
    }

    z() {
    }

    @Override // retrofit2.k.a
    public k d(Type type, Annotation[] annotationArr, k0 k0Var) {
        if (k.a.b(type) != x.a()) {
            return null;
        }
        return new a(k0Var.h(k.a.a(0, (ParameterizedType) type), annotationArr));
    }
}
