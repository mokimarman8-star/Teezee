package com.transsion.search_pugc.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import com.therouter.TheRouter;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.R$id;
import com.transsion.search_pugc.fragment.SearchSubjectFragment;
import com.transsion.search_pugc.g;
import ij.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import vp.a;
import yg.l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\tR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001e¨\u0006)"}, d2 = {"Lcom/transsion/search_pugc/activity/SearchManagerActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lvp/a;", "<init>", "()V", BuildConfig.FLAVOR, "D0", BuildConfig.FLAVOR, "f0", "()Ljava/lang/String;", "C0", "()Lvp/a;", "l0", "m0", "k0", "p0", "q0", "retryLoadData", BuildConfig.FLAVOR, "n0", "()Z", "isTranslucent", "isStatusDark", "isChangeStatusBar", "getPageName", "Landroidx/fragment/app/Fragment;", "i", "Landroidx/fragment/app/Fragment;", "mFragment", "j", "Ljava/lang/String;", "keyWord", BuildConfig.FLAVOR, "k", "I", "searchType", "l", "Z", "backExitSearch", "m", "fromUGCVideoId", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchManagerActivity extends BaseNewActivity<a> {

    /* renamed from: i, reason: from kotlin metadata */
    private Fragment mFragment;

    /* renamed from: j, reason: from kotlin metadata */
    public String keyWord;

    /* renamed from: k, reason: from kotlin metadata */
    public int searchType = 3;

    /* renamed from: l, reason: from kotlin metadata */
    public boolean backExitSearch;

    /* renamed from: m, reason: from kotlin metadata */
    public String fromUGCVideoId;

    /* JADX WARN: Multi-variable type inference failed */
    private final void D0() {
        if (this.mFragment != null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra("hot_search_word");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        w p = supportFragmentManager.p();
        Intrinsics.g(p, "beginTransaction()");
        SearchSubjectFragment a = SearchSubjectFragment.INSTANCE.a(stringExtra, this.keyWord, this.backExitSearch, this.fromUGCVideoId);
        this.mFragment = a;
        int i = R$id.fl_content;
        Intrinsics.e(a);
        p.s(i, a);
        p.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public a getViewBinding() {
        a c = a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String f0() {
        return BuildConfig.FLAVOR;
    }

    public String getPageName() {
        return "searchpage";
    }

    public boolean isChangeStatusBar() {
        return !y.a.a();
    }

    public boolean isStatusDark() {
        return !y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }

    public void k0() {
    }

    public void l0() {
        TheRouter.l(this);
        g.g.d(this);
    }

    public void m0() {
    }

    public boolean n0() {
        return this.searchType != 1;
    }

    public void p0() {
    }

    public void q0() {
        super.q0();
        D0();
    }

    public void retryLoadData() {
        w0();
        if (!l.a.e()) {
            y0();
        } else {
            u0();
            D0();
        }
    }
}
