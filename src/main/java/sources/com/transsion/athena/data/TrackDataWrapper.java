package com.transsion.athena.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.transsion.gslb.BuildConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class TrackDataWrapper implements Parcelable {
    public static final Parcelable.Creator<TrackDataWrapper> CREATOR = new athena();
    private String a;
    private TrackData b;
    private long c;

    class athena implements Parcelable.Creator<TrackDataWrapper> {
        athena() {
        }

        @Override // android.os.Parcelable.Creator
        public TrackDataWrapper createFromParcel(Parcel parcel) {
            return new TrackDataWrapper(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TrackDataWrapper[] newArray(int i) {
            return new TrackDataWrapper[i];
        }
    }

    protected TrackDataWrapper(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readParcelable(TrackData.class.getClassLoader());
        this.c = parcel.readLong();
    }

    public TrackDataWrapper(String str, TrackData trackData, long j) {
        this.a = str;
        this.b = trackData;
        this.c = j;
    }

    public String a() {
        String str = this.a;
        return str == null ? BuildConfig.FLAVOR : str;
    }

    public long b() {
        return this.c;
    }

    public TrackData c() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeLong(this.c);
    }
}
