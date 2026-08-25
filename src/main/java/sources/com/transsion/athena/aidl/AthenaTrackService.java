package com.transsion.athena.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.transsion.athena.athena;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.taaneh.aethna;
import com.transsion.ga.AthenaAnalytics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class AthenaTrackService extends Service {
    private final athena.AbstractBinderC0009athena a = new athena(this);

    class athena extends athena.AbstractBinderC0009athena {
        athena(AthenaTrackService athenaTrackService) {
        }

        @Override // com.transsion.athena.athena
        public void a(String str, TrackData trackData, long j) throws RemoteException {
            aethna.a("AthenaTrackService receive appId : %d, eventName : %s", Long.valueOf(j), str);
            AthenaAnalytics.L(j).h0(str, trackData, j);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        aethna.a("AthenaTrackService onBind");
        return this.a;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        aethna.a("AthenaTrackService onUnbind");
        return super.onUnbind(intent);
    }
}
