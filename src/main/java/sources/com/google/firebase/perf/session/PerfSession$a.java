package com.google.firebase.perf.session;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class PerfSession$a implements Parcelable.Creator {
    PerfSession$a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PerfSession createFromParcel(Parcel parcel) {
        return new PerfSession(parcel, (PerfSession$a) null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PerfSession[] newArray(int i) {
        return new PerfSession[i];
    }
}
