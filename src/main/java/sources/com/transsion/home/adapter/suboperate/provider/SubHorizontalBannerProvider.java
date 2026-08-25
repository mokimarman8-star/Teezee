package com.transsion.home.adapter.suboperate.provider;

import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.widget.OperateScrollableHost;
import com.transsion.gslb.Utils;
import com.transsion.home.R;
import com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter;
import com.transsion.home.bean.BannerBean;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubHorizontalBannerProvider extends BaseItemProvider implements androidx.lifecycle.f {
    private final int e;
    private final BaseHomeSubFragment f;
    private final Set g;
    private Handler h;
    private ViewPager2 i;
    private int j;
    private long k;
    private View l;
    private boolean m;
    private t1 n;
    private OperateItem o;
    private SubHorizontalViewPagerAdapter p;
    private final Runnable q;

    public static final class a extends ViewPager2.OnPageChangeCallback {
        final /* synthetic */ OperateItem a;
        final /* synthetic */ SubHorizontalBannerProvider b;

        a(OperateItem operateItem, SubHorizontalBannerProvider subHorizontalBannerProvider) {
            this.a = operateItem;
            this.b = subHorizontalBannerProvider;
        }

        public void onPageSelected(int i) {
            List<BannerData> banners;
            BannerData bannerData;
            Image image;
            String averageHueLight;
            List<BannerData> banners2;
            BannerBean banner = this.a.getBanner();
            if (banner != null ? Intrinsics.c(banner.getAutoPlay(), Boolean.TRUE) : false) {
                Handler handler = this.b.h;
                if (handler != null) {
                    handler.removeCallbacks(this.b.q);
                }
                Handler handler2 = this.b.h;
                if (handler2 != null) {
                    handler2.postDelayed(this.b.q, this.b.k);
                }
            }
            this.b.j = i;
            BannerBean banner2 = this.a.getBanner();
            int size = i % ((banner2 == null || (banners2 = banner2.getBanners()) == null) ? 1 : banners2.size());
            BannerBean banner3 = this.a.getBanner();
            if (banner3 != null && (banners = banner3.getBanners()) != null && (bannerData = banners.get(size)) != null && (image = bannerData.getImage()) != null && (averageHueLight = image.getAverageHueLight()) != null) {
                SubHorizontalBannerProvider subHorizontalBannerProvider = this.b;
                View view = null;
                GradientDrawable c = sk.a.c(StringsKt.Q(averageHueLight, Utils.SEPARATOR, "#ff", false, 4, (Object) null), StringsKt.Q(averageHueLight, Utils.SEPARATOR, "#00", false, 4, (Object) null), null, 4, null);
                View view2 = subHorizontalBannerProvider.l;
                if (view2 == null) {
                    Intrinsics.y("bgColorView");
                } else {
                    view = view2;
                }
                view.setBackground(c);
            }
            this.b.L(this.a, size);
        }
    }

    public SubHorizontalBannerProvider(int i, BaseHomeSubFragment baseHomeSubFragment) {
        Intrinsics.h(baseHomeSubFragment, "fragment");
        this.e = i;
        this.f = baseHomeSubFragment;
        this.g = new LinkedHashSet();
        this.j = -1;
        this.k = 5000L;
        this.q = new Runnable() { // from class: com.transsion.home.adapter.suboperate.provider.x
            @Override // java.lang.Runnable
            public final void run() {
                SubHorizontalBannerProvider.M(SubHorizontalBannerProvider.this);
            }
        };
    }

    private final void H() {
        Handler handler = this.h;
        if (handler != null) {
            handler.postDelayed(this.q, this.k);
        }
    }

    private final boolean J(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return this.g.add(str);
    }

    private final void K() {
        if (HomeTabId.INSTANCE.h(Integer.valueOf(this.e), true)) {
            this.n = kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SubHorizontalBannerProvider$registerCourse$1(this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(OperateItem operateItem, int i) {
        List<BannerData> banners;
        BannerBean banner = operateItem.getBanner();
        BannerData bannerData = (banner == null || (banners = banner.getBanners()) == null) ? null : banners.get(i);
        if (J(bannerData != null ? bannerData.getSubjectId() : null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "browse_banner");
            hashMap.put("sequence", String.valueOf(i));
            hashMap.put("tabId", String.valueOf(this.e));
            if (bannerData != null) {
                sk.b.b(bannerData, hashMap);
            }
            sk.b.a(operateItem, hashMap);
            com.transsion.baselib.helper.a.a.e(SubTabFragment.INSTANCE.a(this.e), hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(SubHorizontalBannerProvider subHorizontalBannerProvider) {
        if (!subHorizontalBannerProvider.f.isVisible()) {
            if (subHorizontalBannerProvider.f.isAdded()) {
                subHorizontalBannerProvider.H();
                return;
            }
            return;
        }
        ViewPager2 viewPager2 = subHorizontalBannerProvider.i;
        if (viewPager2 == null) {
            Intrinsics.y("viewPager2");
            viewPager2 = null;
        }
        ViewPager2 viewPager22 = subHorizontalBannerProvider.i;
        if (viewPager22 == null) {
            Intrinsics.y("viewPager2");
            viewPager22 = null;
        }
        int currentItem = viewPager22.getCurrentItem() + 1;
        ViewPager2 viewPager23 = subHorizontalBannerProvider.i;
        if (viewPager23 == null) {
            Intrinsics.y("viewPager2");
            viewPager23 = null;
        }
        RecyclerView.Adapter adapter = viewPager23.getAdapter();
        Integer valueOf = adapter != null ? Integer.valueOf(adapter.getItemCount()) : null;
        Intrinsics.e(valueOf);
        viewPager2.setCurrentItem(currentItem % valueOf.intValue());
    }

    private final void N() {
        t1 t1Var = this.n;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        this.n = null;
    }

    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, OperateItem operateItem) {
        List<BannerData> arrayList;
        String interval;
        Integer v;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        this.i = baseViewHolder.getView(R.id.sub_operation_horizontal_view_pager);
        this.l = baseViewHolder.getView(R.id.sub_operation_banner_bg);
        int min = Math.min(com.blankj.utilcode.util.y.e(), com.blankj.utilcode.util.y.c()) - com.blankj.utilcode.util.a0.a(112.0f);
        int i = (int) ((min * 9.0f) / 16);
        View view = this.i;
        ViewPager2 viewPager2 = null;
        if (view == null) {
            Intrinsics.y("viewPager2");
            view = null;
        }
        view.getLayoutParams().height = i;
        ((OperateScrollableHost) baseViewHolder.getView(R.id.sub_operation_view_scroll_helper)).interceptAllEvent(true);
        int h0 = this.f.h0();
        baseViewHolder.getView(R.id.sub_operation_banner_space).getLayoutParams().height = h0;
        View view2 = this.l;
        if (view2 == null) {
            Intrinsics.y("bgColorView");
            view2 = null;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        View view3 = this.i;
        if (view3 == null) {
            Intrinsics.y("viewPager2");
            view3 = null;
        }
        layoutParams.height = h0 + view3.getLayoutParams().height;
        BannerBean banner = operateItem.getBanner();
        if (banner == null || (arrayList = banner.getBanners()) == null) {
            arrayList = new ArrayList<>();
        }
        ViewPager2 viewPager22 = this.i;
        if (viewPager22 == null) {
            Intrinsics.y("viewPager2");
            viewPager22 = null;
        }
        viewPager22.setPageTransformer(new CompositePageTransformer());
        ViewPager2 viewPager23 = this.i;
        if (viewPager23 == null) {
            Intrinsics.y("viewPager2");
            viewPager23 = null;
        }
        viewPager23.setOffscreenPageLimit(3);
        ViewPager2 viewPager24 = this.i;
        if (viewPager24 == null) {
            Intrinsics.y("viewPager2");
            viewPager24 = null;
        }
        viewPager24.setAdapter(new SubHorizontalViewPagerAdapter(arrayList, this.e, operateItem, min, i));
        if (arrayList.isEmpty()) {
            return;
        }
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacks(this.q);
        }
        this.h = new Handler(Looper.getMainLooper());
        ViewPager2 viewPager25 = this.i;
        if (viewPager25 == null) {
            Intrinsics.y("viewPager2");
            viewPager25 = null;
        }
        viewPager25.registerOnPageChangeCallback(new a(operateItem, this));
        BannerBean banner2 = operateItem.getBanner();
        long intValue = ((banner2 == null || (interval = banner2.getInterval()) == null || (v = StringsKt.v(interval)) == null) ? 0 : v.intValue()) * 1000;
        if (intValue <= 0) {
            intValue = this.k;
        }
        this.k = intValue;
        int i2 = this.j;
        if (i2 < 0) {
            i2 = 1073741823 - (1073741823 % arrayList.size());
        }
        ViewPager2 viewPager26 = this.i;
        if (viewPager26 == null) {
            Intrinsics.y("viewPager2");
            viewPager26 = null;
        }
        viewPager26.setCurrentItem(i2, false);
        ViewPager2 viewPager27 = this.i;
        if (viewPager27 == null) {
            Intrinsics.y("viewPager2");
        } else {
            viewPager2 = viewPager27;
        }
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        Intrinsics.f(adapter, "null cannot be cast to non-null type com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter");
        this.p = (SubHorizontalViewPagerAdapter) adapter;
        this.o = operateItem;
    }

    public int l() {
        return PostItemType.HORIZONTAL_BANNER.ordinal();
    }

    public int m() {
        return R.layout.item_sub_operation_horizontal_banner;
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
        handler.removeCallbacks(this.q);
    }

    public void onResume(androidx.lifecycle.u uVar) {
        Handler handler;
        Intrinsics.h(uVar, "owner");
        androidx.lifecycle.e.d(this, uVar);
        if (!this.m || (handler = this.h) == null) {
            return;
        }
        handler.postDelayed(this.q, this.k);
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
            handler.postDelayed(this.q, this.k);
        }
        K();
    }

    public void u(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.u(baseViewHolder);
        this.m = false;
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacks(this.q);
        }
        N();
    }
}
