package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class RecyclerView$SavedState$a implements Parcelable.ClassLoaderCreator {
    RecyclerView$SavedState$a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RecyclerView.SavedState createFromParcel(Parcel parcel) {
        return new RecyclerView.SavedState(parcel, (ClassLoader) null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RecyclerView.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new RecyclerView.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public RecyclerView.SavedState[] newArray(int i5) {
        return new RecyclerView.SavedState[i5];
    }
}
