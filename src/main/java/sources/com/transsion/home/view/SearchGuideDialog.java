package com.transsion.home.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.tn.lib.view.RoundedArrowImageView;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/transsion/home/view/SearchGuideDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", BuildConfig.FLAVOR, "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onResume", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", BuildConfig.FLAVOR, "d0", "()Ljava/lang/String;", "Lqk/g;", "c", "Lqk/g;", "mViewBinding", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "mCallback", "Landroidx/constraintlayout/widget/ConstraintLayout$b;", "e", "Landroidx/constraintlayout/widget/ConstraintLayout$b;", "searchLayoutParam", "f", "a", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchGuideDialog extends BaseDialog {
    public static final int g = 8;
    private static boolean h;

    /* renamed from: c, reason: from kotlin metadata */
    private qk.g mViewBinding;

    /* renamed from: d, reason: from kotlin metadata */
    private Function0 mCallback;

    /* renamed from: e, reason: from kotlin metadata */
    private ConstraintLayout.b searchLayoutParam;

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            RoundedArrowImageView roundedArrowImageView;
            ConstraintLayout constraintLayout;
            AppCompatImageView appCompatImageView;
            AppCompatImageView appCompatImageView2;
            ViewTreeObserver viewTreeObserver;
            qk.g gVar = SearchGuideDialog.this.mViewBinding;
            if (gVar != null && (appCompatImageView2 = gVar.c) != null && (viewTreeObserver = appCompatImageView2.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            qk.g gVar2 = SearchGuideDialog.this.mViewBinding;
            ViewGroup.LayoutParams layoutParams = (gVar2 == null || (appCompatImageView = gVar2.c) == null) ? null : appCompatImageView.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            qk.g gVar3 = SearchGuideDialog.this.mViewBinding;
            ViewGroup.LayoutParams layoutParams2 = (gVar3 == null || (constraintLayout = gVar3.e) == null) ? null : constraintLayout.getLayoutParams();
            Intrinsics.f(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            int marginEnd = (((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams2)).width - bVar.getMarginEnd()) - a0.a(40.0f);
            qk.g gVar4 = SearchGuideDialog.this.mViewBinding;
            if (gVar4 == null || (roundedArrowImageView = gVar4.d) == null) {
                return;
            }
            int a = a0.a(20.0f) + marginEnd;
            a.a.g(wf.a.a, "the bubbleArrowPosition is " + a + ", the marginStart is " + marginEnd, false, 2, (Object) null);
            roundedArrowImageView.setArrowPosition((float) a);
        }
    }

    private final void initView() {
        ConstraintLayout constraintLayout;
        AppCompatImageView appCompatImageView;
        ViewTreeObserver viewTreeObserver;
        ConstraintLayout constraintLayout2;
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(null);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.gravity = 17;
            }
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            if (attributes2 != null) {
                attributes2.width = y.e();
            }
            WindowManager.LayoutParams attributes3 = window.getAttributes();
            if (attributes3 != null) {
                attributes3.height = y.c();
            }
            window.setDimAmount(0.5f);
        }
        qk.g gVar = this.mViewBinding;
        if (gVar != null && (constraintLayout2 = gVar.e) != null) {
            ViewGroup.LayoutParams layoutParams = constraintLayout2.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ConstraintLayout.b bVar2 = this.searchLayoutParam;
            if (bVar2 != null) {
                Intrinsics.e(bVar2);
                ((ViewGroup.MarginLayoutParams) bVar).topMargin = ((ViewGroup.MarginLayoutParams) bVar2).topMargin - com.blankj.utilcode.util.d.c();
                ConstraintLayout.b bVar3 = this.searchLayoutParam;
                Intrinsics.e(bVar3);
                ((ViewGroup.MarginLayoutParams) bVar).width = ((ViewGroup.MarginLayoutParams) bVar3).width;
                ConstraintLayout.b bVar4 = this.searchLayoutParam;
                Intrinsics.e(bVar4);
                ((ViewGroup.MarginLayoutParams) bVar).height = ((ViewGroup.MarginLayoutParams) bVar4).height;
                ConstraintLayout.b bVar5 = this.searchLayoutParam;
                Intrinsics.e(bVar5);
                bVar.setMarginStart(bVar5.getMarginStart());
                a.a aVar = wf.a.a;
                ConstraintLayout.b bVar6 = this.searchLayoutParam;
                Intrinsics.e(bVar6);
                a.a.g(aVar, "the searchLayoutParam.marginStart is " + bVar6.getMarginStart(), false, 2, (Object) null);
            }
            constraintLayout2.setLayoutParams(bVar);
        }
        qk.g gVar2 = this.mViewBinding;
        if (gVar2 != null && (appCompatImageView = gVar2.c) != null && (viewTreeObserver = appCompatImageView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new b());
        }
        qk.g gVar3 = this.mViewBinding;
        if (gVar3 == null || (constraintLayout = gVar3.e) == null) {
            return;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchGuideDialog.p0(SearchGuideDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(SearchGuideDialog searchGuideDialog, View view) {
        a.a.g(wf.a.a, "the search button is clicked", false, 2, (Object) null);
        Function0 function0 = searchGuideDialog.mCallback;
        if (function0 != null) {
        }
        searchGuideDialog.dismiss();
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public String d0() {
        return "POSITION_SEARCH";
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public qi.b newLogViewConfig() {
        return new qi.b("OneClickToDownloadDialog", false, 2, null);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.h(inflater, "inflater");
        qk.g c = qk.g.c(inflater);
        this.mViewBinding = c;
        h = true;
        if (c != null) {
            return c.getRoot();
        }
        return null;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        initView();
        a.a.g(wf.a.a, getClassTag() + " --> onCreate()", false, 2, (Object) null);
        if (savedInstanceState != null) {
            dismissAllowingStateLoss();
        }
    }
}
