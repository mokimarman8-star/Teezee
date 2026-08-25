package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class Fragment$SavedState$a implements Parcelable.ClassLoaderCreator {
    Fragment$SavedState$a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Fragment.SavedState createFromParcel(Parcel parcel) {
        return new Fragment.SavedState(parcel, (ClassLoader) null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Fragment.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Fragment.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Fragment.SavedState[] newArray(int i5) {
        return new Fragment.SavedState[i5];
    }
}
