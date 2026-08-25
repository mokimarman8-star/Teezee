package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import qb.a;
import qb.h;
import tb.e;
import tb.o;
import ub.e;
import xb.g;
import yb.b;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class n {
    static final FilenameFilter t = new FilenameFilter() { // from class: com.google.firebase.crashlytics.internal.common.m
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean M;
            M = n.M(file, str);
            return M;
        }
    };
    private final Context a;
    private final d0 b;
    private final y c;
    private final o d;
    private final CrashlyticsWorkers e;
    private final g0 f;
    private final g g;
    private final a h;
    private final e i;
    private final a j;
    private final rb.a k;
    private final k l;
    private final w0 m;
    private b0 n;
    private b o = null;
    final TaskCompletionSource p = new TaskCompletionSource();
    final TaskCompletionSource q = new TaskCompletionSource();
    final TaskCompletionSource r = new TaskCompletionSource();
    final AtomicBoolean s = new AtomicBoolean(false);

    n(Context context, g0 g0Var, d0 d0Var, g gVar, y yVar, a aVar, o oVar, e eVar, w0 w0Var, a aVar2, rb.a aVar3, k kVar, CrashlyticsWorkers crashlyticsWorkers) {
        this.a = context;
        this.f = g0Var;
        this.b = d0Var;
        this.g = gVar;
        this.c = yVar;
        this.h = aVar;
        this.d = oVar;
        this.i = eVar;
        this.j = aVar2;
        this.k = aVar3;
        this.l = kVar;
        this.m = w0Var;
        this.e = crashlyticsWorkers;
    }

    private static boolean B() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String C() {
        SortedSet r = this.m.r();
        if (r.isEmpty()) {
            return null;
        }
        return (String) r.first();
    }

    private static long D() {
        return G(System.currentTimeMillis());
    }

    static List E(h hVar, String str, g gVar, byte[] bArr) {
        File q = gVar.q(str, "user-data");
        File q2 = gVar.q(str, "keys");
        File q3 = gVar.q(str, "rollouts-state");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f("logs_file", "logs", bArr));
        arrayList.add(new e0("crash_meta_file", "metadata", hVar.d()));
        arrayList.add(new e0("session_meta_file", "session", hVar.g()));
        arrayList.add(new e0("app_meta_file", "app", hVar.e()));
        arrayList.add(new e0("device_meta_file", "device", hVar.a()));
        arrayList.add(new e0("os_meta_file", "os", hVar.f()));
        arrayList.add(R(hVar));
        arrayList.add(new e0("user_meta_file", "user", q));
        arrayList.add(new e0("keys_file", "keys", q2));
        arrayList.add(new e0("rollouts_file", "rollouts", q3));
        return arrayList;
    }

    private InputStream F(String str) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            qb.g.f().k("Couldn't get Class Loader");
            return null;
        }
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        qb.g.f().g("No version control information found");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long G(long j) {
        return j / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(String str) {
        w(str, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean M(File file, String str) {
        return str.startsWith(".ae");
    }

    private Task O(long j) {
        if (B()) {
            qb.g.f().k("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.forResult((Object) null);
        }
        qb.g.f().b("Logging app exception event to Firebase Analytics");
        return Tasks.call(new ScheduledThreadPoolExecutor(1), new e(this, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task P() {
        ArrayList arrayList = new ArrayList();
        for (File file : N()) {
            try {
                arrayList.add(O(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                qb.g.f().k("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.whenAll(arrayList);
    }

    private static boolean Q(String str, File file, CrashlyticsReport.a aVar) {
        if (file == null || !file.exists()) {
            qb.g.f().k("No minidump data found for session " + str);
        }
        if (aVar == null) {
            qb.g.f().g("No Tombstones data found for session " + str);
        }
        return (file == null || !file.exists()) && aVar == null;
    }

    private static j0 R(h hVar) {
        File c = hVar.c();
        return (c == null || !c.exists()) ? new f("minidump_file", "minidump", new byte[]{0}) : new e0("minidump_file", "minidump", c);
    }

    private static byte[] T(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private Task a0() {
        if (this.b.d()) {
            qb.g.f().b("Automatic data collection is enabled. Allowing upload.");
            this.p.trySetResult(Boolean.FALSE);
            return Tasks.forResult(Boolean.TRUE);
        }
        qb.g.f().b("Automatic data collection is disabled.");
        qb.g.f().i("Notifying that unsent reports are available.");
        this.p.trySetResult(Boolean.TRUE);
        Task onSuccessTask = this.b.j().onSuccessTask(new c(this));
        qb.g.f().b("Waiting for send/deleteUnsentReports to be called.");
        return com.google.firebase.crashlytics.internal.concurrency.b.c(onSuccessTask, this.q.getTask());
    }

    private void b0(String str) {
        List historicalProcessExitReasons;
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            qb.g.f().i("ANR feature enabled, but device is API " + i);
            return;
        }
        historicalProcessExitReasons = ((ActivityManager) this.a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
        if (historicalProcessExitReasons.size() != 0) {
            this.m.x(str, historicalProcessExitReasons, new e(this.g, str), o.m(str, this.g, this.e));
        } else {
            qb.g.f().i("No ApplicationExitInfo available. Session: " + str);
        }
    }

    private static e.a o(g0 g0Var, a aVar) {
        return e.a.b(g0Var.f(), aVar.f, aVar.g, g0Var.a().c(), DeliveryMechanism.determineFrom(aVar.d).getId(), aVar.h);
    }

    private static e.b p(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return e.b.c(CommonUtils.k(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.b(context), statFs.getBlockCount() * statFs.getBlockSize(), CommonUtils.w(), CommonUtils.l(), Build.MANUFACTURER, Build.PRODUCT);
    }

    private static e.c q() {
        return e.c.a(Build.VERSION.RELEASE, Build.VERSION.CODENAME, CommonUtils.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v(boolean z, b bVar, boolean z2) {
        String str;
        CrashlyticsWorkers.c();
        ArrayList arrayList = new ArrayList(this.m.r());
        if (arrayList.size() <= z) {
            qb.g.f().i("No open sessions to be closed.");
            return;
        }
        String str2 = (String) arrayList.get(z ? 1 : 0);
        if (z2 && bVar.b().b.b) {
            b0(str2);
        } else {
            qb.g.f().i("ANR feature disabled.");
        }
        if (z2 && this.j.d(str2)) {
            z(str2);
        }
        if (z != 0) {
            str = (String) arrayList.get(0);
        } else {
            this.l.e((String) null);
            str = null;
        }
        this.m.l(D(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, Boolean bool) {
        long D = D();
        qb.g.f().b("Opening a new session with ID " + str);
        this.j.c(str, String.format(Locale.US, "Crashlytics Android SDK/%s", x.q()), D, ub.e.b(o(this.f, this.h), q(), p(this.a)));
        if (bool.booleanValue() && str != null) {
            this.d.r(str);
        }
        this.i.e(str);
        this.l.e(str);
        this.m.s(str, D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(long j) {
        try {
            if (this.g.g(".ae" + j).createNewFile()) {
            } else {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e) {
            qb.g.f().l("Could not create app exception marker file.", e);
        }
    }

    private void z(String str) {
        qb.g.f().i("Finalizing native report for session " + str);
        h a = this.j.a(str);
        File c = a.c();
        CrashlyticsReport.a b = a.b();
        if (Q(str, c, b)) {
            qb.g.f().k("No native core present");
            return;
        }
        long lastModified = c.lastModified();
        tb.e eVar = new tb.e(this.g, str);
        File k = this.g.k(str);
        if (!k.isDirectory()) {
            qb.g.f().k("Couldn't create directory to store native session files, aborting.");
            return;
        }
        x(lastModified);
        List E = E(a, str, this.g, eVar.b());
        k0.b(k, E);
        qb.g.f().b("CrashlyticsController#finalizePreviousNativeSession");
        this.m.k(str, E, b);
        eVar.a();
    }

    boolean A(b bVar) {
        CrashlyticsWorkers.c();
        if (K()) {
            qb.g.f().k("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        qb.g.f().i("Finalizing previously open sessions.");
        try {
            v(true, bVar, true);
            qb.g.f().i("Closed all previously open sessions.");
            return true;
        } catch (Exception e) {
            qb.g.f().e("Unable to finalize previously open sessions.", e);
            return false;
        }
    }

    String H() {
        InputStream F = F("META-INF/version-control-info.textproto");
        if (F == null) {
            return null;
        }
        qb.g.f().b("Read version control info");
        return Base64.encodeToString(T(F), 0);
    }

    void I(b bVar, Thread thread, Throwable th) {
        J(bVar, thread, th, false);
    }

    synchronized void J(b bVar, Thread thread, Throwable th, boolean z) {
        qb.g.f().b("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        Task g = this.e.a.g(new b(this, System.currentTimeMillis(), th, thread, bVar, z));
        if (!z) {
            try {
                try {
                    z0.b(g);
                } catch (TimeoutException unused) {
                    qb.g.f().d("Cannot send reports. Timed out while fetching settings.");
                }
            } catch (Exception e) {
                qb.g.f().e("Error handling uncaught exception", e);
            }
        }
    }

    boolean K() {
        b0 b0Var = this.n;
        return b0Var != null && b0Var.a();
    }

    List N() {
        return this.g.h(t);
    }

    void S(String str) {
        this.e.a.f(new l(this, str));
    }

    void U() {
        try {
            String H = H();
            if (H != null) {
                X("com.crashlytics.version-control-info", H);
                qb.g.f().g("Saved version control info");
            }
        } catch (IOException e) {
            qb.g.f().l("Unable to save version control info", e);
        }
    }

    Task V() {
        this.q.trySetResult(Boolean.TRUE);
        return this.r.getTask();
    }

    void W(String str, String str2) {
        try {
            this.d.p(str, str2);
        } catch (IllegalArgumentException e) {
            Context context = this.a;
            if (context != null && CommonUtils.u(context)) {
                throw e;
            }
            qb.g.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    void X(String str, String str2) {
        try {
            this.d.q(str, str2);
        } catch (IllegalArgumentException e) {
            Context context = this.a;
            if (context != null && CommonUtils.u(context)) {
                throw e;
            }
            qb.g.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    void Y(String str) {
        this.d.s(str);
    }

    void Z(Task task) {
        if (this.m.o()) {
            qb.g.f().i("Crash reports are available to be sent.");
            a0().onSuccessTask(this.e.a, new d(this, task));
        } else {
            qb.g.f().i("No crash reports are available to be sent.");
            this.p.trySetResult(Boolean.FALSE);
        }
    }

    void c0(Thread thread, Throwable th) {
        long currentTimeMillis = System.currentTimeMillis();
        if (K()) {
            return;
        }
        long G = G(currentTimeMillis);
        String C = C();
        if (C == null) {
            qb.g.f().k("Tried to write a non-fatal exception while no session was open.");
        } else {
            this.m.w(th, thread, C, G);
        }
    }

    void d0(long j, String str) {
        if (K()) {
            return;
        }
        this.i.g(j, str);
    }

    Task n() {
        if (this.s.compareAndSet(false, true)) {
            return this.p.getTask();
        }
        qb.g.f().k("checkForUnsentReports should only be called once per execution.");
        return Tasks.forResult(Boolean.FALSE);
    }

    Task s() {
        this.q.trySetResult(Boolean.FALSE);
        return this.r.getTask();
    }

    boolean t() {
        CrashlyticsWorkers.c();
        if (!this.c.c()) {
            String C = C();
            return C != null && this.j.d(C);
        }
        qb.g.f().i("Found previous crash marker.");
        this.c.d();
        return true;
    }

    void u(b bVar) {
        v(false, bVar, false);
    }

    void y(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, b bVar) {
        this.o = bVar;
        S(str);
        b0 b0Var = new b0(new a(this), bVar, uncaughtExceptionHandler, this.j);
        this.n = b0Var;
        Thread.setDefaultUncaughtExceptionHandler(b0Var);
    }
}
