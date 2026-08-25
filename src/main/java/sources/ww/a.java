package ww;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface a extends IInterface {

    /* renamed from: ww.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0116a extends Binder implements a {

        /* renamed from: ww.a$a$a, reason: collision with other inner class name */
        private static class C0117a implements a {
            private IBinder a;

            C0117a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public AbstractBinderC0116a() {
            attachInterface(this, "com.transsnet.dispenselib.IDispenseCommonCallBack");
        }

        public static a X0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.transsnet.dispenselib.IDispenseCommonCallBack");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0117a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("com.transsnet.dispenselib.IDispenseCommonCallBack");
            }
            if (i == 1598968902) {
                parcel2.writeString("com.transsnet.dispenselib.IDispenseCommonCallBack");
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            M0(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void M0(String str, String str2);
}
