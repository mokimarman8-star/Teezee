package ww;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ww.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* renamed from: ww.b$a$a, reason: collision with other inner class name */
        private static class C0118a implements b {
            private IBinder a;

            C0118a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // ww.b
            public void j(ww.a aVar, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.transsnet.dispenselib.IDispenseCommonService");
                    obtain.writeStrongInterface(aVar);
                    obtain.writeString(str);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.transsnet.dispenselib.IDispenseCommonService");
        }

        public static b X0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.transsnet.dispenselib.IDispenseCommonService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0118a(iBinder) : (b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("com.transsnet.dispenselib.IDispenseCommonService");
            }
            if (i == 1598968902) {
                parcel2.writeString("com.transsnet.dispenselib.IDispenseCommonService");
                return true;
            }
            if (i == 1) {
                j(a.AbstractBinderC0116a.X0(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
            } else if (i == 2) {
                b0(a.AbstractBinderC0116a.X0(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
            } else if (i == 3) {
                G0(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
            } else {
                if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                String i3 = i(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(i3);
            }
            return true;
        }
    }

    void G0(String str, String str2, String str3);

    void b0(ww.a aVar, String str);

    String i(String str, String str2, String str3);

    void j(ww.a aVar, String str);
}
