package androidx.coroutines;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.coroutines.i;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface j extends IInterface {

    /* renamed from: e, reason: collision with root package name */
    public static final String f13223e = "androidx$room$IMultiInstanceInvalidationService".replace('$', '.');

    public static abstract class a extends Binder implements j {

        /* renamed from: androidx.room.j$a$a, reason: collision with other inner class name */
        private static class C0100a implements j {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f13224a;

            C0100a(IBinder iBinder) {
                this.f13224a = iBinder;
            }

            @Override // androidx.coroutines.j
            public void V0(i iVar, int i5) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(j.f13223e);
                    obtain.writeStrongInterface(iVar);
                    obtain.writeInt(i5);
                    this.f13224a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // androidx.coroutines.j
            public void Z(int i5, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(j.f13223e);
                    obtain.writeInt(i5);
                    obtain.writeStringArray(strArr);
                    this.f13224a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13224a;
            }

            @Override // androidx.coroutines.j
            public int r0(i iVar, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(j.f13223e);
                    obtain.writeStrongInterface(iVar);
                    obtain.writeString(str);
                    this.f13224a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, j.f13223e);
        }

        public static j X0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(j.f13223e);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof j)) ? new C0100a(iBinder) : (j) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            String str = j.f13223e;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i5 == 1) {
                int r02 = r0(i.a.X0(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(r02);
            } else if (i5 == 2) {
                V0(i.a.X0(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i5 != 3) {
                    return super.onTransact(i5, parcel, parcel2, i6);
                }
                Z(parcel.readInt(), parcel.createStringArray());
            }
            return true;
        }
    }

    void V0(i iVar, int i5);

    void Z(int i5, String[] strArr);

    int r0(i iVar, String str);
}
