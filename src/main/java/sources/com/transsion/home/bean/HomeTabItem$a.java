package com.transsion.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HomeTabItem$a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final HomeTabItem createFromParcel(Parcel parcel) {
        Boolean valueOf;
        Intrinsics.h(parcel, "parcel");
        String readString = parcel.readString();
        Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        NameImage createFromParcel = parcel.readInt() == 0 ? null : NameImage.CREATOR.createFromParcel(parcel);
        NameImage createFromParcel2 = parcel.readInt() == 0 ? null : NameImage.CREATOR.createFromParcel(parcel);
        String readString5 = parcel.readString();
        if (parcel.readInt() == 0) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(parcel.readInt() != 0);
        }
        return new HomeTabItem(readString, valueOf2, readString2, readString3, readString4, createFromParcel, createFromParcel2, readString5, valueOf);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final HomeTabItem[] newArray(int i) {
        return new HomeTabItem[i];
    }
}
