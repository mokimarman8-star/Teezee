package com.transsion.flow.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PlayListIcon$a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final PlayListIcon createFromParcel(Parcel parcel) {
        Boolean valueOf;
        Intrinsics.h(parcel, "parcel");
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        if (parcel.readInt() == 0) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(parcel.readInt() != 0);
        }
        return new PlayListIcon(readString, readString2, valueOf, parcel.readString());
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final PlayListIcon[] newArray(int i) {
        return new PlayListIcon[i];
    }
}
