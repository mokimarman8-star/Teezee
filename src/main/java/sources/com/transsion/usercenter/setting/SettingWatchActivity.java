package com.transsion.usercenter.setting;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baselib.utils.PlayMode;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.usercenter.R$string;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import xu.a1;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0019\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u0005R\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/transsion/usercenter/setting/SettingWatchActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lxu/a1;", "Lcom/tn/lib/widget/dialog/TRDialogListener;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "isStream", HttpUrl.FRAGMENT_ENCODE_SET, "updateMode", "(Z)V", "restartApp", "editTipsDialog", "getViewBinding", "()Lxu/a1;", "isStatusDark", "()Z", "isTranslucent", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/os/Bundle;)V", "Lcom/tn/lib/widget/dialog/TRDialog;", "dialog", "onLeftButtonClick", "(Lcom/tn/lib/widget/dialog/TRDialog;)V", "onRightButtonClick", "onBackPressed", "isStreamMode", "Z", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class SettingWatchActivity extends BaseActivity<a1> implements TRDialogListener {
    private final boolean isStreamMode = ij.t.a.b();

    /* JADX WARN: Multi-variable type inference failed */
    private final void editTipsDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R.string.back_edit_tips);
            Intrinsics.g(string, "getString(...)");
            TRDialog.a g = aVar.g(string);
            String string2 = getString(R$string.profile_back_edit_yes);
            Intrinsics.g(string2, "getString(...)");
            TRDialog.a e = g.e(string2);
            String string3 = getString(R$string.profile_back_edit_no);
            Intrinsics.g(string3, "getString(...)");
            e.j(string3).d(androidx.core.content.b.getColor(this, R.color.text_01)).i(androidx.core.content.b.getColor(this, R.color.text_01)).h(R.drawable.libui_sub_btn2_normal).c(R.drawable.libui_sub_btn2_normal).f(this).a().c0(this, "edit_tips");
        } catch (Exception unused) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$0(SettingWatchActivity settingWatchActivity, View it) {
        Intrinsics.h(it, "it");
        settingWatchActivity.updateMode(true);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$1(SettingWatchActivity settingWatchActivity, View it) {
        Intrinsics.h(it, "it");
        settingWatchActivity.updateMode(false);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$2(SettingWatchActivity settingWatchActivity, View it) {
        Intrinsics.h(it, "it");
        settingWatchActivity.restartApp();
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void restartApp() {
        ij.t.a.c(((a1) getMViewBinding()).g.isSelected() ? PlayMode.STREAM : PlayMode.DOWNLOAD);
        com.transsion.baselib.report.k.a.l();
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268435456);
        }
        startActivity(launchIntentForPackage);
        Process.killProcess(Process.myPid());
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    private final void updateMode(boolean isStream) {
        ((a1) getMViewBinding()).f.setAlpha(isStream == this.isStreamMode ? 0.5f : 1.0f);
        ((a1) getMViewBinding()).f.setEnabled(isStream != this.isStreamMode);
        ((a1) getMViewBinding()).g.setSelected(isStream);
        ((a1) getMViewBinding()).c.setSelected(!isStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a1 getViewBinding() {
        a1 c = a1.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        TitleLayout titleLayout = ((a1) getMViewBinding()).j;
        Intrinsics.g(titleLayout, "titleLayout");
        uf.c.e(titleLayout);
        ((a1) getMViewBinding()).j.setTitleText(com.transsion.baseui.R.string.watch_options);
        AppCompatTextView streamTv = ((a1) getMViewBinding()).i;
        Intrinsics.g(streamTv, "streamTv");
        uf.c.c(streamTv, 0L, new Function1() { // from class: com.transsion.usercenter.setting.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initView$lambda$0;
                initView$lambda$0 = SettingWatchActivity.initView$lambda$0(SettingWatchActivity.this, (View) obj);
                return initView$lambda$0;
            }
        }, 1, (Object) null);
        AppCompatTextView downloadTv = ((a1) getMViewBinding()).e;
        Intrinsics.g(downloadTv, "downloadTv");
        uf.c.c(downloadTv, 0L, new Function1() { // from class: com.transsion.usercenter.setting.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initView$lambda$1;
                initView$lambda$1 = SettingWatchActivity.initView$lambda$1(SettingWatchActivity.this, (View) obj);
                return initView$lambda$1;
            }
        }, 1, (Object) null);
        AppCompatTextView restartTV = ((a1) getMViewBinding()).f;
        Intrinsics.g(restartTV, "restartTV");
        uf.c.c(restartTV, 0L, new Function1() { // from class: com.transsion.usercenter.setting.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initView$lambda$2;
                initView$lambda$2 = SettingWatchActivity.initView$lambda$2(SettingWatchActivity.this, (View) obj);
                return initView$lambda$2;
            }
        }, 1, (Object) null);
        updateMode(this.isStreamMode);
    }

    public boolean isStatusDark() {
        return false;
    }

    public boolean isTranslucent() {
        return true;
    }

    public void onBackPressed() {
        if (((a1) getMViewBinding()).g.isSelected() == this.isStreamMode) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        } else {
            editTipsDialog();
        }
    }

    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
        finish();
    }

    public void onRightButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
    }
}
