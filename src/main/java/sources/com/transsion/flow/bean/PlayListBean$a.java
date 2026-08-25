package com.transsion.flow.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PlayListBean$a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final PlayListBean createFromParcel(Parcel parcel) {
        ArrayList arrayList;
        Intrinsics.h(parcel, "parcel");
        if (parcel.readInt() == 0) {
            arrayList = null;
        } else {
            int readInt = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList2.add(PlayListItem.CREATOR.createFromParcel(parcel));
            }
            arrayList = arrayList2;
        }
        return new PlayListBean(arrayList, parcel.readSerializable(), parcel.readString());
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final PlayListBean[] newArray(int i) {
        return new PlayListBean[i];
    }
}
