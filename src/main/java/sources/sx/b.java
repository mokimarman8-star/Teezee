package sx;

import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements a {
    @Override // sx.a
    public String getLanguage() {
        String language = Locale.getDefault().getLanguage();
        Intrinsics.g(language, "getDefault().language");
        return language;
    }

    @Override // sx.a
    public String getTimeZoneId() {
        String id = TimeZone.getDefault().getID();
        Intrinsics.g(id, "getDefault().id");
        return id;
    }
}
