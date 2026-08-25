package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ActionMenuPresenter$SavedState implements Parcelable {
    public static final Parcelable.Creator<ActionMenuPresenter$SavedState> CREATOR = new a();
    public int openSubMenuId;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActionMenuPresenter$SavedState createFromParcel(Parcel parcel) {
            return new ActionMenuPresenter$SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActionMenuPresenter$SavedState[] newArray(int i5) {
            return new ActionMenuPresenter$SavedState[i5];
        }
    }

    ActionMenuPresenter$SavedState() {
    }

    ActionMenuPresenter$SavedState(Parcel parcel) {
        this.openSubMenuId = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.openSubMenuId);
    }
}
