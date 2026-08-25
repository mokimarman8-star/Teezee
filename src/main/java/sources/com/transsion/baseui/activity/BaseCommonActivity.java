package com.transsion.baseui.activity;

import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.i;
import androidx.compose.runtime.v1;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.blankj.utilcode.util.a0;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.util.c;
import f4.a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import qi.h;
import yg.l;
import yg.m;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\b'\u0018\u0000 1*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004:\u00012B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00028\u0000H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H$¢\u0006\u0004\b\u001a\u0010\u0006J\u001f\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\u0006J\u000f\u0010\"\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\u0007H\u0014¢\u0006\u0004\b#\u0010\u0006J\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010\u0006J\u000f\u0010%\u001a\u00020\u0007H\u0014¢\u0006\u0004\b%\u0010\u0006J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\fH\u0016¢\u0006\u0004\b)\u0010\u000eJ\u000f\u0010*\u001a\u00020\u0007H\u0007¢\u0006\u0004\b*\u0010+R\"\u0010,\u001a\u00028\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/transsion/baseui/activity/BaseCommonActivity;", "Lf4/a;", "T", "Landroidx/appcompat/app/AppCompatActivity;", "Lyg/m;", "<init>", "()V", "", "U", "Landroid/view/View;", "S", "()Landroid/view/View;", "", "getClassTag", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "intercept", "(Landroid/content/Context;Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "getViewBinding", "()Lf4/a;", "setView", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "onDisconnected", "onResume", "onPause", "finish", "onDestroy", "", "isMonitorNetworkState", "()Z", "getPageName", "EnterHomeView", "(Landroidx/compose/runtime/i;I)V", "mViewBinding", "Lf4/a;", "getMViewBinding", "setMViewBinding", "(Lf4/a;)V", "Companion", "a", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class BaseCommonActivity<T extends a> extends AppCompatActivity implements m {
    public static final String EXTRA_SHOW_HOME_BUTTON = "show_enter_home";
    public static final String TAG = "BaseCommonActivity";
    public T mViewBinding;
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(BaseCommonActivity baseCommonActivity) {
        if (c.a.a(R$mipmap.ic_tab_home, 2000L)) {
            return Unit.a;
        }
        Navigator.x(TheRouter.c("/main/tab").F("tabIndex", 0), baseCommonActivity, (mf.c) null, 2, (Object) null);
        h hVar = h.a;
        String pageName = baseCommonActivity.getPageName();
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "deeplink_enter_home_click");
        Unit unit = Unit.a;
        hVar.o(pageName, hashMap);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(BaseCommonActivity baseCommonActivity, int i, i iVar, int i2) {
        baseCommonActivity.EnterHomeView(iVar, v1.a(i | 1));
        return Unit.a;
    }

    private final View S() {
        ComposeView composeView = new ComposeView(this, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        ViewTreeLifecycleOwner.b(composeView, this);
        ViewTreeViewModelStoreOwner.b(composeView, this);
        ViewTreeSavedStateRegistryOwner.b(composeView, this);
        composeView.setContent(androidx.compose.runtime.internal.b.b(-541145127, true, new b(this)));
        return composeView;
    }

    private final void U() {
        if (getIntent().getBooleanExtra(EXTRA_SHOW_HOME_BUTTON, false)) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.gravity = 8388691;
            layoutParams.y = a0.a(120.0f);
            layoutParams.flags = 136;
            layoutParams.format = -3;
            getWindowManager().addView(S(), layoutParams);
            h hVar = h.a;
            String pageName = getPageName();
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "deeplink_enter_home_browse");
            Unit unit = Unit.a;
            hVar.z(pageName, hashMap);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
    
        if (r6 == r5.a()) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void EnterHomeView(androidx.compose.runtime.i r30, int r31) {
        /*
            Method dump skipped, instructions count: 551
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.baseui.activity.BaseCommonActivity.EnterHomeView(androidx.compose.runtime.i, int):void");
    }

    @Override // android.app.Activity
    public void finish() {
        if (getIntent().getBooleanExtra(EXTRA_SHOW_HOME_BUTTON, false)) {
            finishAffinity();
        }
        super.finish();
    }

    public final String getClassTag() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final T getMViewBinding() {
        T t = this.mViewBinding;
        if (t != null) {
            return t;
        }
        Intrinsics.y("mViewBinding");
        return null;
    }

    public String getPageName() {
        return "";
    }

    public abstract a getViewBinding();

    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:3:0x0001, B:7:0x0006, B:9:0x0014, B:15:0x0027, B:17:0x003a, B:19:0x0040, B:20:0x0046, B:22:0x004c, B:24:0x005b, B:26:0x0061, B:27:0x0067, B:29:0x0085, B:32:0x008a, B:39:0x0096, B:40:0x009d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void intercept(android.content.Context r9, android.os.Bundle r10) {
        /*
            r8 = this;
            r0 = 1
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L1f
            if (r10 != 0) goto L6
            return
        L6:
            tg.b r1 = tg.b.a     // Catch: java.lang.Throwable -> L1f
            java.lang.String r1 = r1.n()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r2 = "9"
            boolean r2 = android.text.TextUtils.equals(r1, r2)     // Catch: java.lang.Throwable -> L1f
            if (r2 != 0) goto L22
            java.lang.String r2 = "10"
            boolean r1 = android.text.TextUtils.equals(r1, r2)     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L1d
            goto L22
        L1d:
            r1 = 0
            goto L23
        L1f:
            r9 = move-exception
            goto La4
        L22:
            r1 = r0
        L23:
            if (r9 == 0) goto L9d
            if (r1 == 0) goto L9d
            java.lang.Class r1 = r9.getClass()     // Catch: java.lang.Throwable -> L1f
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch: java.lang.Throwable -> L1f
            r10.setClassLoader(r1)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r1 = "androidx.lifecycle.BundlableSavedStateRegistry.key"
            android.os.Bundle r10 = r10.getBundle(r1)     // Catch: java.lang.Throwable -> L1f
            if (r10 == 0) goto L96
            java.util.Set r1 = r10.keySet()     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L96
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L1f
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1f
        L46:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L1f
            if (r2 == 0) goto L96
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r3 = r10.get(r2)     // Catch: java.lang.Throwable -> L1f
            boolean r4 = r3 instanceof android.os.Bundle     // Catch: java.lang.Throwable -> L1f
            r5 = 0
            if (r4 == 0) goto L5e
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch: java.lang.Throwable -> L1f
            goto L5f
        L5e:
            r3 = r5
        L5f:
            if (r3 == 0) goto L66
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch: java.lang.Throwable -> L1f
            goto L67
        L66:
            r3 = r5
        L67:
            wf.a$a r4 = wf.a.a     // Catch: java.lang.Throwable -> L1f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r6.<init>()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r7 = "BaseCommonActivity --> intercept() --> classLoader = "
            r6.append(r7)     // Catch: java.lang.Throwable -> L1f
            r6.append(r3)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L1f
            r4.j(r3, r0)     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r2 = r10.get(r2)     // Catch: java.lang.Throwable -> L1f
            boolean r3 = r2 instanceof android.os.Bundle     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto L88
            r5 = r2
            android.os.Bundle r5 = (android.os.Bundle) r5     // Catch: java.lang.Throwable -> L1f
        L88:
            if (r5 == 0) goto L46
            java.lang.Class r2 = r9.getClass()     // Catch: java.lang.Throwable -> L1f
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch: java.lang.Throwable -> L1f
            r5.setClassLoader(r2)     // Catch: java.lang.Throwable -> L1f
            goto L46
        L96:
            wf.a$a r9 = wf.a.a     // Catch: java.lang.Throwable -> L1f
            java.lang.String r10 = "BaseCommonActivity --> intercept() --> 当前系统版本9、10 替换BootClassLoader -- ClassLoader"
            r9.j(r10, r0)     // Catch: java.lang.Throwable -> L1f
        L9d:
            kotlin.Unit r9 = kotlin.Unit.a     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r9 = kotlin.Result.m34constructorimpl(r9)     // Catch: java.lang.Throwable -> L1f
            goto Lae
        La4:
            kotlin.Result$Companion r10 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.a(r9)
            java.lang.Object r9 = kotlin.Result.m34constructorimpl(r9)
        Lae:
            java.lang.Throwable r9 = kotlin.Result.m37exceptionOrNullimpl(r9)
            if (r9 != 0) goto Lb5
            goto Lcb
        Lb5:
            wf.a$a r10 = wf.a.a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "BaseCommonActivity --> intercept() --> it = "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r10.j(r9, r0)
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.baseui.activity.BaseCommonActivity.intercept(android.content.Context, android.os.Bundle):void");
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
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        intercept(this, savedInstanceState);
        super.onCreate(savedInstanceState);
        if (isMonitorNetworkState()) {
            l.a.l(this);
        }
        setMViewBinding(getViewBinding());
        setView();
        U();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isMonitorNetworkState()) {
            l.a.m(this);
        }
        k.f((String) null, this, 1, (Object) null);
    }

    public void onDisconnected() {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        k.k((String) null, this, 1, (Object) null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        Intent launchIntentForPackage;
        try {
            super.onResume();
            k.o((String) null, this, 1, (Object) null);
        } catch (IllegalArgumentException unused) {
            if (isTaskRoot()) {
                String simpleName = getClass().getSimpleName();
                Intrinsics.g(simpleName, "getSimpleName(...)");
                if (StringsKt.c0(simpleName, "MainActivity", false, 2, (Object) null) && (launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName())) != null) {
                    launchIntentForPackage.addFlags(268468224);
                    startActivity(launchIntentForPackage);
                }
            }
            finish();
        }
    }

    public final void setMViewBinding(T t) {
        Intrinsics.h(t, "<set-?>");
        this.mViewBinding = t;
    }

    protected abstract void setView();
}
