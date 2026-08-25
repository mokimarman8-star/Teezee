package cv;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final a a = new a();
    private static final Gson b = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    private a() {
    }

    public final String a(Object obj) {
        if (obj == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        try {
            return new Gson().toJson(obj);
        } catch (Exception unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }
}
