package com.transsion.athena;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.transsion.athena.data.TrackData;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface athena extends IInterface {

    /* renamed from: com.transsion.athena.athena$athena, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0009athena extends Binder implements athena {
        public static final /* synthetic */ int a = 0;

        /* renamed from: com.transsion.athena.athena$athena$athena, reason: collision with other inner class name */
        private static class C0010athena implements athena {
            private IBinder a;

            C0010athena(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.transsion.athena.athena
            public void a(String str, TrackData trackData, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.transsion.athena.IAthenaTrackInterface");
                    obtain.writeString(str);
                    if (trackData != null) {
                        obtain.writeInt(1);
                        trackData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    if (!this.a.transact(1, obtain, obtain2, 0)) {
                        int i = AbstractBinderC0009athena.a;
                    }
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public AbstractBinderC0009athena() {
            attachInterface(this, "com.transsion.athena.IAthenaTrackInterface");
        }

        public static athena a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.transsion.athena.IAthenaTrackInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof athena)) ? new C0010athena(iBinder) : (athena) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.transsion.athena.IAthenaTrackInterface");
                return true;
            }
            parcel.enforceInterface("com.transsion.athena.IAthenaTrackInterface");
            a(parcel.readString(), parcel.readInt() != 0 ? (TrackData) TrackData.CREATOR.createFromParcel(parcel) : null, parcel.readLong());
            parcel2.writeNoException();
            return true;
        }
    }

    void a(String str, TrackData trackData, long j) throws RemoteException;
}
