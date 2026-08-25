package com.transsion.videodetail;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.therouter.TheRouter;
import com.tn.lib.widget.R;
import com.transsion.baseui.activity.BaseNewActivity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import f4.a;
import kotlin.Metadata;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0018\u0010\u0005J\u0019\u0010\u001b\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001f\u0010\u0005R\u0018\u0010\"\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b*\u0010!R\u0018\u0010-\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010!R\u0016\u00100\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00104\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b3\u0010/R\u0016\u00106\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b5\u0010&R\u0016\u00108\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b7\u0010&R$\u0010@\u001a\u0004\u0018\u0001098\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/transsion/videodetail/BaseDetailActivity;", "Lf4/a;", "T", "Lcom/transsion/baseui/activity/BaseNewActivity;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", HttpUrl.FRAGMENT_ENCODE_SET, "statusColor", "()I", "isMusicFloatingAttach", HttpUrl.FRAGMENT_ENCODE_SET, "f0", "()Ljava/lang/String;", "o0", "n0", HttpUrl.FRAGMENT_ENCODE_SET, "l0", "isMonitorNetworkState", "retryLoadData", "setView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "m0", "k0", "p0", "i", "Ljava/lang/String;", "id", "j", "ops", "k", "Z", "autoDownload", "l", "autoPlay", "m", "autoPlayResourceId", "n", "moduleName", "o", "I", "preloadId", "p", "curSeason", "q", "targetEp", "r", "isMusicLikedFragment", "s", "isMusicFloatViewClick", "Landroidx/fragment/app/Fragment;", "t", "Landroidx/fragment/app/Fragment;", "D0", "()Landroidx/fragment/app/Fragment;", "E0", "(Landroidx/fragment/app/Fragment;)V", "mFragment", "VideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class BaseDetailActivity<T extends f4.a> extends BaseNewActivity<T> {

    /* renamed from: i, reason: from kotlin metadata */
    public String id;

    /* renamed from: j, reason: from kotlin metadata */
    public String ops;

    /* renamed from: k, reason: from kotlin metadata */
    public boolean autoDownload;

    /* renamed from: l, reason: from kotlin metadata */
    public boolean autoPlay;

    /* renamed from: m, reason: from kotlin metadata */
    public String autoPlayResourceId;

    /* renamed from: n, reason: from kotlin metadata */
    public String moduleName;

    /* renamed from: o, reason: from kotlin metadata */
    public int preloadId;

    /* renamed from: p, reason: from kotlin metadata */
    public int curSeason;

    /* renamed from: q, reason: from kotlin metadata */
    public int targetEp;

    /* renamed from: r, reason: from kotlin metadata */
    public boolean isMusicLikedFragment;

    /* renamed from: s, reason: from kotlin metadata */
    public boolean isMusicFloatViewClick;

    /* renamed from: t, reason: from kotlin metadata */
    private Fragment mFragment;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0() {
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.w(0.0f);
        }
    }

    /* renamed from: D0, reason: from getter */
    protected final Fragment getMFragment() {
        return this.mFragment;
    }

    protected final void E0(Fragment fragment) {
        this.mFragment = fragment;
    }

    public String f0() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public boolean isChangeStatusBar() {
        return true;
    }

    public boolean isMonitorNetworkState() {
        return false;
    }

    public boolean isMusicFloatingAttach() {
        return false;
    }

    public boolean isStatusDark() {
        return false;
    }

    public boolean isTranslucent() {
        return true;
    }

    public void k0() {
    }

    public void l0() {
        s0();
    }

    public void m0() {
    }

    public boolean n0() {
        return true;
    }

    public boolean o0() {
        return false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }

    public void p0() {
    }

    public void retryLoadData() {
    }

    protected void setView() {
        super.setView();
        getMViewBinding().getRoot().post(new Runnable() { // from class: com.transsion.videodetail.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseDetailActivity.F0();
            }
        });
    }

    public int statusColor() {
        return R.color.black;
    }
}
