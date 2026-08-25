package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import mb.a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class f {
    private a.b a;
    private AppMeasurementSdk b;
    private e c;

    public f(AppMeasurementSdk appMeasurementSdk, a.b bVar) {
        this.a = bVar;
        this.b = appMeasurementSdk;
        e eVar = new e(this);
        this.c = eVar;
        this.b.registerOnMeasurementEventListener(eVar);
    }
}
