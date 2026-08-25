package com.transsion.athena.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class TrackData$athena implements Parcelable.Creator<TrackData> {
    TrackData$athena() {
    }

    @Override // android.os.Parcelable.Creator
    public TrackData createFromParcel(Parcel parcel) {
        return new TrackData(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public TrackData[] newArray(int i) {
        return new TrackData[i];
    }
}
