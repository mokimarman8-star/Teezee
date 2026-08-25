package com.transsion.home.adapter.suboperate.provider;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.baseui.recycler.InterceptView;
import com.transsion.baseui.widget.OperateScrollableHost;
import com.transsion.home.R;
import com.transsion.home.adapter.suboperate.adapter.SubBannerChildPagerAdapter;
import com.transsion.home.adapter.trending.BannerADDataHelper;
import com.transsion.home.bean.BannerBean;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadDialogShowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i extends BaseItemProvider implements androidx.lifecycle.f {
    private final int e;
    private final BaseHomeSubFragment f;
    private final Set g;
    private Handler h;
    private ViewPager2 i;
    private ViewPager2 j;
    private InterceptView k;
    private int l;
    private long m;
    private boolean n;
    private com.transsion.home.adapter.suboperate.adapter.v o;
    private SubBannerChildPagerAdapter p;
    private com.transsion.home.adapter.suboperate.adapter.v q;
    private final Runnable r;

    public static final class a extends ViewPager2.OnPageChangeCallback {
        final /* synthetic */ OperateItem a;
        final /* synthetic */ i b;

        a(OperateItem operateItem, i iVar) {
            this.a = operateItem;
            this.b = iVar;
        }

        public void onPageSelected(int i) {
            BannerBean banner = this.a.getBanner();
            if (banner != null ? Intrinsics.c(banner.getAutoPlay(), Boolean.TRUE) : false) {
                Handler handler = this.b.h;
                if (handler != null) {
                    handler.removeCallbacks(this.b.r);
                }
                Handler handler2 = this.b.h;
                if (handler2 != null) {
                    handler2.postDelayed(this.b.r, this.b.m);
                }
            }
            boolean z = this.b.l != -1;
            this.b.l = i;
            this.b.a0(i, z);
        }
    }

    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        public void onPageSelected(int i) {
            super.onPageSelected(i);
            int Q = i.this.Q();
            if (Q != -1) {
                i.this.W(Q);
            }
        }
    }

    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ BaseViewHolder a;

        c(BaseViewHolder baseViewHolder) {
            this.a = baseViewHolder;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver = ((RecyclerView.a0) this.a).itemView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            AppStartReport.a.e(new AppStartDotState("trending_end", 0L, 2, (DefaultConstructorMarker) null));
            return true;
        }
    }

    public i(int i, BaseHomeSubFragment baseHomeSubFragment) {
        Intrinsics.h(baseHomeSubFragment, "fragment");
        this.e = i;
        this.f = baseHomeSubFragment;
        this.g = new LinkedHashSet();
        this.l = -1;
        this.m = 5000L;
        U();
        this.r = new Runnable() { // from class: com.transsion.home.adapter.suboperate.provider.e
            @Override // java.lang.Runnable
            public final void run() {
                i.Z(i.this);
            }
        };
    }

    private final List L(List list, final Function1 function1) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = list;
        boolean m = BannerADDataHelper.a.m();
        List list2 = list;
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            BannerData bannerData = (BannerData) next;
            if ((bannerData != null ? bannerData.getBiddingAdData() : null) != null) {
                arrayList.add(next);
            }
        }
        List U0 = CollectionsKt.U0(arrayList);
        if (m || U0.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list2) {
                BannerData bannerData2 = (BannerData) obj;
                if ((bannerData2 != null ? bannerData2.getBiddingAdData() : null) == null) {
                    arrayList2.add(obj);
                }
            }
            List U02 = CollectionsKt.U0(arrayList2);
            objectRef.element = U02;
            if (U02.isEmpty()) {
                return (List) objectRef.element;
            }
            BannerADDataHelper.a.k(new Function2() { // from class: com.transsion.home.adapter.suboperate.provider.h
                public final Object invoke(Object obj2, Object obj3) {
                    Unit M;
                    M = i.M(objectRef, function1, (BiddingIntermediateMaterialBean) obj2, ((Integer) obj3).intValue());
                    return M;
                }
            });
        }
        return (List) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(Ref.ObjectRef objectRef, Function1 function1, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, int i) {
        if (biddingIntermediateMaterialBean == null) {
            return Unit.a;
        }
        if (((List) objectRef.element).size() > i) {
            ((List) objectRef.element).add(i, new BannerData(null, null, null, false, null, null, null, null, 0, null, null, biddingIntermediateMaterialBean, 2047, null));
        } else {
            ((List) objectRef.element).add(new BannerData(null, null, null, false, null, null, null, null, 0, null, null, biddingIntermediateMaterialBean, 2047, null));
        }
        function1.invoke(objectRef.element);
        return Unit.a;
    }

    private final void N() {
        Handler handler = this.h;
        if (handler != null) {
            handler.postDelayed(this.r, this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(i iVar, List list) {
        Intrinsics.h(list, "data");
        iVar.b0(list);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Q() {
        ViewPager2 viewPager2 = this.j;
        if (viewPager2 == null) {
            Intrinsics.y("cardPager");
            viewPager2 = null;
        }
        return viewPager2.getCurrentItem();
    }

    private final int R(int i) {
        return 1073741823 - (1073741823 % i);
    }

    private final void S(List list, OperateItem operateItem) {
        ViewPager2 viewPager2 = this.j;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.y("cardPager");
            viewPager2 = null;
        }
        viewPager2.setPageTransformer(new CompositePageTransformer());
        ViewPager2 viewPager23 = this.j;
        if (viewPager23 == null) {
            Intrinsics.y("cardPager");
            viewPager23 = null;
        }
        viewPager23.setOffscreenPageLimit(3);
        this.p = new SubBannerChildPagerAdapter(list, this.e, operateItem);
        ViewPager2 viewPager24 = this.j;
        if (viewPager24 == null) {
            Intrinsics.y("cardPager");
            viewPager24 = null;
        }
        viewPager24.setAdapter(this.p);
        ViewPager2 viewPager25 = this.j;
        if (viewPager25 == null) {
            Intrinsics.y("cardPager");
        } else {
            viewPager22 = viewPager25;
        }
        viewPager22.registerOnPageChangeCallback(new b());
    }

    private final void U() {
        BaseHomeSubFragment baseHomeSubFragment = this.f;
        Function1 function1 = new Function1() { // from class: com.transsion.home.adapter.suboperate.provider.g
            public final Object invoke(Object obj) {
                Unit V;
                V = i.V(i.this, (DownloadDialogShowEvent) obj);
                return V;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadDialogShowEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(baseHomeSubFragment, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(i iVar, DownloadDialogShowEvent downloadDialogShowEvent) {
        Intrinsics.h(downloadDialogShowEvent, "value");
        if (iVar.n) {
            if (downloadDialogShowEvent.getShow()) {
                Handler handler = iVar.h;
                if (handler != null) {
                    handler.removeCallbacks(iVar.r);
                }
            } else {
                Handler handler2 = iVar.h;
                if (handler2 != null) {
                    handler2.postDelayed(iVar.r, iVar.m);
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(int i) {
        ViewPager2 viewPager2 = this.i;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.y("viewPager2");
            viewPager2 = null;
        }
        if (i != viewPager2.getCurrentItem()) {
            ViewPager2 viewPager23 = this.i;
            if (viewPager23 == null) {
                Intrinsics.y("viewPager2");
            } else {
                viewPager22 = viewPager23;
            }
            viewPager22.setCurrentItem(i, true);
        }
    }

    private final void X() {
        List arrayList;
        List g;
        if (this.f.isAdded() && this.f.isVisible()) {
            View view = this.i;
            if (view == null) {
                Intrinsics.y("viewPager2");
                view = null;
            }
            if (view.isShown()) {
                com.transsion.home.adapter.suboperate.adapter.v vVar = this.q;
                if (vVar == null || (g = vVar.g()) == null || (arrayList = CollectionsKt.U0(g)) == null) {
                    arrayList = new ArrayList();
                }
                L(arrayList, new Function1() { // from class: com.transsion.home.adapter.suboperate.provider.f
                    public final Object invoke(Object obj) {
                        Unit Y;
                        Y = i.Y(i.this, (List) obj);
                        return Y;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(i iVar, List list) {
        Intrinsics.h(list, "data");
        iVar.b0(list);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(i iVar) {
        if (!iVar.f.isVisible()) {
            if (iVar.f.isAdded()) {
                iVar.N();
                return;
            }
            return;
        }
        ViewPager2 viewPager2 = iVar.i;
        if (viewPager2 == null) {
            Intrinsics.y("viewPager2");
            viewPager2 = null;
        }
        ViewPager2 viewPager22 = iVar.i;
        if (viewPager22 == null) {
            Intrinsics.y("viewPager2");
            viewPager22 = null;
        }
        int currentItem = viewPager22.getCurrentItem() + 1;
        ViewPager2 viewPager23 = iVar.i;
        if (viewPager23 == null) {
            Intrinsics.y("viewPager2");
            viewPager23 = null;
        }
        RecyclerView.Adapter adapter = viewPager23.getAdapter();
        Integer valueOf = adapter != null ? Integer.valueOf(adapter.getItemCount()) : null;
        Intrinsics.e(valueOf);
        viewPager2.setCurrentItem(currentItem % valueOf.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(int i, boolean z) {
        if (i != Q()) {
            ViewPager2 viewPager2 = this.j;
            if (viewPager2 == null) {
                Intrinsics.y("cardPager");
                viewPager2 = null;
            }
            viewPager2.setCurrentItem(i, z);
        }
    }

    private final void b0(List list) {
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            com.transsion.home.adapter.suboperate.adapter.v vVar = this.q;
            if (vVar != null) {
                vVar.i(list);
            }
            com.transsion.home.adapter.suboperate.adapter.v vVar2 = this.q;
            if (vVar2 != null) {
                vVar2.notifyDataSetChanged();
            }
            SubBannerChildPagerAdapter subBannerChildPagerAdapter = this.p;
            if (subBannerChildPagerAdapter != null) {
                subBannerChildPagerAdapter.h(list);
            }
            SubBannerChildPagerAdapter subBannerChildPagerAdapter2 = this.p;
            if (subBannerChildPagerAdapter2 != null) {
                subBannerChildPagerAdapter2.notifyDataSetChanged();
                unit = Unit.a;
            } else {
                unit = null;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, OperateItem operateItem) {
        List arrayList;
        String interval;
        Integer v;
        List<BannerData> banners;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        this.i = ((RecyclerView.a0) baseViewHolder).itemView.findViewById(R.id.sub_operation_view_pager);
        this.j = baseViewHolder.getView(R.id.cardPager);
        InterceptView interceptView = (InterceptView) baseViewHolder.getView(R.id.interestLayout);
        this.k = interceptView;
        ViewPager2 viewPager2 = null;
        if (interceptView == null) {
            Intrinsics.y("interestLayout");
            interceptView = null;
        }
        View view = this.j;
        if (view == null) {
            Intrinsics.y("cardPager");
            view = null;
        }
        interceptView.setPostView(view);
        ((OperateScrollableHost) baseViewHolder.getView(R.id.sub_operation_view_scroll_helper)).interceptAllEvent(true);
        ((OperateScrollableHost) baseViewHolder.getView(R.id.sub_operation_card_helper)).interceptAllEvent(true);
        BannerBean banner = operateItem.getBanner();
        if (banner == null || (banners = banner.getBanners()) == null || (arrayList = CollectionsKt.U0(banners)) == null) {
            arrayList = new ArrayList();
        }
        List<BannerData> L = L(arrayList, new Function1() { // from class: com.transsion.home.adapter.suboperate.provider.d
            public final Object invoke(Object obj) {
                Unit P;
                P = i.P(i.this, (List) obj);
                return P;
            }
        });
        BannerBean banner2 = operateItem.getBanner();
        if (banner2 != null) {
            banner2.setBanners(L);
        }
        if (L.isEmpty()) {
            return;
        }
        com.transsion.home.adapter.suboperate.adapter.v vVar = this.q;
        if (vVar == null) {
            this.q = new com.transsion.home.adapter.suboperate.adapter.v(L, this.e, this, operateItem);
        } else if (vVar != null) {
            vVar.i(L);
        }
        this.o = this.q;
        ViewPager2 viewPager22 = this.i;
        if (viewPager22 == null) {
            Intrinsics.y("viewPager2");
            viewPager22 = null;
        }
        viewPager22.setAdapter(this.o);
        S(L, operateItem);
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacks(this.r);
        }
        this.h = new Handler(Looper.getMainLooper());
        ViewPager2 viewPager23 = this.i;
        if (viewPager23 == null) {
            Intrinsics.y("viewPager2");
            viewPager23 = null;
        }
        viewPager23.registerOnPageChangeCallback(new a(operateItem, this));
        BannerBean banner3 = operateItem.getBanner();
        long intValue = ((banner3 == null || (interval = banner3.getInterval()) == null || (v = StringsKt.v(interval)) == null) ? 0 : v.intValue()) * 1000;
        if (intValue <= 0) {
            intValue = this.m;
        }
        this.m = intValue;
        int i = this.l;
        if (i < 0) {
            i = R(L.size());
        }
        ViewPager2 viewPager24 = this.i;
        if (viewPager24 == null) {
            Intrinsics.y("viewPager2");
            viewPager24 = null;
        }
        viewPager24.setCurrentItem(i, false);
        ViewPager2 viewPager25 = this.j;
        if (viewPager25 == null) {
            Intrinsics.y("cardPager");
        } else {
            viewPager2 = viewPager25;
        }
        viewPager2.setCurrentItem(i, false);
    }

    public final boolean T(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return this.g.add(str);
    }

    public int l() {
        return PostItemType.BANNER.ordinal();
    }

    public int m() {
        return R.layout.item_sub_operation_banner;
    }

    public /* synthetic */ void onCreate(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.a(this, uVar);
    }

    public /* synthetic */ void onDestroy(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.b(this, uVar);
    }

    public void onPause(androidx.lifecycle.u uVar) {
        Handler handler;
        Intrinsics.h(uVar, "owner");
        androidx.lifecycle.e.c(this, uVar);
        if (!this.n || (handler = this.h) == null) {
            return;
        }
        handler.removeCallbacks(this.r);
    }

    public void onResume(androidx.lifecycle.u uVar) {
        Intrinsics.h(uVar, "owner");
        androidx.lifecycle.e.d(this, uVar);
        if (this.n) {
            Handler handler = this.h;
            if (handler != null) {
                handler.postDelayed(this.r, this.m);
            }
            X();
        }
    }

    public /* synthetic */ void onStart(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.e(this, uVar);
    }

    public /* synthetic */ void onStop(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.f(this, uVar);
    }

    public void t(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.t(baseViewHolder);
        this.n = true;
        Handler handler = this.h;
        if (handler != null) {
            handler.postDelayed(this.r, this.m);
        }
        ((RecyclerView.a0) baseViewHolder).itemView.getViewTreeObserver().addOnPreDrawListener(new c(baseViewHolder));
    }

    public void u(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.u(baseViewHolder);
        this.n = false;
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacks(this.r);
        }
    }
}
