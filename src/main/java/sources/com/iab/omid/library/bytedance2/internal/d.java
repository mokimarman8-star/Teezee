package com.iab.omid.library.bytedance2.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class d implements Application.ActivityLifecycleCallbacks {
    private boolean a;
    protected boolean b;
    private a c;

    public interface a {
        void a(boolean z);
    }

    private void a(boolean z) {
        if (this.b != z) {
            this.b = z;
            if (this.a) {
                b(z);
                a aVar = this.c;
                if (aVar != null) {
                    aVar.a(z);
                }
            }
        }
    }

    private boolean a() {
        return b().importance == 100 || d();
    }

    public void a(@NonNull Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    ActivityManager.RunningAppProcessInfo b() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    protected void b(boolean z) {
    }

    public boolean c() {
        return this.b;
    }

    protected boolean d() {
        return false;
    }

    public void e() {
        this.a = true;
        boolean a2 = a();
        this.b = a2;
        b(a2);
    }

    public void f() {
        this.a = false;
        this.c = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        a(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        a(a());
    }
}
