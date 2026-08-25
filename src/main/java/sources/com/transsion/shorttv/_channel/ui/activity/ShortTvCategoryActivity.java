package com.transsion.shorttv._channel.ui.activity;

import android.os.Bundle;
import com.gyf.immersionbar.ImmersionBar;
import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import com.transsion.shorttv.R;
import com.transsion.shorttv._channel.ShortTvCategoryFragment;
import com.transsion.shorttv.base.activity.BaseActivity;
import hr.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qr.m;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/transsion/shorttv/_channel/ui/activity/ShortTvCategoryActivity;", "Lcom/transsion/shorttv/base/activity/BaseActivity;", "Lqr/m;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "X", "()Lqr/m;", "initView", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", "isExpand", "W", "(Z)V", BuildConfig.FLAVOR, "g", "Ljava/lang/String;", "categoryType", "h", "showType", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvCategoryActivity extends BaseActivity<m> {

    /* renamed from: g, reason: from kotlin metadata */
    public String categoryType;

    /* renamed from: h, reason: from kotlin metadata */
    public String showType = MsgStyle.CUSTOM_LEFT_PIC;

    /* JADX WARN: Multi-variable type inference failed */
    public final void W(boolean isExpand) {
        ImmersionBar with = ImmersionBar.with(this);
        boolean z = false;
        if (isExpand && !g.a.a()) {
            z = true;
        }
        with.statusBarDarkFont(z).init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public m getViewBinding() {
        m c = m.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    @Override // com.transsion.shorttv.base.activity.BaseActivity
    public void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().p().s(R.id.container, ShortTvCategoryFragment.INSTANCE.a(this.categoryType, this.showType)).k();
        }
    }

    @Override // com.transsion.shorttv.base.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.shorttv.base.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.shorttv.base.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.shorttv.base.activity.BaseActivity, com.transsion.shorttv.base.activity.BaseCommonActivity
    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }
}
