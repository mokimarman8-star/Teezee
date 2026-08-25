package com.google.firebase.sessions.settings;

import androidx.datastore.core.g;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.datastore.preferences.core.c;
import androidx.datastore.preferences.core.f;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class SettingsCache {
    private static final a c = new a(null);
    private static final c.a d = f.a("firebase_sessions_enabled");
    private static final c.a e = f.c("firebase_sessions_sampling_rate");
    private static final c.a f = f.e("firebase_sessions_restart_timeout");
    private static final c.a g = f.e("firebase_sessions_cache_duration");
    private static final c.a h = f.f("firebase_sessions_cache_updated_time");
    private final g a;
    private c b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", TtmlNode.ANONYMOUS_REGION_ID, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", l = {46}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.settings.SettingsCache$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsCache.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            SettingsCache settingsCache;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                SettingsCache settingsCache2 = SettingsCache.this;
                kotlinx.coroutines.flow.a data = settingsCache2.a.getData();
                this.L$0 = settingsCache2;
                this.label = 1;
                Object o = kotlinx.coroutines.flow.c.o(data, this);
                if (o == f) {
                    return f;
                }
                settingsCache = settingsCache2;
                obj = o;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                settingsCache = (SettingsCache) this.L$0;
                ResultKt.b(obj);
            }
            settingsCache.l(((androidx.datastore.preferences.core.c) obj).d());
            return Unit.a;
        }
    }

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SettingsCache(g gVar) {
        Intrinsics.h(gVar, "dataStore");
        this.a = gVar;
        i.f((CoroutineContext) null, new AnonymousClass1(null), 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|24|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0029, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        android.util.Log.w("SettingsCache", "Failed to update cache config value: " + r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(c.a aVar, Object obj, Continuation continuation) {
        SettingsCache$updateConfigValue$1 settingsCache$updateConfigValue$1;
        int i;
        if (continuation instanceof SettingsCache$updateConfigValue$1) {
            settingsCache$updateConfigValue$1 = (SettingsCache$updateConfigValue$1) continuation;
            int i2 = settingsCache$updateConfigValue$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                settingsCache$updateConfigValue$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = settingsCache$updateConfigValue$1.result;
                Object f2 = IntrinsicsKt.f();
                i = settingsCache$updateConfigValue$1.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    g gVar = this.a;
                    SettingsCache$updateConfigValue$2 settingsCache$updateConfigValue$2 = new SettingsCache$updateConfigValue$2(obj, aVar, this, null);
                    settingsCache$updateConfigValue$1.label = 1;
                    if (PreferencesKt.a(gVar, settingsCache$updateConfigValue$2, settingsCache$updateConfigValue$1) == f2) {
                        return f2;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj2);
                }
                return Unit.a;
            }
        }
        settingsCache$updateConfigValue$1 = new SettingsCache$updateConfigValue$1(this, continuation);
        Object obj22 = settingsCache$updateConfigValue$1.result;
        Object f22 = IntrinsicsKt.f();
        i = settingsCache$updateConfigValue$1.label;
        if (i != 0) {
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(androidx.datastore.preferences.core.c cVar) {
        this.b = new c((Boolean) cVar.b(d), (Double) cVar.b(e), (Integer) cVar.b(f), (Integer) cVar.b(g), (Long) cVar.b(h));
    }

    public final boolean d() {
        c cVar = this.b;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.y("sessionConfigs");
            cVar = null;
        }
        Long b = cVar.b();
        c cVar3 = this.b;
        if (cVar3 == null) {
            Intrinsics.y("sessionConfigs");
        } else {
            cVar2 = cVar3;
        }
        Integer a2 = cVar2.a();
        return b == null || a2 == null || (System.currentTimeMillis() - b.longValue()) / ((long) 1000) >= ((long) a2.intValue());
    }

    public final Integer e() {
        c cVar = this.b;
        if (cVar == null) {
            Intrinsics.y("sessionConfigs");
            cVar = null;
        }
        return cVar.d();
    }

    public final Double f() {
        c cVar = this.b;
        if (cVar == null) {
            Intrinsics.y("sessionConfigs");
            cVar = null;
        }
        return cVar.e();
    }

    public final Boolean g() {
        c cVar = this.b;
        if (cVar == null) {
            Intrinsics.y("sessionConfigs");
            cVar = null;
        }
        return cVar.c();
    }

    public final Object i(Double d2, Continuation continuation) {
        Object h2 = h(e, d2, continuation);
        return h2 == IntrinsicsKt.f() ? h2 : Unit.a;
    }

    public final Object j(Integer num, Continuation continuation) {
        Object h2 = h(g, num, continuation);
        return h2 == IntrinsicsKt.f() ? h2 : Unit.a;
    }

    public final Object k(Long l, Continuation continuation) {
        Object h2 = h(h, l, continuation);
        return h2 == IntrinsicsKt.f() ? h2 : Unit.a;
    }

    public final Object m(Integer num, Continuation continuation) {
        Object h2 = h(f, num, continuation);
        return h2 == IntrinsicsKt.f() ? h2 : Unit.a;
    }

    public final Object n(Boolean bool, Continuation continuation) {
        Object h2 = h(d, bool, continuation);
        return h2 == IntrinsicsKt.f() ? h2 : Unit.a;
    }
}
