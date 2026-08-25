package com.transsion.postdetail.shorttv;

import android.app.Application;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.transsion.baselib.db.video.ShortTvFavoriteState;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashMap;
import kg.c;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvPlayListViewModel extends androidx.lifecycle.b {
    public static final a n = new a(null);
    private final com.transsion.postdetail.shorttv.a b;
    private final b0 c;
    private final b0 d;
    private final b0 e;
    private final b0 f;
    private final b0 g;
    private final b0 h;
    private final b0 i;
    private final b0 j;
    private final b0 k;
    private final b0 l;
    private final HashMap m;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvPlayListViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = (com.transsion.postdetail.shorttv.a) c.e.a().h(com.transsion.postdetail.shorttv.a.class);
        this.c = new b0();
        this.d = new b0();
        this.e = new b0();
        this.f = new b0();
        this.g = new b0();
        this.h = new b0();
        this.i = new b0();
        this.j = new b0();
        this.k = new b0();
        this.l = new b0();
        this.m = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Subject subject) {
        ShortTVFavInfo shortTVFavInfo;
        if (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) {
            return;
        }
        ShortTvFavoriteState shortTvFavoriteState = new ShortTvFavoriteState();
        shortTvFavoriteState.setFavoriteNum(shortTVFavInfo.getFavoriteNum());
        shortTvFavoriteState.setHasFavorite(shortTVFavInfo.getHasFavorite());
        shortTvFavoriteState.setFavoriteTime(shortTVFavInfo.getFavoriteTime());
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = BuildConfig.FLAVOR;
        }
        shortTvFavoriteState.setSubjectId(subjectId);
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new ShortTvPlayListViewModel$updateFavorite$1$1(this, shortTvFavoriteState, null), 3, (Object) null);
    }

    public final void d(Subject subject) {
        ShortTVFavInfo shortTVFavInfo;
        if (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) {
            return;
        }
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new ShortTvPlayListViewModel$favorite$1(subject, shortTVFavInfo.getHasFavorite(), this, shortTVFavInfo, null), 3, (Object) null);
    }

    public final b0 e() {
        return this.f;
    }

    public final b0 f() {
        return this.g;
    }

    public final com.transsion.postdetail.shorttv.a g() {
        return this.b;
    }

    public final b0 h() {
        return this.c;
    }

    public final void i(String str) {
        Intrinsics.h(str, "type");
        this.i.q(str);
    }

    public final void j() {
        this.i.q("ad_cancel");
    }
}
