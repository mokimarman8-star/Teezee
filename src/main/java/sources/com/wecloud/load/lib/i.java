package com.wecloud.load.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.wecloud.load.lib.h;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface i extends IInterface {

    public static abstract class a extends Binder implements i {

        /* renamed from: com.wecloud.load.lib.i$a$a, reason: collision with other inner class name */
        private static class C0052a implements i {
            private IBinder a;

            C0052a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.wecloud.load.lib.i
            public void D(SoDownloadRequest soDownloadRequest, h hVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wecloud.load.lib.ISoLoadService");
                    b.d(obtain, soDownloadRequest, 0);
                    obtain.writeStrongInterface(hVar);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public a() {
            attachInterface(this, "com.wecloud.load.lib.ISoLoadService");
        }

        public static i X0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.wecloud.load.lib.ISoLoadService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof i)) ? new C0052a(iBinder) : (i) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("com.wecloud.load.lib.ISoLoadService");
            }
            if (i == 1598968902) {
                parcel2.writeString("com.wecloud.load.lib.ISoLoadService");
                return true;
            }
            if (i == 1) {
                D((SoDownloadRequest) b.c(parcel, SoDownloadRequest.CREATOR), h.a.Y0(parcel.readStrongBinder()));
                parcel2.writeNoException();
            } else if (i == 2) {
                boolean J0 = J0(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(J0 ? 1 : 0);
            } else {
                if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                int C = C(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(C);
            }
            return true;
        }
    }

    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object c(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void d(Parcel parcel, Parcelable parcelable, int i) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i);
            }
        }
    }

    int C(String str);

    void D(SoDownloadRequest soDownloadRequest, h hVar);

    boolean J0(String str);
}
