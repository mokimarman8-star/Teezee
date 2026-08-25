package com.mbridge.msdk.foundation.same.report;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class BatchReportMessage implements Parcelable {
    public static final Parcelable.Creator<BatchReportMessage> CREATOR = new a();
    private String a;
    private long b;
    private String c;

    class a implements Parcelable.Creator<BatchReportMessage> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BatchReportMessage createFromParcel(Parcel parcel) {
            return new BatchReportMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BatchReportMessage[] newArray(int i) {
            return new BatchReportMessage[i];
        }
    }

    protected BatchReportMessage(Parcel parcel) {
        this.c = parcel.readString();
        this.a = parcel.readString();
        this.b = parcel.readLong();
    }

    public BatchReportMessage(String str, String str2, long j) {
        this.c = str;
        this.a = str2;
        this.b = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getReportMessage() {
        return this.a;
    }

    public long getTimestamp() {
        return this.b;
    }

    public String getUuid() {
        return this.c;
    }

    public void setReportMessage(String str) {
        this.a = str;
    }

    public void setTimestamp(long j) {
        this.b = j;
    }

    public void setUuid(String str) {
        this.c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.a);
        parcel.writeLong(this.b);
    }
}
