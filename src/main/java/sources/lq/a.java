package lq;

import android.content.Context;
import com.transsion.gslb.BuildConfig;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();
    private static String b = BuildConfig.FLAVOR;
    private static Function0 c;
    private static Function4 d;
    private static Function1 e;

    private a() {
    }

    public final void a() {
        b = BuildConfig.FLAVOR;
        c = null;
        d = null;
        e = null;
    }

    public final String b() {
        return b;
    }

    public final String c() {
        String str;
        Function0 function0 = c;
        return (function0 == null || (str = (String) function0.invoke()) == null) ? BuildConfig.FLAVOR : str;
    }

    public void d(String str, Function0 function0, Function4 function4, Function1 function1) {
        Intrinsics.h(str, "appName");
        Intrinsics.h(function0, "userId");
        Intrinsics.h(function4, "reportShow");
        Intrinsics.h(function1, "toastShow");
        b = str;
        c = function0;
        d = function4;
        e = function1;
    }

    public final void e(Context context, String str, String str2, com.transsion.share.share.a aVar) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str2, "id");
        Function4 function4 = d;
        if (function4 != null) {
            function4.invoke(context, str, str2, aVar);
        }
    }

    public final void f(String str) {
        Intrinsics.h(str, "content");
        Function1 function1 = e;
        if (function1 != null) {
            function1.invoke(str);
        }
    }
}
