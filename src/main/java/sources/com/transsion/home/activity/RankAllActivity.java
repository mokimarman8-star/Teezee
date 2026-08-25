package com.transsion.home.activity;

import android.os.Bundle;
import com.therouter.TheRouter;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.fragment.rank.RankAllFragment;
import ij.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qk.a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/transsion/home/activity/RankAllActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lqk/a;", "<init>", "()V", "b0", "()Lqk/a;", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", BuildConfig.FLAVOR, "a", "Ljava/lang/String;", "requestCategory", BuildConfig.FLAVOR, "b", "I", "tabId", "c", "defaultCategory", "d", "rankingListId", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RankAllActivity extends BaseActivity<a> {

    /* renamed from: a, reason: from kotlin metadata */
    public String requestCategory;

    /* renamed from: b, reason: from kotlin metadata */
    public int tabId;

    /* renamed from: c, reason: from kotlin metadata */
    public String defaultCategory;

    /* renamed from: d, reason: from kotlin metadata */
    public String rankingListId;

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public a getViewBinding() {
        TheRouter.l(this);
        a c = a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().p().s(R.id.container, RankAllFragment.INSTANCE.a(this.requestCategory, Integer.valueOf(this.tabId), this.defaultCategory, this.rankingListId)).k();
        }
    }

    public boolean isStatusDark() {
        return !y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }
}
