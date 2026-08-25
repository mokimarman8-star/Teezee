package com.transsion.subtitle.helper;

import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.SubtitleBean;
import com.transsion.baselib.db.download.SubtitleLanguageMapBean;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class c {
    public static final Locale a() {
        String string = com.transsion.baselib.report.launch.b.a.b().getString("k_language_short_name", (String) null);
        Locale a = Build.VERSION.SDK_INT >= 24 ? n0.d.a(androidx.appcompat.app.h.a(Utils.a().getResources().getConfiguration()), 0) : Utils.a().getResources().getConfiguration().locale;
        if (!Intrinsics.c(a.getLanguage(), string) && string != null && string.length() > 0) {
            return new Locale(string, a.getCountry());
        }
        Intrinsics.e(a);
        return a;
    }

    public static final String b(ht.a aVar) {
        SubtitleDownloadTable b;
        String fileCharsetName;
        if (aVar != null && (b = aVar.b()) != null && (fileCharsetName = b.getFileCharsetName()) != null) {
            return fileCharsetName;
        }
        String name = Charsets.UTF_8.name();
        Intrinsics.g(name, "name(...)");
        return name;
    }

    public static final boolean c(String language, List list) {
        String str;
        Intrinsics.h(language, "language");
        Intrinsics.h(list, "list");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String lan = ((SubtitleBean) it.next()).getLan();
            if (lan != null) {
                str = lan.toUpperCase(Locale.ROOT);
                Intrinsics.g(str, "toUpperCase(...)");
            } else {
                str = null;
            }
            String upperCase = language.toUpperCase(Locale.ROOT);
            Intrinsics.g(upperCase, "toUpperCase(...)");
            if (Intrinsics.c(str, upperCase)) {
                return true;
            }
        }
        return false;
    }

    public static final void d(List list) {
        Intrinsics.h(list, "list");
        Locale a = Build.VERSION.SDK_INT >= 24 ? n0.d.a(androidx.appcompat.app.h.a(Utils.a().getResources().getConfiguration()), 0) : Utils.a().getResources().getConfiguration().locale;
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            SubtitleLanguageMapBean subtitleLanguageMapBean = (SubtitleLanguageMapBean) list.get(i);
            if (Intrinsics.c(Intrinsics.c(subtitleLanguageMapBean.getLan(), "in_id") ? "in" : subtitleLanguageMapBean.getLan(), a.getLanguage())) {
                break;
            } else {
                i++;
            }
        }
        if (i > 0) {
            list.add(0, (SubtitleLanguageMapBean) list.remove(i));
        }
    }
}
