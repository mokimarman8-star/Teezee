package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.dialog.BaseViewBindingDialog;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$style;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rR.\u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/transsion/usercenter/laboratory/LabLocationDialog;", "Lcom/transsion/baseui/dialog/BaseViewBindingDialog;", "Lxu/x;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", HttpUrl.FRAGMENT_ENCODE_SET, "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", HttpUrl.FRAGMENT_ENCODE_SET, "n0", "()Lkotlin/jvm/functions/Function3;", "bindingInflater", "d", "a", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LabLocationDialog extends BaseViewBindingDialog<xu.x> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(LabLocationDialog labLocationDialog, View view) {
        EditTextWithClear editTextWithClear;
        Editable text;
        EditTextWithClear editTextWithClear2;
        Editable text2;
        EditTextWithClear editTextWithClear3;
        Editable text3;
        EditTextWithClear editTextWithClear4;
        Editable text4;
        xu.x xVar = (xu.x) labLocationDialog.o0();
        String str = null;
        String obj = (xVar == null || (editTextWithClear4 = xVar.e) == null || (text4 = editTextWithClear4.getText()) == null) ? null : text4.toString();
        xu.x xVar2 = (xu.x) labLocationDialog.o0();
        String obj2 = (xVar2 == null || (editTextWithClear3 = xVar2.f) == null || (text3 = editTextWithClear3.getText()) == null) ? null : text3.toString();
        xu.x xVar3 = (xu.x) labLocationDialog.o0();
        String obj3 = (xVar3 == null || (editTextWithClear2 = xVar3.g) == null || (text2 = editTextWithClear2.getText()) == null) ? null : text2.toString();
        xu.x xVar4 = (xu.x) labLocationDialog.o0();
        if (xVar4 != null && (editTextWithClear = xVar4.d) != null && (text = editTextWithClear.getText()) != null) {
            str = text.toString();
        }
        if (obj == null || obj.length() == 0) {
            Toast.makeText(labLocationDialog.getContext(), "lat is empty", 1).show();
            return;
        }
        if (obj2 == null || obj2.length() == 0) {
            Toast.makeText(labLocationDialog.getContext(), "lon is empty", 1).show();
            return;
        }
        if (obj3 == null || obj3.length() == 0) {
            Toast.makeText(labLocationDialog.getContext(), "name is empty", 1).show();
            return;
        }
        if (str == null || str.length() == 0) {
            Toast.makeText(labLocationDialog.getContext(), "address is empty", 1).show();
            return;
        }
        com.transsion.baselib.report.launch.b.a.b().putString("key_lo_mock_test_lab_lat", obj + "|" + obj2 + "|" + obj3 + "|" + str);
        labLocationDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(LabLocationDialog labLocationDialog, View view) {
        EditTextWithClear editTextWithClear;
        EditTextWithClear editTextWithClear2;
        EditTextWithClear editTextWithClear3;
        EditTextWithClear editTextWithClear4;
        com.transsion.baselib.report.launch.b.a.b().putString("key_lo_mock_test_lab_lat", HttpUrl.FRAGMENT_ENCODE_SET);
        xu.x xVar = (xu.x) labLocationDialog.o0();
        if (xVar != null && (editTextWithClear4 = xVar.e) != null) {
            editTextWithClear4.setText(HttpUrl.FRAGMENT_ENCODE_SET);
        }
        xu.x xVar2 = (xu.x) labLocationDialog.o0();
        if (xVar2 != null && (editTextWithClear3 = xVar2.f) != null) {
            editTextWithClear3.setText(HttpUrl.FRAGMENT_ENCODE_SET);
        }
        xu.x xVar3 = (xu.x) labLocationDialog.o0();
        if (xVar3 != null && (editTextWithClear2 = xVar3.g) != null) {
            editTextWithClear2.setText(HttpUrl.FRAGMENT_ENCODE_SET);
        }
        xu.x xVar4 = (xu.x) labLocationDialog.o0();
        if (xVar4 != null && (editTextWithClear = xVar4.d) != null) {
            editTextWithClear.setText(HttpUrl.FRAGMENT_ENCODE_SET);
        }
        labLocationDialog.dismiss();
    }

    public Function3 n0() {
        return LabLocationDialog$bindingInflater$1.INSTANCE;
    }

    public void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(savedInstanceState);
        setStyle(0, R$style.BaseDialogStyle);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        String string = com.transsion.baselib.report.launch.b.a.b().getString("key_lo_mock_test_lab_lat", HttpUrl.FRAGMENT_ENCODE_SET);
        if (string != null && string.length() != 0 && StringsKt.c0(string, "|", false, 2, null)) {
            List S0 = StringsKt.S0(string, new String[]{"|"}, false, 0, 6, null);
            xu.x xVar = (xu.x) o0();
            if (xVar != null) {
                xVar.e.setText((CharSequence) S0.get(0));
                xVar.f.setText((CharSequence) S0.get(1));
                xVar.g.setText((CharSequence) S0.get(2));
                xVar.d.setText((CharSequence) S0.get(3));
            }
        }
        xu.x xVar2 = (xu.x) o0();
        if (xVar2 != null && (appCompatTextView2 = xVar2.b) != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabLocationDialog.r0(LabLocationDialog.this, view2);
                }
            });
        }
        xu.x xVar3 = (xu.x) o0();
        if (xVar3 == null || (appCompatTextView = xVar3.c) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabLocationDialog.s0(LabLocationDialog.this, view2);
            }
        });
    }
}
