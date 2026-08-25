package com.google.firebase.sessions;

import com.google.android.gms.tasks.Task;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class InstallationId {
    public static final Companion c = new Companion(null);
    private final String a;
    private final String b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|(2:3|(12:5|6|7|(1:(1:(6:11|12|13|14|15|16)(2:19|20))(2:21|22))(3:29|30|(1:32))|23|24|25|(1:27)|13|14|15|16))|37|6|7|(0)(0)|23|24|25|(0)|13|14|15|16) */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0046, code lost:
        
            r10 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x006f, code lost:
        
            android.util.Log.w("InstallationId", "Error getting authentication token.", r10);
            r10 = r9;
            r9 = com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode.ANONYMOUS_REGION_ID;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0034, code lost:
        
            r10 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0093, code lost:
        
            android.util.Log.w("InstallationId", "Error getting Firebase installation id .", r10);
            r9 = r9;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0089 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
        /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v16 */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v8 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object a(lc.e eVar, Continuation continuation) {
            InstallationId$Companion$create$1 installationId$Companion$create$1;
            Object obj;
            Object f;
            int i;
            if (continuation instanceof InstallationId$Companion$create$1) {
                installationId$Companion$create$1 = (InstallationId$Companion$create$1) continuation;
                int i2 = installationId$Companion$create$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    installationId$Companion$create$1.label = i2 - Integer.MIN_VALUE;
                    obj = installationId$Companion$create$1.result;
                    f = IntrinsicsKt.f();
                    i = installationId$Companion$create$1.label;
                    String str = TtmlNode.ANONYMOUS_REGION_ID;
                    if (i != 0) {
                        ResultKt.b(obj);
                        Task a = eVar.a(false);
                        Intrinsics.g(a, "firebaseInstallations.getToken(false)");
                        installationId$Companion$create$1.L$0 = eVar;
                        installationId$Companion$create$1.label = 1;
                        obj = qy.b.a(a, installationId$Companion$create$1);
                        eVar = eVar;
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ?? r9 = (String) installationId$Companion$create$1.L$0;
                            ResultKt.b(obj);
                            eVar = r9;
                            Intrinsics.g(obj, "{\n          firebaseInst…ions.id.await()\n        }");
                            str = (String) obj;
                            ?? r92 = eVar;
                            return new InstallationId(str, r92, null);
                        }
                        lc.e eVar2 = (lc.e) installationId$Companion$create$1.L$0;
                        ResultKt.b(obj);
                        eVar = eVar2;
                    }
                    String b = ((com.google.firebase.installations.f) obj).b();
                    Intrinsics.g(b, "{\n          firebaseInst…).await().token\n        }");
                    lc.e eVar3 = eVar;
                    ?? r93 = b;
                    Task id2 = eVar3.getId();
                    Intrinsics.g(id2, "firebaseInstallations.id");
                    installationId$Companion$create$1.L$0 = r93;
                    installationId$Companion$create$1.label = 2;
                    obj = qy.b.a(id2, installationId$Companion$create$1);
                    eVar = r93;
                    if (obj == f) {
                        return f;
                    }
                    Intrinsics.g(obj, "{\n          firebaseInst…ions.id.await()\n        }");
                    str = (String) obj;
                    ?? r922 = eVar;
                    return new InstallationId(str, r922, null);
                }
            }
            installationId$Companion$create$1 = new InstallationId$Companion$create$1(this, continuation);
            obj = installationId$Companion$create$1.result;
            f = IntrinsicsKt.f();
            i = installationId$Companion$create$1.label;
            String str2 = TtmlNode.ANONYMOUS_REGION_ID;
            if (i != 0) {
            }
            String b2 = ((com.google.firebase.installations.f) obj).b();
            Intrinsics.g(b2, "{\n          firebaseInst…).await().token\n        }");
            lc.e eVar32 = eVar;
            ?? r932 = b2;
            Task id22 = eVar32.getId();
            Intrinsics.g(id22, "firebaseInstallations.id");
            installationId$Companion$create$1.L$0 = r932;
            installationId$Companion$create$1.label = 2;
            obj = qy.b.a(id22, installationId$Companion$create$1);
            eVar = r932;
            if (obj == f) {
            }
            Intrinsics.g(obj, "{\n          firebaseInst…ions.id.await()\n        }");
            str2 = (String) obj;
            ?? r9222 = eVar;
            return new InstallationId(str2, r9222, null);
        }
    }

    private InstallationId(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public /* synthetic */ InstallationId(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }
}
