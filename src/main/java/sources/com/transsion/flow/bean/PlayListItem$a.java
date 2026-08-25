package com.transsion.flow.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PlayListItem$a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final PlayListItem createFromParcel(Parcel parcel) {
        ArrayList arrayList;
        Intrinsics.h(parcel, "parcel");
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        PlayListIcon playListIcon = (PlayListIcon) (parcel.readInt() == 0 ? null : PlayListIcon.CREATOR.createFromParcel(parcel));
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        String readString7 = parcel.readString();
        if (parcel.readInt() == 0) {
            arrayList = null;
        } else {
            int readInt = parcel.readInt();
            arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(parcel.readSerializable());
            }
        }
        return new PlayListItem(readString, readString2, readString3, readString4, playListIcon, readString5, readString6, readString7, arrayList, parcel.readString(), parcel.readInt() != 0 ? Boolean.valueOf(parcel.readInt() != 0) : null, parcel.readInt() != 0);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final PlayListItem[] newArray(int i) {
        return new PlayListItem[i];
    }
}
