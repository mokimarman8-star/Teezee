package com.transsion.ga;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.transsion.athena.athena;
import com.transsion.athena.data.TrackDataWrapper;
import com.transsion.athena.taaneh.aethna;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class g implements ServiceConnection {
    final /* synthetic */ AthenaAnalytics a;

    g(AthenaAnalytics athenaAnalytics) {
        this.a = athenaAnalytics;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            AthenaAnalytics.h(this.a, athena.AbstractBinderC0009athena.a(iBinder));
            AthenaAnalytics.q(this.a, true);
            aethna.c("AthenaTrackService onServiceConnected");
            Iterator it = AthenaAnalytics.j(this.a).iterator();
            while (it.hasNext()) {
                TrackDataWrapper trackDataWrapper = (TrackDataWrapper) it.next();
                if (trackDataWrapper.c().c() < 524288) {
                    AthenaAnalytics.o(this.a, trackDataWrapper.a(), trackDataWrapper.c(), trackDataWrapper.b());
                } else {
                    aethna.b("TrackData size is too large, ignored !!");
                }
            }
            AthenaAnalytics.j(this.a).clear();
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        AthenaAnalytics.q(this.a, false);
        aethna.c("AthenaTrackService onServiceDisconnected");
    }
}
