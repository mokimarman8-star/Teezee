package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.mmkv.MMKV;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u0019\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/transsion/usercenter/laboratory/LabPhoneBrandDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "Landroid/view/View$OnClickListener;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "text", HttpUrl.FRAGMENT_ENCODE_SET, "q0", "(Ljava/lang/String;)V", "value", "u0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "v", "onClick", "(Landroid/view/View;)V", "Lxu/p;", "c", "Lxu/p;", "getViewBinding", "()Lxu/p;", "setViewBinding", "(Lxu/p;)V", "viewBinding", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LabPhoneBrandDialog extends BaseDialog implements View.OnClickListener {

    /* renamed from: c, reason: from kotlin metadata */
    private xu.p viewBinding;

    public LabPhoneBrandDialog() {
        super(R$layout.dialog_lab_brand);
    }

    private final void q0(String text) {
        if (text == null || text.length() == 0) {
            fh.b.a.e("text is null~");
            return;
        }
        u0(text);
        Toast.makeText(getContext(), "set brand:" + text + " success", 1).show();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(LabPhoneBrandDialog labPhoneBrandDialog, View view) {
        labPhoneBrandDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(LabPhoneBrandDialog labPhoneBrandDialog, View view) {
        EditTextWithClear editTextWithClear;
        xu.p pVar = labPhoneBrandDialog.viewBinding;
        labPhoneBrandDialog.q0(String.valueOf((pVar == null || (editTextWithClear = pVar.d) == null) ? null : editTextWithClear.getText()));
        labPhoneBrandDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(LabPhoneBrandDialog labPhoneBrandDialog, View view) {
        Toast.makeText(labPhoneBrandDialog.getContext(), "reset success", 1).show();
        MMKV c = mg.a.a.c();
        if (c != null) {
            c.putString("phone_brand", HttpUrl.FRAGMENT_ENCODE_SET);
        }
        labPhoneBrandDialog.dismiss();
    }

    private final void u0(String value) {
        MMKV c = mg.a.a.c();
        if (c != null) {
            c.putString("phone_brand", value);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        q0(v instanceof TextView ? ((TextView) v).getText().toString() : HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(savedInstanceState);
        setStyle(0, R$style.BaseDialogStyle);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        AppCompatTextView appCompatTextView6;
        AppCompatTextView appCompatTextView7;
        AppCompatTextView appCompatTextView8;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        this.viewBinding = xu.p.a(view);
        MMKV c = mg.a.a.c();
        String string = c != null ? c.getString("phone_brand", HttpUrl.FRAGMENT_ENCODE_SET) : null;
        xu.p pVar = this.viewBinding;
        if (pVar != null && (appCompatTextView8 = pVar.e) != null) {
            appCompatTextView8.setText(string);
        }
        xu.p pVar2 = this.viewBinding;
        if (pVar2 != null && (appCompatTextView7 = pVar2.b) != null) {
            appCompatTextView7.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabPhoneBrandDialog.r0(LabPhoneBrandDialog.this, view2);
                }
            });
        }
        xu.p pVar3 = this.viewBinding;
        if (pVar3 != null && (appCompatTextView6 = pVar3.c) != null) {
            appCompatTextView6.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabPhoneBrandDialog.s0(LabPhoneBrandDialog.this, view2);
                }
            });
        }
        xu.p pVar4 = this.viewBinding;
        if (pVar4 != null && (appCompatTextView5 = pVar4.i) != null) {
            appCompatTextView5.setOnClickListener(this);
        }
        xu.p pVar5 = this.viewBinding;
        if (pVar5 != null && (appCompatTextView4 = pVar5.f) != null) {
            appCompatTextView4.setOnClickListener(this);
        }
        xu.p pVar6 = this.viewBinding;
        if (pVar6 != null && (appCompatTextView3 = pVar6.g) != null) {
            appCompatTextView3.setOnClickListener(this);
        }
        xu.p pVar7 = this.viewBinding;
        if (pVar7 != null && (appCompatTextView2 = pVar7.h) != null) {
            appCompatTextView2.setOnClickListener(this);
        }
        xu.p pVar8 = this.viewBinding;
        if (pVar8 == null || (appCompatTextView = pVar8.j) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabPhoneBrandDialog.t0(LabPhoneBrandDialog.this, view2);
            }
        });
    }
}
