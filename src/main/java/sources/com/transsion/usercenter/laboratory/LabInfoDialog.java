package com.transsion.usercenter.laboratory;

import ah.c;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.therouter.TheRouter;
import com.tn.lib.widget.R;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Locale;
import java.util.TimeZone;
import jg.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/transsion/usercenter/laboratory/LabInfoDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "keyColor", "valueColor", "Lah/c;", "p0", "(II)Lah/c;", HttpUrl.FRAGMENT_ENCODE_SET, "q0", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", HttpUrl.FRAGMENT_ENCODE_SET, "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LabInfoDialog extends BaseDialog {
    public LabInfoDialog() {
        super(R$layout.dialog_lab_info);
    }

    private final ah.c p0(int keyColor, int valueColor) {
        UserInfo i;
        c.a c = ah.c.e().e("user_id = ").c(keyColor);
        qx.a aVar = (qx.a) TheRouter.d(qx.a.class, new Object[0]);
        c.a c2 = c.e(((aVar == null || (i = aVar.i()) == null) ? null : i.getUserId()) + "\n").c(valueColor).e("device_id = ").c(keyColor);
        tg.b bVar = tg.b.a;
        c.a c3 = c2.e(bVar.h() + "\n").c(valueColor).e("version_name = ").c(keyColor).e(com.blankj.utilcode.util.c.h() + "\n").c(valueColor).e("version_code = ").c(keyColor).e(com.blankj.utilcode.util.c.f() + "\n").c(valueColor).e("os_version = ").c(keyColor).e(bVar.n() + "\n").c(valueColor).e("model = ").c(keyColor).e(bVar.l() + "\n").c(valueColor).e("install_ch = ").c(keyColor).e(mg.a.a.a() + "\n").c(valueColor).e("gaid = ").c(keyColor).e(bVar.i() + "\n").c(valueColor).e("net = ").c(keyColor).e(yg.l.a.d() + "\n").c(valueColor).e("region = ").c(keyColor).e(Locale.getDefault().getCountry() + "\n").c(valueColor).e("timezone = ").c(keyColor).e(TimeZone.getDefault().getID() + "\n").c(valueColor).e("sp_code = ").c(keyColor).e(q0() + "\n").c(valueColor).e("channel = ").c(keyColor);
        b.a aVar2 = jg.b.a;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        c.a c4 = c3.e(aVar2.e(a) + "\n").c(valueColor).e("package = ").c(keyColor).e(com.blankj.utilcode.util.c.e() + "\n").c(valueColor).e("SignatureMD5 = ").c(keyColor);
        ij.d dVar = ij.d.a;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        c.a c5 = c4.e(dVar.a(a2) + "\n").c(valueColor).e("SignatureSha1 = ").c(keyColor);
        Application a3 = Utils.a();
        Intrinsics.g(a3, "getApp(...)");
        c.a c6 = c5.e(ij.d.c(a3) + "\n").c(valueColor).e("SignatureSHA256 = ").c(keyColor);
        Application a4 = Utils.a();
        Intrinsics.g(a4, "getApp(...)");
        ah.c b = c6.e(dVar.b(a4) + "\n").c(valueColor).b();
        Intrinsics.g(b, "build(...)");
        return b;
    }

    private final String q0() {
        String string;
        MMKV c = mg.a.a.c();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (c != null && (string = c.getString("sp_code", HttpUrl.FRAGMENT_ENCODE_SET)) != null) {
            str = string;
        }
        return TextUtils.isEmpty(str) ? tg.b.a.o() : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(LabInfoDialog labInfoDialog, View view) {
        labInfoDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(xu.v vVar, LabInfoDialog labInfoDialog, View view) {
        com.blankj.utilcode.util.g.a(vVar.d.getText().toString());
        Toast.makeText(labInfoDialog.getContext(), "copy success", 1).show();
        labInfoDialog.dismiss();
    }

    public void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(savedInstanceState);
        setStyle(0, R$style.BaseDialogStyle);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        final xu.v a = xu.v.a(view);
        Intrinsics.g(a, "bind(...)");
        a.d.setText(p0(androidx.core.content.b.getColor(view.getContext(), R.color.main), androidx.core.content.b.getColor(view.getContext(), R.color.text_02)));
        a.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabInfoDialog.r0(LabInfoDialog.this, view2);
            }
        });
        a.c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabInfoDialog.s0(xu.v.this, this, view2);
            }
        });
    }
}
