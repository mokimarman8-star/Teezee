package com.transsion.home.viewmodel;

import android.app.Application;
import androidx.lifecycle.u0;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Pager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCFilmListViewModel extends androidx.lifecycle.b {
    public static final a j = new a(null);
    public static final int k = 8;
    private final yk.b b;
    private String c;
    private int d;
    private Pager e;
    private boolean f;
    private final androidx.lifecycle.b0 g;
    private final androidx.lifecycle.b0 h;
    private boolean i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCFilmListViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = (yk.b) kg.c.e.a().h(yk.b.class);
        this.c = BuildConfig.FLAVOR;
        this.d = 1;
        this.g = new androidx.lifecycle.b0();
        this.h = new androidx.lifecycle.b0();
    }

    private final void i(int i) {
        a.a.f(wf.a.a, "FilmListViewModel", "getFilmList: start loading, page=" + i + ", filmType=" + this.c, false, 4, (Object) null);
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new UGCFilmListViewModel$getFilmList$1(this, i, null), 2, (Object) null);
    }

    public final androidx.lifecycle.b0 j() {
        return this.h;
    }

    public final androidx.lifecycle.b0 k() {
        return this.g;
    }

    public final boolean l() {
        Pager pager = this.e;
        if (pager != null) {
            return Intrinsics.c(pager.getHasMore(), Boolean.TRUE);
        }
        return false;
    }

    public final void m(String str) {
        Intrinsics.h(str, "filmType");
        this.c = str;
        a.a.f(wf.a.a, "FilmListViewModel", "init: filmType=" + str, false, 4, (Object) null);
    }

    public final boolean n() {
        return this.f;
    }

    public final void o() {
        Pager pager = this.e;
        String nextPage = pager != null ? pager.getNextPage() : null;
        if (nextPage == null || nextPage.length() == 0) {
            a.a.x(wf.a.a, "FilmListViewModel", "loadMore: nextPage is null or empty, cannot load more", false, 4, (Object) null);
            this.g.n((Object) null);
            return;
        }
        a.a.f(wf.a.a, "FilmListViewModel", "loadMore: load nextPage=" + nextPage, false, 4, (Object) null);
        this.f = false;
        Integer v = StringsKt.v(nextPage);
        i(v != null ? v.intValue() : 1);
    }

    public final void p() {
        a.a.f(wf.a.a, "FilmListViewModel", "refresh: reset page to 1 and load first page", false, 4, (Object) null);
        this.d = 1;
        this.e = null;
        this.f = true;
        i(1);
    }
}
