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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.google.android.material.appbar.AppBarLayout;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.flow.bean.CategoryItemBean;
import com.transsion.flow.bean.LayoutStyle;
import com.transsion.flow.bean.PlayUrl;
import com.transsion.flow.bean.SubjectGameInfo;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.CategoryBean;
import com.transsion.home.category.CategoryActivity;
import com.transsion.home.category.adapter.e;
import com.transsion.home.category.fragment.CategoryFragment;
import com.transsion.home.category.fragment.a;
import com.transsion.home.viewmodel.CategoryViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectDl;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.push.bean.MsgStyle;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import ij.k;
import ij.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.y0;
import mf.c;
import ni.f;
import qk.j;
import t6.f;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0019\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\u0004J\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001dH\u0016¢\u0006\u0004\b%\u0010\u001fJ!\u0010*\u001a\u00020\t2\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010,\u001a\u00020\tH\u0016¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010-\u001a\u00020\tH\u0016¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\tH\u0016¢\u0006\u0004\b/\u0010\u0004J\u000f\u00100\u001a\u00020\tH\u0016¢\u0006\u0004\b0\u0010\u0004J\u000f\u00101\u001a\u00020\tH\u0016¢\u0006\u0004\b1\u0010\u0004J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\tH\u0016¢\u0006\u0004\b5\u0010\u0004R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010?R\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001b\u0010L\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006R"}, d2 = {"Lcom/transsion/home/category/fragment/CategoryFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lqk/j;", "<init>", "()V", "Lcom/transsion/moviedetailapi/bean/CategoryItemBean;", "categoryItemBean", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "z0", "(Lcom/transsion/moviedetailapi/bean/CategoryItemBean;I)V", "item", "D0", "reload", "Lcom/transsion/home/bean/CategoryBean;", "categoryBean", "O0", "(Lcom/transsion/home/bean/CategoryBean;)V", "loadMore", "loadData", BuildConfig.FLAVOR, "isExpand", "y0", "(Z)V", "Lcom/transsion/moviedetailapi/bean/Subject;", "C0", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "M0", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", "initAd", "Landroid/view/LayoutInflater;", "inflater", "B0", "(Landroid/view/LayoutInflater;)Lqk/j;", "getPageStateLayoutTitle", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initViewData", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViewModel", "loadDefaultData", "initListener", "retryLoadData", "onPause", "onDestroyView", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "onDestroy", "Lcom/transsion/home/viewmodel/CategoryViewModel;", "a", "Lcom/transsion/home/viewmodel/CategoryViewModel;", "viewModel", "Lcom/transsion/home/category/adapter/e;", "b", "Lcom/transsion/home/category/adapter/e;", "mAdapter", "c", "Ljava/lang/String;", "categoryType", "d", "showType", "Lrk/b;", "e", "Lrk/b;", "mExposureHelper", "Lzk/b;", "f", "Lkotlin/Lazy;", "A0", "()Lzk/b;", "categoryDotHelper", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "g", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "v3ListManager", "h", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CategoryFragment extends PageStatusFragment<j> {

    /* renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int i = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private CategoryViewModel viewModel;

    /* renamed from: b, reason: from kotlin metadata */
    private e mAdapter;

    /* renamed from: c, reason: from kotlin metadata */
    private String categoryType;

    /* renamed from: d, reason: from kotlin metadata */
    private String showType;

    /* renamed from: e, reason: from kotlin metadata */
    private rk.b mExposureHelper;

    /* renamed from: f, reason: from kotlin metadata */
    private final Lazy categoryDotHelper = LazyKt.b(new Function0() { // from class: pk.g
        public final Object invoke() {
            zk.b x0;
            x0 = CategoryFragment.x0();
            return x0;
        }
    });

    /* renamed from: g, reason: from kotlin metadata */
    private BiddingListManager v3ListManager;

    /* renamed from: com.transsion.home.category.fragment.CategoryFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Fragment a(String str, String str2) {
            Bundle a = d.a();
            a.putString("category_type", str);
            if (str2 == null) {
                str2 = MsgStyle.CUSTOM_LEFT_PIC;
            }
            a.putString("showType", str2);
            CategoryFragment categoryFragment = new CategoryFragment();
            categoryFragment.setArguments(a);
            return categoryFragment;
        }
    }

    public static final class b implements rk.a {
        b() {
        }

        @Override // rk.a
        public void a(int i, long j, View view) {
            Subject subject;
            Boolean hasResource;
            Subject subject2;
            Subject subject3;
            List data;
            e eVar = CategoryFragment.this.mAdapter;
            boolean z = false;
            if (i >= ((eVar == null || (data = eVar.getData()) == null) ? 0 : data.size())) {
                return;
            }
            e eVar2 = CategoryFragment.this.mAdapter;
            CategoryItemBean categoryItemBean = eVar2 != null ? (CategoryItemBean) eVar2.f0(i) : null;
            zk.b A0 = CategoryFragment.this.A0();
            String pageName = CategoryFragment.this.getPageName();
            String subjectId = (categoryItemBean == null || (subject3 = categoryItemBean.getSubject()) == null) ? null : subject3.getSubjectId();
            String ops = (categoryItemBean == null || (subject2 = categoryItemBean.getSubject()) == null) ? null : subject2.getOps();
            Integer valueOf = Integer.valueOf(i);
            String itemType = categoryItemBean != null ? categoryItemBean.getItemType() : null;
            if (categoryItemBean != null && (subject = categoryItemBean.getSubject()) != null && (hasResource = subject.getHasResource()) != null) {
                z = hasResource.booleanValue();
            }
            A0.a(pageName, subjectId, ops, valueOf, itemType, z, CategoryFragment.this.categoryType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zk.b A0() {
        return (zk.b) this.categoryDotHelper.getValue();
    }

    private final void C0(Subject item) {
        if (item == null) {
            return;
        }
        Navigator.x(TheRouter.c("/playvideo/detail").K("id", item.getSubjectId()).F("season", item.getSeason()).K("ops", a.a(item, this.categoryType)), getContext(), (c) null, 2, (Object) null);
    }

    private final void D0(CategoryItemBean item, int position) {
        Integer subjectType;
        PlayUrl playUrl;
        String playUrl2;
        PlayUrl playUrl3;
        String playUrl4;
        Boolean hasResource;
        Subject subject = item.getSubject();
        boolean z = false;
        if (subject == null || !subject.isShortTV()) {
            Subject subject2 = item.getSubject();
            if (subject2 == null || !subject2.isJumpBrowser()) {
                Subject subject3 = item.getSubject();
                if (subject3 == null || !subject3.isJumpWebview()) {
                    Navigator c = TheRouter.c("/movie/detail");
                    Subject subject4 = item.getSubject();
                    Navigator F = c.F("subject_type", (subject4 == null || (subjectType = subject4.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
                    Subject subject5 = item.getSubject();
                    Navigator K = F.K("id", subject5 != null ? subject5.getSubjectId() : null);
                    Subject subject6 = item.getSubject();
                    Navigator.x(K.F("season", subject6 != null ? subject6.getSeason() : 0).K("ops", a.a(item.getSubject(), this.categoryType)), getContext(), (c) null, 2, (Object) null);
                } else {
                    Subject subject7 = item.getSubject();
                    if (subject7 != null && (playUrl = subject7.getPlayUrl()) != null && (playUrl2 = playUrl.getPlayUrl()) != null) {
                        k.h(playUrl2, null, 1, null);
                    }
                }
            } else {
                Subject subject8 = item.getSubject();
                if (subject8 != null && (playUrl3 = subject8.getPlayUrl()) != null && (playUrl4 = playUrl3.getPlayUrl()) != null) {
                    k.i(playUrl4);
                }
            }
        } else {
            DownloadManagerApi a = DownloadManagerApi.j.a();
            FragmentActivity context = getContext();
            Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            DownloadManagerApi.e0(a, context, getPageName(), BuildConfig.FLAVOR, a.a(item.getSubject(), this.categoryType), "download_subject", false, item.getSubject(), (String) null, (Boolean) null, 384, (Object) null);
        }
        zk.b A0 = A0();
        String pageName = getPageName();
        Subject subject9 = item.getSubject();
        String subjectId = subject9 != null ? subject9.getSubjectId() : null;
        Subject subject10 = item.getSubject();
        String ops = subject10 != null ? subject10.getOps() : null;
        Integer valueOf = Integer.valueOf(position);
        String itemType = item.getItemType();
        Subject subject11 = item.getSubject();
        if (subject11 != null && (hasResource = subject11.getHasResource()) != null) {
            z = hasResource.booleanValue();
        }
        A0.b(pageName, subjectId, ops, valueOf, itemType, z, this.categoryType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(CategoryFragment categoryFragment, int i2, BiddingNativeManager biddingNativeManager) {
        List data;
        Intrinsics.h(biddingNativeManager, "current");
        if (biddingNativeManager != null) {
            CategoryItemBean categoryItemBean = new CategoryItemBean(null, null, new Subject((String) null, (Integer) null, (String) null, (String) null, (Cover) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -1, 67108863, (DefaultConstructorMarker) null), 3, null);
            Subject subject = categoryItemBean.getSubject();
            if (subject != null) {
                subject.setNonAdDelegate(biddingNativeManager);
            }
            e eVar = categoryFragment.mAdapter;
            if (i2 < ((eVar == null || (data = eVar.getData()) == null) ? 0 : data.size())) {
                e eVar2 = categoryFragment.mAdapter;
                if (eVar2 != null) {
                    eVar2.n(i2, categoryItemBean);
                }
            } else {
                e eVar3 = categoryFragment.mAdapter;
                if (eVar3 != null) {
                    eVar3.p(categoryItemBean);
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(CategoryFragment categoryFragment, View view) {
        FragmentActivity activity = categoryFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(final CategoryFragment categoryFragment) {
        RecyclerView recyclerView;
        if (l.a.e()) {
            categoryFragment.loadMore();
            return;
        }
        fh.b.a.d(R.string.no_network_toast);
        j jVar = (j) categoryFragment.getMViewBinding();
        if (jVar == null || (recyclerView = jVar.e) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: pk.i
            @Override // java.lang.Runnable
            public final void run() {
                CategoryFragment.H0(CategoryFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(CategoryFragment categoryFragment) {
        f h0;
        e eVar = categoryFragment.mAdapter;
        if (eVar == null || (h0 = eVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(CategoryFragment categoryFragment, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = baseQuickAdapter.getItem(i2);
        if (item instanceof CategoryItemBean) {
            categoryFragment.D0((CategoryItemBean) item, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(CategoryFragment categoryFragment, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        List data;
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L)) {
            return;
        }
        e eVar = categoryFragment.mAdapter;
        CategoryItemBean categoryItemBean = (eVar == null || (data = eVar.getData()) == null) ? null : (CategoryItemBean) CollectionsKt.l0(data, i2);
        if (categoryItemBean == null || view.getId() != com.transsion.home.R.id.ll_download) {
            return;
        }
        categoryFragment.z0(categoryItemBean, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(CategoryFragment categoryFragment, j jVar, AppBarLayout appBarLayout, int i2) {
        if (categoryFragment.getContext() == null) {
            return;
        }
        if (Math.abs(i2) >= appBarLayout.getTotalScrollRange()) {
            jVar.f.setBackgroundColor(androidx.core.content.b.getColor(categoryFragment.requireContext(), R.color.bg_01));
            jVar.c.setImageTintList(ColorStateList.valueOf(androidx.core.content.b.getColor(categoryFragment.requireContext(), R.color.btn_back)));
            AppCompatTextView appCompatTextView = jVar.g;
            Intrinsics.g(appCompatTextView, "tvTitle");
            uf.c.k(appCompatTextView);
            AppCompatTextView appCompatTextView2 = jVar.h;
            Intrinsics.g(appCompatTextView2, "tvTitleExpand");
            uf.c.g(appCompatTextView2);
            categoryFragment.y0(true);
            return;
        }
        jVar.f.setBackgroundColor(androidx.core.content.b.getColor(categoryFragment.requireContext(), R.color.transparent));
        jVar.c.setImageTintList(ColorStateList.valueOf(androidx.core.content.b.getColor(categoryFragment.requireContext(), R.color.common_white)));
        AppCompatTextView appCompatTextView3 = jVar.g;
        Intrinsics.g(appCompatTextView3, "tvTitle");
        uf.c.g(appCompatTextView3);
        AppCompatTextView appCompatTextView4 = jVar.h;
        Intrinsics.g(appCompatTextView4, "tvTitleExpand");
        uf.c.k(appCompatTextView4);
        categoryFragment.y0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(CategoryFragment categoryFragment, BaseDto baseDto) {
        List data;
        HashMap g;
        e eVar;
        f h0;
        Pager pager;
        f h02;
        e eVar2;
        f h03;
        CategoryBean categoryBean;
        List<CategoryItemBean> list;
        a.a.f(wf.a.a, "CategoryFragment", "return code=" + (baseDto != null ? baseDto.getCode() : null) + " size=" + ((baseDto == null || (categoryBean = (CategoryBean) baseDto.getData()) == null || (list = categoryBean.getList()) == null) ? null : Integer.valueOf(list.size())), false, 4, (Object) null);
        if (baseDto == null) {
            return Unit.a;
        }
        categoryFragment.showContentView();
        e eVar3 = categoryFragment.mAdapter;
        if (eVar3 != null && (h02 = eVar3.h0()) != null && h02.r() && (eVar2 = categoryFragment.mAdapter) != null && (h03 = eVar2.h0()) != null) {
            h03.s();
        }
        if (Intrinsics.c(baseDto.getCode(), "0")) {
            CategoryBean categoryBean2 = (CategoryBean) baseDto.getData();
            if (((categoryBean2 == null || (pager = categoryBean2.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.FALSE)) && (eVar = categoryFragment.mAdapter) != null && (h0 = eVar.h0()) != null) {
                f.u(h0, false, 1, (Object) null);
            }
            categoryFragment.O0((CategoryBean) baseDto.getData());
            qi.b logViewConfig = categoryFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            qi.b logViewConfig2 = categoryFragment.getLogViewConfig();
            if (logViewConfig2 != null) {
                CategoryBean categoryBean3 = (CategoryBean) baseDto.getData();
                logViewConfig2.n(categoryBean3 != null ? categoryBean3.getOps() : null);
            }
        } else {
            e eVar4 = categoryFragment.mAdapter;
            if ((eVar4 == null || (data = eVar4.getData()) == null || data.size() != 0) ? false : true) {
                PageStatusFragment.showEmptyView$default(categoryFragment, false, 1, (Object) null);
            }
        }
        qi.b logViewConfig3 = categoryFragment.getLogViewConfig();
        if (logViewConfig3 != null && (g = logViewConfig3.g()) != null) {
            g.put("category_type", categoryFragment.categoryType);
        }
        return Unit.a;
    }

    private final void M0() {
        Function1 function1 = new Function1() { // from class: pk.h
            public final Object invoke(Object obj) {
                Unit N0;
                N0 = CategoryFragment.N0(CategoryFragment.this, (AddToDownloadEvent) obj);
                return N0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(CategoryFragment categoryFragment, AddToDownloadEvent addToDownloadEvent) {
        e eVar;
        List data;
        Intrinsics.h(addToDownloadEvent, "value");
        try {
            e eVar2 = categoryFragment.mAdapter;
            int i2 = -1;
            if (eVar2 != null && (data = eVar2.getData()) != null) {
                Iterator it = data.iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Subject subject = ((CategoryItemBean) it.next()).getSubject();
                    if (Intrinsics.c(subject != null ? subject.getSubjectId() : null, addToDownloadEvent.getSubjectId())) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
            }
            if (i2 >= 0 && (eVar = categoryFragment.mAdapter) != null) {
                eVar.notifyItemChanged(i2);
            }
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        return Unit.a;
    }

    private final void O0(CategoryBean categoryBean) {
        j jVar;
        List data;
        String str;
        Subject subject;
        Cover cover;
        String thumbnail;
        Subject subject2;
        Cover cover2;
        List data2;
        e eVar;
        if (categoryBean == null || (jVar = (j) getMViewBinding()) == null) {
            return;
        }
        jVar.g.setText(categoryBean.getDesc());
        jVar.h.setText(categoryBean.getDesc());
        List<CategoryItemBean> list = categoryBean.getList();
        if (list != null && (eVar = this.mAdapter) != null) {
            eVar.q(list);
        }
        e eVar2 = this.mAdapter;
        if (eVar2 == null || (data = eVar2.getData()) == null || !(!data.isEmpty())) {
            return;
        }
        e eVar3 = this.mAdapter;
        CategoryItemBean categoryItemBean = (eVar3 == null || (data2 = eVar3.getData()) == null) ? null : (CategoryItemBean) data2.get(0);
        f.a aVar = ni.f.a;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        f.b m = aVar.m(requireContext);
        String str2 = BuildConfig.FLAVOR;
        if (categoryItemBean == null || (subject2 = categoryItemBean.getSubject()) == null || (cover2 = subject2.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b g = m.g(str);
        if (categoryItemBean != null && (subject = categoryItemBean.getSubject()) != null && (cover = subject.getCover()) != null && (thumbnail = cover.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        f.b l = g.l(str2);
        AppCompatImageView appCompatImageView = jVar.d;
        Intrinsics.g(appCompatImageView, "ivCover");
        l.d(appCompatImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPageName() {
        return "category";
    }

    private final void initAd() {
        BiddingListManager biddingListManager = new BiddingListManager();
        j jVar = (j) getMViewBinding();
        biddingListManager.F(jVar != null ? jVar.e : null);
        biddingListManager.A(v.a(this));
        biddingListManager.G("PlayListScene");
        biddingListManager.z(new Function2() { // from class: pk.j
            public final Object invoke(Object obj, Object obj2) {
                Unit E0;
                E0 = CategoryFragment.E0(CategoryFragment.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                return E0;
            }
        });
        this.v3ListManager = biddingListManager;
    }

    private final void loadData() {
        CategoryViewModel categoryViewModel = this.viewModel;
        if (categoryViewModel == null) {
            Intrinsics.y("viewModel");
            categoryViewModel = null;
        }
        String str = this.categoryType;
        if (str == null) {
            str = "Nollywood";
        }
        categoryViewModel.i(str);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final zk.b x0() {
        return new zk.b();
    }

    private final void y0(boolean isExpand) {
        if (isAdded()) {
            CategoryActivity activity = getActivity();
            if (activity instanceof CategoryActivity) {
                activity.b0(isExpand);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void z0(CategoryItemBean categoryItemBean, int position) {
        String str;
        Subject subject;
        String str2;
        ResourceDetectors resourceDetector;
        Subject subject2;
        String subjectId;
        ResourceDetectors resourceDetector2;
        Boolean hasResource;
        Context context = getContext();
        if (context != null) {
            Subject subject3 = categoryItemBean.getSubject();
            boolean z = false;
            if (subject3 != null) {
                Integer subjectType = subject3.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    DownloadManagerApi a = DownloadManagerApi.j.a();
                    FragmentActivity context2 = getContext();
                    Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    DownloadManagerApi.e0(a, context2, "playlist", BuildConfig.FLAVOR, a.a(subject3, this.categoryType), "download_subject", true, subject3, (String) null, (Boolean) null, 384, (Object) null);
                    str2 = "download_subject";
                    subject = subject3;
                    zk.b A0 = A0();
                    String subjectId2 = subject == null ? subject.getSubjectId() : null;
                    String ops = subject != null ? subject.getOps() : null;
                    Integer valueOf = Integer.valueOf(position);
                    String itemType = categoryItemBean.getItemType();
                    if (subject != null && (hasResource = subject.getHasResource()) != null) {
                        z = hasResource.booleanValue();
                    }
                    A0.c("playlist", str2, subjectId2, ops, valueOf, itemType, z, this.categoryType);
                }
            }
            if (t.a.b()) {
                C0(subject3);
                subject = subject3;
                str2 = "play_subject";
            } else {
                DownloadManagerApi.a aVar = DownloadManagerApi.j;
                if (DownloadManagerApi.x0(aVar.a(), subject3 != null ? subject3.getSubjectId() : null, (subject3 == null || (resourceDetector2 = subject3.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId(), subject3 != null && subject3.isSeries(), false, 8, (Object) null)) {
                    if (subject3 == null || (subjectId = subject3.getSubjectId()) == null) {
                        subject2 = subject3;
                    } else {
                        subject2 = subject3;
                        DownloadManagerApi.z0(aVar.a(), subjectId, context, "playlist", (String) null, 8, (Object) null);
                    }
                    str2 = "play_subject";
                    subject = subject2;
                } else {
                    DownloadManagerApi a2 = aVar.a();
                    FragmentActivity requireActivity = requireActivity();
                    Intrinsics.g(requireActivity, "requireActivity(...)");
                    String a3 = a.a(subject3, this.categoryType);
                    if (subject3 == null || (resourceDetector = subject3.getResourceDetector()) == null || (str = resourceDetector.getResourceLink()) == null) {
                        str = BuildConfig.FLAVOR;
                    }
                    subject = subject3;
                    DownloadManagerApi.M(a2, requireActivity, subject3, "playlist", (String) null, a3, str, (String) null, (String) null, (String) null, false, 960, (Object) null);
                    str2 = "download_subject";
                }
            }
            zk.b A02 = A0();
            if (subject == null) {
            }
            String ops2 = subject != null ? subject.getOps() : null;
            Integer valueOf2 = Integer.valueOf(position);
            String itemType2 = categoryItemBean.getItemType();
            if (subject != null) {
                z = hasResource.booleanValue();
            }
            A02.c("playlist", str2, subjectId2, ops2, valueOf2, itemType2, z, this.categoryType);
        }
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public j getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        j c = j.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
    }

    public void initViewData() {
        Toolbar toolbar;
        j jVar = (j) getMViewBinding();
        if (jVar != null && (toolbar = jVar.f) != null) {
            uf.c.e(toolbar);
        }
        pageStateFitStatusBar();
    }

    public void initViewData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        Bundle arguments = getArguments();
        this.categoryType = arguments != null ? arguments.getString("category_type") : null;
        Bundle arguments2 = getArguments();
        this.showType = arguments2 != null ? arguments2.getString("showType") : null;
        ArrayList arrayList = new ArrayList();
        final j jVar = (j) getMViewBinding();
        if (jVar != null) {
            jVar.c.setOnClickListener(new View.OnClickListener() { // from class: pk.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CategoryFragment.F0(CategoryFragment.this, view2);
                }
            });
            RecyclerView recyclerView = jVar.e;
            recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
            rk.b bVar = new rk.b(0.6f, new b(), false, 4, null);
            bVar.l(2);
            recyclerView.addOnScrollListener(bVar);
            this.mExposureHelper = bVar;
            e eVar = new e(arrayList, getPageName(), this.mExposureHelper, this.showType);
            eVar.h0().z(true);
            eVar.h0().y(true);
            eVar.h0().D(new r6.f() { // from class: pk.c
                public final void a() {
                    CategoryFragment.G0(CategoryFragment.this);
                }
            });
            eVar.w1(new r6.d() { // from class: pk.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i2) {
                    CategoryFragment.I0(CategoryFragment.this, baseQuickAdapter, view2, i2);
                }
            });
            eVar.l(new int[]{com.transsion.home.R.id.ll_download});
            eVar.s1(new r6.b() { // from class: pk.e
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i2) {
                    CategoryFragment.J0(CategoryFragment.this, baseQuickAdapter, view2, i2);
                }
            });
            this.mAdapter = eVar;
            recyclerView.setAdapter(eVar);
            jVar.b.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: pk.f
                public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                    CategoryFragment.K0(CategoryFragment.this, jVar, appBarLayout, i2);
                }
            });
        }
        initAd();
    }

    public void initViewModel() {
        CategoryViewModel a = new v0(this).a(CategoryViewModel.class);
        this.viewModel = a;
        if (a == null) {
            Intrinsics.y("viewModel");
            a = null;
        }
        a.j().j(this, new a.C0031a(new Function1() { // from class: pk.a
            public final Object invoke(Object obj) {
                Unit L0;
                L0 = CategoryFragment.L0(CategoryFragment.this, (BaseDto) obj);
                return L0;
            }
        }));
        M0();
    }

    public void loadDefaultData() {
        if (l.a.e()) {
            showLoadingView();
            loadData();
        }
    }

    public qi.b newLogViewConfig() {
        return new qi.b(getPageName(), false, 2, null);
    }

    public void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.v3ListManager;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
    }

    public void onDestroyView() {
        CategoryViewModel categoryViewModel = this.viewModel;
        if (categoryViewModel == null) {
            Intrinsics.y("viewModel");
            categoryViewModel = null;
        }
        categoryViewModel.o(1);
        CategoryViewModel categoryViewModel2 = this.viewModel;
        if (categoryViewModel2 == null) {
            Intrinsics.y("viewModel");
            categoryViewModel2 = null;
        }
        categoryViewModel2.j().q((Object) null);
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        rk.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void retryLoadData() {
        List data;
        e eVar = this.mAdapter;
        if (eVar != null && (data = eVar.getData()) != null && data.size() == 0) {
            reload();
            return;
        }
        e eVar2 = this.mAdapter;
        if (eVar2 == null || eVar2.h0().i() != LoadMoreStatus.Fail) {
            return;
        }
        eVar2.h0().w();
    }
}
