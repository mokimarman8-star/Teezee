package com.transsion.ugcvideodetail.activity;

import android.os.Bundle;
import androidx.core.os.d;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import com.therouter.TheRouter;
import com.tn.lib.widget.R;
import com.transsion.baselib.report.k;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.api.UGCVideoType;
import com.transsion.ugcvideodetail.fragment.UGCLocalVideoDetailFragment;
import com.transsion.videofloat.manager.c;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import cw.e;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;
import yg.l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u0014J\u000f\u0010\u001d\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001aJ\u000f\u0010\u001f\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001f\u0010\u001aJ\u000f\u0010 \u001a\u00020\u0018H\u0016¢\u0006\u0004\b \u0010\u001aJ\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\bH\u0016¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010\u0005R\u0018\u0010*\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b+\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010)R\u0018\u00100\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u0010)R\u0018\u00102\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b1\u0010)R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108¨\u0006:"}, d2 = {"Lcom/transsion/ugcvideodetail/activity/UGCLocalVideoDetailActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Liu/a;", "Lcom/transsion/videofloat/manager/c;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", HttpUrl.FRAGMENT_ENCODE_SET, "onCreate", "(Landroid/os/Bundle;)V", HttpUrl.FRAGMENT_ENCODE_SET, "category", "D0", "(Ljava/lang/String;)V", "C0", "()Liu/a;", "q0", "retryLoadData", "getPageName", "()Ljava/lang/String;", "onPause", "onDestroy", "h", HttpUrl.FRAGMENT_ENCODE_SET, "isMusicFloatingAttach", "()Z", "isChangeStatusBar", "f0", "o0", "n0", "isTranslucent", "isStatusDark", HttpUrl.FRAGMENT_ENCODE_SET, "statusColor", "()I", "l0", "m0", "k0", "p0", "i", "Ljava/lang/String;", "videoId", "j", "resourceId", "k", "type", "l", "previousPageVideoId", "m", "previousPageTrackId", "Landroidx/fragment/app/Fragment;", "n", "Landroidx/fragment/app/Fragment;", "mFragment", "o", "Z", "hasHandledActivityLimit", "UGCVideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class UGCLocalVideoDetailActivity extends BaseNewActivity<iu.a> implements c {

    /* renamed from: i, reason: from kotlin metadata */
    public String videoId;

    /* renamed from: j, reason: from kotlin metadata */
    public String resourceId;

    /* renamed from: k, reason: from kotlin metadata */
    public String type;

    /* renamed from: l, reason: from kotlin metadata */
    public String previousPageVideoId;

    /* renamed from: m, reason: from kotlin metadata */
    public String previousPageTrackId;

    /* renamed from: n, reason: from kotlin metadata */
    private Fragment mFragment;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean hasHandledActivityLimit;

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public iu.a getViewBinding() {
        iu.a c = iu.a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D0(String category) {
        if (this.hasHandledActivityLimit) {
            return;
        }
        k.a.w(Intrinsics.c(category, UGCVideoType.MUSIC.getValue()) ? 1 : 3, this);
        this.hasHandledActivityLimit = true;
    }

    public String f0() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public String getPageName() {
        return "/ugc_video/local_detail";
    }

    @Override // com.transsion.videofloat.manager.c
    public void h() {
        UGCLocalVideoDetailFragment uGCLocalVideoDetailFragment = this.mFragment;
        if (uGCLocalVideoDetailFragment instanceof UGCLocalVideoDetailFragment) {
            UGCLocalVideoDetailFragment uGCLocalVideoDetailFragment2 = uGCLocalVideoDetailFragment instanceof UGCLocalVideoDetailFragment ? uGCLocalVideoDetailFragment : null;
            if (uGCLocalVideoDetailFragment2 != null) {
                uGCLocalVideoDetailFragment2.L0();
            }
        }
    }

    public boolean isChangeStatusBar() {
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
    }

    public void m0() {
    }

    public boolean n0() {
        return false;
    }

    public boolean o0() {
        return false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }

    protected void onDestroy() {
        super.onDestroy();
        h();
        e.a.b().j(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            UGCLocalVideoDetailFragment uGCLocalVideoDetailFragment = this.mFragment;
            if (uGCLocalVideoDetailFragment instanceof UGCLocalVideoDetailFragment) {
                UGCLocalVideoDetailFragment uGCLocalVideoDetailFragment2 = uGCLocalVideoDetailFragment instanceof UGCLocalVideoDetailFragment ? uGCLocalVideoDetailFragment : null;
                if (uGCLocalVideoDetailFragment2 != null) {
                    uGCLocalVideoDetailFragment2.L0();
                }
            }
        }
    }

    public void p0() {
    }

    public void q0() {
        if (this.mFragment == null) {
            Fragment k0 = getSupportFragmentManager().k0("VideoDetailFragment");
            this.mFragment = k0;
            if (k0 == null) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
                w p = supportFragmentManager.p();
                Intrinsics.g(p, "beginTransaction()");
                UGCLocalVideoDetailFragment a = UGCLocalVideoDetailFragment.INSTANCE.a();
                a.setArguments(d.b(new Pair[]{TuplesKt.a("id", this.videoId), TuplesKt.a("resource_id", this.resourceId), TuplesKt.a("ugcCategory", this.type), TuplesKt.a("parent_video_id", this.previousPageVideoId), TuplesKt.a("parent_track_id", this.previousPageTrackId)}));
                p.t(R$id.container, a, "VideoDetailFragment");
                this.mFragment = a;
                p.j();
            }
        }
    }

    public void retryLoadData() {
        w0();
        if (!l.a.e()) {
            y0();
        } else {
            u0();
            p0();
        }
    }

    public int statusColor() {
        return R.color.black;
    }
}
