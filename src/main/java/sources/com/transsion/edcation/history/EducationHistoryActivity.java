package com.transsion.edcation.history;

import android.os.Bundle;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.edcation.R$string;
import com.transsion.gslb.BuildConfig;
import ij.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/transsion/edcation/history/EducationHistoryActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Leh/a;", "<init>", "()V", "b0", "()Leh/a;", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "Education_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class EducationHistoryActivity extends BaseActivity<eh.a> {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public eh.a getViewBinding() {
        eh.a c = eh.a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String getPageName() {
        return "Education History";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initView(Bundle savedInstanceState) {
        TitleLayout titleLayout = getMViewBinding().c;
        String string = getString(R$string.course_history_title);
        Intrinsics.g(string, "getString(...)");
        titleLayout.setTitleText(string);
        titleLayout.setPadding(0, com.blankj.utilcode.util.d.c(), 0, 0);
        getSupportFragmentManager().p().s(R.id.container, new EducationHistoryFragment()).k();
    }

    public boolean isStatusDark() {
        return !y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }
}
