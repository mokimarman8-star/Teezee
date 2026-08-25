package com.google.firebase.sessions.settings;

import android.os.Build;
import android.util.Log;
import androidx.datastore.core.g;
import com.google.firebase.sessions.InstallationId;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import lc.e;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class RemoteSettings implements d {
    private static final a g = new a(null);
    private final CoroutineContext a;
    private final e b;
    private final com.google.firebase.sessions.b c;
    private final com.google.firebase.sessions.settings.a d;
    private final Lazy e;
    private final kotlinx.coroutines.sync.a f;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RemoteSettings(CoroutineContext coroutineContext, e eVar, com.google.firebase.sessions.b bVar, com.google.firebase.sessions.settings.a aVar, final g gVar) {
        Intrinsics.h(coroutineContext, "backgroundDispatcher");
        Intrinsics.h(eVar, "firebaseInstallationsApi");
        Intrinsics.h(bVar, "appInfo");
        Intrinsics.h(aVar, "configsFetcher");
        Intrinsics.h(gVar, "dataStore");
        this.a = coroutineContext;
        this.b = eVar;
        this.c = bVar;
        this.d = aVar;
        this.e = LazyKt.b(new Function0<SettingsCache>() { // from class: com.google.firebase.sessions.settings.RemoteSettings$settingsCache$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SettingsCache m48invoke() {
                return new SettingsCache(gVar);
            }
        });
        this.f = kotlinx.coroutines.sync.g.b(false, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsCache f() {
        return (SettingsCache) this.e.getValue();
    }

    private final String g(String str) {
        return new Regex("/").replace(str, TtmlNode.ANONYMOUS_REGION_ID);
    }

    @Override // com.google.firebase.sessions.settings.d
    public Boolean a() {
        return f().g();
    }

    @Override // com.google.firebase.sessions.settings.d
    public Duration b() {
        Integer e = f().e();
        if (e == null) {
            return null;
        }
        Duration.Companion companion = Duration.b;
        return Duration.g(DurationKt.s(e.intValue(), DurationUnit.SECONDS));
    }

    @Override // com.google.firebase.sessions.settings.d
    public Double c() {
        return f().f();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:26:0x004d, B:27:0x00ab, B:29:0x00b9, B:32:0x00c6, B:37:0x008a, B:39:0x0094, B:42:0x009a), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c6 A[Catch: all -> 0x0051, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:26:0x004d, B:27:0x00ab, B:29:0x00b9, B:32:0x00c6, B:37:0x008a, B:39:0x0094, B:42:0x009a), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:26:0x004d, B:27:0x00ab, B:29:0x00b9, B:32:0x00c6, B:37:0x008a, B:39:0x0094, B:42:0x009a), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a A[Catch: all -> 0x0051, TRY_ENTER, TryCatch #0 {all -> 0x0051, blocks: (B:26:0x004d, B:27:0x00ab, B:29:0x00b9, B:32:0x00c6, B:37:0x008a, B:39:0x0094, B:42:0x009a), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    @Override // com.google.firebase.sessions.settings.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object d(Continuation continuation) {
        RemoteSettings$updateSettings$1 remoteSettings$updateSettings$1;
        ?? r8;
        kotlinx.coroutines.sync.a aVar;
        kotlinx.coroutines.sync.a aVar2;
        RemoteSettings remoteSettings;
        String b;
        try {
            if (continuation instanceof RemoteSettings$updateSettings$1) {
                remoteSettings$updateSettings$1 = (RemoteSettings$updateSettings$1) continuation;
                int i = remoteSettings$updateSettings$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    remoteSettings$updateSettings$1.label = i - Integer.MIN_VALUE;
                    Object obj = remoteSettings$updateSettings$1.result;
                    Object f = IntrinsicsKt.f();
                    r8 = remoteSettings$updateSettings$1.label;
                    if (r8 != 0) {
                        ResultKt.b(obj);
                        if (!this.f.d() && !f().d()) {
                            return Unit.a;
                        }
                        kotlinx.coroutines.sync.a aVar3 = this.f;
                        remoteSettings$updateSettings$1.L$0 = this;
                        remoteSettings$updateSettings$1.L$1 = aVar3;
                        remoteSettings$updateSettings$1.label = 1;
                        if (aVar3.f((Object) null, remoteSettings$updateSettings$1) == f) {
                            return f;
                        }
                        aVar2 = aVar3;
                        remoteSettings = this;
                    } else {
                        if (r8 != 1) {
                            if (r8 != 2) {
                                if (r8 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                aVar = (kotlinx.coroutines.sync.a) remoteSettings$updateSettings$1.L$0;
                                try {
                                    ResultKt.b(obj);
                                    Unit unit = Unit.a;
                                    aVar.unlock((Object) null);
                                    return Unit.a;
                                } catch (Throwable th) {
                                    th = th;
                                    aVar.unlock((Object) null);
                                    throw th;
                                }
                            }
                            aVar2 = (kotlinx.coroutines.sync.a) remoteSettings$updateSettings$1.L$1;
                            remoteSettings = (RemoteSettings) remoteSettings$updateSettings$1.L$0;
                            ResultKt.b(obj);
                            b = ((InstallationId) obj).b();
                            if (!Intrinsics.c(b, TtmlNode.ANONYMOUS_REGION_ID)) {
                                Log.w("SessionConfigFetcher", "Error getting Firebase Installation ID. Skipping this Session Event.");
                                Unit unit2 = Unit.a;
                                aVar2.unlock((Object) null);
                                return unit2;
                            }
                            Pair a2 = TuplesKt.a("X-Crashlytics-Installation-ID", b);
                            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                            String format = String.format("%s/%s", Arrays.copyOf(new Object[]{Build.MANUFACTURER, Build.MODEL}, 2));
                            Intrinsics.g(format, "format(format, *args)");
                            Pair a3 = TuplesKt.a("X-Crashlytics-Device-Model", remoteSettings.g(format));
                            String str = Build.VERSION.INCREMENTAL;
                            Intrinsics.g(str, "INCREMENTAL");
                            Pair a4 = TuplesKt.a("X-Crashlytics-OS-Build-Version", remoteSettings.g(str));
                            String str2 = Build.VERSION.RELEASE;
                            Intrinsics.g(str2, "RELEASE");
                            Map l = MapsKt.l(new Pair[]{a2, a3, a4, TuplesKt.a("X-Crashlytics-OS-Display-Version", remoteSettings.g(str2)), TuplesKt.a("X-Crashlytics-API-Client-Version", remoteSettings.c.f())});
                            com.google.firebase.sessions.settings.a aVar4 = remoteSettings.d;
                            RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(remoteSettings, null);
                            RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(null);
                            remoteSettings$updateSettings$1.L$0 = aVar2;
                            remoteSettings$updateSettings$1.L$1 = null;
                            remoteSettings$updateSettings$1.label = 3;
                            if (aVar4.a(l, remoteSettings$updateSettings$2$1, remoteSettings$updateSettings$2$2, remoteSettings$updateSettings$1) == f) {
                                return f;
                            }
                            aVar = aVar2;
                            Unit unit3 = Unit.a;
                            aVar.unlock((Object) null);
                            return Unit.a;
                        }
                        aVar2 = (kotlinx.coroutines.sync.a) remoteSettings$updateSettings$1.L$1;
                        remoteSettings = (RemoteSettings) remoteSettings$updateSettings$1.L$0;
                        ResultKt.b(obj);
                    }
                    if (remoteSettings.f().d()) {
                        Unit unit4 = Unit.a;
                        aVar2.unlock((Object) null);
                        return unit4;
                    }
                    InstallationId.Companion companion = InstallationId.c;
                    e eVar = remoteSettings.b;
                    remoteSettings$updateSettings$1.L$0 = remoteSettings;
                    remoteSettings$updateSettings$1.L$1 = aVar2;
                    remoteSettings$updateSettings$1.label = 2;
                    obj = companion.a(eVar, remoteSettings$updateSettings$1);
                    if (obj == f) {
                        return f;
                    }
                    b = ((InstallationId) obj).b();
                    if (!Intrinsics.c(b, TtmlNode.ANONYMOUS_REGION_ID)) {
                    }
                }
            }
            if (r8 != 0) {
            }
            if (remoteSettings.f().d()) {
            }
        } catch (Throwable th2) {
            th = th2;
            aVar = r8;
        }
        remoteSettings$updateSettings$1 = new RemoteSettings$updateSettings$1(this, continuation);
        Object obj2 = remoteSettings$updateSettings$1.result;
        Object f2 = IntrinsicsKt.f();
        r8 = remoteSettings$updateSettings$1.label;
    }
}
