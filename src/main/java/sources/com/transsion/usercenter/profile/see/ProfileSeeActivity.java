package com.transsion.usercenter.profile.see;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import com.therouter.TheRouter;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$string;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ij.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import xu.q0;
import yg.l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0015\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0007R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010+\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/transsion/usercenter/profile/see/ProfileSeeActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lxu/q0;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "E0", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", HttpUrl.FRAGMENT_ENCODE_SET, "onCreate", "(Landroid/os/Bundle;)V", "F0", "()Lxu/q0;", "f0", "l0", "m0", "k0", "retryLoadData", "p0", "onBackPressed", HttpUrl.FRAGMENT_ENCODE_SET, "isTranslucent", "()Z", "isChangeStatusBar", "isStatusDark", HttpUrl.FRAGMENT_ENCODE_SET, "count", "H0", "(I)V", "getPageName", "i", "Ljava/lang/String;", "mUserId", "j", "I", "mWant2SeeCount", "Lqx/a;", "k", "Lkotlin/Lazy;", "D0", "()Lqx/a;", "mLoginApi", "Lcom/transsion/usercenter/profile/see/ProfileSeeListFragment;", "l", "Lcom/transsion/usercenter/profile/see/ProfileSeeListFragment;", "target", "m", "a", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ProfileSeeActivity extends BaseNewActivity<q0> {

    /* renamed from: i, reason: from kotlin metadata */
    public String mUserId;

    /* renamed from: j, reason: from kotlin metadata */
    private int mWant2SeeCount;

    /* renamed from: k, reason: from kotlin metadata */
    private final Lazy mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.see.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qx.a G0;
            G0 = ProfileSeeActivity.G0();
            return G0;
        }
    });

    /* renamed from: l, reason: from kotlin metadata */
    private ProfileSeeListFragment target;

    private final qx.a D0() {
        return (qx.a) this.mLoginApi.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String E0() {
        UserInfo i;
        String str = this.mUserId;
        if (str != null && str.length() != 0) {
            String str2 = this.mUserId;
            qx.a D0 = D0();
            if (!Intrinsics.c(str2, (D0 == null || (i = D0.i()) == null) ? null : i.getUserId())) {
                String string = getString(R$string.profile_list);
                Intrinsics.e(string);
                return string;
            }
        }
        String string2 = getString(R$string.profile_your_list);
        Intrinsics.e(string2);
        return string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a G0() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public q0 getViewBinding() {
        q0 c = q0.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public final void H0(int count) {
        if (this.mWant2SeeCount < 0) {
            count = 0;
        }
        this.mWant2SeeCount = count;
    }

    public String f0() {
        return E0();
    }

    public String getPageName() {
        return "movie_audio_archies";
    }

    public boolean isChangeStatusBar() {
        return true;
    }

    public boolean isStatusDark() {
        return !y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }

    public void k0() {
    }

    public void l0() {
    }

    public void m0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("want2SeeCount", this.mWant2SeeCount);
        setResult(-1, intent);
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }

    public void p0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        w p = supportFragmentManager.p();
        Intrinsics.g(p, "beginTransaction()");
        ProfileSeeListFragment a = ProfileSeeListFragment.INSTANCE.a(1, this.mUserId, E0());
        p.s(R$id.flContent, a);
        this.target = a;
        p.j();
    }

    public void retryLoadData() {
        w0();
        if (!l.a.e()) {
            y0();
            return;
        }
        u0();
        if (this.target == null) {
            p0();
        }
    }
}
