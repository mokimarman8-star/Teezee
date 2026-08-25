package tu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class f {
    public static final Gson a;

    static {
        Gson create = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Intrinsics.g(create, "create(...)");
        a = create;
    }
}
