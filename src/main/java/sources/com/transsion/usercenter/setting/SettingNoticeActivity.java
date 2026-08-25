package com.transsion.usercenter.setting;

import android.os.Bundle;
import android.view.View;
import com.tn.lib.view.TitleLayout;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.push.notification.ToolbarNotificationUtils;
import com.transsion.usercenter.R$string;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import xu.y0;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/transsion/usercenter/setting/SettingNoticeActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lxu/y0;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "d0", "c0", "()Lxu/y0;", HttpUrl.FRAGMENT_ENCODE_SET, "isStatusDark", "()Z", "isTranslucent", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/os/Bundle;)V", "a", "Z", "showNotice", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class SettingNoticeActivity extends BaseActivity<y0> {

    /* renamed from: a, reason: from kotlin metadata */
    private boolean showNotice = true;

    private final void d0() {
        this.showNotice = com.transsion.baselib.report.launch.b.a.b().getBoolean("k_is_show_ongoing_tool_notice", true);
        ((y0) getMViewBinding()).b.setChecked(this.showNotice);
        ((y0) getMViewBinding()).b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingNoticeActivity.e0(SettingNoticeActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(SettingNoticeActivity settingNoticeActivity, View view) {
        if (settingNoticeActivity.showNotice) {
            ToolbarNotificationUtils.a.y();
            com.transsion.baselib.report.launch.b.a.b().putBoolean("k_is_show_ongoing_tool_notice", false);
        } else {
            com.transsion.baselib.report.launch.b.a.b().putBoolean("k_is_show_ongoing_tool_notice", true);
            ToolbarNotificationUtils.a.G();
        }
        settingNoticeActivity.showNotice = !settingNoticeActivity.showNotice;
        ((y0) settingNoticeActivity.getMViewBinding()).b.setChecked(settingNoticeActivity.showNotice);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public y0 getViewBinding() {
        y0 c = y0.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        TitleLayout toolBar = ((y0) getMViewBinding()).c;
        Intrinsics.g(toolBar, "toolBar");
        uf.c.e(toolBar);
        ((y0) getMViewBinding()).c.setTitleText(R$string.user_setting);
        d0();
    }

    public boolean isStatusDark() {
        return false;
    }

    public boolean isTranslucent() {
        return true;
    }
}
