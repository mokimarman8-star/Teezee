package com.transsion.rewardscenter.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.R$id;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0005*\u0001\u001d\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0004R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/transsion/rewardscenter/ui/RewardsCenterActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lyo/b;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "C0", "()Lyo/b;", BuildConfig.FLAVOR, "f0", "()Ljava/lang/String;", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "l0", "m0", "k0", "p0", "retryLoadData", "i", "Ljava/lang/String;", "source", "j", "sceneId", "com/transsion/rewardscenter/ui/RewardsCenterActivity$a", "k", "Lcom/transsion/rewardscenter/ui/RewardsCenterActivity$a;", "onBackPress", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RewardsCenterActivity extends BaseNewActivity<yo.b> {

    /* renamed from: i, reason: from kotlin metadata */
    private String source;

    /* renamed from: j, reason: from kotlin metadata */
    private String sceneId;

    /* renamed from: k, reason: from kotlin metadata */
    private final a onBackPress = new a();

    public static final class a extends androidx.activity.u {
        a() {
            super(true);
        }

        public void handleOnBackPressed() {
            RewardsCenterActivity.this.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public yo.b getViewBinding() {
        yo.b c = yo.b.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String f0() {
        return BuildConfig.FLAVOR;
    }

    public void k0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l0() {
        String stringExtra = getIntent().getStringExtra("source");
        String str = null;
        if (stringExtra == null) {
            Uri data = getIntent().getData();
            stringExtra = data != null ? data.getQueryParameter("source") : null;
        }
        this.source = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("scene_id");
        if (stringExtra2 == null) {
            Uri data2 = getIntent().getData();
            if (data2 != null) {
                str = data2.getQueryParameter("sceneId");
            }
        } else {
            str = stringExtra2;
        }
        this.sceneId = str;
        Uri data3 = getIntent().getData();
        boolean z = false;
        if (data3 != null && Intrinsics.c(data3.getHost(), "member") && Intrinsics.c(data3.getPath(), "/adtask")) {
            z = true;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        androidx.fragment.app.w p = supportFragmentManager.p();
        Intrinsics.g(p, "beginTransaction()");
        RewardsCenterFragment rewardsCenterFragment = new RewardsCenterFragment();
        Bundle bundle = new Bundle();
        bundle.putString("source", this.source);
        bundle.putString("scene_id", this.sceneId);
        bundle.putBoolean("is_from_ad_task", z);
        rewardsCenterFragment.setArguments(bundle);
        p.t(R$id.fl_content, rewardsCenterFragment, "RewardsCenter");
        p.j();
    }

    public void m0() {
        getOnBackPressedDispatcher().i(this, this.onBackPress);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a.a.f(wf.a.a, "RewardsCenter", "RewardsCenterActivity --> onCreate() --> source: " + this.source + ", sceneId: " + this.sceneId, false, 4, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onNewIntent(Intent intent) {
        Intrinsics.h(intent, "intent");
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
        setIntent(intent);
        RewardsCenterFragment k0 = getSupportFragmentManager().k0("RewardsCenter");
        RewardsCenterFragment rewardsCenterFragment = k0 instanceof RewardsCenterFragment ? k0 : null;
        if (rewardsCenterFragment != null) {
            rewardsCenterFragment.q1();
        }
    }

    public void p0() {
    }

    public void retryLoadData() {
    }
}
