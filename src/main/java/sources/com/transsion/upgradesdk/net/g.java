package com.transsion.upgradesdk.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g extends BroadcastReceiver {
    public final /* synthetic */ ru.f a;

    public g(ru.f fVar) {
        this.a = fVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action;
        if (intent != null) {
            try {
                action = intent.getAction();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            action = null;
        }
        if (Intrinsics.c(action, "android.net.conn.CONNECTIVITY_CHANGE")) {
            ru.f.b(this.a);
            throw null;
        }
    }
}
