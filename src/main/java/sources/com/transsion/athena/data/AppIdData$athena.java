package com.transsion.athena.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class AppIdData$athena implements Parcelable.Creator<AppIdData> {
    AppIdData$athena() {
    }

    @Override // android.os.Parcelable.Creator
    public AppIdData createFromParcel(Parcel parcel) {
        return new AppIdData(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public AppIdData[] newArray(int i) {
        return new AppIdData[i];
    }
}
