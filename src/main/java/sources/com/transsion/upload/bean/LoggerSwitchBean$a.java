package com.transsion.upload.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LoggerSwitchBean$a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final LoggerSwitchBean createFromParcel(Parcel parcel) {
        Boolean valueOf;
        Intrinsics.h(parcel, "parcel");
        if (parcel.readInt() == 0) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(parcel.readInt() != 0);
        }
        return new LoggerSwitchBean(valueOf);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final LoggerSwitchBean[] newArray(int i) {
        return new LoggerSwitchBean[i];
    }
}
