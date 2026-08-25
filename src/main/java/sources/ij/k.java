package ij;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.core.utils.ToastUtil;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class k {
    public static final Navigator b(Navigator navigator, Bundle bundle) {
        Intrinsics.h(navigator, "<this>");
        if (bundle == null) {
            return navigator;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof String) {
                navigator.K(str, (String) obj);
            } else if (obj instanceof Integer) {
                navigator.F(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                navigator.G(str, ((Number) obj).longValue());
            } else if (obj instanceof Float) {
                navigator.E(str, ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                navigator.D(str, ((Number) obj).doubleValue());
            } else if (obj instanceof Boolean) {
                navigator.z(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Character) {
                navigator.C(str, ((Character) obj).charValue());
            } else if (obj instanceof Bundle) {
                navigator.A(str, (Bundle) obj);
            } else if (obj instanceof Parcelable) {
                navigator.I(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                navigator.J(str, (Serializable) obj);
            } else if (obj != null) {
                navigator.K(str, obj.toString());
            }
        }
        return navigator;
    }

    private static final void c(Uri uri, Function2 function2) {
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

    public static final String d(long j) {
        if (1 <= j && j < 1000) {
            return String.valueOf(j);
        }
        if (1000 <= j && j < 1000000) {
            return (j / 1000) + "k";
        }
        if (j < 1000000) {
            return "0";
        }
        return (j / 1000000) + "m";
    }

    public static final int e(List list, Object obj) {
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

    public static final boolean f(Uri uri) {
        Intrinsics.h(uri, "<this>");
        return Intrinsics.c(uri.getScheme(), "https") || Intrinsics.c(uri.getScheme(), "http");
    }

    public static final void g(String str, String str2) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(str2, "extraParam");
        Uri parse = Uri.parse(str + str2);
        Intrinsics.e(parse);
        if (f(parse)) {
            p(TheRouter.c("/web/web").K("url", str));
            return;
        }
        try {
            String queryParameter = parse.getQueryParameter("miniapp_deeplink");
            if (queryParameter != null && queryParameter.length() != 0) {
                wf.a.a.c("deeplink", "openDeeplink--Deeplink is mini app, " + queryParameter, true);
                dj.a aVar = dj.a.a;
                Application a = Utils.a();
                Intrinsics.g(a, "getApp(...)");
                aVar.b(a, queryParameter);
                return;
            }
        } catch (Throwable th2) {
            a.a.l(wf.a.a, "Deeplink", "openMiniApp:" + th2, false, 4, (Object) null);
            th2.printStackTrace();
        }
        try {
            Uri g = com.transsion.baselib.helper.b.a.g(parse);
            if (g != null) {
                o(g);
            }
        } catch (Throwable th3) {
            a.a.l(wf.a.a, "Deeplink", "openDeeplink:" + th3, false, 4, (Object) null);
            th3.printStackTrace();
        }
    }

    public static /* synthetic */ void h(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = BuildConfig.FLAVOR;
        }
        g(str, str2);
    }

    public static final void i(String str) {
        Intrinsics.h(str, "<this>");
        j(str, com.transsion.baselib.report.k.a.o());
    }

    public static final void j(String str, Context context) {
        String str2;
        Intrinsics.h(str, "<this>");
        if (context == null) {
            return;
        }
        if (!StringsKt.W(str, "http://", false, 2, (Object) null) && !StringsKt.W(str, "https://", false, 2, (Object) null)) {
            str = "http://" + str;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addCategory("android.intent.category.BROWSABLE");
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            try {
                Intent intent2 = new Intent(intent);
                intent2.setPackage("com.android.chrome");
                context.startActivity(intent2);
                a.a.l(wf.a.a, "ExternalBrowser", "openExternalBrowser with chrome", false, 4, (Object) null);
                com.transsion.baselib.helper.a.a.c("ExtUtils", "dialog_browser_chrome");
            } catch (Exception unused) {
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                Intrinsics.g(queryIntentActivities, "queryIntentActivities(...)");
                ArrayList<ResolveInfo> arrayList = new ArrayList();
                for (Object obj : queryIntentActivities) {
                    if (!Intrinsics.c(((ResolveInfo) obj).activityInfo.packageName, context.getPackageName())) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.v(arrayList, 10));
                for (ResolveInfo resolveInfo : arrayList) {
                    Intent intent3 = new Intent(intent);
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    intent3.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                    arrayList2.add(intent3);
                }
                if (arrayList2.isEmpty()) {
                    ToastUtil.f("Please install a browser to continue");
                    str2 = "dialog_no_browser";
                } else {
                    Intent createChooser = Intent.createChooser((Intent) CollectionsKt.i0(arrayList2), "Open in browser");
                    createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) CollectionsKt.d0(arrayList2, 1).toArray(new Intent[0]));
                    context.startActivity(createChooser);
                    a.a.l(wf.a.a, "ExternalBrowser", "openExternalBrowser with --filter intent", false, 4, (Object) null);
                    str2 = "dialog_browser_normal";
                }
                com.transsion.baselib.helper.a.a.c("ExtUtils", str2);
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            ToastUtil.f("Unable to open through this browser, please try another one");
            str2 = "dialog_browser_err";
            com.transsion.baselib.helper.a.a.c("ExtUtils", str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            ToastUtil.f("Unable to open through this browser, please try another one");
            str2 = "dialog_browser_unknown_err";
            com.transsion.baselib.helper.a.a.c("ExtUtils", str2);
        }
    }

    public static final String k(String str) {
        Intrinsics.h(str, "<this>");
        try {
            URI uri = new URI(str);
            return uri.getScheme() + "://" + uri.getHost() + uri.getPath();
        } catch (Throwable unused) {
            return str;
        }
    }

    private static final String l(Uri uri) {
        String queryParameter = uri.getQueryParameter("type");
        if (queryParameter != null) {
            return queryParameter;
        }
        String path = uri.getPath();
        return path == null ? BuildConfig.FLAVOR : path;
    }

    public static final Navigator m(Uri uri) {
        Intrinsics.h(uri, "<this>");
        final Navigator c = TheRouter.c(l(uri));
        c(uri, new Function2() { // from class: ij.j
            public final Object invoke(Object obj, Object obj2) {
                Unit n;
                n = k.n(c, (String) obj, (String) obj2);
                return n;
            }
        });
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Navigator navigator, String str, String str2) {
        Intrinsics.h(str, "key");
        Intrinsics.h(str2, "value");
        navigator.K(str, str2);
        return Unit.a;
    }

    public static final void o(Uri uri) {
        Intrinsics.h(uri, "<this>");
        p(m(uri));
    }

    public static final void p(Navigator navigator) {
        Object obj;
        Intrinsics.h(navigator, "<this>");
        try {
            Iterator it = com.transsion.baselib.report.k.a.m().iterator();
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
                activity = com.transsion.baselib.report.k.a.o();
            }
            Navigator.x(navigator, activity, (mf.c) null, 2, (Object) null);
        } catch (Throwable unused) {
            Navigator.x(navigator, (Context) null, (mf.c) null, 3, (Object) null);
        }
    }
}
