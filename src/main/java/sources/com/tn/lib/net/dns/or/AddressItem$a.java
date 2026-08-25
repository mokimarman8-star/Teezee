package com.tn.lib.net.dns.or;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class AddressItem$a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final AddressItem createFromParcel(Parcel parcel) {
        Intrinsics.h(parcel, "parcel");
        return new AddressItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final AddressItem[] newArray(int i) {
        return new AddressItem[i];
    }
}
