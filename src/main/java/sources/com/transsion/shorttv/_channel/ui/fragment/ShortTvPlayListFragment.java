package com.transsion.shorttv._channel.ui.fragment;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.os.d;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.c0;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.google.android.material.appbar.AppBarLayout;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import com.transsion.shorttv._channel.model.ShortTvPlayListResp;
import com.transsion.shorttv._channel.model.ShortTvPlayListType;
import com.transsion.shorttv._channel.ui.activity.ShortTvPlayListActivity;
import com.transsion.shorttv._channel.ui.adapter.a;
import com.transsion.shorttv._channel.ui.adapter.e;
import com.transsion.shorttv._channel.ui.fragment.ShortTvPlayListFragment;
import com.transsion.shorttv._channel.ui.viewmodel.ShortTvPlayListViewModel;
import com.transsion.shorttv.base.fragment.PageStatusFragment;
import com.transsion.shorttv.bean.Cover;
import com.transsion.shorttv.bean.Staff;
import com.transsion.shorttv.bean.Subject;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.y0;
import ni.f;
import org.json.JSONObject;
import qr.b0;
import r6.f;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Z2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001[B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001f\u0010\u0018J\u000f\u0010 \u001a\u00020\u0012H\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0012H\u0002¢\u0006\u0004\b!\u0010\u0004J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0007J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\u0007J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0012H\u0016¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0012H\u0016¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010-\u001a\u00020\u0012H\u0016¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0012H\u0016¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u0010\u0007J\u000f\u00100\u001a\u00020\u0012H\u0016¢\u0006\u0004\b0\u0010\u0004J\u000f\u00101\u001a\u00020\u0012H\u0016¢\u0006\u0004\b1\u0010\u0004J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0012H\u0016¢\u0006\u0004\b5\u0010\u0004R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010;R\u0018\u0010B\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010;R\u0016\u0010E\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001b\u0010U\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006\\"}, d2 = {"Lcom/transsion/shorttv/_channel/ui/fragment/ShortTvPlayListFragment;", "Lcom/transsion/shorttv/base/fragment/PageStatusFragment;", "Lqr/b0;", "<init>", "()V", BuildConfig.FLAVOR, "Q0", "()Z", "Lcom/transsion/shorttv/_channel/ui/adapter/a;", "E0", "()Lcom/transsion/shorttv/_channel/ui/adapter/a;", "Lcom/transsion/shorttv/_channel/ui/adapter/e;", "I0", "()Lcom/transsion/shorttv/_channel/ui/adapter/e;", "Lcom/transsion/shorttv/bean/Subject;", "subjectItem", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "A0", "(Lcom/transsion/shorttv/bean/Subject;I)V", "Lcom/transsion/shorttv/_channel/model/ShortTvPlayListResp;", "playListResp", "U0", "(Lcom/transsion/shorttv/_channel/model/ShortTvPlayListResp;)V", "reload", "loadData", "loadMore", "isExpand", "z0", "(Z)V", "V0", "S0", "initAd", "Landroid/view/LayoutInflater;", "inflater", "C0", "(Landroid/view/LayoutInflater;)Lqr/b0;", "isShowPageStateLayoutTitle", "isAudioShowNoNetworkLayout", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "receiveArguments", "initViewData", "initViewModel", "initListener", "isMonitorNetworkState", "retryLoadData", "loadDefaultData", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "onDestroy", "Lcom/transsion/shorttv/_channel/ui/viewmodel/ShortTvPlayListViewModel;", "i", "Lcom/transsion/shorttv/_channel/ui/viewmodel/ShortTvPlayListViewModel;", "viewModel", "j", "Ljava/lang/String;", "mLabel", "k", "mCategory", "l", "mRecType", "m", "mTopIds", "n", "I", "mTabId", "Lbr/b;", "o", "Lbr/b;", "mExposureHelper", "p", "Lcom/transsion/shorttv/_channel/ui/adapter/e;", "mSubjectAdapter", "q", "Lcom/transsion/shorttv/_channel/ui/adapter/a;", "mCastAdapter", "Lxq/d;", "r", "Lkotlin/Lazy;", "B0", "()Lxq/d;", "mPlayListDotHelper", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "s", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "v3ListManager", "t", "a", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvPlayListFragment extends PageStatusFragment<b0> {

    /* renamed from: t, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: from kotlin metadata */
    private ShortTvPlayListViewModel viewModel;

    /* renamed from: j, reason: from kotlin metadata */
    private String mLabel;

    /* renamed from: k, reason: from kotlin metadata */
    private String mCategory;

    /* renamed from: l, reason: from kotlin metadata */
    private String mRecType;

    /* renamed from: m, reason: from kotlin metadata */
    private String mTopIds;

    /* renamed from: n, reason: from kotlin metadata */
    private int mTabId;

    /* renamed from: o, reason: from kotlin metadata */
    private br.b mExposureHelper;

    /* renamed from: p, reason: from kotlin metadata */
    private e mSubjectAdapter;

    /* renamed from: q, reason: from kotlin metadata */
    private a mCastAdapter;

    /* renamed from: r, reason: from kotlin metadata */
    private final Lazy mPlayListDotHelper = LazyKt.b(new Function0() { // from class: uq.p
        public final Object invoke() {
            xq.d R0;
            R0 = ShortTvPlayListFragment.R0();
            return R0;
        }
    });

    /* renamed from: s, reason: from kotlin metadata */
    private BiddingListManager v3ListManager;

    /* renamed from: com.transsion.shorttv._channel.ui.fragment.ShortTvPlayListFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortTvPlayListFragment a(String str, String str2, String str3, String str4, int i) {
            ShortTvPlayListFragment shortTvPlayListFragment = new ShortTvPlayListFragment();
            shortTvPlayListFragment.setArguments(d.b(new Pair[]{TuplesKt.a("label", str), TuplesKt.a("category", str2), TuplesKt.a("recType", str3), TuplesKt.a("topIds", str4), TuplesKt.a("tab_id", Integer.valueOf(i))}));
            return shortTvPlayListFragment;
        }
    }

    public static final class b implements br.a {
        b() {
        }

        @Override // br.a
        public void a(int i, long j, View view) {
            Boolean hasResource;
            List data;
            List data2;
            boolean z = false;
            r13 = 0;
            int i2 = 0;
            z = false;
            if (ShortTvPlayListFragment.this.Q0()) {
                a aVar = ShortTvPlayListFragment.this.mCastAdapter;
                if (aVar != null && (data2 = aVar.getData()) != null) {
                    i2 = data2.size();
                }
                if (i >= i2) {
                    return;
                }
                a aVar2 = ShortTvPlayListFragment.this.mCastAdapter;
                Staff staff = aVar2 != null ? (Staff) aVar2.getItem(i) : null;
                ShortTvPlayListFragment.this.B0().b("playlist", staff != null ? staff.getStaffId() : null, staff != null ? staff.getOps() : null, Integer.valueOf(i), ShortTvPlayListFragment.this.mCategory, ShortTvPlayListFragment.this.mRecType, ShortTvPlayListFragment.this.mLabel);
                return;
            }
            e eVar = ShortTvPlayListFragment.this.mSubjectAdapter;
            if (i >= ((eVar == null || (data = eVar.getData()) == null) ? 0 : data.size())) {
                return;
            }
            e eVar2 = ShortTvPlayListFragment.this.mSubjectAdapter;
            Subject subject = eVar2 != null ? (Subject) eVar2.getItem(i) : null;
            xq.d B0 = ShortTvPlayListFragment.this.B0();
            String subjectId = subject != null ? subject.getSubjectId() : null;
            String ops = subject != null ? subject.getOps() : null;
            Integer valueOf = Integer.valueOf(i);
            if (subject != null && (hasResource = subject.getHasResource()) != null) {
                z = hasResource.booleanValue();
            }
            B0.d("playlist", subjectId, ops, valueOf, z, ShortTvPlayListFragment.this.mCategory, ShortTvPlayListFragment.this.mRecType, ShortTvPlayListFragment.this.mLabel);
        }
    }

    static final class c implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    private final void A0(Subject subjectItem, int position) {
        Boolean hasResource;
        FragmentActivity context = getContext();
        if (context != null) {
            rr.a.a.a(context, "playlist", subjectItem != null ? subjectItem.getOps() : null, (r21 & 8) != 0 ? null : "download_subject", (r21 & 16) != 0 ? false : true, (r21 & 32) != 0 ? null : subjectItem, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? Boolean.FALSE : Boolean.TRUE);
            B0().a("playlist", "download_subject", subjectItem != null ? subjectItem.getSubjectId() : null, subjectItem != null ? subjectItem.getOps() : null, Integer.valueOf(position), (subjectItem == null || (hasResource = subjectItem.getHasResource()) == null) ? false : hasResource.booleanValue(), this.mCategory, this.mRecType, this.mLabel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xq.d B0() {
        return (xq.d) this.mPlayListDotHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(ShortTvPlayListFragment shortTvPlayListFragment, int i, BiddingNativeManager biddingNativeManager) {
        List data;
        List data2;
        Intrinsics.h(biddingNativeManager, "current");
        if (biddingNativeManager != null) {
            int i2 = 0;
            if (shortTvPlayListFragment.Q0()) {
                Staff staff = new Staff();
                staff.setNonAdDelegate(biddingNativeManager);
                a aVar = shortTvPlayListFragment.mCastAdapter;
                if (aVar != null && (data2 = aVar.getData()) != null) {
                    i2 = data2.size();
                }
                if (i < i2) {
                    a aVar2 = shortTvPlayListFragment.mCastAdapter;
                    if (aVar2 != null) {
                        aVar2.n(i, staff);
                    }
                } else {
                    a aVar3 = shortTvPlayListFragment.mCastAdapter;
                    if (aVar3 != null) {
                        aVar3.p(staff);
                    }
                }
            } else {
                Subject subject = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, false, null, null, 0, 0, null, 0, null, 0, null, -1, 1073741823, null);
                subject.setNonAdDelegate(biddingNativeManager);
                e eVar = shortTvPlayListFragment.mSubjectAdapter;
                if (eVar != null && (data = eVar.getData()) != null) {
                    i2 = data.size();
                }
                if (i < i2) {
                    e eVar2 = shortTvPlayListFragment.mSubjectAdapter;
                    if (eVar2 != null) {
                        eVar2.n(i, subject);
                    }
                } else {
                    e eVar3 = shortTvPlayListFragment.mSubjectAdapter;
                    if (eVar3 != null) {
                        eVar3.p(subject);
                    }
                }
            }
        }
        return Unit.a;
    }

    private final a E0() {
        a aVar = new a(new ArrayList(), this.mExposureHelper);
        aVar.h0().z(true);
        aVar.h0().y(true);
        aVar.h0().D(new f() { // from class: uq.t
            public final void a() {
                ShortTvPlayListFragment.F0(ShortTvPlayListFragment.this);
            }
        });
        aVar.w1(new r6.d() { // from class: uq.u
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ShortTvPlayListFragment.H0(ShortTvPlayListFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mCastAdapter = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(final ShortTvPlayListFragment shortTvPlayListFragment) {
        RecyclerView recyclerView;
        if (l.a.e()) {
            shortTvPlayListFragment.loadMore();
            return;
        }
        jr.b.a.d(R.string.short_tv_no_network);
        b0 b0Var = (b0) shortTvPlayListFragment.getMViewBinding();
        if (b0Var == null || (recyclerView = b0Var.e) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: uq.n
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvPlayListFragment.G0(ShortTvPlayListFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(ShortTvPlayListFragment shortTvPlayListFragment) {
        t6.f h0;
        a aVar = shortTvPlayListFragment.mCastAdapter;
        if (aVar == null || (h0 = aVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(ShortTvPlayListFragment shortTvPlayListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof Staff) {
            Staff staff = (Staff) item;
            Navigator.x(TheRouter.c("/movie/staff").K("id", staff.getStaffId()).J("staff", (Serializable) item), shortTvPlayListFragment.requireContext(), (mf.c) null, 2, (Object) null);
            shortTvPlayListFragment.B0().c("playlist", staff.getStaffId(), staff.getOps(), Integer.valueOf(i), shortTvPlayListFragment.mCategory, shortTvPlayListFragment.mRecType, shortTvPlayListFragment.mLabel);
        }
    }

    private final e I0() {
        e eVar = new e(new ArrayList(), this.mExposureHelper);
        eVar.h0().z(true);
        eVar.h0().y(true);
        eVar.h0().D(new f() { // from class: uq.w
            public final void a() {
                ShortTvPlayListFragment.J0(ShortTvPlayListFragment.this);
            }
        });
        eVar.w1(new r6.d() { // from class: uq.x
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ShortTvPlayListFragment.L0(ShortTvPlayListFragment.this, baseQuickAdapter, view, i);
            }
        });
        eVar.l(new int[]{R.id.ll_download});
        eVar.s1(new r6.b() { // from class: uq.m
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ShortTvPlayListFragment.M0(ShortTvPlayListFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mSubjectAdapter = eVar;
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(final ShortTvPlayListFragment shortTvPlayListFragment) {
        RecyclerView recyclerView;
        if (l.a.e()) {
            shortTvPlayListFragment.loadMore();
            return;
        }
        jr.b.a.d(R.string.short_tv_no_network);
        b0 b0Var = (b0) shortTvPlayListFragment.getMViewBinding();
        if (b0Var == null || (recyclerView = b0Var.e) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: uq.o
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvPlayListFragment.K0(ShortTvPlayListFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(ShortTvPlayListFragment shortTvPlayListFragment) {
        t6.f h0;
        e eVar = shortTvPlayListFragment.mSubjectAdapter;
        if (eVar == null || (h0 = eVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(ShortTvPlayListFragment shortTvPlayListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            xq.b.c(subject);
            xq.d B0 = shortTvPlayListFragment.B0();
            String subjectId = subject.getSubjectId();
            String ops = subject.getOps();
            Integer valueOf = Integer.valueOf(i);
            Boolean hasResource = subject.getHasResource();
            B0.e("playlist", subjectId, ops, valueOf, hasResource != null ? hasResource.booleanValue() : false, shortTvPlayListFragment.mCategory, shortTvPlayListFragment.mRecType, shortTvPlayListFragment.mLabel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(ShortTvPlayListFragment shortTvPlayListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (hr.d.a.a(view.getId(), 2000L)) {
            return;
        }
        Object item = baseQuickAdapter.getItem(i);
        Subject subject = item instanceof Subject ? (Subject) item : null;
        if (view.getId() == R.id.ll_download) {
            shortTvPlayListFragment.A0(subject, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(ShortTvPlayListFragment shortTvPlayListFragment, View view) {
        FragmentActivity activity = shortTvPlayListFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(ShortTvPlayListFragment shortTvPlayListFragment, b0 b0Var, AppBarLayout appBarLayout, int i) {
        if (shortTvPlayListFragment.getContext() == null) {
            return;
        }
        if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            b0Var.f.setBackgroundColor(androidx.core.content.b.getColor(shortTvPlayListFragment.requireContext(), R.color.short_tv_bg));
            b0Var.c.setImageTintList(ColorStateList.valueOf(androidx.core.content.b.getColor(shortTvPlayListFragment.requireContext(), R.color.short_tv_white)));
            AppCompatTextView appCompatTextView = b0Var.g;
            Intrinsics.g(appCompatTextView, "tvTitle");
            cr.b.e(appCompatTextView);
            AppCompatTextView appCompatTextView2 = b0Var.h;
            Intrinsics.g(appCompatTextView2, "tvTitleExpand");
            cr.b.b(appCompatTextView2);
            shortTvPlayListFragment.z0(true);
            return;
        }
        b0Var.f.setBackgroundColor(androidx.core.content.b.getColor(shortTvPlayListFragment.requireContext(), R.color.short_tv_transparent));
        b0Var.c.setImageTintList(ColorStateList.valueOf(androidx.core.content.b.getColor(shortTvPlayListFragment.requireContext(), R.color.short_tv_white)));
        AppCompatTextView appCompatTextView3 = b0Var.g;
        Intrinsics.g(appCompatTextView3, "tvTitle");
        cr.b.b(appCompatTextView3);
        AppCompatTextView appCompatTextView4 = b0Var.h;
        Intrinsics.g(appCompatTextView4, "tvTitleExpand");
        cr.b.e(appCompatTextView4);
        shortTvPlayListFragment.z0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(ShortTvPlayListFragment shortTvPlayListFragment, ShortTvPlayListResp shortTvPlayListResp) {
        List data;
        List data2;
        e eVar;
        t6.f h0;
        t6.f h02;
        e eVar2;
        t6.f h03;
        List data3;
        List data4;
        a aVar;
        t6.f h04;
        t6.f h05;
        a aVar2;
        t6.f h06;
        shortTvPlayListFragment.showContentView();
        shortTvPlayListFragment.U0(shortTvPlayListResp);
        if (shortTvPlayListFragment.Q0()) {
            a aVar3 = shortTvPlayListFragment.mCastAdapter;
            if (aVar3 != null && (h05 = aVar3.h0()) != null && h05.r() && (aVar2 = shortTvPlayListFragment.mCastAdapter) != null && (h06 = aVar2.h0()) != null) {
                h06.s();
            }
            if (shortTvPlayListResp != null) {
                List<Staff> staffs = shortTvPlayListResp.getStaffs();
                int size = staffs != null ? staffs.size() : 0;
                if (size < 4 && (aVar = shortTvPlayListFragment.mCastAdapter) != null && (h04 = aVar.h0()) != null) {
                    t6.f.u(h04, false, 1, (Object) null);
                }
                a aVar4 = shortTvPlayListFragment.mCastAdapter;
                if (aVar4 == null || (data4 = aVar4.getData()) == null || data4.size() != 0 || size != 0) {
                    shortTvPlayListFragment.V0(shortTvPlayListResp);
                } else {
                    PageStatusFragment.c0(shortTvPlayListFragment, false, 1, null);
                }
                qi.b logViewConfig = shortTvPlayListFragment.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.k(true);
                }
            } else {
                a aVar5 = shortTvPlayListFragment.mCastAdapter;
                if (aVar5 != null && (data3 = aVar5.getData()) != null && data3.size() == 0) {
                    PageStatusFragment.c0(shortTvPlayListFragment, false, 1, null);
                }
            }
        } else {
            e eVar3 = shortTvPlayListFragment.mSubjectAdapter;
            if (eVar3 != null && (h02 = eVar3.h0()) != null && h02.r() && (eVar2 = shortTvPlayListFragment.mSubjectAdapter) != null && (h03 = eVar2.h0()) != null) {
                h03.s();
            }
            if (shortTvPlayListResp != null) {
                List<Subject> subjects = shortTvPlayListResp.getSubjects();
                int size2 = subjects != null ? subjects.size() : 0;
                if (size2 < 4 && (eVar = shortTvPlayListFragment.mSubjectAdapter) != null && (h0 = eVar.h0()) != null) {
                    t6.f.u(h0, false, 1, (Object) null);
                }
                e eVar4 = shortTvPlayListFragment.mSubjectAdapter;
                if (eVar4 == null || (data2 = eVar4.getData()) == null || data2.size() != 0 || size2 != 0) {
                    shortTvPlayListFragment.V0(shortTvPlayListResp);
                } else {
                    PageStatusFragment.c0(shortTvPlayListFragment, false, 1, null);
                }
                qi.b logViewConfig2 = shortTvPlayListFragment.getLogViewConfig();
                if (logViewConfig2 != null) {
                    logViewConfig2.k(true);
                }
            } else {
                e eVar5 = shortTvPlayListFragment.mSubjectAdapter;
                if (eVar5 != null && (data = eVar5.getData()) != null && data.size() == 0) {
                    PageStatusFragment.c0(shortTvPlayListFragment, false, 1, null);
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Q0() {
        return Intrinsics.c(this.mCategory, ShortTvPlayListType.CAST.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xq.d R0() {
        return new xq.d();
    }

    private final void S0() {
        Function1 function1 = new Function1() { // from class: uq.q
            public final Object invoke(Object obj) {
                Unit T0;
                T0 = ShortTvPlayListFragment.T0(ShortTvPlayListFragment.this, (AddToDownloadEvent) obj);
                return T0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(ShortTvPlayListFragment shortTvPlayListFragment, AddToDownloadEvent addToDownloadEvent) {
        e eVar;
        List data;
        Intrinsics.h(addToDownloadEvent, "value");
        try {
            e eVar2 = shortTvPlayListFragment.mSubjectAdapter;
            int i = -1;
            if (eVar2 != null && (data = eVar2.getData()) != null) {
                Iterator it = data.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics.c(((Subject) it.next()).getSubjectId(), addToDownloadEvent.getSubjectId())) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (i >= 0 && (eVar = shortTvPlayListFragment.mSubjectAdapter) != null) {
                eVar.notifyItemChanged(i);
            }
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        return Unit.a;
    }

    private final void U0(ShortTvPlayListResp playListResp) {
        List<Subject> subjects;
        List<Staff> staffs;
        String ops = playListResp != null ? playListResp.getOps() : null;
        JSONObject jSONObject = (ops == null || ops.length() == 0) ? new JSONObject() : new JSONObject(ops);
        jSONObject.put("rec_type", this.mRecType);
        jSONObject.put("label", this.mLabel);
        String jSONObject2 = jSONObject.toString();
        if (playListResp != null && (staffs = playListResp.getStaffs()) != null) {
            for (Staff staff : staffs) {
                String ops2 = staff.getOps();
                if (ops2 == null || ops2.length() == 0) {
                    staff.setOps(jSONObject2);
                }
            }
        }
        if (playListResp == null || (subjects = playListResp.getSubjects()) == null) {
            return;
        }
        for (Subject subject : subjects) {
            String ops3 = subject.getOps();
            if (ops3 == null || ops3.length() == 0) {
                subject.setOps(jSONObject2);
            }
        }
    }

    private final void V0(ShortTvPlayListResp playListResp) {
        b0 b0Var;
        List data;
        String str;
        Cover cover;
        String thumbnail;
        Cover cover2;
        List data2;
        List data3;
        e eVar;
        List data4;
        String avatarUrl;
        List data5;
        com.transsion.shorttv._channel.ui.adapter.a aVar;
        if (getContext() == null || (b0Var = (b0) getMViewBinding()) == null) {
            return;
        }
        String title = playListResp.getTitle();
        if (title != null && title.length() > 0) {
            b0Var.g.setText(playListResp.getTitle());
            b0Var.h.setText(playListResp.getTitle());
        }
        boolean Q0 = Q0();
        Subject subject = null;
        r4 = null;
        Staff staff = null;
        subject = null;
        String str2 = BuildConfig.FLAVOR;
        if (Q0) {
            List<Staff> staffs = playListResp.getStaffs();
            if (staffs != null && (aVar = this.mCastAdapter) != null) {
                aVar.q(staffs);
            }
            com.transsion.shorttv._channel.ui.adapter.a aVar2 = this.mCastAdapter;
            if (aVar2 == null || (data4 = aVar2.getData()) == null || !(!data4.isEmpty())) {
                return;
            }
            com.transsion.shorttv._channel.ui.adapter.a aVar3 = this.mCastAdapter;
            if (aVar3 != null && (data5 = aVar3.getData()) != null) {
                staff = (Staff) data5.get(0);
            }
            f.a aVar4 = ni.f.a;
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            f.b m = aVar4.m(requireContext);
            if (staff != null && (avatarUrl = staff.getAvatarUrl()) != null) {
                str2 = avatarUrl;
            }
            f.b g = m.g(str2);
            AppCompatImageView appCompatImageView = b0Var.d;
            Intrinsics.g(appCompatImageView, "ivCover");
            g.d(appCompatImageView);
            return;
        }
        List<Subject> subjects = playListResp.getSubjects();
        if (subjects != null) {
            Boolean showRank = playListResp.getShowRank();
            e eVar2 = this.mSubjectAdapter;
            if (eVar2 != null && (data3 = eVar2.getData()) != null && data3.isEmpty() && showRank != null && (eVar = this.mSubjectAdapter) != null) {
                eVar.T1(showRank.booleanValue());
            }
            e eVar3 = this.mSubjectAdapter;
            if (eVar3 != null) {
                eVar3.q(subjects);
            }
        }
        e eVar4 = this.mSubjectAdapter;
        if (eVar4 == null || (data = eVar4.getData()) == null || !(!data.isEmpty())) {
            return;
        }
        e eVar5 = this.mSubjectAdapter;
        if (eVar5 != null && (data2 = eVar5.getData()) != null) {
            subject = (Subject) data2.get(0);
        }
        f.a aVar5 = ni.f.a;
        Context requireContext2 = requireContext();
        Intrinsics.g(requireContext2, "requireContext(...)");
        f.b m2 = aVar5.m(requireContext2);
        if (subject == null || (cover2 = subject.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b g2 = m2.g(str);
        if (subject != null && (cover = subject.getCover()) != null && (thumbnail = cover.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        f.b l = g2.l(str2);
        AppCompatImageView appCompatImageView2 = b0Var.d;
        Intrinsics.g(appCompatImageView2, "ivCover");
        l.d(appCompatImageView2);
    }

    private final void initAd() {
        Map a = com.transsion.ad.strategy.c.a.a(BuildConfig.FLAVOR);
        String str = this.mCategory;
        if (str != null) {
            a.put("category", str);
        }
        BiddingListManager biddingListManager = new BiddingListManager();
        b0 b0Var = (b0) getMViewBinding();
        biddingListManager.F(b0Var != null ? b0Var.e : null);
        biddingListManager.A(v.a(this));
        biddingListManager.G("PlayListScene");
        biddingListManager.B(a);
        biddingListManager.z(new Function2() { // from class: uq.v
            public final Object invoke(Object obj, Object obj2) {
                Unit D0;
                D0 = ShortTvPlayListFragment.D0(ShortTvPlayListFragment.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                return D0;
            }
        });
        this.v3ListManager = biddingListManager;
    }

    private final void loadData() {
        ShortTvPlayListViewModel shortTvPlayListViewModel = this.viewModel;
        if (shortTvPlayListViewModel == null) {
            Intrinsics.y("viewModel");
            shortTvPlayListViewModel = null;
        }
        ShortTvPlayListViewModel shortTvPlayListViewModel2 = shortTvPlayListViewModel;
        String str = this.mLabel;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        String str2 = this.mCategory;
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        String str3 = this.mRecType;
        if (str3 == null) {
            str3 = BuildConfig.FLAVOR;
        }
        String str4 = this.mTopIds;
        if (str4 == null) {
            str4 = BuildConfig.FLAVOR;
        }
        shortTvPlayListViewModel2.f(str, str2, str3, str4, this.mTabId);
    }

    private final void loadMore() {
        loadData();
    }

    private final void reload() {
        if (l.a.e()) {
            loadDefaultData();
        } else {
            showLoadingView();
            showNoNetworkViewDelayed();
        }
    }

    private final void z0(boolean isExpand) {
        if (isAdded()) {
            ShortTvPlayListActivity activity = getActivity();
            if (activity instanceof ShortTvPlayListActivity) {
                activity.W(isExpand);
            }
        }
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public b0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        b0 c2 = b0.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void initListener() {
        S0();
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void initViewData() {
        Toolbar toolbar;
        Toolbar toolbar2;
        b0 b0Var = (b0) getMViewBinding();
        if (b0Var != null && (toolbar2 = b0Var.f) != null) {
            xq.b.a(toolbar2);
        }
        pageStateFitStatusBar();
        initAd();
        if (((b0) getMViewBinding()) != null) {
            b0 b0Var2 = (b0) getMViewBinding();
            if (b0Var2 != null && (toolbar = b0Var2.f) != null) {
                xq.b.a(toolbar);
            }
            pageStateFitStatusBar();
            initAd();
            final b0 b0Var3 = (b0) getMViewBinding();
            if (b0Var3 != null) {
                b0Var3.c.setOnClickListener(new View.OnClickListener() { // from class: uq.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ShortTvPlayListFragment.N0(ShortTvPlayListFragment.this, view);
                    }
                });
                RecyclerView recyclerView = b0Var3.e;
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                br.b bVar = new br.b(0.6f, new b(), false, 4, null);
                bVar.l(2);
                recyclerView.addOnScrollListener(bVar);
                this.mExposureHelper = bVar;
                recyclerView.setAdapter(Q0() ? E0() : I0());
                b0Var3.b.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: uq.s
                    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                        ShortTvPlayListFragment.O0(ShortTvPlayListFragment.this, b0Var3, appBarLayout, i);
                    }
                });
            }
        }
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void initViewModel() {
        ShortTvPlayListViewModel shortTvPlayListViewModel = (ShortTvPlayListViewModel) new v0(this).a(ShortTvPlayListViewModel.class);
        this.viewModel = shortTvPlayListViewModel;
        ShortTvPlayListViewModel shortTvPlayListViewModel2 = null;
        if (shortTvPlayListViewModel == null) {
            Intrinsics.y("viewModel");
            shortTvPlayListViewModel = null;
        }
        shortTvPlayListViewModel.i(1);
        ShortTvPlayListViewModel shortTvPlayListViewModel3 = this.viewModel;
        if (shortTvPlayListViewModel3 == null) {
            Intrinsics.y("viewModel");
        } else {
            shortTvPlayListViewModel2 = shortTvPlayListViewModel3;
        }
        shortTvPlayListViewModel2.g().j(this, new c(new Function1() { // from class: uq.l
            public final Object invoke(Object obj) {
                Unit P0;
                P0 = ShortTvPlayListFragment.P0(ShortTvPlayListFragment.this, (ShortTvPlayListResp) obj);
                return P0;
            }
        }));
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return true;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public boolean isMonitorNetworkState() {
        return true;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void loadDefaultData() {
        if (l.a.e()) {
            showLoadingView();
            loadData();
        }
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public qi.b newLogViewConfig() {
        return new qi.b("playlist", false, 2, null);
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.v3ListManager;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void receiveArguments() {
        HashMap g;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mLabel = arguments.getString("label");
            this.mCategory = arguments.getString("category");
            this.mRecType = arguments.getString("recType");
            this.mTopIds = arguments.getString("topIds");
            this.mTabId = arguments.getInt("tab_id", 0);
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g = logViewConfig.g()) == null) {
            return;
        }
        g.put("label", this.mLabel);
        g.put("category", this.mCategory);
        g.put("rec_type", this.mRecType);
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void retryLoadData() {
        List data;
        List data2;
        if (Q0()) {
            com.transsion.shorttv._channel.ui.adapter.a aVar = this.mCastAdapter;
            if (aVar != null && (data2 = aVar.getData()) != null && data2.size() == 0) {
                reload();
                return;
            }
            com.transsion.shorttv._channel.ui.adapter.a aVar2 = this.mCastAdapter;
            if (aVar2 == null || aVar2.h0().i() != LoadMoreStatus.Fail) {
                return;
            }
            aVar2.h0().w();
            return;
        }
        e eVar = this.mSubjectAdapter;
        if (eVar != null && (data = eVar.getData()) != null && data.size() == 0) {
            reload();
            return;
        }
        e eVar2 = this.mSubjectAdapter;
        if (eVar2 == null || eVar2.h0().i() != LoadMoreStatus.Fail) {
            return;
        }
        eVar2.h0().w();
    }
}
