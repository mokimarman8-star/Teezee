package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import mb.a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class e implements AppMeasurementSdk.OnEventListener {
    private final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        a.b bVar;
        if (str == null || !a.i(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(RewardPlus.NAME, str2);
        bundle2.putLong("timestampInMillis", j);
        bundle2.putBundle("params", bundle);
        bVar = this.a.a;
        bVar.a(3, bundle2);
    }
}
