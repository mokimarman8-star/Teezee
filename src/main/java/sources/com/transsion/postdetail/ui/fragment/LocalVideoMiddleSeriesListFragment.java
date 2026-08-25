package com.transsion.postdetail.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.R$anim;
import com.transsion.postdetail.viewmodel.LocalVideoDetailViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u001f\u0010\u000b\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0010H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u0004J\u001f\u0010(\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J!\u0010*\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b*\u0010\u001dJ6\u0010/\u001a\u00020\u00052'\u0010.\u001a#\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00050+¢\u0006\u0004\b/\u00100J\u001d\u00104\u001a\u00020\u00052\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u0010¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u00020\u001f¢\u0006\u0004\b7\u00108R\u0014\u0010;\u001a\u00020&8\u0002X\u0082D¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\"\u0010L\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u00108R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010:R\u0018\u0010P\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR9\u0010S\u001a%\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/LocalVideoMiddleSeriesListFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lwn/k;", "<init>", "()V", BuildConfig.FLAVOR, "initAdapter", "k0", BuildConfig.FLAVOR, "Lcom/transsion/baselib/db/download/DownloadBean;", "insertList", "u0", "(Ljava/util/List;)V", "bean", "p0", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", BuildConfig.FLAVOR, "position", "q0", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "f0", "(Landroid/view/LayoutInflater;)Lwn/k;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "transit", BuildConfig.FLAVOR, "enter", "nextAnim", "Landroid/view/animation/Animation;", "onCreateAnimation", "(IZI)Landroid/view/animation/Animation;", "lazyLoadData", BuildConfig.FLAVOR, "pageFrom", "r0", "(Lcom/transsion/baselib/db/download/DownloadBean;Ljava/lang/String;)V", "initData", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "callback", "s0", "(Lkotlin/jvm/functions/Function2;)V", "Landroidx/fragment/app/Fragment;", "fragment", "id", "t0", "(Landroidx/fragment/app/Fragment;I)V", "force", "n0", "(Z)V", "a", "Ljava/lang/String;", "TAG", "b", "I", "scrollOffset", "Lcom/transsion/postdetail/ui/adapter/c;", "c", "Lcom/transsion/postdetail/ui/adapter/c;", "seriesAdapter", "Lcom/transsion/postdetail/viewmodel/LocalVideoDetailViewModel;", "d", "Lcom/transsion/postdetail/viewmodel/LocalVideoDetailViewModel;", "viewModel", "e", "Z", "m0", "()Z", "setRemoved", "isRemoved", "f", "g", "Lcom/transsion/baselib/db/download/DownloadBean;", "downloadBean", "h", "Lkotlin/jvm/functions/Function2;", "itemClickCallback", "i", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LocalVideoMiddleSeriesListFragment extends BaseFragment<wn.k> {

    /* renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: from kotlin metadata */
    private com.transsion.postdetail.ui.adapter.c seriesAdapter;

    /* renamed from: d, reason: from kotlin metadata */
    private LocalVideoDetailViewModel viewModel;

    /* renamed from: g, reason: from kotlin metadata */
    private DownloadBean downloadBean;

    /* renamed from: h, reason: from kotlin metadata */
    private Function2 itemClickCallback;

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG = "LocalVideoMiddleSeriesListFragment";

    /* renamed from: b, reason: from kotlin metadata */
    private final int scrollOffset = com.blankj.utilcode.util.a0.a(280.0f);

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isRemoved = true;

    /* renamed from: f, reason: from kotlin metadata */
    private String pageFrom = BuildConfig.FLAVOR;

    /* renamed from: com.transsion.postdetail.ui.fragment.LocalVideoMiddleSeriesListFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalVideoMiddleSeriesListFragment a() {
            return new LocalVideoMiddleSeriesListFragment();
        }
    }

    public static final class b extends DiffUtil.e {
        b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(DownloadBean downloadBean, DownloadBean downloadBean2) {
            Intrinsics.h(downloadBean, "oldItem");
            Intrinsics.h(downloadBean2, "newItem");
            return Intrinsics.c(downloadBean.getResourceId(), downloadBean2.getResourceId()) && downloadBean.getStatus() == downloadBean2.getStatus() && downloadBean.getProgress() == downloadBean2.getProgress() && Intrinsics.c(downloadBean.getUpdateTimeStamp(), downloadBean2.getUpdateTimeStamp());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(DownloadBean downloadBean, DownloadBean downloadBean2) {
            Intrinsics.h(downloadBean, "oldItem");
            Intrinsics.h(downloadBean2, "newItem");
            return Intrinsics.c(downloadBean.getResourceId(), downloadBean2.getResourceId());
        }
    }

    static final class c implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(LocalVideoMiddleSeriesListFragment localVideoMiddleSeriesListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L) || baseQuickAdapter.getData().isEmpty()) {
            return;
        }
        Object obj = baseQuickAdapter.getData().get(i);
        Intrinsics.f(obj, "null cannot be cast to non-null type com.transsion.baselib.db.download.DownloadBean");
        DownloadBean downloadBean = (DownloadBean) obj;
        a.a aVar = wf.a.a;
        String str = localVideoMiddleSeriesListFragment.TAG;
        DownloadBean downloadBean2 = localVideoMiddleSeriesListFragment.downloadBean;
        Integer valueOf = downloadBean2 != null ? Integer.valueOf(downloadBean2.getEpse()) : null;
        DownloadBean downloadBean3 = localVideoMiddleSeriesListFragment.downloadBean;
        String resourceId = downloadBean3 != null ? downloadBean3.getResourceId() : null;
        a.a.f(aVar, str, "item click, current epse = " + valueOf + ",resourceId=" + resourceId + ",  click epse = " + downloadBean.getEpse() + ",resourceId=" + downloadBean.getResourceId(), false, 4, (Object) null);
        String resourceId2 = downloadBean.getResourceId();
        DownloadBean downloadBean4 = localVideoMiddleSeriesListFragment.downloadBean;
        if (Intrinsics.c(resourceId2, downloadBean4 != null ? downloadBean4.getResourceId() : null)) {
            return;
        }
        if (downloadBean.getCanPlay()) {
            localVideoMiddleSeriesListFragment.downloadBean = downloadBean;
        }
        Function2 function2 = localVideoMiddleSeriesListFragment.itemClickCallback;
        if (function2 != null) {
            function2.invoke(downloadBean, Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(LocalVideoMiddleSeriesListFragment localVideoMiddleSeriesListFragment, List list) {
        a.a.f(wf.a.a, localVideoMiddleSeriesListFragment.TAG, "2--fragment, on get series from local, size = " + (list != null ? Integer.valueOf(list.size()) : null), false, 4, (Object) null);
        localVideoMiddleSeriesListFragment.u0(list);
        DownloadBean downloadBean = localVideoMiddleSeriesListFragment.downloadBean;
        if (downloadBean != null) {
            localVideoMiddleSeriesListFragment.p0(downloadBean);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(LocalVideoMiddleSeriesListFragment localVideoMiddleSeriesListFragment, DownloadBean downloadBean) {
        com.transsion.postdetail.ui.adapter.c cVar;
        List data;
        List data2;
        int i = 0;
        if (downloadBean != null) {
            downloadBean.setPlaying(false);
        }
        com.transsion.postdetail.ui.adapter.c cVar2 = localVideoMiddleSeriesListFragment.seriesAdapter;
        int i2 = -1;
        if (cVar2 != null && (data2 = cVar2.getData()) != null) {
            Iterator it = data2.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.c(((DownloadBean) it.next()).getResourceId(), downloadBean != null ? downloadBean.getResourceId() : null)) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
        }
        if (i2 >= 0) {
            com.transsion.postdetail.ui.adapter.c cVar3 = localVideoMiddleSeriesListFragment.seriesAdapter;
            if (cVar3 != null && (data = cVar3.getData()) != null) {
                i = data.size();
            }
            if (i2 < i && (cVar = localVideoMiddleSeriesListFragment.seriesAdapter) != null) {
                cVar.notifyItemChanged(i2, Boolean.FALSE);
            }
        }
        return Unit.a;
    }

    private final void initAdapter() {
        com.transsion.postdetail.ui.adapter.c cVar = new com.transsion.postdetail.ui.adapter.c(new ArrayList(), true);
        cVar.w1(new r6.d() { // from class: com.transsion.postdetail.ui.fragment.a1
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LocalVideoMiddleSeriesListFragment.g0(LocalVideoMiddleSeriesListFragment.this, baseQuickAdapter, view, i);
            }
        });
        cVar.R0(new b());
        this.seriesAdapter = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(LocalVideoMiddleSeriesListFragment localVideoMiddleSeriesListFragment, DownloadBean downloadBean) {
        com.transsion.postdetail.ui.adapter.c cVar;
        List data;
        List data2;
        if (downloadBean != null) {
            downloadBean.setPlaying(true);
        }
        com.transsion.postdetail.ui.adapter.c cVar2 = localVideoMiddleSeriesListFragment.seriesAdapter;
        int i = -1;
        int i2 = 0;
        if (cVar2 != null && (data2 = cVar2.getData()) != null) {
            Iterator it = data2.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.c(((DownloadBean) it.next()).getResourceId(), downloadBean != null ? downloadBean.getResourceId() : null)) {
                    i = i3;
                    break;
                }
                i3++;
            }
        }
        if (i >= 0) {
            com.transsion.postdetail.ui.adapter.c cVar3 = localVideoMiddleSeriesListFragment.seriesAdapter;
            if (cVar3 != null && (data = cVar3.getData()) != null) {
                i2 = data.size();
            }
            if (i < i2 && (cVar = localVideoMiddleSeriesListFragment.seriesAdapter) != null) {
                cVar.notifyItemChanged(i, Boolean.TRUE);
            }
        }
        return Unit.a;
    }

    private final void k0() {
        RecyclerView recyclerView;
        wn.k kVar = (wn.k) getMViewBinding();
        if (kVar == null || (recyclerView = kVar.c) == null) {
            return;
        }
        int a = com.blankj.utilcode.util.a0.a(4.0f);
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 3));
        int i = a * 2;
        int i2 = a * 3;
        recyclerView.addItemDecoration(new tf.a(i, i, i2, i2));
        recyclerView.setAdapter(this.seriesAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(LocalVideoMiddleSeriesListFragment localVideoMiddleSeriesListFragment, View view) {
        o0(localVideoMiddleSeriesListFragment, false, 1, null);
    }

    public static /* synthetic */ void o0(LocalVideoMiddleSeriesListFragment localVideoMiddleSeriesListFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        localVideoMiddleSeriesListFragment.n0(z);
    }

    private final void p0(DownloadBean bean) {
        List data;
        List data2;
        com.transsion.postdetail.ui.adapter.c cVar = this.seriesAdapter;
        int i = -1;
        int i2 = 0;
        if (cVar != null && (data2 = cVar.getData()) != null) {
            Iterator it = data2.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.c(((DownloadBean) it.next()).getResourceId(), bean.getResourceId())) {
                    i = i3;
                    break;
                }
                i3++;
            }
        }
        if (i > 0) {
            com.transsion.postdetail.ui.adapter.c cVar2 = this.seriesAdapter;
            if (cVar2 != null && (data = cVar2.getData()) != null) {
                i2 = data.size();
            }
            if (i < i2) {
                q0(i);
            }
        }
    }

    private final void q0(int position) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        a.a.v(wf.a.a, this.TAG, "seriesScrollToPosition = " + position, false, 4, (Object) null);
        if (position < 0) {
            return;
        }
        try {
            wn.k kVar = (wn.k) getMViewBinding();
            if (kVar != null && (recyclerView2 = kVar.c) != null) {
                recyclerView2.scrollToPosition(position);
            }
            wn.k kVar2 = (wn.k) getMViewBinding();
            RecyclerView.m layoutManager = (kVar2 == null || (recyclerView = kVar2.c) == null) ? null : recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                ((GridLayoutManager) layoutManager).scrollToPositionWithOffset(position, this.scrollOffset);
            }
        } catch (Throwable unused) {
        }
    }

    private final void u0(List insertList) {
        List l;
        ArrayList arrayList;
        List data;
        List data2;
        com.transsion.postdetail.ui.adapter.c cVar = this.seriesAdapter;
        if (cVar != null && (data2 = cVar.getData()) != null && data2.isEmpty()) {
            com.transsion.postdetail.ui.adapter.c cVar2 = this.seriesAdapter;
            if (cVar2 != null) {
                cVar2.n1(insertList);
                return;
            }
            return;
        }
        com.transsion.postdetail.ui.adapter.c cVar3 = this.seriesAdapter;
        if (cVar3 == null || (l = cVar3.getData()) == null) {
            l = CollectionsKt.l();
        }
        Integer num = null;
        if (insertList != null) {
            arrayList = new ArrayList();
            for (Object obj : insertList) {
                if (!l.contains((DownloadBean) obj)) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            a.a.f(wf.a.a, this.TAG, "全部去重了~", false, 4, (Object) null);
            return;
        }
        com.transsion.postdetail.ui.adapter.c cVar4 = this.seriesAdapter;
        if (cVar4 != null) {
            cVar4.q(arrayList);
        }
        a.a aVar = wf.a.a;
        String str = this.TAG;
        com.transsion.postdetail.ui.adapter.c cVar5 = this.seriesAdapter;
        if (cVar5 != null && (data = cVar5.getData()) != null) {
            num = Integer.valueOf(data.size());
        }
        a.a.f(aVar, str, "3--fragment, on get series from net, totalSize = " + num, false, 4, (Object) null);
    }

    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public wn.k getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        wn.k c2 = wn.k.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void initData(View view, Bundle savedInstanceState) {
        androidx.lifecycle.b0 e;
        androidx.lifecycle.b0 f;
        androidx.lifecycle.b0 i;
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            LocalVideoDetailViewModel localVideoDetailViewModel = (LocalVideoDetailViewModel) new androidx.lifecycle.v0(activity, new v0.d()).a(LocalVideoDetailViewModel.class);
            this.viewModel = localVideoDetailViewModel;
            if (localVideoDetailViewModel != null && (i = localVideoDetailViewModel.i()) != null) {
                i.j(activity, new c(new Function1() { // from class: com.transsion.postdetail.ui.fragment.w0
                    public final Object invoke(Object obj) {
                        Unit h0;
                        h0 = LocalVideoMiddleSeriesListFragment.h0(LocalVideoMiddleSeriesListFragment.this, (List) obj);
                        return h0;
                    }
                }));
            }
            LocalVideoDetailViewModel localVideoDetailViewModel2 = this.viewModel;
            if (localVideoDetailViewModel2 != null && (f = localVideoDetailViewModel2.f()) != null) {
                f.j(activity, new c(new Function1() { // from class: com.transsion.postdetail.ui.fragment.x0
                    public final Object invoke(Object obj) {
                        Unit i0;
                        i0 = LocalVideoMiddleSeriesListFragment.i0(LocalVideoMiddleSeriesListFragment.this, (DownloadBean) obj);
                        return i0;
                    }
                }));
            }
            LocalVideoDetailViewModel localVideoDetailViewModel3 = this.viewModel;
            if (localVideoDetailViewModel3 == null || (e = localVideoDetailViewModel3.e()) == null) {
                return;
            }
            e.j(activity, new c(new Function1() { // from class: com.transsion.postdetail.ui.fragment.y0
                public final Object invoke(Object obj) {
                    Unit j0;
                    j0 = LocalVideoMiddleSeriesListFragment.j0(LocalVideoMiddleSeriesListFragment.this, (DownloadBean) obj);
                    return j0;
                }
            }));
        }
    }

    public void initView(View view, Bundle savedInstanceState) {
        AppCompatImageView appCompatImageView;
        Intrinsics.h(view, "view");
        initAdapter();
        k0();
        wn.k kVar = (wn.k) getMViewBinding();
        if (kVar == null || (appCompatImageView = kVar.b) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LocalVideoMiddleSeriesListFragment.l0(LocalVideoMiddleSeriesListFragment.this, view2);
            }
        });
    }

    public void lazyLoadData() {
    }

    /* renamed from: m0, reason: from getter */
    public final boolean getIsRemoved() {
        return this.isRemoved;
    }

    public final void n0(boolean force) {
        if (!this.isRemoved || force) {
            this.isRemoved = true;
            try {
                FragmentManager parentFragmentManager = getParentFragmentManager();
                parentFragmentManager.g1();
                androidx.fragment.app.w p = parentFragmentManager.p();
                Intrinsics.g(p, "beginTransaction(...)");
                p.r(this);
                p.j();
                Intrinsics.e(parentFragmentManager);
            } catch (Throwable unused) {
            }
        }
    }

    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return enter ? AnimationUtils.loadAnimation(getActivity(), R$anim.enter_bottom_menu) : AnimationUtils.loadAnimation(getActivity(), R$anim.exit_bottom_menu);
    }

    public final void r0(DownloadBean bean, String pageFrom) {
        Intrinsics.h(pageFrom, "pageFrom");
        this.downloadBean = bean;
        this.pageFrom = pageFrom;
    }

    public final void s0(Function2 callback) {
        Intrinsics.h(callback, "callback");
        this.itemClickCallback = callback;
    }

    public final void t0(Fragment fragment, int id) {
        Intrinsics.h(fragment, "fragment");
        if (this.isRemoved) {
            this.isRemoved = false;
            try {
                FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
                androidx.fragment.app.w p = childFragmentManager.p();
                Intrinsics.g(p, "beginTransaction()");
                p.t(id, this, "LocalVideoMiddleSeriesList");
                p.j();
            } catch (Throwable unused) {
            }
        }
    }
}
