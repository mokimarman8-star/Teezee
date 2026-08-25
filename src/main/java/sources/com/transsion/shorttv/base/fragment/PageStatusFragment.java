package com.transsion.shorttv.base.fragment;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.v;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.util.DeviceKeyMonitor;
import com.transsion.shorttv.base.widget.NoNetworkBigView;
import com.transsion.shorttv.base.widget.StateView;
import com.transsion.shorttv.base.widget.k;
import f4.a;
import hr.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import yg.l;
import yg.m;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 q*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001JB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u000f\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\bJ\u001f\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000bH\u0016¢\u0006\u0004\b#\u0010\bJ\u000f\u0010$\u001a\u00020\u000bH\u0016¢\u0006\u0004\b$\u0010\bJ\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020%H\u0016¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020%H\u0016¢\u0006\u0004\b)\u0010'J\u000f\u0010*\u001a\u00020%H\u0016¢\u0006\u0004\b*\u0010'J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u0019\u0010/\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020%H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0012H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105J\u0011\u00106\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b6\u00102J\r\u00107\u001a\u00020\u000b¢\u0006\u0004\b7\u0010\bJ\r\u00108\u001a\u00020\u000b¢\u0006\u0004\b8\u0010\bJ\u0017\u00109\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020%¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u000b¢\u0006\u0004\b;\u0010\bJ\u0017\u0010<\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020%¢\u0006\u0004\b<\u0010:J\r\u0010=\u001a\u00020\u000b¢\u0006\u0004\b=\u0010\bJ\u000f\u0010>\u001a\u00020\u000bH\u0016¢\u0006\u0004\b>\u0010\bJ\u000f\u0010?\u001a\u00020\u000bH\u0016¢\u0006\u0004\b?\u0010\bJ\u000f\u0010@\u001a\u00020\u000bH\u0016¢\u0006\u0004\b@\u0010\bJ\u0017\u0010A\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020+H&¢\u0006\u0004\bC\u0010-J!\u0010D\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\bD\u0010\u0017J\u000f\u0010D\u001a\u00020\u000bH&¢\u0006\u0004\bD\u0010\bJ\u000f\u0010E\u001a\u00020\u000bH&¢\u0006\u0004\bE\u0010\bJ\u000f\u0010F\u001a\u00020\u000bH&¢\u0006\u0004\bF\u0010\bJ\u000f\u0010G\u001a\u00020\u000bH\u0016¢\u0006\u0004\bG\u0010\bJ\u000f\u0010H\u001a\u00020\u000bH&¢\u0006\u0004\bH\u0010\bR$\u0010P\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010W\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010_\u001a\u0004\u0018\u00010X8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0018\u0010b\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u001d\u0010l\u001a\u0004\u0018\u00010g8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010o¨\u0006r"}, d2 = {"Lcom/transsion/shorttv/base/fragment/PageStatusFragment;", "Lf4/a;", "T", "Landroidx/fragment/app/Fragment;", "Lhr/e;", "Lyg/m;", "Lcom/transsion/shorttv/base/util/DeviceKeyMonitor$b;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "logResume", "logPause", "onDestroy", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "onDisconnected", "receiveArguments", BuildConfig.FLAVOR, "isAudioShowNoNetworkLayout", "()Z", "isMonitorNetworkState", "isShowPageStateLayoutTitle", "isRegisteDeviceKeyMonitor", BuildConfig.FLAVOR, "getEmptyDescText", "()Ljava/lang/String;", "isShowTitleLayout", "getEmptyView", "(Z)Landroid/view/View;", "getNoNetworkView", "()Landroid/view/View;", BuildConfig.FLAVOR, "getScreenType", "()I", "getLoadingView", "pageStateFitStatusBar", "showContentView", "showEmptyView", "(Z)V", "showLoadingView", "showNoNetworkView", "showNoNetworkViewDelayed", "onDestroyView", "onHomeClick", "onRecentClick", "getViewBinding", "(Landroid/view/LayoutInflater;)Lf4/a;", "getPageStateLayoutTitle", "initViewData", "initViewModel", "initListener", "loadDefaultData", "retryLoadData", "Landroid/widget/ProgressBar;", "a", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "progressBar", "b", "Lf4/a;", "getMViewBinding", "()Lf4/a;", "setMViewBinding", "(Lf4/a;)V", "mViewBinding", "Landroid/widget/FrameLayout;", "c", "Landroid/widget/FrameLayout;", "getFlStateView", "()Landroid/widget/FrameLayout;", "setFlStateView", "(Landroid/widget/FrameLayout;)V", "flStateView", "d", "Landroid/view/View;", "loadingView", "Lcom/transsion/shorttv/base/util/DeviceKeyMonitor;", "e", "Lcom/transsion/shorttv/base/util/DeviceKeyMonitor;", "deviceKeyMonitor", "Lqi/b;", "f", "Lkotlin/Lazy;", "getLogViewConfig", "()Lqi/b;", "logViewConfig", "Ljava/lang/Runnable;", "g", "Ljava/lang/Runnable;", "showNoNetworkViewRunnable", "h", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class PageStatusFragment<T extends f4.a> extends Fragment implements hr.e, m, DeviceKeyMonitor.b {

    /* renamed from: a, reason: from kotlin metadata */
    private ProgressBar progressBar;

    /* renamed from: b, reason: from kotlin metadata */
    private f4.a mViewBinding;

    /* renamed from: c, reason: from kotlin metadata */
    private FrameLayout flStateView;

    /* renamed from: d, reason: from kotlin metadata */
    private View loadingView;

    /* renamed from: e, reason: from kotlin metadata */
    private DeviceKeyMonitor deviceKeyMonitor;

    /* renamed from: f, reason: from kotlin metadata */
    private final Lazy logViewConfig = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.base.fragment.c
        public final Object invoke() {
            qi.b b0;
            b0 = PageStatusFragment.b0(PageStatusFragment.this);
            return b0;
        }
    });

    /* renamed from: g, reason: from kotlin metadata */
    private Runnable showNoNetworkViewRunnable = new Runnable() { // from class: com.transsion.shorttv.base.fragment.d
        @Override // java.lang.Runnable
        public final void run() {
            PageStatusFragment.e0(PageStatusFragment.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(PageStatusFragment pageStatusFragment) {
        String f;
        qi.b logViewConfig = pageStatusFragment.getLogViewConfig();
        if (logViewConfig != null && (f = logViewConfig.f()) != null) {
            k.c(f);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(PageStatusFragment pageStatusFragment) {
        String f;
        pageStatusFragment.retryLoadData();
        qi.b logViewConfig = pageStatusFragment.getLogViewConfig();
        if (logViewConfig != null && (f = logViewConfig.f()) != null) {
            k.b(f);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qi.b b0(PageStatusFragment pageStatusFragment) {
        return pageStatusFragment.newLogViewConfig();
    }

    public static /* synthetic */ void c0(PageStatusFragment pageStatusFragment, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showEmptyView");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        pageStatusFragment.showEmptyView(z);
    }

    public static /* synthetic */ void d0(PageStatusFragment pageStatusFragment, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNoNetworkView");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        pageStatusFragment.showNoNetworkView(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(PageStatusFragment pageStatusFragment) {
        d0(pageStatusFragment, false, 1, null);
    }

    public String getEmptyDescText() {
        return BuildConfig.FLAVOR;
    }

    public View getEmptyView(boolean isShowTitleLayout) {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        stateView.showData(2, getScreenType(), isShowTitleLayout, getPageStateLayoutTitle(), getEmptyDescText());
        return stateView;
    }

    protected final FrameLayout getFlStateView() {
        return this.flStateView;
    }

    public View getLoadingView() {
        return this.loadingView;
    }

    @Override // hr.e
    public qi.b getLogViewConfig() {
        return (qi.b) this.logViewConfig.getValue();
    }

    public final f4.a getMViewBinding() {
        return this.mViewBinding;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.transsion.shorttv.base.widget.NoNetworkBigView] */
    public View getNoNetworkView() {
        String f;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        ?? noNetworkBigView = new NoNetworkBigView(requireContext, isShowPageStateLayoutTitle());
        noNetworkBigView.retry(new Function0() { // from class: com.transsion.shorttv.base.fragment.e
            public final Object invoke() {
                Unit a0;
                a0 = PageStatusFragment.a0(PageStatusFragment.this);
                return a0;
            }
        });
        noNetworkBigView.goToSetting(new Function0() { // from class: com.transsion.shorttv.base.fragment.f
            public final Object invoke() {
                Unit Z;
                Z = PageStatusFragment.Z(PageStatusFragment.this);
                return Z;
            }
        });
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (f = logViewConfig.f()) != null) {
            k.a(f);
        }
        return noNetworkBigView;
    }

    public abstract String getPageStateLayoutTitle();

    public int getScreenType() {
        return 1;
    }

    public abstract f4.a getViewBinding(LayoutInflater inflater);

    public abstract void initListener();

    public abstract void initViewData();

    public void initViewData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
    }

    public abstract void initViewModel();

    public boolean isAudioShowNoNetworkLayout() {
        return true;
    }

    public boolean isMonitorNetworkState() {
        return true;
    }

    public boolean isRegisteDeviceKeyMonitor() {
        return false;
    }

    public boolean isShowPageStateLayoutTitle() {
        return true;
    }

    public void loadDefaultData() {
    }

    public void logPause() {
        e.a.b(this);
    }

    public void logResume() {
        e.a.c(this);
    }

    public qi.b newLogViewConfig() {
        return e.a.a(this);
    }

    public void onConnected() {
        m.a.a(this);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        v.a(this).b(new PageStatusFragment$onConnected$1(this, null));
    }

    public void onCreate(Bundle savedInstanceState) {
        Context context;
        super.onCreate(savedInstanceState);
        receiveArguments();
        if (isMonitorNetworkState()) {
            l.a.l(this);
        }
        if (!isRegisteDeviceKeyMonitor() || (context = getContext()) == null) {
            return;
        }
        this.deviceKeyMonitor = new DeviceKeyMonitor(context, this);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        Intrinsics.h(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(R.layout.short_tv_fragment_default_base_layout, container, false);
        this.mViewBinding = getViewBinding(inflater);
        if (inflate != null && (frameLayout2 = (FrameLayout) inflate.findViewById(R.id.flContent)) != null) {
            f4.a aVar = this.mViewBinding;
            frameLayout2.addView(aVar != null ? aVar.getRoot() : null);
        }
        if (inflate == null || (frameLayout = (FrameLayout) inflate.findViewById(R.id.flStateView)) == null) {
            frameLayout = null;
        } else if (isAudioShowNoNetworkLayout() && !l.a.e()) {
            frameLayout.setVisibility(0);
            frameLayout.addView(getNoNetworkView());
        }
        this.flStateView = frameLayout;
        this.progressBar = inflate != null ? (ProgressBar) inflate.findViewById(R.id.progressBar) : null;
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        if (isMonitorNetworkState()) {
            l.a.m(this);
        }
        DeviceKeyMonitor deviceKeyMonitor = this.deviceKeyMonitor;
        if (deviceKeyMonitor != null) {
            deviceKeyMonitor.b();
        }
    }

    public void onDestroyView() {
        View root;
        super.onDestroyView();
        f4.a aVar = this.mViewBinding;
        if (aVar != null && (root = aVar.getRoot()) != null) {
            root.removeCallbacks(this.showNoNetworkViewRunnable);
        }
        this.showNoNetworkViewRunnable = null;
    }

    public void onDisconnected() {
    }

    @Override // com.transsion.shorttv.base.util.DeviceKeyMonitor.b
    public void onHomeClick() {
    }

    public void onPause() {
        super.onPause();
        if (isHidden()) {
            return;
        }
        logPause();
    }

    @Override // com.transsion.shorttv.base.util.DeviceKeyMonitor.b
    public void onRecentClick() {
    }

    public void onResume() {
        super.onResume();
        logResume();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViewData();
        initViewData(view, savedInstanceState);
        initViewModel();
        initListener();
        loadDefaultData();
    }

    public final void pageStateFitStatusBar() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            cr.b.a(frameLayout);
        }
    }

    public void receiveArguments() {
    }

    public abstract void retryLoadData();

    public final void showContentView() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public final void showEmptyView(boolean isShowTitleLayout) {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(getEmptyView(isShowTitleLayout));
        }
    }

    public final void showLoadingView() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            View loadingView = getLoadingView();
            if (loadingView != null) {
                frameLayout.addView(loadingView);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showNoNetworkView(boolean isShowTitleLayout) {
        FrameLayout frameLayout;
        if (getContext() == null || (frameLayout = this.flStateView) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(0);
        View noNetworkView = getNoNetworkView();
        if (noNetworkView instanceof NoNetworkBigView) {
            NoNetworkBigView.showTitle$default((NoNetworkBigView) noNetworkView, isShowTitleLayout, null, 2, null);
        }
        frameLayout.addView(noNetworkView);
    }

    public final void showNoNetworkViewDelayed() {
        View root;
        f4.a aVar = this.mViewBinding;
        if (aVar == null || (root = aVar.getRoot()) == null) {
            return;
        }
        root.postDelayed(this.showNoNetworkViewRunnable, 200L);
    }
}
