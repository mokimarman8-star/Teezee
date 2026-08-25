package com.transsion.home.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.blankj.utilcode.util.a0;
import com.therouter.TheRouter;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.preload.MainXMLPreloadControlImp;
import com.transsion.home.preload.a;
import com.transsion.home.preload.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qk.d;
import zg.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\u0005J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010$¨\u0006&"}, d2 = {"Lcom/transsion/home/activity/OperateActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lqk/d;", "Lcom/transsion/home/preload/a;", "<init>", "()V", BuildConfig.FLAVOR, "d0", "c0", "()Lqk/d;", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "b0", "()I", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", "onDestroy", "Lcom/transsion/home/preload/b;", "d", "()Lcom/transsion/home/preload/b;", "a", "I", "tabId", "b", "Ljava/lang/String;", "tabCode", "c", "title", "Lcom/transsion/home/preload/b;", "xmlPreload", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class OperateActivity extends BaseActivity<d> implements a {

    /* renamed from: a, reason: from kotlin metadata */
    public int tabId;

    /* renamed from: b, reason: from kotlin metadata */
    public String tabCode = BuildConfig.FLAVOR;

    /* renamed from: c, reason: from kotlin metadata */
    public String title = BuildConfig.FLAVOR;

    /* renamed from: d, reason: from kotlin metadata */
    private b xmlPreload;

    private final void d0() {
        TitleLayout titleLayout = ((d) getMViewBinding()).c;
        titleLayout.setTitleText(this.title);
        h hVar = h.a;
        Context context = titleLayout.getContext();
        Intrinsics.g(context, "getContext(...)");
        titleLayout.setPadding(0, hVar.d(context), 0, 0);
        titleLayout.setBackgroundColor(com.blankj.utilcode.util.h.a(R.color.transparent));
        titleLayout.setViewLineVisible(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int b0() {
        h hVar = h.a;
        Context applicationContext = getApplicationContext();
        Intrinsics.g(applicationContext, "getApplicationContext(...)");
        return hVar.d(applicationContext) + a0.a(44.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public d getViewBinding() {
        TheRouter.l(this);
        d c = d.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.preload.a
    public b d() {
        if (this.xmlPreload == null && Build.VERSION.SDK_INT > 28) {
            this.xmlPreload = new MainXMLPreloadControlImp(this);
        }
        return this.xmlPreload;
    }

    public String getPageName() {
        return SubTabFragment.INSTANCE.a(this.tabId);
    }

    public void initView(Bundle savedInstanceState) {
        d0();
        getSupportFragmentManager().p().s(com.transsion.home.R.id.operate_page_container, SubTabFragment.INSTANCE.b(this.tabId, this.tabCode)).j();
    }

    public boolean isStatusDark() {
        return false;
    }

    public boolean isTranslucent() {
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        b bVar = this.xmlPreload;
        if (bVar != null) {
            bVar.reset();
        }
        this.xmlPreload = null;
    }
}
