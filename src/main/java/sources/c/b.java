package c;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import c.a;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface b extends IInterface {

    /* renamed from: g, reason: collision with root package name */
    public static final String f14186g = "android$support$customtabs$ICustomTabsService".replace('$', '.');

    public static abstract class a extends Binder implements b {

        /* renamed from: c.b$a$a, reason: collision with other inner class name */
        private static class C0121a implements b {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f14187a;

            C0121a(IBinder iBinder) {
                this.f14187a = iBinder;
            }

            @Override // c.b
            public boolean B(c.a aVar, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f14186g);
                    obtain.writeStrongInterface(aVar);
                    C0122b.f(obtain, bundle, 0);
                    this.f14187a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.b
            public boolean P0(c.a aVar, IBinder iBinder, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f14186g);
                    obtain.writeStrongInterface(aVar);
                    obtain.writeStrongBinder(iBinder);
                    C0122b.f(obtain, bundle, 0);
                    this.f14187a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.b
            public boolean U(c.a aVar, Uri uri, Bundle bundle, List list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f14186g);
                    obtain.writeStrongInterface(aVar);
                    C0122b.f(obtain, uri, 0);
                    C0122b.f(obtain, bundle, 0);
                    C0122b.e(obtain, list, 0);
                    this.f14187a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.b
            public int W(c.a aVar, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f14186g);
                    obtain.writeStrongInterface(aVar);
                    obtain.writeString(str);
                    C0122b.f(obtain, bundle, 0);
                    this.f14187a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14187a;
            }

            @Override // c.b
            public boolean d(c.a aVar, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f14186g);
                    obtain.writeStrongInterface(aVar);
                    C0122b.f(obtain, bundle, 0);
                    this.f14187a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.b
            public boolean r(c.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f14186g);
                    obtain.writeStrongInterface(aVar);
                    this.f14187a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.b
            public boolean w0(long j5) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f14186g);
                    obtain.writeLong(j5);
                    this.f14187a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, b.f14186g);
        }

        public static b X0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(b.f14186g);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0121a(iBinder) : (b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            String str = b.f14186g;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i5) {
                case 2:
                    boolean w02 = w0(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(w02 ? 1 : 0);
                    return true;
                case 3:
                    boolean r5 = r(a.AbstractBinderC0119a.X0(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(r5 ? 1 : 0);
                    return true;
                case 4:
                    c.a X0 = a.AbstractBinderC0119a.X0(parcel.readStrongBinder());
                    Uri uri = (Uri) C0122b.d(parcel, Uri.CREATOR);
                    Parcelable.Creator creator = Bundle.CREATOR;
                    boolean U = U(X0, uri, (Bundle) C0122b.d(parcel, creator), parcel.createTypedArrayList(creator));
                    parcel2.writeNoException();
                    parcel2.writeInt(U ? 1 : 0);
                    return true;
                case 5:
                    Bundle u5 = u(parcel.readString(), (Bundle) C0122b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0122b.f(parcel2, u5, 1);
                    return true;
                case 6:
                    boolean g5 = g(a.AbstractBinderC0119a.X0(parcel.readStrongBinder()), (Bundle) C0122b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(g5 ? 1 : 0);
                    return true;
                case 7:
                    boolean x02 = x0(a.AbstractBinderC0119a.X0(parcel.readStrongBinder()), (Uri) C0122b.d(parcel, Uri.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(x02 ? 1 : 0);
                    return true;
                case 8:
                    int W = W(a.AbstractBinderC0119a.X0(parcel.readStrongBinder()), parcel.readString(), (Bundle) C0122b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(W);
                    return true;
                case 9:
                    boolean l02 = l0(a.AbstractBinderC0119a.X0(parcel.readStrongBinder()), parcel.readInt(), (Uri) C0122b.d(parcel, Uri.CREATOR), (Bundle) C0122b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(l02 ? 1 : 0);
                    return true;
                case 10:
                    boolean d5 = d(a.AbstractBinderC0119a.X0(parcel.readStrongBinder()), (Bundle) C0122b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(d5 ? 1 : 0);
                    return true;
                case 11:
                    boolean U0 = U0(a.AbstractBinderC0119a.X0(parcel.readStrongBinder()), (Uri) C0122b.d(parcel, Uri.CREATOR), (Bundle) C0122b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(U0 ? 1 : 0);
                    return true;
                case 12:
                    boolean T = T(a.AbstractBinderC0119a.X0(parcel.readStrongBinder()), (Uri) C0122b.d(parcel, Uri.CREATOR), parcel.readInt(), (Bundle) C0122b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(T ? 1 : 0);
                    return true;
                case 13:
                    boolean B = B(a.AbstractBinderC0119a.X0(parcel.readStrongBinder()), (Bundle) C0122b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(B ? 1 : 0);
                    return true;
                case 14:
                    boolean P0 = P0(a.AbstractBinderC0119a.X0(parcel.readStrongBinder()), parcel.readStrongBinder(), (Bundle) C0122b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(P0 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i5, parcel, parcel2, i6);
            }
        }
    }

    /* renamed from: c.b$b, reason: collision with other inner class name */
    public static class C0122b {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object d(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void e(Parcel parcel, List list, int i5) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                f(parcel, (Parcelable) list.get(i6), i5);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void f(Parcel parcel, Parcelable parcelable, int i5) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i5);
            }
        }
    }

    boolean B(c.a aVar, Bundle bundle);

    boolean P0(c.a aVar, IBinder iBinder, Bundle bundle);

    boolean T(c.a aVar, Uri uri, int i5, Bundle bundle);

    boolean U(c.a aVar, Uri uri, Bundle bundle, List list);

    boolean U0(c.a aVar, Uri uri, Bundle bundle);

    int W(c.a aVar, String str, Bundle bundle);

    boolean d(c.a aVar, Bundle bundle);

    boolean g(c.a aVar, Bundle bundle);

    boolean l0(c.a aVar, int i5, Uri uri, Bundle bundle);

    boolean r(c.a aVar);

    Bundle u(String str, Bundle bundle);

    boolean w0(long j5);

    boolean x0(c.a aVar, Uri uri);
}
