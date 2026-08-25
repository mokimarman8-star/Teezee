package com.transsion.shorttv_pugc.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import com.therouter.TheRouter;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.shorttv.R;
import com.transsion.shorttv_pugc.base.activity.BaseActivity;
import com.transsion.shorttv_pugc.ui.fragment.ShortTvDetailListFragment;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ds.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import qr.l;
import vs.g;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0016\u0010\u0004R\u0016\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b*\u0010&R\u0018\u0010-\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010&R\u0018\u0010/\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010&R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/transsion/shorttv_pugc/ui/activity/ShortTvListActivity;", "Lcom/transsion/shorttv_pugc/base/activity/BaseActivity;", "Lqr/l;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "U", "S", "R", "()Lqr/l;", HttpUrl.FRAGMENT_ENCODE_SET, "isStatusDark", "()Z", "isMonitorNetworkState", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onPause", HttpUrl.FRAGMENT_ENCODE_SET, "f", "I", "ep", HttpUrl.FRAGMENT_ENCODE_SET, "g", "J", "ms", "h", "Z", "isHistoryFirst", "i", "ugcWithoutHistory", HttpUrl.FRAGMENT_ENCODE_SET, "j", "Ljava/lang/String;", "ugcVideoId", "k", "subjectId", "l", "collectId", "m", "ops", "n", "fromOptId", "Lcom/transsion/shorttv_pugc/ui/fragment/ShortTvDetailListFragment;", "o", "Lcom/transsion/shorttv_pugc/ui/fragment/ShortTvDetailListFragment;", "fragment", "p", "a", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ShortTvListActivity extends BaseActivity<l> {

    /* renamed from: p, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: from kotlin metadata */
    public int ep = -1;

    /* renamed from: g, reason: from kotlin metadata */
    public long ms;

    /* renamed from: h, reason: from kotlin metadata */
    public boolean isHistoryFirst;

    /* renamed from: i, reason: from kotlin metadata */
    public boolean ugcWithoutHistory;

    /* renamed from: j, reason: from kotlin metadata */
    public String ugcVideoId;

    /* renamed from: k, reason: from kotlin metadata */
    public String subjectId;

    /* renamed from: l, reason: from kotlin metadata */
    public String collectId;

    /* renamed from: m, reason: from kotlin metadata */
    public String ops;

    /* renamed from: n, reason: from kotlin metadata */
    public String fromOptId;

    /* renamed from: o, reason: from kotlin metadata */
    private ShortTvDetailListFragment fragment;

    /* renamed from: com.transsion.shorttv_pugc.ui.activity.ShortTvListActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Context context, String str, Integer num, long j, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                num = null;
            }
            Integer num2 = num;
            if ((i & 8) != 0) {
                j = 0;
            }
            long j2 = j;
            if ((i & 16) != 0) {
                z = false;
            }
            companion.a(context, str, num2, j2, z);
        }

        public final void a(Context context, String subjectId, Integer num, long j, boolean z) {
            Intrinsics.h(context, "context");
            Intrinsics.h(subjectId, "subjectId");
        }
    }

    private final void S() {
        BiddingInterstitialManager.Companion.b(BiddingInterstitialManager.t, "ShortTvInterstitialScene", (Map) null, 2, (Object) null);
        BiddingVideoManager.Companion.b(BiddingVideoManager.t, "ShortTvVideoScene", (Map) null, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U() {
        Fragment k0 = getSupportFragmentManager().k0("ShortTvDetailListFragment");
        ShortTvDetailListFragment shortTvDetailListFragment = k0 instanceof ShortTvDetailListFragment ? (ShortTvDetailListFragment) k0 : null;
        this.fragment = shortTvDetailListFragment;
        if (shortTvDetailListFragment == null) {
            ShortTvDetailListFragment shortTvDetailListFragment2 = new ShortTvDetailListFragment();
            shortTvDetailListFragment2.setArguments(getIntent().getExtras());
            this.fragment = shortTvDetailListFragment2;
            w p = getSupportFragmentManager().p();
            int i = R.id.flContent;
            ShortTvDetailListFragment shortTvDetailListFragment3 = this.fragment;
            Intrinsics.e(shortTvDetailListFragment3);
            p.t(i, shortTvDetailListFragment3, "ShortTvDetailListFragment");
            p.l();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.shorttv_pugc.base.activity.BaseCommonActivity
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public l getViewBinding() {
        l c = l.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    @Override // com.transsion.shorttv_pugc.base.activity.BaseCommonActivity
    public boolean isMonitorNetworkState() {
        return false;
    }

    @Override // com.transsion.shorttv_pugc.base.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.shorttv_pugc.base.activity.BaseActivity, com.transsion.shorttv_pugc.base.activity.BaseCommonActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b.a.f(1, this);
        S();
        TheRouter.l(this);
        U();
        g P = P();
        if (P != null) {
            P.d();
        }
    }

    protected void onNewIntent(Intent intent) {
        Intrinsics.h(intent, "intent");
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.shorttv_pugc.base.activity.BaseActivity, com.transsion.shorttv_pugc.base.activity.BaseCommonActivity
    protected void onPause() {
        ShortTvDetailListFragment shortTvDetailListFragment;
        super.onPause();
        if (!isFinishing() || (shortTvDetailListFragment = this.fragment) == null) {
            return;
        }
        shortTvDetailListFragment.L0();
    }
}
