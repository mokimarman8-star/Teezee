package sz;

import java.util.Locale;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static String a(String str) {
        return str != null ? str.toLowerCase(Locale.ENGLISH) : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public static String b(String str) {
        return a(str).trim();
    }
}
