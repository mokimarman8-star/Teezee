package pl;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.blankj.utilcode.util.Utils;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class f extends BridgeWebView.BaseJavascriptInterface {
    private final BridgeWebView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(BridgeWebView bridgeWebView) {
        super(bridgeWebView.getCallbacks());
        Intrinsics.h(bridgeWebView, "customWebView");
        this.a = bridgeWebView;
    }

    private final String a() {
        ArrayList arrayList = new ArrayList();
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://"));
        ResolveInfo resolveActivity = a.getPackageManager().resolveActivity(intent, 65536);
        String str = null;
        String str2 = (resolveActivity != null ? resolveActivity.activityInfo : null) != null ? resolveActivity.activityInfo.packageName : null;
        if (str2 != null && !Intrinsics.c(str2, "android")) {
            return str2;
        }
        List<ResolveInfo> queryIntentActivities = a.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.g(queryIntentActivities, "queryIntentActivities(...)");
        Iterator<ResolveInfo> it = queryIntentActivities.iterator();
        String str3 = null;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if ((activityInfo.flags & 1) != 0) {
                str = activityInfo.packageName;
            } else {
                str3 = activityInfo.packageName;
                arrayList.add(str3);
            }
        }
        if (arrayList.contains("com.android.chrome")) {
            return "com.android.chrome";
        }
        if (str != null) {
            str2 = str;
        }
        return str3 != null ? str3 : str2;
    }

    private final boolean b() {
        return StringsKt.H("huawei", Build.MANUFACTURER, true);
    }

    @JavascriptInterface
    public void close() {
    }

    @JavascriptInterface
    public void openBrowser(String str) {
        Intrinsics.h(str, "url");
        StringBuilder sb = new StringBuilder();
        sb.append("openBrowser() --> url = ");
        sb.append(str);
        try {
            Intent parseUri = StringsKt.W(str, "intent", false, 2, (Object) null) ? Intent.parseUri(str, 1) : new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (parseUri != null) {
                if (b()) {
                    parseUri.setPackage(a());
                }
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                parseUri.setFlags(268435456);
            }
            Utils.a().startActivity(parseUri);
        } catch (Exception e) {
            Log.e("gs_log", "openBrowser() --> url = " + str + " --> e = " + e);
        }
    }

    public String send(String str) {
        return "send";
    }
}
