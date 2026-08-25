package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/transsion/usercenter/laboratory/LabContentModeDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", HttpUrl.FRAGMENT_ENCODE_SET, "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lxu/r;", "c", "Lxu/r;", "viewBinding", HttpUrl.FRAGMENT_ENCODE_SET, "d", "Z", "isUGCMode", "e", "isResetMode", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LabContentModeDialog extends BaseDialog {

    /* renamed from: c, reason: from kotlin metadata */
    private xu.r viewBinding;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isUGCMode;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isResetMode;

    public LabContentModeDialog() {
        super(R$layout.dialog_lab_content_mode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(LabContentModeDialog labContentModeDialog, View view) {
        labContentModeDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(LabContentModeDialog labContentModeDialog, View view) {
        if (labContentModeDialog.isResetMode) {
            fh.b.a.e("当前媒体播放模式已使用线上配置");
            com.transsion.baselib.report.launch.b.a.b().remove("key_or_content_mode_local");
        } else {
            fh.b.a.e("当前媒体播放模式是 playMode = " + (labContentModeDialog.isUGCMode ? "UGCVideo" : "Subject"));
            ij.g.a.e(labContentModeDialog.isUGCMode);
            com.transsion.baselib.report.launch.b.a.b().putInt("key_or_content_mode_local", labContentModeDialog.isUGCMode ? 1 : 0);
        }
        labContentModeDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(LabContentModeDialog labContentModeDialog, RadioGroup radioGroup, int i) {
        if (i == R$id.radioButtonSubject) {
            labContentModeDialog.isUGCMode = false;
            labContentModeDialog.isResetMode = false;
        } else if (i == R$id.radioButtonUGCVideo) {
            labContentModeDialog.isUGCMode = true;
            labContentModeDialog.isResetMode = false;
        } else if (i == R$id.radioButtonReset) {
            labContentModeDialog.isUGCMode = false;
            labContentModeDialog.isResetMode = true;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(savedInstanceState);
        setStyle(0, R$style.BaseDialogStyle);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        Button button;
        Button button2;
        RadioGroup radioGroup4;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        this.viewBinding = xu.r.a(view);
        if (com.transsion.baselib.report.launch.b.a.b().getInt("key_or_content_mode_local", -1) == -1) {
            xu.r rVar = this.viewBinding;
            if (rVar != null && (radioGroup4 = rVar.g) != null) {
                radioGroup4.check(R$id.radioButtonReset);
            }
            this.isResetMode = true;
            this.isUGCMode = false;
        } else if (ij.g.a.b()) {
            xu.r rVar2 = this.viewBinding;
            if (rVar2 != null && (radioGroup2 = rVar2.g) != null) {
                radioGroup2.check(R$id.radioButtonUGCVideo);
            }
            this.isUGCMode = true;
            this.isResetMode = false;
        } else {
            xu.r rVar3 = this.viewBinding;
            if (rVar3 != null && (radioGroup = rVar3.g) != null) {
                radioGroup.check(R$id.radioButtonSubject);
            }
            this.isUGCMode = false;
            this.isResetMode = false;
        }
        xu.r rVar4 = this.viewBinding;
        if (rVar4 != null && (button2 = rVar4.b) != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabContentModeDialog.q0(LabContentModeDialog.this, view2);
                }
            });
        }
        xu.r rVar5 = this.viewBinding;
        if (rVar5 != null && (button = rVar5.c) != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabContentModeDialog.r0(LabContentModeDialog.this, view2);
                }
            });
        }
        xu.r rVar6 = this.viewBinding;
        if (rVar6 == null || (radioGroup3 = rVar6.g) == null) {
            return;
        }
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.transsion.usercenter.laboratory.f
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup5, int i) {
                LabContentModeDialog.s0(LabContentModeDialog.this, radioGroup5, i);
            }
        });
    }
}
