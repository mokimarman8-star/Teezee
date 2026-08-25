package kh;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface a extends IInterface {

    /* renamed from: kh.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0053a extends Binder implements a {

        /* renamed from: kh.a$a$a, reason: collision with other inner class name */
        private static class C0054a implements a {
            public static a b;
            private IBinder a;

            C0054a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // kh.a
            public String getId() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (!this.a.transact(1, obtain, obtain2, 0) && AbstractBinderC0053a.Y0() != null) {
                        return AbstractBinderC0053a.Y0().getId();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0053a() {
            attachInterface(this, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        }

        public static a X0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0054a(iBinder) : (a) queryLocalInterface;
        }

        public static a Y0() {
            return C0054a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String id = getId();
                parcel2.writeNoException();
                parcel2.writeString(id);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            boolean isLimitAdTrackingEnabled = isLimitAdTrackingEnabled(parcel.readInt() != 0);
            parcel2.writeNoException();
            parcel2.writeInt(isLimitAdTrackingEnabled ? 1 : 0);
            return true;
        }
    }

    String getId();

    boolean isLimitAdTrackingEnabled(boolean z);
}
