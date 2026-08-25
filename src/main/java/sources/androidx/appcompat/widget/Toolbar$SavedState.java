package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class Toolbar$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<Toolbar$SavedState> CREATOR = new a();
    int expandedMenuItemId;
    boolean isOverflowOpen;

    class a implements Parcelable.ClassLoaderCreator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Toolbar$SavedState createFromParcel(Parcel parcel) {
            return new Toolbar$SavedState(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Toolbar$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new Toolbar$SavedState(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Toolbar$SavedState[] newArray(int i5) {
            return new Toolbar$SavedState[i5];
        }
    }

    public Toolbar$SavedState(Parcel parcel) {
        this(parcel, null);
    }

    public Toolbar$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.expandedMenuItemId = parcel.readInt();
        this.isOverflowOpen = parcel.readInt() != 0;
    }

    public Toolbar$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.expandedMenuItemId);
        parcel.writeInt(this.isOverflowOpen ? 1 : 0);
    }
}
