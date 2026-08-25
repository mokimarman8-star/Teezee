package c;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface a extends IInterface {

    /* renamed from: f, reason: collision with root package name */
    public static final String f14184f = "android$support$customtabs$ICustomTabsCallback".replace('$', '.');

    /* renamed from: c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0119a extends Binder implements a {

        /* renamed from: c.a$a$a, reason: collision with other inner class name */
        private static class C0120a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f14185a;

            C0120a(IBinder iBinder) {
                this.f14185a = iBinder;
            }

            @Override // c.a
            public void B0(int i5, int i6, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f14184f);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    b.d(obtain, bundle, 0);
                    this.f14185a.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // c.a
            public void K0(int i5, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f14184f);
                    obtain.writeInt(i5);
                    b.d(obtain, bundle, 0);
                    this.f14185a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // c.a
            public void L(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f14184f);
                    obtain.writeString(str);
                    b.d(obtain, bundle, 0);
                    this.f14185a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // c.a
            public void O0(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f14184f);
                    obtain.writeString(str);
                    b.d(obtain, bundle, 0);
                    this.f14185a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.a
            public void R0(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f14184f);
                    b.d(obtain, bundle, 0);
                    this.f14185a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.a
            public void T0(int i5, Uri uri, boolean z5, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f14184f);
                    obtain.writeInt(i5);
                    b.d(obtain, uri, 0);
                    obtain.writeInt(z5 ? 1 : 0);
                    b.d(obtain, bundle, 0);
                    this.f14185a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14185a;
            }

            @Override // c.a
            public Bundle s(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f14184f);
                    obtain.writeString(str);
                    b.d(obtain, bundle, 0);
                    this.f14185a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) b.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0119a() {
            attachInterface(this, a.f14184f);
        }

        public static a X0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f14184f);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0120a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            String str = a.f14184f;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i5) {
                case 2:
                    K0(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                case 3:
                    L(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                case 4:
                    R0((Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    O0(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    T0(parcel.readInt(), (Uri) b.c(parcel, Uri.CREATOR), parcel.readInt() != 0, (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                case 7:
                    Bundle s5 = s(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    b.d(parcel2, s5, 1);
                    return true;
                case 8:
                    B0(parcel.readInt(), parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                default:
                    return super.onTransact(i5, parcel, parcel2, i6);
            }
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
        public static void d(Parcel parcel, Parcelable parcelable, int i5) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i5);
            }
        }
    }

    void B0(int i5, int i6, Bundle bundle);

    void K0(int i5, Bundle bundle);

    void L(String str, Bundle bundle);

    void O0(String str, Bundle bundle);

    void R0(Bundle bundle);

    void T0(int i5, Uri uri, boolean z5, Bundle bundle);

    Bundle s(String str, Bundle bundle);
}
