package com.transsion.ga;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import com.transsion.athena.config.data.model.anehat;
import com.transsion.athena.taaneh.aatnhe;
import com.transsion.baselib.db.download.DownloadException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class h extends BroadcastReceiver {
    private boolean a = true;

    h() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            if (this.a) {
                this.a = false;
                return;
            }
            try {
                if (aatnhe.c(context) && anehat.c(context)) {
                    AthenaAnalytics.f0();
                    AthenaAnalytics.E();
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if ("android.location.PROVIDERS_CHANGED".equals(action)) {
            if (com.transsion.athena.taaneh.anehat.a(context, "android.permission.ACCESS_FINE_LOCATION") || com.transsion.athena.taaneh.anehat.a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                try {
                    LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
                    if (!locationManager.isProviderEnabled("gps") && !locationManager.isProviderEnabled("network")) {
                        return;
                    }
                    AthenaAnalytics.K(9999).k(DownloadException.EXCEPTION_IO_UNKNOWN_SERVICE, 3000L);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
