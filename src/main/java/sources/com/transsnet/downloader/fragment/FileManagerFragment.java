package com.transsnet.downloader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v;
import androidx.viewpager2.widget.ViewPager2;
import au.e;
import bx.h0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.w;
import com.therouter.TheRouter;
import com.transsion.baseui.activity.k;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.fragment.FileManagerFragment$special$;
import com.transsnet.downloader.fragment.ad.AppDownloadAdFragment;
import com.transsnet.downloader.fragment.ad.TopCardAdFragment;
import com.transsnet.downloader.manager.g;
import com.transsnet.downloader.manager.p;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import com.transsnet.downloader.viewmodel.LocalFileViewModel;
import com.transsnet.downloader.viewmodel.TransferReceivedViewModel;
import com.transsnet.downloader.widget.FileManagerTabTitleView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import com.transsnet.loginapi.bean.UserInfo;
import ij.m;
import im.f;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;
import net.lucode.hackware.magicindicator.MagicIndicator;
import uf.c;
import wf.a;
import xy.d;
import zg.b;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 h2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001iB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0019\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010!J\u0017\u0010%\u001a\u00020$2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\u00062\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0016¢\u0006\u0004\b,\u0010-J!\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b0\u00101J!\u00102\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b2\u00101J\u000f\u00103\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u0010\u0005J\r\u00104\u001a\u00020\u0006¢\u0006\u0004\b4\u0010\u0005J\u000f\u00105\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010\u0005J\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\u0005J\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\u0005J\u0017\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0006H\u0016¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010=\u001a\u00020\u0006H\u0016¢\u0006\u0004\b=\u0010\u0005J\u000f\u0010>\u001a\u00020\u0006H\u0016¢\u0006\u0004\b>\u0010\u0005J\u000f\u0010?\u001a\u00020\u0006H\u0016¢\u0006\u0004\b?\u0010\u0005R\u0016\u0010B\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010H\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010OR\u001b\u0010W\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010E\u001a\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR \u0010_\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020X0\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\"\u0010g\u001a\u00020`8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010f¨\u0006j"}, d2 = {"Lcom/transsnet/downloader/fragment/FileManagerFragment;", "Lcom/transsnet/downloader/fragment/DownloadTabBaseFragment;", "Lbx/h0;", "Lim/f;", "<init>", "()V", "", "initViewModel", "", "position", "count", "c1", "(II)V", "N0", "L0", "O0", "S0", "initAd", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "R0", "(Landroid/view/LayoutInflater;)Lbx/h0;", "Landroidx/viewpager2/widget/ViewPager2;", "z0", "()Landroidx/viewpager2/widget/ViewPager2;", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "r0", "()Lnet/lucode/hackware/magicindicator/MagicIndicator;", "t0", "(I)V", "state", "s0", "Landroidx/fragment/app/Fragment;", "d0", "(I)Landroidx/fragment/app/Fragment;", "", "", "f0", "()Ljava/util/List;", "list", "u0", "(Ljava/util/List;)V", "Landroid/view/View;", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "lazyLoadData", "b1", "onDestroy", "onStart", "onResume", "", "hidden", "onHiddenChanged", "(Z)V", "onPause", "logPause", "logResume", "onMemberStateChange", "k", "Z", "isFirstStart", "Lcom/transsnet/downloader/viewmodel/TransferReceivedViewModel;", "l", "Lkotlin/Lazy;", "Q0", "()Lcom/transsnet/downloader/viewmodel/TransferReceivedViewModel;", "mTransferViewModel", "Lcom/transsnet/downloader/viewmodel/LocalFileViewModel;", "m", "P0", "()Lcom/transsnet/downloader/viewmodel/LocalFileViewModel;", "mLocalFileViewModel", "n", "Landroidx/fragment/app/Fragment;", "topCardAdFragment", "o", "appDownloadAdFragment", "Lcom/transsnet/downloader/manager/g;", "p", "M0", "()Lcom/transsnet/downloader/manager/g;", "downloadManager", "Lcom/transsnet/downloader/fragment/DownloadListBaseFragment;", "q", "Lcom/transsnet/downloader/fragment/DownloadListBaseFragment;", "currentFragment", "", "r", "Ljava/util/Map;", "fragmentMap", "", "s", "J", "getResumeTimeStamp", "()J", "setResumeTimeStamp", "(J)V", "resumeTimeStamp", "t", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class FileManagerFragment extends DownloadTabBaseFragment<h0> implements f {
    public static final a t = new a((DefaultConstructorMarker) null);

    /* renamed from: n, reason: from kotlin metadata */
    private Fragment topCardAdFragment;

    /* renamed from: o, reason: from kotlin metadata */
    private Fragment appDownloadAdFragment;

    /* renamed from: q, reason: from kotlin metadata */
    private DownloadListBaseFragment currentFragment;

    /* renamed from: s, reason: from kotlin metadata */
    private long resumeTimeStamp;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean isFirstStart = true;

    /* renamed from: l, reason: from kotlin metadata */
    private final Lazy mTransferViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(TransferReceivedViewModel.class), new FileManagerFragment$special$.inlined.activityViewModels.default.1(this), new FileManagerFragment$special$.inlined.activityViewModels.default.2(this));

    /* renamed from: m, reason: from kotlin metadata */
    private final Lazy mLocalFileViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(LocalFileViewModel.class), new FileManagerFragment$special$.inlined.activityViewModels.default.3(this), new FileManagerFragment$special$.inlined.activityViewModels.default.4(this));

    /* renamed from: p, reason: from kotlin metadata */
    private final Lazy downloadManager = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.w5
        public final Object invoke() {
            g K0;
            K0 = FileManagerFragment.K0();
            return K0;
        }
    });

    /* renamed from: r, reason: from kotlin metadata */
    private final Map fragmentMap = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static final g K0() {
        return p.a.a(Utils.a());
    }

    private final void L0() {
        j0().H();
        TransferReceivedViewModel.i(Q0(), false, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g M0() {
        return (g) this.downloadManager.getValue();
    }

    private final void N0() {
        j0().P();
    }

    private final void O0() {
        LocalFileViewModel.k(P0(), false, 1, (Object) null);
    }

    private final LocalFileViewModel P0() {
        return (LocalFileViewModel) this.mLocalFileViewModel.getValue();
    }

    private final TransferReceivedViewModel Q0() {
        return (TransferReceivedViewModel) this.mTransferViewModel.getValue();
    }

    private final void S0() {
        b6 b6Var = new b6(this);
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadRefreshEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(this, name, state, y0.c().p(), false, b6Var);
        c6 c6Var = new c6(this);
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = AddToDownloadEvent.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.observeEvent(this, name2, state, y0.c().p(), false, c6Var);
        d6 d6Var = new d6(this);
        FlowEventBus flowEventBus3 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name3 = e.class.getName();
        Intrinsics.g(name3, "getName(...)");
        flowEventBus3.observeEvent(this, name3, state, y0.c().p(), false, d6Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(FileManagerFragment fileManagerFragment, DownloadRefreshEvent downloadRefreshEvent) {
        Intrinsics.h(downloadRefreshEvent, "value");
        String resourceId = downloadRefreshEvent.getResourceId();
        if (resourceId == null || resourceId.length() == 0) {
            fileManagerFragment.j0().H();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit U0(FileManagerFragment fileManagerFragment, AddToDownloadEvent addToDownloadEvent) {
        FrameLayout frameLayout;
        Intrinsics.h(addToDownloadEvent, "value");
        h0 mViewBinding = fileManagerFragment.getMViewBinding();
        if (mViewBinding != null && (frameLayout = mViewBinding.d) != null && frameLayout.getVisibility() != 0 && fileManagerFragment.isVisible() && addToDownloadEvent.getAdd()) {
            fileManagerFragment.N0();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(FileManagerFragment fileManagerFragment, e eVar) {
        Intrinsics.h(eVar, "value");
        a.a.c("Transfer_d", "TransferFinishEvent， 有传输完成，刷新页面", true);
        fileManagerFragment.j0().r0(eVar.a(), new e6(fileManagerFragment));
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(FileManagerFragment fileManagerFragment) {
        TransferReceivedViewModel.i(fileManagerFragment.Q0(), false, 1, (Object) null);
        fileManagerFragment.j0().d0().q(Boolean.TRUE);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(FileManagerFragment fileManagerFragment, List list) {
        fileManagerFragment.c1(0, list != null ? list.size() : 0);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(FileManagerFragment fileManagerFragment, List list) {
        fileManagerFragment.c1(1, list != null ? list.size() : 0);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(FileManagerFragment fileManagerFragment, List list) {
        fileManagerFragment.c1(2, list != null ? list.size() : 0);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a1(FileManagerFragment fileManagerFragment, List list) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            a.a.x(a.a, fileManagerFragment.getTAG(), "downloading null- hide fragment", false, 4, (Object) null);
            h0 mViewBinding = fileManagerFragment.getMViewBinding();
            if (mViewBinding != null && (frameLayout = mViewBinding.d) != null) {
                c.g(frameLayout);
            }
        } else {
            h0 mViewBinding2 = fileManagerFragment.getMViewBinding();
            if (mViewBinding2 == null || (frameLayout3 = mViewBinding2.d) == null || frameLayout3.getVisibility() != 0) {
                h0 mViewBinding3 = fileManagerFragment.getMViewBinding();
                if (mViewBinding3 != null && (frameLayout2 = mViewBinding3.d) != null) {
                    c.k(frameLayout2);
                }
                a.a aVar = a.a;
                a.a.f(aVar, fileManagerFragment.getTAG(), "downloading have data, show fragment", false, 4, (Object) null);
                DownloadingListFragment k0 = fileManagerFragment.getChildFragmentManager().k0("DownloadingListFragment");
                if (k0 == null) {
                    k0 = new DownloadingListFragment();
                }
                DownloadingListFragment downloadingListFragment = k0;
                if (downloadingListFragment.isAdded()) {
                    a.a.f(aVar, fileManagerFragment.getTAG(), "downloading have data, isAdded, show", false, 4, (Object) null);
                    fileManagerFragment.getChildFragmentManager().p().y(downloadingListFragment).l();
                } else {
                    a.a.f(aVar, fileManagerFragment.getTAG(), "downloading have data, add", false, 4, (Object) null);
                    fileManagerFragment.getChildFragmentManager().p().c(R$id.flDownloadingContainer, downloadingListFragment, "DownloadingListFragment").l();
                }
            } else {
                a.a.f(a.a, fileManagerFragment.getTAG(), "downloading have data, fragment is shown", false, 4, (Object) null);
            }
        }
        return Unit.a;
    }

    private final void c1(int position, int count) {
        String str;
        a.a.x(a.a, getTAG(), "updateTabTitle - position:" + position + ",count:" + count, false, 4, (Object) null);
        if (position >= i0().size()) {
            return;
        }
        Object obj = i0().get(position);
        if (count > 0) {
            str = " " + count;
        } else {
            str = "";
        }
        String str2 = obj + str;
        ORCommonNavigator g0 = g0();
        d pagerTitleView = g0 != null ? g0.getPagerTitleView(position) : null;
        FileManagerTabTitleView fileManagerTabTitleView = pagerTitleView instanceof FileManagerTabTitleView ? (FileManagerTabTitleView) pagerTitleView : null;
        if (fileManagerTabTitleView != null) {
            fileManagerTabTitleView.setTitle(str2, count, position);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAd() {
        Fragment k0 = getChildFragmentManager().k0("TopCardAdFragment");
        this.topCardAdFragment = k0;
        if (k0 == null) {
            this.topCardAdFragment = new TopCardAdFragment();
        }
        Fragment fragment = this.topCardAdFragment;
        if (fragment != null) {
            m mVar = m.a;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            m.b(mVar, childFragmentManager, R$id.flTopCardAd, fragment, false, (String) null, 24, (Object) null);
        }
        Fragment k02 = getChildFragmentManager().k0("AppDownloadAdFragment");
        this.appDownloadAdFragment = k02;
        if (k02 == null) {
            this.appDownloadAdFragment = new AppDownloadAdFragment();
        }
        Fragment fragment2 = this.appDownloadAdFragment;
        if (fragment2 != null) {
            m mVar2 = m.a;
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.g(childFragmentManager2, "getChildFragmentManager(...)");
            m.b(mVar2, childFragmentManager2, R$id.flAppDownloadAd, fragment2, false, (String) null, 24, (Object) null);
        }
    }

    private final void initViewModel() {
        j0().O().j(this, new b(new x5(this)));
        P0().i().j(this, new b(new y5(this)));
        Q0().j().j(this, new b(new z5(this)));
        j0().Q().j(this, new b(new a6(this)));
        L0();
        O0();
    }

    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public h0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        h0 c = h0.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b1() {
        AppCompatTextView appCompatTextView;
        long a = w.a();
        if (a > 0) {
            String a2 = b.a(a, 1);
            h0 mViewBinding = getMViewBinding();
            if (mViewBinding == null || (appCompatTextView = mViewBinding.g) == null) {
                return;
            }
            appCompatTextView.setText(a2);
        }
    }

    public Fragment d0(int position) {
        TransferReceivedFragment a;
        if (position == 0) {
            a = DownloadedListFragment.k.a();
            this.fragmentMap.put(Integer.valueOf(position), a);
        } else if (position == 1) {
            a = LocalFileListFragment.o.a();
            this.fragmentMap.put(Integer.valueOf(position), a);
        } else {
            if (position != 2) {
                return DownloadedListFragment.k.a();
            }
            a = TransferReceivedFragment.l.a();
            this.fragmentMap.put(Integer.valueOf(position), a);
        }
        return a;
    }

    public List f0() {
        return (List) j0().K().f();
    }

    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        b1();
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new initData.1(this, (Continuation) null), 3, (Object) null);
        DownloadSDCardUtil.a.b();
        initViewModel();
        S0();
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.initView(view, savedInstanceState);
        initAd();
    }

    public void lazyLoadData() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void logPause() {
        super/*com.transsion.baseui.fragment.BaseFragment*/.logPause();
        if (this.resumeTimeStamp != 0) {
            com.transsion.baselib.report.e.a.n("downloadpage", Long.valueOf(SystemClock.elapsedRealtime() - this.resumeTimeStamp), getContext());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void logResume() {
        super/*com.transsion.baseui.fragment.BaseFragment*/.logResume();
        this.resumeTimeStamp = SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle savedInstanceState) {
        super/*com.transsion.baseui.fragment.BaseFragment*/.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        y0(arguments != null ? arguments.getInt("extra_page_index") : 0);
        if (p.a.a(Utils.a()).i()) {
            y0(0);
        }
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.D(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.v(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onHiddenChanged(boolean hidden) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        if (hidden) {
            return;
        }
        TopCardAdFragment topCardAdFragment = this.topCardAdFragment;
        TopCardAdFragment topCardAdFragment2 = topCardAdFragment instanceof TopCardAdFragment ? topCardAdFragment : null;
        if (topCardAdFragment2 != null) {
            topCardAdFragment2.k0();
        }
        Fragment fragment = this.appDownloadAdFragment;
        AppDownloadAdFragment appDownloadAdFragment = fragment instanceof AppDownloadAdFragment ? (AppDownloadAdFragment) fragment : null;
        if (appDownloadAdFragment != null) {
            appDownloadAdFragment.o0();
        }
        L0();
    }

    public void onMemberStateChange() {
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        boolean e = bVar != null ? bVar.e() : false;
        a.a.f(a.a, "co_mem", "下载管理页面收到回调 --> skipShowAd = " + e, false, 4, (Object) null);
        ax.b bVar2 = new ax.b();
        qx.a aVar = (qx.a) TheRouter.d(qx.a.class, new Object[0]);
        UserInfo i = aVar != null ? aVar.i() : null;
        if (i == null || i.getUserType() != 0) {
            im.b bVar3 = (im.b) TheRouter.d(im.b.class, new Object[0]);
            bVar2.i(bVar3 != null ? bVar3.B() : 1);
        } else {
            bVar2.i(1);
        }
        p.a aVar2 = p.a;
        p.a.b(aVar2, (Context) null, 1, (Object) null).G(bVar2);
        p.a.b(aVar2, (Context) null, 1, (Object) null).v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super/*com.transsion.baseui.fragment.BaseFragment*/.onPause();
        k.l((String) null, this, (String) null, 5, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        super/*com.transsion.baseui.fragment.BaseFragment*/.onResume();
        k.p((String) null, this, "visible=" + isVisible(), 1, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
        if (isVisible()) {
            if (this.isFirstStart) {
                this.isFirstStart = false;
            } else {
                L0();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MagicIndicator r0() {
        h0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.f;
        }
        return null;
    }

    public void s0(int state) {
    }

    public void t0(int position) {
        this.currentFragment = (DownloadListBaseFragment) this.fragmentMap.get(Integer.valueOf(position));
    }

    public void u0(List list) {
        j0().K().q(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewPager2 z0() {
        h0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.h;
        }
        return null;
    }
}
