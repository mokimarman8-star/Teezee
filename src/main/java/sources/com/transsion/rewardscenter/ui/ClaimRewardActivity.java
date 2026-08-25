package com.transsion.rewardscenter.ui;

import androidx.fragment.app.FragmentManager;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.R$id;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/transsion/rewardscenter/ui/ClaimRewardActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lyo/a;", "<init>", "()V", "C0", "()Lyo/a;", BuildConfig.FLAVOR, "f0", "()Ljava/lang/String;", BuildConfig.FLAVOR, "l0", "m0", "k0", "p0", "retryLoadData", "D0", "i", "a", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ClaimRewardActivity extends BaseNewActivity<yo.a> {
    public static final int j = BaseNewActivity.h;

    public static final class b extends androidx.activity.u {
        b() {
            super(true);
        }

        public void handleOnBackPressed() {
            ClaimRewardActivity.this.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public yo.a getViewBinding() {
        yo.a c = yo.a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D0() {
        setResult(-1);
        finish();
    }

    public String f0() {
        return BuildConfig.FLAVOR;
    }

    public void k0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l0() {
        String stringExtra = getIntent().getStringExtra("prize_id");
        if (stringExtra == null) {
            stringExtra = BuildConfig.FLAVOR;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        androidx.fragment.app.w p = supportFragmentManager.p();
        Intrinsics.g(p, "beginTransaction()");
        p.t(R$id.fl_content, ClaimRewardFragment.INSTANCE.a(stringExtra), "ClaimRewardFragment");
        p.j();
    }

    public void m0() {
        getOnBackPressedDispatcher().i(this, new b());
    }

    public void p0() {
    }

    public void retryLoadData() {
    }
}
