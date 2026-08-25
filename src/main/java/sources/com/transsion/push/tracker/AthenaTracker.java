package com.transsion.push.tracker;

import android.os.Bundle;
import com.transsion.athena.data.TrackData;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.push.PushManager;
import com.transsion.push.tracker.Tracker;
import com.transsion.push.utils.PushLogUtils;
import yj.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class AthenaTracker {
    private static AthenaTracker a;

    private AthenaTracker() {
    }

    private TrackData a(Bundle bundle) {
        TrackData trackData = new TrackData();
        if (bundle == null) {
            return trackData;
        }
        for (String str : bundle.keySet()) {
            trackData.add(str, bundle.get(str) + "");
        }
        return trackData;
    }

    private boolean c() {
        try {
            int i = AthenaAnalytics.p;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private void d(Tracker.KEY key, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            sb.append(str);
            sb.append(":");
            sb.append(bundle.get(str));
            sb.append(", ");
        }
        PushLogUtils.LOG.g("Athena track event:" + key.event + ", tid:" + key.tid + ", " + sb.toString());
    }

    public static AthenaTracker getInstance() {
        if (a == null) {
            a = new AthenaTracker();
        }
        return a;
    }

    void b() {
        if (c()) {
            AthenaAnalytics.P(a.a().getApplicationContext(), "push", 1041, false);
        }
    }

    void e(Tracker.KEY key, Bundle bundle) {
        if (c()) {
            if (!PushManager.getInstance().getIsSdkInitFinished()) {
                AthenaAnalytics.P(a.a().getApplicationContext(), "push", 1041, false);
            }
            try {
                d(key, bundle);
                AthenaAnalytics.K(key.tid).g0(key.event, a(bundle), key.tid);
            } catch (Exception unused) {
            }
        }
    }
}
