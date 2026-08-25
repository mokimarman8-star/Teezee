package androidx.coroutines;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface i extends IInterface {

    /* renamed from: d, reason: collision with root package name */
    public static final String f13211d = "androidx$room$IMultiInstanceInvalidationCallback".replace('$', '.');

    public static abstract class a extends Binder implements i {

        /* renamed from: androidx.room.i$a$a, reason: collision with other inner class name */
        private static class C0099a implements i {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f13212a;

            C0099a(IBinder iBinder) {
                this.f13212a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13212a;
            }

            @Override // androidx.coroutines.i
            public void o(String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(i.f13211d);
                    obtain.writeStringArray(strArr);
                    this.f13212a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, i.f13211d);
        }

        public static i X0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(i.f13211d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof i)) ? new C0099a(iBinder) : (i) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            String str = i.f13211d;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i5 != 1) {
                return super.onTransact(i5, parcel, parcel2, i6);
            }
            o(parcel.createStringArray());
            return true;
        }
    }

    void o(String[] strArr);
}
