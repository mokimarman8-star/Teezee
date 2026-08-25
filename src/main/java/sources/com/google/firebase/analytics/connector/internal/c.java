package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import mb.a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class c implements AppMeasurementSdk.OnEventListener {
    private final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        a.b bVar;
        if (this.a.a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", a.b(str2));
            bVar = this.a.b;
            bVar.a(2, bundle2);
        }
    }
}
