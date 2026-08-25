package com.transsion.memberapi;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberCheckResult$a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final MemberCheckResult createFromParcel(Parcel parcel) {
        ArrayList arrayList;
        Intrinsics.h(parcel, "parcel");
        Boolean valueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        if (parcel.readInt() == 0) {
            arrayList = null;
        } else {
            int readInt = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList2.add(MemberRights.CREATOR.createFromParcel(parcel));
            }
            arrayList = arrayList2;
        }
        return new MemberCheckResult(valueOf, readString, readString2, readString3, arrayList, parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readInt() != 0 ? ThreeInOnePopup.CREATOR.createFromParcel(parcel) : null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final MemberCheckResult[] newArray(int i) {
        return new MemberCheckResult[i];
    }
}
