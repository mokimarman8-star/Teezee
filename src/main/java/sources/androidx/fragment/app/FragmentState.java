package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final String f8140a;

    /* renamed from: b, reason: collision with root package name */
    final String f8141b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f8142c;

    /* renamed from: d, reason: collision with root package name */
    final int f8143d;

    /* renamed from: e, reason: collision with root package name */
    final int f8144e;

    /* renamed from: f, reason: collision with root package name */
    final String f8145f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f8146g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f8147h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f8148i;

    /* renamed from: j, reason: collision with root package name */
    final Bundle f8149j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f8150k;

    /* renamed from: l, reason: collision with root package name */
    final int f8151l;

    /* renamed from: m, reason: collision with root package name */
    Bundle f8152m;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i5) {
            return new FragmentState[i5];
        }
    }

    FragmentState(Parcel parcel) {
        this.f8140a = parcel.readString();
        this.f8141b = parcel.readString();
        this.f8142c = parcel.readInt() != 0;
        this.f8143d = parcel.readInt();
        this.f8144e = parcel.readInt();
        this.f8145f = parcel.readString();
        this.f8146g = parcel.readInt() != 0;
        this.f8147h = parcel.readInt() != 0;
        this.f8148i = parcel.readInt() != 0;
        this.f8149j = parcel.readBundle();
        this.f8150k = parcel.readInt() != 0;
        this.f8152m = parcel.readBundle();
        this.f8151l = parcel.readInt();
    }

    FragmentState(Fragment fragment) {
        this.f8140a = fragment.getClass().getName();
        this.f8141b = fragment.mWho;
        this.f8142c = fragment.mFromLayout;
        this.f8143d = fragment.mFragmentId;
        this.f8144e = fragment.mContainerId;
        this.f8145f = fragment.mTag;
        this.f8146g = fragment.mRetainInstance;
        this.f8147h = fragment.mRemoving;
        this.f8148i = fragment.mDetached;
        this.f8149j = fragment.mArguments;
        this.f8150k = fragment.mHidden;
        this.f8151l = fragment.mMaxState.ordinal();
    }

    Fragment a(h hVar, ClassLoader classLoader) {
        Fragment instantiate = hVar.instantiate(classLoader, this.f8140a);
        Bundle bundle = this.f8149j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        instantiate.setArguments(this.f8149j);
        instantiate.mWho = this.f8141b;
        instantiate.mFromLayout = this.f8142c;
        instantiate.mRestored = true;
        instantiate.mFragmentId = this.f8143d;
        instantiate.mContainerId = this.f8144e;
        instantiate.mTag = this.f8145f;
        instantiate.mRetainInstance = this.f8146g;
        instantiate.mRemoving = this.f8147h;
        instantiate.mDetached = this.f8148i;
        instantiate.mHidden = this.f8150k;
        instantiate.mMaxState = Lifecycle.State.values()[this.f8151l];
        Bundle bundle2 = this.f8152m;
        if (bundle2 != null) {
            instantiate.mSavedFragmentState = bundle2;
        } else {
            instantiate.mSavedFragmentState = new Bundle();
        }
        return instantiate;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f8140a);
        sb.append(" (");
        sb.append(this.f8141b);
        sb.append(")}:");
        if (this.f8142c) {
            sb.append(" fromLayout");
        }
        if (this.f8144e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f8144e));
        }
        String str = this.f8145f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f8145f);
        }
        if (this.f8146g) {
            sb.append(" retainInstance");
        }
        if (this.f8147h) {
            sb.append(" removing");
        }
        if (this.f8148i) {
            sb.append(" detached");
        }
        if (this.f8150k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f8140a);
        parcel.writeString(this.f8141b);
        parcel.writeInt(this.f8142c ? 1 : 0);
        parcel.writeInt(this.f8143d);
        parcel.writeInt(this.f8144e);
        parcel.writeString(this.f8145f);
        parcel.writeInt(this.f8146g ? 1 : 0);
        parcel.writeInt(this.f8147h ? 1 : 0);
        parcel.writeInt(this.f8148i ? 1 : 0);
        parcel.writeBundle(this.f8149j);
        parcel.writeInt(this.f8150k ? 1 : 0);
        parcel.writeBundle(this.f8152m);
        parcel.writeInt(this.f8151l);
    }
}
