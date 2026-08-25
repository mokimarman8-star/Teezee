package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.NetworkUtils;
import com.tn.lib.widget.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u000bJ\u001b\u0010\u000f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/tn/lib/view/NoNetworkSmallView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "Lkotlin/Function0;", "", "retryListener", "retry", "(Lkotlin/jvm/functions/Function0;)V", "settingListener", "goToSetting", "Leh/d;", "a", "Leh/d;", "binding", "UI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class NoNetworkSmallView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private eh.d binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoNetworkSmallView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoNetworkSmallView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NoNetworkSmallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.binding = eh.d.b(LayoutInflater.from(context), this);
        setBackgroundResource(R.mipmap.bg_network_view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(NoNetworkSmallView noNetworkSmallView, Function0 function0, View view) {
        try {
            Result.Companion companion = Result.Companion;
            NetworkUtils.v();
            Result.constructor-impl(Unit.a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th));
        }
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(Function0 function0, final eh.d dVar, NoNetworkSmallView noNetworkSmallView, View view) {
        function0.invoke();
        AppCompatTextView appCompatTextView = dVar.d;
        Intrinsics.g(appCompatTextView, "retry");
        uf.c.g(appCompatTextView);
        AppCompatTextView appCompatTextView2 = dVar.b;
        Intrinsics.g(appCompatTextView2, "goToSetting");
        uf.c.g(appCompatTextView2);
        AppCompatTextView appCompatTextView3 = dVar.f;
        Intrinsics.g(appCompatTextView3, "tvTitle");
        uf.c.g(appCompatTextView3);
        ProgressBar progressBar = dVar.c;
        Intrinsics.g(progressBar, "progressBar");
        uf.c.k(progressBar);
        noNetworkSmallView.postDelayed(new Runnable() { // from class: com.tn.lib.view.r
            @Override // java.lang.Runnable
            public final void run() {
                NoNetworkSmallView.m(eh.d.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(eh.d dVar) {
        AppCompatTextView appCompatTextView = dVar.d;
        Intrinsics.g(appCompatTextView, "retry");
        uf.c.k(appCompatTextView);
        AppCompatTextView appCompatTextView2 = dVar.b;
        Intrinsics.g(appCompatTextView2, "goToSetting");
        uf.c.k(appCompatTextView2);
        AppCompatTextView appCompatTextView3 = dVar.f;
        Intrinsics.g(appCompatTextView3, "tvTitle");
        uf.c.k(appCompatTextView3);
        ProgressBar progressBar = dVar.c;
        Intrinsics.g(progressBar, "progressBar");
        uf.c.g(progressBar);
    }

    public final void goToSetting(final Function0<Unit> settingListener) {
        AppCompatTextView appCompatTextView;
        Intrinsics.h(settingListener, "settingListener");
        eh.d dVar = this.binding;
        if (dVar == null || (appCompatTextView = dVar.b) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NoNetworkSmallView.k(NoNetworkSmallView.this, settingListener, view);
            }
        });
    }

    public final void retry(final Function0<Unit> retryListener) {
        Intrinsics.h(retryListener, "retryListener");
        final eh.d dVar = this.binding;
        if (dVar != null) {
            dVar.d.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NoNetworkSmallView.l(retryListener, dVar, this, view);
                }
            });
        }
    }
}
