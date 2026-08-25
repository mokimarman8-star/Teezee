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
import com.transsion.home.activity.FilterActivity;
import com.transsion.home.fragment.filter.FilterFragment;
import eh.a;
import gj.b;
import ij.y;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010!¨\u0006'"}, d2 = {"Lcom/transsion/home/activity/FilterActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Leh/a;", "Lcom/transsion/baselib/report/g;", "<init>", "()V", BuildConfig.FLAVOR, "e0", "i0", "h0", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "d0", "()Leh/a;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initView", "retryLoadData", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", BuildConfig.FLAVOR, "a", "I", "tabId", "b", "Ljava/lang/String;", "tabCode", "c", "mFilterJson", "d", "videoType", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class FilterActivity extends BaseActivity<a> implements g {

    /* renamed from: a, reason: from kotlin metadata */
    public int tabId;

    /* renamed from: c, reason: from kotlin metadata */
    public String mFilterJson;

    /* renamed from: b, reason: from kotlin metadata */
    public String tabCode = BuildConfig.FLAVOR;

    /* renamed from: d, reason: from kotlin metadata */
    public String videoType = BuildConfig.FLAVOR;

    private final void e0() {
        getSupportFragmentManager().p().s(R.id.container, FilterFragment.INSTANCE.a(this.tabId, this.tabCode, this.mFilterJson)).k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void f0(FilterActivity filterActivity, View view) {
        b bVar = (b) gj.a.a.a(b.class);
        if (bVar != null) {
            bVar.d(BuildConfig.FLAVOR, filterActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(FilterActivity filterActivity, View view) {
        filterActivity.i0();
        filterActivity.finish();
    }

    private final void h0() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "back_browse");
        hashMap.put("tabId", String.valueOf(this.tabId));
        com.transsion.baselib.helper.a.a.e(getPageName(), hashMap);
    }

    private final void i0() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "back_click");
        hashMap.put("tabId", String.valueOf(this.tabId));
        com.transsion.baselib.helper.a.a.f(getPageName(), hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public a getViewBinding() {
        a c = a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String getPageName() {
        return "home_filter_page";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initView(Bundle savedInstanceState) {
        TitleLayout titleLayout = getMViewBinding().c;
        titleLayout.setRightView(R.mipmap.ic_search_movie, new View.OnClickListener() { // from class: lk.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterActivity.f0(FilterActivity.this, view);
            }
        });
        titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: lk.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterActivity.g0(FilterActivity.this, view);
            }
        });
        h0();
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

    public qi.b newLogViewConfig() {
        qi.b bVar = new qi.b(getPageName(), false, 2, null);
        bVar.l(true);
        return bVar;
    }

    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }

    public void retryLoadData() {
    }
}
