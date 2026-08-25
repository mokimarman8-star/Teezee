package uu;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class b {
    public abstract String a();

    public String b() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public List c() {
        return new ArrayList();
    }

    public abstract String d();

    public abstract void e(Function1 function1);

    public abstract Object f(Function1 function1, Function1 function12, Continuation continuation);

    public abstract String g();

    public abstract void h(JsonObject jsonObject, Function1 function1);

    public boolean i() {
        return true;
    }
}
