package com.transsion.subroom.app;

import android.content.ComponentCallbacks2;
import android.content.Context;
import androidx.work.a;
import bin.mt.signature.KillerApplication;
import cm.f;
import com.blankj.utilcode.util.t;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.transsion.baselib.net.AppLifeStatusInterceptor;
import com.transsion.baselib.report.k;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.startup.StartupManager;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsion.subroom.app.SubRoomApp;
import ct.b;
import ct.c;
import ct.d;
import ig.e;
import ij.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import on.e0;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00182\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/transsion/subroom/app/SubRoomApp;", "Landroid/app/Application;", "Landroid/content/ComponentCallbacks2;", "Landroidx/work/a$c;", "<init>", "()V", "Landroid/content/Context;", "base", "", "attachBaseContext", "(Landroid/content/Context;)V", "onCreate", "", "level", "onTrimMemory", "(I)V", "Landroidx/work/a;", "a", "()Landroidx/work/a;", "", "Lkotlin/Lazy;", "c", "()Z", "isMainProcess", "b", "app_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class SubRoomApp extends KillerApplication implements ComponentCallbacks2, a.c {

    /* renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private final Lazy isMainProcess = LazyKt.b(new Function0() { // from class: ct.a
        public final Object invoke() {
            boolean d;
            d = SubRoomApp.d();
            return Boolean.valueOf(d);
        }
    });

    /* renamed from: com.transsion.subroom.app.SubRoomApp$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Function0 g() {
            return new b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean h() {
            ConfigBean c = f.c.a().c("player_async", true);
            return Intrinsics.c(c != null ? c.getValue() : null, "false");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Function0 i() {
            return new c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean j() {
            return !h.a.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Function0 k() {
            return new d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int l() {
            Integer v;
            ConfigBean c = f.c.a().c("sb_player_type", true);
            String value = c != null ? c.getValue() : null;
            if (value == null || value.length() == 0 || (v = StringsKt.v(value)) == null) {
                return 1;
            }
            return v.intValue();
        }
    }

    private final boolean c() {
        return ((Boolean) this.isMainProcess.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d() {
        return t.e();
    }

    public a a() {
        a a = new a.b().b(4).a();
        Intrinsics.g(a, "build(...)");
        return a;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        StartupManager.g.a().A(base);
        com.transsion.startup.pref.consume.c.a.j();
        com.transsion.baselib.net.d.a.c();
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        if (c()) {
            e0 e0Var = e0.a;
            Companion companion = INSTANCE;
            e0Var.x(companion.i());
            e0Var.w(companion.g());
            e0Var.y(companion.k());
            e eVar = e.a;
            eVar.a(new com.transsion.baselib.net.f());
            eVar.a(new AppLifeStatusInterceptor());
            CacheIpPool.a.o("api6.aoneroom.com");
            StartupManager.g.a().c0(this);
            if (!com.transsion.baselib.report.launch.b.a.b().getBoolean("dark_mode_follow_sys", false)) {
                androidx.appcompat.app.f.O(2);
            }
            registerActivityLifecycleCallbacks(k.a);
        } else {
            StartupManager.g.a().V(this);
        }
        AppStartReport.a.e(new AppStartDotState(AppStartDotState.APP_END, 0L, 2, null));
        com.transsion.baseui.activity.k.b((String) null, 1, (Object) null);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        StartupManager.g.a().j0(level, c());
    }
}
