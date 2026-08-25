package com.transsion.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AhaGameAllGames$a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final AhaGameAllGames createFromParcel(Parcel parcel) {
        Intrinsics.h(parcel, "parcel");
        ArrayList arrayList = null;
        Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        String readString7 = parcel.readString();
        String readString8 = parcel.readString();
        String readString9 = parcel.readString();
        GameLayoutType valueOf2 = GameLayoutType.valueOf(parcel.readString());
        if (parcel.readInt() != 0) {
            int readInt = parcel.readInt();
            arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(AhaGameAllGames.CREATOR.createFromParcel(parcel));
            }
        }
        return new AhaGameAllGames(valueOf, readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, readString9, valueOf2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final AhaGameAllGames[] newArray(int i) {
        return new AhaGameAllGames[i];
    }
}
