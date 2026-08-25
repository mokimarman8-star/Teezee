package ls;

import android.net.Uri;
import com.therouter.TheRouter;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class b {
    public static final int a(List list, Object obj) {
        Intrinsics.h(list, "<this>");
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            if (it.next() == obj) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    public static final boolean b(Uri uri) {
        Intrinsics.h(uri, "<this>");
        return Intrinsics.c(uri.getScheme(), "https") || Intrinsics.c(uri.getScheme(), "http");
    }

    public static final void c(String str, String extraParam) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(extraParam, "extraParam");
        Uri parse = Uri.parse(str + extraParam);
        Intrinsics.e(parse);
        if (b(parse)) {
            hr.c.k(TheRouter.c(WebPageIdentity.WEB_VIEW).K(WebConstants.FIELD_URL, str));
            return;
        }
        try {
            Uri a = hs.a.a.a(parse);
            if (a != null) {
                hr.c.j(a);
            }
        } catch (Throwable th) {
            a.a.l(wf.a.a, "Deeplink", "openDeeplink:" + th, false, 4, (Object) null);
            th.printStackTrace();
        }
    }

    public static /* synthetic */ void d(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        c(str, str2);
    }
}
