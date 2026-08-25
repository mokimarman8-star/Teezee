package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {
    private Sj Sj;

    public interface Sj {
        void Sj();

        void sP();
    }

    public void Sj(Sj sj) {
        this.Sj = sj;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            "onReceive: action: ".concat(String.valueOf(action));
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra("reason");
                "reason: ".concat(String.valueOf(stringExtra));
                if ("homekey".equals(stringExtra)) {
                    Sj sj = this.Sj;
                    if (sj != null) {
                        sj.Sj();
                        return;
                    }
                    return;
                }
                if (!"recentapps".equals(stringExtra)) {
                    "assist".equals(stringExtra);
                    return;
                }
                Sj sj2 = this.Sj;
                if (sj2 != null) {
                    sj2.sP();
                }
            }
        } catch (Throwable unused) {
        }
    }
}
