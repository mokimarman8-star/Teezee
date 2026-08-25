package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;
import com.tencent.mmkv.MMKV;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/transsion/usercenter/laboratory/LabWebTestDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", HttpUrl.FRAGMENT_ENCODE_SET, "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "c", "a", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LabWebTestDialog extends BaseDialog {
    public LabWebTestDialog() {
        super(R$layout.dialog_lab_web);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(xu.a0 a0Var, LabWebTestDialog labWebTestDialog, View view) {
        Editable text = a0Var.c.getText();
        String obj = text != null ? text.toString() : null;
        if (obj == null || obj.length() == 0) {
            Toast.makeText(labWebTestDialog.getContext(), "url is empty", 1).show();
            return;
        }
        com.transsion.baselib.report.launch.b.a.b().putString("key_web_test_url", obj);
        Navigator.x(TheRouter.c(WebPageIdentity.WEB_VIEW).K(WebConstants.FIELD_URL, obj), labWebTestDialog.getContext(), (mf.c) null, 2, (Object) null);
        labWebTestDialog.dismiss();
    }

    public void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(savedInstanceState);
        setStyle(0, R$style.BaseDialogStyle);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        final xu.a0 a = xu.a0.a(view);
        Intrinsics.g(a, "bind(...)");
        MMKV b = com.transsion.baselib.report.launch.b.a.b();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        String string = b.getString("key_web_test_url", HttpUrl.FRAGMENT_ENCODE_SET);
        if (string != null) {
            str = string;
        }
        a.c.setText(str);
        a.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabWebTestDialog.o0(xu.a0.this, this, view2);
            }
        });
    }
}
