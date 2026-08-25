package com.transsion.home.activity;

import android.os.Bundle;
import com.therouter.TheRouter;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.fragment.ranking.UGCRankAllFragment;
import ij.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qk.a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/transsion/home/activity/UGCRankingActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lqk/a;", "<init>", "()V", "b0", "()Lqk/a;", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", BuildConfig.FLAVOR, "a", "Ljava/lang/String;", "requestCategory", "b", "tabId", "c", "videoType", "d", "fromOptId", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCRankingActivity extends BaseActivity<a> {

    /* renamed from: a, reason: from kotlin metadata */
    public String requestCategory;

    /* renamed from: b, reason: from kotlin metadata */
    public String tabId = "0";

    /* renamed from: c, reason: from kotlin metadata */
    public String videoType = BuildConfig.FLAVOR;

    /* renamed from: d, reason: from kotlin metadata */
    public String fromOptId = BuildConfig.FLAVOR;

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
            getSupportFragmentManager().p().s(R.id.container, UGCRankAllFragment.INSTANCE.a(this.requestCategory, this.tabId, this.videoType, this.fromOptId)).k();
        }
    }

    public boolean isStatusDark() {
        return !y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }
}
