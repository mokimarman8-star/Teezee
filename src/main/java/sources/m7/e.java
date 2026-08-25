package m7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.TypeAdapters;
import java.math.BigDecimal;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class e {
    private static Gson a;

    public static synchronized Gson a() {
        Gson gson;
        synchronized (e.class) {
            try {
                if (a == null) {
                    a = b().create();
                }
                gson = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gson;
    }

    public static GsonBuilder b() {
        return new GsonBuilder().registerTypeAdapterFactory(TypeAdapters.newFactory(String.class, new h())).registerTypeAdapterFactory(TypeAdapters.newFactory(Boolean.TYPE, Boolean.class, new b())).registerTypeAdapterFactory(TypeAdapters.newFactory(Integer.TYPE, Integer.class, new f())).registerTypeAdapterFactory(TypeAdapters.newFactory(Long.TYPE, Long.class, new g())).registerTypeAdapterFactory(TypeAdapters.newFactory(Float.TYPE, Float.class, new d())).registerTypeAdapterFactory(TypeAdapters.newFactory(Double.TYPE, Double.class, new c())).registerTypeAdapterFactory(TypeAdapters.newFactory(BigDecimal.class, new a()));
    }
}
