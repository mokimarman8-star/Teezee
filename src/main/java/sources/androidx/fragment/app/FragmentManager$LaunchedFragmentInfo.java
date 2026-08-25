package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class FragmentManager$LaunchedFragmentInfo implements Parcelable {
    public static final Parcelable.Creator<FragmentManager$LaunchedFragmentInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    String f8110a;

    /* renamed from: b, reason: collision with root package name */
    int f8111b;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManager$LaunchedFragmentInfo createFromParcel(Parcel parcel) {
            return new FragmentManager$LaunchedFragmentInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentManager$LaunchedFragmentInfo[] newArray(int i5) {
            return new FragmentManager$LaunchedFragmentInfo[i5];
        }
    }

    FragmentManager$LaunchedFragmentInfo(Parcel parcel) {
        this.f8110a = parcel.readString();
        this.f8111b = parcel.readInt();
    }

    FragmentManager$LaunchedFragmentInfo(String str, int i5) {
        this.f8110a = str;
        this.f8111b = i5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f8110a);
        parcel.writeInt(this.f8111b);
    }
}
