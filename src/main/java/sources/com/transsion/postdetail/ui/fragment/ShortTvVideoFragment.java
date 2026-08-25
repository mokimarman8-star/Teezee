package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.therouter.TheRouter;
import com.tn.lib.view.DefaultView;
import com.tn.lib.widget.TnTextView;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.flow.bean.LayoutStyle;
import com.transsion.flow.bean.PlayUrl;
import com.transsion.flow.bean.ShortTVRespData;
import com.transsion.flow.bean.SubjectGameInfo;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectDl;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.config.RenderType;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R;
import com.transsion.postdetail.control.SubjectVideoPagerChangeControl;
import com.transsion.postdetail.helper.ShortTvImmVideoHelper;
import com.transsion.postdetail.ui.fragment.preload.VideoImmersiveDataLoader;
import com.transsion.postdetail.ui.view.ImmVideoLoadMoreView;
import com.transsion.postdetail.ui.view.ImmVideoNoNetworkView;
import com.transsion.postdetail.viewmodel.ImmVideoRequestEntity;
import com.transsion.push.bean.MsgStyle;
import com.transsion.shorttv.base.pager.PagerLayoutManager;
import fh.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import wf.a;
import yg.m;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0087\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001BB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0005J\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0005J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0005J\u0017\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J!\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b1\u00102J!\u00103\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b3\u00102J\u000f\u00104\u001a\u00020\u0006H\u0016¢\u0006\u0004\b4\u0010\u0005J\u000f\u00105\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010\u0005J\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\u0005J\u0017\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0006H\u0016¢\u0006\u0004\b;\u0010\u0005J\u000f\u0010<\u001a\u00020\u0006H\u0016¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010=\u001a\u00020\u0006H\u0016¢\u0006\u0004\b=\u0010\u0005J\u0017\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020)H\u0016¢\u0006\u0004\b?\u0010,J\u000f\u0010@\u001a\u00020\u0006H\u0016¢\u0006\u0004\b@\u0010\u0005R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010I\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010R\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010C\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010CR\u0016\u0010V\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010HR\u0016\u0010X\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010KR\u001b\u0010^\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010t\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010KR\u0016\u0010v\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010KR\u0016\u0010x\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010KR\u0016\u0010z\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010HR%\u0010\u0082\u0001\u001a\u00020{8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001¨\u0006\u0088\u0001"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/ShortTvVideoFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lwn/r;", "Lim/f;", "<init>", "()V", BuildConfig.FLAVOR, "initPlayer", "initAdapter", "initViewModel", "initBack", "observeRemoveVideo", "Lcom/transsion/moviedetailapi/bean/ShortTVRespData;", "subjectBean", "L0", "(Lcom/transsion/moviedetailapi/bean/ShortTVRespData;)V", "showNotNetError", "showEmpty", "Landroid/content/Context;", "context", "Landroid/view/View;", "getEmptyView", "(Landroid/content/Context;)Landroid/view/View;", "getNotNetErrorView", "hideProgress", "showProgress", "loadMore", "loadData", "doLoadData", BuildConfig.FLAVOR, "it", "scrollToPosition", "(I)V", "initAd", "J0", "(Landroid/content/Context;)V", "initNonAd", "Landroid/view/LayoutInflater;", "inflater", "y0", "(Landroid/view/LayoutInflater;)Lwn/r;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "lazyLoadData", "onResume", "onPause", BuildConfig.FLAVOR, "hidden", "onHiddenChanged", "(Z)V", "logPause", "logResume", "onDestroy", "outState", "onSaveInstanceState", "onMemberStateChange", BuildConfig.FLAVOR, "a", "Ljava/lang/String;", "mPostId", "b", "mItemType", "c", "I", "mTabId", "d", "Z", "fromComment", "e", "getTran_ops", "()Ljava/lang/String;", "setTran_ops", "(Ljava/lang/String;)V", "tran_ops", "f", "mNextPage", "g", "mPerPage", "h", "videoLoadMore", "Lcom/transsion/postdetail/viewmodel/w;", "i", "Lkotlin/Lazy;", "v0", "()Lcom/transsion/postdetail/viewmodel/w;", "mVideoViewModel", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "j", "Lcom/transsion/shorttv/base/pager/PagerLayoutManager;", "mPagerLayoutManager", "Lcom/transsion/postdetail/control/SubjectVideoPagerChangeControl;", "k", "Lcom/transsion/postdetail/control/SubjectVideoPagerChangeControl;", "mPagerChangeControl", "Lcom/transsion/postdetail/ui/adapter/i;", "l", "Lcom/transsion/postdetail/ui/adapter/i;", "mAdapter", "Lcom/transsion/player/orplayer/f;", "m", "Lcom/transsion/player/orplayer/f;", "mOrPlayer", "Lcom/transsion/player/ui/ORPlayerView;", "n", "Lcom/transsion/player/ui/ORPlayerView;", "mOrPlayerView", "o", "isLoadingData", "p", "isFirstLoadMore", "q", "attachToMain", "r", "savedCurrentIndex", BuildConfig.FLAVOR, "s", "J", "getResumeTimeStamp", "()J", "setResumeTimeStamp", "(J)V", "resumeTimeStamp", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "t", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "v3ListManager", "u", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvVideoFragment extends BaseFragment<wn.r> implements im.f {

    /* renamed from: u, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: from kotlin metadata */
    private int mTabId;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean fromComment;

    /* renamed from: e, reason: from kotlin metadata */
    private String tran_ops;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean videoLoadMore;

    /* renamed from: i, reason: from kotlin metadata */
    private final Lazy mVideoViewModel;

    /* renamed from: j, reason: from kotlin metadata */
    private PagerLayoutManager mPagerLayoutManager;

    /* renamed from: k, reason: from kotlin metadata */
    private SubjectVideoPagerChangeControl mPagerChangeControl;

    /* renamed from: l, reason: from kotlin metadata */
    private com.transsion.postdetail.ui.adapter.i mAdapter;

    /* renamed from: m, reason: from kotlin metadata */
    private com.transsion.player.orplayer.f mOrPlayer;

    /* renamed from: n, reason: from kotlin metadata */
    private ORPlayerView mOrPlayerView;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean isLoadingData;

    /* renamed from: p, reason: from kotlin metadata */
    private boolean isFirstLoadMore;

    /* renamed from: q, reason: from kotlin metadata */
    private boolean attachToMain;

    /* renamed from: r, reason: from kotlin metadata */
    private int savedCurrentIndex;

    /* renamed from: s, reason: from kotlin metadata */
    private long resumeTimeStamp;

    /* renamed from: t, reason: from kotlin metadata */
    private BiddingListManager v3ListManager;

    /* renamed from: a, reason: from kotlin metadata */
    private String mPostId = BuildConfig.FLAVOR;

    /* renamed from: b, reason: from kotlin metadata */
    private String mItemType = BuildConfig.FLAVOR;

    /* renamed from: f, reason: from kotlin metadata */
    private String mNextPage = MsgStyle.CUSTOM_LEFT_PIC;

    /* renamed from: g, reason: from kotlin metadata */
    private int mPerPage = 5;

    /* renamed from: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortTvVideoFragment a(Context context, String str, String str2, Integer num, boolean z, boolean z2, String str3, boolean z3) {
            String str4;
            Intrinsics.h(context, "context");
            ShortTvVideoFragment shortTvVideoFragment = new ShortTvVideoFragment();
            shortTvVideoFragment.J0(context);
            ImmVideoRequestEntity immVideoRequestEntity = new ImmVideoRequestEntity();
            immVideoRequestEntity.setPage(MsgStyle.CUSTOM_LEFT_PIC);
            immVideoRequestEntity.setPerPage(5);
            immVideoRequestEntity.setSessionId(jg.b.a.h());
            Uri b = com.transsion.baselib.report.h.a.b();
            if (b == null || (str4 = b.toString()) == null) {
                str4 = BuildConfig.FLAVOR;
            }
            immVideoRequestEntity.setDeepLink(str4);
            immVideoRequestEntity.setUserPrefer(BuildConfig.FLAVOR);
            immVideoRequestEntity.setLatest_events(new ej.a(ej.b.a.e()));
            immVideoRequestEntity.setPostId("0");
            immVideoRequestEntity.setTabId(num != null ? num.intValue() : 0);
            immVideoRequestEntity.setImmersiveRecType(1);
            shortTvVideoFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("id", str), TuplesKt.a("item_type", str2), TuplesKt.a("tab_id", num), TuplesKt.a("video_load_more", Boolean.valueOf(z)), TuplesKt.a("from_comment", Boolean.valueOf(z2)), TuplesKt.a("rec_ops", str3), TuplesKt.a("attach_to_main", Boolean.valueOf(z3)), TuplesKt.a("yy_preload_id", Integer.valueOf(am.e.a.c(new VideoImmersiveDataLoader(immVideoRequestEntity))))}));
            return shortTvVideoFragment;
        }
    }

    public static final class b extends androidx.activity.u {
        b() {
            super(true);
        }

        public void handleOnBackPressed() {
            FragmentActivity activity = ShortTvVideoFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static final class c implements yg.m {
        c() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            t6.f h0;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            if (((ShortTVRespData) ShortTvVideoFragment.this.v0().l().f()) == null) {
                ShortTvVideoFragment.this.loadData();
                return;
            }
            com.transsion.postdetail.ui.adapter.i iVar = ShortTvVideoFragment.this.mAdapter;
            if (((iVar == null || (h0 = iVar.h0()) == null) ? null : h0.i()) == LoadMoreStatus.Fail) {
                ShortTvVideoFragment.this.loadMore();
            }
        }

        public void onDisconnected() {
        }
    }

    static final class d implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        d(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.c0) && (obj instanceof FunctionAdapter)) {
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

    public ShortTvVideoFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m121invoke() {
                return this;
            }
        };
        this.mVideoViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.postdetail.viewmodel.w.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.x0 m122invoke() {
                androidx.lifecycle.x0 viewModelStore = ((androidx.lifecycle.y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m123invoke() {
                Object invoke = function0.invoke();
                androidx.lifecycle.m mVar = invoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.isFirstLoadMore = true;
        this.savedCurrentIndex = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(final ShortTvVideoFragment shortTvVideoFragment) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (!yg.l.a.e()) {
            wn.r rVar = (wn.r) shortTvVideoFragment.getMViewBinding();
            if (rVar == null || (recyclerView = rVar.d) == null) {
                return;
            }
            recyclerView.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.e5
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTvVideoFragment.C0(ShortTvVideoFragment.this);
                }
            }, 500L);
            return;
        }
        if (shortTvVideoFragment.isFirstLoadMore) {
            shortTvVideoFragment.isFirstLoadMore = false;
            shortTvVideoFragment.loadMore();
            return;
        }
        wn.r rVar2 = (wn.r) shortTvVideoFragment.getMViewBinding();
        if (rVar2 == null || (recyclerView2 = rVar2.d) == null) {
            return;
        }
        recyclerView2.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.d5
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvVideoFragment.B0(ShortTvVideoFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(ShortTvVideoFragment shortTvVideoFragment) {
        shortTvVideoFragment.loadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(ShortTvVideoFragment shortTvVideoFragment) {
        t6.f h0;
        shortTvVideoFragment.isLoadingData = false;
        com.transsion.postdetail.ui.adapter.i iVar = shortTvVideoFragment.mAdapter;
        if (iVar == null || (h0 = iVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(ShortTvVideoFragment shortTvVideoFragment, View view) {
        shortTvVideoFragment.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(ShortTvVideoFragment shortTvVideoFragment, ShortTVRespData shortTVRespData) {
        t6.f h0;
        com.transsion.postdetail.ui.adapter.i iVar;
        t6.f h02;
        List data;
        shortTvVideoFragment.isLoadingData = false;
        if (shortTVRespData == null) {
            com.transsion.postdetail.ui.adapter.i iVar2 = shortTvVideoFragment.mAdapter;
            if (iVar2 == null || (data = iVar2.getData()) == null || data.size() != 0) {
                com.transsion.postdetail.ui.adapter.i iVar3 = shortTvVideoFragment.mAdapter;
                if (iVar3 != null && (h0 = iVar3.h0()) != null && h0.r() && (iVar = shortTvVideoFragment.mAdapter) != null && (h02 = iVar.h0()) != null) {
                    h02.v();
                }
            } else if (yg.l.a.e()) {
                shortTvVideoFragment.showEmpty();
            } else {
                shortTvVideoFragment.showNotNetError();
            }
        } else {
            shortTvVideoFragment.L0(shortTVRespData);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(ShortTvVideoFragment shortTvVideoFragment, String str) {
        if (TextUtils.equals("0", str)) {
            gx.b.a.a().e(shortTvVideoFragment.mPostId);
            FragmentActivity activity = shortTvVideoFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else {
            b.a aVar = fh.b.a;
            FragmentActivity activity2 = shortTvVideoFragment.getActivity();
            aVar.e(activity2 != null ? activity2.getString(R.string.delete_post_failed) : null);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(ShortTvVideoFragment shortTvVideoFragment, List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            shortTvVideoFragment.showProgress();
            shortTvVideoFragment.loadData();
        } else {
            shortTvVideoFragment.L0(new ShortTVRespData(CollectionsKt.U0(list2), null, false));
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(final ShortTvVideoFragment shortTvVideoFragment, final Integer num) {
        RecyclerView recyclerView;
        try {
            if (num.intValue() >= 0) {
                SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = shortTvVideoFragment.mPagerChangeControl;
                if (subjectVideoPagerChangeControl != null) {
                    subjectVideoPagerChangeControl.r();
                }
                com.transsion.postdetail.ui.adapter.i iVar = shortTvVideoFragment.mAdapter;
                if (iVar != null) {
                    Intrinsics.e(num);
                    iVar.G0(num.intValue());
                }
                wn.r rVar = (wn.r) shortTvVideoFragment.getMViewBinding();
                if (rVar != null && (recyclerView = rVar.d) != null) {
                    recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.f5
                        @Override // java.lang.Runnable
                        public final void run() {
                            ShortTvVideoFragment.I0(ShortTvVideoFragment.this, num);
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(ShortTvVideoFragment shortTvVideoFragment, Integer num) {
        RecyclerView.a0 a0Var;
        RecyclerView recyclerView;
        Integer num2;
        wn.r rVar = (wn.r) shortTvVideoFragment.getMViewBinding();
        if (rVar == null || (recyclerView = rVar.d) == null) {
            a0Var = null;
        } else {
            com.transsion.postdetail.ui.adapter.i iVar = shortTvVideoFragment.mAdapter;
            if (iVar != null) {
                int a0 = iVar.a0();
                Intrinsics.e(num);
                num2 = Integer.valueOf(a0 + num.intValue());
            } else {
                num2 = num;
            }
            Intrinsics.e(num2);
            a0Var = recyclerView.findViewHolderForAdapterPosition(num2.intValue());
        }
        SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = shortTvVideoFragment.mPagerChangeControl;
        if (subjectVideoPagerChangeControl != null) {
            Intrinsics.e(num);
            subjectVideoPagerChangeControl.f(num.intValue(), true, a0Var != null ? a0Var.itemView : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(Context context) {
        ShortTvImmVideoHelper.k.a().v(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(ShortTvVideoFragment shortTvVideoFragment, int i) {
        PagerLayoutManager pagerLayoutManager = shortTvVideoFragment.mPagerLayoutManager;
        if (pagerLayoutManager != null) {
            View T = pagerLayoutManager.T();
            if (T != null) {
                a.a.r(wf.a.a, "ShortTvImmVideoPlayer", new String[]{"initView2， scrollToPosition ：" + i}, false, 4, (Object) null);
                SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = shortTvVideoFragment.mPagerChangeControl;
                if (subjectVideoPagerChangeControl != null) {
                    subjectVideoPagerChangeControl.f(i, true, T);
                    return;
                }
                return;
            }
            int childCount = pagerLayoutManager.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = pagerLayoutManager.getChildAt(i2);
                if (childAt != null && pagerLayoutManager.getPosition(childAt) == i) {
                    a.a.r(wf.a.a, "ShortTvImmVideoPlayer", new String[]{"initView， scrollToPosition ：" + i}, false, 4, (Object) null);
                    SubjectVideoPagerChangeControl subjectVideoPagerChangeControl2 = shortTvVideoFragment.mPagerChangeControl;
                    if (subjectVideoPagerChangeControl2 != null) {
                        subjectVideoPagerChangeControl2.f(i, true, childAt);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private final void L0(ShortTVRespData subjectBean) {
        String str;
        com.transsion.postdetail.ui.adapter.i iVar;
        t6.f h0;
        t6.f h02;
        com.transsion.postdetail.ui.adapter.i iVar2;
        t6.f h03;
        String url;
        Media video;
        hideProgress();
        Pager pager = subjectBean.getPager();
        if (pager == null || (str = pager.getNextPage()) == null) {
            str = MsgStyle.CUSTOM_LEFT_PIC;
        }
        this.mNextPage = str;
        List<Subject> items = subjectBean.getItems();
        if (items != null) {
            Iterator<Subject> it = items.iterator();
            while (it.hasNext()) {
                Subject next = it.next();
                ShortTVItem shortTVFirstEp = next.getShortTVFirstEp();
                if (((shortTVFirstEp == null || (video = shortTVFirstEp.getVideo()) == null) ? null : video.getVideoAddress()) != null) {
                    ShortTVItem shortTVFirstEp2 = next.getShortTVFirstEp();
                    Media video2 = shortTVFirstEp2 != null ? shortTVFirstEp2.getVideo() : null;
                    Intrinsics.e(video2);
                    Video videoAddress = video2.getVideoAddress();
                    if (videoAddress != null && (url = videoAddress.getUrl()) != null && url.length() == 0) {
                    }
                }
                it.remove();
            }
            com.transsion.postdetail.ui.adapter.i iVar3 = this.mAdapter;
            List data = iVar3 != null ? iVar3.getData() : null;
            ArrayList arrayList = new ArrayList();
            if (data == null || !(!data.isEmpty())) {
                arrayList.addAll(items);
            } else {
                Iterator<Subject> it2 = items.iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
            SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this.mPagerChangeControl;
            if (subjectVideoPagerChangeControl != null) {
                subjectVideoPagerChangeControl.g(arrayList);
            }
            SubjectVideoPagerChangeControl subjectVideoPagerChangeControl2 = this.mPagerChangeControl;
            if (subjectVideoPagerChangeControl2 != null) {
                subjectVideoPagerChangeControl2.o();
            }
            if (this.attachToMain) {
                ShortTvImmVideoHelper a = ShortTvImmVideoHelper.k.a();
                com.transsion.postdetail.ui.adapter.i iVar4 = this.mAdapter;
                a.z(iVar4 != null ? iVar4.getData() : null);
            }
        }
        com.transsion.postdetail.ui.adapter.i iVar5 = this.mAdapter;
        if (iVar5 != null && (h02 = iVar5.h0()) != null && h02.r() && (iVar2 = this.mAdapter) != null && (h03 = iVar2.h0()) != null) {
            h03.s();
        }
        Pager pager2 = subjectBean.getPager();
        if ((pager2 != null ? Intrinsics.c(pager2.getHasMore(), Boolean.FALSE) : false) && (iVar = this.mAdapter) != null && (h0 = iVar.h0()) != null) {
            t6.f.u(h0, false, 1, (Object) null);
        }
        int i = this.savedCurrentIndex;
        if (i >= 0) {
            scrollToPosition(i);
            this.savedCurrentIndex = -1;
        }
    }

    private final void doLoadData() {
        if (this.isLoadingData) {
            return;
        }
        this.isLoadingData = true;
        v0().k(this.mPostId, this.mTabId, this.mNextPage, this.mPerPage, 1);
    }

    private final View getEmptyView(Context context) {
        final DefaultView defaultView = new DefaultView(context, DefaultView.ModelStyle.MODEL_STYLE_NIGHT);
        defaultView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        defaultView.setGravity(17);
        defaultView.setDefaultImageViewVisibility(0);
        defaultView.setDefaultImage(com.tn.lib.widget.R.mipmap.ic_no_content);
        String string = context.getString(com.tn.lib.widget.R.string.no_content);
        Intrinsics.g(string, "getString(...)");
        defaultView.setDescText(string);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DESC_BTN);
        defaultView.setBtnVisibility(0);
        String string2 = context.getString(com.transsion.baseui.R.string.retry_text);
        Intrinsics.g(string2, "getString(...)");
        defaultView.setBtnText(string2);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.l5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvVideoFragment.u0(ShortTvVideoFragment.this, defaultView, view);
            }
        });
        defaultView.setVisibility(0);
        return defaultView;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.transsion.postdetail.ui.view.ImmVideoNoNetworkView] */
    private final View getNotNetErrorView(Context context) {
        final ?? immVideoNoNetworkView = new ImmVideoNoNetworkView(context);
        uf.c.e((View) immVideoNoNetworkView);
        immVideoNoNetworkView.retry(new Function0() { // from class: com.transsion.postdetail.ui.fragment.i5
            public final Object invoke() {
                Unit w0;
                w0 = ShortTvVideoFragment.w0(ImmVideoNoNetworkView.this, this);
                return w0;
            }
        });
        immVideoNoNetworkView.goToSetting(new Function0() { // from class: com.transsion.postdetail.ui.fragment.j5
            public final Object invoke() {
                Unit x0;
                x0 = ShortTvVideoFragment.x0();
                return x0;
            }
        });
        com.tn.lib.view.o.a("shorttv_detail_video");
        return immVideoNoNetworkView;
    }

    private final void hideProgress() {
    }

    private final void initAd() {
        BiddingListManager biddingListManager = new BiddingListManager();
        this.v3ListManager = biddingListManager;
        wn.r rVar = (wn.r) getMViewBinding();
        biddingListManager.F(rVar != null ? rVar.d : null);
        BiddingListManager biddingListManager2 = this.v3ListManager;
        if (biddingListManager2 != null) {
            biddingListManager2.A(androidx.lifecycle.v.a(this));
        }
        BiddingListManager biddingListManager3 = this.v3ListManager;
        if (biddingListManager3 != null) {
            biddingListManager3.G("VideoForYouListScene");
        }
        BiddingListManager biddingListManager4 = this.v3ListManager;
        if (biddingListManager4 != null) {
            biddingListManager4.z(new Function2() { // from class: com.transsion.postdetail.ui.fragment.m5
                public final Object invoke(Object obj, Object obj2) {
                    Unit z0;
                    z0 = ShortTvVideoFragment.z0(ShortTvVideoFragment.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                    return z0;
                }
            });
        }
    }

    private final void initAdapter() {
        com.transsion.postdetail.ui.adapter.i iVar = new com.transsion.postdetail.ui.adapter.i(new ArrayList(), this, this.mPostId, this.mItemType, this.attachToMain);
        iVar.h0().z(this.videoLoadMore);
        if (this.videoLoadMore) {
            iVar.h0().C(new ImmVideoLoadMoreView());
            iVar.h0().z(true);
            iVar.h0().y(true);
            iVar.h0().E(2);
            iVar.h0().D(new r6.f() { // from class: com.transsion.postdetail.ui.fragment.o5
                public final void a() {
                    ShortTvVideoFragment.A0(ShortTvVideoFragment.this);
                }
            });
        }
        this.mAdapter = iVar;
    }

    private final void initBack() {
        AppCompatImageView appCompatImageView;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView2;
        ConstraintLayout constraintLayout;
        wn.r rVar = (wn.r) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (rVar == null || (constraintLayout = rVar.e) == null) ? null : constraintLayout.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin = com.blankj.utilcode.util.d.c();
        if (this.mPostId.length() == 0) {
            wn.r rVar2 = (wn.r) getMViewBinding();
            if (rVar2 == null || (appCompatImageView2 = rVar2.b) == null) {
                return;
            }
            uf.c.g(appCompatImageView2);
            return;
        }
        wn.r rVar3 = (wn.r) getMViewBinding();
        if (rVar3 != null && (tnTextView = rVar3.f) != null) {
            uf.c.g(tnTextView);
        }
        wn.r rVar4 = (wn.r) getMViewBinding();
        if (rVar4 != null && (appCompatImageView = rVar4.b) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.n5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShortTvVideoFragment.D0(ShortTvVideoFragment.this, view);
                }
            });
        }
        requireActivity().getOnBackPressedDispatcher().i(this, new b());
    }

    private final void initNonAd() {
    }

    private final void initPlayer() {
        com.transsion.player.orplayer.f a;
        eo.b bVar = eo.b.a;
        if (bVar.b()) {
            a = new pn.e(null, 1, null);
            a.setLooping(true);
            a.prepare();
            a.play();
        } else {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            a = new f.a(requireContext).b(new hn.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, true, false, false, false, null, 126975, null)).a();
        }
        this.mOrPlayer = a;
        if (bVar.b()) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.g(requireActivity, "requireActivity(...)");
            ORPlayerView oRPlayerView = new ORPlayerView(requireActivity, RenderType.SURFACE_VIEW);
            this.mOrPlayerView = oRPlayerView;
            com.transsion.player.orplayer.f fVar = this.mOrPlayer;
            if (fVar != null) {
                fVar.setSurfaceView(oRPlayerView.getSurface());
            }
        } else {
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.g(requireActivity2, "requireActivity(...)");
            ORPlayerView oRPlayerView2 = new ORPlayerView(requireActivity2, RenderType.TEXTURE_VIEW);
            this.mOrPlayerView = oRPlayerView2;
            com.transsion.player.orplayer.f fVar2 = this.mOrPlayer;
            if (fVar2 != null) {
                fVar2.setTextureView(oRPlayerView2.getTextureView());
            }
        }
        com.transsion.player.orplayer.f fVar3 = this.mOrPlayer;
        if (fVar3 != null) {
            fVar3.setLooping(true);
        }
    }

    private final void initViewModel() {
        v0().l().j(this, new d(new Function1() { // from class: com.transsion.postdetail.ui.fragment.b5
            public final Object invoke(Object obj) {
                Unit E0;
                E0 = ShortTvVideoFragment.E0(ShortTvVideoFragment.this, (ShortTVRespData) obj);
                return E0;
            }
        }));
        v0().j().j(this, new d(new Function1() { // from class: com.transsion.postdetail.ui.fragment.g5
            public final Object invoke(Object obj) {
                Unit F0;
                F0 = ShortTvVideoFragment.F0(ShortTvVideoFragment.this, (String) obj);
                return F0;
            }
        }));
        if (this.attachToMain) {
            ShortTvImmVideoHelper.k.a().n().j(this, new d(new Function1() { // from class: com.transsion.postdetail.ui.fragment.h5
                public final Object invoke(Object obj) {
                    Unit G0;
                    G0 = ShortTvVideoFragment.G0(ShortTvVideoFragment.this, (List) obj);
                    return G0;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        doLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMore() {
        loadData();
    }

    private final void observeRemoveVideo() {
        v0().o().j(this, new d(new Function1() { // from class: com.transsion.postdetail.ui.fragment.k5
            public final Object invoke(Object obj) {
                Unit H0;
                H0 = ShortTvVideoFragment.H0(ShortTvVideoFragment.this, (Integer) obj);
                return H0;
            }
        }));
    }

    private final void scrollToPosition(final int it) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        List data;
        com.transsion.postdetail.ui.adapter.i iVar = this.mAdapter;
        if (((iVar == null || (data = iVar.getData()) == null) ? 0 : data.size()) <= it) {
            return;
        }
        wn.r rVar = (wn.r) getMViewBinding();
        if (rVar != null && (recyclerView2 = rVar.d) != null) {
            recyclerView2.scrollToPosition(it);
        }
        wn.r rVar2 = (wn.r) getMViewBinding();
        if (rVar2 == null || (recyclerView = rVar2.d) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.c5
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvVideoFragment.K0(ShortTvVideoFragment.this, it);
            }
        });
    }

    private final void showEmpty() {
        com.transsion.postdetail.ui.adapter.i iVar;
        List data;
        hideProgress();
        com.transsion.postdetail.ui.adapter.i iVar2 = this.mAdapter;
        if (iVar2 == null || (data = iVar2.getData()) == null || !(!data.isEmpty())) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            View emptyView = getEmptyView(requireContext);
            if (emptyView == null || (iVar = this.mAdapter) == null) {
                return;
            }
            iVar.Y0(emptyView);
        }
    }

    private final void showNotNetError() {
        com.transsion.postdetail.ui.adapter.i iVar;
        List data;
        hideProgress();
        com.transsion.postdetail.ui.adapter.i iVar2 = this.mAdapter;
        if (iVar2 == null || (data = iVar2.getData()) == null || !(!data.isEmpty())) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            View notNetErrorView = getNotNetErrorView(requireContext);
            if (notNetErrorView == null || (iVar = this.mAdapter) == null) {
                return;
            }
            iVar.Y0(notNetErrorView);
        }
    }

    private final void showProgress() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(ShortTvVideoFragment shortTvVideoFragment, DefaultView defaultView, View view) {
        shortTvVideoFragment.loadData();
        defaultView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.postdetail.viewmodel.w v0() {
        return (com.transsion.postdetail.viewmodel.w) this.mVideoViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit w0(ImmVideoNoNetworkView immVideoNoNetworkView, ShortTvVideoFragment shortTvVideoFragment) {
        uf.c.g(immVideoNoNetworkView);
        shortTvVideoFragment.showProgress();
        shortTvVideoFragment.loadData();
        com.tn.lib.view.o.b("shorttv_detail_video");
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0() {
        com.tn.lib.view.o.c("shorttv_detail_video");
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(ShortTvVideoFragment shortTvVideoFragment, int i, BiddingNativeManager biddingNativeManager) {
        List data;
        Intrinsics.h(biddingNativeManager, "current");
        if (biddingNativeManager != null) {
            Subject subject = new Subject((String) null, (Integer) null, (String) null, (String) null, (Cover) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -1, 67108863, (DefaultConstructorMarker) null);
            subject.setNonAdDelegate(biddingNativeManager);
            com.transsion.postdetail.ui.adapter.i iVar = shortTvVideoFragment.mAdapter;
            int size = (iVar == null || (data = iVar.getData()) == null) ? 0 : data.size();
            if (i <= size) {
                com.transsion.postdetail.ui.adapter.i iVar2 = shortTvVideoFragment.mAdapter;
                if (iVar2 != null) {
                    iVar2.n(i, subject);
                }
            } else {
                com.transsion.postdetail.ui.adapter.i iVar3 = shortTvVideoFragment.mAdapter;
                if (iVar3 != null) {
                    iVar3.n(size, subject);
                }
            }
        }
        return Unit.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        if (r1 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initData(View view, Bundle savedInstanceState) {
        List k;
        String str;
        Intrinsics.h(view, "view");
        setNetListener(new c());
        initViewModel();
        ShortTVRespData n = v0().n();
        if (n != null) {
            Pager pager = n.getPager();
            if (pager == null || (str = pager.getNextPage()) == null) {
                str = MsgStyle.CUSTOM_LEFT_PIC;
            }
            this.mNextPage = str;
            k = n.getItems();
        }
        k = ShortTvImmVideoHelper.k.a().k();
        if (!k.isEmpty()) {
            SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this.mPagerChangeControl;
            if (subjectVideoPagerChangeControl != null) {
                subjectVideoPagerChangeControl.g(k);
                return;
            }
            return;
        }
        if (this.attachToMain) {
            ShortTvImmVideoHelper.k.a().t();
        } else {
            showProgress();
            loadData();
        }
    }

    public void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        Intrinsics.h(view, "view");
        int i = savedInstanceState != null ? savedInstanceState.getInt("CURRENT_INDEX") : -1;
        this.savedCurrentIndex = i;
        a.a.r(wf.a.a, "ShortTvImmVideoPlayer", new String[]{"initView， savedCurrentIndex ：" + i}, false, 4, (Object) null);
        initAd();
        initNonAd();
        initAdapter();
        initPlayer();
        initBack();
        observeRemoveVideo();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        this.mPagerLayoutManager = new PagerLayoutManager(requireActivity);
        SubjectVideoPagerChangeControl aVar = eo.b.a.b() ? new com.transsion.postdetail.control.a(this, this.mAdapter, this.mOrPlayer, this.mOrPlayerView, this.mPagerLayoutManager) : new SubjectVideoPagerChangeControl(this, this.mAdapter, this.mOrPlayer, this.mOrPlayerView, this.mPagerLayoutManager);
        this.mPagerChangeControl = aVar;
        PagerLayoutManager pagerLayoutManager = this.mPagerLayoutManager;
        if (pagerLayoutManager != null) {
            pagerLayoutManager.X(aVar);
        }
        wn.r rVar = (wn.r) getMViewBinding();
        if (rVar != null && (recyclerView = rVar.d) != null) {
            recyclerView.setLayoutManager(this.mPagerLayoutManager);
            recyclerView.setAdapter(this.mAdapter);
            recyclerView.setHasFixedSize(true);
        }
        ShortTvImmVideoHelper a = ShortTvImmVideoHelper.k.a();
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.g(requireActivity2, "requireActivity(...)");
        a.p(requireActivity2);
    }

    public void lazyLoadData() {
    }

    public void logPause() {
        super.logPause();
        if (this.resumeTimeStamp != 0) {
            com.transsion.baselib.report.e.a.n("shorttv_detail_video", Long.valueOf(SystemClock.elapsedRealtime() - this.resumeTimeStamp), getContext());
        }
    }

    public void logResume() {
        super.logResume();
        this.resumeTimeStamp = SystemClock.elapsedRealtime();
    }

    public qi.b newLogViewConfig() {
        return new qi.b("shorttv_detail_video", false, 2, null);
    }

    public void onCreate(Bundle savedInstanceState) {
        String str;
        HashMap g;
        HashMap g2;
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String str2 = BuildConfig.FLAVOR;
        if (arguments == null || (str = arguments.getString("id")) == null) {
            str = BuildConfig.FLAVOR;
        }
        this.mPostId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString("item_type")) != null) {
            str2 = string;
        }
        this.mItemType = str2;
        Bundle arguments3 = getArguments();
        this.mTabId = arguments3 != null ? arguments3.getInt("tab_id") : 0;
        Bundle arguments4 = getArguments();
        this.videoLoadMore = arguments4 != null ? arguments4.getBoolean("video_load_more", true) : true;
        Bundle arguments5 = getArguments();
        this.fromComment = arguments5 != null ? arguments5.getBoolean("from_comment") : false;
        Bundle arguments6 = getArguments();
        this.tran_ops = arguments6 != null ? arguments6.getString("rec_ops") : null;
        Bundle arguments7 = getArguments();
        this.attachToMain = arguments7 != null ? arguments7.getBoolean("attach_to_main") : false;
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g2 = logViewConfig.g()) != null) {
        }
        qi.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g = logViewConfig2.g()) != null) {
        }
        com.transsion.postdetail.viewmodel.w v0 = v0();
        if (v0 != null) {
            Bundle arguments8 = getArguments();
            v0.q(arguments8 != null ? Integer.valueOf(arguments8.getInt("yy_preload_id")) : null);
        }
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.D(this);
        }
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), (CoroutineContext) null, (CoroutineStart) null, new ShortTvVideoFragment$onDestroy$1(this, null), 3, (Object) null);
        ShortTvImmVideoHelper.k.a().j();
        BiddingListManager biddingListManager = this.v3ListManager;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.v(this);
        }
    }

    public void onHiddenChanged(boolean hidden) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                com.transsion.player.orplayer.f fVar = this.mOrPlayer;
                if (fVar != null) {
                    fVar.pause();
                }
                logPause();
            } else {
                com.transsion.player.orplayer.f fVar2 = this.mOrPlayer;
                if (fVar2 != null) {
                    fVar2.play();
                }
                logResume();
            }
            SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this.mPagerChangeControl;
            if (subjectVideoPagerChangeControl != null) {
                subjectVideoPagerChangeControl.p(hidden);
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    @Override // im.f
    public void onMemberStateChange() {
        a.a.f(wf.a.a, "co_mem", "VideoFragment --> onMemberStateChange() --> refresh list", false, 4, (Object) null);
        com.transsion.postdetail.ui.adapter.i iVar = this.mAdapter;
        if (iVar != null) {
            iVar.n1((Collection) null);
        }
        loadData();
    }

    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.k.l(null, this, null, 5, null);
    }

    public void onResume() {
        super.onResume();
        com.transsion.baseui.activity.k.p(null, this, "visible=" + isVisible(), 1, null);
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(outState);
        SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this.mPagerChangeControl;
        outState.putInt("CURRENT_INDEX", subjectVideoPagerChangeControl != null ? subjectVideoPagerChangeControl.i() : 0);
    }

    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public wn.r getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        wn.r c2 = wn.r.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
