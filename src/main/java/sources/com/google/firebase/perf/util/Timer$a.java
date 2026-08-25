package com.google.firebase.perf.util;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class Timer$a implements Parcelable.Creator {
    Timer$a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Timer createFromParcel(Parcel parcel) {
        return new Timer(parcel, (Timer$a) null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Timer[] newArray(int i) {
        return new Timer[i];
    }
}
