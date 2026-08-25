package com.transsion.home.activity;

import android.os.Bundle;
import android.view.View;
import com.blankj.utilcode.util.d;
import com.therouter.TheRouter;
import com.tn.lib.view.TitleLayout;
import com.transsion.baselib.report.g;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.activity.UGCFilterActivity;
import com.transsion.home.fragment.filter.FilterFragment;
import com.transsion.home.fragment.filter.UGCFilterFragment;
import eh.a;
import gj.b;
import ij.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010#\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001c¨\u0006$"}, d2 = {"Lcom/transsion/home/activity/UGCFilterActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Leh/a;", "Lcom/transsion/baselib/report/g;", "<init>", "()V", BuildConfig.FLAVOR, "e0", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "d0", "()Leh/a;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initView", "retryLoadData", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", BuildConfig.FLAVOR, "a", "I", "tabId", "b", "Ljava/lang/String;", "tabCode", "c", "mFilterJson", "d", "videoType", "e", "fromOptId", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCFilterActivity extends BaseActivity<a> implements g {

    /* renamed from: a, reason: from kotlin metadata */
    public int tabId;

    /* renamed from: c, reason: from kotlin metadata */
    public String mFilterJson;

    /* renamed from: b, reason: from kotlin metadata */
    public String tabCode = BuildConfig.FLAVOR;

    /* renamed from: d, reason: from kotlin metadata */
    public String videoType = BuildConfig.FLAVOR;

    /* renamed from: e, reason: from kotlin metadata */
    public String fromOptId = BuildConfig.FLAVOR;

    private final void e0() {
        getSupportFragmentManager().p().s(R.id.container, ij.g.a.b() ? UGCFilterFragment.INSTANCE.a(this.tabId, this.tabCode, this.videoType, this.mFilterJson, this.fromOptId) : FilterFragment.INSTANCE.a(this.tabId, this.tabCode, this.mFilterJson)).k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void f0(UGCFilterActivity uGCFilterActivity, View view) {
        b bVar = (b) gj.a.a.a(b.class);
        if (bVar != null) {
            bVar.d(BuildConfig.FLAVOR, uGCFilterActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(UGCFilterActivity uGCFilterActivity, View view) {
        uGCFilterActivity.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public a getViewBinding() {
        a c = a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String getPageName() {
        return "/home/ugc_filter";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initView(Bundle savedInstanceState) {
        TitleLayout titleLayout = getMViewBinding().c;
        titleLayout.setRightView(R.mipmap.ic_search_movie, new View.OnClickListener() { // from class: lk.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCFilterActivity.f0(UGCFilterActivity.this, view);
            }
        });
        titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: lk.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCFilterActivity.g0(UGCFilterActivity.this, view);
            }
        });
        String string = getString(R.string.filter);
        Intrinsics.g(string, "getString(...)");
        titleLayout.setTitleText(string);
        titleLayout.setPadding(0, d.c(), 0, 0);
        e0();
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
    }

    public void retryLoadData() {
    }
}
