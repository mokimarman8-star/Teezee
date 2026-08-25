package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: Access modifiers changed from: protected */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class DrawerLayout$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<DrawerLayout$SavedState> CREATOR = new a();
    int lockModeEnd;
    int lockModeLeft;
    int lockModeRight;
    int lockModeStart;
    int openDrawerGravity;

    class a implements Parcelable.ClassLoaderCreator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrawerLayout$SavedState createFromParcel(Parcel parcel) {
            return new DrawerLayout$SavedState(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DrawerLayout$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new DrawerLayout$SavedState(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public DrawerLayout$SavedState[] newArray(int i5) {
            return new DrawerLayout$SavedState[i5];
        }
    }

    public DrawerLayout$SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
        super(parcel, classLoader);
        this.openDrawerGravity = 0;
        this.openDrawerGravity = parcel.readInt();
        this.lockModeLeft = parcel.readInt();
        this.lockModeRight = parcel.readInt();
        this.lockModeStart = parcel.readInt();
        this.lockModeEnd = parcel.readInt();
    }

    public DrawerLayout$SavedState(@NonNull Parcelable parcelable) {
        super(parcelable);
        this.openDrawerGravity = 0;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.openDrawerGravity);
        parcel.writeInt(this.lockModeLeft);
        parcel.writeInt(this.lockModeRight);
        parcel.writeInt(this.lockModeStart);
        parcel.writeInt(this.lockModeEnd);
    }
}
