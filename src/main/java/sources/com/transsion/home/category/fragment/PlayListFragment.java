package com.transsion.home.category.fragment;

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
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.google.android.material.appbar.AppBarLayout;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.flow.bean.LayoutStyle;
import com.transsion.flow.bean.PlayListType;
import com.transsion.flow.bean.PlayUrl;
import com.transsion.flow.bean.SubjectGameInfo;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.PlayListResp;
import com.transsion.home.category.PlayListActivity;
import com.transsion.home.category.adapter.j;
import com.transsion.home.category.fragment.PlayListFragment;
import com.transsion.home.viewmodel.PlayListViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectDl;
import com.transsion.moviedetailapi.bean.Trailer;
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
import qk.r;
import r6.f;
import wf.a;
import yg.l;
import zk.h;
import zk.i;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 X2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001f\u0010\u0018J\u000f\u0010 \u001a\u00020\u0012H\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0012H\u0002¢\u0006\u0004\b!\u0010\u0004J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0012H\u0016¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010*\u001a\u00020\u0012H\u0016¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010+\u001a\u00020\u0012H\u0016¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0012H\u0016¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010-\u001a\u00020\u0005H\u0016¢\u0006\u0004\b-\u0010\u0007J\u000f\u0010.\u001a\u00020\u0012H\u0016¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0012H\u0016¢\u0006\u0004\b/\u0010\u0004J\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0012H\u0016¢\u0006\u0004\b3\u0010\u0004R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00109R\u0018\u0010@\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010C\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u001b\u0010S\u001a\u00020N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006Y"}, d2 = {"Lcom/transsion/home/category/fragment/PlayListFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lqk/r;", "<init>", "()V", BuildConfig.FLAVOR, "U0", "()Z", "Lcom/transsion/home/category/adapter/b;", "I0", "()Lcom/transsion/home/category/adapter/b;", "Lcom/transsion/home/category/adapter/j;", "M0", "()Lcom/transsion/home/category/adapter/j;", "Lcom/transsion/moviedetailapi/bean/Subject;", "subjectItem", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "E0", "(Lcom/transsion/moviedetailapi/bean/Subject;I)V", "Lcom/transsion/home/bean/PlayListResp;", "playListResp", "Y0", "(Lcom/transsion/home/bean/PlayListResp;)V", "reload", "loadData", "loadMore", "isExpand", "D0", "(Z)V", "Z0", "W0", "initAd", "Landroid/view/LayoutInflater;", "inflater", "G0", "(Landroid/view/LayoutInflater;)Lqk/r;", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "receiveArguments", "initViewData", "initViewModel", "initListener", "isMonitorNetworkState", "retryLoadData", "loadDefaultData", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "onDestroy", "Lcom/transsion/home/viewmodel/PlayListViewModel;", "a", "Lcom/transsion/home/viewmodel/PlayListViewModel;", "viewModel", "b", "Ljava/lang/String;", "mLabel", "c", "mCategory", "d", "mRecType", "e", "mTopIds", "f", "I", "mTabId", "Lrk/b;", "g", "Lrk/b;", "mExposureHelper", "h", "Lcom/transsion/home/category/adapter/j;", "mSubjectAdapter", "i", "Lcom/transsion/home/category/adapter/b;", "mCastAdapter", "Lzk/i;", "j", "Lkotlin/Lazy;", "F0", "()Lzk/i;", "mPlayListDotHelper", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "k", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "v3ListManager", "l", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PlayListFragment extends PageStatusFragment<r> {

    /* renamed from: l, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int m = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private PlayListViewModel viewModel;

    /* renamed from: b, reason: from kotlin metadata */
    private String mLabel;

    /* renamed from: c, reason: from kotlin metadata */
    private String mCategory;

    /* renamed from: d, reason: from kotlin metadata */
    private String mRecType;

    /* renamed from: e, reason: from kotlin metadata */
    private String mTopIds;

    /* renamed from: f, reason: from kotlin metadata */
    private int mTabId;

    /* renamed from: g, reason: from kotlin metadata */
    private rk.b mExposureHelper;

    /* renamed from: h, reason: from kotlin metadata */
    private j mSubjectAdapter;

    /* renamed from: i, reason: from kotlin metadata */
    private com.transsion.home.category.adapter.b mCastAdapter;

    /* renamed from: j, reason: from kotlin metadata */
    private final Lazy mPlayListDotHelper = LazyKt.b(new Function0() { // from class: pk.r
        public final Object invoke() {
            zk.i V0;
            V0 = PlayListFragment.V0();
            return V0;
        }
    });

    /* renamed from: k, reason: from kotlin metadata */
    private BiddingListManager v3ListManager;

    /* renamed from: com.transsion.home.category.fragment.PlayListFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayListFragment a(String str, String str2, String str3, String str4, int i) {
            PlayListFragment playListFragment = new PlayListFragment();
            playListFragment.setArguments(d.b(new Pair[]{TuplesKt.a("label", str), TuplesKt.a("category", str2), TuplesKt.a("recType", str3), TuplesKt.a("topIds", str4), TuplesKt.a("tabId", Integer.valueOf(i))}));
            return playListFragment;
        }
    }

    public static final class b implements rk.a {
        b() {
        }

        @Override // rk.a
        public void a(int i, long j, View view) {
            Boolean hasResource;
            List data;
            List data2;
            boolean z = false;
            r13 = 0;
            int i2 = 0;
            z = false;
            if (PlayListFragment.this.U0()) {
                com.transsion.home.category.adapter.b bVar = PlayListFragment.this.mCastAdapter;
                if (bVar != null && (data2 = bVar.getData()) != null) {
                    i2 = data2.size();
                }
                if (i >= i2) {
                    return;
                }
                com.transsion.home.category.adapter.b bVar2 = PlayListFragment.this.mCastAdapter;
                Staff staff = bVar2 != null ? (Staff) bVar2.getItem(i) : null;
                PlayListFragment.this.F0().b("playlist", staff != null ? staff.getStaffId() : null, staff != null ? staff.getOps() : null, Integer.valueOf(i), PlayListFragment.this.mCategory, PlayListFragment.this.mRecType, PlayListFragment.this.mLabel);
                return;
            }
            j jVar = PlayListFragment.this.mSubjectAdapter;
            if (i >= ((jVar == null || (data = jVar.getData()) == null) ? 0 : data.size())) {
                return;
            }
            j jVar2 = PlayListFragment.this.mSubjectAdapter;
            Subject subject = jVar2 != null ? (Subject) jVar2.getItem(i) : null;
            i F0 = PlayListFragment.this.F0();
            String subjectId = subject != null ? subject.getSubjectId() : null;
            String ops = subject != null ? subject.getOps() : null;
            Integer valueOf = Integer.valueOf(i);
            if (subject != null && (hasResource = subject.getHasResource()) != null) {
                z = hasResource.booleanValue();
            }
            F0.d("playlist", subjectId, ops, valueOf, z, PlayListFragment.this.mCategory, PlayListFragment.this.mRecType, PlayListFragment.this.mLabel);
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

    private final void D0(boolean isExpand) {
        if (isAdded()) {
            PlayListActivity activity = getActivity();
            if (activity instanceof PlayListActivity) {
                activity.b0(isExpand);
            }
        }
    }

    private final void E0(Subject subjectItem, int position) {
        Boolean hasResource;
        if (getContext() != null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            F0().a("playlist", h.g(subjectItem, "playlist", requireContext, "play_list_page"), subjectItem != null ? subjectItem.getSubjectId() : null, subjectItem != null ? subjectItem.getOps() : null, Integer.valueOf(position), (subjectItem == null || (hasResource = subjectItem.getHasResource()) == null) ? false : hasResource.booleanValue(), this.mCategory, this.mRecType, this.mLabel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i F0() {
        return (i) this.mPlayListDotHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(PlayListFragment playListFragment, int i, BiddingNativeManager biddingNativeManager) {
        List data;
        List data2;
        Intrinsics.h(biddingNativeManager, "current");
        if (biddingNativeManager != null) {
            int i2 = 0;
            if (playListFragment.U0()) {
                Staff staff = new Staff();
                staff.setNonAdDelegate(biddingNativeManager);
                com.transsion.home.category.adapter.b bVar = playListFragment.mCastAdapter;
                if (bVar != null && (data2 = bVar.getData()) != null) {
                    i2 = data2.size();
                }
                if (i < i2) {
                    com.transsion.home.category.adapter.b bVar2 = playListFragment.mCastAdapter;
                    if (bVar2 != null) {
                        bVar2.n(i, staff);
                    }
                } else {
                    com.transsion.home.category.adapter.b bVar3 = playListFragment.mCastAdapter;
                    if (bVar3 != null) {
                        bVar3.p(staff);
                    }
                }
            } else {
                Subject subject = new Subject((String) null, (Integer) null, (String) null, (String) null, (Cover) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -1, 67108863, (DefaultConstructorMarker) null);
                subject.setNonAdDelegate(biddingNativeManager);
                j jVar = playListFragment.mSubjectAdapter;
                if (jVar != null && (data = jVar.getData()) != null) {
                    i2 = data.size();
                }
                if (i < i2) {
                    j jVar2 = playListFragment.mSubjectAdapter;
                    if (jVar2 != null) {
                        jVar2.n(i, subject);
                    }
                } else {
                    j jVar3 = playListFragment.mSubjectAdapter;
                    if (jVar3 != null) {
                        jVar3.p(subject);
                    }
                }
            }
        }
        return Unit.a;
    }

    private final com.transsion.home.category.adapter.b I0() {
        final com.transsion.home.category.adapter.b bVar = new com.transsion.home.category.adapter.b(new ArrayList(), this.mExposureHelper);
        bVar.h0().z(true);
        bVar.h0().y(true);
        bVar.h0().D(new f() { // from class: pk.w
            public final void a() {
                PlayListFragment.J0(PlayListFragment.this);
            }
        });
        bVar.w1(new r6.d() { // from class: pk.l
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PlayListFragment.L0(com.transsion.home.category.adapter.b.this, this, baseQuickAdapter, view, i);
            }
        });
        this.mCastAdapter = bVar;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(final PlayListFragment playListFragment) {
        RecyclerView recyclerView;
        if (l.a.e()) {
            playListFragment.loadMore();
            return;
        }
        fh.b.a.d(R.string.no_network);
        r rVar = (r) playListFragment.getMViewBinding();
        if (rVar == null || (recyclerView = rVar.e) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: pk.m
            @Override // java.lang.Runnable
            public final void run() {
                PlayListFragment.K0(PlayListFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(PlayListFragment playListFragment) {
        t6.f h0;
        com.transsion.home.category.adapter.b bVar = playListFragment.mCastAdapter;
        if (bVar == null || (h0 = bVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(com.transsion.home.category.adapter.b bVar, PlayListFragment playListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof Staff) {
            Staff staff = (Staff) item;
            Navigator.x(TheRouter.c("/movie/staff").K("id", staff.getStaffId()).J("staff", (Serializable) item), bVar.getContext(), (mf.c) null, 2, (Object) null);
            playListFragment.F0().c("playlist", staff.getStaffId(), staff.getOps(), Integer.valueOf(i), playListFragment.mCategory, playListFragment.mRecType, playListFragment.mLabel);
        }
    }

    private final j M0() {
        j jVar = new j(new ArrayList(), this.mExposureHelper);
        jVar.h0().z(true);
        jVar.h0().y(true);
        jVar.h0().D(new f() { // from class: pk.t
            public final void a() {
                PlayListFragment.N0(PlayListFragment.this);
            }
        });
        jVar.w1(new r6.d() { // from class: pk.u
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PlayListFragment.P0(PlayListFragment.this, baseQuickAdapter, view, i);
            }
        });
        jVar.l(new int[]{com.transsion.home.R.id.ll_download});
        jVar.s1(new r6.b() { // from class: pk.v
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PlayListFragment.Q0(PlayListFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mSubjectAdapter = jVar;
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(final PlayListFragment playListFragment) {
        RecyclerView recyclerView;
        if (l.a.e()) {
            playListFragment.loadMore();
            return;
        }
        fh.b.a.d(R.string.no_network);
        r rVar = (r) playListFragment.getMViewBinding();
        if (rVar == null || (recyclerView = rVar.e) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: pk.n
            @Override // java.lang.Runnable
            public final void run() {
                PlayListFragment.O0(PlayListFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(PlayListFragment playListFragment) {
        t6.f h0;
        j jVar = playListFragment.mSubjectAdapter;
        if (jVar == null || (h0 = jVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(PlayListFragment playListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            h.f(subject, "play_list_page");
            i F0 = playListFragment.F0();
            String subjectId = subject.getSubjectId();
            String ops = subject.getOps();
            Integer valueOf = Integer.valueOf(i);
            Boolean hasResource = subject.getHasResource();
            F0.e("playlist", subjectId, ops, valueOf, hasResource != null ? hasResource.booleanValue() : false, playListFragment.mCategory, playListFragment.mRecType, playListFragment.mLabel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(PlayListFragment playListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L)) {
            return;
        }
        Object item = baseQuickAdapter.getItem(i);
        Subject subject = item instanceof Subject ? (Subject) item : null;
        if (view.getId() == com.transsion.home.R.id.ll_download) {
            playListFragment.E0(subject, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(PlayListFragment playListFragment, View view) {
        FragmentActivity activity = playListFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(PlayListFragment playListFragment, r rVar, AppBarLayout appBarLayout, int i) {
        if (playListFragment.getContext() == null) {
            return;
        }
        if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            rVar.f.setBackgroundColor(androidx.core.content.b.getColor(playListFragment.requireContext(), R.color.bg_01));
            rVar.c.setImageTintList(ColorStateList.valueOf(androidx.core.content.b.getColor(playListFragment.requireContext(), R.color.btn_back)));
            AppCompatTextView appCompatTextView = rVar.g;
            Intrinsics.g(appCompatTextView, "tvTitle");
            uf.c.k(appCompatTextView);
            AppCompatTextView appCompatTextView2 = rVar.h;
            Intrinsics.g(appCompatTextView2, "tvTitleExpand");
            uf.c.g(appCompatTextView2);
            playListFragment.D0(true);
            return;
        }
        rVar.f.setBackgroundColor(androidx.core.content.b.getColor(playListFragment.requireContext(), R.color.transparent));
        rVar.c.setImageTintList(ColorStateList.valueOf(androidx.core.content.b.getColor(playListFragment.requireContext(), R.color.common_white)));
        AppCompatTextView appCompatTextView3 = rVar.g;
        Intrinsics.g(appCompatTextView3, "tvTitle");
        uf.c.g(appCompatTextView3);
        AppCompatTextView appCompatTextView4 = rVar.h;
        Intrinsics.g(appCompatTextView4, "tvTitleExpand");
        uf.c.k(appCompatTextView4);
        playListFragment.D0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(PlayListFragment playListFragment, PlayListResp playListResp) {
        List data;
        List data2;
        j jVar;
        t6.f h0;
        t6.f h02;
        j jVar2;
        t6.f h03;
        List data3;
        List data4;
        com.transsion.home.category.adapter.b bVar;
        t6.f h04;
        t6.f h05;
        com.transsion.home.category.adapter.b bVar2;
        t6.f h06;
        playListFragment.showContentView();
        playListFragment.Y0(playListResp);
        if (playListFragment.U0()) {
            com.transsion.home.category.adapter.b bVar3 = playListFragment.mCastAdapter;
            if (bVar3 != null && (h05 = bVar3.h0()) != null && h05.r() && (bVar2 = playListFragment.mCastAdapter) != null && (h06 = bVar2.h0()) != null) {
                h06.s();
            }
            if (playListResp != null) {
                List<Staff> staffs = playListResp.getStaffs();
                int size = staffs != null ? staffs.size() : 0;
                if (size < 4 && (bVar = playListFragment.mCastAdapter) != null && (h04 = bVar.h0()) != null) {
                    t6.f.u(h04, false, 1, (Object) null);
                }
                com.transsion.home.category.adapter.b bVar4 = playListFragment.mCastAdapter;
                if (bVar4 == null || (data4 = bVar4.getData()) == null || data4.size() != 0 || size != 0) {
                    playListFragment.Z0(playListResp);
                } else {
                    PageStatusFragment.showEmptyView$default(playListFragment, false, 1, (Object) null);
                }
                qi.b logViewConfig = playListFragment.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.k(true);
                }
            } else {
                com.transsion.home.category.adapter.b bVar5 = playListFragment.mCastAdapter;
                if (bVar5 != null && (data3 = bVar5.getData()) != null && data3.size() == 0) {
                    PageStatusFragment.showEmptyView$default(playListFragment, false, 1, (Object) null);
                }
            }
        } else {
            j jVar3 = playListFragment.mSubjectAdapter;
            if (jVar3 != null && (h02 = jVar3.h0()) != null && h02.r() && (jVar2 = playListFragment.mSubjectAdapter) != null && (h03 = jVar2.h0()) != null) {
                h03.s();
            }
            if (playListResp != null) {
                List<Subject> subjects = playListResp.getSubjects();
                int size2 = subjects != null ? subjects.size() : 0;
                if (size2 < 4 && (jVar = playListFragment.mSubjectAdapter) != null && (h0 = jVar.h0()) != null) {
                    t6.f.u(h0, false, 1, (Object) null);
                }
                j jVar4 = playListFragment.mSubjectAdapter;
                if (jVar4 == null || (data2 = jVar4.getData()) == null || data2.size() != 0 || size2 != 0) {
                    playListFragment.Z0(playListResp);
                } else {
                    PageStatusFragment.showEmptyView$default(playListFragment, false, 1, (Object) null);
                }
                qi.b logViewConfig2 = playListFragment.getLogViewConfig();
                if (logViewConfig2 != null) {
                    logViewConfig2.k(true);
                }
            } else {
                j jVar5 = playListFragment.mSubjectAdapter;
                if (jVar5 != null && (data = jVar5.getData()) != null && data.size() == 0) {
                    PageStatusFragment.showEmptyView$default(playListFragment, false, 1, (Object) null);
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U0() {
        return Intrinsics.c(this.mCategory, PlayListType.CAST.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i V0() {
        return new i();
    }

    private final void W0() {
        Function1 function1 = new Function1() { // from class: pk.q
            public final Object invoke(Object obj) {
                Unit X0;
                X0 = PlayListFragment.X0(PlayListFragment.this, (AddToDownloadEvent) obj);
                return X0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(PlayListFragment playListFragment, AddToDownloadEvent addToDownloadEvent) {
        j jVar;
        List data;
        Intrinsics.h(addToDownloadEvent, "value");
        try {
            j jVar2 = playListFragment.mSubjectAdapter;
            int i = -1;
            if (jVar2 != null && (data = jVar2.getData()) != null) {
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
            if (i >= 0 && (jVar = playListFragment.mSubjectAdapter) != null) {
                jVar.notifyItemChanged(i);
            }
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        return Unit.a;
    }

    private final void Y0(PlayListResp playListResp) {
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

    private final void Z0(PlayListResp playListResp) {
        r rVar;
        List data;
        String str;
        Cover cover;
        String thumbnail;
        Cover cover2;
        List data2;
        List data3;
        j jVar;
        List data4;
        String avatarUrl;
        List data5;
        com.transsion.home.category.adapter.b bVar;
        if (getContext() == null || (rVar = (r) getMViewBinding()) == null) {
            return;
        }
        String title = playListResp.getTitle();
        if (title != null && title.length() > 0) {
            rVar.g.setText(playListResp.getTitle());
            rVar.h.setText(playListResp.getTitle());
        }
        boolean U0 = U0();
        Staff staff = null;
        String str2 = BuildConfig.FLAVOR;
        if (U0) {
            List<Staff> staffs = playListResp.getStaffs();
            if (staffs != null && (bVar = this.mCastAdapter) != null) {
                bVar.q(staffs);
            }
            com.transsion.home.category.adapter.b bVar2 = this.mCastAdapter;
            if (bVar2 == null || (data4 = bVar2.getData()) == null || !(!data4.isEmpty())) {
                return;
            }
            com.transsion.home.category.adapter.b bVar3 = this.mCastAdapter;
            if (bVar3 != null && (data5 = bVar3.getData()) != null) {
                staff = (Staff) data5.get(0);
            }
            f.a aVar = ni.f.a;
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            f.b m2 = aVar.m(requireContext);
            if (staff != null && (avatarUrl = staff.getAvatarUrl()) != null) {
                str2 = avatarUrl;
            }
            f.b g = m2.g(str2);
            AppCompatImageView appCompatImageView = rVar.d;
            Intrinsics.g(appCompatImageView, "ivCover");
            g.d(appCompatImageView);
            return;
        }
        List<Subject> subjects = playListResp.getSubjects();
        if (subjects != null) {
            Boolean showRank = playListResp.getShowRank();
            j jVar2 = this.mSubjectAdapter;
            if (jVar2 != null && (data3 = jVar2.getData()) != null && data3.isEmpty() && showRank != null && (jVar = this.mSubjectAdapter) != null) {
                jVar.T1(showRank.booleanValue());
            }
            j jVar3 = this.mSubjectAdapter;
            if (jVar3 != null) {
                jVar3.q(subjects);
            }
        }
        j jVar4 = this.mSubjectAdapter;
        if (jVar4 == null || (data = jVar4.getData()) == null || !(!data.isEmpty())) {
            return;
        }
        j jVar5 = this.mSubjectAdapter;
        if (jVar5 != null && (data2 = jVar5.getData()) != null) {
            staff = (Subject) data2.get(0);
        }
        f.a aVar2 = ni.f.a;
        Context requireContext2 = requireContext();
        Intrinsics.g(requireContext2, "requireContext(...)");
        f.b m3 = aVar2.m(requireContext2);
        if (staff == null || (cover2 = staff.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b g2 = m3.g(str);
        if (staff != null && (cover = staff.getCover()) != null && (thumbnail = cover.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        f.b l = g2.l(str2);
        AppCompatImageView appCompatImageView2 = rVar.d;
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
        r rVar = (r) getMViewBinding();
        biddingListManager.F(rVar != null ? rVar.e : null);
        biddingListManager.A(v.a(this));
        biddingListManager.G("PlayListScene");
        biddingListManager.B(a);
        biddingListManager.z(new Function2() { // from class: pk.s
            public final Object invoke(Object obj, Object obj2) {
                Unit H0;
                H0 = PlayListFragment.H0(PlayListFragment.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                return H0;
            }
        });
        this.v3ListManager = biddingListManager;
    }

    private final void loadData() {
        PlayListViewModel playListViewModel = this.viewModel;
        if (playListViewModel == null) {
            Intrinsics.y("viewModel");
            playListViewModel = null;
        }
        PlayListViewModel playListViewModel2 = playListViewModel;
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
        playListViewModel2.f(str, str2, str3, str4, this.mTabId);
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

    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public r getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        r c2 = r.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
        W0();
    }

    public void initViewData() {
        Toolbar toolbar;
        r rVar = (r) getMViewBinding();
        if (rVar != null && (toolbar = rVar.f) != null) {
            uf.c.e(toolbar);
        }
        pageStateFitStatusBar();
        initAd();
        final r rVar2 = (r) getMViewBinding();
        if (rVar2 != null) {
            rVar2.c.setOnClickListener(new View.OnClickListener() { // from class: pk.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayListFragment.R0(PlayListFragment.this, view);
                }
            });
            RecyclerView recyclerView = rVar2.e;
            recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
            rk.b bVar = new rk.b(0.6f, new b(), false, 4, null);
            bVar.l(2);
            recyclerView.addOnScrollListener(bVar);
            this.mExposureHelper = bVar;
            recyclerView.setAdapter(U0() ? I0() : M0());
            rVar2.b.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: pk.p
                public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                    PlayListFragment.S0(PlayListFragment.this, rVar2, appBarLayout, i);
                }
            });
        }
    }

    public void initViewModel() {
        PlayListViewModel playListViewModel = (PlayListViewModel) new v0(this).a(PlayListViewModel.class);
        this.viewModel = playListViewModel;
        PlayListViewModel playListViewModel2 = null;
        if (playListViewModel == null) {
            Intrinsics.y("viewModel");
            playListViewModel = null;
        }
        playListViewModel.i(1);
        PlayListViewModel playListViewModel3 = this.viewModel;
        if (playListViewModel3 == null) {
            Intrinsics.y("viewModel");
        } else {
            playListViewModel2 = playListViewModel3;
        }
        playListViewModel2.g().j(this, new c(new Function1() { // from class: pk.k
            public final Object invoke(Object obj) {
                Unit T0;
                T0 = PlayListFragment.T0(PlayListFragment.this, (PlayListResp) obj);
                return T0;
            }
        }));
    }

    public boolean isMonitorNetworkState() {
        return true;
    }

    public void loadDefaultData() {
        if (l.a.e()) {
            showLoadingView();
            loadData();
        }
    }

    public qi.b newLogViewConfig() {
        return new qi.b("playlist", false, 2, null);
    }

    public void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.v3ListManager;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
    }

    public void receiveArguments() {
        HashMap g;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mLabel = arguments.getString("label");
            this.mCategory = arguments.getString("category");
            this.mRecType = arguments.getString("recType");
            this.mTopIds = arguments.getString("topIds");
            this.mTabId = arguments.getInt("tabId", 0);
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g = logViewConfig.g()) == null) {
            return;
        }
        g.put("label", this.mLabel);
        g.put("category", this.mCategory);
        g.put("rec_type", this.mRecType);
    }

    public void retryLoadData() {
        List data;
        List data2;
        if (U0()) {
            com.transsion.home.category.adapter.b bVar = this.mCastAdapter;
            if (bVar != null && (data2 = bVar.getData()) != null && data2.size() == 0) {
                reload();
                return;
            }
            com.transsion.home.category.adapter.b bVar2 = this.mCastAdapter;
            if (bVar2 == null || bVar2.h0().i() != LoadMoreStatus.Fail) {
                return;
            }
            bVar2.h0().w();
            return;
        }
        j jVar = this.mSubjectAdapter;
        if (jVar != null && (data = jVar.getData()) != null && data.size() == 0) {
            reload();
            return;
        }
        j jVar2 = this.mSubjectAdapter;
        if (jVar2 == null || jVar2.h0().i() != LoadMoreStatus.Fail) {
            return;
        }
        jVar2.h0().w();
    }
}
