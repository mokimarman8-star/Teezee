package com.transsion.baselib.db.mcc;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LocalMcc$a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final LocalMcc createFromParcel(Parcel parcel) {
        Intrinsics.h(parcel, "parcel");
        return new LocalMcc(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final LocalMcc[] newArray(int i) {
        return new LocalMcc[i];
    }
}
