package com.transsion.startup.pref.consume;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class AppStartDotState$b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final AppStartDotState createFromParcel(Parcel parcel) {
        Intrinsics.h(parcel, "parcel");
        return new AppStartDotState(parcel.readString(), parcel.readLong());
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final AppStartDotState[] newArray(int i) {
        return new AppStartDotState[i];
    }
}
