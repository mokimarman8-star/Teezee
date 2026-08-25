package com.transsion.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HotSearchKeyWord$a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final HotSearchKeyWord createFromParcel(Parcel parcel) {
        Intrinsics.h(parcel, "parcel");
        return new HotSearchKeyWord(parcel.readString());
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final HotSearchKeyWord[] newArray(int i) {
        return new HotSearchKeyWord[i];
    }
}
