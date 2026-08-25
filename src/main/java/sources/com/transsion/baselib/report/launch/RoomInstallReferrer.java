package com.transsion.baselib.report.launch;

import android.app.Application;
import com.transsion.ga.AthenaAnalytics;
import i5.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class RoomInstallReferrer {
    public static final RoomInstallReferrer a = new RoomInstallReferrer();
    private static i5.a b;
    private static a c;

    private RoomInstallReferrer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Application application, d dVar) {
        String d = dVar.d();
        a.a.f(wf.a.a, "RoomInstallReferrer", "fetchInstallReferrer referrerUrl: " + d, false, 4, (Object) null);
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new RoomInstallReferrer$fetchInstallReferrer$1(application, d, dVar, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Application application, String str) {
        a.a.f(wf.a.a, "RoomInstallReferrer", "fetchInstallReferrerErr msg: " + str, false, 4, (Object) null);
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new fetchInstallReferrerErr.1(application, (Continuation) null), 3, (Object) null);
    }

    private final void j(c cVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00af A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(kotlin.coroutines.Continuation r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.transsion.baselib.report.launch.RoomInstallReferrer.waitForPsReferrerResult.1
            if (r0 == 0) goto L13
            r0 = r12
            com.transsion.baselib.report.launch.RoomInstallReferrer$waitForPsReferrerResult$1 r0 = (com.transsion.baselib.report.launch.RoomInstallReferrer.waitForPsReferrerResult.1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.baselib.report.launch.RoomInstallReferrer$waitForPsReferrerResult$1 r0 = new com.transsion.baselib.report.launch.RoomInstallReferrer$waitForPsReferrerResult$1
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            long r5 = r0.J$0
            kotlin.ResultKt.b(r12)
            goto L53
        L2c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L34:
            kotlin.ResultKt.b(r12)
            long r5 = java.lang.System.currentTimeMillis()
            com.transsion.baselib.report.launch.b r12 = com.transsion.baselib.report.launch.b.a
            com.tencent.mmkv.MMKV r12 = r12.b()
            java.lang.String r2 = "k_install_referrer"
            java.lang.String r12 = r12.getString(r2, r3)
            if (r12 == 0) goto L53
            int r12 = r12.length()
            if (r12 != 0) goto L50
            goto L53
        L50:
            kotlin.Unit r12 = kotlin.Unit.a
            return r12
        L53:
            android.app.Application r12 = com.blankj.utilcode.util.Utils.a()
            com.transsion.athena.attribution.SpUtils r12 = com.transsion.athena.attribution.SpUtils.getInstance(r12)
            java.lang.String r2 = "key_referrer_palm_store"
            java.lang.String r12 = r12.getString(r2)
            java.lang.String r2 = "SnowballReferrer"
            if (r12 == 0) goto La4
            int r7 = r12.length()
            if (r7 != 0) goto L6c
            goto La4
        L6c:
            wf.a$a r0 = wf.a.a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "get referrer: "
            r1.append(r5)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r0.c(r2, r1, r4)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L99
            java.lang.Class<com.transsion.baselib.report.launch.c> r0 = com.transsion.baselib.report.launch.c.class
            java.lang.Object r12 = com.blankj.utilcode.util.o.d(r12, r0)     // Catch: java.lang.Throwable -> L99
            android.support.v4.media.session.c.a(r12)     // Catch: java.lang.Throwable -> L99
            kotlin.jvm.internal.Intrinsics.e(r3)     // Catch: java.lang.Throwable -> L99
            r11.j(r3)     // Catch: java.lang.Throwable -> L99
            kotlin.Unit r12 = kotlin.Unit.a     // Catch: java.lang.Throwable -> L99
            kotlin.Result.m34constructorimpl(r12)     // Catch: java.lang.Throwable -> L99
            goto Lb6
        L99:
            r12 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.a(r12)
            kotlin.Result.m34constructorimpl(r12)
            goto Lb6
        La4:
            long r7 = java.lang.System.currentTimeMillis()
            long r7 = r7 - r5
            r9 = 10000(0x2710, double:4.9407E-320)
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 <= 0) goto Lb9
            wf.a$a r12 = wf.a.a
            java.lang.String r0 = "wait referrer timeout"
            r12.w(r2, r0, r4)
        Lb6:
            kotlin.Unit r12 = kotlin.Unit.a
            return r12
        Lb9:
            r0.J$0 = r5
            r0.label = r4
            r7 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r12 = kotlinx.coroutines.u0.a(r7, r0)
            if (r12 != r1) goto L53
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.report.launch.RoomInstallReferrer.k(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void e(Application application, a aVar) {
        Intrinsics.h(application, "context");
        Intrinsics.h(aVar, "lis");
        i5.a aVar2 = null;
        String string = b.a.b().getString("k_install_referrer", null);
        if (string != null && string.length() != 0) {
            a.a.f(wf.a.a, "RoomInstallReferrer", "localReferrerUrl:" + string, false, 4, (Object) null);
            return;
        }
        c = aVar;
        try {
            i5.a a2 = i5.a.c(application).a();
            b = a2;
            if (a2 == null) {
                Intrinsics.y("referrerClient");
            } else {
                aVar2 = a2;
            }
            aVar2.d(new b(application));
        } catch (Exception unused) {
            h(application, "unknown err");
        }
    }

    public final Object f(n0 n0Var, Continuation continuation) {
        try {
            Result.Companion companion = Result.Companion;
            AthenaAnalytics.Y(2570);
            Result.m34constructorimpl(Unit.a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m34constructorimpl(ResultKt.a(th));
        }
        i.d(n0Var, (CoroutineContext) null, (CoroutineStart) null, new checkSnowballInstallReferrer.3((Continuation) null), 3, (Object) null);
        return Unit.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0044, code lost:
    
        if (r3 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(android.app.Application r8, java.lang.String r9, i5.d r10) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            java.lang.String r0 = "referrer"
            kotlin.jvm.internal.Intrinsics.h(r9, r0)
            com.transsion.baselib.report.launch.b r0 = com.transsion.baselib.report.launch.b.a     // Catch: java.lang.Exception -> L40
            com.tencent.mmkv.MMKV r0 = r0.b()     // Catch: java.lang.Exception -> L40
            java.lang.String r1 = "k_install_referrer"
            r0.putString(r1, r9)     // Catch: java.lang.Exception -> L40
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Exception -> L40
            r0.<init>()     // Catch: java.lang.Exception -> L40
            android.content.pm.PackageManager r1 = r8.getPackageManager()     // Catch: java.lang.Exception -> L40
            java.lang.String r2 = r8.getPackageName()     // Catch: java.lang.Exception -> L40
            r3 = 0
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r3)     // Catch: java.lang.Exception -> L40
            com.transsion.baselib.helper.b r2 = com.transsion.baselib.helper.b.a     // Catch: java.lang.Exception -> L40
            com.transsion.baselib.helper.ReferrerBean r2 = r2.d(r9)     // Catch: java.lang.Exception -> L40
            java.lang.String r3 = r2.getUtmSource()     // Catch: java.lang.Exception -> L40
            if (r3 == 0) goto L46
            int r4 = r3.length()     // Catch: java.lang.Exception -> L40
            if (r4 != 0) goto L44
            jg.b$a r3 = jg.b.a     // Catch: java.lang.Exception -> L40
            java.lang.String r3 = r3.e(r8)     // Catch: java.lang.Exception -> L40
            goto L44
        L40:
            r8 = move-exception
            r3 = r8
            goto Le5
        L44:
            if (r3 != 0) goto L4a
        L46:
            java.lang.String r3 = r2.getUtmSource()     // Catch: java.lang.Exception -> L40
        L4a:
            if (r3 == 0) goto L51
            mg.a$a r4 = mg.a.a     // Catch: java.lang.Exception -> L40
            r4.e(r3)     // Catch: java.lang.Exception -> L40
        L51:
            java.lang.String r3 = r2.getUtmCampaign()     // Catch: java.lang.Exception -> L40
            if (r3 == 0) goto L5c
            mg.a$a r4 = mg.a.a     // Catch: java.lang.Exception -> L40
            r4.g(r3)     // Catch: java.lang.Exception -> L40
        L5c:
            mg.a$a r3 = mg.a.a     // Catch: java.lang.Exception -> L40
            java.util.UUID r4 = java.util.UUID.randomUUID()     // Catch: java.lang.Exception -> L40
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L40
            java.lang.String r5 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.g(r4, r5)     // Catch: java.lang.Exception -> L40
            r3.f(r4)     // Catch: java.lang.Exception -> L40
            java.lang.String r3 = "install_time"
            long r4 = r1.lastUpdateTime     // Catch: java.lang.Exception -> L40
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Exception -> L40
            r0.put(r3, r4)     // Catch: java.lang.Exception -> L40
            java.lang.String r3 = "install_version"
            java.lang.String r1 = r1.versionName     // Catch: java.lang.Exception -> L40
            r0.put(r3, r1)     // Catch: java.lang.Exception -> L40
            java.lang.String r1 = "install_referrer"
            r0.put(r1, r9)     // Catch: java.lang.Exception -> L40
            java.lang.String r9 = "install_store"
            jg.b$a r1 = jg.b.a     // Catch: java.lang.Exception -> L40
            java.lang.String r8 = r1.e(r8)     // Catch: java.lang.Exception -> L40
            r0.put(r9, r8)     // Catch: java.lang.Exception -> L40
            if (r10 == 0) goto Ld3
            java.lang.String r8 = "referrer_click_timestamp_seconds"
            long r3 = r10.f()     // Catch: java.lang.Exception -> L40
            java.lang.String r9 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L40
            r0.put(r8, r9)     // Catch: java.lang.Exception -> L40
            java.lang.String r8 = "install_begin_timestamp_seconds"
            long r3 = r10.b()     // Catch: java.lang.Exception -> L40
            java.lang.String r9 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L40
            r0.put(r8, r9)     // Catch: java.lang.Exception -> L40
            java.lang.String r8 = "google_play_instant"
            boolean r9 = r10.a()     // Catch: java.lang.Exception -> L40
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Exception -> L40
            r0.put(r8, r9)     // Catch: java.lang.Exception -> L40
            java.lang.String r8 = "referrer_click_timestamp_server_seconds"
            long r3 = r10.g()     // Catch: java.lang.Exception -> L40
            java.lang.String r9 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L40
            r0.put(r8, r9)     // Catch: java.lang.Exception -> L40
            java.lang.String r8 = "install_begin_timestamp_server_seconds"
            long r9 = r10.g()     // Catch: java.lang.Exception -> L40
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Exception -> L40
            r0.put(r8, r9)     // Catch: java.lang.Exception -> L40
        Ld3:
            qi.h r8 = qi.h.a     // Catch: java.lang.Exception -> L40
            java.lang.String r9 = "app_install"
            r8.r(r9, r0)     // Catch: java.lang.Exception -> L40
            com.transsion.baselib.report.launch.RoomInstallReferrer$a r8 = com.transsion.baselib.report.launch.RoomInstallReferrer.c     // Catch: java.lang.Exception -> L40
            if (r8 == 0) goto Le1
            r8.a(r2)     // Catch: java.lang.Exception -> L40
        Le1:
            r8 = 0
            com.transsion.baselib.report.launch.RoomInstallReferrer.c = r8     // Catch: java.lang.Exception -> L40
            goto Lf2
        Le5:
            wf.a$a r0 = wf.a.a
            r5 = 8
            r6 = 0
            java.lang.String r1 = "RoomInstallReferrer"
            java.lang.String r2 = ""
            r4 = 0
            wf.a.a.e(r0, r1, r2, r3, r4, r5, r6)
        Lf2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.report.launch.RoomInstallReferrer.i(android.app.Application, java.lang.String, i5.d):void");
    }
}
