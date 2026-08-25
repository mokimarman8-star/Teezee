package com.transsion.home.category;

import android.os.Bundle;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.category.fragment.PlayListFragment;
import ij.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qk.e;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/transsion/home/category/PlayListActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lqk/e;", "<init>", "()V", "c0", "()Lqk/e;", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", "isExpand", "b0", "(Z)V", BuildConfig.FLAVOR, "a", "Ljava/lang/String;", "category", "b", "label", "c", "recType", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PlayListActivity extends BaseActivity<e> {

    /* renamed from: a, reason: from kotlin metadata */
    public String category;

    /* renamed from: b, reason: from kotlin metadata */
    public String label;

    /* renamed from: c, reason: from kotlin metadata */
    public String recType;

    /* JADX WARN: Multi-variable type inference failed */
    public final void b0(boolean isExpand) {
        ImmersionBar with = ImmersionBar.with(this);
        boolean z = false;
        if (isExpand && !y.a.a()) {
            z = true;
        }
        with.statusBarDarkFont(z).init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public e getViewBinding() {
        e c = e.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().p().s(R.id.container, PlayListFragment.INSTANCE.a(getIntent().getStringExtra("label"), getIntent().getStringExtra("category"), getIntent().getStringExtra("recType"), getIntent().getStringExtra("topIds"), getIntent().getIntExtra("tabId", 0))).k();
        }
    }

    public boolean isChangeStatusBar() {
        return false;
    }

    public boolean isStatusDark() {
        return false;
    }

    public boolean isTranslucent() {
        return true;
    }
}
