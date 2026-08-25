package pl;

import android.net.Uri;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    public final boolean a(String str) {
        Object obj;
        Intrinsics.h(str, "url");
        try {
            Result.Companion companion = Result.Companion;
            Uri parse = Uri.parse(str);
            String query = parse.getQuery();
            if (query == null) {
                String fragment = parse.getFragment();
                query = null;
                if (fragment != null) {
                    query = StringsKt.b1(fragment, "?", (String) null, 2, (Object) null);
                }
            }
            String queryParameter = Uri.parse("?" + query).getQueryParameter("h5_bar");
            obj = Result.constructor-impl(Boolean.valueOf(queryParameter != null ? Boolean.parseBoolean(queryParameter) : false));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            System.out.println((Object) ("Error parsing URL: " + th3.getMessage()));
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }
}
