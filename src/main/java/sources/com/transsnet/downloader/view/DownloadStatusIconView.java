package com.transsnet.downloader.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import bx.f1;
import com.airbnb.lottie.LottieAnimationView;
import com.blankj.utilcode.util.a0;
import com.transsnet.downloader.R;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ij.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import wf.a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u000eJ\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u000eJ\u001d\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0014¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\fH\u0014¢\u0006\u0004\b!\u0010\u000eJ\u000f\u0010\"\u001a\u00020\fH\u0014¢\u0006\u0004\b\"\u0010\u000eR\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010.R\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00100¨\u00062"}, d2 = {"Lcom/transsnet/downloader/view/DownloadStatusIconView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", HttpUrl.FRAGMENT_ENCODE_SET, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", HttpUrl.FRAGMENT_ENCODE_SET, "d", "()V", "e", "size", "f", "(I)V", "g", HttpUrl.FRAGMENT_ENCODE_SET, "showAnima", "setAnima", "(Z)V", "c", "h", "status", "onDownloadStatusChange", "(II)V", "resId", "isBanner", "setDownloadIcon", "(IZ)V", "onDetachedFromWindow", "onAttachedToWindow", "Lbx/f1;", "a", "Lbx/f1;", "viewBinding", "b", "Z", "isShowAnima", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/String;", "animaJsonName", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "lavView", "I", "lastTag", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadStatusIconView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final f1 viewBinding;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean isShowAnima;

    /* renamed from: c, reason: from kotlin metadata */
    private String animaJsonName;

    /* renamed from: d, reason: from kotlin metadata */
    private LottieAnimationView lavView;

    /* renamed from: e, reason: from kotlin metadata */
    private int lastTag;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadStatusIconView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadStatusIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadStatusIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        View.inflate(getContext(), R.layout.view_download_status_icon, this);
        f1 a = f1.a(this);
        Intrinsics.g(a, "bind(...)");
        this.viewBinding = a;
        d();
        new AsyncLayoutInflater(context).a(R.layout.view_download_status_icon_lav, (ViewGroup) null, new AsyncLayoutInflater.d() { // from class: com.transsnet.downloader.view.a
            public final void a(View view, int i2, ViewGroup viewGroup) {
                DownloadStatusIconView.b(DownloadStatusIconView.this, view, i2, viewGroup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DownloadStatusIconView downloadStatusIconView, View view, int i, ViewGroup viewGroup) {
        LottieAnimationView lottieAnimationView;
        Intrinsics.h(view, "view");
        if (view instanceof LottieAnimationView) {
            downloadStatusIconView.lavView = (LottieAnimationView) view;
            int a = a0.a(24.0f);
            downloadStatusIconView.addView((View) downloadStatusIconView.lavView, 0, (ViewGroup.LayoutParams) new FrameLayout.LayoutParams(a, a));
            String str = downloadStatusIconView.animaJsonName;
            if (str != null && (lottieAnimationView = downloadStatusIconView.lavView) != null) {
                lottieAnimationView.setAnimation(str);
            }
            if (downloadStatusIconView.isShowAnima) {
                downloadStatusIconView.c();
            } else {
                downloadStatusIconView.h();
            }
        }
    }

    private final void c() {
        LottieAnimationView lottieAnimationView = this.lavView;
        if (lottieAnimationView == null) {
            return;
        }
        if (lottieAnimationView != null) {
            lottieAnimationView.setRepeatCount(-1);
        }
        if (isAttachedToWindow()) {
            LottieAnimationView lottieAnimationView2 = this.lavView;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.playAnimation();
            }
        } else {
            LottieAnimationView lottieAnimationView3 = this.lavView;
            if (lottieAnimationView3 != null) {
                lottieAnimationView3.pauseAnimation();
            }
        }
        LottieAnimationView lottieAnimationView4 = this.lavView;
        if (lottieAnimationView4 != null) {
            uf.c.k(lottieAnimationView4);
        }
        ImageView ivDownloadIcon = this.viewBinding.c;
        Intrinsics.g(ivDownloadIcon, "ivDownloadIcon");
        uf.c.g(ivDownloadIcon);
    }

    private final void d() {
        View vDownloadTips = this.viewBinding.e;
        Intrinsics.g(vDownloadTips, "vDownloadTips");
        uf.c.g(vDownloadTips);
        AppCompatImageView ivDownloadFail = this.viewBinding.b;
        Intrinsics.g(ivDownloadFail, "ivDownloadFail");
        uf.c.g(ivDownloadFail);
        AppCompatTextView tvDownloadStatus = this.viewBinding.d;
        Intrinsics.g(tvDownloadStatus, "tvDownloadStatus");
        uf.c.g(tvDownloadStatus);
    }

    private final void e() {
        View vDownloadTips = this.viewBinding.e;
        Intrinsics.g(vDownloadTips, "vDownloadTips");
        uf.c.g(vDownloadTips);
        AppCompatImageView ivDownloadFail = this.viewBinding.b;
        Intrinsics.g(ivDownloadFail, "ivDownloadFail");
        uf.c.k(ivDownloadFail);
        AppCompatTextView tvDownloadStatus = this.viewBinding.d;
        Intrinsics.g(tvDownloadStatus, "tvDownloadStatus");
        uf.c.g(tvDownloadStatus);
    }

    private final void f(int size) {
        View vDownloadTips = this.viewBinding.e;
        Intrinsics.g(vDownloadTips, "vDownloadTips");
        uf.c.g(vDownloadTips);
        AppCompatImageView ivDownloadFail = this.viewBinding.b;
        Intrinsics.g(ivDownloadFail, "ivDownloadFail");
        uf.c.g(ivDownloadFail);
        if (size <= 0) {
            AppCompatTextView tvDownloadStatus = this.viewBinding.d;
            Intrinsics.g(tvDownloadStatus, "tvDownloadStatus");
            uf.c.g(tvDownloadStatus);
        } else {
            String valueOf = size > 99 ? "99+" : String.valueOf(size);
            AppCompatTextView tvDownloadStatus2 = this.viewBinding.d;
            Intrinsics.g(tvDownloadStatus2, "tvDownloadStatus");
            uf.c.k(tvDownloadStatus2);
            this.viewBinding.d.setText(valueOf);
        }
    }

    private final void g() {
        View vDownloadTips = this.viewBinding.e;
        Intrinsics.g(vDownloadTips, "vDownloadTips");
        uf.c.k(vDownloadTips);
        AppCompatImageView ivDownloadFail = this.viewBinding.b;
        Intrinsics.g(ivDownloadFail, "ivDownloadFail");
        uf.c.g(ivDownloadFail);
        AppCompatTextView tvDownloadStatus = this.viewBinding.d;
        Intrinsics.g(tvDownloadStatus, "tvDownloadStatus");
        uf.c.g(tvDownloadStatus);
    }

    private final void h() {
        LottieAnimationView lottieAnimationView = this.lavView;
        if (lottieAnimationView == null) {
            return;
        }
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView2 = this.lavView;
        if (lottieAnimationView2 != null) {
            uf.c.g(lottieAnimationView2);
        }
        ImageView ivDownloadIcon = this.viewBinding.c;
        Intrinsics.g(ivDownloadIcon, "ivDownloadIcon");
        uf.c.k(ivDownloadIcon);
    }

    private final void setAnima(boolean showAnima) {
        this.isShowAnima = showAnima;
        if (showAnima) {
            c();
        } else {
            h();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LottieAnimationView lottieAnimationView;
        super.onAttachedToWindow();
        if (!this.isShowAnima || (lottieAnimationView = this.lavView) == null) {
            return;
        }
        lottieAnimationView.resumeAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        LottieAnimationView lottieAnimationView;
        super.onDetachedFromWindow();
        if (!this.isShowAnima || (lottieAnimationView = this.lavView) == null) {
            return;
        }
        lottieAnimationView.pauseAnimation();
    }

    public final void onDownloadStatusChange(int status, int size) {
        if (status == 0) {
            a.a.f(wf.a.a, "DownloadStatus", "View onDownloadStatusChange, showDefault", false, 4, (Object) null);
            setAnima(false);
            d();
            return;
        }
        if (status == 1) {
            a.a.f(wf.a.a, "DownloadStatus", "View onDownloadStatusChange, showTips", false, 4, (Object) null);
            setAnima(false);
            g();
            return;
        }
        if (status == 2) {
            a.a.f(wf.a.a, "DownloadStatus", "View onDownloadStatusChange, showFail", false, 4, (Object) null);
            setAnima(false);
            e();
            return;
        }
        if (status == 3) {
            a.a.f(wf.a.a, "DownloadStatus", "View onDownloadStatusChange, showFail anima", false, 4, (Object) null);
            setAnima(true);
            e();
        } else if (status == 4) {
            a.a.f(wf.a.a, "DownloadStatus", "View onDownloadStatusChange, showStatus", false, 4, (Object) null);
            setAnima(false);
            f(size);
        } else {
            if (status != 5) {
                return;
            }
            a.a.f(wf.a.a, "DownloadStatus", "View onDownloadStatusChange, showStatus anima", false, 4, (Object) null);
            setAnima(true);
            f(size);
        }
    }

    public final void setDownloadIcon(int resId, boolean isBanner) {
        int a = androidx.compose.foundation.e.a(isBanner) + resId;
        if (a == this.lastTag) {
            return;
        }
        this.lastTag = a;
        this.viewBinding.c.setImageResource(resId);
        String str = isBanner ? "download_icon_status_anima_home.json" : y.a.a() ? "download_icon_status_anima_home_fit_night.json" : "download_icon_status_anima_home_fit.json";
        this.animaJsonName = str;
        LottieAnimationView lottieAnimationView = this.lavView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation(str);
        }
        if (this.isShowAnima) {
            c();
        } else {
            h();
        }
    }
}
