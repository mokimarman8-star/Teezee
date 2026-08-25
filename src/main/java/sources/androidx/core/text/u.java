package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class u {
    public static int a(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
