package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ActivityResult$a implements Parcelable.Creator {
    ActivityResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ActivityResult createFromParcel(Parcel parcel) {
        Intrinsics.h(parcel, "parcel");
        return new ActivityResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ActivityResult[] newArray(int i5) {
        return new ActivityResult[i5];
    }
}
