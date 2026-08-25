package com.transsion.shorttv.base.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.NetworkUtils;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qr.r0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001d\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018¢\u0006\u0004\b\u001d\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/transsion/shorttv/base/widget/NoNetworkBigView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", BuildConfig.FLAVOR, "isShowTitleLayout", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "(Landroid/content/Context;Z)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "marin", BuildConfig.FLAVOR, "setTopMargin", "(I)V", "visible", BuildConfig.FLAVOR, "title", "showTitle", "(ZLjava/lang/String;)V", "Lkotlin/Function0;", "retryListener", "retry", "(Lkotlin/jvm/functions/Function0;)V", "setting", "goToSetting", "onBackClick", "()V", "Lqr/r0;", "a", "Lqr/r0;", "binding", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NoNetworkBigView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private r0 binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoNetworkBigView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoNetworkBigView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, false, 8, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NoNetworkBigView(final Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.binding = r0.b(LayoutInflater.from(context), this);
        setLayoutParams(new ConstraintLayout.b(-1, -1));
        setBackgroundResource(R.color.short_tv_bg_01);
        r0 r0Var = this.binding;
        if (r0Var != null) {
            if (z) {
                AppCompatImageView appCompatImageView = r0Var.c;
                Intrinsics.g(appCompatImageView, "ivBack");
                cr.b.e(appCompatImageView);
                AppCompatTextView appCompatTextView = r0Var.g;
                Intrinsics.g(appCompatTextView, "tvTitle");
                cr.b.e(appCompatTextView);
            } else {
                AppCompatImageView appCompatImageView2 = r0Var.c;
                Intrinsics.g(appCompatImageView2, "ivBack");
                cr.b.b(appCompatImageView2);
                AppCompatTextView appCompatTextView2 = r0Var.g;
                Intrinsics.g(appCompatTextView2, "tvTitle");
                cr.b.b(appCompatTextView2);
            }
            r0Var.c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.base.widget.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NoNetworkBigView.l(context, view);
                }
            });
        }
    }

    public /* synthetic */ NoNetworkBigView(Context context, AttributeSet attributeSet, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, i, (i2 & 8) != 0 ? true : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoNetworkBigView(Context context, boolean z) {
        this(context, null, 0, z);
        Intrinsics.h(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function0 function0, View view) {
        NetworkUtils.v();
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Context context, View view) {
        if (context instanceof Activity) {
            ((Activity) context).onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function0 function0, View view) {
        function0.invoke();
    }

    public static /* synthetic */ void showTitle$default(NoNetworkBigView noNetworkBigView, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = BuildConfig.FLAVOR;
        }
        noNetworkBigView.showTitle(z, str);
    }

    public final void goToSetting(final Function0<Unit> setting) {
        AppCompatTextView appCompatTextView;
        Intrinsics.h(setting, "setting");
        r0 r0Var = this.binding;
        if (r0Var == null || (appCompatTextView = r0Var.b) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.base.widget.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NoNetworkBigView.k(setting, view);
            }
        });
    }

    public final void onBackClick() {
    }

    public final void retry(final Function0<Unit> retryListener) {
        AppCompatTextView appCompatTextView;
        Intrinsics.h(retryListener, "retryListener");
        r0 r0Var = this.binding;
        if (r0Var == null || (appCompatTextView = r0Var.f) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.base.widget.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NoNetworkBigView.m(retryListener, view);
            }
        });
    }

    public final void setTopMargin(int marin) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        r0 r0Var = this.binding;
        ViewGroup.LayoutParams layoutParams = (r0Var == null || (appCompatImageView2 = r0Var.d) == null) ? null : appCompatImageView2.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
        if (bVar == null) {
            bVar = new ConstraintLayout.b(0, -1);
        }
        ((ViewGroup.MarginLayoutParams) bVar).topMargin = marin;
        r0 r0Var2 = this.binding;
        if (r0Var2 == null || (appCompatImageView = r0Var2.d) == null) {
            return;
        }
        appCompatImageView.setLayoutParams(bVar);
    }

    public final void showTitle(boolean visible, String title) {
        Intrinsics.h(title, "title");
        r0 r0Var = this.binding;
        if (r0Var != null) {
            if (visible) {
                AppCompatImageView appCompatImageView = r0Var.c;
                Intrinsics.g(appCompatImageView, "ivBack");
                cr.b.e(appCompatImageView);
                AppCompatTextView appCompatTextView = r0Var.g;
                Intrinsics.g(appCompatTextView, "tvTitle");
                cr.b.e(appCompatTextView);
            } else {
                AppCompatImageView appCompatImageView2 = r0Var.c;
                Intrinsics.g(appCompatImageView2, "ivBack");
                cr.b.b(appCompatImageView2);
                AppCompatTextView appCompatTextView2 = r0Var.g;
                Intrinsics.g(appCompatTextView2, "tvTitle");
                cr.b.b(appCompatTextView2);
            }
            r0Var.g.setText(title);
        }
    }
}
