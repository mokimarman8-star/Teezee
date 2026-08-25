package com.transsion.room.sub.viewmodel.subscription;

import android.app.Application;
import androidx.lifecycle.b;
import androidx.lifecycle.b0;
import com.transsion.gslb.BuildConfig;
import kg.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends b {
    public static final C0054a e = new C0054a(null);
    private String b;
    private final pp.a c;
    private final b0 d;

    /* renamed from: com.transsion.room.sub.viewmodel.subscription.a$a, reason: collision with other inner class name */
    public static final class C0054a {
        private C0054a() {
        }

        public /* synthetic */ C0054a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = BuildConfig.FLAVOR;
        this.c = (pp.a) c.e.a().h(pp.a.class);
        this.d = new b0();
    }
}
