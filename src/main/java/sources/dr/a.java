package dr;

import android.net.Uri;
import android.text.TextUtils;
import com.transsion.core.utils.ToastUtil;
import com.transsion.gslb.BuildConfig;
import java.util.HashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final Uri a(Uri uri) {
        Object obj;
        String queryParameter;
        String str;
        if (uri == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            queryParameter = uri.getQueryParameter("type");
            str = BuildConfig.FLAVOR;
            if (queryParameter == null) {
                queryParameter = BuildConfig.FLAVOR;
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (queryParameter.length() > 0) {
            return uri.buildUpon().path(queryParameter).build();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("subject", "/movie/detail");
        hashMap.put("post", "/post/detail");
        String uri2 = uri.toString();
        Intrinsics.g(uri2, "toString(...)");
        if (!TextUtils.isEmpty(uri2)) {
            List S0 = StringsKt.S0(uri2, new String[]{"-"}, false, 0, 6, (Object) null);
            if (S0.size() >= 2) {
                String str2 = (String) hashMap.get(S0.get(0));
                String str3 = (String) S0.get(1);
                return new Uri.Builder().encodedPath(str2).encodedQuery("id=" + str3).build();
            }
        }
        String path = uri.getPath();
        if (path != null) {
            str = path;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '/') {
                i++;
            }
        }
        if (i < 2) {
            return null;
        }
        obj = Result.constructor-impl(Unit.a);
        if (Result.exceptionOrNull-impl(obj) != null) {
            ToastUtil.f("请升级最新版本");
        }
        return uri;
    }
}
