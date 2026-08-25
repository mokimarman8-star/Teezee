package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/transsion/usercenter/laboratory/LabFpsDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", HttpUrl.FRAGMENT_ENCODE_SET, "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lxu/t;", "c", "Lxu/t;", "viewBinding", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LabFpsDialog extends BaseDialog {

    /* renamed from: c, reason: from kotlin metadata */
    private xu.t viewBinding;

    public LabFpsDialog() {
        super(R$layout.dialog_lab_fps_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(LabFpsDialog labFpsDialog, View view) {
        labFpsDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(LabFpsDialog labFpsDialog, View view) {
        labFpsDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(RadioGroup radioGroup, int i) {
        if (i == R$id.radioButtonFpsOpen) {
            fh.b.a.e("show fps");
            com.transsion.baselib.report.launch.b.a.b().putString("debug_fps", MRAIDPresenter.OPEN);
        } else if (i == R$id.radioButtonFpsClose) {
            fh.b.a.e("dismiss fps");
            com.transsion.baselib.report.launch.b.a.b().putString("debug_fps", MRAIDPresenter.CLOSE);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(savedInstanceState);
        setStyle(0, R$style.BaseDialogStyle);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        RadioGroup radioGroup;
        Button button;
        Button button2;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        this.viewBinding = xu.t.a(view);
        if (getActivity() != null) {
            if (Intrinsics.c(com.transsion.baselib.report.launch.b.a.b().getString("debug_fps", HttpUrl.FRAGMENT_ENCODE_SET), MRAIDPresenter.OPEN)) {
                xu.t tVar = this.viewBinding;
                if (tVar != null && (radioGroup3 = tVar.f) != null) {
                    radioGroup3.check(R$id.radioButtonFpsOpen);
                }
            } else {
                xu.t tVar2 = this.viewBinding;
                if (tVar2 != null && (radioGroup2 = tVar2.f) != null) {
                    radioGroup2.check(R$id.radioButtonFpsClose);
                }
            }
        }
        xu.t tVar3 = this.viewBinding;
        if (tVar3 != null && (button2 = tVar3.b) != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabFpsDialog.q0(LabFpsDialog.this, view2);
                }
            });
        }
        xu.t tVar4 = this.viewBinding;
        if (tVar4 != null && (button = tVar4.c) != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabFpsDialog.r0(LabFpsDialog.this, view2);
                }
            });
        }
        xu.t tVar5 = this.viewBinding;
        if (tVar5 == null || (radioGroup = tVar5.f) == null) {
            return;
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.transsion.usercenter.laboratory.o
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup4, int i) {
                LabFpsDialog.s0(radioGroup4, i);
            }
        });
    }
}
