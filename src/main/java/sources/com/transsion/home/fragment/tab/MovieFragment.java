package com.transsion.home.fragment.tab;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.google.android.material.tabs.TabLayout;
import com.therouter.TheRouter;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.NoNetworkBigView;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.flow.bean.PlayUrl;
import com.transsion.flow.bean.SubjectGameInfo;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.Channel;
import com.transsion.home.bean.FilterItems;
import com.transsion.home.bean.Item;
import com.transsion.home.bean.LayoutStyle;
import com.transsion.home.bean.MovieBean;
import com.transsion.home.bean.MovieItem;
import com.transsion.home.bean.RefreshBaseDto;
import com.transsion.home.fragment.home.HomeFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.home.view.filter.popup.PopupFilterView;
import com.transsion.home.view.layoutmanager.OffsetGridLayoutManager;
import com.transsion.home.viewmodel.MovieViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectDl;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.push.PushConstants;
import com.transsion.push.bean.MsgStyle;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.json.JSONObject;
import wf.a;
import yg.m;

@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 ª\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002«\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J!\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J7\u0010\u001e\u001a\u00020\u00052&\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u0004J\u0019\u0010#\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b#\u0010$J#\u0010'\u001a\u00020\u00052\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0%H\u0002¢\u0006\u0004\b'\u0010(J7\u0010+\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010%2\u0006\u0010*\u001a\u00020\u0016H\u0002¢\u0006\u0004\b+\u0010,J!\u0010/\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010*\u001a\u00020\u0016H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0005H\u0002¢\u0006\u0004\b1\u0010\u0004J\u000f\u00102\u001a\u00020\u0005H\u0002¢\u0006\u0004\b2\u0010\u0004J\u0019\u00104\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b4\u0010$J\u0019\u00105\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b5\u0010$J\u000f\u00106\u001a\u00020\u0005H\u0002¢\u0006\u0004\b6\u0010\u0004J\u000f\u00107\u001a\u00020\u0012H\u0002¢\u0006\u0004\b7\u00108J\u001b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0012H\u0002¢\u0006\u0004\b<\u00108J\u0017\u0010>\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0016H\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0005H\u0002¢\u0006\u0004\b@\u0010\u0004J\u000f\u0010A\u001a\u00020\tH\u0002¢\u0006\u0004\bA\u0010\u000bJ\u0017\u0010D\u001a\u00020\u00022\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bD\u0010EJ\u0019\u0010H\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0004\bH\u0010IJ!\u0010L\u001a\u00020\u00052\u0006\u0010K\u001a\u00020J2\b\u0010G\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\u0005H\u0016¢\u0006\u0004\bN\u0010\u0004J\u0017\u0010Q\u001a\u00020\u00052\u0006\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bQ\u0010RJ\u0019\u0010U\u001a\u00020\u0005*\u00020S2\u0006\u0010T\u001a\u00020\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u0005H\u0016¢\u0006\u0004\bW\u0010\u0004J\u000f\u0010X\u001a\u00020\u0005H\u0016¢\u0006\u0004\bX\u0010\u0004J\u000f\u0010Y\u001a\u00020\u0005H\u0016¢\u0006\u0004\bY\u0010\u0004J\u000f\u0010Z\u001a\u00020\u0005H\u0016¢\u0006\u0004\bZ\u0010\u0004J\u0017\u0010\\\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\\\u0010?J\u000f\u0010]\u001a\u00020\u0005H\u0016¢\u0006\u0004\b]\u0010\u0004J\u000f\u0010_\u001a\u00020^H\u0016¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\u0005H\u0016¢\u0006\u0004\ba\u0010\u0004J\u0017\u0010d\u001a\u00020\t2\b\u0010c\u001a\u0004\u0018\u00010b¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020\tH\u0016¢\u0006\u0004\bf\u0010\u000bJ\u000f\u0010g\u001a\u00020\u0005H\u0016¢\u0006\u0004\bg\u0010\u0004J\u0011\u0010i\u001a\u0004\u0018\u00010hH\u0016¢\u0006\u0004\bi\u0010jJ\u001f\u0010n\u001a\u00020\u00052\u0006\u0010k\u001a\u00020\u00122\u0006\u0010m\u001a\u00020lH\u0016¢\u0006\u0004\bn\u0010oR\u001d\u0010u\u001a\u0004\u0018\u00010p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010}\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0019\u0010\u0083\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0088\u0001R\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u0088\u0001R\u0019\u0010\u008f\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u0082\u0001Rq\u0010\u0092\u0001\u001aZ\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001c0\u001bj,\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001c`\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u009a\u0001\u001a\u00030\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0019\u0010\u009c\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u0088\u0001R\u001c\u0010 \u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R'\u0010£\u0001\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u001a\u0010¥\u0001\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010\u007fR\u001a\u0010§\u0001\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¦\u0001\u0010\u007fR\u001a\u0010©\u0001\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¨\u0001\u0010\u007f¨\u0006¬\u0001"}, d2 = {"Lcom/transsion/home/fragment/tab/MovieFragment;", "Lcom/transsion/home/fragment/tab/BaseHomeSubFragment;", "Lqk/q;", "<init>", "()V", BuildConfig.FLAVOR, "initScrollListener", "m1", "n1", BuildConfig.FLAVOR, "Z0", "()Ljava/lang/String;", "k1", "channelId", BuildConfig.FLAVOR, "Lcom/transsion/home/bean/Item;", "Y0", "(Ljava/lang/String;)Ljava/util/List;", BuildConfig.FLAVOR, "position", "V0", "(I)V", BuildConfig.FLAVOR, "h1", "()Z", "initViewModel", "A1", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "selectItems", "J1", "(Ljava/util/HashMap;)V", "loadData", "C1", "loadMore", "x1", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "selectedMap", "w1", "(Ljava/util/Map;)V", "selectedItems", "isRefresh", "X0", "(Ljava/lang/String;Ljava/util/Map;Z)V", "Lcom/transsion/home/bean/MovieBean;", "movieBean", "H1", "(Lcom/transsion/home/bean/MovieBean;Z)V", "showLoadingView", "i1", "string", "F1", "W0", "j1", "e1", "()I", "Lcom/transsion/home/bean/LayoutStyle;", "a1", "(Ljava/lang/String;)Lcom/transsion/home/bean/LayoutStyle;", "b1", PushConstants.PUSH_SERVICE_TYPE_SHOW, "z1", "(Z)V", "l1", "d1", "Landroid/view/LayoutInflater;", "inflater", "g1", "(Landroid/view/LayoutInflater;)Lqk/q;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "p0", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lcom/google/android/material/tabs/TabLayout$Tab;", "selected", "B1", "(Lcom/google/android/material/tabs/TabLayout$Tab;Z)V", "lazyLoadData", "startLoading", "hideLoading", "onResume", "hidden", "onHiddenChanged", "onPause", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "onDestroyView", "Lcom/transsion/home/bean/FilterItems;", "filterItems", "f1", "(Lcom/transsion/home/bean/FilterItems;)Ljava/lang/String;", "g0", "c0", "Landroidx/recyclerview/widget/RecyclerView;", "f0", "()Landroidx/recyclerview/widget/RecyclerView;", "lastAdPosition", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "wrapperNativeManager", "l0", "(ILcom/transsion/ad/bidding/nativead/BiddingNativeManager;)V", "Lim/b;", "g", "Lkotlin/Lazy;", "c1", "()Lim/b;", "memberProvider", "Lcom/transsion/home/adapter/a;", "h", "Lcom/transsion/home/adapter/a;", "mAdapter", "Lcom/transsion/home/viewmodel/MovieViewModel;", "i", "Lcom/transsion/home/viewmodel/MovieViewModel;", "mMovieModel", "j", "Landroid/view/View;", "header", "k", "I", "mPage", "l", "Lcom/transsion/home/bean/FilterItems;", "mFilterItems", "m", "Ljava/lang/String;", "mChannelId", "n", "mDeeplinkChannelId", "o", "mFilterJson", "p", "mPerPage", "q", "Ljava/util/HashMap;", "mSubjectTypeMap", "Lcom/transsion/home/view/filter/popup/PopupFilterView;", "r", "Lcom/transsion/home/view/filter/popup/PopupFilterView;", "mFilterView", BuildConfig.FLAVOR, "s", "J", "startShowTime", "t", "mPageFrom", "Lrk/b;", "u", "Lrk/b;", "mExposureHelper", "v", "Ljava/util/Map;", "mLatestSelectItems", "w", "mNoNetworkView", "x", "mLoadingView", "y", "mNoResultView", "z", "a", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MovieFragment extends BaseHomeSubFragment<qk.q> {

    /* renamed from: h, reason: from kotlin metadata */
    private com.transsion.home.adapter.a mAdapter;

    /* renamed from: i, reason: from kotlin metadata */
    private MovieViewModel mMovieModel;

    /* renamed from: j, reason: from kotlin metadata */
    private View header;

    /* renamed from: l, reason: from kotlin metadata */
    private FilterItems mFilterItems;

    /* renamed from: m, reason: from kotlin metadata */
    private String mChannelId;

    /* renamed from: n, reason: from kotlin metadata */
    private String mDeeplinkChannelId;

    /* renamed from: o, reason: from kotlin metadata */
    private String mFilterJson;

    /* renamed from: r, reason: from kotlin metadata */
    private PopupFilterView mFilterView;

    /* renamed from: s, reason: from kotlin metadata */
    private long startShowTime;

    /* renamed from: u, reason: from kotlin metadata */
    private rk.b mExposureHelper;

    /* renamed from: v, reason: from kotlin metadata */
    private Map mLatestSelectItems;

    /* renamed from: w, reason: from kotlin metadata */
    private View mNoNetworkView;

    /* renamed from: x, reason: from kotlin metadata */
    private View mLoadingView;

    /* renamed from: y, reason: from kotlin metadata */
    private View mNoResultView;

    /* renamed from: z, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int A = 8;

    /* renamed from: g, reason: from kotlin metadata */
    private final Lazy memberProvider = LazyKt.b(new Function0() { // from class: com.transsion.home.fragment.tab.p
        public final Object invoke() {
            im.b y1;
            y1 = MovieFragment.y1();
            return y1;
        }
    });

    /* renamed from: k, reason: from kotlin metadata */
    private int mPage = 1;

    /* renamed from: p, reason: from kotlin metadata */
    private int mPerPage = 12;

    /* renamed from: q, reason: from kotlin metadata */
    private HashMap mSubjectTypeMap = new HashMap();

    /* renamed from: t, reason: from kotlin metadata */
    private String mPageFrom = qi.h.a.h();

    /* renamed from: com.transsion.home.fragment.tab.MovieFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MovieFragment b(Companion companion, int i, boolean z, String str, String str2, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            if ((i2 & 4) != 0) {
                str = null;
            }
            if ((i2 & 8) != 0) {
                str2 = BuildConfig.FLAVOR;
            }
            return companion.a(i, z, str, str2);
        }

        public final MovieFragment a(int i, boolean z, String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", i);
            bundle.putString("tab_code", str2);
            bundle.putBoolean("hide_header_bg", z);
            bundle.putString("filter_json", str);
            MovieFragment movieFragment = new MovieFragment();
            movieFragment.setArguments(bundle);
            return movieFragment;
        }
    }

    public static final class b implements TabLayout.OnTabSelectedListener {
        b() {
        }

        public void onTabReselected(TabLayout.Tab tab) {
            a.a.f(wf.a.a, "MovieFragment", "release tab " + (tab != null ? Integer.valueOf(tab.getPosition()) : null), false, 4, (Object) null);
        }

        public void onTabSelected(TabLayout.Tab tab) {
            RecyclerView recyclerView;
            a.a.f(wf.a.a, "MovieFragment", "selected tab " + (tab != null ? Integer.valueOf(tab.getPosition()) : null), false, 4, (Object) null);
            if (tab != null) {
                MovieFragment.this.B1(tab, true);
            }
            MovieFragment.this.startShowTime = SystemClock.elapsedRealtime();
            MovieFragment movieFragment = MovieFragment.this;
            movieFragment.mPageFrom = movieFragment.f1(movieFragment.mFilterItems);
            if (tab == null) {
                return;
            }
            MovieFragment.this.V0(tab.getPosition());
            com.transsion.baselib.helper.a.a.h(MovieFragment.this.mPageFrom, MovieFragment.this.mPageFrom, (r16 & 4) != 0 ? BuildConfig.FLAVOR : null, (r16 & 8) != 0 ? BuildConfig.FLAVOR : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
            rk.b bVar = MovieFragment.this.mExposureHelper;
            if (bVar != null) {
                bVar.e();
            }
            MovieFragment movieFragment2 = MovieFragment.this;
            movieFragment2.x1(movieFragment2.mChannelId);
            MovieFragment movieFragment3 = MovieFragment.this;
            movieFragment3.J1((HashMap) movieFragment3.mSubjectTypeMap.get(MovieFragment.this.mChannelId));
            qk.q qVar = (qk.q) MovieFragment.this.getMViewBinding();
            if (qVar == null || (recyclerView = qVar.c) == null) {
                return;
            }
            recyclerView.scrollToPosition(0);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            if (tab != null) {
                MovieFragment.this.B1(tab, false);
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.a;
            MovieFragment movieFragment = MovieFragment.this;
            aVar.k(movieFragment.f1(movieFragment.mFilterItems), MovieFragment.this.mPageFrom, String.valueOf(elapsedRealtime - MovieFragment.this.startShowTime));
            a.a.f(wf.a.a, "MovieFragment", "unselected tab " + (tab != null ? Integer.valueOf(tab.getPosition()) : null), false, 4, (Object) null);
        }
    }

    public static final class c implements rk.a {
        c() {
        }

        @Override // rk.a
        public void a(int i, long j, View view) {
            List data;
            String str;
            String ops;
            com.transsion.home.adapter.a aVar = MovieFragment.this.mAdapter;
            if (aVar == null || (data = aVar.getData()) == null) {
                return;
            }
            int size = data.size();
            MovieFragment movieFragment = MovieFragment.this;
            if (i >= size) {
                return;
            }
            com.transsion.home.adapter.a aVar2 = movieFragment.mAdapter;
            MovieItem movieItem = aVar2 != null ? (MovieItem) aVar2.getItem(i) : null;
            HashMap hashMap = new HashMap();
            String str2 = BuildConfig.FLAVOR;
            if (movieItem == null || (str = movieItem.getSubjectId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("subject_id", str);
            hashMap.put("has_resource", String.valueOf(movieItem != null ? movieItem.getHasResource() : null));
            hashMap.put("sequence", String.valueOf(i));
            if (movieItem != null && (ops = movieItem.getOps()) != null) {
                str2 = ops;
            }
            hashMap.put("ops", str2);
            hashMap.put("filter_name", movieFragment.Z0());
            hashMap.put("browse_duration", String.valueOf(j));
            com.transsion.baselib.helper.a.a.e(movieFragment.f1(movieFragment.mFilterItems), hashMap);
        }
    }

    public static final class d extends DiffUtil.e {
        d() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(MovieItem movieItem, MovieItem movieItem2) {
            Intrinsics.h(movieItem, "oldItem");
            Intrinsics.h(movieItem2, "newItem");
            return Intrinsics.c(movieItem.getSubjectId(), movieItem2.getSubjectId());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(MovieItem movieItem, MovieItem movieItem2) {
            Intrinsics.h(movieItem, "oldItem");
            Intrinsics.h(movieItem2, "newItem");
            return Intrinsics.c(movieItem.getSubjectType(), movieItem2.getSubjectType());
        }
    }

    public static final class e extends RecyclerView.r {
        private int[] a;
        private int b;

        e() {
        }

        private final void d(RecyclerView recyclerView) {
            StaggeredGridLayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                if (this.a == null) {
                    this.a = new int[layoutManager.Q()];
                }
                layoutManager.E(this.a);
                this.b = e(this.a);
                return;
            }
            if (layoutManager instanceof GridLayoutManager) {
                this.b = ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            } else {
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    throw new RuntimeException("Unsupported layoutManager.");
                }
                this.b = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            }
        }

        private final int e(int[] iArr) {
            if (iArr == null) {
                return 0;
            }
            int i = 0;
            for (int i2 : iArr) {
                if (i2 > i) {
                    i = i2;
                }
            }
            return i;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            com.transsion.home.adapter.a aVar;
            t6.f h0;
            t6.f h02;
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
            int itemCount = layoutManager != null ? layoutManager.getItemCount() : 0;
            if (i != 0 || childCount <= 0 || this.b < itemCount - 1) {
                return;
            }
            com.transsion.home.adapter.a aVar2 = MovieFragment.this.mAdapter;
            if (((aVar2 == null || (h02 = aVar2.h0()) == null) ? null : h02.i()) != LoadMoreStatus.Fail || (aVar = MovieFragment.this.mAdapter) == null || (h0 = aVar.h0()) == null) {
                return;
            }
            h0.w();
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.h(recyclerView, "recyclerView");
            d(recyclerView);
        }
    }

    public static final class f implements yg.m {
        f() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            t6.f h0;
            List data;
            List data2;
            List data3;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            if (MovieFragment.this.isResumed()) {
                com.transsion.home.adapter.a aVar = MovieFragment.this.mAdapter;
                if (aVar != null && (data3 = aVar.getData()) != null && data3.isEmpty()) {
                    View view = MovieFragment.this.mNoNetworkView;
                    if (view != null) {
                        uf.c.g(view);
                    }
                    MovieFragment.this.loadData();
                    return;
                }
                com.transsion.home.adapter.a aVar2 = MovieFragment.this.mAdapter;
                int size = (aVar2 == null || (data2 = aVar2.getData()) == null) ? 0 : data2.size();
                if (size <= 0) {
                    MovieFragment movieFragment = MovieFragment.this;
                    movieFragment.X0(movieFragment.mChannelId, MovieFragment.this.mLatestSelectItems, true);
                    return;
                }
                com.transsion.home.adapter.a aVar3 = MovieFragment.this.mAdapter;
                MovieItem movieItem = (aVar3 == null || (data = aVar3.getData()) == null) ? null : (MovieItem) data.get(size - 1);
                if (Intrinsics.c(MovieFragment.this.mChannelId, movieItem != null ? movieItem.getChannelId() : null)) {
                    if (Intrinsics.c(MovieFragment.this.mLatestSelectItems, movieItem != null ? movieItem.getSelectItems() : null)) {
                        com.transsion.home.adapter.a aVar4 = MovieFragment.this.mAdapter;
                        if (aVar4 == null || (h0 = aVar4.h0()) == null) {
                            return;
                        }
                        h0.w();
                        return;
                    }
                }
                MovieFragment movieFragment2 = MovieFragment.this;
                movieFragment2.X0(movieFragment2.mChannelId, MovieFragment.this.mLatestSelectItems, true);
            }
        }

        public void onDisconnected() {
        }
    }

    static final class g implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        g(Function1 function1) {
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

    private final void A1() {
        PopupFilterView popupFilterView = this.mFilterView;
        if (popupFilterView != null) {
            PopupFilterView.initSelectData$default(popupFilterView, Y0(this.mChannelId), null, 2, null);
        }
    }

    private final void C1() {
        View view = this.header;
        if (view != null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.no_network_stub);
            if (this.mNoNetworkView == null) {
                this.mNoNetworkView = viewStub.inflate();
            }
            View view2 = this.mNoNetworkView;
            if (view2 != null) {
                uf.c.k(view2);
                final NoNetworkBigView findViewById = view2.findViewById(R.id.state_view);
                if (findViewById != null) {
                    NoNetworkBigView.showTitle$default(findViewById, false, (String) null, 2, (Object) null);
                    findViewById.retry(new Function0() { // from class: com.transsion.home.fragment.tab.k
                        public final Object invoke() {
                            Unit D1;
                            D1 = MovieFragment.D1(findViewById, this);
                            return D1;
                        }
                    });
                    findViewById.goToSetting(new Function0() { // from class: com.transsion.home.fragment.tab.l
                        public final Object invoke() {
                            Unit E1;
                            E1 = MovieFragment.E1(MovieFragment.this);
                            return E1;
                        }
                    });
                }
                com.tn.lib.view.o.a(d1());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D1(NoNetworkBigView noNetworkBigView, MovieFragment movieFragment) {
        uf.c.g(noNetworkBigView);
        movieFragment.loadData();
        com.tn.lib.view.o.b(movieFragment.d1());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E1(MovieFragment movieFragment) {
        com.tn.lib.view.o.c(movieFragment.d1());
        return Unit.a;
    }

    private final void F1(String string) {
        View view = this.header;
        if (view != null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.no_result_stub);
            if (this.mNoResultView == null) {
                this.mNoResultView = viewStub.inflate();
            }
            final View view2 = this.mNoResultView;
            if (view2 != null) {
                uf.c.k(view2);
                TextView textView = (TextView) view2.findViewById(R.id.tv_no_result);
                if (textView != null) {
                    textView.setText(string);
                }
                View findViewById = view2.findViewById(R.id.tv_reset);
                if (findViewById != null) {
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.tab.s
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            MovieFragment.G1(MovieFragment.this, view2, view3);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(MovieFragment movieFragment, View view, View view2) {
        movieFragment.W0(movieFragment.mChannelId);
        movieFragment.x1(movieFragment.mChannelId);
        uf.c.g(view);
        movieFragment.startLoading();
        movieFragment.A1();
    }

    private final void H1(MovieBean movieBean, boolean isRefresh) {
        t6.f h0;
        qk.q qVar;
        LinearLayout root;
        t6.f h02;
        com.transsion.home.adapter.a aVar;
        t6.f h03;
        SwipeRefreshLayout swipeRefreshLayout;
        qk.q qVar2;
        SwipeRefreshLayout swipeRefreshLayout2;
        Integer perPage;
        if (movieBean != null) {
            Pager pager = movieBean.getPager();
            this.mPerPage = (pager == null || (perPage = pager.getPerPage()) == null) ? 10 : perPage.intValue();
            if (isRefresh) {
                qk.q qVar3 = (qk.q) getMViewBinding();
                if (qVar3 != null && (swipeRefreshLayout = qVar3.g) != null && swipeRefreshLayout.isRefreshing() && (qVar2 = (qk.q) getMViewBinding()) != null && (swipeRefreshLayout2 = qVar2.g) != null) {
                    swipeRefreshLayout2.setRefreshing(false);
                }
                com.transsion.home.adapter.a aVar2 = this.mAdapter;
                if (aVar2 != null) {
                    aVar2.n1(movieBean.getItems());
                }
                List<MovieItem> items = movieBean.getItems();
                if (items == null || !items.isEmpty()) {
                    j1();
                } else {
                    F1(getString(R.string.no_filter_result));
                }
            } else {
                com.transsion.home.adapter.a aVar3 = this.mAdapter;
                List data = aVar3 != null ? aVar3.getData() : null;
                ArrayList arrayList = new ArrayList();
                List<MovieItem> items2 = movieBean.getItems();
                if (items2 == null) {
                    items2 = CollectionsKt.l();
                }
                if (data == null || !(!data.isEmpty())) {
                    arrayList.addAll(items2);
                } else {
                    for (MovieItem movieItem : items2) {
                        if (!data.contains(movieItem)) {
                            arrayList.add(movieItem);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    com.transsion.home.adapter.a aVar4 = this.mAdapter;
                    if (aVar4 == null || (h02 = aVar4.h0()) == null) {
                        return;
                    }
                    t6.f.u(h02, false, 1, (Object) null);
                    return;
                }
                com.transsion.home.adapter.a aVar5 = this.mAdapter;
                if (aVar5 != null) {
                    aVar5.q(arrayList);
                }
                com.transsion.home.adapter.a aVar6 = this.mAdapter;
                if (aVar6 != null && (h0 = aVar6.h0()) != null && h0.r() && (qVar = (qk.q) getMViewBinding()) != null && (root = qVar.getRoot()) != null) {
                    root.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            MovieFragment.I1(MovieFragment.this);
                        }
                    }, 300L);
                }
            }
            Pager pager2 = movieBean.getPager();
            if (!(pager2 != null ? Intrinsics.c(pager2.getHasMore(), Boolean.FALSE) : false) || (aVar = this.mAdapter) == null || (h03 = aVar.h0()) == null) {
                return;
            }
            t6.f.u(h03, false, 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(MovieFragment movieFragment) {
        t6.f h0;
        com.transsion.home.adapter.a aVar = movieFragment.mAdapter;
        if (aVar == null || (h0 = aVar.h0()) == null) {
            return;
        }
        h0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(HashMap selectItems) {
        PopupFilterView popupFilterView = this.mFilterView;
        if (popupFilterView != null) {
            popupFilterView.initSelectData(Y0(this.mChannelId), selectItems);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0(int position) {
        String channelId;
        List<Channel> typeList;
        Channel channel;
        RecyclerView recyclerView;
        List<Channel> typeList2;
        FilterItems filterItems = this.mFilterItems;
        int size = (filterItems == null || (typeList2 = filterItems.getTypeList()) == null) ? -1 : typeList2.size();
        if (position < 0 || position >= size) {
            return;
        }
        RecyclerView.m mVar = null;
        if (h1()) {
            channelId = this.mDeeplinkChannelId;
        } else {
            FilterItems filterItems2 = this.mFilterItems;
            channelId = (filterItems2 == null || (typeList = filterItems2.getTypeList()) == null || (channel = typeList.get(position)) == null) ? null : channel.getChannelId();
        }
        this.mChannelId = channelId;
        this.mDeeplinkChannelId = null;
        View view = this.header;
        if (view != null) {
            qk.q qVar = (qk.q) getMViewBinding();
            if (qVar != null && (recyclerView = qVar.c) != null) {
                mVar = recyclerView.getLayoutManager();
            }
            if (mVar instanceof OffsetGridLayoutManager) {
                OffsetGridLayoutManager offsetGridLayoutManager = (OffsetGridLayoutManager) mVar;
                if (offsetGridLayoutManager.U() == e1()) {
                    a.a.f(wf.a.a, "MovieFragment", "span count is same " + offsetGridLayoutManager.U(), false, 4, (Object) null);
                    return;
                }
            }
            n1();
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            com.transsion.home.adapter.a aVar = this.mAdapter;
            if (aVar != null) {
                BaseQuickAdapter.y(aVar, view, 0, 0, 6, (Object) null);
            }
            showLoadingView();
        }
    }

    private final void W0(String channelId) {
        HashMap hashMap = (HashMap) this.mSubjectTypeMap.get(channelId);
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(String channelId, Map selectedItems, boolean isRefresh) {
        MovieViewModel movieViewModel = this.mMovieModel;
        if (movieViewModel != null) {
            int i = this.mPage;
            this.mPage = i + 1;
            movieViewModel.k(i, this.mPerPage, channelId, selectedItems, isRefresh);
        }
        this.mLatestSelectItems = selectedItems;
        q0(selectedItems);
    }

    private final List Y0(String channelId) {
        List<Channel> typeList;
        FilterItems filterItems = this.mFilterItems;
        if (filterItems == null || (typeList = filterItems.getTypeList()) == null) {
            return null;
        }
        for (Channel channel : typeList) {
            if (Intrinsics.c(channel.getChannelId(), channelId)) {
                return channel.getItems();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Z0() {
        String str;
        HashMap hashMap = (HashMap) this.mSubjectTypeMap.get(this.mChannelId);
        if (hashMap == null || (str = (String) hashMap.get("sort")) == null) {
            str = BuildConfig.FLAVOR;
        }
        return "filter_" + str;
    }

    private final LayoutStyle a1(String channelId) {
        List<Channel> typeList;
        FilterItems filterItems = this.mFilterItems;
        if (filterItems == null || (typeList = filterItems.getTypeList()) == null) {
            return null;
        }
        for (Channel channel : typeList) {
            if (Intrinsics.c(channel.getChannelId(), channelId)) {
                return channel.getStyle();
            }
        }
        return null;
    }

    private final int b1() {
        return R.layout.home_empty_view_loading;
    }

    private final im.b c1() {
        return (im.b) this.memberProvider.getValue();
    }

    private final String d1() {
        HomeFragment parentFragment = getParentFragment();
        return parentFragment instanceof HomeFragment ? parentFragment.J0() : BuildConfig.FLAVOR;
    }

    private final int e1() {
        LayoutStyle a1 = a1(this.mChannelId);
        if (a1 != null) {
            int colNum = a1.getColNum();
            FragmentActivity activity = getActivity();
            return colNum + ((activity == null || !com.transsion.baseui.util.b.a(activity)) ? 0 : 1);
        }
        if (Intrinsics.c(this.mChannelId, MsgStyle.CUSTOM_LEFT_PIC_EMOJI) || Intrinsics.c(this.mChannelId, "6") || Intrinsics.c(this.mChannelId, "1003") || Intrinsics.c(this.mChannelId, "1004")) {
            return 2;
        }
        FragmentActivity activity2 = getActivity();
        return (activity2 == null || !com.transsion.baseui.util.b.a(activity2)) ? 3 : 4;
    }

    private final boolean h1() {
        FilterItems filterItems;
        List<Channel> typeList;
        String str = this.mDeeplinkChannelId;
        if (str != null && str.length() != 0 && (filterItems = this.mFilterItems) != null && (typeList = filterItems.getTypeList()) != null) {
            Iterator<T> it = typeList.iterator();
            while (it.hasNext()) {
                if (Intrinsics.c(((Channel) it.next()).getChannelId(), this.mDeeplinkChannelId)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void i1() {
        View view = this.mLoadingView;
        if (view != null) {
            uf.c.g(view);
        }
    }

    private final void initScrollListener() {
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        qk.q qVar = (qk.q) getMViewBinding();
        if (qVar != null && (swipeRefreshLayout2 = qVar.g) != null) {
            swipeRefreshLayout2.setEnabled(false);
        }
        qk.q qVar2 = (qk.q) getMViewBinding();
        if (qVar2 != null && (swipeRefreshLayout = qVar2.g) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.home.fragment.tab.o
                public final void a() {
                    MovieFragment.r1(MovieFragment.this);
                }
            });
        }
        qk.q qVar3 = (qk.q) getMViewBinding();
        if (qVar3 == null || (recyclerView = qVar3.c) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new e());
    }

    private final void initViewModel() {
        MovieViewModel movieViewModel = this.mMovieModel;
        if (movieViewModel != null) {
            movieViewModel.i().j(this, new g(new Function1() { // from class: com.transsion.home.fragment.tab.i
                public final Object invoke(Object obj) {
                    Unit s1;
                    s1 = MovieFragment.s1(MovieFragment.this, (BaseDto) obj);
                    return s1;
                }
            }));
            movieViewModel.l().j(this, new g(new Function1() { // from class: com.transsion.home.fragment.tab.m
                public final Object invoke(Object obj) {
                    Unit u1;
                    u1 = MovieFragment.u1(MovieFragment.this, (RefreshBaseDto) obj);
                    return u1;
                }
            }));
            PopupFilterView popupFilterView = this.mFilterView;
            if (popupFilterView != null) {
                popupFilterView.setOnFilterListener(new Function1() { // from class: com.transsion.home.fragment.tab.n
                    public final Object invoke(Object obj) {
                        Unit v1;
                        v1 = MovieFragment.v1(MovieFragment.this, (Map) obj);
                        return v1;
                    }
                });
            }
        }
    }

    private final void j1() {
        View view = this.mNoResultView;
        if (view != null) {
            uf.c.g(view);
        }
    }

    private final void k1() {
        List<Channel> typeList;
        qk.q qVar;
        View view;
        List<Channel> typeList2;
        qk.b0 b0Var;
        qk.b0 b0Var2;
        List<Channel> typeList3;
        FilterItems filterItems = this.mFilterItems;
        int i = 0;
        int size = (filterItems == null || (typeList3 = filterItems.getTypeList()) == null) ? 0 : typeList3.size();
        if (size <= 0) {
            return;
        }
        qk.q qVar2 = (qk.q) getMViewBinding();
        ConstraintLayout constraintLayout = null;
        TabLayout tabLayout = (qVar2 == null || (b0Var2 = qVar2.b) == null) ? null : b0Var2.d;
        qk.q qVar3 = (qk.q) getMViewBinding();
        if (qVar3 != null && (b0Var = qVar3.b) != null) {
            constraintLayout = b0Var.c;
        }
        if (size == 1) {
            if (constraintLayout != null) {
                uf.c.g(constraintLayout);
            }
            x1(this.mChannelId);
            J1((HashMap) this.mSubjectTypeMap.get(this.mChannelId));
        } else {
            if (constraintLayout != null) {
                uf.c.k(constraintLayout);
            }
            if (tabLayout != null) {
                tabLayout.removeAllTabs();
            }
            if (tabLayout != null) {
                tabLayout.clearOnTabSelectedListeners();
            }
            if (tabLayout != null) {
                tabLayout.addOnTabSelectedListener(new b());
            }
            FilterItems filterItems2 = this.mFilterItems;
            if (filterItems2 != null && (typeList = filterItems2.getTypeList()) != null) {
                int i2 = 0;
                for (Object obj : typeList) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.u();
                    }
                    Channel channel = (Channel) obj;
                    if (tabLayout != null) {
                        tabLayout.addTab(tabLayout.newTab().setText(channel.getChannelName()), Intrinsics.c(channel.getChannelId(), this.mChannelId));
                    }
                    i2 = i3;
                }
            }
        }
        if (getParentFragment() instanceof HomeFragment) {
            FilterItems filterItems3 = this.mFilterItems;
            if (filterItems3 != null && (typeList2 = filterItems3.getTypeList()) != null) {
                i = typeList2.size();
            }
            if (i > 1 || (qVar = (qk.q) getMViewBinding()) == null || (view = qVar.e) == null) {
                return;
            }
            uf.c.k(view);
        }
    }

    private final void l1() {
        RecyclerView recyclerView;
        if (this.mExposureHelper == null) {
            rk.b bVar = new rk.b(0.6f, new c(), false, 4, null);
            qk.q qVar = (qk.q) getMViewBinding();
            if (qVar != null && (recyclerView = qVar.c) != null) {
                recyclerView.addOnScrollListener(bVar);
            }
            this.mExposureHelper = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        startLoading();
        MovieViewModel movieViewModel = this.mMovieModel;
        if (movieViewModel != null) {
            movieViewModel.h(Integer.valueOf(getMTabId()), "v3");
        }
    }

    private final void loadMore() {
        String str = this.mChannelId;
        X0(str, (Map) this.mSubjectTypeMap.get(str), false);
    }

    private final void m1() {
        List<Channel> typeList;
        this.mSubjectTypeMap.clear();
        FilterItems filterItems = this.mFilterItems;
        if (filterItems == null || (typeList = filterItems.getTypeList()) == null) {
            return;
        }
        Iterator<T> it = typeList.iterator();
        while (it.hasNext()) {
            this.mSubjectTypeMap.put(((Channel) it.next()).getChannelId(), new HashMap());
        }
    }

    private final void n1() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        qk.q qVar;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        int e1 = e1();
        OffsetGridLayoutManager offsetGridLayoutManager = new OffsetGridLayoutManager(getContext(), e1, 1, false);
        qk.q qVar2 = (qk.q) getMViewBinding();
        if (qVar2 != null && (recyclerView4 = qVar2.c) != null) {
            recyclerView4.setLayoutManager(offsetGridLayoutManager);
        }
        com.transsion.home.adapter.a aVar = new com.transsion.home.adapter.a(new ArrayList(), this.mExposureHelper, a1(this.mChannelId), e1);
        aVar.h0().z(true);
        aVar.h0().y(true);
        aVar.h0().D(new r6.f() { // from class: com.transsion.home.fragment.tab.q
            public final void a() {
                MovieFragment.p1(MovieFragment.this);
            }
        });
        aVar.R0(new d());
        aVar.w1(new r6.d() { // from class: com.transsion.home.fragment.tab.r
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MovieFragment.o1(MovieFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mAdapter = aVar;
        qk.q qVar3 = (qk.q) getMViewBinding();
        if (qVar3 != null && (recyclerView2 = qVar3.c) != null && recyclerView2.getItemDecorationCount() < 2 && (qVar = (qk.q) getMViewBinding()) != null && (recyclerView3 = qVar.c) != null) {
            recyclerView3.addItemDecoration(new tf.b(com.blankj.utilcode.util.a0.a(4.0f), com.blankj.utilcode.util.a0.a(4.0f), com.blankj.utilcode.util.a0.a(16.0f), com.blankj.utilcode.util.a0.a(16.0f)));
        }
        qk.q qVar4 = (qk.q) getMViewBinding();
        if (qVar4 == null || (recyclerView = qVar4.c) == null) {
            return;
        }
        recyclerView.setAdapter(this.mAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(MovieFragment movieFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof MovieItem) {
            MovieItem movieItem = (MovieItem) item;
            String subjectId = movieItem.getSubjectId();
            if (subjectId != null) {
                zk.h.f(new Subject(subjectId, movieItem.getSubjectType(), movieItem.getTitle(), (String) null, (Cover) null, (String) null, movieItem.getDescription(), (String) null, (Integer) null, movieItem.getGenre(), (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, movieItem.getOps(), (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (com.transsion.flow.bean.LayoutStyle) null, movieItem.getPlayUrl(), (Boolean) null, -524872, 50331647, (DefaultConstructorMarker) null), movieFragment.Z0());
            }
            HashMap hashMap = new HashMap();
            String subjectId2 = movieItem.getSubjectId();
            String str = BuildConfig.FLAVOR;
            if (subjectId2 == null) {
                subjectId2 = BuildConfig.FLAVOR;
            }
            hashMap.put("subject_id", subjectId2);
            hashMap.put("sequence", String.valueOf(i));
            String ops = movieItem.getOps();
            if (ops != null) {
                str = ops;
            }
            hashMap.put("ops", str);
            hashMap.put("filter_name", movieFragment.Z0());
            com.transsion.baselib.helper.a.a.f(movieFragment.f1(movieFragment.mFilterItems), hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(final MovieFragment movieFragment) {
        RecyclerView recyclerView;
        if (yg.l.a.e()) {
            movieFragment.loadMore();
            return;
        }
        fh.b.a.d(com.tn.lib.widget.R.string.no_network_toast);
        qk.q qVar = (qk.q) movieFragment.getMViewBinding();
        if (qVar == null || (recyclerView = qVar.c) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.j
            @Override // java.lang.Runnable
            public final void run() {
                MovieFragment.q1(MovieFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(MovieFragment movieFragment) {
        t6.f h0;
        com.transsion.home.adapter.a aVar = movieFragment.mAdapter;
        if (aVar == null || (h0 = aVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(MovieFragment movieFragment) {
        movieFragment.c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(final MovieFragment movieFragment, BaseDto baseDto) {
        SwipeRefreshLayout swipeRefreshLayout;
        if (baseDto == null) {
            return Unit.a;
        }
        if (!Intrinsics.c(baseDto.getCode(), "0")) {
            qk.q qVar = (qk.q) movieFragment.getMViewBinding();
            if (qVar != null && (swipeRefreshLayout = qVar.g) != null) {
                swipeRefreshLayout.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        MovieFragment.t1(MovieFragment.this);
                    }
                }, 200L);
            }
            return Unit.a;
        }
        movieFragment.mFilterItems = (FilterItems) baseDto.getData();
        movieFragment.V0(0);
        movieFragment.m1();
        movieFragment.k1();
        com.transsion.home.adapter.a aVar = movieFragment.mAdapter;
        if (aVar != null) {
            aVar.F1(movieFragment.a1(movieFragment.mChannelId));
        }
        return Unit.a;
    }

    private final void showLoadingView() {
        View view = this.header;
        if (view != null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.loading_stub);
            if (viewStub != null) {
                viewStub.setLayoutResource(b1());
            }
            if (this.mLoadingView == null) {
                this.mLoadingView = viewStub.inflate();
            }
            View view2 = this.mLoadingView;
            if (view2 != null) {
                uf.c.k(view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(MovieFragment movieFragment) {
        movieFragment.hideLoading();
        movieFragment.C1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(MovieFragment movieFragment, RefreshBaseDto refreshBaseDto) {
        t6.f h0;
        com.transsion.home.adapter.a aVar;
        t6.f h02;
        List data;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        SwipeRefreshLayout swipeRefreshLayout3;
        if (refreshBaseDto == null) {
            return Unit.a;
        }
        qk.q qVar = (qk.q) movieFragment.getMViewBinding();
        if (qVar != null && (swipeRefreshLayout3 = qVar.g) != null) {
            swipeRefreshLayout3.setEnabled(true);
        }
        if (Intrinsics.c(refreshBaseDto.getCode(), "0")) {
            qi.b logViewConfig = movieFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            MovieBean movieBean = (MovieBean) refreshBaseDto.getData();
            if (movieBean != null) {
                movieFragment.H1(movieBean, refreshBaseDto.getIsRefresh());
                View view = movieFragment.mNoNetworkView;
                if (view != null) {
                    uf.c.g(view);
                }
            }
            movieFragment.hideLoading();
            return Unit.a;
        }
        if (refreshBaseDto.getIsRefresh()) {
            qk.q qVar2 = (qk.q) movieFragment.getMViewBinding();
            if (qVar2 != null && (swipeRefreshLayout = qVar2.g) != null && swipeRefreshLayout.isRefreshing()) {
                qk.q qVar3 = (qk.q) movieFragment.getMViewBinding();
                if (qVar3 != null && (swipeRefreshLayout2 = qVar3.g) != null) {
                    swipeRefreshLayout2.setRefreshing(false);
                }
                movieFragment.n0();
            }
        } else {
            com.transsion.home.adapter.a aVar2 = movieFragment.mAdapter;
            if (aVar2 != null && (h0 = aVar2.h0()) != null && h0.r() && (aVar = movieFragment.mAdapter) != null && (h02 = aVar.h0()) != null) {
                h02.v();
            }
        }
        com.transsion.home.adapter.a aVar3 = movieFragment.mAdapter;
        if (aVar3 == null || (data = aVar3.getData()) == null || data.size() != 0) {
            if (yg.l.a.e()) {
                fh.b.a.d(com.transsnet.downloader.R.string.str_ad_video_error_tips);
            } else {
                fh.b.a.d(com.tn.lib.widget.R.string.no_network_toast);
            }
            movieFragment.i1();
            return Unit.a;
        }
        if (yg.l.a.e()) {
            movieFragment.F1(movieFragment.getString(R.string.home_no_network_content));
        } else {
            movieFragment.C1();
        }
        movieFragment.i1();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(MovieFragment movieFragment, Map map) {
        Intrinsics.h(map, "it");
        movieFragment.w1(map);
        com.transsion.baselib.helper.a.a.h(movieFragment.f1(movieFragment.mFilterItems), map.toString(), (r16 & 4) != 0 ? BuildConfig.FLAVOR : null, (r16 & 8) != 0 ? BuildConfig.FLAVOR : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
        rk.b bVar = movieFragment.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
        return Unit.a;
    }

    private final void w1(Map selectedMap) {
        this.mPage = 1;
        HashMap hashMap = (HashMap) this.mSubjectTypeMap.get(this.mChannelId);
        if (hashMap != null) {
            hashMap.clear();
        }
        if (hashMap != null) {
            hashMap.putAll(selectedMap);
        }
        X0(this.mChannelId, hashMap, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1(String channelId) {
        List<Channel> typeList;
        this.mPage = 1;
        FilterItems filterItems = this.mFilterItems;
        if (filterItems == null || (typeList = filterItems.getTypeList()) == null) {
            return;
        }
        for (Channel channel : typeList) {
            if (Intrinsics.c(channel.getChannelId(), channelId)) {
                HashMap hashMap = (HashMap) this.mSubjectTypeMap.get(channelId);
                String str = this.mFilterJson;
                if (str == null || str.length() <= 0) {
                    List<Item> items = channel.getItems();
                    if (items != null) {
                        for (Item item : items) {
                            if ((hashMap != null ? (String) hashMap.get(item.getFilterType()) : null) == null) {
                                if (item.getRangeVals() != null) {
                                    String a = PopupFilterView.INSTANCE.a(item.getRangeVals().getMinVal(), item.getRangeVals().getMaxVal());
                                    if (hashMap != null) {
                                        hashMap.put(item.getFilterType(), a);
                                    }
                                } else if (!item.getFilterValsV2().isEmpty() && hashMap != null) {
                                    hashMap.put(item.getFilterType(), item.getFilterValsV2().get(0).getId());
                                }
                            }
                        }
                    }
                } else {
                    try {
                        String str2 = this.mFilterJson;
                        if (str2 == null) {
                            str2 = BuildConfig.FLAVOR;
                        }
                        JSONObject jSONObject = new JSONObject(str2);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String string = jSONObject.getString(next);
                            if (hashMap != null) {
                                hashMap.put(next, string);
                            }
                        }
                        Unit unit = Unit.a;
                    } catch (Exception unused) {
                        List<Item> items2 = channel.getItems();
                        if (items2 != null) {
                            for (Item item2 : items2) {
                                if ((hashMap != null ? (String) hashMap.get(item2.getFilterType()) : null) == null && hashMap != null) {
                                    hashMap.put(item2.getFilterType(), item2.getFilterValsV2().get(0).getId());
                                }
                            }
                            Unit unit2 = Unit.a;
                        }
                    }
                }
                this.mFilterJson = null;
                X0(channelId, hashMap, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final im.b y1() {
        return (im.b) TheRouter.d(im.b.class, new Object[0]);
    }

    private final void z1(boolean show) {
        if (getMTabId() == HomeTabId.Game.getValue()) {
            if (show) {
                im.b c1 = c1();
                if (c1 != null) {
                    c1.h();
                    return;
                }
                return;
            }
            im.b c12 = c1();
            if (c12 != null) {
                c12.q();
            }
        }
    }

    public final void B1(TabLayout.Tab tab, boolean z) {
        Intrinsics.h(tab, "<this>");
        try {
            Field declaredField = tab.getClass().getDeclaredField("view");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(tab);
            Field declaredField2 = obj.getClass().getDeclaredField("textView");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Intrinsics.f(obj2, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) obj2;
            textView.setTextSize(14.0f);
            if (z) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                textView.setTypeface(Typeface.defaultFromStyle(0));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void c0() {
        super.c0();
        this.mPage = 1;
        String str = this.mChannelId;
        X0(str, (Map) this.mSubjectTypeMap.get(str), true);
        rk.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public RecyclerView f0() {
        qk.q qVar = (qk.q) getMViewBinding();
        if (qVar != null) {
            return qVar.c;
        }
        return null;
    }

    public final String f1(FilterItems filterItems) {
        List<Channel> typeList;
        String mTabCode = getMTabCode();
        if (mTabCode != null && mTabCode.length() != 0) {
            String mTabCode2 = getMTabCode();
            return mTabCode2 == null ? BuildConfig.FLAVOR : mTabCode2;
        }
        if (filterItems != null && (typeList = filterItems.getTypeList()) != null) {
            for (Channel channel : typeList) {
                if (Intrinsics.c(this.mChannelId, channel.getChannelId())) {
                    String channelName = channel.getChannelName();
                    return channelName == null ? d1() : channelName;
                }
            }
        }
        return d1();
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public String g0() {
        int e1 = e1();
        return e1 != 2 ? e1 != 3 ? "HomeFragmentListLinearTemplateAd" : "HomeFragmentListGrid3TemplateAd" : "HomeFragmentListGrid2TemplateAd";
    }

    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public qk.q getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        qk.q c2 = qk.q.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void hideLoading() {
        i1();
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void initView(View view, Bundle savedInstanceState) {
        qk.q qVar;
        View view2;
        View view3;
        Intrinsics.h(view, "view");
        super.initView(view, savedInstanceState);
        qk.q qVar2 = (qk.q) getMViewBinding();
        if (qVar2 != null && (view3 = qVar2.f) != null) {
            view3.getLayoutParams().height = h0();
        }
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getBoolean("hide_header_bg", false) && (qVar = (qk.q) getMViewBinding()) != null && (view2 = qVar.f) != null) {
            uf.c.g(view2);
        }
        this.mMovieModel = new androidx.lifecycle.v0(this).a(MovieViewModel.class);
        qk.q qVar3 = (qk.q) getMViewBinding();
        this.mFilterView = qVar3 != null ? qVar3.d : null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.header_movie, (ViewGroup) null);
        this.header = inflate;
        if (inflate != null) {
            l1();
            n1();
            initScrollListener();
            com.transsion.home.adapter.a aVar = this.mAdapter;
            if (aVar != null) {
                BaseQuickAdapter.y(aVar, inflate, 0, 0, 6, (Object) null);
            }
            initViewModel();
            setNetListener(new f());
        }
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void l0(int lastAdPosition, BiddingNativeManager wrapperNativeManager) {
        List data;
        Intrinsics.h(wrapperNativeManager, "wrapperNativeManager");
        Context context = getContext();
        if ((context == null || !com.transsion.baseui.util.b.a(context)) && wrapperNativeManager != null) {
            MovieItem movieItem = new MovieItem((String) null, (Cover) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Cover) null, (String) null, (Integer) null, (List) null, (String) null, (Boolean) null, (Integer) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Map) null, (BiddingNativeManager) null, (PlayUrl) null, 67108863, (DefaultConstructorMarker) null);
            movieItem.setNonAdDelegate(wrapperNativeManager);
            com.transsion.home.adapter.a aVar = this.mAdapter;
            int size = (aVar == null || (data = aVar.getData()) == null) ? 0 : data.size();
            if (lastAdPosition < 0 || lastAdPosition > size) {
                com.transsion.home.adapter.a aVar2 = this.mAdapter;
                if (aVar2 != null) {
                    aVar2.p(movieItem);
                    return;
                }
                return;
            }
            com.transsion.home.adapter.a aVar3 = this.mAdapter;
            if (aVar3 != null) {
                aVar3.n(lastAdPosition, movieItem);
            }
        }
    }

    public void lazyLoadData() {
        loadData();
    }

    public qi.b newLogViewConfig() {
        return new qi.b(d1(), false, 2, null);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(newConfig);
        com.transsion.home.adapter.a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.mFilterJson = arguments != null ? arguments.getString("filter_json") : null;
    }

    public void onDestroyView() {
        androidx.lifecycle.b0 m;
        androidx.lifecycle.b0 j;
        this.mPage = 1;
        MovieViewModel movieViewModel = this.mMovieModel;
        if (movieViewModel != null && (j = movieViewModel.j()) != null) {
            j.q((Object) null);
        }
        MovieViewModel movieViewModel2 = this.mMovieModel;
        if (movieViewModel2 != null && (m = movieViewModel2.m()) != null) {
            m.q((Object) null);
        }
        super.onDestroyView();
    }

    public void onHiddenChanged(boolean hidden) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        com.transsion.baseui.activity.k.h(null, this, hidden, "tabId=" + getMTabId(), 1, null);
        if (isResumed()) {
            if (!hidden) {
                logResume();
                z1(true);
            } else {
                z1(false);
                logPause();
                this.startShowTime = SystemClock.elapsedRealtime();
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (getMTabId() == 2) {
            com.transsion.baselib.helper.a.a.k(f1(this.mFilterItems), qi.h.a.h(), String.valueOf(SystemClock.elapsedRealtime() - this.startShowTime));
        }
        rk.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
        com.transsion.baseui.activity.k.l(null, this, "tabId=" + getMTabId(), 1, null);
        z1(false);
    }

    public void onResume() {
        com.transsion.home.adapter.a aVar;
        List data;
        super.onResume();
        this.startShowTime = SystemClock.elapsedRealtime();
        View view = this.mNoNetworkView;
        if (view != null && uf.c.i(view) && yg.l.a.e() && (aVar = this.mAdapter) != null && (data = aVar.getData()) != null && data.isEmpty()) {
            View view2 = this.mNoNetworkView;
            if (view2 != null) {
                uf.c.g(view2);
            }
            loadData();
        }
        com.transsion.baseui.activity.k.p(null, this, "tabId=" + getMTabId() + " visible=" + isVisible(), 1, null);
        z1(true);
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void p0() {
        RecyclerView recyclerView;
        qk.q qVar = (qk.q) getMViewBinding();
        if (qVar == null || (recyclerView = qVar.c) == null) {
            return;
        }
        recyclerView.smoothScrollToPosition(0);
    }

    public void startLoading() {
        showLoadingView();
    }
}
