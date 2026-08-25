package androidx.swiperefreshlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class SwipeRefreshLayout$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SwipeRefreshLayout$SavedState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final boolean f13409a;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SwipeRefreshLayout$SavedState createFromParcel(Parcel parcel) {
            return new SwipeRefreshLayout$SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SwipeRefreshLayout$SavedState[] newArray(int i5) {
            return new SwipeRefreshLayout$SavedState[i5];
        }
    }

    SwipeRefreshLayout$SavedState(Parcel parcel) {
        super(parcel);
        this.f13409a = parcel.readByte() != 0;
    }

    SwipeRefreshLayout$SavedState(Parcelable parcelable, boolean z5) {
        super(parcelable);
        this.f13409a = z5;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeByte(this.f13409a ? (byte) 1 : (byte) 0);
    }
}
