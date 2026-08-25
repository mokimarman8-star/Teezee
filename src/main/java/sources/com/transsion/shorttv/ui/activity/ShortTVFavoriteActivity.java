package com.transsion.shorttv.ui.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.activity.u;
import androidx.core.os.d;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import com.therouter.TheRouter;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.activity.BaseNewActivity;
import com.transsion.shorttv.ui.fragment.ShortTVFavoriteFragment;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import cr.b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import qr.l;
import wf.a;

@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\b\u0005*\u0001\u001c\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0004R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/transsion/shorttv/ui/activity/ShortTVFavoriteActivity;", "Lcom/transsion/shorttv/base/activity/BaseNewActivity;", "Lqr/l;", "<init>", "()V", "l0", "()Lqr/l;", HttpUrl.FRAGMENT_ENCODE_SET, "V", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", HttpUrl.FRAGMENT_ENCODE_SET, "onCreate", "(Landroid/os/Bundle;)V", "b0", "g0", HttpUrl.FRAGMENT_ENCODE_SET, "isTranslucent", "()Z", "isStatusDark", "c0", "a0", "f0", "retryLoadData", "j", "Ljava/lang/String;", "ops", "com/transsion/shorttv/ui/activity/ShortTVFavoriteActivity$a", "k", "Lcom/transsion/shorttv/ui/activity/ShortTVFavoriteActivity$a;", "onBackPress", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ShortTVFavoriteActivity extends BaseNewActivity<l> {

    /* renamed from: j, reason: from kotlin metadata */
    public String ops;

    /* renamed from: k, reason: from kotlin metadata */
    private final a onBackPress = new a();

    public static final class a extends u {
        a() {
            super(true);
        }

        public void handleOnBackPressed() {
            a.a.g(wf.a.a, "ShortTVFavoriteActivity --> onBackPress --> handleOnBackPressed() --> setResult(RESULT_OK)", false, 2, (Object) null);
            ShortTVFavoriteActivity.this.finish();
        }
    }

    public String V() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public void a0() {
    }

    public void b0() {
        FrameLayout b = getMViewBinding().b();
        Intrinsics.g(b, "getRoot(...)");
        b.a(b);
        i0();
    }

    public void c0() {
        getOnBackPressedDispatcher().i(this, this.onBackPress);
    }

    public void f0() {
    }

    public void g0() {
        super.g0();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        w p = supportFragmentManager.p();
        Intrinsics.g(p, "beginTransaction()");
        ShortTVFavoriteFragment a2 = ShortTVFavoriteFragment.INSTANCE.a();
        a2.setArguments(d.b(new Pair[]{TuplesKt.a("ops", this.ops)}));
        p.t(R.id.flContent, a2, "ShortTVFavoriteFragment");
        p.j();
    }

    public boolean isStatusDark() {
        return false;
    }

    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public l getViewBinding() {
        l c = l.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }

    public void retryLoadData() {
    }
}
