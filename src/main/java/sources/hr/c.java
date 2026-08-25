package hr;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class c {
    private static final void b(Uri uri, Function2 function2) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Intrinsics.g(queryParameterNames, "getQueryParameterNames(...)");
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : queryParameterNames) {
            if (!Intrinsics.c((String) obj, "type")) {
                arrayList.add(obj);
            }
        }
        for (String str : arrayList) {
            String queryParameter = uri.getQueryParameter(str);
            if (queryParameter != null) {
                Intrinsics.e(str);
                function2.invoke(str, queryParameter);
            }
        }
    }

    public static final int c(List list, Object obj) {
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

    public static final boolean d(Uri uri) {
        Intrinsics.h(uri, "<this>");
        return Intrinsics.c(uri.getScheme(), "https") || Intrinsics.c(uri.getScheme(), "http");
    }

    public static final void e(String str, String str2) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(str2, "extraParam");
        Uri parse = Uri.parse(str + str2);
        Intrinsics.e(parse);
        if (d(parse)) {
            k(TheRouter.c("/web/web").K("url", str));
            return;
        }
        try {
            Uri a = dr.a.a.a(parse);
            if (a != null) {
                j(a);
            }
        } catch (Throwable th2) {
            a.a.l(wf.a.a, "Deeplink", "openDeeplink:" + th2, false, 4, (Object) null);
            th2.printStackTrace();
        }
    }

    public static /* synthetic */ void f(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = BuildConfig.FLAVOR;
        }
        e(str, str2);
    }

    private static final String g(Uri uri) {
        String queryParameter = uri.getQueryParameter("type");
        if (queryParameter != null) {
            return queryParameter;
        }
        String path = uri.getPath();
        return path == null ? BuildConfig.FLAVOR : path;
    }

    public static final Navigator h(Uri uri) {
        Intrinsics.h(uri, "<this>");
        final Navigator c = TheRouter.c(g(uri));
        b(uri, new Function2() { // from class: hr.b
            public final Object invoke(Object obj, Object obj2) {
                Unit i;
                i = c.i(c, (String) obj, (String) obj2);
                return i;
            }
        });
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Navigator navigator, String str, String str2) {
        Intrinsics.h(str, "key");
        Intrinsics.h(str2, "value");
        navigator.K(str, str2);
        return Unit.a;
    }

    public static final void j(Uri uri) {
        Intrinsics.h(uri, "<this>");
        k(h(uri));
    }

    public static final void k(Navigator navigator) {
        Object obj;
        Intrinsics.h(navigator, "<this>");
        try {
            Iterator it = zq.b.a.e().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String localClassName = ((Activity) obj).getLocalClassName();
                Intrinsics.g(localClassName, "getLocalClassName(...)");
                if (StringsKt.c0(localClassName, "MainActivity", false, 2, (Object) null)) {
                    break;
                }
            }
            Activity activity = (Activity) obj;
            if (activity == null) {
                activity = zq.b.a.g();
            }
            Navigator.x(navigator, activity, (mf.c) null, 2, (Object) null);
        } catch (Throwable unused) {
            Navigator.x(navigator, (Context) null, (mf.c) null, 3, (Object) null);
        }
    }
}
