package com.transsion.room.sub.viewmodel.subscription;

import android.app.Application;
import androidx.lifecycle.b;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import kg.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubscriptionViewModel extends b {
    public static final a k = new a(null);
    private final b0 b;
    private final b0 c;
    private final b0 d;
    private final b0 e;
    private final b0 f;
    private final b0 g;
    private int h;
    private final pp.a i;
    private String j;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = new b0();
        this.c = new b0();
        this.d = new b0();
        this.e = new b0();
        this.f = new b0();
        this.g = new b0();
        this.h = 1;
        this.i = (pp.a) c.e.a().h(pp.a.class);
    }

    public final b0 d() {
        return this.b;
    }

    public final void e(String str) {
        Intrinsics.h(str, "uid");
        this.j = str;
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new SubscriptionViewModel$getSubscriptionStatsData$1(this, str, null), 2, (Object) null);
    }
}
