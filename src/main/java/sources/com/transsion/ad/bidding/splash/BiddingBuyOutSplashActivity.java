package com.transsion.ad.bidding.splash;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.gyf.immersionbar.ImmersionBar;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.R$id;
import com.transsion.ad.R$string;
import com.transsion.ad.bidding.base.AbsBiddingActivity;
import com.transsion.ad.bidding.splash.BiddingBuyOutSplashActivity;
import com.transsion.ad.strategy.t;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import sh.e;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001b\u0010\u000fJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001c\u0010\u000fJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001d\u0010\u000fJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0004R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/transsion/ad/bidding/splash/BiddingBuyOutSplashActivity;", "Lcom/transsion/ad/bidding/base/AbsBiddingActivity;", "Lcom/transsion/ad/strategy/t$a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", TtmlNode.ANONYMOUS_REGION_ID, "onCreate", "(Landroid/os/Bundle;)V", TtmlNode.ANONYMOUS_REGION_ID, "getLogTag", "()Ljava/lang/String;", "Landroid/view/View;", "o0", "()Landroid/view/View;", "Landroid/widget/FrameLayout;", "j0", "()Landroid/widget/FrameLayout;", "p0", TtmlNode.ANONYMOUS_REGION_ID, "g0", "()I", "i", "y0", "(I)V", "r0", "c0", "k0", "l0", "D0", "Lsh/e;", "o", "Lsh/e;", "binding", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CustomSplashScreen"})
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class BiddingBuyOutSplashActivity extends AbsBiddingActivity implements t.a {

    /* renamed from: o, reason: from kotlin metadata */
    private e binding;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void O0(ConstraintLayout constraintLayout, BiddingBuyOutSplashActivity biddingBuyOutSplashActivity) {
        constraintLayout.setPadding(constraintLayout.getPaddingLeft(), ImmersionBar.getStatusBarHeight(biddingBuyOutSplashActivity), constraintLayout.getPaddingRight(), constraintLayout.getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(BiddingBuyOutSplashActivity biddingBuyOutSplashActivity, View view) {
        biddingBuyOutSplashActivity.b0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public void D0() {
        AppCompatTextView appCompatTextView;
        try {
            Result.Companion companion = Result.Companion;
            FrameLayout frameLayout = (FrameLayout) findViewById(R$id.movieBoxLayout);
            if (frameLayout != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(LayoutInflater.from(this).inflate(getMAppLayoutId(), (ViewGroup) frameLayout, false));
            } else {
                frameLayout = null;
            }
            Result.constructor-impl(frameLayout);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th));
        }
        e eVar = this.binding;
        if (eVar == null || (appCompatTextView = eVar.g) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: qh.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiddingBuyOutSplashActivity.P0(BiddingBuyOutSplashActivity.this, view);
            }
        });
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public View c0() {
        return findViewById(R$id.adIcon);
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public int g0() {
        return com.transsion.ad.scene.a.a.r(getSceneId());
    }

    public String getLogTag() {
        return "ad_s";
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public FrameLayout j0() {
        e eVar = this.binding;
        if (eVar != null) {
            return eVar.d;
        }
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public View k0() {
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public View l0() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public View o0() {
        e c = e.c(getLayoutInflater());
        this.binding = c;
        if (c != null) {
            return c.getRoot();
        }
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    protected void onCreate(Bundle savedInstanceState) {
        final ConstraintLayout constraintLayout;
        super.onCreate(savedInstanceState);
        e eVar = this.binding;
        if (eVar == null || (constraintLayout = eVar.c) == null) {
            return;
        }
        constraintLayout.post(new Runnable() { // from class: qh.b
            @Override // java.lang.Runnable
            public final void run() {
                BiddingBuyOutSplashActivity.O0(constraintLayout, this);
            }
        });
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public FrameLayout p0() {
        e eVar = this.binding;
        if (eVar != null) {
            return eVar.e;
        }
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public void r0() {
        b0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public void y0(int i) {
        AppCompatTextView appCompatTextView;
        e eVar = this.binding;
        if (eVar == null || (appCompatTextView = eVar.g) == null) {
            return;
        }
        appCompatTextView.setVisibility(0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = getString(R$string.skip_ad, Integer.valueOf(i));
        Intrinsics.g(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[0], 0));
        Intrinsics.g(format, "format(...)");
        appCompatTextView.setText(format);
    }
}
