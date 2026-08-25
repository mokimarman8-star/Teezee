package androidx.coroutines.impl.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.coroutines.AbstractC0216j;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ForceStopRunnable$BroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static final String f14081a = AbstractC0216j.i("ForceStopRunnable$Rcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
            return;
        }
        AbstractC0216j.e().j(f14081a, "Rescheduling alarm that keeps track of force-stops.");
        ForceStopRunnable.setAlarm(context);
    }
}
