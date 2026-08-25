package com.cloud.tmc.miniapp.ad.interstitial;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cloud.tmc.ad.R;
import com.cloud.tmc.ad.bean.AdClickBean;
import com.cloud.tmc.ad.bean.AdShowBean;
import com.cloud.tmc.ad.bean.AdStyleBean;
import com.cloud.tmc.ad.bean.DownUpPointBean;
import com.cloud.tmc.ad.interface.AdEventListener;
import com.cloud.tmc.ad.utils.RoundedCornersTransform;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.miniutils.util.ScreenUtils;
import com.cloud.tmc.miniutils.util.SizeUtils;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class AdInterstitialJsonAllStyleView$Builder extends AdBaseDialog {
    public ConstraintLayout OooO;
    public final String OooO0oO;
    public AdEventListener OooO0oo;
    public ImageView OooOO0;
    public ImageView OooOO0O;
    public ImageView OooOO0o;
    public TextView OooOOO;
    public ImageView OooOOO0;
    public TextView OooOOOO;
    public TextView OooOOOo;
    public float OooOOo;
    public ImageView OooOOo0;
    public float OooOOoo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdInterstitialJsonAllStyleView$Builder(Context context, String str, String str2, String str3, String str4, String str5, String str6, AdStyleBean adStyleBean, AdEventListener adEventListener) {
        super(context);
        float f;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "triggerId");
        Intrinsics.h(str2, "mainImgUrl");
        Intrinsics.h(adStyleBean, "styleBean");
        this.OooO0oO = str;
        this.OooO0oo = adEventListener;
        try {
            setContentView(R.layout.view_interstitial_json_all_styles);
            setCanceledOnTouchOutside(false);
            setAnimStyle(-1);
            this.OooO = findViewById(R.id.cl_content);
            this.OooOO0 = (ImageView) findViewById(R.id.iv_main);
            this.OooOO0O = (ImageView) findViewById(R.id.iv_ad);
            this.OooOO0o = (ImageView) findViewById(R.id.iv_homepage);
            this.OooOOO0 = (ImageView) findViewById(R.id.iv_logo);
            this.OooOOo0 = (ImageView) findViewById(R.id.iv_close);
            this.OooOOO = (TextView) findViewById(R.id.tv_title);
            this.OooOOOO = (TextView) findViewById(R.id.tv_content);
            this.OooOOOo = (TextView) findViewById(R.id.tv_next);
            if (adStyleBean.getShowTitle() && !TextUtils.isEmpty(str4) && (textView3 = this.OooOOO) != null) {
                textView3.setVisibility(0);
                textView3.setText(str4);
                TextPaint paint = textView3.getPaint();
                if (paint != null) {
                    paint.setFakeBoldText(true);
                }
            }
            if (adStyleBean.getShowDescript() && !TextUtils.isEmpty(str5) && (textView2 = this.OooOOOO) != null) {
                textView2.setVisibility(0);
                textView2.setText(str5);
            }
            if (adStyleBean.getShowButton() && !TextUtils.isEmpty(str6) && (textView = this.OooOOOo) != null) {
                textView.setVisibility(0);
                textView.setText(str6);
            }
            if (adStyleBean.getShowLogo() && !TextUtils.isEmpty(str3) && new File(str3).exists() && (imageView = this.OooOOO0) != null) {
                RequestOptions transform = new RequestOptions().transform(new RoundedCornersTransform(SizeUtils.dp2px(8.0f), SizeUtils.dp2px(8.0f), SizeUtils.dp2px(8.0f), SizeUtils.dp2px(8.0f)));
                Intrinsics.g(transform, "RequestOptions()\n       …                        )");
                imageView.setVisibility(0);
                Glide.with(context).load(str3).placeholder(Drawable.createFromPath(str3)).apply(transform).into(imageView);
            }
            if (!TextUtils.isEmpty(str2) && new File(str2).exists()) {
                float f2 = StringsKt.G(str2, "gif", false, 2, (Object) null) ? 1.0f : 8.0f;
                if (adStyleBean.getShowButton() || adStyleBean.getShowLogo() || adStyleBean.getShowTitle() || adStyleBean.getShowDescript()) {
                    f = 0.0f;
                } else {
                    f = StringsKt.G(str2, "gif", false, 2, (Object) null) ? 1.0f : 8.0f;
                    ConstraintLayout.b bVar = new ConstraintLayout.b(-1, -2);
                    ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = 0;
                    ImageView imageView2 = this.OooOO0;
                    if (imageView2 != null) {
                        imageView2.setLayoutParams(bVar);
                    }
                }
                ImageView imageView3 = this.OooOO0;
                if (imageView3 != null) {
                    RequestOptions transform2 = new RequestOptions().transform(new RoundedCornersTransform(SizeUtils.dp2px(f2), SizeUtils.dp2px(f2), SizeUtils.dp2px(f), SizeUtils.dp2px(f)));
                    Intrinsics.g(transform2, "RequestOptions()\n       …                        )");
                    RequestOptions requestOptions = transform2;
                    imageView3.setMaxHeight((int) (ScreenUtils.getScreenHeight() * 0.72d));
                    if (StringsKt.G(str2, "gif", false, 2, (Object) null)) {
                        Intrinsics.g(Glide.with(context).asGif().placeholder(Drawable.createFromPath(str2)).load(str2).apply(requestOptions).into(imageView3), "{\n                      …                        }");
                    } else {
                        Intrinsics.g(Glide.with(context).load(str2).placeholder(Drawable.createFromPath(str2)).apply(requestOptions).into(imageView3), "{\n                      …                        }");
                    }
                }
            }
            AdEventListener adEventListener2 = this.OooO0oo;
            if (adEventListener2 != null) {
                adEventListener2.fillingResult(str, true);
            }
            setOnClickListener(this.OooOO0O, this.OooOO0o, this.OooOOo0);
            ConstraintLayout constraintLayout = this.OooO;
            if (constraintLayout != null) {
                constraintLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.cloud.tmc.miniapp.ad.interstitial.d
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return AdInterstitialJsonAllStyleView$Builder.OooO00o(AdInterstitialJsonAllStyleView$Builder.this, view, motionEvent);
                    }
                });
            }
        } catch (Throwable unused) {
            AdEventListener adEventListener3 = this.OooO0oo;
            if (adEventListener3 != null) {
                adEventListener3.fillingResult(this.OooO0oO, false);
            }
        }
    }

    public static final boolean OooO00o(AdInterstitialJsonAllStyleView$Builder adInterstitialJsonAllStyleView$Builder, View view, MotionEvent motionEvent) {
        Intrinsics.h(adInterstitialJsonAllStyleView$Builder, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            adInterstitialJsonAllStyleView$Builder.OooOOo = motionEvent.getX();
            adInterstitialJsonAllStyleView$Builder.OooOOoo = motionEvent.getY();
        } else if (action == 1 && motionEvent.getX() >= 0.0f && motionEvent.getX() <= view.getWidth() && motionEvent.getY() >= 0.0f && motionEvent.getY() <= view.getHeight()) {
            DownUpPointBean downUpPointBean = new DownUpPointBean(adInterstitialJsonAllStyleView$Builder.OooOOo, adInterstitialJsonAllStyleView$Builder.OooOOoo, motionEvent.getX(), motionEvent.getY(), view.getHeight(), view.getWidth());
            AdEventListener adEventListener = adInterstitialJsonAllStyleView$Builder.OooO0oo;
            if (adEventListener != null) {
                AdEventListener.DefaultImpls.click$default(adEventListener, adInterstitialJsonAllStyleView$Builder.OooO0oO, downUpPointBean, (String) null, 4, (Object) null);
            }
        }
        return true;
    }

    @Override // com.cloud.tmc.miniapp.ad.interstitial.AdBaseDialog
    public int OooO00o() {
        ConstraintLayout constraintLayout = this.OooO;
        if (constraintLayout != null) {
            return constraintLayout.getHeight();
        }
        return 0;
    }

    @Override // com.cloud.tmc.miniapp.ad.interstitial.AdBaseDialog
    public void OooO00o(AdShowBean adShowBean) {
        Intrinsics.h(adShowBean, "adShowBean");
        AdEventListener adEventListener = this.OooO0oo;
        if (adEventListener != null) {
            adEventListener.showResult(this.OooO0oO, true, adShowBean);
        }
    }

    @Override // com.cloud.tmc.miniapp.ad.interstitial.AdBaseDialog
    public int OooO0O0() {
        ConstraintLayout constraintLayout = this.OooO;
        if (constraintLayout != null) {
            return constraintLayout.getWidth();
        }
        return 0;
    }

    @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooO00o, com.cloud.tmc.miniapp.action.ClickAction, android.view.View.OnClickListener
    public void onClick(View view) {
        AdEventListener adEventListener;
        Intrinsics.h(view, "view");
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        if (Intrinsics.c(view, this.OooOO0O)) {
            AdEventListener adEventListener2 = this.OooO0oo;
            if (adEventListener2 != null) {
                adEventListener2.clickPersonalization(this.OooO0oO);
                return;
            }
            return;
        }
        if (Intrinsics.c(view, this.OooOO0o)) {
            AdEventListener adEventListener3 = this.OooO0oo;
            if (adEventListener3 != null) {
                adEventListener3.clickHomePage(this.OooO0oO);
                return;
            }
            return;
        }
        if (!Intrinsics.c(view, this.OooOOo0) || (adEventListener = this.OooO0oo) == null) {
            return;
        }
        String str = this.OooO0oO;
        AdClickBean adClickBean = new AdClickBean(0, 0L, (String) null, 7, (DefaultConstructorMarker) null);
        adClickBean.setShowTimes(this.OooO0O0);
        adClickBean.setShowDuration(System.currentTimeMillis() - adClickBean.getShowDuration());
        ConstraintLayout constraintLayout = this.OooO;
        Integer valueOf = constraintLayout != null ? Integer.valueOf(constraintLayout.getWidth()) : null;
        ConstraintLayout constraintLayout2 = this.OooO;
        adClickBean.setShowArea(valueOf + "*" + (constraintLayout2 != null ? Integer.valueOf(constraintLayout2.getHeight()) : null));
        Unit unit = Unit.a;
        adEventListener.closeAd(str, adClickBean);
    }
}
