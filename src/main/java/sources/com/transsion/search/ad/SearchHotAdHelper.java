package com.transsion.search.ad;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.blankj.utilcode.util.a0;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.bidding.nativead.BiddingSspNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.wrapperad.R;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;
import ow.s;
import y0.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchHotAdHelper {
    public static final a n = new a(null);
    private final LifecycleCoroutineScope a;
    private BiddingSspNativeManager b;
    private List c;
    private List d;
    private BiddingNativeManager e;
    private NativeWrapperAdView f;
    private SearchHotAdContainerView g;
    private Function1 h;
    private boolean i;
    private ObjectAnimator j;
    private Runnable k;
    private final c l;
    private final b m;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b extends oh.a {
        b() {
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            SearchHotAdHelper.this.n(biddingIntermediateMaterialBean);
        }
    }

    public static final class c extends oh.a {
        c() {
        }

        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            SearchHotAdHelper.this.t();
        }

        public void k(List list) {
            super.k(list);
            SearchHotAdHelper.this.o(list);
        }
    }

    public SearchHotAdHelper(LifecycleCoroutineScope lifecycleCoroutineScope) {
        Intrinsics.h(lifecycleCoroutineScope, "lifecycleScope");
        this.a = lifecycleCoroutineScope;
        this.l = new c();
        this.m = new b();
    }

    private final void k() {
        Runnable runnable = new Runnable() { // from class: com.transsion.search.ad.a
            @Override // java.lang.Runnable
            public final void run() {
                SearchHotAdHelper.l(SearchHotAdHelper.this);
            }
        };
        this.k = runnable;
        NativeWrapperAdView nativeWrapperAdView = this.f;
        if (nativeWrapperAdView != null) {
            nativeWrapperAdView.postDelayed(runnable, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(SearchHotAdHelper searchHotAdHelper) {
        NativeWrapperAdView nativeWrapperAdView = searchHotAdHelper.f;
        AppCompatTextView findViewById = nativeWrapperAdView != null ? nativeWrapperAdView.findViewById(R.id.native_ad_action) : null;
        if (findViewById != null) {
            ObjectAnimator duration = ObjectAnimator.ofArgb(findViewById, "textColor", findViewById.getCurrentTextColor(), androidx.core.content.b.getColor(findViewById.getContext(), com.transsion.ad.R.color.gray_dark_00)).setDuration(300L);
            Intrinsics.g(duration, "setDuration(...)");
            Drawable background = findViewById.getBackground();
            if (background == null) {
                background = h.e(findViewById.getContext().getResources(), android.R.color.transparent, findViewById.getContext().getTheme());
            }
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{background, h.e(findViewById.getContext().getResources(), R.drawable.bg_gradient_brand_4, findViewById.getContext().getTheme())});
            findViewById.setBackground(transitionDrawable);
            transitionDrawable.startTransition(300);
            duration.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        NativeWrapperAdView nativeWrapperAdView;
        SearchHotAdContainerView searchHotAdContainerView = this.g;
        if (searchHotAdContainerView == null || (nativeWrapperAdView = searchHotAdContainerView.getNativeWrapperAdView()) == null) {
            return;
        }
        this.f = nativeWrapperAdView;
        ow.b bVar = ow.b.a;
        Context context = nativeWrapperAdView.getContext();
        Intrinsics.g(context, "getContext(...)");
        nativeWrapperAdView.bindNativeView(this.e, bVar.a(context, "SearchHotNativeScene"), biddingIntermediateMaterialBean);
        x();
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.transsion.search.ad.SearchHotAdContainerView] */
    public final void o(List list) {
        List list2;
        BiddingSspNativeManager biddingSspNativeManager;
        ?? r0 = this.g;
        if (r0 == 0) {
            return;
        }
        List<NativeWrapperAdView> hiNativeAdViews = r0.getHiNativeAdViews();
        this.c = hiNativeAdViews;
        if (list != null) {
            this.d = list;
        } else {
            list = null;
        }
        List<NativeWrapperAdView> list3 = hiNativeAdViews;
        if (list3 == null || list3.isEmpty() || (list2 = list) == null || list2.isEmpty() || (biddingSspNativeManager = this.b) == null) {
            return;
        }
        int min = Math.min(hiNativeAdViews.size(), list.size());
        for (int i = 0; i < min; i++) {
            Context context = r0.getContext();
            Intrinsics.g(context, "getContext(...)");
            NativeWrapperAdView.bindSspNativeView$default(hiNativeAdViews.get(i), biddingSspNativeManager, null, new s(context), (BiddingIntermediateMaterialBean) list.get(i), 2, null);
        }
        x();
    }

    private final void q() {
        NativeWrapperAdView nativeWrapperAdView;
        ObjectAnimator objectAnimator = this.j;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.j = null;
        Runnable runnable = this.k;
        if (runnable != null && (nativeWrapperAdView = this.f) != null) {
            nativeWrapperAdView.removeCallbacks(runnable);
        }
        this.k = null;
    }

    private final void r() {
        BiddingNativeManager biddingNativeManager = this.e;
        if (biddingNativeManager != null) {
            biddingNativeManager.U();
        }
        this.e = null;
        q();
    }

    private final void s() {
        List list = this.c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((NativeWrapperAdView) it.next()).removeAllViews();
            }
        }
        this.c = null;
        BiddingSspNativeManager biddingSspNativeManager = this.b;
        if (biddingSspNativeManager != null) {
            biddingSspNativeManager.U();
        }
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        r();
        i.d(this.a, y0.b(), (CoroutineStart) null, new SearchHotAdHelper$loadBiddingAd$1(this, null), 2, (Object) null);
    }

    private final void u() {
        s();
        i.d(this.a, y0.b(), (CoroutineStart) null, new SearchHotAdHelper$loadHiAd$1(this, null), 2, (Object) null);
    }

    private final void v() {
        w();
        k();
    }

    private final void w() {
        NativeWrapperAdView nativeWrapperAdView = this.f;
        ImageView imageView = nativeWrapperAdView != null ? (ImageView) nativeWrapperAdView.findViewWithTag("adVolumeImage") : null;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 8388691;
            int a2 = a0.a(8.0f);
            layoutParams2.setMarginStart(a2);
            layoutParams2.bottomMargin = a2;
            int a3 = a0.a(26.0f);
            layoutParams2.width = a3;
            layoutParams2.height = a3;
        }
    }

    private final void x() {
        this.i = true;
        Function1 function1 = this.h;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    public final void m(SearchHotAdContainerView searchHotAdContainerView) {
        this.g = searchHotAdContainerView;
        u();
    }

    public final void p() {
        s();
        r();
        this.h = null;
        SearchHotAdContainerView searchHotAdContainerView = this.g;
        if (searchHotAdContainerView != null) {
            searchHotAdContainerView.destroy();
        }
        this.g = null;
    }

    public final void y(Function1 function1) {
        Intrinsics.h(function1, "callback");
        this.h = function1;
        if (this.i) {
            function1.invoke(Boolean.TRUE);
        }
    }
}
