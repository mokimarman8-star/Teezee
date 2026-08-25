package com.transsion.shorttv._channel.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import com.transsion.shorttv._channel.ui.activity.ShortTvMovieFilterActivity;
import com.transsion.shorttv._channel.ui.fragment.ShortTvMovieFragment;
import com.transsion.shorttv.base.activity.BaseActivity;
import hr.e;
import hr.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qi.h;
import qr.n;
import xq.b;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\bR\u0016\u0010\u001f\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/transsion/shorttv/_channel/ui/activity/ShortTvMovieFilterActivity;", "Lcom/transsion/shorttv/base/activity/BaseActivity;", "Lqr/n;", "Lhr/e;", "<init>", "()V", BuildConfig.FLAVOR, "a0", "Z", BuildConfig.FLAVOR, "isTranslucent", "()Z", "isStatusDark", "X", "()Lqr/n;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initView", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", BuildConfig.FLAVOR, "g", "I", "tabId", "h", "showViewPager", "i", "Ljava/lang/String;", "tabCode", "j", "mFilterJson", BuildConfig.FLAVOR, "Lcom/transsion/shorttv/_channel/model/ShortTvHomeTabItem;", "k", "Ljava/util/List;", "tabItems", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvMovieFilterActivity extends BaseActivity<n> implements e {

    /* renamed from: g, reason: from kotlin metadata */
    public int tabId;

    /* renamed from: j, reason: from kotlin metadata */
    public String mFilterJson;

    /* renamed from: h, reason: from kotlin metadata */
    public boolean showViewPager = true;

    /* renamed from: i, reason: from kotlin metadata */
    public String tabCode = BuildConfig.FLAVOR;

    /* renamed from: k, reason: from kotlin metadata */
    private final List tabItems = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(ShortTvMovieFilterActivity shortTvMovieFilterActivity, View view) {
        shortTvMovieFilterActivity.a0();
        shortTvMovieFilterActivity.finish();
    }

    private final void Z() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "back_browse");
        hashMap.put("tabId", String.valueOf(this.tabId));
        h.a.z(getPageName(), hashMap);
    }

    private final void a0() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "back_click");
        hashMap.put("tabId", String.valueOf(this.tabId));
        h.a.z(getPageName(), hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public n getViewBinding() {
        n c = n.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    public String getPageName() {
        return "movie_filter_page";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.View, com.transsion.shorttv._channel.ui.widget.ShortTvTitleLayout] */
    @Override // com.transsion.shorttv.base.activity.BaseActivity
    public void initView(Bundle savedInstanceState) {
        ?? r5 = ((n) getMViewBinding()).c;
        r5.setLeftOnclick(new View.OnClickListener() { // from class: tq.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvMovieFilterActivity.Y(ShortTvMovieFilterActivity.this, view);
            }
        });
        Z();
        String string = getString(R.string.short_tv_filter);
        Intrinsics.g(string, "getString(...)");
        r5.setTitleText(string);
        Context context = r5.getContext();
        Intrinsics.g(context, "getContext(...)");
        r5.setPadding(0, b.b(context), 0, 0);
        getSupportFragmentManager().p().s(R.id.content_layout, ShortTvMovieFragment.INSTANCE.a(true, this.mFilterJson)).j();
    }

    @Override // com.transsion.shorttv.base.activity.BaseActivity
    public boolean isStatusDark() {
        return !g.a.a();
    }

    @Override // com.transsion.shorttv.base.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.shorttv.base.activity.BaseActivity, com.transsion.shorttv.base.activity.BaseCommonActivity
    protected void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }
}
