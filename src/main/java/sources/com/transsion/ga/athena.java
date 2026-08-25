package com.transsion.ga;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.taaneh.aethna;
import com.transsion.athena.taaneh.anehat;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.UUID;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class athena implements Application.ActivityLifecycleCallbacks {
    private int b;
    private Runnable d;
    private long h;
    private long k;
    private final Handler a = new Handler(Looper.getMainLooper());
    private boolean c = true;
    private long e = 0;
    private int f = 0;
    private String g = null;
    private int i = 0;
    private final LinkedList j = new LinkedList();

    private static class a {
        int a;
        String b;
        long c;

        a(int i, String str, long j) {
            this.a = i;
            this.b = str;
            this.c = j;
        }
    }

    /* renamed from: com.transsion.ga.athena$athena, reason: collision with other inner class name */
    class RunnableC0026athena implements Runnable {
        RunnableC0026athena() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                athena.this.i = 0;
                athena.this.j.clear();
                athena.this.c = true;
                athena.this.e = 0L;
                ehanat.d(BuildConfig.FLAVOR);
            } catch (Exception unused) {
            }
        }
    }

    private boolean e(Activity activity) {
        Window window;
        if (activity == null || AthenaAnalytics.r(activity.getClass()) || (window = activity.getWindow()) == null) {
            return false;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        return (attributes.width == 1 && attributes.height == 1) ? false : true;
    }

    void d(long j) {
        this.k = j;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        com.transsion.athena.taaneh.athena.b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        com.transsion.athena.taaneh.athena.a();
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
        String valueOf;
        if (e(activity)) {
            try {
                String simpleName = activity.getClass().getSimpleName();
                int i = 1;
                if (ehanat.s()) {
                    int i2 = this.i + 1;
                    this.i = i2;
                    this.j.addLast(new a(i2, simpleName, SystemClock.elapsedRealtime()));
                }
                int i3 = this.b + 1;
                this.b = i3;
                if (i3 <= 1) {
                    this.h = SystemClock.elapsedRealtime();
                    if (this.c) {
                        try {
                            valueOf = UUID.randomUUID().toString();
                        } catch (Exception unused) {
                            valueOf = String.valueOf(System.currentTimeMillis());
                        }
                        ehanat.d(valueOf);
                        this.e = System.currentTimeMillis();
                        try {
                            Uri referrer = activity.getReferrer();
                            if (referrer != null) {
                                this.g = referrer.getAuthority();
                            }
                            Intent intent = activity.getIntent();
                            String str = this.g;
                            int i4 = anehat.e;
                            if (intent != null) {
                                Set<String> categories = intent.getCategories();
                                if (!"android.intent.action.MAIN".equals(intent.getAction()) || categories == null || !categories.contains("android.intent.category.LAUNCHER")) {
                                    i = TextUtils.isEmpty(str) ? 0 : 2;
                                }
                            }
                            this.f = i;
                            if (TextUtils.equals(this.g, activity.getPackageName())) {
                                this.f = 3;
                            }
                        } catch (Exception e) {
                            aethna.b(Log.getStackTraceString(e));
                        }
                        Iterator<Integer> it = com.transsion.athena.data.athena.a().iterator();
                        while (it.hasNext()) {
                            Integer next = it.next();
                            if (next.intValue() != 9999) {
                                AthenaAnalytics.K(next.intValue()).g0("page_enter", new TrackData().add("purl", simpleName), next.intValue());
                            }
                        }
                    }
                }
                this.c = false;
                Runnable runnable = this.d;
                if (runnable != null) {
                    this.a.removeCallbacks(runnable);
                    this.d = null;
                }
            } catch (Exception e2) {
                aethna.b(Log.getStackTraceString(e2));
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Bundle bundleExtra;
        if (e(activity)) {
            try {
                if (ehanat.s() && this.j.size() > 0) {
                    String simpleName = activity.getClass().getSimpleName();
                    Iterator it = this.j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a aVar = (a) it.next();
                        if (simpleName.equals(aVar.b)) {
                            long elapsedRealtime = SystemClock.elapsedRealtime() - aVar.c;
                            TrackData add = new TrackData().add("s_id", ehanat.m()).add("url", aVar.b).add("no", aVar.a);
                            if (elapsedRealtime <= 0) {
                                elapsedRealtime = 0;
                            }
                            TrackData add2 = add.add("t", elapsedRealtime).add("ext", BuildConfig.FLAVOR);
                            if (activity.getIntent() != null && (bundleExtra = activity.getIntent().getBundleExtra("athena")) != null) {
                                add2.add("ext", bundleExtra);
                            }
                            AthenaAnalytics.L(this.k).h0("page_view", add2, this.k);
                            this.j.remove(aVar);
                        }
                    }
                }
                int i = this.b - 1;
                this.b = i;
                if (i == 0) {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - this.h;
                    if (elapsedRealtime2 > 1000 && elapsedRealtime2 < 86400000) {
                        Iterator<Integer> it2 = com.transsion.athena.data.athena.a().iterator();
                        while (it2.hasNext()) {
                            Integer next = it2.next();
                            if (next.intValue() != 9999) {
                                AthenaAnalytics.K(next.intValue()).g0("app_active", new TrackData().add("s_id", ehanat.m()).add("s_t", this.f).add(PushConstants.PROVIDER_FIELD_PKG, this.f == 2 ? this.g : BuildConfig.FLAVOR).add("s_s", this.e).add("t", elapsedRealtime2), next.intValue());
                            }
                        }
                    }
                    Runnable runnable = this.d;
                    if (runnable != null) {
                        this.a.removeCallbacks(runnable);
                    }
                    Handler handler = this.a;
                    RunnableC0026athena runnableC0026athena = new RunnableC0026athena();
                    this.d = runnableC0026athena;
                    handler.postDelayed(runnableC0026athena, ehanat.n());
                    AthenaAnalytics.X();
                }
            } catch (Exception e) {
                aethna.b(Log.getStackTraceString(e));
            }
        }
    }
}
