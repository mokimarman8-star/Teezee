package com.transsion.mbwidget.guide;

import android.os.Bundle;
import com.tn.lib.view.TitleLayout;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.mbwidget.R$string;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/transsion/mbwidget/guide/WidgetGuideActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Ldm/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/os/Bundle;)V", "b0", "()Ldm/a;", BuildConfig.FLAVOR, "isStatusDark", "()Z", "isTranslucent", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class WidgetGuideActivity extends BaseActivity<dm.a> {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public dm.a getViewBinding() {
        dm.a c = dm.a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        ((dm.a) getMViewBinding()).b.setTitleText(R$string.widget_add_guide_title);
        TitleLayout titleLayout = ((dm.a) getMViewBinding()).b;
        Intrinsics.g(titleLayout, "mTitleLayout");
        uf.c.e(titleLayout);
    }

    public boolean isStatusDark() {
        return true;
    }

    public boolean isTranslucent() {
        return true;
    }
}
