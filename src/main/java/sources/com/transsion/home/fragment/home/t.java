package com.transsion.home.fragment.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.wrapperad.view.BiddingRectangleIrregularView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class t {
    private BiddingRectangleIrregularView a;
    private BiddingRectangleIrregularView b;

    public static final class a extends oh.a {
        final /* synthetic */ FrameLayout d;

        a(FrameLayout frameLayout) {
            this.d = frameLayout;
        }

        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            this.d.setVisibility(8);
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            this.d.setVisibility(0);
        }

        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
            this.d.setVisibility(8);
        }
    }

    public static final class b extends oh.a {
        final /* synthetic */ View d;
        final /* synthetic */ FrameLayout e;

        b(View view, FrameLayout frameLayout) {
            this.d = view;
            this.e = frameLayout;
        }

        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            this.e.setVisibility(8);
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            this.d.setVisibility(8);
            this.e.setVisibility(0);
        }

        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
            this.e.setVisibility(8);
        }
    }

    public final void a() {
        BiddingRectangleIrregularView biddingRectangleIrregularView = this.a;
        if (biddingRectangleIrregularView != null) {
            biddingRectangleIrregularView.onAdViewDestroy();
        }
        BiddingRectangleIrregularView biddingRectangleIrregularView2 = this.b;
        if (biddingRectangleIrregularView2 != null) {
            biddingRectangleIrregularView2.onAdViewDestroy();
        }
    }

    public final void b(FrameLayout frameLayout, FrameLayout frameLayout2, View view, n0 n0Var) {
        Intrinsics.h(frameLayout, "flGameCenter");
        Intrinsics.h(frameLayout2, "flPhoneCenter");
        Intrinsics.h(view, "leftLogo");
        if (this.a == null) {
            Context context = frameLayout.getContext();
            Intrinsics.g(context, "getContext(...)");
            BiddingRectangleIrregularView biddingRectangleIrregularView = new BiddingRectangleIrregularView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            this.a = biddingRectangleIrregularView;
            biddingRectangleIrregularView.setSceneId("HomeRIGHTTopGameNonstandardScene");
            BiddingRectangleIrregularView biddingRectangleIrregularView2 = this.a;
            if (biddingRectangleIrregularView2 != null) {
                biddingRectangleIrregularView2.setIrregularAdListener(new a(frameLayout));
            }
            BiddingRectangleIrregularView biddingRectangleIrregularView3 = this.a;
            if (biddingRectangleIrregularView3 != null) {
                biddingRectangleIrregularView3.loadAd();
            }
            frameLayout.removeAllViews();
            frameLayout.addView(this.a);
        }
        if (this.b == null) {
            Context context2 = frameLayout2.getContext();
            Intrinsics.g(context2, "getContext(...)");
            BiddingRectangleIrregularView biddingRectangleIrregularView4 = new BiddingRectangleIrregularView(context2, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            this.b = biddingRectangleIrregularView4;
            biddingRectangleIrregularView4.setSceneId("HomeLeftTopBrandNonstandardScene");
            BiddingRectangleIrregularView biddingRectangleIrregularView5 = this.b;
            if (biddingRectangleIrregularView5 != null) {
                biddingRectangleIrregularView5.setIrregularAdListener(new b(view, frameLayout2));
            }
            BiddingRectangleIrregularView biddingRectangleIrregularView6 = this.b;
            if (biddingRectangleIrregularView6 != null) {
                biddingRectangleIrregularView6.loadAd();
            }
            frameLayout2.removeAllViews();
            frameLayout2.addView(this.b);
        }
    }

    public final void c() {
        BiddingRectangleIrregularView biddingRectangleIrregularView = this.a;
        if (biddingRectangleIrregularView != null) {
            biddingRectangleIrregularView.loadAd();
        }
        BiddingRectangleIrregularView biddingRectangleIrregularView2 = this.b;
        if (biddingRectangleIrregularView2 != null) {
            biddingRectangleIrregularView2.loadAd();
        }
    }
}
