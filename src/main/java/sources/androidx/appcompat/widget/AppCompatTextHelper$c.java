package androidx.appcompat.widget;

import android.os.LocaleList;
import android.widget.TextView;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class AppCompatTextHelper$c {
    static LocaleList a(String str) {
        return LocaleList.forLanguageTags(str);
    }

    static void b(TextView textView, LocaleList localeList) {
        textView.setTextLocales(localeList);
    }
}
