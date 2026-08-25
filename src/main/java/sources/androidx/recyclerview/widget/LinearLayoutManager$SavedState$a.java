package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.LinearLayoutManager;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class LinearLayoutManager$SavedState$a implements Parcelable.Creator {
    LinearLayoutManager$SavedState$a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayoutManager.SavedState createFromParcel(Parcel parcel) {
        return new LinearLayoutManager.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutManager.SavedState[] newArray(int i5) {
        return new LinearLayoutManager.SavedState[i5];
    }
}
