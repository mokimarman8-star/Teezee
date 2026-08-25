package com.transsion.mb.config.manager;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ConfigBean$a implements Parcelable.Creator {
    private ConfigBean$a() {
    }

    public /* synthetic */ ConfigBean$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConfigBean createFromParcel(Parcel parcel) {
        Intrinsics.h(parcel, "parcel");
        return new ConfigBean(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConfigBean[] newArray(int i) {
        return new ConfigBean[i];
    }
}
