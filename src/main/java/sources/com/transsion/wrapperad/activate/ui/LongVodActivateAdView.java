package com.transsion.wrapperad.activate.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.ad.ps.activate.PSActivateManager;
import com.transsion.ad.ps.activate.PsActivateBean;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;
import com.transsion.wrapperad.activate.ui.LongVodActivateAdView;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import nw.e;
import okhttp3.HttpUrl;
import wf.a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/transsion/wrapperad/activate/ui/LongVodActivateAdView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", HttpUrl.FRAGMENT_ENCODE_SET, "destroy", "()V", "Lcom/transsion/ad/ps/activate/PsActivateBean;", "activateAd", "Lcom/transsion/wrapperad/activate/ui/LongVodActivateDialog;", "longVodActivateDialog", "Lnw/e;", "listener", "showAd", "(Lcom/transsion/ad/ps/activate/PsActivateBean;Lcom/transsion/wrapperad/activate/ui/LongVodActivateDialog;Lnw/e;)V", "a", "Lnw/e;", HttpUrl.FRAGMENT_ENCODE_SET, "b", "Ljava/util/List;", "activateList", "c", "Lcom/transsion/ad/ps/activate/PsActivateBean;", "clickActivateBean", "wrapperad_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LongVodActivateAdView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private e listener;

    /* renamed from: b, reason: from kotlin metadata */
    private final List activateList;

    /* renamed from: c, reason: from kotlin metadata */
    private PsActivateBean clickActivateBean;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public LongVodActivateAdView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LongVodActivateAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.activateList = new ArrayList();
    }

    public /* synthetic */ LongVodActivateAdView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TextView textView, LongVodActivateAdView longVodActivateAdView, LongVodActivateDialog longVodActivateDialog, e eVar, View view, View view2) {
        ImageView imageView;
        PsActivateBean b = PSActivateManager.a.b();
        if (b != null) {
            longVodActivateAdView.showAd(b, longVodActivateDialog, eVar);
            return;
        }
        a.a.g(a.a, "LongVodActivateAdView --> showAd() --> 没有广告了", false, 2, (Object) null);
        if (view != null && (imageView = (ImageView) view.findViewById(R$id.ivRefresh)) != null) {
            imageView.setVisibility(8);
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TextView textView, PsActivateBean psActivateBean, e eVar, LongVodActivateAdView longVodActivateAdView, LongVodActivateDialog longVodActivateDialog, View view) {
        if (ci.e.a.b(textView.getContext(), psActivateBean.getPackageName())) {
            eVar.a(true);
        } else {
            eVar.a(false);
        }
        longVodActivateAdView.clickActivateBean = psActivateBean;
        if (longVodActivateDialog != null) {
            longVodActivateDialog.q0(MRAIDPresenter.OPEN, psActivateBean.getPackageName());
        }
    }

    public final void destroy() {
    }

    public final void showAd(final PsActivateBean activateAd, final LongVodActivateDialog longVodActivateDialog, final e listener) {
        Intrinsics.h(activateAd, "activateAd");
        Intrinsics.h(listener, "listener");
        this.listener = listener;
        this.activateList.add(activateAd);
        a.a.g(a.a, "LongVodActivateAdView --> showAd() --> " + activateAd, false, 2, (Object) null);
        View inflate = TextUtils.isEmpty(activateAd.getShowContent()) ? LayoutInflater.from(getContext()).inflate(R$layout.long_vod_activate_ad_view_style_1_layout, (ViewGroup) null) : LayoutInflater.from(getContext()).inflate(R$layout.long_vod_activate_ad_view_style_2_layout, (ViewGroup) null);
        removeAllViews();
        addView(inflate);
        AppCompatImageView findViewById = inflate.findViewById(R$id.activateAdImage);
        if (findViewById != null) {
            f.a aVar = f.a;
            Context context = findViewById.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(activateAd.getShowContent()).d(findViewById);
        }
        AppCompatImageView findViewById2 = inflate.findViewById(R$id.activateAdIcon);
        if (findViewById2 != null) {
            f.a aVar2 = f.a;
            Context context2 = findViewById2.getContext();
            Intrinsics.g(context2, "getContext(...)");
            aVar2.m(context2).g(activateAd.getIconUrl()).d(findViewById2);
        }
        TextView textView = (TextView) inflate.findViewById(R$id.activateAdTitle);
        if (textView != null) {
            textView.setText(activateAd.getAppName());
        }
        TextView textView2 = (TextView) inflate.findViewById(R$id.activateAdDescription);
        if (textView2 != null) {
            textView2.setText(activateAd.getSimpleDescription());
        }
        final TextView textView3 = (TextView) inflate.findViewById(R$id.tvTryMore);
        if (textView3 != null) {
            final View view = inflate;
            textView3.setOnClickListener(new View.OnClickListener() { // from class: nw.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LongVodActivateAdView.c(textView3, this, longVodActivateDialog, listener, view, view2);
                }
            });
        }
        final TextView textView4 = (TextView) inflate.findViewById(R$id.activateAdBtn);
        if (textView4 != null) {
            textView4.setText(activateAd.getButtonText());
            textView4.setOnClickListener(new View.OnClickListener() { // from class: nw.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LongVodActivateAdView.d(textView4, activateAd, listener, this, longVodActivateDialog, view2);
                }
            });
        }
    }
}
