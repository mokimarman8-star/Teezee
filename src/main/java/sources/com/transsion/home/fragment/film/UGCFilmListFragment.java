package com.transsion.home.fragment.film;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.d;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.Utils;
import com.transsion.home.adapter.e;
import com.transsion.home.bean.UGCRankAllData;
import com.transsion.home.bean.UgcGenreTopRespGenreItem;
import com.transsion.home.fragment.film.UGCFilmListFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.home.viewmodel.UGCFilmListViewModel;
import com.transsion.home.viewmodel.UGCRankingViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.UGCVideoType;
import com.transsion.ugcvideodetail.api.bean.UGCCollection;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import ni.f;
import qk.l;
import t6.f;
import wf.a;
import xk.a;
import zg.h;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u0000 a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u001d\u0010\u0012\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\r\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u0004J\r\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020!H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0007H\u0016¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0004\b-\u0010\u0004J\u001f\u00101\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020\u0018¢\u0006\u0004\b1\u00102J\u0015\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0018¢\u0006\u0004\b7\u0010\u001aR\u0018\u00104\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010A\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010<R\u0016\u0010C\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010<R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010<R\u0016\u0010O\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010<R\u0016\u0010S\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010<R\u0018\u0010V\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010N¨\u0006b"}, d2 = {"Lcom/transsion/home/fragment/film/UGCFilmListFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lqk/l;", "<init>", "()V", "Lcom/transsion/moviedetailapi/bean/Cover;", "cover", BuildConfig.FLAVOR, "G0", "(Lcom/transsion/moviedetailapi/bean/Cover;)V", "B0", "Lcom/transsion/home/adapter/e;", "x0", "()Lcom/transsion/home/adapter/e;", "reload", BuildConfig.FLAVOR, "Lcom/transsion/home/bean/UgcGenreTopRespGenreItem;", "filmList", "K0", "(Ljava/util/List;)V", "Landroid/view/LayoutInflater;", "inflater", "w0", "(Landroid/view/LayoutInflater;)Lqk/l;", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "receiveArguments", "initViewData", "hideLoading", "startLoading", "initViewModel", "initListener", BuildConfig.FLAVOR, "isMonitorNetworkState", "()Z", "hidden", "onHiddenChanged", "(Z)V", "onPause", "retryLoadData", "loadDefaultData", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "onDestroy", "Lcom/transsion/home/bean/UGCRankAllData;", "data", "rankCategory", "L0", "(Lcom/transsion/home/bean/UGCRankAllData;Ljava/lang/String;)V", "Lcom/transsion/home/viewmodel/UGCRankingViewModel;", "viewModel", "H0", "(Lcom/transsion/home/viewmodel/UGCRankingViewModel;)V", "getPageName", "Lcom/transsion/home/viewmodel/UGCFilmListViewModel;", "a", "Lcom/transsion/home/viewmodel/UGCFilmListViewModel;", "b", "Ljava/lang/String;", "tabId", "c", "fromOptId", "d", "filmType", "e", "mFilmListTitle", "Lrk/b;", "f", "Lrk/b;", "mExposureHelper", "g", "Lcom/transsion/home/adapter/e;", "mFilmListAdapter", "h", "mFilmListCover", "i", "Z", "isRankingMode", "j", "rankingCategory", "k", "videoType", "l", "Lcom/transsion/home/viewmodel/UGCRankingViewModel;", "rankingViewModel", "Lxk/a;", "m", "Lxk/a;", "headerMaskManager", BuildConfig.FLAVOR, "n", "J", "firstLoadStartTimeMillis", "o", "hasRecordedFirstLoadDuration", "p", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCFilmListFragment extends PageStatusFragment<l> {

    /* renamed from: p, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int q = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private UGCFilmListViewModel viewModel;

    /* renamed from: f, reason: from kotlin metadata */
    private rk.b mExposureHelper;

    /* renamed from: g, reason: from kotlin metadata */
    private e mFilmListAdapter;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean isRankingMode;

    /* renamed from: l, reason: from kotlin metadata */
    private UGCRankingViewModel rankingViewModel;

    /* renamed from: m, reason: from kotlin metadata */
    private a headerMaskManager;

    /* renamed from: n, reason: from kotlin metadata */
    private long firstLoadStartTimeMillis;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean hasRecordedFirstLoadDuration;

    /* renamed from: b, reason: from kotlin metadata */
    private String tabId = "0";

    /* renamed from: c, reason: from kotlin metadata */
    private String fromOptId = BuildConfig.FLAVOR;

    /* renamed from: d, reason: from kotlin metadata */
    private String filmType = BuildConfig.FLAVOR;

    /* renamed from: e, reason: from kotlin metadata */
    private String mFilmListTitle = BuildConfig.FLAVOR;

    /* renamed from: h, reason: from kotlin metadata */
    private String mFilmListCover = BuildConfig.FLAVOR;

    /* renamed from: j, reason: from kotlin metadata */
    private String rankingCategory = BuildConfig.FLAVOR;

    /* renamed from: k, reason: from kotlin metadata */
    private String videoType = BuildConfig.FLAVOR;

    /* renamed from: com.transsion.home.fragment.film.UGCFilmListFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ UGCFilmListFragment b(Companion companion, String str, String str2, String str3, boolean z, String str4, String str5, int i, Object obj) {
            if ((i & 8) != 0) {
                z = false;
            }
            return companion.a(str, str2, str3, z, str4, str5);
        }

        public final UGCFilmListFragment a(String str, String str2, String str3, boolean z, String str4, String str5) {
            Intrinsics.h(str, "tabId");
            Intrinsics.h(str2, "filmType");
            Intrinsics.h(str3, "mFilmListTitle");
            Intrinsics.h(str4, "videoType");
            Intrinsics.h(str5, "fromOptId");
            UGCFilmListFragment uGCFilmListFragment = new UGCFilmListFragment();
            uGCFilmListFragment.setArguments(d.b(new Pair[]{TuplesKt.a("tabId", str), TuplesKt.a("filmType", str2), TuplesKt.a("filmListTitle", str3), TuplesKt.a("onlyShowList", Boolean.valueOf(z)), TuplesKt.a("videoType", str4), TuplesKt.a("fromOptId", str5)}));
            return uGCFilmListFragment;
        }
    }

    public static final class b implements rk.a {
        b() {
        }

        @Override // rk.a
        public void a(int i, long j, View view) {
            String str;
            String str2;
            String str3;
            UGCVideo video;
            String ops;
            UGCVideo video2;
            UGCVideo video3;
            UGCVideo video4;
            UGCVideoBelongToCollection belongToCollection;
            List data;
            e eVar = UGCFilmListFragment.this.mFilmListAdapter;
            if (i >= ((eVar == null || (data = eVar.getData()) == null) ? 0 : data.size())) {
                return;
            }
            e eVar2 = UGCFilmListFragment.this.mFilmListAdapter;
            UGCContent uGCContent = eVar2 != null ? (UGCContent) eVar2.getItem(i) : null;
            HashMap hashMap = new HashMap();
            hashMap.put("browse_duration", String.valueOf(j));
            hashMap.put("module_name", "item");
            if (UGCFilmListFragment.this.isRankingMode) {
                hashMap.put("rank_category", UGCFilmListFragment.this.rankingCategory);
            }
            String str4 = BuildConfig.FLAVOR;
            if (uGCContent == null || (video4 = uGCContent.getVideo()) == null || (belongToCollection = video4.getBelongToCollection()) == null || (str = belongToCollection.getCollectionId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("belong_to_collection_id", str);
            if (uGCContent == null || (video3 = uGCContent.getVideo()) == null || (str2 = video3.getUgcVideoId()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("content_id", str2);
            if (uGCContent == null || (video2 = uGCContent.getVideo()) == null || (str3 = video2.getSubjectId()) == null) {
                str3 = BuildConfig.FLAVOR;
            }
            hashMap.put("refer_subject_id", str3);
            hashMap.put("content_type", "ugc_video");
            if (uGCContent != null && (video = uGCContent.getVideo()) != null && (ops = video.getOps()) != null) {
                str4 = ops;
            }
            hashMap.put("ops", str4);
            hashMap.put("title", UGCFilmListFragment.this.isRankingMode ? UGCFilmListFragment.this.rankingCategory : UGCFilmListFragment.this.mFilmListTitle);
            com.transsion.baselib.helper.a.a.e(UGCFilmListFragment.this.getPageName(), hashMap);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(UGCFilmListFragment uGCFilmListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        String ops;
        UGCVideoBelongToCollection belongToCollection;
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof UGCContent) {
            UGCContent uGCContent = (UGCContent) item;
            String str2 = null;
            gu.c.f(uGCContent, (Integer) null, (String) null, 3, (Object) null);
            UGCVideo video = uGCContent.getVideo();
            String ugcVideoId = video != null ? video.getUgcVideoId() : null;
            UGCVideo video2 = uGCContent.getVideo();
            if (video2 != null && (belongToCollection = video2.getBelongToCollection()) != null) {
                str2 = belongToCollection.getCollectionId();
            }
            a.a.f(wf.a.a, "FilmListFragment", "initFilmListAdapter: item clicked, position=" + i + ", topicType=" + uGCContent.getTopicType() + ", videoId=" + ugcVideoId + ", collectionId=" + str2, false, 4, (Object) null);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "item");
            if (uGCFilmListFragment.isRankingMode) {
                hashMap.put("rank_category", uGCFilmListFragment.rankingCategory);
            }
            String str3 = BuildConfig.FLAVOR;
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            hashMap.put("belong_to_collection_id", str2);
            if (ugcVideoId == null) {
                ugcVideoId = BuildConfig.FLAVOR;
            }
            hashMap.put("content_id", ugcVideoId);
            UGCVideo video3 = uGCContent.getVideo();
            if (video3 == null || (str = video3.getSubjectId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("refer_subject_id", str);
            hashMap.put("content_type", "ugc_video");
            UGCVideo video4 = uGCContent.getVideo();
            if (video4 != null && (ops = video4.getOps()) != null) {
                str3 = ops;
            }
            hashMap.put("ops", str3);
            com.transsion.baselib.helper.a.a.f(uGCFilmListFragment.getPageName(), hashMap);
        }
    }

    private final void B0() {
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        l lVar = (l) getMViewBinding();
        if (lVar != null && (swipeRefreshLayout = lVar.f) != null) {
            swipeRefreshLayout.setEnabled(true);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: uk.e
                public final void a() {
                    UGCFilmListFragment.C0(UGCFilmListFragment.this);
                }
            });
        }
        l lVar2 = (l) getMViewBinding();
        if (lVar2 == null || (recyclerView = lVar2.e) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setItemAnimator((RecyclerView.j) null);
        rk.b bVar = new rk.b(0.6f, new b(), false, 4, null);
        bVar.l(2);
        recyclerView.addOnScrollListener(bVar);
        this.mExposureHelper = bVar;
        recyclerView.setAdapter(x0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(UGCFilmListFragment uGCFilmListFragment) {
        a.a.f(wf.a.a, "FilmListFragment", "initRecyclerView: user pull to refresh", false, 4, (Object) null);
        rk.b bVar = uGCFilmListFragment.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
        if (uGCFilmListFragment.isRankingMode) {
            UGCRankingViewModel uGCRankingViewModel = uGCFilmListFragment.rankingViewModel;
            if (uGCRankingViewModel != null) {
                uGCRankingViewModel.n();
                return;
            }
            return;
        }
        UGCFilmListViewModel uGCFilmListViewModel = uGCFilmListFragment.viewModel;
        if (uGCFilmListViewModel != null) {
            uGCFilmListViewModel.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(UGCFilmListFragment uGCFilmListFragment, View view) {
        FragmentActivity activity = uGCFilmListFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(UGCFilmListFragment uGCFilmListFragment, String str) {
        TitleLayout titleLayout;
        TitleLayout titleLayout2;
        TnTextView titleView;
        CharSequence text;
        if (!uGCFilmListFragment.isRankingMode) {
            l lVar = (l) uGCFilmListFragment.getMViewBinding();
            String obj = (lVar == null || (titleLayout2 = lVar.g) == null || (titleView = titleLayout2.getTitleView()) == null || (text = titleView.getText()) == null) ? null : text.toString();
            if ((obj == null || obj.length() == 0) && str != null && str.length() > 0) {
                a.a.f(wf.a.a, "FilmListFragment", "filmListDescLiveData: set title from desc='" + str + "'", false, 4, (Object) null);
                uGCFilmListFragment.mFilmListTitle = str;
                l lVar2 = (l) uGCFilmListFragment.getMViewBinding();
                if (lVar2 != null && (titleLayout = lVar2.g) != null) {
                    titleLayout.setTitleText(str);
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(UGCFilmListFragment uGCFilmListFragment, List list) {
        List l;
        e eVar;
        List data;
        SwipeRefreshLayout swipeRefreshLayout;
        f h0;
        List data2;
        List data3;
        HashMap g;
        List data4;
        f h02;
        e eVar2;
        f h03;
        SwipeRefreshLayout swipeRefreshLayout2;
        if (list != null) {
            List list2 = list;
            l = new ArrayList(CollectionsKt.v(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                l.add(((UgcGenreTopRespGenreItem) it.next()).getUgcContent());
            }
        } else {
            l = CollectionsKt.l();
        }
        a.a aVar = wf.a.a;
        Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
        int size = l.size();
        boolean z = list == null;
        a.a.f(aVar, "FilmListFragment", "filmListLiveData: data received, rawItems=" + valueOf + ", flattened=" + size + ", isNull=" + z + ", isRankingMode=" + uGCFilmListFragment.isRankingMode, false, 4, (Object) null);
        if (!uGCFilmListFragment.isRankingMode) {
            uGCFilmListFragment.showContentView();
        }
        l lVar = (l) uGCFilmListFragment.getMViewBinding();
        if (lVar != null && (swipeRefreshLayout2 = lVar.f) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        e eVar3 = uGCFilmListFragment.mFilmListAdapter;
        if (eVar3 != null && (h02 = eVar3.h0()) != null && h02.r() && (eVar2 = uGCFilmListFragment.mFilmListAdapter) != null && (h03 = eVar2.h0()) != null) {
            h03.s();
        }
        if (list != null) {
            e eVar4 = uGCFilmListFragment.mFilmListAdapter;
            boolean z2 = (eVar4 == null || (data4 = eVar4.getData()) == null || !data4.isEmpty()) ? false : true;
            if (!uGCFilmListFragment.isRankingMode && z2 && !uGCFilmListFragment.hasRecordedFirstLoadDuration && uGCFilmListFragment.firstLoadStartTimeMillis > 0) {
                long currentTimeMillis = System.currentTimeMillis() - uGCFilmListFragment.firstLoadStartTimeMillis;
                qi.b logViewConfig = uGCFilmListFragment.getLogViewConfig();
                if (logViewConfig != null && (g = logViewConfig.g()) != null) {
                    g.put("load_duration", String.valueOf(currentTimeMillis));
                }
                uGCFilmListFragment.hasRecordedFirstLoadDuration = true;
            }
            int size2 = l.size();
            e eVar5 = uGCFilmListFragment.mFilmListAdapter;
            Integer valueOf2 = (eVar5 == null || (data3 = eVar5.getData()) == null) ? null : Integer.valueOf(data3.size());
            UGCFilmListViewModel uGCFilmListViewModel = uGCFilmListFragment.viewModel;
            a.a.f(aVar, "FilmListFragment", "filmListLiveData: received " + size2 + " contents, currentListSize=" + valueOf2 + ", hasMore=" + (uGCFilmListViewModel != null ? Boolean.valueOf(uGCFilmListViewModel.l()) : null), false, 4, (Object) null);
            UGCFilmListViewModel uGCFilmListViewModel2 = uGCFilmListFragment.viewModel;
            if (uGCFilmListViewModel2 == null || !uGCFilmListViewModel2.l()) {
                a.a.f(aVar, "FilmListFragment", "filmListLiveData: no more data, load more end", false, 4, (Object) null);
                e eVar6 = uGCFilmListFragment.mFilmListAdapter;
                if (eVar6 != null && (h0 = eVar6.h0()) != null) {
                    f.u(h0, false, 1, (Object) null);
                }
            }
            e eVar7 = uGCFilmListFragment.mFilmListAdapter;
            if (eVar7 == null || (data2 = eVar7.getData()) == null || !data2.isEmpty() || size2 != 0) {
                uGCFilmListFragment.K0(list);
            } else {
                a.a.f(aVar, "FilmListFragment", "filmListLiveData: empty data, isRankingMode=" + uGCFilmListFragment.isRankingMode, false, 4, (Object) null);
                if (!uGCFilmListFragment.isRankingMode) {
                    uGCFilmListFragment.showEmptyView(true);
                }
            }
            qi.b logViewConfig2 = uGCFilmListFragment.getLogViewConfig();
            if (logViewConfig2 != null) {
                logViewConfig2.k(true);
            }
        } else {
            aVar.i("FilmListFragment", "filmListLiveData: data is null, isRankingMode=" + uGCFilmListFragment.isRankingMode, true);
            l lVar2 = (l) uGCFilmListFragment.getMViewBinding();
            if (lVar2 != null && (swipeRefreshLayout = lVar2.f) != null) {
                swipeRefreshLayout.setRefreshing(false);
            }
            if (!uGCFilmListFragment.isRankingMode && (eVar = uGCFilmListFragment.mFilmListAdapter) != null && (data = eVar.getData()) != null && data.isEmpty()) {
                uGCFilmListFragment.showEmptyView(true);
            }
        }
        return Unit.a;
    }

    private final void G0(Cover cover) {
        String averageHueDark;
        Object obj;
        ImageView imageView;
        String str;
        String str2;
        Context activity = getActivity();
        if (activity == null) {
            return;
        }
        l lVar = (l) getMViewBinding();
        String str3 = BuildConfig.FLAVOR;
        if (lVar != null && (imageView = lVar.c) != null) {
            f.b m = ni.f.a.m(activity);
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b g = m.g(str);
            if (cover == null || (str2 = cover.getThumbnail()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            g.l(str2).d(imageView);
        }
        if (cover == null || (averageHueDark = cover.getAverageHueDark()) == null) {
            return;
        }
        Unit unit = null;
        if (StringsKt.c0(averageHueDark, Utils.SEPARATOR, false, 2, (Object) null)) {
            try {
                Result.Companion companion = Result.Companion;
                String averageHueDark2 = cover.getAverageHueDark();
                if (averageHueDark2 != null) {
                    str3 = averageHueDark2;
                }
                int parseColor = Color.parseColor(str3);
                xk.a aVar = this.headerMaskManager;
                if (aVar != null) {
                    aVar.a(Integer.valueOf(parseColor));
                    unit = Unit.a;
                }
                obj = Result.constructor-impl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th2));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                a.a.l(wf.a.a, "FilmListFragment", "initRecyclerView: parseColor failed, use default color", false, 4, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(final UGCFilmListFragment uGCFilmListFragment, final UGCRankAllData uGCRankAllData) {
        RecyclerView recyclerView;
        t6.f h0;
        Pager pager;
        List<UGCContent> items;
        a.a aVar = wf.a.a;
        Boolean bool = null;
        Integer valueOf = (uGCRankAllData == null || (items = uGCRankAllData.getItems()) == null) ? null : Integer.valueOf(items.size());
        if (uGCRankAllData != null && (pager = uGCRankAllData.getPager()) != null) {
            bool = pager.getHasMore();
        }
        a.a.f(aVar, "FilmListFragment", "loadMoreLiveData: received data, items size=" + valueOf + ", hasMore=" + bool, false, 4, (Object) null);
        if (uGCRankAllData == null) {
            a.a.x(aVar, "FilmListFragment", "loadMoreLiveData: data is null, load more failed", false, 4, (Object) null);
            e eVar = uGCFilmListFragment.mFilmListAdapter;
            if (eVar != null && (h0 = eVar.h0()) != null) {
                h0.v();
            }
        } else {
            List<UGCContent> items2 = uGCRankAllData.getItems();
            if (items2 == null) {
                items2 = CollectionsKt.l();
            }
            List<UGCContent> list = items2;
            a.a.f(aVar, "FilmListFragment", "loadMoreLiveData: add " + list.size() + " items to list", false, 4, (Object) null);
            e eVar2 = uGCFilmListFragment.mFilmListAdapter;
            if (eVar2 != null) {
                eVar2.q(list);
            }
            l lVar = (l) uGCFilmListFragment.getMViewBinding();
            if (lVar != null && (recyclerView = lVar.e) != null) {
                recyclerView.postDelayed(new Runnable() { // from class: uk.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        UGCFilmListFragment.J0(UGCFilmListFragment.this, uGCRankAllData);
                    }
                }, 300L);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(UGCFilmListFragment uGCFilmListFragment, UGCRankAllData uGCRankAllData) {
        t6.f h0;
        t6.f h02;
        e eVar;
        t6.f h03;
        e eVar2 = uGCFilmListFragment.mFilmListAdapter;
        if (eVar2 != null && (h02 = eVar2.h0()) != null && h02.r() && (eVar = uGCFilmListFragment.mFilmListAdapter) != null && (h03 = eVar.h0()) != null) {
            h03.s();
        }
        Pager pager = uGCRankAllData.getPager();
        if (pager != null ? Intrinsics.c(pager.getHasMore(), Boolean.TRUE) : false) {
            return;
        }
        a.a.f(wf.a.a, "FilmListFragment", "loadMoreLiveData: no more data, load more end", false, 4, (Object) null);
        e eVar3 = uGCFilmListFragment.mFilmListAdapter;
        if (eVar3 == null || (h0 = eVar3.h0()) == null) {
            return;
        }
        t6.f.u(h0, false, 1, (Object) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b9, code lost:
    
        if ((r5 != null ? r5.Q1() : false) != false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void K0(List filmList) {
        HashMap g;
        UGCVideo video;
        UGCVideo video2;
        UGCCollection collection;
        UGCVideo video3;
        Cover cover;
        List data;
        List data2;
        ArrayList arrayList = new ArrayList();
        Iterator it = filmList.iterator();
        while (it.hasNext()) {
            UGCContent ugcContent = ((UgcGenreTopRespGenreItem) it.next()).getUgcContent();
            if (ugcContent != null) {
                arrayList.add(ugcContent);
            }
        }
        e eVar = this.mFilmListAdapter;
        boolean z = false;
        r1 = 0;
        int i = 0;
        int size = (eVar == null || (data2 = eVar.getData()) == null) ? 0 : data2.size();
        UGCFilmListViewModel uGCFilmListViewModel = this.viewModel;
        boolean n = uGCFilmListViewModel != null ? uGCFilmListViewModel.n() : false;
        Cover cover2 = null;
        if (n || size == 0) {
            rk.b bVar = this.mExposureHelper;
            if (bVar != null) {
                bVar.e();
            }
            UGCContent uGCContent = (UGCContent) CollectionsKt.k0(arrayList);
            if (!Intrinsics.c((uGCContent == null || (video2 = uGCContent.getVideo()) == null) ? null : video2.getCategory(), UGCVideoType.EDUCATION.getValue())) {
                e eVar2 = this.mFilmListAdapter;
            }
            z = true;
            e eVar3 = this.mFilmListAdapter;
            if (eVar3 != null) {
                eVar3.R1(z);
            }
            e eVar4 = this.mFilmListAdapter;
            if (eVar4 != null) {
                eVar4.n1(arrayList);
            }
            qi.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g = logViewConfig.g()) != null) {
                UGCContent uGCContent2 = (UGCContent) CollectionsKt.k0(arrayList);
                g.put("ops", (uGCContent2 == null || (video = uGCContent2.getVideo()) == null) ? null : video.getOps());
            }
            a.a.f(wf.a.a, "FilmListFragment", "updateData: refresh or first load, replace data. size: " + size + " -> " + arrayList.size(), false, 4, (Object) null);
        } else {
            e eVar5 = this.mFilmListAdapter;
            if (eVar5 != null) {
                eVar5.q(arrayList);
            }
            e eVar6 = this.mFilmListAdapter;
            if (eVar6 != null && (data = eVar6.getData()) != null) {
                i = data.size();
            }
            a.a.f(wf.a.a, "FilmListFragment", "updateData: load more, add " + arrayList.size() + " items, list size: " + size + " -> " + i, false, 4, (Object) null);
        }
        if ((n || size == 0) && !arrayList.isEmpty()) {
            UGCContent uGCContent3 = (UGCContent) CollectionsKt.k0(arrayList);
            if (uGCContent3 != null && (video3 = uGCContent3.getVideo()) != null && (cover = video3.getCover()) != null) {
                cover2 = cover;
            } else if (uGCContent3 != null && (collection = uGCContent3.getCollection()) != null) {
                cover2 = collection.getCover();
            }
            a.a.f(wf.a.a, "FilmListFragment", "updateData: refresh or first load, set top ", false, 4, (Object) null);
            if (this.isRankingMode) {
                return;
            }
            G0(cover2);
        }
    }

    private final void reload() {
        if (yg.l.a.e()) {
            loadDefaultData();
        } else {
            showLoadingView();
            showNoNetworkViewDelayed();
        }
    }

    private final e x0() {
        e eVar = new e(new ArrayList(), this.mExposureHelper, this.isRankingMode, HomeTabId.INSTANCE.h(StringsKt.v(this.tabId), false) || StringsKt.H(UGCVideoType.EDUCATION.getValue(), this.videoType, true));
        eVar.h0().z(true);
        eVar.h0().y(true);
        eVar.h0().D(new r6.f() { // from class: uk.g
            public final void a() {
                UGCFilmListFragment.y0(UGCFilmListFragment.this);
            }
        });
        eVar.w1(new r6.d() { // from class: uk.h
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                UGCFilmListFragment.A0(UGCFilmListFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mFilmListAdapter = eVar;
        Intrinsics.e(eVar);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(final UGCFilmListFragment uGCFilmListFragment) {
        RecyclerView recyclerView;
        if (!yg.l.a.e()) {
            a.a.x(wf.a.a, "FilmListFragment", "initFilmListAdapter: no network, load more failed", false, 4, (Object) null);
            l lVar = (l) uGCFilmListFragment.getMViewBinding();
            if (lVar == null || (recyclerView = lVar.e) == null) {
                return;
            }
            recyclerView.postDelayed(new Runnable() { // from class: uk.i
                @Override // java.lang.Runnable
                public final void run() {
                    UGCFilmListFragment.z0(UGCFilmListFragment.this);
                }
            }, 300L);
            return;
        }
        a.a.f(wf.a.a, "FilmListFragment", "initFilmListAdapter: trigger load more, isRankingMode=" + uGCFilmListFragment.isRankingMode, false, 4, (Object) null);
        if (uGCFilmListFragment.isRankingMode) {
            UGCRankingViewModel uGCRankingViewModel = uGCFilmListFragment.rankingViewModel;
            if (uGCRankingViewModel != null) {
                uGCRankingViewModel.m();
                return;
            }
            return;
        }
        UGCFilmListViewModel uGCFilmListViewModel = uGCFilmListFragment.viewModel;
        if (uGCFilmListViewModel != null) {
            uGCFilmListViewModel.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(UGCFilmListFragment uGCFilmListFragment) {
        t6.f h0;
        e eVar = uGCFilmListFragment.mFilmListAdapter;
        if (eVar == null || (h0 = eVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    public final void H0(UGCRankingViewModel viewModel) {
        Intrinsics.h(viewModel, "viewModel");
        a.a.f(wf.a.a, "FilmListFragment", "setupRankingViewModel: setup ranking mode, disable self error handling", false, 4, (Object) null);
        this.rankingViewModel = viewModel;
        this.isRankingMode = true;
        viewModel.j().p(this);
        viewModel.j().j(this, new c(new Function1() { // from class: uk.d
            public final Object invoke(Object obj) {
                Unit I0;
                I0 = UGCFilmListFragment.I0(UGCFilmListFragment.this, (UGCRankAllData) obj);
                return I0;
            }
        }));
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L0(UGCRankAllData data, String rankCategory) {
        List<UGCContent> items;
        boolean z;
        e eVar;
        e eVar2;
        Pager pager;
        t6.f h0;
        l lVar;
        l lVar2;
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView;
        t6.f h02;
        t6.f h03;
        UGCContent uGCContent;
        UGCVideo video;
        HashMap g;
        List<UGCContent> items2;
        Intrinsics.h(rankCategory, "rankCategory");
        a.a aVar = wf.a.a;
        a.a.f(aVar, "FilmListFragment", "updateRankData: items size=" + ((data == null || (items2 = data.getItems()) == null) ? null : Integer.valueOf(items2.size())) + ", title=" + (data != null ? data.getTitle() : null), false, 4, (Object) null);
        this.isRankingMode = true;
        if (data == null || (items = data.getItems()) == null || items.isEmpty()) {
            this.rankingCategory = rankCategory;
            showEmptyView(false);
            a.a.x(aVar, "FilmListFragment", "updateRankData: data is null", false, 4, (Object) null);
            return;
        }
        rk.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
        this.rankingCategory = rankCategory;
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.m(false);
        }
        qi.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null) {
            logViewConfig2.k(true);
        }
        qi.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (g = logViewConfig3.g()) != null && this.isRankingMode) {
            g.put("rank_category", rankCategory);
        }
        List<UGCContent> items3 = data.getItems();
        a.a.f(aVar, "FilmListFragment", "updateRankData: items from " + (items3 != null ? Integer.valueOf(items3.size()) : null) + " ugcContent", false, 4, (Object) null);
        List<UGCContent> items4 = data.getItems();
        if (!Intrinsics.c((items4 == null || (uGCContent = (UGCContent) CollectionsKt.k0(items4)) == null || (video = uGCContent.getVideo()) == null) ? null : video.getCategory(), UGCVideoType.EDUCATION.getValue())) {
            e eVar3 = this.mFilmListAdapter;
            if (!(eVar3 != null ? eVar3.getIsEducationList() : false)) {
                z = false;
                eVar = this.mFilmListAdapter;
                if (eVar != null) {
                    eVar.R1(z);
                }
                eVar2 = this.mFilmListAdapter;
                if (eVar2 != null) {
                    eVar2.n1(data.getItems());
                }
                pager = data.getPager();
                if (pager == null ? Intrinsics.c(pager.getHasMore(), Boolean.TRUE) : false) {
                    a.a.f(aVar, "FilmListFragment", "updateRankData: no more data, load more end", false, 4, (Object) null);
                    e eVar4 = this.mFilmListAdapter;
                    if (eVar4 != null && (h0 = eVar4.h0()) != null) {
                        t6.f.u(h0, false, 1, (Object) null);
                    }
                } else {
                    a.a.f(aVar, "FilmListFragment", "updateRankData: has more data, enable load more", false, 4, (Object) null);
                    e eVar5 = this.mFilmListAdapter;
                    if (eVar5 != null && (h03 = eVar5.h0()) != null) {
                        h03.z(true);
                    }
                    e eVar6 = this.mFilmListAdapter;
                    if (eVar6 != null && (h02 = eVar6.h0()) != null) {
                        h02.y(true);
                    }
                }
                lVar = (l) getMViewBinding();
                if (lVar != null && (recyclerView = lVar.e) != null) {
                    recyclerView.scrollToPosition(0);
                }
                lVar2 = (l) getMViewBinding();
                if (lVar2 != null && (swipeRefreshLayout = lVar2.f) != null) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                showContentView();
            }
        }
        z = true;
        eVar = this.mFilmListAdapter;
        if (eVar != null) {
        }
        eVar2 = this.mFilmListAdapter;
        if (eVar2 != null) {
        }
        pager = data.getPager();
        if (pager == null ? Intrinsics.c(pager.getHasMore(), Boolean.TRUE) : false) {
        }
        lVar = (l) getMViewBinding();
        if (lVar != null) {
            recyclerView.scrollToPosition(0);
        }
        lVar2 = (l) getMViewBinding();
        if (lVar2 != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        showContentView();
    }

    public final String getPageName() {
        return this.isRankingMode ? "/home/ugc_ranking" : "/home/ugc_film_list";
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public final void hideLoading() {
        SwipeRefreshLayout swipeRefreshLayout;
        l lVar = (l) getMViewBinding();
        if (lVar == null || (swipeRefreshLayout = lVar.f) == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    public void initListener() {
    }

    public void initViewData() {
        TitleLayout titleLayout;
        SwipeRefreshLayout swipeRefreshLayout;
        View view;
        View view2;
        ImageView imageView;
        TitleLayout titleLayout2;
        if (this.isRankingMode) {
            a.a.f(wf.a.a, "FilmListFragment", "initViewData: onlyShowList mode, hide header views", false, 4, (Object) null);
            l lVar = (l) getMViewBinding();
            if (lVar != null && (titleLayout2 = lVar.g) != null) {
                uf.c.g(titleLayout2);
            }
            l lVar2 = (l) getMViewBinding();
            if (lVar2 != null && (imageView = lVar2.c) != null) {
                uf.c.g(imageView);
            }
            l lVar3 = (l) getMViewBinding();
            if (lVar3 != null && (view2 = lVar3.d) != null) {
                uf.c.g(view2);
            }
            l lVar4 = (l) getMViewBinding();
            if (lVar4 != null && (view = lVar4.b) != null) {
                uf.c.g(view);
            }
            l lVar5 = (l) getMViewBinding();
            if (lVar5 != null && (swipeRefreshLayout = lVar5.f) != null) {
                ViewGroup.LayoutParams layoutParams = swipeRefreshLayout.getLayoutParams();
                ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
                if (bVar != null) {
                    bVar.i = 0;
                    swipeRefreshLayout.setLayoutParams(bVar);
                }
            }
        } else {
            l lVar6 = (l) getMViewBinding();
            if (lVar6 != null && (titleLayout = lVar6.g) != null) {
                titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: uk.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        UGCFilmListFragment.D0(UGCFilmListFragment.this, view3);
                    }
                });
                h hVar = h.a;
                Context context = titleLayout.getContext();
                Intrinsics.g(context, "getContext(...)");
                titleLayout.setPadding(0, hVar.d(context), 0, 0);
                titleLayout.setTitleTextColor(titleLayout.getResources().getColor(R.color.white_100));
                titleLayout.setTitleText(this.mFilmListTitle);
                titleLayout.setTitleMaxWidth(Integer.MAX_VALUE);
            }
            l lVar7 = (l) getMViewBinding();
            ImageView imageView2 = lVar7 != null ? lVar7.c : null;
            l lVar8 = (l) getMViewBinding();
            this.headerMaskManager = new xk.a(imageView2, lVar8 != null ? lVar8.b : null);
            pageStateFitStatusBar();
        }
        B0();
    }

    public void initViewModel() {
        b0 k;
        b0 j;
        if (this.isRankingMode) {
            a.a.f(wf.a.a, "FilmListFragment", "initViewModel: ranking mode, skip init self viewmodel", false, 4, (Object) null);
            return;
        }
        UGCFilmListViewModel a = new v0(this).a(UGCFilmListViewModel.class);
        this.viewModel = a;
        if (a != null) {
            a.m(this.filmType);
        }
        a.a.f(wf.a.a, "FilmListFragment", "initViewModel: ViewModel initialized with filmListId=" + this.filmType, false, 4, (Object) null);
        if (!this.hasRecordedFirstLoadDuration && this.firstLoadStartTimeMillis == 0) {
            this.firstLoadStartTimeMillis = System.currentTimeMillis();
        }
        UGCFilmListViewModel uGCFilmListViewModel = this.viewModel;
        if (uGCFilmListViewModel != null && (j = uGCFilmListViewModel.j()) != null) {
            j.j(this, new c(new Function1() { // from class: uk.b
                public final Object invoke(Object obj) {
                    Unit E0;
                    E0 = UGCFilmListFragment.E0(UGCFilmListFragment.this, (String) obj);
                    return E0;
                }
            }));
        }
        UGCFilmListViewModel uGCFilmListViewModel2 = this.viewModel;
        if (uGCFilmListViewModel2 == null || (k = uGCFilmListViewModel2.k()) == null) {
            return;
        }
        k.j(this, new c(new Function1() { // from class: uk.c
            public final Object invoke(Object obj) {
                Unit F0;
                F0 = UGCFilmListFragment.F0(UGCFilmListFragment.this, (List) obj);
                return F0;
            }
        }));
    }

    public boolean isMonitorNetworkState() {
        return true;
    }

    public void loadDefaultData() {
        a.a aVar = wf.a.a;
        a.a.f(aVar, "FilmListFragment", "loadDefaultData: start loading default data, isRankingMode=" + this.isRankingMode, false, 4, (Object) null);
        if (this.isRankingMode) {
            a.a.f(aVar, "FilmListFragment", "loadDefaultData: ranking mode, skip self loading", false, 4, (Object) null);
            return;
        }
        if (!yg.l.a.e()) {
            a.a.x(aVar, "FilmListFragment", "loadDefaultData: no network available", false, 4, (Object) null);
            return;
        }
        showLoadingView();
        if (!this.hasRecordedFirstLoadDuration && this.firstLoadStartTimeMillis == 0) {
            this.firstLoadStartTimeMillis = System.currentTimeMillis();
        }
        UGCFilmListViewModel uGCFilmListViewModel = this.viewModel;
        if (uGCFilmListViewModel != null) {
            uGCFilmListViewModel.p();
        }
    }

    public qi.b newLogViewConfig() {
        return new qi.b(getPageName(), false, 2, null);
    }

    public void onDestroy() {
        super.onDestroy();
        rk.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
        this.mExposureHelper = null;
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

    public void onPause() {
        super.onPause();
        rk.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void receiveArguments() {
        HashMap g;
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("tabId", "0");
            Intrinsics.g(string, "getString(...)");
            this.tabId = string;
            String string2 = arguments.getString("filmType", BuildConfig.FLAVOR);
            Intrinsics.g(string2, "getString(...)");
            this.filmType = string2;
            String string3 = arguments.getString("filmListTitle", BuildConfig.FLAVOR);
            Intrinsics.g(string3, "getString(...)");
            this.mFilmListTitle = string3;
            this.isRankingMode = arguments.getBoolean("onlyShowList", false);
            String string4 = arguments.getString("videoType", BuildConfig.FLAVOR);
            Intrinsics.g(string4, "getString(...)");
            this.videoType = string4;
            String string5 = arguments.getString("fromOptId", BuildConfig.FLAVOR);
            Intrinsics.g(string5, "getString(...)");
            this.fromOptId = string5;
        }
        a.a.f(wf.a.a, "FilmListFragment", "receiveArguments: filmListId=" + this.filmType + ", title=" + this.mFilmListTitle + ", cover=" + this.mFilmListCover + ", onlyShowList=" + this.isRankingMode, false, 4, (Object) null);
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g = logViewConfig.g()) == null) {
            return;
        }
        g.put("page_from", qi.h.a.h());
    }

    public void retryLoadData() {
        List data;
        a.a aVar = wf.a.a;
        a.a.f(aVar, "FilmListFragment", "retryLoadData: retry loading data, isRankingMode=" + this.isRankingMode, false, 4, (Object) null);
        if (this.isRankingMode) {
            a.a.f(aVar, "FilmListFragment", "retryLoadData: ranking mode, skip self retry", false, 4, (Object) null);
            return;
        }
        e eVar = this.mFilmListAdapter;
        if (eVar != null && (data = eVar.getData()) != null && data.isEmpty()) {
            reload();
            return;
        }
        e eVar2 = this.mFilmListAdapter;
        if (eVar2 == null || eVar2.h0().i() != LoadMoreStatus.Fail) {
            return;
        }
        eVar2.h0().w();
    }

    public final void startLoading() {
        SwipeRefreshLayout swipeRefreshLayout;
        l lVar = (l) getMViewBinding();
        if (lVar == null || (swipeRefreshLayout = lVar.f) == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(true);
    }

    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public l getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        l c2 = l.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
