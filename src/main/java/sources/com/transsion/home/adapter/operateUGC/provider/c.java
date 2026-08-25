package com.transsion.home.adapter.operateUGC.provider;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.indicator.BannerIndicator;
import com.tn.lib.view.indicator.BaseIndicator;
import com.transsion.baseui.widget.OperateScrollableHost;
import com.transsion.home.R;
import com.transsion.home.adapter.operateUGC.adapter.BannerUGCAdapter;
import com.transsion.home.bean.BannerBean;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseItemProvider implements androidx.lifecycle.f {
    private final int e;
    private final BaseHomeSubFragment f;
    private final Set g;
    private Handler h;
    private ViewPager2 i;
    private BannerIndicator j;
    private int k;
    private long l;
    private boolean m;
    private final Runnable n;

    public static final class a extends ViewPager2.OnPageChangeCallback {
        final /* synthetic */ OperateItem a;
        final /* synthetic */ c b;
        final /* synthetic */ List c;

        a(OperateItem operateItem, c cVar, List list) {
            this.a = operateItem;
            this.b = cVar;
            this.c = list;
        }

        public void onPageSelected(int i) {
            BannerBean banner = this.a.getBanner();
            if (banner != null ? Intrinsics.c(banner.getAutoPlay(), Boolean.TRUE) : false) {
                Handler handler = this.b.h;
                if (handler != null) {
                    handler.removeCallbacks(this.b.n);
                }
                Handler handler2 = this.b.h;
                if (handler2 != null) {
                    handler2.postDelayed(this.b.n, this.b.l);
                }
            }
            this.b.k = i;
            BaseIndicator baseIndicator = this.b.j;
            if (baseIndicator == null) {
                Intrinsics.y("circleIndicator");
                baseIndicator = null;
            }
            baseIndicator.onPageSelected(i % this.c.size());
        }
    }

    public static final class b implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ BaseViewHolder a;

        b(BaseViewHolder baseViewHolder) {
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

    public c(int i, BaseHomeSubFragment baseHomeSubFragment) {
        Intrinsics.h(baseHomeSubFragment, "fragment");
        this.e = i;
        this.f = baseHomeSubFragment;
        this.g = new LinkedHashSet();
        this.k = -1;
        this.l = 5000L;
        this.n = new Runnable() { // from class: com.transsion.home.adapter.operateUGC.provider.b
            @Override // java.lang.Runnable
            public final void run() {
                c.J(c.this);
            }
        };
    }

    private final void F() {
        Handler handler = this.h;
        if (handler != null) {
            handler.postDelayed(this.n, this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(c cVar) {
        View view = cVar.j;
        if (view == null) {
            Intrinsics.y("circleIndicator");
            view = null;
        }
        view.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(c cVar) {
        if (!cVar.f.isVisible()) {
            if (cVar.f.isAdded()) {
                cVar.F();
                return;
            }
            return;
        }
        ViewPager2 viewPager2 = cVar.i;
        if (viewPager2 == null) {
            Intrinsics.y("viewPager2");
            viewPager2 = null;
        }
        ViewPager2 viewPager22 = cVar.i;
        if (viewPager22 == null) {
            Intrinsics.y("viewPager2");
            viewPager22 = null;
        }
        int currentItem = viewPager22.getCurrentItem() + 1;
        ViewPager2 viewPager23 = cVar.i;
        if (viewPager23 == null) {
            Intrinsics.y("viewPager2");
            viewPager23 = null;
        }
        RecyclerView.Adapter adapter = viewPager23.getAdapter();
        Integer valueOf = adapter != null ? Integer.valueOf(adapter.getItemCount()) : null;
        Intrinsics.e(valueOf);
        viewPager2.setCurrentItem(currentItem % valueOf.intValue());
    }

    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, OperateItem operateItem) {
        List<BannerData> arrayList;
        String interval;
        Integer v;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        this.i = ((RecyclerView.a0) baseViewHolder).itemView.findViewById(R.id.provider_ugc_banner_view_pager);
        ((OperateScrollableHost) ((RecyclerView.a0) baseViewHolder).itemView.findViewById(R.id.provider_ugc_banner_view_scroll_helper)).interceptAllEvent(true);
        this.j = ((RecyclerView.a0) baseViewHolder).itemView.findViewById(R.id.provider_ugc_banner_view_pager_indicator);
        BannerBean banner = operateItem.getBanner();
        if (banner == null || (arrayList = banner.getBanners()) == null) {
            arrayList = new ArrayList<>();
        }
        ViewPager2 viewPager2 = this.i;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.y("viewPager2");
            viewPager2 = null;
        }
        viewPager2.setAdapter(new BannerUGCAdapter(arrayList, this.e, this, operateItem));
        if (arrayList.isEmpty()) {
            return;
        }
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacks(this.n);
        }
        this.h = new Handler(Looper.getMainLooper());
        ViewPager2 viewPager23 = this.i;
        if (viewPager23 == null) {
            Intrinsics.y("viewPager2");
            viewPager23 = null;
        }
        viewPager23.registerOnPageChangeCallback(new a(operateItem, this, arrayList));
        BaseIndicator baseIndicator = this.j;
        if (baseIndicator == null) {
            Intrinsics.y("circleIndicator");
            baseIndicator = null;
        }
        com.tn.lib.view.indicator.a indicatorConfig = baseIndicator.getIndicatorConfig();
        indicatorConfig.s(-1);
        indicatorConfig.q(androidx.core.content.b.getColor(k(), com.tn.lib.widget.R.color.white_20));
        indicatorConfig.r(com.blankj.utilcode.util.a0.a(4.0f));
        indicatorConfig.t(com.blankj.utilcode.util.a0.a(8.0f));
        indicatorConfig.o(com.blankj.utilcode.util.a0.a(4.0f));
        indicatorConfig.n(arrayList.size());
        View view = this.j;
        if (view == null) {
            Intrinsics.y("circleIndicator");
            view = null;
        }
        view.post(new Runnable() { // from class: com.transsion.home.adapter.operateUGC.provider.a
            @Override // java.lang.Runnable
            public final void run() {
                c.H(c.this);
            }
        });
        BannerBean banner2 = operateItem.getBanner();
        long intValue = ((banner2 == null || (interval = banner2.getInterval()) == null || (v = StringsKt.v(interval)) == null) ? 0 : v.intValue()) * 1000;
        if (intValue <= 0) {
            intValue = this.l;
        }
        this.l = intValue;
        int i = this.k;
        if (i < 0) {
            i = 1073741823 - (1073741823 % arrayList.size());
        }
        ViewPager2 viewPager24 = this.i;
        if (viewPager24 == null) {
            Intrinsics.y("viewPager2");
        } else {
            viewPager22 = viewPager24;
        }
        viewPager22.setCurrentItem(i, false);
    }

    public final boolean I(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return this.g.add(str);
    }

    public int l() {
        return PostItemType.UGC_BANNER.ordinal();
    }

    public int m() {
        return R.layout.provider_ugc_item_banner;
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
        if (!this.m || (handler = this.h) == null) {
            return;
        }
        handler.removeCallbacks(this.n);
    }

    public void onResume(androidx.lifecycle.u uVar) {
        Handler handler;
        Intrinsics.h(uVar, "owner");
        androidx.lifecycle.e.d(this, uVar);
        if (!this.m || (handler = this.h) == null) {
            return;
        }
        handler.postDelayed(this.n, this.l);
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
        this.m = true;
        Handler handler = this.h;
        if (handler != null) {
            handler.postDelayed(this.n, this.l);
        }
        ((RecyclerView.a0) baseViewHolder).itemView.getViewTreeObserver().addOnPreDrawListener(new b(baseViewHolder));
    }

    public void u(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.u(baseViewHolder);
        this.m = false;
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacks(this.n);
        }
    }
}
