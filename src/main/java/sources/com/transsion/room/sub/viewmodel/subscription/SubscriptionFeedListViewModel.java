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
public final class SubscriptionFeedListViewModel extends b {
    public static final a f = new a(null);
    private static int g = 8;
    private String b;
    private boolean c;
    private final pp.a d;
    private final b0 e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionFeedListViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.d = (pp.a) c.e.a().h(pp.a.class);
        this.e = new b0();
    }

    public final b0 e() {
        return this.e;
    }

    public final void f(String str) {
        this.b = str;
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new SubscriptionFeedListViewModel$getSubscriptionFeedData$1(this, str, null), 2, (Object) null);
    }

    public final boolean g() {
        return this.c;
    }

    public final void h(String str) {
        this.c = false;
        if (str == null || str.length() == 0) {
            wf.a.a.w("SubscriptionFeedListViewModel", "loadMore: nextCursor is null or empty, cannot load more", true);
            this.e.n((Object) null);
            return;
        }
        wf.a.a.c("SubscriptionFeedListViewModel", "loadMore: load nextCursor=" + str, true);
        f(str);
    }

    public final void i() {
        wf.a.a.c("SubscriptionFeedListViewModel", "refresh: reset page to 1 and load first page", true);
        this.c = true;
        f(BuildConfig.FLAVOR);
    }
}
