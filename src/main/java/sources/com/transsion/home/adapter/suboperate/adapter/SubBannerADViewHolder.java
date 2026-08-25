package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.hisavana.common.bean.TAdNativeInfo;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.gslb.GslbSdk;
import com.transsion.gslb.Utils;
import com.transsion.home.R;
import com.transsion.home.adapter.trending.BannerADDataHelper;
import com.transsion.home.bean.BannerData;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubBannerADViewHolder extends RecyclerView.a0 {
    public static final a h = new a(null);
    public static final int i = 8;
    private static final int j = Color.parseColor("#101114");
    private static final int k = a0.a(237.0f);
    private static final int l = a0.a(37.0f);
    private static final int m = a0.a(57.0f);
    private final View a;
    private final View b;
    private final View c;
    private final FrameLayout d;
    private final NativeWrapperAdView e;
    private com.transsion.ad.bidding.base.r f;
    private n0 g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubBannerADViewHolder(View view) {
        super(view);
        Intrinsics.h(view, "itemView");
        View findViewById = view.findViewById(R.id.home_sub_pager_items_status);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.home_sub_pager_items_space);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R.id.home_sub_pager_items_top_mask);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R.id.home_sub_pager_items_container);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.d = (FrameLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.nativeView);
        Intrinsics.g(findViewById5, "findViewById(...)");
        this.e = (NativeWrapperAdView) findViewById5;
    }

    private final GradientDrawable j(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{Color.parseColor(StringsKt.Q(str, Utils.SEPARATOR, "#ff", false, 4, (Object) null)), Color.parseColor(StringsKt.Q(str, Utils.SEPARATOR, "#ff", false, 4, (Object) null)), Color.parseColor(StringsKt.Q(str, Utils.SEPARATOR, "#00", false, 4, (Object) null))});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        return gradientDrawable;
    }

    private final void l(TAdNativeInfo tAdNativeInfo) {
        TAdNativeInfo.Image image;
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        List imageList = tAdNativeInfo.getImageList();
        String url = (imageList == null || (image = (TAdNativeInfo.Image) CollectionsKt.k0(imageList)) == null) ? null : image.getUrl();
        if (url == null || StringsKt.q0(url)) {
            m(-16777216);
        } else {
            Glide.with(GslbSdk.context).asBitmap().load(url).into(new CustomTarget() { // from class: com.transsion.home.adapter.suboperate.adapter.SubBannerADViewHolder$renderHiADMask$1
                public void onLoadCleared(Drawable drawable) {
                }

                public void onLoadFailed(Drawable drawable) {
                    a.a.f(wf.a.a, "BannerADDataHelper", "onLoadFailed", false, 4, (Object) null);
                    SubBannerADViewHolder.this.m(-16777216);
                }

                public void onResourceReady(Bitmap bitmap, Transition transition) {
                    n0 n0Var;
                    Intrinsics.h(bitmap, "resource");
                    n0Var = SubBannerADViewHolder.this.g;
                    if (n0Var != null) {
                        kotlinx.coroutines.i.d(n0Var, y0.b(), (CoroutineStart) null, new SubBannerADViewHolder$renderHiADMask$1$onResourceReady$1(bitmap, SubBannerADViewHolder.this, null), 2, (Object) null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int i2) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format(Locale.ROOT, "#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & i2)}, 1));
        Intrinsics.g(format, "format(...)");
        this.a.setBackgroundColor(i2);
        this.b.setBackgroundColor(i2);
        this.c.setBackground(j(format));
        this.e.post(new Runnable() { // from class: com.transsion.home.adapter.suboperate.adapter.g
            @Override // java.lang.Runnable
            public final void run() {
                SubBannerADViewHolder.n(SubBannerADViewHolder.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(SubBannerADViewHolder subBannerADViewHolder) {
        int measuredHeight = subBannerADViewHolder.e.getMeasuredHeight();
        int i2 = measuredHeight == 0 ? l : measuredHeight < 10 ? 1 : k - measuredHeight;
        subBannerADViewHolder.b.getLayoutParams().height = RangesKt.l(i2, 1, m);
        a.a.f(wf.a.a, "BannerADDataHelper", "nativeViewHeight: " + measuredHeight + ", space height: " + i2 + ", space.layoutParams.height: " + subBannerADViewHolder.b.getLayoutParams().height, false, 4, (Object) null);
        subBannerADViewHolder.b.requestLayout();
        uf.c.k(subBannerADViewHolder.b);
    }

    public final void i(BannerData bannerData) {
        BiddingIntermediateMaterialBean biddingAdData;
        n0 n0Var = this.g;
        if (n0Var == null || !o0.g(n0Var)) {
            this.g = o0.a(y0.c().plus(v1.b((t1) null, 1, (Object) null)));
        }
        this.a.getLayoutParams().height = com.blankj.utilcode.util.d.c();
        this.d.getLayoutParams().height = ((y.e() * 9) / 16) + a0.a(44.0f);
        if (this.f == null) {
            ow.b bVar = ow.b.a;
            Context context = ((RecyclerView.a0) this).itemView.getContext();
            Intrinsics.g(context, "getContext(...)");
            this.f = bVar.a(context, "TrendingNativeBannerScene");
        }
        BannerADDataHelper.a.i(this.e, this.f, bannerData != null ? bannerData.getBiddingAdData() : null);
        if (bannerData == null || (biddingAdData = bannerData.getBiddingAdData()) == null) {
            return;
        }
        this.b.getLayoutParams().height = 0;
        uf.c.g(this.b);
        TAdNativeInfo nativeInfo = biddingAdData.getNativeInfo();
        if (nativeInfo != null) {
            l(nativeInfo);
            return;
        }
        AdPlans plans = biddingAdData.getPlans();
        if (plans != null) {
            ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = -1;
            }
            MbAdImage b = com.transsion.ad.monopoly.plan.c.a.b(plans);
            String averageHueDark = b != null ? b.getAverageHueDark() : null;
            if (averageHueDark != null && StringsKt.c0(averageHueDark, Utils.SEPARATOR, false, 2, (Object) null)) {
                this.a.setBackgroundColor(Color.parseColor(averageHueDark));
                this.c.setBackground(j(averageHueDark));
                return;
            }
            int i2 = j;
            this.a.setBackgroundColor(i2);
            View view = this.c;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format(Locale.ROOT, "#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(i2 & 16777215)}, 1));
            Intrinsics.g(format, "format(...)");
            view.setBackground(j(format));
        }
    }

    public final void k() {
        BannerADDataHelper.a.n();
        n0 n0Var = this.g;
        if (n0Var != null) {
            o0.d(n0Var, (CancellationException) null, 1, (Object) null);
        }
    }
}
