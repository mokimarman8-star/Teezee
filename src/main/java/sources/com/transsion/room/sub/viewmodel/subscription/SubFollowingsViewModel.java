package com.transsion.room.sub.viewmodel.subscription;

import android.app.Application;
import androidx.lifecycle.b;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.transsion.gslb.BuildConfig;
import kg.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubFollowingsViewModel extends b {
    public static final a g = new a(null);
    private String b;
    private int c;
    private boolean d;
    private final pp.b e;
    private final b0 f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubFollowingsViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.c = 8;
        this.e = (pp.b) c.e.a().h(pp.b.class);
        this.f = new b0();
    }

    public final b0 e() {
        return this.f;
    }

    public final void f(String str) {
        this.b = str;
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new SubFollowingsViewModel$getSubscriptionFollowingsData$1(this, str, null), 2, (Object) null);
    }

    public final boolean g() {
        return this.d;
    }

    public final void h(String str) {
        this.d = false;
        if (str == null || str.length() == 0) {
            wf.a.a.w("SubFollowingsViewModel", "loadMore: nextPage is null or empty, cannot load more", true);
            this.f.n((Object) null);
            return;
        }
        wf.a.a.c("SubFollowingsViewModel", "loadMore: load nextCursor=" + str, true);
        f(str);
    }

    public final void i() {
        wf.a.a.c("SubFollowingsViewModel", "refresh: reset page to 1 and load first page", true);
        this.b = BuildConfig.FLAVOR;
        this.d = true;
        f(BuildConfig.FLAVOR);
    }
}
