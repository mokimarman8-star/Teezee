package yr;

import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.transsion.shorttv.utils.h;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import n0.d;
import xr.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    public static final Locale a() {
        String string = h.a.e().getString("k_language_short_name", (String) null);
        Locale a = Build.VERSION.SDK_INT >= 24 ? d.a(androidx.appcompat.app.h.a(Utils.a().getResources().getConfiguration()), 0) : Utils.a().getResources().getConfiguration().locale;
        if (!Intrinsics.c(a.getLanguage(), string) && string != null && string.length() > 0) {
            return new Locale(string, a.getCountry());
        }
        Intrinsics.e(a);
        return a;
    }

    public static final String b(b bVar) {
        SubtitleDownloadTable a;
        String fileCharsetName;
        if (bVar != null && (a = bVar.a()) != null && (fileCharsetName = a.getFileCharsetName()) != null) {
            return fileCharsetName;
        }
        String name = Charsets.b.name();
        Intrinsics.g(name, "name(...)");
        return name;
    }
}
