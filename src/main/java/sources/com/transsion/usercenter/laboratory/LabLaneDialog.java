package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mmkv.MMKV;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/transsion/usercenter/laboratory/LabLaneDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "Landroid/view/View$OnClickListener;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "lane", HttpUrl.FRAGMENT_ENCODE_SET, "t0", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "v", "onClick", "(Landroid/view/View;)V", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LabLaneDialog extends BaseDialog implements View.OnClickListener {
    public LabLaneDialog() {
        super(R$layout.dialog_lab_lane);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(LabLaneDialog labLaneDialog, View view) {
        labLaneDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(xu.w wVar, LabLaneDialog labLaneDialog, View view) {
        Editable text = wVar.d.getText();
        if (text == null || text.length() == 0) {
            fh.b.a.e("text is null~");
        } else {
            labLaneDialog.t0(text.toString());
            labLaneDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(LabLaneDialog labLaneDialog, View view) {
        Toast.makeText(labLaneDialog.getContext(), "reset success", 1).show();
        jg.b.a.b("x-md-global-color", HttpUrl.FRAGMENT_ENCODE_SET);
        MMKV c = mg.a.a.c();
        if (c != null) {
            c.putString("x-md-global-color", HttpUrl.FRAGMENT_ENCODE_SET);
        }
        labLaneDialog.dismiss();
    }

    private final void t0(String lane) {
        Toast.makeText(getContext(), "set \"" + lane + "\" success", 1).show();
        jg.b.a.b("x-md-global-color", lane);
        MMKV c = mg.a.a.c();
        if (c != null) {
            c.putString("x-md-global-color", lane);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.f(v, "null cannot be cast to non-null type android.widget.TextView");
        t0(((TextView) v).getText().toString());
        dismiss();
    }

    public void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(savedInstanceState);
        setStyle(0, R$style.BaseDialogStyle);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        final xu.w a = xu.w.a(view);
        Intrinsics.g(a, "bind(...)");
        MMKV c = mg.a.a.c();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (c != null && (string = c.getString("x-md-global-color", HttpUrl.FRAGMENT_ENCODE_SET)) != null) {
            str = string;
        }
        a.j.setText(str);
        a.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabLaneDialog.q0(LabLaneDialog.this, view2);
            }
        });
        a.c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabLaneDialog.r0(xu.w.this, this, view2);
            }
        });
        a.e.setOnClickListener(this);
        a.f.setOnClickListener(this);
        a.g.setOnClickListener(this);
        a.h.setOnClickListener(this);
        a.i.setOnClickListener(this);
        a.k.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabLaneDialog.s0(LabLaneDialog.this, view2);
            }
        });
    }
}
