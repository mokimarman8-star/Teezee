package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class Trace$a implements Parcelable.Creator {
    Trace$a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Trace createFromParcel(Parcel parcel) {
        return new Trace(parcel, false, (Trace$a) null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Trace[] newArray(int i) {
        return new Trace[i];
    }
}
