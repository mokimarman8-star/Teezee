package com.google.firebase.crashlytics.internal.concurrency;

import android.os.Looper;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import qb.g;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class CrashlyticsWorkers {
    public static final Companion e = new Companion(null);
    private static boolean f;
    public final e a;
    public final e b;
    public final e c;
    public final e d;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void h(Function0 function0, Function0 function02) {
            if (((Boolean) function0.invoke()).booleanValue()) {
                return;
            }
            g.f().b((String) function02.invoke());
            i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String j() {
            return Thread.currentThread().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean k() {
            String j = j();
            Intrinsics.g(j, "threadName");
            return StringsKt.c0(j, "Firebase Background Thread #", false, 2, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean l() {
            String j = j();
            Intrinsics.g(j, "threadName");
            return StringsKt.c0(j, "Firebase Blocking Thread #", false, 2, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean m() {
            return !Looper.getMainLooper().isCurrentThread();
        }

        public final void e() {
            h(new CrashlyticsWorkers$Companion$checkBackgroundThread$1(this), new Function0<String>() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers$Companion$checkBackgroundThread$2
                public final String invoke() {
                    String j;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Must be called on a background thread, was called on ");
                    j = CrashlyticsWorkers.e.j();
                    sb2.append(j);
                    sb2.append('.');
                    return sb2.toString();
                }
            });
        }

        public final void f() {
            h(new CrashlyticsWorkers$Companion$checkBlockingThread$1(this), new Function0<String>() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers$Companion$checkBlockingThread$2
                public final String invoke() {
                    String j;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Must be called on a blocking thread, was called on ");
                    j = CrashlyticsWorkers.e.j();
                    sb2.append(j);
                    sb2.append('.');
                    return sb2.toString();
                }
            });
        }

        public final void g() {
            h(new CrashlyticsWorkers$Companion$checkNotMainThread$1(this), new Function0<String>() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers$Companion$checkNotMainThread$2
                public final String invoke() {
                    String j;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Must not be called on a main thread, was called on ");
                    j = CrashlyticsWorkers.e.j();
                    sb2.append(j);
                    sb2.append('.');
                    return sb2.toString();
                }
            });
        }

        public final boolean i() {
            return CrashlyticsWorkers.f;
        }

        public final void n(boolean z) {
            CrashlyticsWorkers.f = z;
        }
    }

    public CrashlyticsWorkers(ExecutorService executorService, ExecutorService executorService2) {
        Intrinsics.h(executorService, "backgroundExecutorService");
        Intrinsics.h(executorService2, "blockingExecutorService");
        this.a = new e(executorService);
        this.b = new e(executorService);
        this.c = new e(executorService);
        this.d = new e(executorService2);
    }

    public static final void c() {
        e.e();
    }

    public static final void d() {
        e.f();
    }

    public static final void e() {
        e.g();
    }

    public static final void f(boolean z) {
        e.n(z);
    }
}
