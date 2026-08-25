package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class Counter$a implements Parcelable.Creator {
    Counter$a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Counter createFromParcel(Parcel parcel) {
        return new Counter(parcel, (Counter$a) null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Counter[] newArray(int i) {
        return new Counter[i];
    }
}
