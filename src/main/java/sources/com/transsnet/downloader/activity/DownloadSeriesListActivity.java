package com.transsnet.downloader.activity;

import android.os.Bundle;
import bx.c;
import com.therouter.TheRouter;
import com.tn.lib.view.TitleLayout;
import com.transsion.baseui.activity.BaseActivity;
import com.transsnet.downloader.R;
import com.transsnet.downloader.fragment.DownloadEpisodesListFragment;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ij.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/transsnet/downloader/activity/DownloadSeriesListActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lbx/c;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", HttpUrl.FRAGMENT_ENCODE_SET, "onCreate", "(Landroid/os/Bundle;)V", "b0", "()Lbx/c;", HttpUrl.FRAGMENT_ENCODE_SET, "isTranslucent", "()Z", "isChangeStatusBar", "isStatusDark", HttpUrl.FRAGMENT_ENCODE_SET, "statusColor", "()I", HttpUrl.FRAGMENT_ENCODE_SET, "a", "Ljava/lang/String;", "name", "b", "subjectId", "c", "I", "parentPosition", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadSeriesListActivity extends BaseActivity<c> {

    /* renamed from: a, reason: from kotlin metadata */
    public String name;

    /* renamed from: b, reason: from kotlin metadata */
    public String subjectId;

    /* renamed from: c, reason: from kotlin metadata */
    public int parentPosition = -1;

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public c getViewBinding() {
        c c = c.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public boolean isChangeStatusBar() {
        return false;
    }

    public boolean isStatusDark() {
        return !y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().p().s(R.id.container, DownloadEpisodesListFragment.INSTANCE.a(this.subjectId, this.parentPosition)).k();
        }
        TitleLayout titleLayout = ((c) getMViewBinding()).c;
        String str = this.name;
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        titleLayout.setTitleText(str);
    }

    public int statusColor() {
        return com.tn.lib.widget.R.color.text_01;
    }
}
