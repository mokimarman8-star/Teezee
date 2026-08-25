package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class Counter implements Parcelable {
    public static final Parcelable.Creator<Counter> CREATOR = new a();
    private final AtomicLong count;
    private final String name;

    private Counter(Parcel parcel) {
        this.name = parcel.readString();
        this.count = new AtomicLong(parcel.readLong());
    }

    public Counter(@NonNull String str) {
        this.name = str;
        this.count = new AtomicLong(0L);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    long getCount() {
        return this.count.get();
    }

    @NonNull
    String getName() {
        return this.name;
    }

    public void increment(long j) {
        this.count.addAndGet(j);
    }

    void setCount(long j) {
        this.count.set(j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeLong(this.count.get());
    }
}
