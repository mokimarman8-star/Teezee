package com.transsion.shorttv.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.shorttv.R;
import com.transsion.shorttv.bean.Subject;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001a\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001a\u0010\u001dR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/transsion/shorttv/ui/widget/ShortTvDownloadInfoExtendView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", HttpUrl.FRAGMENT_ENCODE_SET, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", HttpUrl.FRAGMENT_ENCODE_SET, "m", "()V", "r", HttpUrl.FRAGMENT_ENCODE_SET, "l", "()Z", "o", "k", HttpUrl.FRAGMENT_ENCODE_SET, "getNewTextByConfig", "()Ljava/lang/String;", "Lcom/transsion/shorttv/bean/Subject;", "bean", "showData", "(Lcom/transsion/shorttv/bean/Subject;)V", "desc", "(Ljava/lang/String;)V", "a", "Z", "isExtend", "Lqr/s0;", "b", "Lqr/s0;", "mViewBinding", "c", "Ljava/lang/String;", "description", "d", "I", "mMaxLinesOnShrink", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ShortTvDownloadInfoExtendView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private boolean isExtend;

    /* renamed from: b, reason: from kotlin metadata */
    private qr.s0 mViewBinding;

    /* renamed from: c, reason: from kotlin metadata */
    private String description;

    /* renamed from: d, reason: from kotlin metadata */
    private final int mMaxLinesOnShrink;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvDownloadInfoExtendView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvDownloadInfoExtendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvDownloadInfoExtendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        m();
        this.isExtend = true;
        this.mMaxLinesOnShrink = 3;
    }

    private final String getNewTextByConfig() {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        qr.s0 s0Var;
        AppCompatTextView appCompatTextView3;
        String str = this.description;
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        qr.s0 s0Var2 = this.mViewBinding;
        if (s0Var2 == null || (appCompatTextView = s0Var2.c) == null) {
            return str;
        }
        TextPaint paint = appCompatTextView.getPaint();
        Intrinsics.g(paint, "getPaint(...)");
        StaticLayout build = Build.VERSION.SDK_INT > 23 ? StaticLayout.Builder.obtain(str, 0, str.length(), paint, appCompatTextView.getWidth()).build() : new StaticLayout(str, paint, appCompatTextView.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        Intrinsics.e(build);
        if (build.getLineCount() <= this.mMaxLinesOnShrink) {
            if (l() || (s0Var = this.mViewBinding) == null || (appCompatTextView3 = s0Var.b) == null) {
                return str;
            }
            appCompatTextView3.setVisibility(8);
            return str;
        }
        qr.s0 s0Var3 = this.mViewBinding;
        if (s0Var3 != null && (appCompatTextView2 = s0Var3.b) != null) {
            appCompatTextView2.setVisibility(appCompatTextView.getVisibility());
        }
        return ((Object) str.subSequence(0, build.getLineEnd(this.mMaxLinesOnShrink - 1) - 3)) + "...";
    }

    private final void k() {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        this.isExtend = true;
        qr.s0 s0Var = this.mViewBinding;
        if (s0Var != null && (appCompatTextView2 = s0Var.b) != null) {
            appCompatTextView2.setText(appCompatTextView2.getContext().getString(R.string.short_tv_str_hide));
            Drawable drawable = appCompatTextView2.getContext().getDrawable(R.mipmap.short_tv_ic_up_hide);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            }
            appCompatTextView2.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
        qr.s0 s0Var2 = this.mViewBinding;
        if (s0Var2 == null || (appCompatTextView = s0Var2.c) == null) {
            return;
        }
        appCompatTextView.setText(this.description);
    }

    private final boolean l() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m() {
        AppCompatTextView appCompatTextView;
        qr.s0 a = qr.s0.a(View.inflate(getContext(), R.layout.short_tv_view_download_info_extend_layout, this));
        this.mViewBinding = a;
        if (a == null || (appCompatTextView = a.b) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.widget.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvDownloadInfoExtendView.n(ShortTvDownloadInfoExtendView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ShortTvDownloadInfoExtendView shortTvDownloadInfoExtendView, View view) {
        if (shortTvDownloadInfoExtendView.isExtend) {
            shortTvDownloadInfoExtendView.o();
        } else {
            shortTvDownloadInfoExtendView.k();
        }
    }

    private final void o() {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        this.isExtend = false;
        qr.s0 s0Var = this.mViewBinding;
        if (s0Var != null && (appCompatTextView2 = s0Var.b) != null) {
            appCompatTextView2.setText(appCompatTextView2.getContext().getString(R.string.short_tv_str_more));
            Drawable drawable = appCompatTextView2.getContext().getDrawable(R.mipmap.short_tv_ic_down_more);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            }
            appCompatTextView2.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
        qr.s0 s0Var2 = this.mViewBinding;
        if (s0Var2 == null || (appCompatTextView = s0Var2.c) == null) {
            return;
        }
        appCompatTextView.setText(getNewTextByConfig());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ShortTvDownloadInfoExtendView shortTvDownloadInfoExtendView) {
        shortTvDownloadInfoExtendView.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ShortTvDownloadInfoExtendView shortTvDownloadInfoExtendView) {
        shortTvDownloadInfoExtendView.r();
    }

    private final void r() {
        o();
    }

    public final void showData(Subject bean) {
        String str;
        ConstraintLayout b;
        if (bean == null || (str = bean.getDescription()) == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        this.description = str;
        qr.s0 s0Var = this.mViewBinding;
        if (s0Var == null || (b = s0Var.b()) == null) {
            return;
        }
        b.post(new Runnable() { // from class: com.transsion.shorttv.ui.widget.o
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvDownloadInfoExtendView.p(ShortTvDownloadInfoExtendView.this);
            }
        });
    }

    public final void showData(String desc) {
        ConstraintLayout b;
        if (desc == null) {
            desc = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        this.description = desc;
        qr.s0 s0Var = this.mViewBinding;
        if (s0Var == null || (b = s0Var.b()) == null) {
            return;
        }
        b.post(new Runnable() { // from class: com.transsion.shorttv.ui.widget.n
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvDownloadInfoExtendView.q(ShortTvDownloadInfoExtendView.this);
            }
        });
    }
}
