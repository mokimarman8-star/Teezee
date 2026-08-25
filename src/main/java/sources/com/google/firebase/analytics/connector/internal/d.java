package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.HashSet;
import java.util.Set;
import mb.a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d {
    Set a;
    private a.b b;
    private AppMeasurementSdk c;
    private c d;

    public d(AppMeasurementSdk appMeasurementSdk, a.b bVar) {
        this.b = bVar;
        this.c = appMeasurementSdk;
        c cVar = new c(this);
        this.d = cVar;
        this.c.registerOnMeasurementEventListener(cVar);
        this.a = new HashSet();
    }
}
