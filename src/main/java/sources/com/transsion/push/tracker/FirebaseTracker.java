package com.transsion.push.tracker;

import android.os.Bundle;
import com.transsion.push.tracker.Tracker;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class FirebaseTracker {
    private static FirebaseTracker a;
    private static ITracker b;

    private FirebaseTracker() {
    }

    public static FirebaseTracker getInstance() {
        if (a == null) {
            a = new FirebaseTracker();
        }
        return a;
    }

    void a(Tracker.KEY key, Bundle bundle) {
        ITracker iTracker;
        if (bundle == null || (iTracker = b) == null) {
            return;
        }
        iTracker.track(key, bundle);
    }

    public void setListener(ITracker iTracker) {
        b = iTracker;
    }
}
