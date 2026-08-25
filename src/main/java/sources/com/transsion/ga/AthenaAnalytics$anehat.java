package com.transsion.ga;

import android.os.Handler;
import com.transsion.athena.config.data.model.anehat;
import com.transsion.athena.data.TrackData;
import com.transsion.gslb.BuildConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class AthenaAnalytics$anehat implements Runnable {
    private final Handler a;
    private SimpleDateFormat b;
    private String c;

    private AthenaAnalytics$anehat(Handler handler) {
        this.c = BuildConfig.FLAVOR;
        this.a = handler;
    }

    /* synthetic */ AthenaAnalytics$anehat(Handler handler, AthenaAnalytics$athena athenaAnalytics$athena) {
        this(handler);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (AthenaAnalytics.t() > 0) {
            if (anehat.c(AthenaAnalytics.g())) {
                if (this.b == null) {
                    this.b = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
                }
                String format = this.b.format(new Date());
                if (!format.equals(this.c)) {
                    Iterator<Integer> it = com.transsion.athena.data.athena.a().iterator();
                    while (it.hasNext()) {
                        Integer next = it.next();
                        if (next.intValue() != 9999) {
                            AthenaAnalytics.K(next.intValue()).g0("app_heartbeat", (TrackData) null, next.intValue());
                        }
                    }
                    this.c = format;
                }
            }
            this.a.postDelayed(this, 3600000L);
        }
    }
}
