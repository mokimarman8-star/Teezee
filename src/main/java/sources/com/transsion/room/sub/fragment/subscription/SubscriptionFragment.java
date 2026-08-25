package com.transsion.room.sub.fragment.subscription;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baselib.report.g;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.sub.adapter.subscription.a;
import com.transsion.room.sub.adapter.subscription.k;
import com.transsion.room.sub.bean.subscription.ItemTrending;
import com.transsion.room.sub.bean.subscription.PagerTrending;
import com.transsion.room.sub.bean.subscription.SubscriptionFeedBean;
import com.transsion.room.sub.bean.subscription.SubscriptionStatsBean;
import com.transsion.room.sub.bean.subscription.TopicItemTrending;
import com.transsion.room.sub.bean.subscription.UgcTrendingHomeBean;
import com.transsion.room.sub.fragment.subscription.SubscriptionFragment;
import com.transsion.room.sub.view.SubscriptionLoadMoreView;
import com.transsion.room.sub.viewmodel.likes.UgcLikesViewModel;
import com.transsion.room.sub.viewmodel.subscription.SubscriptionFeedListViewModel;
import com.transsion.room.sub.viewmodel.subscription.SubscriptionViewModel;
import com.transsion.room.sub.viewmodel.subscription.UgcTrendingHomeViewModel;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.loginapi.bean.UserInfo;
import fp.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import qi.h;
import qx.b;
import r6.f;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u009d\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0003=\u009e\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0007J\u001d\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u000b2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u0016J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010\u0007J\u0019\u0010#\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b#\u0010$J!\u0010(\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u00182\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b*\u0010\u0007J\u000f\u0010+\u001a\u00020\u000bH\u0002¢\u0006\u0004\b+\u0010\u0007J\u0017\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020!H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u000bH\u0016¢\u0006\u0004\b2\u0010\u0007J\u000f\u00103\u001a\u00020\u000bH\u0016¢\u0006\u0004\b3\u0010\u0007J\u000f\u00104\u001a\u00020\u000bH\u0016¢\u0006\u0004\b4\u0010\u0007J\u000f\u00105\u001a\u00020\u000bH\u0016¢\u0006\u0004\b5\u0010\u0007J\u000f\u00106\u001a\u00020\u000bH\u0016¢\u0006\u0004\b6\u0010\u0007J\u001f\u00109\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020!H\u0016¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0018H\u0016¢\u0006\u0004\b=\u0010<J#\u0010?\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u00010!2\b\u0010>\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b?\u0010@J\u0019\u0010A\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\bA\u0010$J\u0019\u0010B\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\bB\u0010<J\u0017\u0010E\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u000bH\u0016¢\u0006\u0004\bG\u0010\u0007J\u0017\u0010H\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bH\u0010FJ\u000f\u0010I\u001a\u00020\u000bH\u0016¢\u0006\u0004\bI\u0010\u0007J\u0017\u0010K\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\bH\u0016¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u000bH\u0016¢\u0006\u0004\bM\u0010\u0007J\u000f\u0010N\u001a\u00020\u000bH\u0016¢\u0006\u0004\bN\u0010\u0007J\u000f\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\u000bH\u0016¢\u0006\u0004\bR\u0010\u0007J\u000f\u0010S\u001a\u00020\u000bH\u0016¢\u0006\u0004\bS\u0010\u0007R\u0018\u0010U\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010[\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010XR\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010cR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010iR\u0018\u0010o\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010r\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010cR\u0016\u0010v\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010cR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010~\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001b\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b;\u0010\u008c\u0001R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R#\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0092\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0017\u0010\u0098\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010cR\u0018\u0010\u009a\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010TR\u0018\u0010\u009c\u0001\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010`¨\u0006\u009f\u0001"}, d2 = {"Lcom/transsion/room/sub/fragment/subscription/SubscriptionFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lfp/t;", "Lcom/transsion/room/sub/adapter/subscription/a;", "Lqx/b;", "Lcom/transsion/baselib/report/g;", "<init>", "()V", BuildConfig.FLAVOR, "S0", "()Z", BuildConfig.FLAVOR, "K0", "E0", "Q0", "V0", "L0", "T0", BuildConfig.FLAVOR, "Lcom/transsion/room/sub/bean/subscription/ItemTrending;", "feedItems", "a1", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "Z0", "Lcom/transsion/room/sub/adapter/subscription/k;", "N0", "()Lcom/transsion/room/sub/adapter/subscription/k;", "Lcom/transsion/room/sub/adapter/subscription/c;", "F0", "()Lcom/transsion/room/sub/adapter/subscription/c;", "I0", BuildConfig.FLAVOR, "userId", "z0", "(Ljava/lang/String;)V", "item", BuildConfig.FLAVOR, "bottomFragmentIndex", "C0", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;I)V", "Y0", "y0", "Landroid/view/LayoutInflater;", "inflater", "B0", "(Landroid/view/LayoutInflater;)Lfp/t;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "loadDefaultData", "initViewData", "initViewModel", "initListener", "retryLoadData", "isLike", "ugcVideoId", "w", "(ZLjava/lang/String;)V", "t", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;)V", "a", "title", "I", "(Ljava/lang/String;Ljava/lang/String;)V", "b", "E", "Lcom/transsnet/loginapi/bean/UserInfo;", "user", "onLogin", "(Lcom/transsnet/loginapi/bean/UserInfo;)V", "onLogout", "onUpdateUserInfo", "onPause", "hidden", "onHiddenChanged", "(Z)V", "onResume", "onDestroy", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "logResume", "logPause", "Ljava/lang/String;", "cursorFeed", "pageNext", "c", "Ljava/lang/Boolean;", "isFirstFeedDataRequest", "d", "hasMoreFeedData", "e", "hasMoreUgcHomeData", BuildConfig.FLAVOR, "f", "J", "firstLoadStartTimeMillis", "g", "Z", "hasFollowings", "h", "isLoginRefresh", "Lbj/b;", "i", "Lbj/b;", "mExposureHelper", "j", "mExposureRecommendHelper", "k", "Lcom/transsion/room/sub/adapter/subscription/c;", "sFeedAdapter", "l", "Lcom/transsion/room/sub/adapter/subscription/k;", "sFeedTrendingAdapter", "m", "isLoading", "n", "isUgcTrendingHomeLoading", "Lcom/transsion/room/sub/fragment/subscription/SubscriptionFragment$TabType;", "o", "Lcom/transsion/room/sub/fragment/subscription/SubscriptionFragment$TabType;", "mCurrentTab", "Lcom/transsion/room/sub/viewmodel/subscription/SubscriptionViewModel;", "p", "Lcom/transsion/room/sub/viewmodel/subscription/SubscriptionViewModel;", "viewModel", "Lcom/transsion/room/sub/viewmodel/subscription/SubscriptionFeedListViewModel;", "q", "Lcom/transsion/room/sub/viewmodel/subscription/SubscriptionFeedListViewModel;", "feedListViewModel", "Lcom/transsion/room/sub/viewmodel/likes/UgcLikesViewModel;", "r", "Lcom/transsion/room/sub/viewmodel/likes/UgcLikesViewModel;", "ugcLikesViewModel", "Lcom/transsion/room/sub/viewmodel/subscription/UgcTrendingHomeViewModel;", "s", "Lcom/transsion/room/sub/viewmodel/subscription/UgcTrendingHomeViewModel;", "ugcHomeViewModel", "Lcom/transsion/room/sub/viewmodel/subscription/a;", "Lcom/transsion/room/sub/viewmodel/subscription/a;", "subUnsubViewModel", "Lcom/transsion/share/share/ShareDialogFragment;", "u", "Lcom/transsion/share/share/ShareDialogFragment;", "shareDialog", "Lqx/a;", "v", "Lkotlin/Lazy;", "getLoginApi", "()Lqx/a;", "loginApi", "isSelf", "x", "pageFrom", "y", "resumeTimeStamp", "z", "TabType", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubscriptionFragment extends PageStatusFragment<t> implements a, qx.b, g {

    /* renamed from: z, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private String cursorFeed;

    /* renamed from: b, reason: from kotlin metadata */
    private String pageNext;

    /* renamed from: c, reason: from kotlin metadata */
    private Boolean isFirstFeedDataRequest;

    /* renamed from: d, reason: from kotlin metadata */
    private Boolean hasMoreFeedData;

    /* renamed from: e, reason: from kotlin metadata */
    private Boolean hasMoreUgcHomeData;

    /* renamed from: f, reason: from kotlin metadata */
    private long firstLoadStartTimeMillis;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean hasFollowings;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean isLoginRefresh;

    /* renamed from: i, reason: from kotlin metadata */
    private bj.b mExposureHelper;

    /* renamed from: j, reason: from kotlin metadata */
    private bj.b mExposureRecommendHelper;

    /* renamed from: k, reason: from kotlin metadata */
    private com.transsion.room.sub.adapter.subscription.c sFeedAdapter;

    /* renamed from: l, reason: from kotlin metadata */
    private k sFeedTrendingAdapter;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean isUgcTrendingHomeLoading;

    /* renamed from: o, reason: from kotlin metadata */
    private TabType mCurrentTab;

    /* renamed from: p, reason: from kotlin metadata */
    private SubscriptionViewModel viewModel;

    /* renamed from: q, reason: from kotlin metadata */
    private SubscriptionFeedListViewModel feedListViewModel;

    /* renamed from: r, reason: from kotlin metadata */
    private UgcLikesViewModel ugcLikesViewModel;

    /* renamed from: s, reason: from kotlin metadata */
    private UgcTrendingHomeViewModel ugcHomeViewModel;

    /* renamed from: t, reason: from kotlin metadata */
    private com.transsion.room.sub.viewmodel.subscription.a subUnsubViewModel;

    /* renamed from: u, reason: from kotlin metadata */
    private ShareDialogFragment shareDialog;

    /* renamed from: v, reason: from kotlin metadata */
    private final Lazy loginApi;

    /* renamed from: w, reason: from kotlin metadata */
    private boolean isSelf;

    /* renamed from: x, reason: from kotlin metadata */
    private String pageFrom;

    /* renamed from: y, reason: from kotlin metadata */
    private long resumeTimeStamp;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/room/sub/fragment/subscription/SubscriptionFragment$TabType;", BuildConfig.FLAVOR, "apiValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getApiValue", "()Ljava/lang/String;", "FOR_U", "LATEST", "HOTTEST", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TabType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TabType[] $VALUES;
        private final String apiValue;
        public static final TabType FOR_U = new TabType("FOR_U", 0, "ForYou");
        public static final TabType LATEST = new TabType("LATEST", 1, "Latest");
        public static final TabType HOTTEST = new TabType("HOTTEST", 2, "New");

        private static final /* synthetic */ TabType[] $values() {
            return new TabType[]{FOR_U, LATEST, HOTTEST};
        }

        static {
            TabType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private TabType(String str, int i, String str2) {
            this.apiValue = str2;
        }

        public static EnumEntries<TabType> getEntries() {
            return $ENTRIES;
        }

        public static TabType valueOf(String str) {
            return (TabType) Enum.valueOf(TabType.class, str);
        }

        public static TabType[] values() {
            return (TabType[]) $VALUES.clone();
        }

        public final String getApiValue() {
            return this.apiValue;
        }
    }

    /* renamed from: com.transsion.room.sub.fragment.subscription.SubscriptionFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubscriptionFragment a() {
            Bundle bundle = new Bundle();
            SubscriptionFragment subscriptionFragment = new SubscriptionFragment();
            subscriptionFragment.setArguments(bundle);
            return subscriptionFragment;
        }
    }

    public static final class b implements bj.a {
        b() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            List data;
            String str;
            UGCVideoBelongToCollection belongToCollection;
            String collectionId;
            com.transsion.room.sub.adapter.subscription.c cVar = SubscriptionFragment.this.sFeedAdapter;
            if (cVar == null || (data = cVar.getData()) == null) {
                return;
            }
            int size = data.size();
            SubscriptionFragment subscriptionFragment = SubscriptionFragment.this;
            if (subscriptionFragment.hasFollowings) {
                StringBuilder sb = new StringBuilder();
                sb.append("Subscription曝光的位置position: ");
                sb.append(i);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Subscription曝光的位置duration: ");
                sb2.append(j);
                if (i >= size) {
                    return;
                }
                com.transsion.room.sub.adapter.subscription.c cVar2 = subscriptionFragment.sFeedAdapter;
                UGCVideo uGCVideo = cVar2 != null ? (UGCVideo) cVar2.getItem(i) : null;
                HashMap hashMap = new HashMap();
                hashMap.put("item_type", "subscription");
                hashMap.put("module_name", "item");
                hashMap.put("ops", String.valueOf(uGCVideo != null ? uGCVideo.getOps() : null));
                hashMap.put("position", String.valueOf(i));
                hashMap.put("refer_subject_id", String.valueOf(uGCVideo != null ? uGCVideo.getSubjectId() : null));
                hashMap.put("content_type", "ugc_video");
                String str2 = BuildConfig.FLAVOR;
                if (uGCVideo == null || (str = uGCVideo.getUgcVideoId()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                hashMap.put("content_id", str);
                hashMap.put("browse_duration", String.valueOf(j));
                if (uGCVideo != null && (belongToCollection = uGCVideo.getBelongToCollection()) != null && (collectionId = belongToCollection.getCollectionId()) != null) {
                    str2 = collectionId;
                }
                hashMap.put("belong_to_collection_id", str2);
                com.transsion.baselib.helper.a.a.e("/subscription/subscription", hashMap);
            }
        }
    }

    public static final class c implements bj.a {
        c() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            List data;
            String str;
            TopicItemTrending content;
            UGCVideo video;
            UGCVideoBelongToCollection belongToCollection;
            String collectionId;
            TopicItemTrending content2;
            UGCVideo video2;
            TopicItemTrending content3;
            UGCVideo video3;
            TopicItemTrending content4;
            UGCVideo video4;
            k kVar = SubscriptionFragment.this.sFeedTrendingAdapter;
            if (kVar == null || (data = kVar.getData()) == null) {
                return;
            }
            int size = data.size();
            SubscriptionFragment subscriptionFragment = SubscriptionFragment.this;
            if (subscriptionFragment.hasFollowings) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Recommend曝光的位置position: ");
            sb.append(i);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Recommend曝光的位置duration: ");
            sb2.append(j);
            if (i >= size) {
                return;
            }
            k kVar2 = subscriptionFragment.sFeedTrendingAdapter;
            String str2 = null;
            ItemTrending itemTrending = kVar2 != null ? (ItemTrending) kVar2.getItem(i) : null;
            HashMap hashMap = new HashMap();
            hashMap.put("item_type", "recommend");
            hashMap.put("module_name", "item");
            hashMap.put("ops", String.valueOf((itemTrending == null || (content4 = itemTrending.getContent()) == null || (video4 = content4.getVideo()) == null) ? null : video4.getOps()));
            hashMap.put("position", String.valueOf(i));
            if (itemTrending != null && (content3 = itemTrending.getContent()) != null && (video3 = content3.getVideo()) != null) {
                str2 = video3.getSubjectId();
            }
            hashMap.put("refer_subject_id", String.valueOf(str2));
            hashMap.put("content_type", "ugc_video");
            hashMap.put("browse_duration", String.valueOf(j));
            String str3 = BuildConfig.FLAVOR;
            if (itemTrending == null || (content2 = itemTrending.getContent()) == null || (video2 = content2.getVideo()) == null || (str = video2.getUgcVideoId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("content_id", str);
            if (itemTrending != null && (content = itemTrending.getContent()) != null && (video = content.getVideo()) != null && (belongToCollection = video.getBelongToCollection()) != null && (collectionId = belongToCollection.getCollectionId()) != null) {
                str3 = collectionId;
            }
            hashMap.put("belong_to_collection_id", str3);
            com.transsion.baselib.helper.a.a.e("/subscription/subscription", hashMap);
        }
    }

    public static final class d implements com.transsion.share.share.a {
        d() {
        }

        @Override // com.transsion.share.share.a
        public void a(String str, PostType postType) {
            Intrinsics.h(str, "id");
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
        }

        @Override // com.transsion.share.share.a
        public void c(String str, String str2, String str3, String str4) {
            Intrinsics.h(str, "url");
            Intrinsics.h(str2, "fileName");
            Intrinsics.h(str3, "fileSize");
            Intrinsics.h(str4, "fileImage");
        }

        @Override // com.transsion.share.share.a
        public void d(String str) {
            Intrinsics.h(str, "id");
        }

        @Override // com.transsion.share.share.a
        public void e(String str) {
            a.C0056a.c(this, str);
        }
    }

    static final class e implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        e(Function1 function1) {
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

    public SubscriptionFragment() {
        Boolean bool = Boolean.FALSE;
        this.isFirstFeedDataRequest = bool;
        this.hasMoreFeedData = bool;
        this.hasMoreUgcHomeData = bool;
        this.mCurrentTab = TabType.HOTTEST;
        this.loginApi = LazyKt.b(new Function0() { // from class: mp.a
            public final Object invoke() {
                qx.a X0;
                X0 = SubscriptionFragment.X0();
                return X0;
            }
        });
        this.pageFrom = BuildConfig.FLAVOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(SubscriptionFragment subscriptionFragment, SubscriptionStatsBean subscriptionStatsBean) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (subscriptionStatsBean == null && !l.a.e()) {
            subscriptionFragment.showNoNetworkView(false);
        }
        Integer followingCount = subscriptionStatsBean != null ? subscriptionStatsBean.getFollowingCount() : null;
        a.a aVar = wf.a.a;
        a.a.f(aVar, "SubscriptionFragment", "followingCount ：" + followingCount, false, 4, (Object) null);
        if (followingCount != null) {
            if (followingCount.intValue() > 0) {
                a.a.f(aVar, "SubscriptionFragment", "有订阅，走订阅接口", false, 4, (Object) null);
                subscriptionFragment.hasFollowings = true;
                if (subscriptionFragment.isLoginRefresh) {
                    SubscriptionFeedListViewModel subscriptionFeedListViewModel = subscriptionFragment.feedListViewModel;
                    if (subscriptionFeedListViewModel != null) {
                        subscriptionFeedListViewModel.i();
                    }
                } else {
                    subscriptionFragment.isFirstFeedDataRequest = Boolean.TRUE;
                    subscriptionFragment.T0();
                    t tVar = (t) subscriptionFragment.getMViewBinding();
                    if (tVar != null && (recyclerView2 = tVar.c) != null) {
                        recyclerView2.setAdapter(subscriptionFragment.sFeedAdapter);
                    }
                }
            } else {
                a.a.f(aVar, "SubscriptionFragment", "无订阅，走推荐接口", false, 4, (Object) null);
                subscriptionFragment.hasFollowings = false;
                if (subscriptionFragment.isLoginRefresh) {
                    UgcTrendingHomeViewModel ugcTrendingHomeViewModel = subscriptionFragment.ugcHomeViewModel;
                    if (ugcTrendingHomeViewModel != null) {
                        ugcTrendingHomeViewModel.i();
                    }
                } else {
                    subscriptionFragment.V0();
                }
                t tVar2 = (t) subscriptionFragment.getMViewBinding();
                if (tVar2 != null && (recyclerView = tVar2.c) != null) {
                    recyclerView.setAdapter(subscriptionFragment.sFeedTrendingAdapter);
                }
            }
            subscriptionFragment.isLoginRefresh = false;
        }
        return Unit.a;
    }

    private final void C0(UGCVideo item, final int bottomFragmentIndex) {
        if (item != null) {
            hu.b.a(item, new Function1() { // from class: mp.j
                public final Object invoke(Object obj) {
                    Navigator D0;
                    D0 = SubscriptionFragment.D0(bottomFragmentIndex, (Navigator) obj);
                    return D0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Navigator D0(int i, Navigator navigator) {
        Intrinsics.h(navigator, "navigator");
        return navigator.F("ugc_bottom_fragment_selected", i);
    }

    private final void E0() {
        RecyclerView recyclerView;
        if (this.mExposureHelper == null) {
            bj.b bVar = new bj.b(0.6f, new b(), false, 4, null);
            t tVar = (t) getMViewBinding();
            if (tVar != null && (recyclerView = tVar.c) != null) {
                recyclerView.addOnScrollListener(bVar);
            }
            this.mExposureHelper = bVar;
        }
    }

    private final com.transsion.room.sub.adapter.subscription.c F0() {
        a.a.f(wf.a.a, "SubscriptionFragment", "initFeedAdapter", false, 4, (Object) null);
        com.transsion.room.sub.adapter.subscription.c cVar = new com.transsion.room.sub.adapter.subscription.c(new ArrayList(), this.mExposureHelper, false);
        cVar.h0().z(true);
        cVar.h0().y(true);
        cVar.h0().E(2);
        cVar.h0().C(new SubscriptionLoadMoreView());
        cVar.h0().D(new f() { // from class: mp.i
            public final void a() {
                SubscriptionFragment.G0(SubscriptionFragment.this);
            }
        });
        this.sFeedAdapter = cVar;
        cVar.Q1(this);
        return this.sFeedAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(final SubscriptionFragment subscriptionFragment) {
        RecyclerView recyclerView;
        a.a aVar = wf.a.a;
        a.a.f(aVar, "SubscriptionFragment", "initSubscriptionListAdapter: trigger", false, 4, (Object) null);
        if (!l.a.e()) {
            a.a.x(aVar, "SubscriptionFragment", "initSubscriptionListAdapter: no network, load more failed", false, 4, (Object) null);
            t tVar = (t) subscriptionFragment.getMViewBinding();
            if (tVar == null || (recyclerView = tVar.c) == null) {
                return;
            }
            recyclerView.postDelayed(new Runnable() { // from class: mp.b
                @Override // java.lang.Runnable
                public final void run() {
                    SubscriptionFragment.H0(SubscriptionFragment.this);
                }
            }, 300L);
            return;
        }
        a.a.f(aVar, "SubscriptionFragment", "initSubscriptionListAdapter: trigger load more", false, 4, (Object) null);
        String str = subscriptionFragment.cursorFeed;
        StringBuilder sb = new StringBuilder();
        sb.append("sub observe cursorFeed : ");
        sb.append(str);
        SubscriptionFeedListViewModel subscriptionFeedListViewModel = subscriptionFragment.feedListViewModel;
        if (subscriptionFeedListViewModel != null) {
            subscriptionFeedListViewModel.h(subscriptionFragment.cursorFeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(SubscriptionFragment subscriptionFragment) {
        t6.f h0;
        com.transsion.room.sub.adapter.subscription.c cVar = subscriptionFragment.sFeedAdapter;
        if (cVar == null || (h0 = cVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    private final void I0() {
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        a.a.f(wf.a.a, "Subscription", "initFeedListRecyclerView", false, 4, (Object) null);
        t tVar = (t) getMViewBinding();
        if (tVar != null && (swipeRefreshLayout = tVar.d) != null) {
            swipeRefreshLayout.setEnabled(true);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: mp.e
                public final void a() {
                    SubscriptionFragment.J0(SubscriptionFragment.this);
                }
            });
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        linearLayoutManager.setInitialPrefetchItemCount(2);
        E0();
        K0();
        bj.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.f();
        }
        bj.b bVar2 = this.mExposureRecommendHelper;
        if (bVar2 != null) {
            bVar2.f();
        }
        t tVar2 = (t) getMViewBinding();
        if (tVar2 != null && (recyclerView = tVar2.c) != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        this.sFeedAdapter = F0();
        this.sFeedTrendingAdapter = N0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(SubscriptionFragment subscriptionFragment) {
        a.a aVar = wf.a.a;
        a.a.f(aVar, "SubscriptionFragment", "initRecyclerView: user pull to refresh", false, 4, (Object) null);
        if (!subscriptionFragment.hasFollowings) {
            a.a.f(aVar, "SubscriptionFragment", "initRecyclerView: user pull to refresh 没有关注", false, 4, (Object) null);
            subscriptionFragment.Y0();
            return;
        }
        a.a.f(aVar, "SubscriptionFragment", "initRecyclerView: user pull to refresh 关注", false, 4, (Object) null);
        SubscriptionFeedListViewModel subscriptionFeedListViewModel = subscriptionFragment.feedListViewModel;
        if (subscriptionFeedListViewModel != null) {
            subscriptionFeedListViewModel.i();
        }
    }

    private final void K0() {
        RecyclerView recyclerView;
        if (this.mExposureRecommendHelper == null) {
            bj.b bVar = new bj.b(0.6f, new c(), false, 4, null);
            t tVar = (t) getMViewBinding();
            if (tVar != null && (recyclerView = tVar.c) != null) {
                recyclerView.addOnScrollListener(bVar);
            }
            this.mExposureRecommendHelper = bVar;
        }
    }

    private final void L0() {
        b0 e2;
        SubscriptionFeedListViewModel subscriptionFeedListViewModel = this.feedListViewModel;
        if (subscriptionFeedListViewModel == null || (e2 = subscriptionFeedListViewModel.e()) == null) {
            return;
        }
        e2.j(this, new e(new Function1() { // from class: mp.f
            public final Object invoke(Object obj) {
                Unit M0;
                M0 = SubscriptionFragment.M0(SubscriptionFragment.this, (SubscriptionFeedBean) obj);
                return M0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(SubscriptionFragment subscriptionFragment, SubscriptionFeedBean subscriptionFeedBean) {
        List<UGCVideo> feedItems;
        t6.f h0;
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        List<UGCVideo> feedItems2;
        List data;
        t tVar;
        RecyclerView recyclerView3;
        List data2;
        t6.f h02;
        List data3;
        t6.f h03;
        t6.f h04;
        subscriptionFragment.y0();
        subscriptionFragment.showContentView();
        a.a aVar = wf.a.a;
        a.a.f(aVar, "SubscriptionFragment", "sub observe start", false, 4, (Object) null);
        subscriptionFragment.hasMoreFeedData = subscriptionFeedBean != null ? Boolean.valueOf(subscriptionFeedBean.getHasMore()) : null;
        subscriptionFragment.cursorFeed = subscriptionFeedBean != null ? subscriptionFeedBean.getNextCursor() : null;
        SubscriptionFeedListViewModel subscriptionFeedListViewModel = subscriptionFragment.feedListViewModel;
        Boolean valueOf = subscriptionFeedListViewModel != null ? Boolean.valueOf(subscriptionFeedListViewModel.g()) : null;
        a.a.f(aVar, "SubscriptionFragment", "hasMoreFeedData " + subscriptionFragment.hasMoreFeedData, false, 4, (Object) null);
        com.transsion.room.sub.adapter.subscription.c cVar = subscriptionFragment.sFeedAdapter;
        if (cVar != null && (h03 = cVar.h0()) != null && h03.r()) {
            a.a.f(aVar, "SubscriptionFragment", "sub observe loadMoreComplete", false, 4, (Object) null);
            com.transsion.room.sub.adapter.subscription.c cVar2 = subscriptionFragment.sFeedAdapter;
            if (cVar2 != null && (h04 = cVar2.h0()) != null) {
                h04.s();
            }
        }
        if ((subscriptionFeedBean != null ? subscriptionFeedBean.getFeedItems() : null) != null) {
            List<UGCVideo> feedItems3 = subscriptionFeedBean.getFeedItems();
            Integer valueOf2 = feedItems3 != null ? Integer.valueOf(feedItems3.size()) : null;
            com.transsion.room.sub.adapter.subscription.c cVar3 = subscriptionFragment.sFeedAdapter;
            Integer valueOf3 = (cVar3 == null || (data3 = cVar3.getData()) == null) ? null : Integer.valueOf(data3.size());
            a.a.f(aVar, "SubscriptionFragment", "subscriptionFeedBean: received " + valueOf2 + " items, currentListSize=" + valueOf3 + ", hasMore=" + subscriptionFeedBean.getHasMore(), false, 4, (Object) null);
            Boolean bool = Boolean.TRUE;
            if (!Intrinsics.c(valueOf, bool) && !Intrinsics.c(subscriptionFragment.hasMoreFeedData, bool)) {
                a.a.f(aVar, "SubscriptionFragment", "subscriptionFeedBean: no more data, load more end", false, 4, (Object) null);
                a.a.f(aVar, "SubscriptionFragment", "sub observe loadMoreEnd", false, 4, (Object) null);
                com.transsion.room.sub.adapter.subscription.c cVar4 = subscriptionFragment.sFeedAdapter;
                if (cVar4 != null && (h02 = cVar4.h0()) != null) {
                    t6.f.u(h02, false, 1, (Object) null);
                }
            }
            com.transsion.room.sub.adapter.subscription.c cVar5 = subscriptionFragment.sFeedAdapter;
            if (cVar5 != null && (data2 = cVar5.getData()) != null && data2.isEmpty() && valueOf2 != null && valueOf2.intValue() == 0) {
                a.a.f(aVar, "SubscriptionFragment", "subscriptionFeedBean: empty data", false, 4, (Object) null);
            } else if (valueOf2 != null && valueOf2.intValue() > 0) {
                if (Intrinsics.c(valueOf, bool) && (tVar = (t) subscriptionFragment.getMViewBinding()) != null && (recyclerView3 = tVar.c) != null) {
                    recyclerView3.setAdapter(subscriptionFragment.sFeedAdapter);
                }
                a.a.f(aVar, "SubscriptionFragment", "sub observe updateData", false, 4, (Object) null);
                subscriptionFragment.Z0(subscriptionFeedBean.getFeedItems());
                qi.b logViewConfig = subscriptionFragment.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.k(true);
                }
            }
        }
        com.transsion.room.sub.adapter.subscription.c cVar6 = subscriptionFragment.sFeedAdapter;
        if ((cVar6 == null || (data = cVar6.getData()) == null || data.size() != 0) && !Intrinsics.c(valueOf, Boolean.TRUE)) {
            a.a.f(aVar, "loadMoreModule", "hasMoreFeedData " + subscriptionFragment.hasMoreFeedData, false, 4, (Object) null);
            if ((subscriptionFeedBean != null ? subscriptionFeedBean.getFeedItems() : null) != null && (((feedItems = subscriptionFeedBean.getFeedItems()) == null || feedItems.size() != 0) && Intrinsics.c(subscriptionFragment.hasMoreFeedData, Boolean.FALSE))) {
                a.a.f(aVar, "loadMoreModule", "subscriptionFeedBean: no more data, load more end", false, 4, (Object) null);
                com.transsion.room.sub.adapter.subscription.c cVar7 = subscriptionFragment.sFeedAdapter;
                if (cVar7 != null && (h0 = cVar7.h0()) != null) {
                    t6.f.u(h0, false, 1, (Object) null);
                }
            }
        } else {
            if ((subscriptionFeedBean != null ? subscriptionFeedBean.getFeedItems() : null) == null || ((feedItems2 = subscriptionFeedBean.getFeedItems()) != null && feedItems2.size() == 0)) {
                Boolean bool2 = subscriptionFragment.hasMoreFeedData;
                Boolean bool3 = Boolean.FALSE;
                if (Intrinsics.c(bool2, bool3)) {
                    Boolean bool4 = subscriptionFragment.isFirstFeedDataRequest;
                    Boolean bool5 = Boolean.TRUE;
                    if (Intrinsics.c(bool4, bool5) && !Intrinsics.c(valueOf, bool5)) {
                        a.a.f(aVar, "SubscriptionFragment", "sub observe loadUgcTrendingHomeData", false, 4, (Object) null);
                        a.a.f(aVar, "SubscriptionFragment", "发送推荐接口的请求", false, 4, (Object) null);
                        subscriptionFragment.hasFollowings = false;
                        subscriptionFragment.V0();
                        subscriptionFragment.isFirstFeedDataRequest = bool3;
                        t tVar2 = (t) subscriptionFragment.getMViewBinding();
                        if (tVar2 != null && (recyclerView2 = tVar2.c) != null) {
                            recyclerView2.setAdapter(subscriptionFragment.sFeedTrendingAdapter);
                        }
                    } else if (Intrinsics.c(subscriptionFragment.isFirstFeedDataRequest, bool3) && Intrinsics.c(valueOf, bool5)) {
                        a.a.f(aVar, "SubscriptionFragment", "sub observe UgcTrending refresh", false, 4, (Object) null);
                        subscriptionFragment.hasFollowings = false;
                        UgcTrendingHomeViewModel ugcTrendingHomeViewModel = subscriptionFragment.ugcHomeViewModel;
                        if (ugcTrendingHomeViewModel != null) {
                            ugcTrendingHomeViewModel.i();
                        }
                        t tVar3 = (t) subscriptionFragment.getMViewBinding();
                        if (tVar3 != null && (recyclerView = tVar3.c) != null) {
                            recyclerView.setAdapter(subscriptionFragment.sFeedTrendingAdapter);
                        }
                    }
                }
            }
            a.a.f(aVar, "SubscriptionFragment", "订阅请求有数据，不发送推荐接口的请求", false, 4, (Object) null);
        }
        subscriptionFragment.isLoading = false;
        t tVar4 = (t) subscriptionFragment.getMViewBinding();
        if (tVar4 != null && (swipeRefreshLayout = tVar4.d) != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        return Unit.a;
    }

    private final k N0() {
        k kVar = new k(new ArrayList(), this.mExposureRecommendHelper, false);
        kVar.h0().z(true);
        kVar.h0().y(true);
        kVar.h0().E(2);
        kVar.h0().C(new SubscriptionLoadMoreView());
        kVar.h0().D(new f() { // from class: mp.h
            public final void a() {
                SubscriptionFragment.O0(SubscriptionFragment.this);
            }
        });
        this.sFeedTrendingAdapter = kVar;
        kVar.Q1(this);
        return this.sFeedTrendingAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(final SubscriptionFragment subscriptionFragment) {
        RecyclerView recyclerView;
        a.a aVar = wf.a.a;
        a.a.f(aVar, "SubscriptionFragment", "initSubscriptionListAdapter: trigger ", false, 4, (Object) null);
        if (!l.a.e()) {
            a.a.x(aVar, "SubscriptionFragment", "initSubscriptionListAdapter: no network, load more failed", false, 4, (Object) null);
            t tVar = (t) subscriptionFragment.getMViewBinding();
            if (tVar == null || (recyclerView = tVar.c) == null) {
                return;
            }
            recyclerView.postDelayed(new Runnable() { // from class: mp.c
                @Override // java.lang.Runnable
                public final void run() {
                    SubscriptionFragment.P0(SubscriptionFragment.this);
                }
            }, 300L);
            return;
        }
        a.a.f(aVar, "SubscriptionFragment", "initSubscriptionListAdapter: trigger load more", false, 4, (Object) null);
        String str = subscriptionFragment.pageNext;
        Integer valueOf = str != null ? Integer.valueOf(Integer.parseInt(str)) : null;
        UgcTrendingHomeViewModel ugcTrendingHomeViewModel = subscriptionFragment.ugcHomeViewModel;
        if (ugcTrendingHomeViewModel != null) {
            ugcTrendingHomeViewModel.h(valueOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(SubscriptionFragment subscriptionFragment) {
        t6.f h0;
        k kVar = subscriptionFragment.sFeedTrendingAdapter;
        if (kVar == null || (h0 = kVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    private final void Q0() {
        b0 f;
        UgcTrendingHomeViewModel ugcTrendingHomeViewModel = this.ugcHomeViewModel;
        if (ugcTrendingHomeViewModel == null || (f = ugcTrendingHomeViewModel.f()) == null) {
            return;
        }
        f.j(this, new e(new Function1() { // from class: mp.g
            public final Object invoke(Object obj) {
                Unit R0;
                R0 = SubscriptionFragment.R0(SubscriptionFragment.this, (UgcTrendingHomeBean) obj);
                return R0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(SubscriptionFragment subscriptionFragment, UgcTrendingHomeBean ugcTrendingHomeBean) {
        t6.f h0;
        SwipeRefreshLayout swipeRefreshLayout;
        List data;
        t6.f h02;
        List data2;
        t6.f h03;
        t6.f h04;
        List<ItemTrending> items;
        PagerTrending pager;
        PagerTrending pager2;
        subscriptionFragment.y0();
        UgcTrendingHomeViewModel ugcTrendingHomeViewModel = subscriptionFragment.ugcHomeViewModel;
        if (ugcTrendingHomeViewModel != null) {
            ugcTrendingHomeViewModel.g();
        }
        subscriptionFragment.showContentView();
        a.a aVar = wf.a.a;
        a.a.f(aVar, "SubscriptionFragment", "recommend observe loadUgcTrendingHomeData", false, 4, (Object) null);
        subscriptionFragment.hasMoreUgcHomeData = (ugcTrendingHomeBean == null || (pager2 = ugcTrendingHomeBean.getPager()) == null) ? null : Boolean.valueOf(pager2.getHasMore());
        subscriptionFragment.pageNext = (ugcTrendingHomeBean == null || (pager = ugcTrendingHomeBean.getPager()) == null) ? null : pager.getNextPage();
        if (ugcTrendingHomeBean != null && (items = ugcTrendingHomeBean.getItems()) != null) {
            items.size();
        }
        a.a.f(aVar, "SubscriptionFragment", "pageNext : " + subscriptionFragment.pageNext, false, 4, (Object) null);
        a.a.f(aVar, "SubscriptionFragment", "hasMoreUgcHomeData " + subscriptionFragment.hasMoreUgcHomeData, false, 4, (Object) null);
        k kVar = subscriptionFragment.sFeedTrendingAdapter;
        if (kVar != null && (h03 = kVar.h0()) != null && h03.r()) {
            k kVar2 = subscriptionFragment.sFeedTrendingAdapter;
            if (kVar2 != null && (h04 = kVar2.h0()) != null) {
                h04.s();
            }
            a.a.f(aVar, "SubscriptionFragment", "recommend observe loadMoreComplete", false, 4, (Object) null);
        }
        if ((ugcTrendingHomeBean != null ? ugcTrendingHomeBean.getItems() : null) != null) {
            List<ItemTrending> items2 = ugcTrendingHomeBean.getItems();
            Integer valueOf = items2 != null ? Integer.valueOf(items2.size()) : null;
            com.transsion.room.sub.adapter.subscription.c cVar = subscriptionFragment.sFeedAdapter;
            Integer valueOf2 = (cVar == null || (data2 = cVar.getData()) == null) ? null : Integer.valueOf(data2.size());
            a.a.f(aVar, "SubscriptionFragment", "ugcTrendingHomeData: received " + valueOf + " items, currentListSize=" + valueOf2 + ", hasMore=" + ugcTrendingHomeBean.getPager().getHasMore(), false, 4, (Object) null);
            if (!Intrinsics.c(subscriptionFragment.hasMoreUgcHomeData, Boolean.TRUE)) {
                a.a.f(aVar, "SubscriptionFragment", "ugcTrendingHomeData: no more data, load more end", false, 4, (Object) null);
                k kVar3 = subscriptionFragment.sFeedTrendingAdapter;
                if (kVar3 != null && (h02 = kVar3.h0()) != null) {
                    t6.f.u(h02, false, 1, (Object) null);
                }
                a.a.f(aVar, "SubscriptionFragment", "recommend observe loadMoreEnd", false, 4, (Object) null);
            }
            k kVar4 = subscriptionFragment.sFeedTrendingAdapter;
            if (kVar4 == null || (data = kVar4.getData()) == null || !data.isEmpty() || valueOf == null || valueOf.intValue() != 0) {
                k kVar5 = subscriptionFragment.sFeedTrendingAdapter;
                if (kVar5 != null && (h0 = kVar5.h0()) != null) {
                    h0.s();
                }
                a.a.f(aVar, "SubscriptionFragment", "recommend observe loadMoreComplete", false, 4, (Object) null);
                List<ItemTrending> items3 = ugcTrendingHomeBean.getItems();
                Intrinsics.e(items3);
                subscriptionFragment.a1(items3);
                qi.b logViewConfig = subscriptionFragment.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.k(true);
                }
            } else {
                a.a.f(aVar, "SubscriptionFragment", "subscriptionFeedBean: empty data", false, 4, (Object) null);
                a.a.f(aVar, "SubscriptionFragment", "recommend observe setEmptyView", false, 4, (Object) null);
                k kVar6 = subscriptionFragment.sFeedTrendingAdapter;
                if (kVar6 != null) {
                    kVar6.Y0(subscriptionFragment.getEmptyView(false));
                }
            }
            t tVar = (t) subscriptionFragment.getMViewBinding();
            if (tVar != null && (swipeRefreshLayout = tVar.d) != null) {
                swipeRefreshLayout.setRefreshing(false);
            }
        }
        return Unit.a;
    }

    /* renamed from: S0, reason: from getter */
    private final boolean getIsSelf() {
        return this.isSelf;
    }

    private final void T0() {
        ConstraintLayout root;
        a.a.f(wf.a.a, "Subscription", "loadFeedData", false, 4, (Object) null);
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        SubscriptionFeedListViewModel subscriptionFeedListViewModel = this.feedListViewModel;
        if (subscriptionFeedListViewModel != null) {
            subscriptionFeedListViewModel.f(BuildConfig.FLAVOR);
        }
        t tVar = (t) getMViewBinding();
        if (tVar == null || (root = tVar.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: mp.l
            @Override // java.lang.Runnable
            public final void run() {
                SubscriptionFragment.U0(SubscriptionFragment.this);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(SubscriptionFragment subscriptionFragment) {
        SwipeRefreshLayout swipeRefreshLayout;
        t tVar = (t) subscriptionFragment.getMViewBinding();
        if (tVar == null || (swipeRefreshLayout = tVar.d) == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void V0() {
        ConstraintLayout root;
        a.a.f(wf.a.a, "SubscriptionFragment", "loadUgcTrendingHomeData", false, 4, (Object) null);
        if (this.isUgcTrendingHomeLoading) {
            return;
        }
        this.isUgcTrendingHomeLoading = true;
        UgcTrendingHomeViewModel ugcTrendingHomeViewModel = this.ugcHomeViewModel;
        if (ugcTrendingHomeViewModel != null) {
            ugcTrendingHomeViewModel.e(1, this.mCurrentTab.getApiValue());
        }
        t tVar = (t) getMViewBinding();
        if (tVar == null || (root = tVar.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: mp.k
            @Override // java.lang.Runnable
            public final void run() {
                SubscriptionFragment.W0(SubscriptionFragment.this);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(SubscriptionFragment subscriptionFragment) {
        SwipeRefreshLayout swipeRefreshLayout;
        t tVar = (t) subscriptionFragment.getMViewBinding();
        if (tVar == null || (swipeRefreshLayout = tVar.d) == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a X0() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    private final void Y0() {
        this.isLoginRefresh = true;
        qx.a loginApi = getLoginApi();
        UserInfo i = loginApi != null ? loginApi.i() : null;
        String userId = i != null ? i.getUserId() : null;
        SubscriptionViewModel subscriptionViewModel = this.viewModel;
        if (subscriptionViewModel != null) {
            subscriptionViewModel.e(String.valueOf(userId));
        }
    }

    private final void Z0(List feedItems) {
        List data;
        List data2;
        com.transsion.room.sub.adapter.subscription.c cVar = this.sFeedAdapter;
        int i = 0;
        int size = (cVar == null || (data2 = cVar.getData()) == null) ? 0 : data2.size();
        SubscriptionFeedListViewModel subscriptionFeedListViewModel = this.feedListViewModel;
        if (Intrinsics.c(subscriptionFeedListViewModel != null ? Boolean.valueOf(subscriptionFeedListViewModel.g()) : null, Boolean.TRUE) || size == 0) {
            com.transsion.room.sub.adapter.subscription.c cVar2 = this.sFeedAdapter;
            if (cVar2 != null) {
                cVar2.n1(feedItems);
            }
            a.a.f(wf.a.a, "SubscriptionFragment", "updateData: refresh or first load, replace data. size: " + size + " -> " + (feedItems != null ? Integer.valueOf(feedItems.size()) : null), false, 4, (Object) null);
            return;
        }
        com.transsion.room.sub.adapter.subscription.c cVar3 = this.sFeedAdapter;
        if (cVar3 != null) {
            Intrinsics.e(feedItems);
            cVar3.q(feedItems);
        }
        com.transsion.room.sub.adapter.subscription.c cVar4 = this.sFeedAdapter;
        if (cVar4 != null && (data = cVar4.getData()) != null) {
            i = data.size();
        }
        a.a.f(wf.a.a, "SubscriptionFragment", "updateData: load more, add " + (feedItems != null ? Integer.valueOf(feedItems.size()) : null) + " items, list size: " + size + " -> " + i, false, 4, (Object) null);
    }

    private final void a1(List feedItems) {
        List data;
        List data2;
        k kVar = this.sFeedTrendingAdapter;
        int i = 0;
        int size = (kVar == null || (data2 = kVar.getData()) == null) ? 0 : data2.size();
        UgcTrendingHomeViewModel ugcTrendingHomeViewModel = this.ugcHomeViewModel;
        if (!Intrinsics.c(ugcTrendingHomeViewModel != null ? Boolean.valueOf(ugcTrendingHomeViewModel.g()) : null, Boolean.TRUE) && size != 0) {
            k kVar2 = this.sFeedTrendingAdapter;
            if (kVar2 != null) {
                kVar2.q(feedItems);
            }
            k kVar3 = this.sFeedTrendingAdapter;
            if (kVar3 != null && (data = kVar3.getData()) != null) {
                i = data.size();
            }
            a.a.f(wf.a.a, "SubscriptionFragment", "updateData: load more, add " + feedItems.size() + " items, list size: " + size + " -> " + i, false, 4, (Object) null);
            return;
        }
        k kVar4 = this.sFeedTrendingAdapter;
        if (kVar4 == null) {
            a.a.f(wf.a.a, "SubscriptionFragment", "FeedTrendingAdapter ==null", false, 4, (Object) null);
        } else {
            a.a.f(wf.a.a, "SubscriptionFragment", "FeedTrendingAdapter ==" + kVar4, false, 4, (Object) null);
        }
        k kVar5 = this.sFeedTrendingAdapter;
        if (kVar5 != null) {
            kVar5.n1(feedItems);
        }
        a.a.f(wf.a.a, "SubscriptionFragment", "updateData: refresh or first load, replace data. size: " + size + " -> " + (feedItems != null ? Integer.valueOf(feedItems.size()) : null), false, 4, (Object) null);
    }

    private final qx.a getLoginApi() {
        return (qx.a) this.loginApi.getValue();
    }

    private final void y0() {
        HashMap g;
        if (this.firstLoadStartTimeMillis > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.firstLoadStartTimeMillis;
            qi.b logViewConfig = getLogViewConfig();
            if (logViewConfig == null || (g = logViewConfig.g()) == null) {
                return;
            }
        }
    }

    private final void z0(String userId) {
        b0 d2;
        showLoadingView();
        a.a.f(wf.a.a, "SubscriptionFragment", "checkHasFollowings阶段", false, 4, (Object) null);
        SubscriptionViewModel subscriptionViewModel = this.viewModel;
        if (subscriptionViewModel != null && (d2 = subscriptionViewModel.d()) != null) {
            d2.j(this, new e(new Function1() { // from class: mp.d
                public final Object invoke(Object obj) {
                    Unit A0;
                    A0 = SubscriptionFragment.A0(SubscriptionFragment.this, (SubscriptionStatsBean) obj);
                    return A0;
                }
            }));
        }
        SubscriptionViewModel subscriptionViewModel2 = this.viewModel;
        if (subscriptionViewModel2 != null) {
            subscriptionViewModel2.e(String.valueOf(userId));
        }
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public t getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.viewModel = new v0(activity).a(SubscriptionViewModel.class);
            this.feedListViewModel = new v0(activity).a(SubscriptionFeedListViewModel.class);
            this.ugcLikesViewModel = new v0(activity).a(UgcLikesViewModel.class);
            this.subUnsubViewModel = new v0(activity).a(com.transsion.room.sub.viewmodel.subscription.a.class);
            this.ugcHomeViewModel = new v0(activity).a(UgcTrendingHomeViewModel.class);
        }
        t c2 = t.c(getLayoutInflater());
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    @Override // com.transsion.room.sub.adapter.subscription.a
    public void E(UGCVideo item) {
        a.a.f(wf.a.a, "SubscriptionFragment", "onClickVideoTrendingDetailItem", false, 4, (Object) null);
        if (item != null) {
            hu.b.b(item, (Function1) null, 1, (Object) null);
        }
    }

    @Override // com.transsion.room.sub.adapter.subscription.a
    public void I(String ugcVideoId, String title) {
        ShareDialogFragment a;
        Fragment parentFragment;
        FragmentManager childFragmentManager;
        a.a.f(wf.a.a, "SubscriptionFragment", "onClickShareItem", false, 4, (Object) null);
        if (this.shareDialog == null) {
            qx.a loginApi = getLoginApi();
            UserInfo i = loginApi != null ? loginApi.i() : null;
            a = ShareDialogFragment.INSTANCE.a(PostType.UGC_VIDEO, ugcVideoId, i != null ? i.getUserId() : null, ReportType.UFC_VIDEO.getValue(), (r29 & 16) != 0 ? BuildConfig.FLAVOR : title, (r29 & 32) != 0 ? BuildConfig.FLAVOR : null, (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : false, (r29 & 256) != 0 ? false : false, "UGCVideoDetail", (r29 & 1024) != 0 ? BuildConfig.FLAVOR : title, (r29 & 2048) != 0 ? BuildConfig.FLAVOR : null);
            this.shareDialog = a;
            if (a != null) {
                a.G0(new d());
            }
            try {
                Fragment parentFragment2 = getParentFragment();
                if (parentFragment2 != null && parentFragment2.isAdded() && (parentFragment = getParentFragment()) != null && (childFragmentManager = parentFragment.getChildFragmentManager()) != null) {
                    childFragmentManager.g0();
                    ShareDialogFragment shareDialogFragment = this.shareDialog;
                    if ((shareDialogFragment != null && shareDialogFragment.isAdded()) || childFragmentManager.k0("share") != null) {
                        return;
                    }
                    ShareDialogFragment shareDialogFragment2 = this.shareDialog;
                    if (shareDialogFragment2 != null) {
                        shareDialogFragment2.show(childFragmentManager, "share");
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.shareDialog = null;
    }

    @Override // com.transsion.room.sub.adapter.subscription.a
    public void a(UGCVideo item) {
        Intrinsics.h(item, "item");
        hu.b.b(item, (Function1) null, 1, (Object) null);
    }

    @Override // com.transsion.room.sub.adapter.subscription.a
    public void b(String userId) {
        a.a.f(wf.a.a, "SubscriptionFragment", "userId111 ：" + userId, false, 4, (Object) null);
        Navigator.x(TheRouter.c("/profile/user_profile").K("userId", userId), requireContext(), (mf.c) null, 2, (Object) null);
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initViewData() {
        boolean z;
        qi.b logViewConfig;
        HashMap g;
        UserInfo i;
        this.firstLoadStartTimeMillis = System.currentTimeMillis();
        qx.a loginApi = getLoginApi();
        String str = null;
        UserInfo i2 = loginApi != null ? loginApi.i() : null;
        String userId = i2 != null ? i2.getUserId() : null;
        if (userId != null && userId.length() != 0) {
            String userId2 = i2 != null ? i2.getUserId() : null;
            qx.a loginApi2 = getLoginApi();
            if (loginApi2 != null && (i = loginApi2.i()) != null) {
                str = i.getUserId();
            }
            if (!Intrinsics.c(userId2, str)) {
                z = false;
                this.isSelf = z;
                if (getIsSelf()) {
                    a.a.f(wf.a.a, "SubscriptionFragment", "isSelf : false", false, 4, (Object) null);
                } else {
                    a.a.f(wf.a.a, "SubscriptionFragment", "isSelf : true", false, 4, (Object) null);
                    qx.a loginApi3 = getLoginApi();
                    if (loginApi3 != null) {
                        loginApi3.e(this);
                    }
                }
                I0();
                if (this.pageFrom.length() == 0) {
                    this.pageFrom = h.a.h();
                }
                logViewConfig = getLogViewConfig();
                if (logViewConfig != null || (g = logViewConfig.g()) == null) {
                }
                return;
            }
        }
        z = true;
        this.isSelf = z;
        if (getIsSelf()) {
        }
        I0();
        if (this.pageFrom.length() == 0) {
        }
        logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
        }
    }

    public void initViewModel() {
        L0();
        Q0();
    }

    public void loadDefaultData() {
        a.a.f(wf.a.a, "SubscriptionFragment", "loadDefaultData阶段", false, 4, (Object) null);
        qx.a loginApi = getLoginApi();
        UserInfo i = loginApi != null ? loginApi.i() : null;
        z0(i != null ? i.getUserId() : null);
    }

    public void logPause() {
        super.logPause();
        if (this.resumeTimeStamp != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.resumeTimeStamp;
            a.a.r(wf.a.a, "Report", new String[]{"Subscription fb log duration:" + elapsedRealtime}, false, 4, (Object) null);
            com.transsion.baselib.report.e.a.n("Subscription", Long.valueOf(elapsedRealtime), getContext());
        }
    }

    public void logResume() {
        super.logResume();
        this.resumeTimeStamp = SystemClock.elapsedRealtime();
    }

    public qi.b newLogViewConfig() {
        return new qi.b("/subscription/subscription", false, 2, null);
    }

    public void onDestroy() {
        super.onDestroy();
        qx.a loginApi = getLoginApi();
        if (loginApi != null) {
            loginApi.j(this);
        }
    }

    public void onHiddenChanged(boolean hidden) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                logResume();
            }
        }
    }

    public void onLogin(UserInfo user) {
        Intrinsics.h(user, "user");
        b.a.a(this, user);
        a.a.f(wf.a.a, "SubscriptionFragment", "onLogin阶段", false, 4, (Object) null);
        Y0();
    }

    public void onLogout() {
        b.a.b(this);
        a.a.f(wf.a.a, "SubscriptionFragment", "onLogout阶段", false, 4, (Object) null);
        Y0();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onUpdateUserInfo(UserInfo user) {
        Intrinsics.h(user, "user");
        a.a.f(wf.a.a, "SubscriptionFragment", "onUpdateUserInfo阶段", false, 4, (Object) null);
    }

    public void retryLoadData() {
        a.a.f(wf.a.a, "SubscriptionFragment", "retryLoadData阶段", false, 4, (Object) null);
        qx.a loginApi = getLoginApi();
        UserInfo i = loginApi != null ? loginApi.i() : null;
        z0(i != null ? i.getUserId() : null);
    }

    @Override // com.transsion.room.sub.adapter.subscription.a
    public void t(UGCVideo item) {
        a.a.f(wf.a.a, "SubscriptionFragment", "onClickCommentReply", false, 4, (Object) null);
        C0(item, 1);
    }

    @Override // com.transsion.room.sub.adapter.subscription.a
    public void w(boolean isLike, String ugcVideoId) {
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        a.a.f(wf.a.a, "SubscriptionFragment", "onClickCommentLike", false, 4, (Object) null);
        UgcLikesViewModel ugcLikesViewModel = this.ugcLikesViewModel;
        if (ugcLikesViewModel != null) {
            ugcLikesViewModel.j(ugcVideoId, isLike);
        }
    }
}
