package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class Trace$b implements Parcelable.Creator {
    Trace$b() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Trace createFromParcel(Parcel parcel) {
        return new Trace(parcel, true, (Trace$a) null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Trace[] newArray(int i) {
        return new Trace[i];
    }
}
