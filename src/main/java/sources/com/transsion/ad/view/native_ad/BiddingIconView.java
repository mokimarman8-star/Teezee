package com.transsion.ad.view.native_ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.transsion.ad.bidding.base.AbsBiddingBuyOutView;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.base.w;
import com.transsion.ad.ps.model.ItemDetail;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import xh.b;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/transsion/ad/view/native_ad/BiddingIconView;", "Lcom/transsion/ad/bidding/base/AbsBiddingBuyOutView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/widget/FrameLayout;", "getMediaContainer", "()Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "isShowVolumeIcon", "()Z", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", BuildConfig.FLAVOR, "iconPerformClick", "()V", "Lcom/transsion/ad/bidding/base/r;", "adLayoutProvider", "bindIconView", "(Lcom/transsion/ad/bidding/base/r;)V", "Lcom/transsion/ad/bidding/base/w;", "p", "Lcom/transsion/ad/bidding/base/w;", "adProviderBean", "q", "Z", "mIsShowVolumeIcon", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class BiddingIconView extends AbsBiddingBuyOutView {

    /* renamed from: p, reason: from kotlin metadata */
    private w adProviderBean;

    /* renamed from: q, reason: from kotlin metadata */
    private boolean mIsShowVolumeIcon;

    public static final class a implements RequestListener {
        a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z) {
            Intrinsics.h(drawable, "resource");
            Intrinsics.h(obj, "model");
            Intrinsics.h(dataSource, "dataSource");
            if (drawable instanceof GifDrawable) {
                ((GifDrawable) drawable).start();
            }
            BiddingIconView.this.setAdMaterialShow(true);
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
            Intrinsics.h(target, "target");
            BiddingIconView.this.f("图片加载失败 --> " + (glideException != null ? glideException.getMessage() : null));
            return false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BiddingIconView(Context context) {
        this(context, r0, 2, r0);
        Intrinsics.h(context, "context");
        AttributeSet attributeSet = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BiddingIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.mIsShowVolumeIcon = true;
    }

    public /* synthetic */ BiddingIconView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void bindIconView(r adLayoutProvider) {
        ItemDetail detail;
        ItemDetail detail2;
        ItemDetail detail3;
        if (getRecommendInfo() == null || adLayoutProvider == null) {
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && activity.isDestroyed()) {
            b.a.c(this, 5, "当前Activity销毁，广告就不需要展示了", null, false, 4, null);
            return;
        }
        w g = adLayoutProvider.g();
        this.adProviderBean = g;
        this.mIsShowVolumeIcon = adLayoutProvider.A();
        Integer l = g.l();
        if (l != null) {
            TextView textView = (TextView) g.i().findViewById(l.intValue());
            if (textView != null) {
                RecommendInfo recommendInfo = getRecommendInfo();
                textView.setText((recommendInfo == null || (detail3 = recommendInfo.getDetail()) == null) ? null : detail3.getName());
            }
        }
        Integer g2 = g.g();
        if (g2 != null) {
            TextView textView2 = (TextView) g.i().findViewById(g2.intValue());
            if (textView2 != null) {
                RecommendInfo recommendInfo2 = getRecommendInfo();
                textView2.setText((recommendInfo2 == null || (detail2 = recommendInfo2.getDetail()) == null) ? null : detail2.getSimpleDescription());
            }
        }
        Integer f = g.f();
        if (f != null) {
            TextView textView3 = (TextView) g.i().findViewById(f.intValue());
            if (textView3 != null) {
                RecommendInfo recommendInfo3 = getRecommendInfo();
                textView3.setText(recommendInfo3 != null ? recommendInfo3.getButtonText() : null);
                RecommendInfo recommendInfo4 = getRecommendInfo();
                if (TextUtils.isEmpty(recommendInfo4 != null ? recommendInfo4.getButtonText() : null)) {
                    textView3.setVisibility(8);
                }
            }
        }
        i.f((CoroutineContext) null, new BiddingIconView$bindIconView$4(g, this, null), 1, (Object) null);
        Integer k = g.k();
        if (k != null) {
            TextView textView4 = (TextView) g.i().findViewById(k.intValue());
            if (textView4 != null) {
                RecommendInfo recommendInfo5 = getRecommendInfo();
                textView4.setText((recommendInfo5 == null || (detail = recommendInfo5.getDetail()) == null) ? null : detail.getStar());
            }
        }
        Integer h = g.h();
        if (h != null) {
            FrameLayout frameLayout = (FrameLayout) g.i().findViewById(h.intValue());
            if (frameLayout != null) {
                frameLayout.removeAllViews();
                ImageView imageView = new ImageView(frameLayout.getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                RequestManager with = Glide.with(frameLayout.getContext());
                RecommendInfo recommendInfo6 = getRecommendInfo();
                with.load(recommendInfo6 != null ? recommendInfo6.getIconUrl() : null).listener(new a()).into(imageView);
                frameLayout.addView(imageView);
            }
        }
        Integer e = g.e();
        if (e != null) {
            ImageView imageView2 = (ImageView) g.i().findViewById(e.intValue());
            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RequestManager with2 = Glide.with(getContext());
            RecommendInfo recommendInfo7 = getRecommendInfo();
            with2.load(recommendInfo7 != null ? recommendInfo7.getIconUrl() : null).transform(new ei.a(25)).into(imageView2);
        }
        addSession();
        removeAllViews();
        addView(g.i(), new FrameLayout.LayoutParams(-1, -1));
    }

    public String getLogTag() {
        return "ad_ic";
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

    public final void iconPerformClick() {
        onAdClick();
    }

    /* renamed from: isShowVolumeIcon, reason: from getter */
    public boolean getMIsShowVolumeIcon() {
        return this.mIsShowVolumeIcon;
    }
}
