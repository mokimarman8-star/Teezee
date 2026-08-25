package com.transsion.shorttv._channel;

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
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.google.android.material.appbar.AppBarLayout;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import com.transsion.shorttv.R;
import com.transsion.shorttv._channel.ShortTvCategoryFragment;
import com.transsion.shorttv._channel.a;
import com.transsion.shorttv._channel.model.ShortTvCategoryBean;
import com.transsion.shorttv._channel.model.ShortTvCategoryItemBean;
import com.transsion.shorttv._channel.ui.activity.ShortTvCategoryActivity;
import com.transsion.shorttv._channel.ui.viewmodel.ShortTvCategoryViewModel;
import com.transsion.shorttv.base.fragment.PageStatusFragment;
import com.transsion.shorttv.bean.Cover;
import com.transsion.shorttv.bean.Pager;
import com.transsion.shorttv.bean.Subject;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
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
import ni.f;
import qr.v;
import t6.f;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0019\u0010\u000f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0018H\u0016¢\u0006\u0004\b \u0010\u001aJ!\u0010%\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010'\u001a\u00020\tH\u0016¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\tH\u0016¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010+\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\tH\u0016¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\tH\u0016¢\u0006\u0004\b0\u0010\u0004R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010:R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/transsion/shorttv/_channel/ShortTvCategoryFragment;", "Lcom/transsion/shorttv/base/fragment/PageStatusFragment;", "Lqr/v;", "<init>", "()V", "Lcom/transsion/shorttv/_channel/model/ShortTvCategoryItemBean;", "categoryItemBean", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "v0", "(Lcom/transsion/shorttv/_channel/model/ShortTvCategoryItemBean;I)V", "reload", "Lcom/transsion/shorttv/_channel/model/ShortTvCategoryBean;", "categoryBean", "I0", "(Lcom/transsion/shorttv/_channel/model/ShortTvCategoryBean;)V", "loadMore", "loadData", BuildConfig.FLAVOR, "isExpand", "u0", "(Z)V", "G0", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", "initAd", "Landroid/view/LayoutInflater;", "inflater", "x0", "(Landroid/view/LayoutInflater;)Lqr/v;", "getPageStateLayoutTitle", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initViewData", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViewModel", "loadDefaultData", "initListener", "retryLoadData", "onPause", "onDestroyView", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "onDestroy", "Lcom/transsion/shorttv/_channel/ui/viewmodel/ShortTvCategoryViewModel;", "i", "Lcom/transsion/shorttv/_channel/ui/viewmodel/ShortTvCategoryViewModel;", "viewModel", "Lcom/transsion/shorttv/_channel/ui/adapter/b;", "j", "Lcom/transsion/shorttv/_channel/ui/adapter/b;", "mAdapter", "k", "Ljava/lang/String;", "categoryType", "l", "showType", "Lbr/b;", "m", "Lbr/b;", "mExposureHelper", "Lxq/a;", "n", "Lkotlin/Lazy;", "w0", "()Lxq/a;", "categoryDotHelper", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "o", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "v3ListManager", "p", "a", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvCategoryFragment extends PageStatusFragment<v> {

    /* renamed from: p, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: from kotlin metadata */
    private ShortTvCategoryViewModel viewModel;

    /* renamed from: j, reason: from kotlin metadata */
    private com.transsion.shorttv._channel.ui.adapter.b mAdapter;

    /* renamed from: k, reason: from kotlin metadata */
    private String categoryType;

    /* renamed from: l, reason: from kotlin metadata */
    private String showType;

    /* renamed from: m, reason: from kotlin metadata */
    private br.b mExposureHelper;

    /* renamed from: n, reason: from kotlin metadata */
    private final Lazy categoryDotHelper = LazyKt.b(new Function0() { // from class: qq.a
        public final Object invoke() {
            xq.a t0;
            t0 = ShortTvCategoryFragment.t0();
            return t0;
        }
    });

    /* renamed from: o, reason: from kotlin metadata */
    private BiddingListManager v3ListManager;

    /* renamed from: com.transsion.shorttv._channel.ShortTvCategoryFragment$a, reason: from kotlin metadata */
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
            ShortTvCategoryFragment shortTvCategoryFragment = new ShortTvCategoryFragment();
            shortTvCategoryFragment.setArguments(a);
            return shortTvCategoryFragment;
        }
    }

    public static final class b implements br.a {
        b() {
        }

        @Override // br.a
        public void a(int i, long j, View view) {
            Subject subject;
            Boolean hasResource;
            Subject subject2;
            Subject subject3;
            List data;
            com.transsion.shorttv._channel.ui.adapter.b bVar = ShortTvCategoryFragment.this.mAdapter;
            boolean z = false;
            if (i >= ((bVar == null || (data = bVar.getData()) == null) ? 0 : data.size())) {
                return;
            }
            com.transsion.shorttv._channel.ui.adapter.b bVar2 = ShortTvCategoryFragment.this.mAdapter;
            ShortTvCategoryItemBean shortTvCategoryItemBean = bVar2 != null ? (ShortTvCategoryItemBean) bVar2.getItem(i) : null;
            xq.a w0 = ShortTvCategoryFragment.this.w0();
            String pageName = ShortTvCategoryFragment.this.getPageName();
            String subjectId = (shortTvCategoryItemBean == null || (subject3 = shortTvCategoryItemBean.getSubject()) == null) ? null : subject3.getSubjectId();
            String ops = (shortTvCategoryItemBean == null || (subject2 = shortTvCategoryItemBean.getSubject()) == null) ? null : subject2.getOps();
            Integer valueOf = Integer.valueOf(i);
            String itemType = shortTvCategoryItemBean != null ? shortTvCategoryItemBean.getItemType() : null;
            if (shortTvCategoryItemBean != null && (subject = shortTvCategoryItemBean.getSubject()) != null && (hasResource = subject.getHasResource()) != null) {
                z = hasResource.booleanValue();
            }
            w0.a(pageName, subjectId, ops, valueOf, itemType, z, ShortTvCategoryFragment.this.categoryType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(final ShortTvCategoryFragment shortTvCategoryFragment) {
        RecyclerView recyclerView;
        if (l.a.e()) {
            shortTvCategoryFragment.loadMore();
            return;
        }
        jr.b.a.d(R.string.short_tv_no_network_toast);
        v vVar = (v) shortTvCategoryFragment.getMViewBinding();
        if (vVar == null || (recyclerView = vVar.e) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: qq.h
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvCategoryFragment.B0(ShortTvCategoryFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(ShortTvCategoryFragment shortTvCategoryFragment) {
        f h0;
        com.transsion.shorttv._channel.ui.adapter.b bVar = shortTvCategoryFragment.mAdapter;
        if (bVar == null || (h0 = bVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof ShortTvCategoryItemBean) {
            xq.b.c(((ShortTvCategoryItemBean) item).getSubject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(ShortTvCategoryFragment shortTvCategoryFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List data;
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (hr.d.a.a(view.getId(), 2000L)) {
            return;
        }
        com.transsion.shorttv._channel.ui.adapter.b bVar = shortTvCategoryFragment.mAdapter;
        ShortTvCategoryItemBean shortTvCategoryItemBean = (bVar == null || (data = bVar.getData()) == null) ? null : (ShortTvCategoryItemBean) CollectionsKt.l0(data, i);
        if (shortTvCategoryItemBean == null || view.getId() != R.id.ll_download) {
            return;
        }
        shortTvCategoryFragment.v0(shortTvCategoryItemBean, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(ShortTvCategoryFragment shortTvCategoryFragment, v vVar, AppBarLayout appBarLayout, int i) {
        if (shortTvCategoryFragment.getContext() == null) {
            return;
        }
        if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            vVar.f.setBackgroundColor(androidx.core.content.b.getColor(shortTvCategoryFragment.requireContext(), R.color.short_tv_bg));
            vVar.c.setImageTintList(ColorStateList.valueOf(androidx.core.content.b.getColor(shortTvCategoryFragment.requireContext(), R.color.short_tv_white)));
            AppCompatTextView appCompatTextView = vVar.g;
            Intrinsics.g(appCompatTextView, "tvTitle");
            cr.b.e(appCompatTextView);
            AppCompatTextView appCompatTextView2 = vVar.h;
            Intrinsics.g(appCompatTextView2, "tvTitleExpand");
            cr.b.b(appCompatTextView2);
            shortTvCategoryFragment.u0(true);
            return;
        }
        vVar.f.setBackgroundColor(androidx.core.content.b.getColor(shortTvCategoryFragment.requireContext(), R.color.short_tv_transparent));
        vVar.c.setImageTintList(ColorStateList.valueOf(androidx.core.content.b.getColor(shortTvCategoryFragment.requireContext(), R.color.short_tv_white)));
        AppCompatTextView appCompatTextView3 = vVar.g;
        Intrinsics.g(appCompatTextView3, "tvTitle");
        cr.b.b(appCompatTextView3);
        AppCompatTextView appCompatTextView4 = vVar.h;
        Intrinsics.g(appCompatTextView4, "tvTitleExpand");
        cr.b.e(appCompatTextView4);
        shortTvCategoryFragment.u0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(ShortTvCategoryFragment shortTvCategoryFragment, BaseDto baseDto) {
        List data;
        HashMap g;
        com.transsion.shorttv._channel.ui.adapter.b bVar;
        f h0;
        Pager pager;
        f h02;
        com.transsion.shorttv._channel.ui.adapter.b bVar2;
        f h03;
        ShortTvCategoryBean shortTvCategoryBean;
        List<ShortTvCategoryItemBean> list;
        a.a.f(wf.a.a, "CategoryFragment", "return code=" + (baseDto != null ? baseDto.getCode() : null) + " size=" + ((baseDto == null || (shortTvCategoryBean = (ShortTvCategoryBean) baseDto.getData()) == null || (list = shortTvCategoryBean.getList()) == null) ? null : Integer.valueOf(list.size())), false, 4, (Object) null);
        if (baseDto == null) {
            return Unit.a;
        }
        shortTvCategoryFragment.showContentView();
        com.transsion.shorttv._channel.ui.adapter.b bVar3 = shortTvCategoryFragment.mAdapter;
        if (bVar3 != null && (h02 = bVar3.h0()) != null && h02.r() && (bVar2 = shortTvCategoryFragment.mAdapter) != null && (h03 = bVar2.h0()) != null) {
            h03.s();
        }
        if (Intrinsics.c(baseDto.getCode(), "0")) {
            ShortTvCategoryBean shortTvCategoryBean2 = (ShortTvCategoryBean) baseDto.getData();
            if (((shortTvCategoryBean2 == null || (pager = shortTvCategoryBean2.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.FALSE)) && (bVar = shortTvCategoryFragment.mAdapter) != null && (h0 = bVar.h0()) != null) {
                f.u(h0, false, 1, (Object) null);
            }
            shortTvCategoryFragment.I0((ShortTvCategoryBean) baseDto.getData());
            qi.b logViewConfig = shortTvCategoryFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            qi.b logViewConfig2 = shortTvCategoryFragment.getLogViewConfig();
            if (logViewConfig2 != null) {
                ShortTvCategoryBean shortTvCategoryBean3 = (ShortTvCategoryBean) baseDto.getData();
                logViewConfig2.n(shortTvCategoryBean3 != null ? shortTvCategoryBean3.getOps() : null);
            }
        } else {
            com.transsion.shorttv._channel.ui.adapter.b bVar4 = shortTvCategoryFragment.mAdapter;
            if ((bVar4 == null || (data = bVar4.getData()) == null || data.size() != 0) ? false : true) {
                PageStatusFragment.c0(shortTvCategoryFragment, false, 1, null);
            }
        }
        qi.b logViewConfig3 = shortTvCategoryFragment.getLogViewConfig();
        if (logViewConfig3 != null && (g = logViewConfig3.g()) != null) {
            g.put("category_type", shortTvCategoryFragment.categoryType);
        }
        return Unit.a;
    }

    private final void G0() {
        Function1 function1 = new Function1() { // from class: qq.i
            public final Object invoke(Object obj) {
                Unit H0;
                H0 = ShortTvCategoryFragment.H0(ShortTvCategoryFragment.this, (AddToDownloadEvent) obj);
                return H0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(ShortTvCategoryFragment shortTvCategoryFragment, AddToDownloadEvent addToDownloadEvent) {
        com.transsion.shorttv._channel.ui.adapter.b bVar;
        List data;
        Intrinsics.h(addToDownloadEvent, "value");
        try {
            com.transsion.shorttv._channel.ui.adapter.b bVar2 = shortTvCategoryFragment.mAdapter;
            int i = -1;
            if (bVar2 != null && (data = bVar2.getData()) != null) {
                Iterator it = data.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Subject subject = ((ShortTvCategoryItemBean) it.next()).getSubject();
                    if (Intrinsics.c(subject != null ? subject.getSubjectId() : null, addToDownloadEvent.getSubjectId())) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (i >= 0 && (bVar = shortTvCategoryFragment.mAdapter) != null) {
                bVar.notifyItemChanged(i);
            }
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        return Unit.a;
    }

    private final void I0(ShortTvCategoryBean categoryBean) {
        v vVar;
        List data;
        String str;
        Subject subject;
        Cover cover;
        String thumbnail;
        Subject subject2;
        Cover cover2;
        List data2;
        com.transsion.shorttv._channel.ui.adapter.b bVar;
        if (categoryBean == null || (vVar = (v) getMViewBinding()) == null) {
            return;
        }
        vVar.g.setText(categoryBean.getDesc());
        vVar.h.setText(categoryBean.getDesc());
        List<ShortTvCategoryItemBean> list = categoryBean.getList();
        if (list != null && (bVar = this.mAdapter) != null) {
            bVar.q(list);
        }
        com.transsion.shorttv._channel.ui.adapter.b bVar2 = this.mAdapter;
        if (bVar2 == null || (data = bVar2.getData()) == null || !(!data.isEmpty())) {
            return;
        }
        com.transsion.shorttv._channel.ui.adapter.b bVar3 = this.mAdapter;
        ShortTvCategoryItemBean shortTvCategoryItemBean = (bVar3 == null || (data2 = bVar3.getData()) == null) ? null : (ShortTvCategoryItemBean) data2.get(0);
        f.a aVar = ni.f.a;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        f.b m = aVar.m(requireContext);
        String str2 = BuildConfig.FLAVOR;
        if (shortTvCategoryItemBean == null || (subject2 = shortTvCategoryItemBean.getSubject()) == null || (cover2 = subject2.getCover()) == null || (str = cover2.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b g = m.g(str);
        if (shortTvCategoryItemBean != null && (subject = shortTvCategoryItemBean.getSubject()) != null && (cover = subject.getCover()) != null && (thumbnail = cover.getThumbnail()) != null) {
            str2 = thumbnail;
        }
        f.b l = g.l(str2);
        AppCompatImageView appCompatImageView = vVar.d;
        Intrinsics.g(appCompatImageView, "ivCover");
        l.d(appCompatImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPageName() {
        return "category";
    }

    private final void initAd() {
        BiddingListManager biddingListManager = new BiddingListManager();
        v vVar = (v) getMViewBinding();
        biddingListManager.F(vVar != null ? vVar.e : null);
        biddingListManager.A(androidx.lifecycle.v.a(this));
        biddingListManager.G("PlayListScene");
        biddingListManager.z(new Function2() { // from class: qq.j
            public final Object invoke(Object obj, Object obj2) {
                Unit y0;
                y0 = ShortTvCategoryFragment.y0(ShortTvCategoryFragment.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                return y0;
            }
        });
        this.v3ListManager = biddingListManager;
    }

    private final void loadData() {
        ShortTvCategoryViewModel shortTvCategoryViewModel = this.viewModel;
        if (shortTvCategoryViewModel == null) {
            Intrinsics.y("viewModel");
            shortTvCategoryViewModel = null;
        }
        String str = this.categoryType;
        if (str == null) {
            str = "Nollywood";
        }
        shortTvCategoryViewModel.i(str);
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
    public static final xq.a t0() {
        return new xq.a();
    }

    private final void u0(boolean isExpand) {
        if (isAdded()) {
            ShortTvCategoryActivity activity = getActivity();
            if (activity instanceof ShortTvCategoryActivity) {
                activity.W(isExpand);
            }
        }
    }

    private final void v0(ShortTvCategoryItemBean categoryItemBean, int position) {
        Boolean hasResource;
        FragmentActivity context = getContext();
        if (context != null) {
            Subject subject = categoryItemBean.getSubject();
            rr.a.a.a(context, "playlist", a.a(subject, this.categoryType), (r21 & 8) != 0 ? null : "download_subject", (r21 & 16) != 0 ? false : true, (r21 & 32) != 0 ? null : subject, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? Boolean.FALSE : Boolean.TRUE);
            w0().b("playlist", "download_subject", subject != null ? subject.getSubjectId() : null, subject != null ? subject.getOps() : null, Integer.valueOf(position), categoryItemBean.getItemType(), (subject == null || (hasResource = subject.getHasResource()) == null) ? false : hasResource.booleanValue(), this.categoryType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xq.a w0() {
        return (xq.a) this.categoryDotHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(ShortTvCategoryFragment shortTvCategoryFragment, int i, BiddingNativeManager biddingNativeManager) {
        List data;
        Intrinsics.h(biddingNativeManager, "current");
        if (biddingNativeManager != null) {
            ShortTvCategoryItemBean shortTvCategoryItemBean = new ShortTvCategoryItemBean(null, null, new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, false, null, null, 0, 0, null, 0, null, 0, null, -1, 1073741823, null), 3, null);
            Subject subject = shortTvCategoryItemBean.getSubject();
            if (subject != null) {
                subject.setNonAdDelegate(biddingNativeManager);
            }
            com.transsion.shorttv._channel.ui.adapter.b bVar = shortTvCategoryFragment.mAdapter;
            if (i < ((bVar == null || (data = bVar.getData()) == null) ? 0 : data.size())) {
                com.transsion.shorttv._channel.ui.adapter.b bVar2 = shortTvCategoryFragment.mAdapter;
                if (bVar2 != null) {
                    bVar2.n(i, shortTvCategoryItemBean);
                }
            } else {
                com.transsion.shorttv._channel.ui.adapter.b bVar3 = shortTvCategoryFragment.mAdapter;
                if (bVar3 != null) {
                    bVar3.p(shortTvCategoryItemBean);
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(ShortTvCategoryFragment shortTvCategoryFragment, View view) {
        FragmentActivity activity = shortTvCategoryFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void initViewData() {
        Toolbar toolbar;
        v vVar = (v) getMViewBinding();
        if (vVar != null && (toolbar = vVar.f) != null) {
            xq.b.a(toolbar);
        }
        pageStateFitStatusBar();
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void initViewData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        Bundle arguments = getArguments();
        this.categoryType = arguments != null ? arguments.getString("category_type") : null;
        Bundle arguments2 = getArguments();
        this.showType = arguments2 != null ? arguments2.getString("showType") : null;
        ArrayList arrayList = new ArrayList();
        final v vVar = (v) getMViewBinding();
        if (vVar != null) {
            vVar.c.setOnClickListener(new View.OnClickListener() { // from class: qq.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ShortTvCategoryFragment.z0(ShortTvCategoryFragment.this, view2);
                }
            });
            RecyclerView recyclerView = vVar.e;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            br.b bVar = new br.b(0.6f, new b(), false, 4, null);
            bVar.l(2);
            recyclerView.addOnScrollListener(bVar);
            this.mExposureHelper = bVar;
            com.transsion.shorttv._channel.ui.adapter.b bVar2 = new com.transsion.shorttv._channel.ui.adapter.b(arrayList, getPageName(), this.mExposureHelper, this.showType);
            bVar2.h0().z(true);
            bVar2.h0().y(true);
            bVar2.h0().D(new r6.f() { // from class: qq.d
                public final void a() {
                    ShortTvCategoryFragment.A0(ShortTvCategoryFragment.this);
                }
            });
            bVar2.w1(new r6.d() { // from class: qq.e
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    ShortTvCategoryFragment.C0(baseQuickAdapter, view2, i);
                }
            });
            bVar2.l(new int[]{R.id.ll_download});
            bVar2.s1(new r6.b() { // from class: qq.f
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    ShortTvCategoryFragment.D0(ShortTvCategoryFragment.this, baseQuickAdapter, view2, i);
                }
            });
            this.mAdapter = bVar2;
            recyclerView.setAdapter(bVar2);
            vVar.b.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: qq.g
                public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                    ShortTvCategoryFragment.E0(ShortTvCategoryFragment.this, vVar, appBarLayout, i);
                }
            });
        }
        initAd();
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void initViewModel() {
        ShortTvCategoryViewModel a = new v0(this).a(ShortTvCategoryViewModel.class);
        this.viewModel = a;
        if (a == null) {
            Intrinsics.y("viewModel");
            a = null;
        }
        a.j().j(this, new a.C0057a(new Function1() { // from class: qq.b
            public final Object invoke(Object obj) {
                Unit F0;
                F0 = ShortTvCategoryFragment.F0(ShortTvCategoryFragment.this, (BaseDto) obj);
                return F0;
            }
        }));
        G0();
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
        return new qi.b(getPageName(), false, 2, null);
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
    public void onDestroyView() {
        ShortTvCategoryViewModel shortTvCategoryViewModel = this.viewModel;
        if (shortTvCategoryViewModel == null) {
            Intrinsics.y("viewModel");
            shortTvCategoryViewModel = null;
        }
        shortTvCategoryViewModel.o(1);
        ShortTvCategoryViewModel shortTvCategoryViewModel2 = this.viewModel;
        if (shortTvCategoryViewModel2 == null) {
            Intrinsics.y("viewModel");
            shortTvCategoryViewModel2 = null;
        }
        shortTvCategoryViewModel2.j().q((Object) null);
        super.onDestroyView();
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void onPause() {
        super.onPause();
        br.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void retryLoadData() {
        List data;
        com.transsion.shorttv._channel.ui.adapter.b bVar = this.mAdapter;
        if (bVar != null && (data = bVar.getData()) != null && data.size() == 0) {
            reload();
            return;
        }
        com.transsion.shorttv._channel.ui.adapter.b bVar2 = this.mAdapter;
        if (bVar2 == null || bVar2.h0().i() != LoadMoreStatus.Fail) {
            return;
        }
        bVar2.h0().w();
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public v getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        v c = v.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }
}
