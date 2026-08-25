package com.google.firebase.perf.application;

import android.app.Activity;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.core.app.g;
import androidx.fragment.app.Fragment;
import com.google.firebase.perf.metrics.g;
import com.google.firebase.perf.util.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class d {
    private static final uc.a e = uc.a.e();
    private final Activity a;
    private final g b;
    private final Map c;
    private boolean d;

    public d(Activity activity) {
        this(activity, new g(), new HashMap());
    }

    d(Activity activity, g gVar, Map map) {
        this.d = false;
        this.a = activity;
        this.b = gVar;
        this.c = map;
    }

    static boolean a() {
        return true;
    }

    private e b() {
        if (!this.d) {
            e.a("No recording has been started.");
            return e.a();
        }
        SparseIntArray[] b = this.b.b();
        if (b == null) {
            e.a("FrameMetricsAggregator.mMetrics is uninitialized.");
            return e.a();
        }
        if (b[0] != null) {
            return e.e(com.google.firebase.perf.metrics.g.a(b));
        }
        e.a("FrameMetricsAggregator.mMetrics[TOTAL_INDEX] is uninitialized.");
        return e.a();
    }

    public void c() {
        if (this.d) {
            e.b("FrameMetricsAggregator is already recording %s", this.a.getClass().getSimpleName());
        } else {
            this.b.a(this.a);
            this.d = true;
        }
    }

    public void d(Fragment fragment) {
        if (!this.d) {
            e.a("Cannot start sub-recording because FrameMetricsAggregator is not recording");
            return;
        }
        if (this.c.containsKey(fragment)) {
            e.b("Cannot start sub-recording because one is already ongoing with the key %s", fragment.getClass().getSimpleName());
            return;
        }
        e b = b();
        if (b.d()) {
            this.c.put(fragment, (g.a) b.c());
        } else {
            e.b("startFragment(%s): snapshot() failed", fragment.getClass().getSimpleName());
        }
    }

    public e e() {
        if (!this.d) {
            e.a("Cannot stop because no recording was started");
            return e.a();
        }
        if (!this.c.isEmpty()) {
            e.a("Sub-recordings are still ongoing! Sub-recordings should be stopped first before stopping Activity screen trace.");
            this.c.clear();
        }
        e b = b();
        try {
            this.b.c(this.a);
        } catch (IllegalArgumentException | NullPointerException e2) {
            if ((e2 instanceof NullPointerException) && Build.VERSION.SDK_INT > 28) {
                throw e2;
            }
            e.k("View not hardware accelerated. Unable to collect FrameMetrics. %s", e2.toString());
            b = e.a();
        }
        this.b.d();
        this.d = false;
        return b;
    }

    public e f(Fragment fragment) {
        if (!this.d) {
            e.a("Cannot stop sub-recording because FrameMetricsAggregator is not recording");
            return e.a();
        }
        if (!this.c.containsKey(fragment)) {
            e.b("Sub-recording associated with key %s was not started or does not exist", fragment.getClass().getSimpleName());
            return e.a();
        }
        g.a aVar = (g.a) this.c.remove(fragment);
        e b = b();
        if (b.d()) {
            return e.e(((g.a) b.c()).a(aVar));
        }
        e.b("stopFragment(%s): snapshot() failed", fragment.getClass().getSimpleName());
        return e.a();
    }
}
