package k00;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.k;
import retrofit2.k0;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public final class a extends k.a {
    private final Gson a;

    private a(Gson gson) {
        this.a = gson;
    }

    public static a f() {
        return g(new Gson());
    }

    public static a g(Gson gson) {
        if (gson != null) {
            return new a(gson);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // retrofit2.k.a
    public k c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, k0 k0Var) {
        return new b(this.a, this.a.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.k.a
    public k d(Type type, Annotation[] annotationArr, k0 k0Var) {
        return new c(this.a, this.a.getAdapter(TypeToken.get(type)));
    }
}
