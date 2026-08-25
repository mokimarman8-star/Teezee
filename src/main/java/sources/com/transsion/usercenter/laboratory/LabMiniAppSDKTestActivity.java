package com.transsion.usercenter.laboratory;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;
import com.tencent.mmkv.MMKV;
import com.transsion.baseui.activity.BaseNewActivity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/transsion/usercenter/laboratory/LabMiniAppSDKTestActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lxu/c;", "<init>", "()V", "E0", "()Lxu/c;", HttpUrl.FRAGMENT_ENCODE_SET, "f0", "()Ljava/lang/String;", HttpUrl.FRAGMENT_ENCODE_SET, "l0", "m0", "k0", "p0", "retryLoadData", "i", "a", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LabMiniAppSDKTestActivity extends BaseNewActivity<xu.c> {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void F0(LabMiniAppSDKTestActivity labMiniAppSDKTestActivity, View view) {
        String str;
        String obj;
        Editable text = ((xu.c) labMiniAppSDKTestActivity.getMViewBinding()).c.getText();
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (text == null || (str = text.toString()) == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (str.length() == 0) {
            Toast.makeText((Context) labMiniAppSDKTestActivity, (CharSequence) "appId is empty", 1).show();
            return;
        }
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        bVar.b().putString("KEY_TEST_MIN_APP_SDK_APP_ID", str);
        Editable text2 = ((xu.c) labMiniAppSDKTestActivity.getMViewBinding()).d.getText();
        if (text2 != null && (obj = text2.toString()) != null) {
            str2 = obj;
        }
        if (str2.length() > 0) {
            bVar.b().putString("KEY_TEST_MIN_APP_SDK_SCENE_ID", str);
        }
        dj.a.a.c(labMiniAppSDKTestActivity, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void G0(LabMiniAppSDKTestActivity labMiniAppSDKTestActivity, View view) {
        String str;
        Editable text = ((xu.c) labMiniAppSDKTestActivity.getMViewBinding()).b.getText();
        if (text == null || (str = text.toString()) == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (str.length() == 0) {
            Toast.makeText((Context) labMiniAppSDKTestActivity, (CharSequence) "deeplink is empty", 1).show();
        } else {
            com.transsion.baselib.report.launch.b.a.b().putString("KEY_TEST_MIN_APP_SDK_DEEPLINK", str);
            ij.k.h(str, (String) null, 1, (Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public xu.c getViewBinding() {
        xu.c c = xu.c.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String f0() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public void k0() {
    }

    public void l0() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        MMKV b = bVar.b();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        String string = b.getString("KEY_TEST_MIN_APP_SDK_APP_ID", HttpUrl.FRAGMENT_ENCODE_SET);
        if (string == null) {
            string = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (string.length() > 0) {
            ((xu.c) getMViewBinding()).c.setText(string);
        }
        String string2 = bVar.b().getString("KEY_TEST_MIN_APP_SDK_SCENE_ID", HttpUrl.FRAGMENT_ENCODE_SET);
        if (string2 == null) {
            string2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (string2.length() > 0) {
            ((xu.c) getMViewBinding()).d.setText(string2);
        }
        String string3 = bVar.b().getString("KEY_TEST_MIN_APP_SDK_DEEPLINK", HttpUrl.FRAGMENT_ENCODE_SET);
        if (string3 != null) {
            str = string3;
        }
        if (str.length() > 0) {
            ((xu.c) getMViewBinding()).b.setText(str);
        }
        ((xu.c) getMViewBinding()).e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LabMiniAppSDKTestActivity.F0(LabMiniAppSDKTestActivity.this, view);
            }
        });
        ((xu.c) getMViewBinding()).f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LabMiniAppSDKTestActivity.G0(LabMiniAppSDKTestActivity.this, view);
            }
        });
    }

    public void m0() {
    }

    public void p0() {
    }

    public void retryLoadData() {
    }
}
