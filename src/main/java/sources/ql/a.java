package ql;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.blankj.utilcode.util.Utils;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.transsion.gslb.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();
    private static String b = BuildConfig.FLAVOR;
    private static BridgeWebView c;

    private a() {
    }

    public final void a(BridgeWebView bridgeWebView) {
        if (bridgeWebView != null) {
            ViewParent parent = bridgeWebView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(bridgeWebView);
            }
            bridgeWebView.stopLoading();
            bridgeWebView.clearHistory();
            bridgeWebView.clearCache(true);
            bridgeWebView.loadUrl("about:blank");
            bridgeWebView.destroy();
        }
    }

    public final BridgeWebView b(String str, Context context) {
        Intrinsics.h(str, "url");
        if (!c(str)) {
            b bVar = b.a;
            bVar.f("get() --> 没有缓存，直接创建一个新的 --> url = " + str);
            if (context == null) {
                context = Utils.a().getApplicationContext();
            }
            Intrinsics.e(context);
            return bVar.b(context);
        }
        BridgeWebView bridgeWebView = c;
        c = null;
        b = null;
        b bVar2 = b.a;
        bVar2.f("get() --> 缓存命中，直接复用 --> url = " + str);
        if (bridgeWebView != null) {
            return bridgeWebView;
        }
        if (context == null) {
            context = Utils.a().getApplicationContext();
        }
        Intrinsics.e(context);
        return bVar2.b(context);
    }

    public final boolean c(String str) {
        Intrinsics.h(str, "url");
        return TextUtils.equals(str, b);
    }

    public final void d(String str) {
        Intrinsics.h(str, "url");
        if (TextUtils.equals(str, b)) {
            b.a.f("preload() --> 正在缓存的地址，无需重复创建 --> url = " + str);
            return;
        }
        b = str;
        if (Build.VERSION.SDK_INT >= 36) {
            b.a.f("preload() --> API 36+，跳过 WebView 预创建 --> url = " + str);
            return;
        }
        if (c == null) {
            b bVar = b.a;
            Context applicationContext = Utils.a().getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            c = bVar.b(applicationContext);
            bVar.f("preloadInternal() --> 不存在创建新的对象");
        }
        BridgeWebView bridgeWebView = c;
        if (bridgeWebView != null) {
            bridgeWebView.setTag(-1001, String.valueOf(System.currentTimeMillis()));
            bridgeWebView.stopLoading();
            bridgeWebView.clearHistory();
            bridgeWebView.clearCache(true);
            bridgeWebView.loadUrl("about:blank");
            bridgeWebView.loadUrl(str);
            b bVar2 = b.a;
            bVar2.f("preloadInternal() --> 创建新对象加入缓存池 --> 预加载埋点 --> url = " + str);
            bVar2.g(str, "preload");
            bridgeWebView.setTag(-1001, Boolean.TRUE);
        }
    }
}
