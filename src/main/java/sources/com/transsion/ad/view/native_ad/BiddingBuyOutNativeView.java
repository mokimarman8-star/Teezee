package com.transsion.ad.view.native_ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ci.g;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.transsion.ad.bidding.base.AbsBiddingBuyOutView;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.base.w;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.strategy.h;
import com.transsion.ad.view.AdTagView;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xh.b;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/transsion/ad/view/native_ad/BiddingBuyOutNativeView;", "Lcom/transsion/ad/bidding/base/AbsBiddingBuyOutView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/widget/FrameLayout;", "getMediaContainer", "()Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "isShowVolumeIcon", "()Z", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", "Lcom/transsion/ad/bidding/base/r;", "adLayoutProvider", BuildConfig.FLAVOR, "bindNativeView", "(Lcom/transsion/ad/bidding/base/r;)V", "Lcom/transsion/ad/bidding/base/w;", "p", "Lcom/transsion/ad/bidding/base/w;", "adProviderBean", "q", "Z", "mIsShowVolumeIcon", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class BiddingBuyOutNativeView extends AbsBiddingBuyOutView {

    /* renamed from: p, reason: from kotlin metadata */
    private w adProviderBean;

    /* renamed from: q, reason: from kotlin metadata */
    private boolean mIsShowVolumeIcon;

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BiddingBuyOutNativeView(Context context) {
        this(context, r0, 2, r0);
        Intrinsics.h(context, "context");
        AttributeSet attributeSet = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BiddingBuyOutNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.mIsShowVolumeIcon = true;
    }

    public /* synthetic */ BiddingBuyOutNativeView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(BiddingBuyOutNativeView biddingBuyOutNativeView, View view) {
        Intrinsics.h(view, "it");
        biddingBuyOutNativeView.onAdClick();
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void bindNativeView(r adLayoutProvider) {
        Integer e;
        MbAdImage image;
        MbAdImage image2;
        MbAdImage image3;
        AdMaterialList adMaterialList;
        if (getAdPlans() == null || adLayoutProvider == null) {
            return;
        }
        Context context = getContext();
        String str = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && activity.isDestroyed()) {
            b.a.c(this, 5, "bindNativeView() --> 当前Activity销毁，广告就不需要展示了", null, false, 4, null);
            return;
        }
        w g = adLayoutProvider.g();
        this.adProviderBean = g;
        this.mIsShowVolumeIcon = adLayoutProvider.A();
        Integer l = g.l();
        if (l != null) {
            TextView textView = (TextView) g.i().findViewById(l.intValue());
            if (textView != null) {
                AdMaterialList adMaterialList2 = getAdMaterialList();
                textView.setText(adMaterialList2 != null ? adMaterialList2.getTitle() : null);
            }
        }
        Integer g2 = g.g();
        if (g2 != null) {
            TextView textView2 = (TextView) g.i().findViewById(g2.intValue());
            if (textView2 != null) {
                AdMaterialList adMaterialList3 = getAdMaterialList();
                textView2.setText(adMaterialList3 != null ? adMaterialList3.getDesc() : null);
            }
        }
        Integer f = g.f();
        if (f != null) {
            TextView textView3 = (TextView) g.i().findViewById(f.intValue());
            if (textView3 != null) {
                AdMaterialList adMaterialList4 = getAdMaterialList();
                if (TextUtils.isEmpty(adMaterialList4 != null ? adMaterialList4.getButtonText() : null) && (adMaterialList = getAdMaterialList()) != null) {
                    adMaterialList.setButtonText("GO");
                }
                AdMaterialList adMaterialList5 = getAdMaterialList();
                textView3.setText(adMaterialList5 != null ? adMaterialList5.getButtonText() : null);
                textView3.setOnClickListener(new g(0L, new Function1() { // from class: com.transsion.ad.view.native_ad.a
                    public final Object invoke(Object obj) {
                        Unit k;
                        k = BiddingBuyOutNativeView.k(BiddingBuyOutNativeView.this, (View) obj);
                        return k;
                    }
                }, 1, null));
            }
        }
        Integer h = g.h();
        if (h != null) {
            FrameLayout frameLayout = (FrameLayout) g.i().findViewById(h.intValue());
            if (frameLayout != null) {
                frameLayout.removeAllViews();
                ImageView imageView = new ImageView(frameLayout.getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                AdPlans adPlans = getAdPlans();
                if (TextUtils.isEmpty(adPlans != null ? adPlans.getAdvertiserAvatarPath() : null)) {
                    RequestManager with = Glide.with(frameLayout.getContext());
                    AdPlans adPlans2 = getAdPlans();
                    with.load(adPlans2 != null ? adPlans2.getAdvertiserAvatar() : null).fitCenter().into(imageView);
                } else {
                    RequestManager with2 = Glide.with(frameLayout.getContext());
                    AdPlans adPlans3 = getAdPlans();
                    with2.load(adPlans3 != null ? adPlans3.getAdvertiserAvatarPath() : null).fitCenter().into(imageView);
                }
                frameLayout.addView(imageView);
            }
        }
        AdMaterialList adMaterialList6 = getAdMaterialList();
        if (Intrinsics.c(adMaterialList6 != null ? adMaterialList6.getType() : null, AdMaterialList.NON_AD_TYPE_TEXT) && (e = g.e()) != null) {
            ImageView imageView2 = (ImageView) g.i().findViewById(e.intValue());
            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            AdMaterialList adMaterialList7 = getAdMaterialList();
            if (TextUtils.isEmpty((adMaterialList7 == null || (image3 = adMaterialList7.getImage()) == null) ? null : image3.getPath())) {
                AdMaterialList adMaterialList8 = getAdMaterialList();
                if (adMaterialList8 != null && (image2 = adMaterialList8.getImage()) != null) {
                    str = image2.getUrl();
                }
            } else {
                AdMaterialList adMaterialList9 = getAdMaterialList();
                if (adMaterialList9 != null && (image = adMaterialList9.getImage()) != null) {
                    str = image.getPath();
                }
            }
            Glide.with(getContext()).load(str).transform(new ei.a(25)).into(imageView2);
        }
        Integer c = g.c();
        if (c != null) {
            ConstraintLayout constraintLayout = (AdTagView) g.i().findViewById(c.intValue());
            if (constraintLayout != null) {
                h.a.a(constraintLayout);
            }
        }
        showMedia();
        removeAllViews();
        addView(g.i(), new FrameLayout.LayoutParams(-1, -1));
    }

    public String getLogTag() {
        return "ad_n";
    }

    public FrameLayout getMediaContainer() {
        Integer h;
        View i;
        Integer j;
        View i2;
        w wVar = this.adProviderBean;
        if (wVar != null && (j = wVar.j()) != null) {
            int intValue = j.intValue();
            w wVar2 = this.adProviderBean;
            if (wVar2 == null || (i2 = wVar2.i()) == null) {
                return null;
            }
            return (FrameLayout) i2.findViewById(intValue);
        }
        w wVar3 = this.adProviderBean;
        if (wVar3 == null || (h = wVar3.h()) == null) {
            return null;
        }
        int intValue2 = h.intValue();
        w wVar4 = this.adProviderBean;
        if (wVar4 == null || (i = wVar4.i()) == null) {
            return null;
        }
        return (FrameLayout) i.findViewById(intValue2);
    }

    /* renamed from: isShowVolumeIcon, reason: from getter */
    public boolean getMIsShowVolumeIcon() {
        return this.mIsShowVolumeIcon;
    }
}
