package fg;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.k;
import retrofit2.k0;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class a extends k.a {
    public static a f() {
        return new a();
    }

    private String g(Annotation[] annotationArr) {
        if (annotationArr != null && annotationArr.length != 0) {
            for (Annotation annotation : annotationArr) {
                if (annotation instanceof cg.a) {
                    return "1311";
                }
            }
        }
        return "no_code";
    }

    public k c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, k0 k0Var) {
        return new b();
    }

    public k d(Type type, Annotation[] annotationArr, k0 k0Var) {
        return new c(type, g(annotationArr));
    }
}
