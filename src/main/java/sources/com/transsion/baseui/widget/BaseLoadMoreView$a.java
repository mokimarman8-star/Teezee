package com.transsion.baseui.widget;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class BaseLoadMoreView$a implements Parcelable.Creator {
    private BaseLoadMoreView$a() {
    }

    public /* synthetic */ BaseLoadMoreView$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public s6.a createFromParcel(Parcel parcel) {
        Intrinsics.h(parcel, "parcel");
        return new BaseLoadMoreView(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s6.a[] newArray(int i) {
        return new s6.a[i];
    }
}
