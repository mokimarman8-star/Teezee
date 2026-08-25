package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class ParcelableMMKV implements Parcelable {
    public static final Parcelable.Creator<ParcelableMMKV> CREATOR = new a();
    private int ashmemFD;
    private int ashmemMetaFD;
    private String cryptKey;
    private final String mmapID;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableMMKV createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            Parcelable.Creator creator = ParcelFileDescriptor.CREATOR;
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) creator.createFromParcel(parcel);
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) creator.createFromParcel(parcel);
            String readString2 = parcel.readString();
            if (parcelFileDescriptor == null || parcelFileDescriptor2 == null) {
                return null;
            }
            return new ParcelableMMKV(readString, parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), readString2, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableMMKV[] newArray(int i) {
            return new ParcelableMMKV[i];
        }
    }

    public ParcelableMMKV(@NonNull MMKV mmkv) {
        this.ashmemFD = -1;
        this.ashmemMetaFD = -1;
        this.cryptKey = null;
        this.mmapID = mmkv.mmapID();
        this.ashmemFD = mmkv.ashmemFD();
        this.ashmemMetaFD = mmkv.ashmemMetaFD();
        this.cryptKey = mmkv.cryptKey();
    }

    private ParcelableMMKV(String str, int i, int i2, String str2) {
        this.mmapID = str;
        this.ashmemFD = i;
        this.ashmemMetaFD = i2;
        this.cryptKey = str2;
    }

    /* synthetic */ ParcelableMMKV(String str, int i, int i2, String str2, a aVar) {
        this(str, i, i2, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @Nullable
    public MMKV toMMKV() {
        int i;
        int i2 = this.ashmemFD;
        if (i2 < 0 || (i = this.ashmemMetaFD) < 0) {
            return null;
        }
        return MMKV.G(this.mmapID, i2, i, this.cryptKey);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        try {
            parcel.writeString(this.mmapID);
            ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.ashmemFD);
            ParcelFileDescriptor fromFd2 = ParcelFileDescriptor.fromFd(this.ashmemMetaFD);
            int i2 = i | 1;
            fromFd.writeToParcel(parcel, i2);
            fromFd2.writeToParcel(parcel, i2);
            String str = this.cryptKey;
            if (str != null) {
                parcel.writeString(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
