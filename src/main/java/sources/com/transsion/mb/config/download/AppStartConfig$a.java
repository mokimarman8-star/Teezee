package com.transsion.mb.config.download;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppStartConfig$a implements Parcelable.Creator {
    private AppStartConfig$a() {
    }

    public /* synthetic */ AppStartConfig$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppStartConfig createFromParcel(Parcel parcel) {
        Intrinsics.h(parcel, "parcel");
        return new AppStartConfig(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppStartConfig[] newArray(int i) {
        return new AppStartConfig[i];
    }
}
