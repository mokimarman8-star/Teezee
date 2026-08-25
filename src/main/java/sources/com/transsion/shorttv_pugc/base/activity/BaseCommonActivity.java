package com.transsion.shorttv_pugc.base.activity;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import f4.a;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import yg.l;
import yg.m;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000 +*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004:\u0001%B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00028\u0000H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH$¢\u0006\u0004\b\u0013\u0010\u0006J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001b\u0010\u0006J\u000f\u0010\u001c\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001c\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u0006J\u000f\u0010\u001e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001e\u0010\u0006J\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$R\"\u0010*\u001a\u00028\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/transsion/shorttv_pugc/base/activity/BaseCommonActivity;", "Lf4/a;", "T", "Landroidx/appcompat/app/AppCompatActivity;", "Lyg/m;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", HttpUrl.FRAGMENT_ENCODE_SET, "intercept", "(Landroid/content/Context;Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "getViewBinding", "()Lf4/a;", "setView", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "onDisconnected", "onResume", "onPause", "finish", "onDestroy", HttpUrl.FRAGMENT_ENCODE_SET, "isMonitorNetworkState", "()Z", HttpUrl.FRAGMENT_ENCODE_SET, "getPageName", "()Ljava/lang/String;", "a", "Lf4/a;", "getMViewBinding", "setMViewBinding", "(Lf4/a;)V", "mViewBinding", "b", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class BaseCommonActivity<T extends f4.a> extends AppCompatActivity implements m {

    /* renamed from: a, reason: from kotlin metadata */
    public f4.a mViewBinding;

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        if (getIntent().getBooleanExtra("show_enter_home", false)) {
            finishAffinity();
        }
        super/*android.app.Activity*/.finish();
    }

    public final f4.a getMViewBinding() {
        f4.a aVar = this.mViewBinding;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.y("mViewBinding");
        return null;
    }

    public String getPageName() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public abstract f4.a getViewBinding();

    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:3:0x0001, B:7:0x0006, B:9:0x0014, B:15:0x0027, B:17:0x003a, B:19:0x0040, B:20:0x0046, B:22:0x004c, B:24:0x005b, B:26:0x0061, B:27:0x0067, B:29:0x0085, B:32:0x008a, B:39:0x0096, B:40:0x009d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void intercept(Context context, Bundle bundle) {
        Object obj;
        Throwable th;
        boolean z;
        Bundle bundle2;
        Set<String> keySet;
        try {
            Result$Companion result$Companion = Result.Companion;
        } catch (Throwable th2) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (bundle == null) {
            return;
        }
        String n = tg.b.a.n();
        if (!TextUtils.equals(n, "9") && !TextUtils.equals(n, "10")) {
            z = false;
            if (context != null && z) {
                bundle.setClassLoader(context.getClass().getClassLoader());
                bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                if (bundle2 != null && (keySet = bundle2.keySet()) != null) {
                    for (String str : keySet) {
                        Object obj2 = bundle2.get(str);
                        Bundle bundle3 = obj2 instanceof Bundle ? (Bundle) obj2 : null;
                        ClassLoader classLoader = bundle3 != null ? bundle3.getClassLoader() : null;
                        wf.a.a.j("BaseCommonActivity --> intercept() --> classLoader = " + classLoader, true);
                        Object obj3 = bundle2.get(str);
                        Bundle bundle4 = obj3 instanceof Bundle ? (Bundle) obj3 : null;
                        if (bundle4 != null) {
                            bundle4.setClassLoader(context.getClass().getClassLoader());
                        }
                    }
                }
                wf.a.a.j("BaseCommonActivity --> intercept() --> 当前系统版本9、10 替换BootClassLoader -- ClassLoader", true);
            }
            obj = Result.constructor-impl(Unit.a);
            th = Result.exceptionOrNull-impl(obj);
            if (th != null) {
                return;
            }
            wf.a.a.j("BaseCommonActivity --> intercept() --> it = " + th, true);
            return;
        }
        z = true;
        if (context != null) {
            bundle.setClassLoader(context.getClass().getClassLoader());
            bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            if (bundle2 != null) {
                while (r1.hasNext()) {
                }
            }
            wf.a.a.j("BaseCommonActivity --> intercept() --> 当前系统版本9、10 替换BootClassLoader -- ClassLoader", true);
        }
        obj = Result.constructor-impl(Unit.a);
        th = Result.exceptionOrNull-impl(obj);
        if (th != null) {
        }
    }

    public boolean isMonitorNetworkState() {
        return true;
    }

    public void onConnected() {
        m.a.a(this);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        intercept(this, savedInstanceState);
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        if (isMonitorNetworkState()) {
            l.a.l(this);
        }
        setMViewBinding(getViewBinding());
        setView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDestroy() {
        super.onDestroy();
        if (isMonitorNetworkState()) {
            l.a.m(this);
        }
        e.b(null, this, 1, null);
    }

    public void onDisconnected() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        e.d(null, this, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        e.f(null, this, 1, null);
    }

    public final void setMViewBinding(f4.a aVar) {
        Intrinsics.h(aVar, "<set-?>");
        this.mViewBinding = aVar;
    }

    protected abstract void setView();
}
