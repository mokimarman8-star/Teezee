package com.transsion.postdetail.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.R$layout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/transsion/postdetail/ui/dialog/NoSubtitleTipDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "mCallback", "Lwn/f;", "d", "Lwn/f;", "bind", BuildConfig.FLAVOR, "e", "Z", "isSelect", "f", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NoSubtitleTipDialog extends BaseDialog {

    /* renamed from: c, reason: from kotlin metadata */
    private Function0 mCallback;

    /* renamed from: d, reason: from kotlin metadata */
    private wn.f bind;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isSelect;

    public NoSubtitleTipDialog() {
        super(R$layout.dialog_no_subtitle_tip_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(NoSubtitleTipDialog noSubtitleTipDialog, View view) {
        noSubtitleTipDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(NoSubtitleTipDialog noSubtitleTipDialog, View view) {
        noSubtitleTipDialog.dismissAllowingStateLoss();
        Function0 function0 = noSubtitleTipDialog.mCallback;
        if (function0 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(NoSubtitleTipDialog noSubtitleTipDialog, View view) {
        ImageView imageView;
        wn.f fVar = noSubtitleTipDialog.bind;
        if (fVar != null && (imageView = fVar.b) != null) {
            imageView.setSelected(!noSubtitleTipDialog.isSelect);
        }
        noSubtitleTipDialog.isSelect = !noSubtitleTipDialog.isSelect;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            dismissAllowingStateLoss();
        }
        setStyle(0, R$style.NormalDialogThemeTrans);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.isSelect) {
            com.transsion.baselib.report.launch.b.a.b().putBoolean("no_subtitle_tip_again", false);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("no_subtitle_tip_again", true);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        LinearLayoutCompat linearLayoutCompat;
        TextView textView;
        TextView textView2;
        Window window;
        Window window2;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        this.bind = wn.f.a(view);
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-2, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(17);
        }
        wn.f fVar = this.bind;
        if (fVar != null && (textView2 = fVar.d) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NoSubtitleTipDialog.q0(NoSubtitleTipDialog.this, view2);
                }
            });
        }
        wn.f fVar2 = this.bind;
        if (fVar2 != null && (textView = fVar2.e) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NoSubtitleTipDialog.r0(NoSubtitleTipDialog.this, view2);
                }
            });
        }
        wn.f fVar3 = this.bind;
        if (fVar3 == null || (linearLayoutCompat = fVar3.c) == null) {
            return;
        }
        linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NoSubtitleTipDialog.s0(NoSubtitleTipDialog.this, view2);
            }
        });
    }
}
