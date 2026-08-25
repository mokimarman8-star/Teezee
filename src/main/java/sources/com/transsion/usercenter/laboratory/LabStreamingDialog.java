package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import com.transsion.baselib.utils.PlayMode;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/transsion/usercenter/laboratory/LabStreamingDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", HttpUrl.FRAGMENT_ENCODE_SET, "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lxu/z;", "c", "Lxu/z;", "viewBinding", "Lcom/transsion/baselib/utils/PlayMode;", "d", "Lcom/transsion/baselib/utils/PlayMode;", "playMode", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LabStreamingDialog extends BaseDialog {

    /* renamed from: c, reason: from kotlin metadata */
    private xu.z viewBinding;

    /* renamed from: d, reason: from kotlin metadata */
    private PlayMode playMode;

    public LabStreamingDialog() {
        super(R$layout.dialog_lab_streaming_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(LabStreamingDialog labStreamingDialog, View view) {
        labStreamingDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(LabStreamingDialog labStreamingDialog, View view) {
        fh.b.a.e("当前媒体播放模式是 playMode = " + labStreamingDialog.playMode);
        PlayMode playMode = labStreamingDialog.playMode;
        if (playMode != null) {
            ij.t.a.c(playMode);
        }
        labStreamingDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(LabStreamingDialog labStreamingDialog, RadioGroup radioGroup, int i) {
        if (i == R$id.radioButtonDownload) {
            fh.b.a.e("PlayMode.DOWNLOAD");
            labStreamingDialog.playMode = PlayMode.DOWNLOAD;
        } else if (i == R$id.radioButtonStream) {
            fh.b.a.e("PlayMode.STREAM");
            labStreamingDialog.playMode = PlayMode.STREAM;
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
        this.viewBinding = xu.z.a(view);
        if (getActivity() != null) {
            if (ij.t.a.b()) {
                xu.z zVar = this.viewBinding;
                if (zVar != null && (radioGroup3 = zVar.f) != null) {
                    radioGroup3.check(R$id.radioButtonStream);
                }
                this.playMode = PlayMode.STREAM;
            } else {
                xu.z zVar2 = this.viewBinding;
                if (zVar2 != null && (radioGroup2 = zVar2.f) != null) {
                    radioGroup2.check(R$id.radioButtonDownload);
                }
                this.playMode = PlayMode.DOWNLOAD;
            }
        }
        xu.z zVar3 = this.viewBinding;
        if (zVar3 != null && (button2 = zVar3.b) != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabStreamingDialog.q0(LabStreamingDialog.this, view2);
                }
            });
        }
        xu.z zVar4 = this.viewBinding;
        if (zVar4 != null && (button = zVar4.c) != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.h0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabStreamingDialog.r0(LabStreamingDialog.this, view2);
                }
            });
        }
        xu.z zVar5 = this.viewBinding;
        if (zVar5 == null || (radioGroup = zVar5.f) == null) {
            return;
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.transsion.usercenter.laboratory.i0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup4, int i) {
                LabStreamingDialog.s0(LabStreamingDialog.this, radioGroup4, i);
            }
        });
    }
}
