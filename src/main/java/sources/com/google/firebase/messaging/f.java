package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.d;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class f {
    private final ExecutorService a;
    private final Context b;
    private final k0 c;

    public f(Context context, k0 k0Var, ExecutorService executorService) {
        this.a = executorService;
        this.b = context;
        this.c = k0Var;
    }

    private boolean b() {
        if (((KeyguardManager) this.b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!PlatformVersion.isAtLeastLollipop()) {
            SystemClock.sleep(10L);
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    private void c(d.a aVar) {
        Log.isLoggable("FirebaseMessaging", 3);
        ((NotificationManager) this.b.getSystemService("notification")).notify(aVar.b, aVar.c, aVar.a.c());
    }

    private g0 d() {
        g0 j = g0.j(this.c.p("gcm.n.image"));
        if (j != null) {
            j.m(this.a);
        }
        return j;
    }

    private void e(NotificationCompat.m mVar, g0 g0Var) {
        if (g0Var == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) Tasks.await(g0Var.k(), 5L, TimeUnit.SECONDS);
            mVar.A(bitmap);
            mVar.L(new NotificationCompat.j().r(bitmap).q((Bitmap) null));
        } catch (InterruptedException unused) {
            Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
            g0Var.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            Log.w("FirebaseMessaging", "Failed to download image: " + e.getCause());
        } catch (TimeoutException unused2) {
            Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
            g0Var.close();
        }
    }

    boolean a() {
        if (this.c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        g0 d = d();
        d.a e = d.e(this.b, this.c);
        e(e.a, d);
        c(e);
        return true;
    }
}
