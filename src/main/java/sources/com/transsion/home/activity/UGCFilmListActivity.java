package com.transsion.home.activity;

import android.os.Bundle;
import com.therouter.TheRouter;
import com.transsion.baselib.report.g;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.fragment.film.UGCFilmListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qk.b;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010#\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001c¨\u0006$"}, d2 = {"Lcom/transsion/home/activity/UGCFilmListActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lqk/b;", "Lcom/transsion/baselib/report/g;", "<init>", "()V", BuildConfig.FLAVOR, "c0", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "b0", "()Lqk/b;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initView", "retryLoadData", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", BuildConfig.FLAVOR, "a", "I", "tabId", "b", "Ljava/lang/String;", "filmType", "c", "filmListTitle", "d", "videoType", "e", "fromOptId", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCFilmListActivity extends BaseActivity<b> implements g {

    /* renamed from: a, reason: from kotlin metadata */
    public int tabId;

    /* renamed from: b, reason: from kotlin metadata */
    public String filmType = BuildConfig.FLAVOR;

    /* renamed from: c, reason: from kotlin metadata */
    public String filmListTitle = BuildConfig.FLAVOR;

    /* renamed from: d, reason: from kotlin metadata */
    public String videoType = BuildConfig.FLAVOR;

    /* renamed from: e, reason: from kotlin metadata */
    public String fromOptId = BuildConfig.FLAVOR;

    private final void c0() {
        getSupportFragmentManager().p().s(R.id.fragment_container, UGCFilmListFragment.Companion.b(UGCFilmListFragment.INSTANCE, String.valueOf(this.tabId), this.filmType, this.filmListTitle, false, this.videoType, this.fromOptId, 8, null)).i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b getViewBinding() {
        b c = b.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String getPageName() {
        return "/home/ugc_film_list";
    }

    public void initView(Bundle savedInstanceState) {
        c0();
    }

    public boolean isStatusDark() {
        return false;
    }

    public boolean isTranslucent() {
        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }

    public void retryLoadData() {
        UGCFilmListFragment j0 = getSupportFragmentManager().j0(R.id.fragment_container);
        if (j0 == null || !(j0 instanceof UGCFilmListFragment)) {
            return;
        }
        j0.retryLoadData();
    }
}
