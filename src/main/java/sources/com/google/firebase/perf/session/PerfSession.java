package com.google.firebase.perf.session;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.a;
import com.google.firebase.perf.v1.SessionVerbosity;
import com.google.firebase.perf.v1.h;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class PerfSession implements Parcelable {
    public static final Parcelable.Creator<PerfSession> CREATOR = new a();
    private final Timer creationTime;
    private boolean isGaugeAndEventCollectionEnabled;
    private final String sessionId;

    private PerfSession(@NonNull Parcel parcel) {
        this.isGaugeAndEventCollectionEnabled = false;
        this.sessionId = parcel.readString();
        this.isGaugeAndEventCollectionEnabled = parcel.readByte() != 0;
        this.creationTime = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
    }

    public PerfSession(String str, a aVar) {
        this.isGaugeAndEventCollectionEnabled = false;
        this.sessionId = str;
        this.creationTime = aVar.a();
    }

    @Nullable
    public static h[] buildAndSort(@NonNull List<PerfSession> list) {
        if (list.isEmpty()) {
            return null;
        }
        h[] hVarArr = new h[list.size()];
        h build = list.get(0).build();
        boolean z = false;
        for (int i = 1; i < list.size(); i++) {
            h build2 = list.get(i).build();
            if (z || !list.get(i).isVerbose()) {
                hVarArr[i] = build2;
            } else {
                hVarArr[0] = build2;
                hVarArr[i] = build;
                z = true;
            }
        }
        if (!z) {
            hVarArr[0] = build;
        }
        return hVarArr;
    }

    public static PerfSession createWithId(@NonNull String str) {
        PerfSession perfSession = new PerfSession(str.replace("-", ""), new a());
        perfSession.setGaugeAndEventCollectionEnabled(shouldCollectGaugesAndEvents());
        return perfSession;
    }

    static boolean isVerbose(@NonNull h hVar) {
        Iterator it = hVar.n().iterator();
        while (it.hasNext()) {
            if (((SessionVerbosity) it.next()) == SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS) {
                return true;
            }
        }
        return false;
    }

    public static boolean shouldCollectGaugesAndEvents() {
        com.google.firebase.perf.config.a g = com.google.firebase.perf.config.a.g();
        return g.K() && Math.random() < g.D();
    }

    public h build() {
        h.c h = h.o().h(this.sessionId);
        if (this.isGaugeAndEventCollectionEnabled) {
            h.d(SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS);
        }
        return h.build();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Timer getTimer() {
        return this.creationTime;
    }

    public boolean isGaugeAndEventCollectionEnabled() {
        return this.isGaugeAndEventCollectionEnabled;
    }

    public boolean isSessionRunningTooLong() {
        return TimeUnit.MICROSECONDS.toMinutes(this.creationTime.getDurationMicros()) > com.google.firebase.perf.config.a.g().A();
    }

    public boolean isVerbose() {
        return this.isGaugeAndEventCollectionEnabled;
    }

    public String sessionId() {
        return this.sessionId;
    }

    public void setGaugeAndEventCollectionEnabled(boolean z) {
        this.isGaugeAndEventCollectionEnabled = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.sessionId);
        parcel.writeByte(this.isGaugeAndEventCollectionEnabled ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.creationTime, 0);
    }
}
