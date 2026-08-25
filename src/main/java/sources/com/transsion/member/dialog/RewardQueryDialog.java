package com.transsion.member.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.widget.R;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.R$layout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/transsion/member/dialog/RewardQueryDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lgm/e;", "c", "Lgm/e;", "bind", BuildConfig.FLAVOR, "d", "Ljava/lang/String;", "title", "e", "a", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RewardQueryDialog extends BaseDialog {
    public static final int f = 8;

    /* renamed from: c, reason: from kotlin metadata */
    private gm.e bind;

    /* renamed from: d, reason: from kotlin metadata */
    private String title;

    public RewardQueryDialog() {
        super(R$layout.dialog_fragment_reward_query);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(RewardQueryDialog rewardQueryDialog, View view) {
        rewardQueryDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(RewardQueryDialog rewardQueryDialog, View view) {
        rewardQueryDialog.dismissAllowingStateLoss();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.center_DialogStyle);
        com.transsion.member.a.a.a(getClassTag() + " --> onCreate()");
        if (savedInstanceState != null) {
            dismissAllowingStateLoss();
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString("title", this.title);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        AppCompatTextView appCompatTextView;
        TextView textView;
        AppCompatTextView appCompatTextView2;
        Window window;
        Window window2;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-1, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(17);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setCancelable(true);
        }
        Dialog dialog4 = getDialog();
        if (dialog4 != null) {
            dialog4.setCanceledOnTouchOutside(false);
        }
        gm.e a = gm.e.a(view);
        this.bind = a;
        if (a != null && (appCompatTextView2 = a.f) != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RewardQueryDialog.p0(RewardQueryDialog.this, view2);
                }
            });
        }
        gm.e eVar = this.bind;
        if (eVar != null && (textView = eVar.g) != null) {
            textView.setText(this.title);
        }
        gm.e eVar2 = this.bind;
        if (eVar2 == null || (appCompatTextView = eVar2.d) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RewardQueryDialog.q0(RewardQueryDialog.this, view2);
            }
        });
    }
}
