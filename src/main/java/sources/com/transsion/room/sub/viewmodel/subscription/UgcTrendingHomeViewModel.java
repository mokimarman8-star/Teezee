package com.transsion.room.sub.viewmodel.subscription;

import android.app.Application;
import androidx.lifecycle.b;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.sub.fragment.subscription.SubscriptionFragment;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;
import pp.c;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UgcTrendingHomeViewModel extends b {
    public static final a i = new a(null);
    private Integer b;
    private Integer c;
    private final c d;
    private String e;
    private SubscriptionFragment.TabType f;
    private boolean g;
    private final b0 h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UgcTrendingHomeViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = 1;
        this.c = 8;
        this.d = (c) kg.c.e.a().h(c.class);
        this.e = BuildConfig.FLAVOR;
        this.f = SubscriptionFragment.TabType.HOTTEST;
        this.h = new b0();
    }

    public final void e(Integer num, String str) {
        this.e = str;
        this.b = num;
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new UgcTrendingHomeViewModel$getUgcHomeTrendingData$1(num, this, str, null), 2, (Object) null);
    }

    public final b0 f() {
        return this.h;
    }

    public final boolean g() {
        return this.g;
    }

    public final void h(Integer num) {
        this.g = false;
        if (num != null && num.intValue() <= 0) {
            wf.a.a.w("UgcTrendingHomeViewModel", "loadMore: nextPage is null or empty, cannot load more", true);
            this.h.n((Object) null);
            return;
        }
        wf.a.a.c("UgcTrendingHomeViewModel", "loadMore: load nextPage=" + num, true);
        e(num, this.e);
    }

    public final void i() {
        wf.a.a.c("UgcTrendingHomeViewModel", "refresh: reset page to 1 and load first page", true);
        this.b = 1;
        String apiValue = this.f.getApiValue();
        this.e = apiValue;
        this.g = true;
        e(this.b, apiValue);
    }
}
