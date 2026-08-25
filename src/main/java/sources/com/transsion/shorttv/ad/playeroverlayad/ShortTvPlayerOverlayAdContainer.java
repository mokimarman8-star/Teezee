package com.transsion.shorttv.ad.playeroverlayad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ci.q;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/transsion/shorttv/ad/playeroverlayad/ShortTvPlayerOverlayAdContainer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "addAdView", "()V", "removeAdView", "a", "Landroid/widget/FrameLayout;", "rootView", "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "b", "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "getNativeAdView", "()Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "setNativeAdView", "(Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;)V", "nativeAdView", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getCountdownView", "()Landroid/widget/TextView;", "setCountdownView", "(Landroid/widget/TextView;)V", "countdownView", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "getCloseView", "()Landroid/widget/ImageView;", "setCloseView", "(Landroid/widget/ImageView;)V", "closeView", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvPlayerOverlayAdContainer extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final FrameLayout rootView;

    /* renamed from: b, reason: from kotlin metadata */
    private NativeWrapperAdView nativeAdView;

    /* renamed from: c, reason: from kotlin metadata */
    private TextView countdownView;

    /* renamed from: d, reason: from kotlin metadata */
    private ImageView closeView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShortTvPlayerOverlayAdContainer(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShortTvPlayerOverlayAdContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShortTvPlayerOverlayAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        LayoutInflater.from(context).inflate(R.layout.shortv_player_ad_overlay_container_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.root_view);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.rootView = (FrameLayout) findViewById;
        this.nativeAdView = (NativeWrapperAdView) findViewById(R.id.native_ad_view);
        this.countdownView = (TextView) findViewById(R.id.count_down_view);
        this.closeView = (ImageView) findViewById(R.id.close_view);
    }

    public /* synthetic */ ShortTvPlayerOverlayAdContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void addAdView() {
        removeAdView();
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        NativeWrapperAdView nativeWrapperAdView = new NativeWrapperAdView(context, null, 2, null);
        this.nativeAdView = nativeWrapperAdView;
        this.rootView.addView(nativeWrapperAdView, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    public final ImageView getCloseView() {
        return this.closeView;
    }

    public final TextView getCountdownView() {
        return this.countdownView;
    }

    public final NativeWrapperAdView getNativeAdView() {
        return this.nativeAdView;
    }

    public final void removeAdView() {
        q.a.a(this.nativeAdView);
        this.nativeAdView = null;
    }

    public final void setCloseView(ImageView imageView) {
        this.closeView = imageView;
    }

    public final void setCountdownView(TextView textView) {
        this.countdownView = textView;
    }

    public final void setNativeAdView(NativeWrapperAdView nativeWrapperAdView) {
        this.nativeAdView = nativeWrapperAdView;
    }
}
