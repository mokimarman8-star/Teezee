package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.flow.bean.LayoutStyle;
import com.transsion.flow.bean.PlayUrl;
import com.transsion.flow.bean.RoomEntranceResponse;
import com.transsion.flow.bean.SubjectGameInfo;
import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.adapter.ForYouEduAdapter;
import com.transsion.moviedetail.view.ForYouLoadMoreView;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectDl;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsnet.downloader.DownloadManagerApi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import wf.a;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 ~2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002KOB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u001f\u0010\u0013\u001a\u00020\n2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00152\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u0005J\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0011H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\nH\u0002¢\u0006\u0004\b*\u0010\u0005J\u000f\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020+H\u0016¢\u0006\u0004\b2\u0010-J\u000f\u00104\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\nH\u0016¢\u0006\u0004\b6\u0010\u0005J\u000f\u00107\u001a\u00020\nH\u0016¢\u0006\u0004\b7\u0010\u0005J\u000f\u00108\u001a\u00020\nH\u0016¢\u0006\u0004\b8\u0010\u0005J\u000f\u00109\u001a\u00020\nH\u0016¢\u0006\u0004\b9\u0010\u0005J\u000f\u0010:\u001a\u00020\nH\u0016¢\u0006\u0004\b:\u0010\u0005J\u000f\u0010;\u001a\u00020\nH\u0016¢\u0006\u0004\b;\u0010\u0005J\u000f\u0010<\u001a\u00020\nH\u0016¢\u0006\u0004\b<\u0010\u0005J\u0017\u0010?\u001a\u00020>2\u0006\u0010=\u001a\u000203H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020>2\u0006\u0010=\u001a\u000203H\u0016¢\u0006\u0004\bA\u0010@J\u0017\u0010C\u001a\u00020\n2\u0006\u0010B\u001a\u000203H\u0016¢\u0006\u0004\bC\u0010DJ\u000f\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001a\u00020\n2\u0006\u0010H\u001a\u000203H\u0016¢\u0006\u0004\bI\u0010DR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR*\u0010Z\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010+0Vj\n\u0012\u0006\u0012\u0004\u0018\u00010+`W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010\\R\u001b\u0010e\u001a\u00020`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR$\u0010h\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010m\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010jR\u0018\u0010'\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010q\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010jR\u0018\u0010t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010w\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010vR\u0016\u0010{\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010vR\u0016\u0010}\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010v¨\u0006\u007f"}, d2 = {"Lcom/transsion/moviedetail/fragment/ForYouFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Llm/f;", "Lwv/b;", "<init>", "()V", BuildConfig.FLAVOR, "z0", "()I", "y0", BuildConfig.FLAVOR, "I0", "x0", "initExposureHelper", "C0", "lazyLoadData", BuildConfig.FLAVOR, "Lcom/transsion/moviedetailapi/bean/Subject;", "list", "M0", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "newList", "currentItemCount", "J0", "(Ljava/util/List;I)Ljava/util/List;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "u0", "()Lcom/chad/library/adapter/base/BaseQuickAdapter;", "s0", "item", "B0", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "position", BuildConfig.FLAVOR, "duration", "K0", "(IJ)V", "subject", "L0", "(ILcom/transsion/moviedetailapi/bean/Subject;)V", "localLogPause", BuildConfig.FLAVOR, "pageName", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "A0", "(Landroid/view/LayoutInflater;)Llm/f;", "getPageStateLayoutTitle", BuildConfig.FLAVOR, "isAudioShowNoNetworkLayout", "()Z", "initViewData", "initViewModel", "initListener", "retryLoadData", "onPause", "onResume", "onDestroy", "isShowTitleLayout", "Landroid/view/View;", "getLocalNoNetworkView", "(Z)Landroid/view/View;", "getEmptyView", "hidden", "onHiddenChanged", "(Z)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "fullscreen", "onScreenChange", "Lbj/b;", "a", "Lbj/b;", "mExposureHelper", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "refreshProgress", "Lcom/transsion/moviedetail/fragment/ForYouFragment$b;", "c", "Lcom/transsion/moviedetail/fragment/ForYouFragment$b;", "listExposureCtrl", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "d", "Ljava/util/HashSet;", "subjectIdSet", "e", "I", "pageIndex", "f", "totalRequestCount", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "g", "Lkotlin/Lazy;", "w0", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", "h", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "forYouAdapter", "i", "Ljava/lang/String;", "curPageName", "j", "curOps", "k", "Lcom/transsion/moviedetailapi/bean/Subject;", "l", "subjectId", "m", "Ljava/lang/Integer;", "subjectType", "n", "Z", "isLocalVideo", "o", "isOutsideVideo", "p", "loading", "q", "isFirst", "r", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ForYouFragment extends PageStatusFragment<lm.f> implements wv.b {

    /* renamed from: r, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String s = "sa_detail_for_you_insert_posts";

    /* renamed from: a, reason: from kotlin metadata */
    private bj.b mExposureHelper;

    /* renamed from: b, reason: from kotlin metadata */
    private ImageView refreshProgress;

    /* renamed from: c, reason: from kotlin metadata */
    private b listExposureCtrl;

    /* renamed from: h, reason: from kotlin metadata */
    private BaseQuickAdapter forYouAdapter;

    /* renamed from: i, reason: from kotlin metadata */
    private String curPageName;

    /* renamed from: j, reason: from kotlin metadata */
    private String curOps;

    /* renamed from: k, reason: from kotlin metadata */
    private Subject subject;

    /* renamed from: l, reason: from kotlin metadata */
    private String subjectId;

    /* renamed from: m, reason: from kotlin metadata */
    private Integer subjectType;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean isLocalVideo;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean isOutsideVideo;

    /* renamed from: p, reason: from kotlin metadata */
    private boolean loading;

    /* renamed from: d, reason: from kotlin metadata */
    private HashSet subjectIdSet = new HashSet();

    /* renamed from: e, reason: from kotlin metadata */
    private int pageIndex = 1;

    /* renamed from: f, reason: from kotlin metadata */
    private int totalRequestCount = 30;

    /* renamed from: g, reason: from kotlin metadata */
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.ForYouFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final androidx.lifecycle.x0 m37invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.fragment.ForYouFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m38invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: q, reason: from kotlin metadata */
    private boolean isFirst = true;

    /* renamed from: com.transsion.moviedetail.fragment.ForYouFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ForYouFragment a(Subject subject, String str, String str2, boolean z, boolean z2) {
            ForYouFragment forYouFragment = new ForYouFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("subject", subject);
            bundle.putString("ops", str);
            bundle.putString("page_name", str2);
            bundle.putBoolean("isLocalVideo", z);
            bundle.putBoolean("isOutsideVideo", z2);
            forYouFragment.setArguments(bundle);
            return forYouFragment;
        }
    }

    private static final class b {
        private final RecyclerView a;
        private final Function2 b;
        private final SparseArray c;
        private int d;
        private int e;
        private int f;
        private List g;
        private int h;

        public b(RecyclerView recyclerView, Function2 function2) {
            Intrinsics.h(recyclerView, "recyclerView");
            Intrinsics.h(function2, "callback");
            this.a = recyclerView;
            this.b = function2;
            this.c = new SparseArray();
            this.d = -1;
            this.e = -1;
            this.f = 3;
            List emptyList = Collections.emptyList();
            Intrinsics.g(emptyList, "emptyList(...)");
            this.g = emptyList;
            this.h = com.blankj.utilcode.util.i.e(40.0f);
        }

        private final void b(int i) {
            a.a.r(wf.a.a, "Foryou", new String[]{"reportItemView line:" + i}, false, 4, (Object) null);
            Long l = (Long) this.c.get(i);
            if (l != null) {
                long longValue = l.longValue();
                if (longValue > 0) {
                    int i2 = this.f;
                    int i3 = i2 * (i + 1);
                    for (int i4 = i2 * i; i4 < i3; i4++) {
                        this.b.invoke(Integer.valueOf(i4), Long.valueOf(SystemClock.elapsedRealtime() - longValue));
                    }
                }
            }
        }

        public final void a() {
            IntIterator a = androidx.core.util.k.a(this.c);
            while (a.hasNext()) {
                b(((Number) a.next()).intValue());
            }
            this.c.clear();
        }

        public final void c() {
            d(this.d, this.e);
        }

        public final void d(int i, int i2) {
            if (i < 0 || i2 < 0) {
                return;
            }
            this.d = i;
            this.e = i2;
            a.a.r(wf.a.a, "Foryou", new String[]{"scrollWithLine startLine:" + i + ", endLine:" + i2}, false, 4, (Object) null);
            ArrayList arrayList = new ArrayList();
            IntIterator a = androidx.core.util.k.a(this.c);
            while (a.hasNext()) {
                int intValue = ((Number) a.next()).intValue();
                int i3 = this.d;
                if (intValue >= this.e || i3 > intValue) {
                    b(intValue);
                    arrayList.add(Integer.valueOf(intValue));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.c.remove(((Number) it.next()).intValue());
            }
            int i4 = this.e;
            for (int i5 = this.d; i5 < i4; i5++) {
                if (((Long) this.c.get(i5)) == null) {
                    this.c.put(i5, Long.valueOf(SystemClock.elapsedRealtime()));
                }
            }
        }

        public final void e(List list) {
            a();
            if (list == null) {
                list = Collections.emptyList();
                Intrinsics.g(list, "emptyList(...)");
            }
            this.g = list;
        }
    }

    public static final class c implements bj.a {
        c() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            ForYouFragment forYouFragment = ForYouFragment.this;
            try {
                Result.Companion companion = Result.Companion;
                forYouFragment.K0(i, j);
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
    }

    public static final class d extends RecyclerView.l {
        d() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(rect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            if (recyclerView.getChildAdapterPosition(view) == -1) {
                return;
            }
            rect.set(lj.a.b(4), lj.a.b(8), lj.a.b(4), 0);
        }
    }

    static final class e implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        e(Function1 function1) {
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

    private final void B0(Subject item) {
        String playUrl;
        String playUrl2;
        Integer subjectType = item.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        if (subjectType != null && subjectType.intValue() == value) {
            DownloadManagerApi a = DownloadManagerApi.j.a();
            FragmentActivity context = getContext();
            Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            DownloadManagerApi.e0(a, context, "subjectdetail", BuildConfig.FLAVOR, item.getOps(), "download_subject", false, item, (String) null, (Boolean) null, 384, (Object) null);
            return;
        }
        if (item.isJumpBrowser()) {
            PlayUrl playUrl3 = item.getPlayUrl();
            if (playUrl3 == null || (playUrl2 = playUrl3.getPlayUrl()) == null) {
                return;
            }
            ij.k.i(playUrl2);
            return;
        }
        if (!item.isJumpWebview()) {
            Navigator c2 = TheRouter.c("/movie/detail");
            Integer subjectType2 = item.getSubjectType();
            Navigator.x(c2.F("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).K("ops", item.getOps()).K("id", item.getSubjectId()), requireContext(), (mf.c) null, 2, (Object) null);
        } else {
            PlayUrl playUrl4 = item.getPlayUrl();
            if (playUrl4 == null || (playUrl = playUrl4.getPlayUrl()) == null) {
                return;
            }
            ij.k.h(playUrl, null, 1, null);
        }
    }

    private final void C0() {
        Integer num = this.subjectType;
        int value = SubjectType.EDUCATION.getValue();
        if (num != null && num.intValue() == value) {
            kotlinx.coroutines.i.d(androidx.lifecycle.v.a(this), (CoroutineContext) null, (CoroutineStart) null, new ForYouFragment$initData$1(this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(ForYouFragment forYouFragment) {
        forYouFragment.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(ForYouFragment forYouFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Subject subject;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        BaseQuickAdapter baseQuickAdapter2 = forYouFragment.forYouAdapter;
        if (baseQuickAdapter2 == null || (subject = (Subject) baseQuickAdapter2.getItem(i)) == null) {
            return;
        }
        Integer subjectType = subject.getSubjectType();
        if (subjectType == null || subjectType.intValue() != -9901) {
            forYouFragment.B0(subject);
        }
        forYouFragment.L0(i, subject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(ForYouFragment forYouFragment, int i, long j) {
        try {
            forYouFragment.K0(i, j);
        } catch (Exception unused) {
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(RoomEntranceResponse roomEntranceResponse) {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(ForYouFragment forYouFragment, List list) {
        forYouFragment.M0(list);
        return Unit.a;
    }

    private final void I0() {
        boolean z = false;
        if (this.isLocalVideo) {
            MovieDetailViewModel w0 = w0();
            boolean z2 = this.isOutsideVideo;
            String str = this.subjectId;
            Integer num = this.subjectType;
            int i = this.pageIndex + 1;
            this.pageIndex = i;
            Context context = getContext();
            w0.s(z2, str, num, i, context != null && com.transsion.baseui.util.b.a(context));
            return;
        }
        MovieDetailViewModel w02 = w0();
        String str2 = this.subjectId;
        Integer num2 = this.subjectType;
        int i2 = this.pageIndex + 1;
        this.pageIndex = i2;
        Context context2 = getContext();
        if (context2 != null && com.transsion.baseui.util.b.a(context2)) {
            z = true;
        }
        w02.t(str2, num2, i2, z);
    }

    private final List J0(List newList, int currentItemCount) {
        int z0;
        if (w0().B() && currentItemCount <= (z0 = z0()) && newList.size() > z0) {
            a.a.f(wf.a.a, "MovieDetailViewModel", "ForYouFragment 插入推荐帖子", false, 4, (Object) null);
            Subject subject = new Subject((String) null, (Integer) null, (String) null, (String) null, (Cover) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -1, 67108863, (DefaultConstructorMarker) null);
            subject.setSubjectType(Integer.valueOf(com.transsion.moviedetail.adapter.c.I));
            newList.add(z0, subject);
        }
        return newList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0(int position, long duration) {
        Subject subject;
        a.a.f(wf.a.a, "Foryou", "reportBrowseEvent position:" + position + ", duration:" + duration + " ", false, 4, (Object) null);
        BaseQuickAdapter baseQuickAdapter = this.forYouAdapter;
        if (baseQuickAdapter == null || (subject = (Subject) baseQuickAdapter.getItem(position)) == null) {
            return;
        }
        Integer subjectType = subject.getSubjectType();
        if ((subjectType != null && subjectType.intValue() == -9901) || !this.subjectIdSet.add(subject.getSubjectId())) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "subject");
        linkedHashMap.put("opt_type", BuildConfig.FLAVOR);
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("subject_id", subjectId);
        linkedHashMap.put("group_id", BuildConfig.FLAVOR);
        String ops = subject.getOps();
        if (ops == null) {
            ops = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("ops", ops);
        Boolean hasResource = subject.getHasResource();
        linkedHashMap.put("has_resource", String.valueOf(hasResource != null ? hasResource.booleanValue() : false));
        linkedHashMap.put("deeplink", BuildConfig.FLAVOR);
        linkedHashMap.put("position", String.valueOf(position));
        linkedHashMap.put("cover", BuildConfig.FLAVOR);
        linkedHashMap.put("browse_duration", String.valueOf(duration));
        linkedHashMap.put("builtin", "0");
        linkedHashMap.put("tab_name", "for_you");
        com.transsion.baselib.helper.a.a.e("subjectdetail", linkedHashMap);
    }

    private final void L0(int position, Subject subject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "subject");
        linkedHashMap.put("item_type", "subject");
        String str = BuildConfig.FLAVOR;
        linkedHashMap.put("opt_type", BuildConfig.FLAVOR);
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        linkedHashMap.put("subject_id", subjectId);
        String ops = subject.getOps();
        if (ops != null) {
            str = ops;
        }
        linkedHashMap.put("ops", str);
        Boolean hasResource = subject.getHasResource();
        linkedHashMap.put("has_resource", String.valueOf(hasResource != null ? hasResource.booleanValue() : false));
        linkedHashMap.put("position", String.valueOf(position));
        linkedHashMap.put("builtin", "0");
        linkedHashMap.put("tab_name", "for_you");
        com.transsion.baselib.helper.a.a.f("subjectdetail", linkedHashMap);
    }

    private final void M0(List list) {
        List data;
        BaseQuickAdapter baseQuickAdapter;
        t6.f h0;
        List l;
        t6.f h02;
        t6.f h03;
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        qi.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null) {
            logViewConfig2.n(this.curOps);
        }
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            a.a.f(wf.a.a, "MovieDetailViewModel", "ForYouFragment 没有更多数据了，加载更多结束", false, 4, (Object) null);
            BaseQuickAdapter baseQuickAdapter2 = this.forYouAdapter;
            if (baseQuickAdapter2 != null && (h0 = baseQuickAdapter2.h0()) != null) {
                h0.t(false);
            }
            BaseQuickAdapter baseQuickAdapter3 = this.forYouAdapter;
            if (baseQuickAdapter3 != null && (data = baseQuickAdapter3.getData()) != null && data.isEmpty() && (baseQuickAdapter = this.forYouAdapter) != null) {
                baseQuickAdapter.Y0(getEmptyView(false));
            }
        } else {
            BaseQuickAdapter baseQuickAdapter4 = this.forYouAdapter;
            if (baseQuickAdapter4 == null || (l = baseQuickAdapter4.getData()) == null) {
                l = CollectionsKt.l();
            }
            List list3 = l;
            ArrayList arrayList = new ArrayList(CollectionsKt.v(list3, 10));
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(((Subject) it.next()).getSubjectId());
            }
            Set W0 = CollectionsKt.W0(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (!W0.contains(((Subject) obj).getSubjectId())) {
                    arrayList2.add(obj);
                }
            }
            BaseQuickAdapter baseQuickAdapter5 = this.forYouAdapter;
            int itemCount = baseQuickAdapter5 != null ? baseQuickAdapter5.getItemCount() : 0;
            if (arrayList2.isEmpty() || itemCount >= this.totalRequestCount) {
                a.a.f(wf.a.a, "MovieDetailViewModel", "ForYouFragment 全部去重或超出最大上限，加载更多结束 totalCount:" + itemCount, false, 4, (Object) null);
                BaseQuickAdapter baseQuickAdapter6 = this.forYouAdapter;
                if (baseQuickAdapter6 != null && (h02 = baseQuickAdapter6.h0()) != null) {
                    h02.t(false);
                }
            } else {
                a.a.f(wf.a.a, "MovieDetailViewModel", "ForYouFragment count: " + (arrayList2.size() + itemCount), false, 4, (Object) null);
                List J0 = J0(CollectionsKt.U0(arrayList2), itemCount);
                BaseQuickAdapter baseQuickAdapter7 = this.forYouAdapter;
                if (baseQuickAdapter7 != null && (h03 = baseQuickAdapter7.h0()) != null) {
                    h03.s();
                }
                BaseQuickAdapter baseQuickAdapter8 = this.forYouAdapter;
                if (baseQuickAdapter8 != null) {
                    baseQuickAdapter8.q(J0);
                }
                b bVar = this.listExposureCtrl;
                if (bVar != null) {
                    bVar.e(J0);
                }
            }
        }
        s0();
        this.loading = false;
    }

    private final void initExposureHelper() {
        RecyclerView recyclerView;
        bj.b bVar = new bj.b(0.6f, new c(), false, 4, null);
        bVar.n(2);
        lm.f fVar = (lm.f) getMViewBinding();
        if (fVar != null && (recyclerView = fVar.b) != null) {
            recyclerView.addOnScrollListener(bVar);
        }
        this.mExposureHelper = bVar;
    }

    private final void lazyLoadData() {
        String value;
        if (getParentFragment() != null) {
            w0().A().j(this, new e(new Function1() { // from class: com.transsion.moviedetail.fragment.b
                public final Object invoke(Object obj) {
                    Unit H0;
                    H0 = ForYouFragment.H0(ForYouFragment.this, (List) obj);
                    return H0;
                }
            }));
            boolean z = false;
            if (this.isLocalVideo) {
                if (!yg.l.a.e()) {
                    BaseQuickAdapter baseQuickAdapter = this.forYouAdapter;
                    if (baseQuickAdapter != null) {
                        baseQuickAdapter.Y0(getLocalNoNetworkView(false));
                        return;
                    }
                    return;
                }
                MovieDetailViewModel w0 = w0();
                boolean z2 = this.isOutsideVideo;
                String str = this.subjectId;
                Integer num = this.subjectType;
                Context context = getContext();
                w0.s(z2, str, num, 0, context != null && com.transsion.baseui.util.b.a(context));
            }
            ConfigBean d2 = cm.f.d(cm.f.c.a(), s, false, 2, (Object) null);
            if (d2 != null && (value = d2.getValue()) != null) {
                z = Boolean.parseBoolean(value);
            }
            if (!z || !ep.k.a.b() || this.isLocalVideo || this.isOutsideVideo) {
                return;
            }
            Integer num2 = this.subjectType;
            int value2 = SubjectType.TV.getValue();
            if (num2 == null || num2.intValue() != value2) {
                Integer num3 = this.subjectType;
                int value3 = SubjectType.MOVIE.getValue();
                if (num3 == null || num3.intValue() != value3) {
                    return;
                }
            }
            a.a.f(wf.a.a, "MovieDetailViewModel", "ForYouFragment 请求推荐帖子------", false, 4, (Object) null);
            w0().J();
        }
    }

    private final void localLogPause() {
        bj.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    private final String pageName() {
        String str = this.curPageName;
        return str == null ? BuildConfig.FLAVOR : str;
    }

    private final void s0() {
        ViewPropertyAnimator animate;
        ImageView imageView = this.refreshProgress;
        if (imageView == null || (animate = imageView.animate()) == null) {
            return;
        }
        animate.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(ForYouFragment forYouFragment, View view) {
        forYouFragment.retryLoadData();
    }

    private final BaseQuickAdapter u0() {
        Integer num = this.subjectType;
        int value = SubjectType.EDUCATION.getValue();
        if (num != null && num.intValue() == value) {
            return new ForYouEduAdapter(new ArrayList());
        }
        String str = this.curPageName;
        if (str == null) {
            str = "subjectdetail";
        }
        return new com.transsion.moviedetail.adapter.c(this, str, z0(), w0(), this.subject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(ForYouFragment forYouFragment, View view) {
        forYouFragment.retryLoadData();
    }

    private final MovieDetailViewModel w0() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    private final int x0() {
        Integer num = this.subjectType;
        int value = SubjectType.MUSIC.getValue();
        if (num == null || num.intValue() != value) {
            Integer num2 = this.subjectType;
            int value2 = SubjectType.EDUCATION.getValue();
            if (num2 == null || num2.intValue() != value2) {
                return 6;
            }
        }
        return 4;
    }

    private final int y0() {
        Integer v;
        ConfigBean c2 = cm.f.c.a().c("sa_for_you_request_count", true);
        String value = c2 != null ? c2.getValue() : null;
        if (value == null || value.length() == 0 || (v = StringsKt.v(value)) == null) {
            return 30;
        }
        return v.intValue();
    }

    private final int z0() {
        if (this.subject == null) {
            return 3;
        }
        Integer num = this.subjectType;
        int value = SubjectType.MUSIC.getValue();
        if (num != null && num.intValue() == value) {
            return 2;
        }
        Integer num2 = this.subjectType;
        int value2 = SubjectType.EDUCATION.getValue();
        if (num2 != null && num2.intValue() == value2) {
            return 2;
        }
        Subject subject = this.subject;
        Intrinsics.e(subject);
        LayoutStyle style = subject.getStyle();
        if (style != null) {
            return style.getColNum();
        }
        return 3;
    }

    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public lm.f getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        lm.f c2 = lm.f.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public View getEmptyView(boolean isShowTitleLayout) {
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_state_view, (ViewGroup) null);
        lm.y a = lm.y.a(inflate);
        Intrinsics.g(a, "bind(...)");
        a.b.setImageResource(R.mipmap.ic_no_content);
        a.c.setText(inflate.getResources().getString(R.string.no_content));
        a.d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForYouFragment.t0(ForYouFragment.this, view);
            }
        });
        Intrinsics.g(inflate, "apply(...)");
        return inflate;
    }

    public View getLocalNoNetworkView(boolean isShowTitleLayout) {
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_state_view, (ViewGroup) null);
        lm.y a = lm.y.a(inflate);
        Intrinsics.g(a, "bind(...)");
        a.d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForYouFragment.v0(ForYouFragment.this, view);
            }
        });
        Intrinsics.g(inflate, "apply(...)");
        return inflate;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
        initExposureHelper();
    }

    public void initViewData() {
        HashMap g;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        qi.b logViewConfig;
        HashMap g2;
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("subject") : null;
        this.subject = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments2 = getArguments();
        this.curPageName = arguments2 != null ? arguments2.getString("page_name") : null;
        Bundle arguments3 = getArguments();
        this.curOps = arguments3 != null ? arguments3.getString("ops") : null;
        Bundle arguments4 = getArguments();
        this.isLocalVideo = arguments4 != null ? arguments4.getBoolean("isLocalVideo") : false;
        Bundle arguments5 = getArguments();
        this.isOutsideVideo = arguments5 != null ? arguments5.getBoolean("isOutsideVideo") : false;
        this.totalRequestCount = y0();
        Subject subject = this.subject;
        this.subjectId = subject != null ? subject.getSubjectId() : null;
        Subject subject2 = this.subject;
        this.subjectType = subject2 != null ? subject2.getSubjectType() : null;
        String str = this.subjectId;
        if (str != null && (logViewConfig = getLogViewConfig()) != null && (g2 = logViewConfig.g()) != null) {
        }
        BaseQuickAdapter u0 = u0();
        t6.f h0 = u0.h0();
        h0.C(new ForYouLoadMoreView());
        h0.z(true);
        h0.y(true);
        h0.E(x0());
        h0.D(new r6.f() { // from class: com.transsion.moviedetail.fragment.e
            public final void a() {
                ForYouFragment.D0(ForYouFragment.this);
            }
        });
        u0.w1(new r6.d() { // from class: com.transsion.moviedetail.fragment.f
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ForYouFragment.E0(ForYouFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.forYouAdapter = u0;
        lm.f fVar = (lm.f) getMViewBinding();
        if (fVar != null && (recyclerView2 = fVar.b) != null) {
            recyclerView2.addItemDecoration(new d());
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(z0(), 1);
            staggeredGridLayoutManager.f0(2);
            recyclerView2.setLayoutManager(staggeredGridLayoutManager);
            recyclerView2.setAdapter(this.forYouAdapter);
        }
        lm.f fVar2 = (lm.f) getMViewBinding();
        if (fVar2 != null && (recyclerView = fVar2.b) != null) {
            this.listExposureCtrl = new b(recyclerView, new Function2() { // from class: com.transsion.moviedetail.fragment.g
                public final Object invoke(Object obj, Object obj2) {
                    Unit F0;
                    F0 = ForYouFragment.F0(ForYouFragment.this, ((Integer) obj).intValue(), ((Long) obj2).longValue());
                    return F0;
                }
            });
        }
        C0();
        qi.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 == null || (g = logViewConfig2.g()) == null) {
            return;
        }
    }

    public void initViewModel() {
        w0().I().j(this, new e(new Function1() { // from class: com.transsion.moviedetail.fragment.d
            public final Object invoke(Object obj) {
                Unit G0;
                G0 = ForYouFragment.G0((RoomEntranceResponse) obj);
                return G0;
            }
        }));
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public qi.b newLogViewConfig() {
        return new qi.b(pageName(), false, 2, null);
    }

    public void onDestroy() {
        super.onDestroy();
        s0();
    }

    public void onHiddenChanged(boolean hidden) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
                localLogPause();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    public void onPause() {
        super.onPause();
        localLogPause();
        b bVar = this.listExposureCtrl;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void onResume() {
        super.onResume();
        b bVar = this.listExposureCtrl;
        if (bVar != null) {
            bVar.c();
        }
        if (this.isFirst) {
            this.isFirst = false;
            lazyLoadData();
        }
    }

    public void onScreenChange(boolean fullscreen) {
        if (isAdded() && !isHidden() && isResumed()) {
            if (!fullscreen) {
                logResume();
            } else {
                logPause();
                localLogPause();
            }
        }
    }

    public void retryLoadData() {
        lazyLoadData();
    }
}
