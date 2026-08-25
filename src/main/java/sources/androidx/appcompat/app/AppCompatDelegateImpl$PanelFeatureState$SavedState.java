package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class AppCompatDelegateImpl$PanelFeatureState$SavedState implements Parcelable {
    public static final Parcelable.Creator<AppCompatDelegateImpl$PanelFeatureState$SavedState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    int f226a;

    /* renamed from: b, reason: collision with root package name */
    boolean f227b;

    /* renamed from: c, reason: collision with root package name */
    Bundle f228c;

    class a implements Parcelable.ClassLoaderCreator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppCompatDelegateImpl$PanelFeatureState$SavedState createFromParcel(Parcel parcel) {
            return AppCompatDelegateImpl$PanelFeatureState$SavedState.a(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppCompatDelegateImpl$PanelFeatureState$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return AppCompatDelegateImpl$PanelFeatureState$SavedState.a(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AppCompatDelegateImpl$PanelFeatureState$SavedState[] newArray(int i5) {
            return new AppCompatDelegateImpl$PanelFeatureState$SavedState[i5];
        }
    }

    AppCompatDelegateImpl$PanelFeatureState$SavedState() {
    }

    static AppCompatDelegateImpl$PanelFeatureState$SavedState a(Parcel parcel, ClassLoader classLoader) {
        AppCompatDelegateImpl$PanelFeatureState$SavedState appCompatDelegateImpl$PanelFeatureState$SavedState = new AppCompatDelegateImpl$PanelFeatureState$SavedState();
        appCompatDelegateImpl$PanelFeatureState$SavedState.f226a = parcel.readInt();
        boolean z5 = parcel.readInt() == 1;
        appCompatDelegateImpl$PanelFeatureState$SavedState.f227b = z5;
        if (z5) {
            appCompatDelegateImpl$PanelFeatureState$SavedState.f228c = parcel.readBundle(classLoader);
        }
        return appCompatDelegateImpl$PanelFeatureState$SavedState;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f226a);
        parcel.writeInt(this.f227b ? 1 : 0);
        if (this.f227b) {
            parcel.writeBundle(this.f228c);
        }
    }
}
