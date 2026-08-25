package com.transsion.athena.enatha;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.transsion.athena.data.TrackData;
import com.transsion.ga.AthenaAnalytics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class anehat implements Runnable {
    private final Handler a;

    public anehat(Handler handler) {
        this.a = handler;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String str;
        boolean z;
        Context J = AthenaAnalytics.J();
        m4.a a = m4.a.a(J);
        String i = a.i("athena_id");
        try {
            str = com.transsion.athena.taaneh.athena.a(J).a();
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.a("%s", e.getMessage());
            str = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(i, str)) {
            a.g("athena_id", str);
            if (!TextUtils.isEmpty(i)) {
                if (!com.transsion.athena.taaneh.anehat.a(J, "android.permission.READ_PHONE_STATE") && !com.transsion.athena.taaneh.anehat.a(J, "android.permission.READ_PRIVILEGED_PHONE_STATE")) {
                    z = false;
                    if (z) {
                        if (TextUtils.isEmpty(com.transsion.athena.taaneh.athena.c())) {
                            AthenaAnalytics.K(9999).g0("data_discard", new TrackData().add("en", "device_id_transfer", 2).add("cnt", 1, 1), 9999);
                        } else {
                            AthenaAnalytics.K(9999).g0("device_id_transfer", new TrackData().add("pre_gaid", i).add("sn", com.transsion.athena.taaneh.athena.c()), 9999);
                        }
                    }
                }
                if (AthenaAnalytics.S()) {
                    z = true;
                    if (z) {
                    }
                } else {
                    z = !com.transsion.athena.taaneh.anehat.c(J);
                    if (z) {
                    }
                }
            }
            i = str;
        }
        if (!TextUtils.isEmpty(i)) {
            com.transsion.athena.taaneh.anehat.b(i);
        }
        if (!((TextUtils.isEmpty(i) && TextUtils.isEmpty(com.transsion.athena.taaneh.athena.a(J, 0))) ? false : true)) {
            com.transsion.athena.taaneh.aethna.a("%s", "device gaid and iid are null");
        }
        this.a.postDelayed(this, 7200000L);
    }
}
