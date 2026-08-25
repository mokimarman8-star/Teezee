package com.google.firebase.sessions;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d {
    private final DataCollectionState a;
    private final DataCollectionState b;
    private final double c;

    public d() {
        this(null, null, 0.0d, 7, null);
    }

    public d(DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d) {
        Intrinsics.h(dataCollectionState, "performance");
        Intrinsics.h(dataCollectionState2, "crashlytics");
        this.a = dataCollectionState;
        this.b = dataCollectionState2;
        this.c = d;
    }

    public /* synthetic */ d(DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState, (i & 2) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState2, (i & 4) != 0 ? 1.0d : d);
    }

    public final DataCollectionState a() {
        return this.b;
    }

    public final DataCollectionState b() {
        return this.a;
    }

    public final double c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && this.b == dVar.b && Double.compare(this.c, dVar.c) == 0;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + androidx.compose.animation.core.r.a(this.c);
    }

    public String toString() {
        return "DataCollectionStatus(performance=" + this.a + ", crashlytics=" + this.b + ", sessionSamplingRate=" + this.c + ')';
    }
}
