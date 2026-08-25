package com.transsion.postdetail.comment.ui;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import com.therouter.TheRouter;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.usercenter.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import yg.l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u000eR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/transsion/postdetail/comment/ui/CommentListActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lwn/c;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "C0", "()Lwn/c;", BuildConfig.FLAVOR, "f0", "()Ljava/lang/String;", "l0", "m0", "k0", "retryLoadData", "p0", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isChangeStatusBar", "isStatusDark", "getPageName", "Lcom/transsion/postdetail/comment/ui/CommentListFragment;", "i", "Lcom/transsion/postdetail/comment/ui/CommentListFragment;", "target", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CommentListActivity extends BaseNewActivity<wn.c> {

    /* renamed from: i, reason: from kotlin metadata */
    private CommentListFragment target;

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public wn.c getViewBinding() {
        wn.c c = wn.c.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String f0() {
        return BuildConfig.FLAVOR;
    }

    public String getPageName() {
        return "comments";
    }

    public boolean isChangeStatusBar() {
        return true;
    }

    public boolean isStatusDark() {
        return true;
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

    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }

    public void p0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        w p = supportFragmentManager.p();
        Intrinsics.g(p, "beginTransaction()");
        CommentListFragment a = CommentListFragment.INSTANCE.a();
        p.s(R.id.container, a);
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
